package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbAdapter { // Contiene tutto quei metodi utilizzati per interrogare il database (utilizzando il DbHelper)

    Context context;
    SQLiteDatabase db;
    DbHelper dbHelper;       //numero di versione del nostro db

    public DbAdapter(Context context) {
        this.context = context;
    }

    public DbAdapter open() throws SQLException {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }


    public void close() { //chiudiamo il database su cui agiamo
        dbHelper.close();
    }

    public Cursor fetchUser() { //metodo per fare la query di tutti i dati
        return db.query(DbHelper.UserMetaData.USER_TABLE, null, null, null, null, null, null);
    }

    public Cursor fetchNodes() {
        return db.query(DbHelper.NodesMetaData.NODES_TABLE, null, null, null, null, null, null);
    }

    public Cursor fetchEdges() {
        return db.query(DbHelper.EdgesMetaData.EDGES_TABLE, null, null, null, null, null, null);
    }

    ///////////////////////////////////////////////////////////--------INSERT USER---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertUser(String nome, String cognome, String email, String username, String password) {
        ContentValues user = new ContentValues();
        user.put(DbHelper.UserMetaData.NOME, nome);
        user.put(DbHelper.UserMetaData.COGNOME, cognome);
        user.put(DbHelper.UserMetaData.EMAIL, email);
        user.put(DbHelper.UserMetaData.USERNAME, username);
        user.put(DbHelper.UserMetaData.PASSWORD, password);
        db.insert(DbHelper.UserMetaData.USER_TABLE, null, user);
    }

    ///////////////////////////////////////////////////////////--------INSERT NODES---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertNode(String id, short x, short y, short z, float width, byte stair, byte emergency) {
        ContentValues node = new ContentValues();
        node.put(DbHelper.NodesMetaData.ID, id);
        node.put(DbHelper.NodesMetaData.X, x);
        node.put(DbHelper.NodesMetaData.Y, y);
        node.put(DbHelper.NodesMetaData.Z, z);
        node.put(DbHelper.NodesMetaData.WIDTH, width);
        node.put(DbHelper.NodesMetaData.STAIR, stair);
        node.put(DbHelper.NodesMetaData.EMERGENCY, emergency);
        db.insert(DbHelper.NodesMetaData.NODES_TABLE, null, node);
    }

    ///////////////////////////////////////////////////////////--------INSERT EDGES---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertEdge(String id1, String id2, float L) { // Non ho bisogno di inserire i pesi dinamici perche stanno gia sul DBserver
        ContentValues edge = new ContentValues();
        edge.put(DbHelper.EdgesMetaData.ID1, id1);
        edge.put(DbHelper.EdgesMetaData.ID2, id2);
        edge.put(DbHelper.EdgesMetaData.L, L);
        db.insert(DbHelper.EdgesMetaData.EDGES_TABLE, null, edge);
    }
}
