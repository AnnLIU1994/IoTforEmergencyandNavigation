package it.univpm.gruppoids.iotforemergencyandnavigation;

/**
 * Created by simon on 03/11/2016.
 */

public class Graph {
    Nodes node;
    Edges edge;
    float weight;
    // TODO: ?? classe per weight ??

    public Graph(Nodes node, Edges edge, float weight) {
        this.node = node;
        this.edge = edge;
        this.weight = weight;
    }

    /*public SimpleWeightedGraph<Nodes, Edges> createGraph() { // DefaultEdge per arco non orientato e senza informazioni particolari

        UndirectedGraph<Nodes, Edges> graph = new SimpleWeightedGraph<Nodes, Edges>(Edges.class);
        graph.addVertex(node);
        //graph.addEdge();
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

    }*/
}
