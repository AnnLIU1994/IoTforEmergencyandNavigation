package it.univpm.gruppoids.iotforemergencyandnavigation.model;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.List;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.DAO;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.IoTDB;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor.IoTCursorFactory;

/**
 * Created by simon on 21/11/2016.
 */

public class Graph extends SimpleWeightedGraph<Node, Edge> {
    // TODO: utilizzare la classe Weight dopo aver fatto la conn con db

    private Context context;

    public Graph(Class<? extends Edge> edgeClass) {
        super(edgeClass);
    }

    // TODO: passare a createGraph il nome del pulsante premuto
    public SimpleWeightedGraph<Node, Edge> createGraph(String quota) { // DefaultEdge per arco non orientato e senza informazioni particolari

        SimpleWeightedGraph<Node, Edge> graph;
        graph = new SimpleWeightedGraph<>(Edge.class);
        Graphs.addAllVertices(graph, getAllNodesOfQuote(quota));
        addAllEdges(graph, quota);

        //graph.vertexSet(); ritorna il set di vertici. stessa cosa per edgeSet()
        //graph.edgeOf(Vertex); ritorna un set di archi uscenti dal vertice passatogli
        //graph.getEdgeWeight(edge); ritorna double, il peso dell'arco
        //graph.getEdgeSource(e);
        //graph.getEdgeTarget(e);
        //graph.containsEdge(node source, node target); ritorna booleano. TODO: da utilizzare per cambio piano
        //graph.containsVertex(nodo); TODO: MEGLIO QUESTO, per cambio piano

        //Graphs.neighborListOf(grafo<v, e>, vertice); per restituire i vertici vicini
        //Graphs.addEdge(grafo<v,e>, e, weight); serve per aggiungere arco e settargli il peso. In una sola istruzione
        //Graphs.addAllVertices(grafo, collection<> di vertici); TODO: da usare per importare vertici dal database
        //Graphs.addAllEdges() TODO: da usare per importare gli archi dal database
        //TODO: il graph lo faccio direttamente sulla classe DBadapter ??

        return graph;

    }

    private List<Node> getAllNodesOfQuote(String quota) {
        List<Node> nodes = new ArrayList<>();

        DAO dao = DAO.get(context.getApplicationContext());
        dao.open();
        IoTCursorFactory.NodesCursor cursor = null;

        switch (quota) {
            case "q145":
                cursor = dao.customNodeQuery("WHERE z = 145", null);
                break;
            case "q150":
                cursor = dao.customNodeQuery("WHERE z = 150", null);
                break;
            case "q155":
                cursor = dao.customNodeQuery("WHERE z = 155", null);
                break;
            default:
                cursor = null;
        }

        if (cursor != null) {
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                nodes.add(cursor.getNode());
                cursor.moveToNext();
            }
        }

        dao.close();

        return nodes;
    }

    private void addAllEdges(SimpleWeightedGraph<Node, Edge> graph, String quota) {

        DAO dao = DAO.get(context.getApplicationContext());
        dao.open();

        IoTCursorFactory.EdgesCursor edgeCursor = dao.customEdgeQuery(null, null);
        edgeCursor.moveToFirst();
        for (int i = 0; i < edgeCursor.getCount(); i++) {
            Edge currentEdge = Edge.fromCursor(edgeCursor);
            Node source = getNodeFromEdgeNodes(dao, quota, currentEdge)[0];
            Node target = getNodeFromEdgeNodes(dao, quota, currentEdge)[1];
            Edge edgeAdded = graph.addEdge(source, target);
            graph.setEdgeWeight(edgeAdded, currentEdge.L);
            edgeCursor.moveToNext();
        }

        dao.close();
    }

    private Node[] getNodeFromEdgeNodes(DAO dao, String quota, Edge edge) {

        Node[] nodeCouple = null;

        List<Node> node = getAllNodesOfQuote(quota);
        for (Node n : node) {
            if (n.nodeId.equals(edge.NodeId_1)) {
                nodeCouple[0] = n;
            } else if (n.nodeId.equals(edge.NodeId_2)) {
                nodeCouple[1] = n;
            }
            if (nodeCouple[0] != null & nodeCouple[1] != null) {
                return nodeCouple;
            }
        }
        return null;
    }
}