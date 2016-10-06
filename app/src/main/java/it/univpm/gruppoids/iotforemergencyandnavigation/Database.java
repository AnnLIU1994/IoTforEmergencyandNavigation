package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database {

    SQLiteDatabase mDb;
    DbHelper mDbHelper;
    Context mContext;
    private static final String DB_NAME = "IoTDb";    //nome del db
    private static final int DB_VERSION = 1;          //numero di versione del nostro db

    public Database (Context ctx) {
        mContext = ctx;
        mDbHelper = new DbHelper(ctx, DB_NAME, null, DB_VERSION);   //quando istanziamo questa classe, istanziamo anche l'helper (vedi sotto)
    }

    public void open(){    //rende leggibile/scrivibile il database
        mDb = mDbHelper.getWritableDatabase();
    }

    public void close(){ //chiudiamo il database su cui agiamo
        mDb.close();
    }

    ////////////////////////////////////////////////////////////--------USER--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class UserMetaData {  // i metadati della tabella, accessibili ovunque
        static final String USER_TABLE = "user";
        static final String NOME = "Nome";
        static final String COGNOME = "Cognome";
        static final String EMAIL = "Email";
        static final String USERNAME = "Username";
        static final String PASSWORD = "Password";
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + UserMetaData.USER_TABLE + " ( " +
            UserMetaData.NOME + " VARCHAR(15) NOT NULL, " +
            UserMetaData.COGNOME + " VARCHAR(20) NOT NULL, " +
            UserMetaData.EMAIL + " VARCHAR(30) NOT NULL, " +
            UserMetaData.USERNAME + " VARCHAR(15) NOT NULL, " +
            UserMetaData.PASSWORD + " VARCHAR(20) NOT NULL, " +
            "PRIMARY KEY (" + UserMetaData.NOME + ", " + UserMetaData.COGNOME + "), " +
            "UNIQUE (" + UserMetaData.USERNAME + "));";

    public Cursor fetchUser(){ //metodo per fare la query di tutti i dati
        return mDb.query(UserMetaData.USER_TABLE, null,null,null,null,null,null);
    }

    ////////////////////////////////////////////////////////////--------NODES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class NodesMetaData {  // i metadati della tabella, accessibili ovunque
        static final String NODES_TABLE = "nodes";
        static final String ID = "Id";
        static final String X = "x";
        static final String Y = "y";
        static final String Z = "z";
        static final String WIDTH = "Width";
        static final String STAIR = "Stair";
        static final String EMERGENCY = "Emergency";
    }

    private static final String CREATE_NODES_TABLE = "CREATE TABLE IF NOT EXISTS " + NodesMetaData.NODES_TABLE + " ( " +
            NodesMetaData.ID + " VARCHAR(9) NOT NULL PRIMARY KEY, " +
            NodesMetaData.X + " SMALLINT(3) UNSIGNED NOT NULL, " + //SMALLINT può assumere 65536 valori. Ponendolo UNSIGNED non si utilizzano i numeri negativi
            NodesMetaData.Y + " SMALLINT(3) UNSIGNED NOT NULL, " +
            NodesMetaData.Z + " SMALLINT(3) UNSIGNED NOT NULL, " +
            NodesMetaData.WIDTH + " DECIMAL(1,1) NOT NULL, " + // DECIMAL(1,1) permette di utilizzare numeri con una cifra unitaria e una decimale
            NodesMetaData.STAIR + " TINYINT(1) DEFAULT 0," + // TINYINT(1) al posto del booleano
            NodesMetaData.EMERGENCY + " TINYINT(1) DEFAULT 0);";

    public Cursor fetchNodes(){
        return mDb.query(NodesMetaData.NODES_TABLE, null,null,null,null,null,null);
    }

    ////////////////////////////////////////////////////////////--------EDGES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class EdgesMetaData {  // i metadati della tabella, accessibili ovunque
        static final String EDGES_TABLE = "edges";
        static final String ID1 = "Id_1";
        static final String ID2 = "Id_2";
        static final String L = "L";
        static final String I = "I";
        static final String C = "C";
        static final String LOS = "LOS";
        static final String V = "V";
    }

    private static final String CREATE_EDGES_TABLE = "CREATE TABLE IF NOT EXISTS " + EdgesMetaData.EDGES_TABLE + " ( " +
            EdgesMetaData.ID1 + " VARCHAR(9) NOT NULL, " +
            EdgesMetaData.ID2 + " VARCHAR(9) NOT NULL, " +
            EdgesMetaData.L + " DECIMAL(2,1)  NOT NULL, " +
            EdgesMetaData.I + " DECIMAL(1,1) NOT NULL, " +
            EdgesMetaData.C + " DECIMAL(1,1)  NOT NULL, " +
            EdgesMetaData.LOS + " DECIMAL(1,1)  NOT NULL, " +
            EdgesMetaData.V + " DECIMAL(1,1)  NOT NULL, " +
            "FOREIGN KEY (" + EdgesMetaData.ID1 + ", " + EdgesMetaData.ID2 + ") REFERENCES " + NodesMetaData.NODES_TABLE + "(" + NodesMetaData.ID + "));";

    public Cursor fetchEdges(){
        return mDb.query(EdgesMetaData.EDGES_TABLE, null,null,null,null,null,null);
    }

    ///////////////////////////////////////////////////////////--------INSERT USER---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertUser(String nome, String cognome, String email, String username, String password){
        ContentValues user = new ContentValues();
        user.put(UserMetaData.NOME, nome);
        user.put(UserMetaData.COGNOME, cognome );
        user.put(UserMetaData.EMAIL, email );
        user.put(UserMetaData.USERNAME, username );
        user.put(UserMetaData.PASSWORD, password );
        mDb.insert(UserMetaData.USER_TABLE, null, user);
    }

    ///////////////////////////////////////////////////////////--------INSERT NODES---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertNode(String id, short x, short y, short z, float width, byte stair, byte emergency){
        ContentValues node = new ContentValues();
        node.put(NodesMetaData.ID, id);
        node.put(NodesMetaData.X, x );
        node.put(NodesMetaData.Y, y );
        node.put(NodesMetaData.Z, z );
        node.put(NodesMetaData.WIDTH, width );
        node.put(NodesMetaData.STAIR, stair );
        node.put(NodesMetaData.EMERGENCY, emergency );
        mDb.insert(NodesMetaData.NODES_TABLE, null, node);
    }

    ///////////////////////////////////////////////////////////--------INSERT EDGES---------//////////////////////////////////////////////////////////////////////////////////////////////
    public void insertEdge(String id1, String id2, float L, float I, float C, float LOS, float V){
        ContentValues edge = new ContentValues();
        edge.put(EdgesMetaData.ID1, id1);
        edge.put(EdgesMetaData.ID2, id2);
        edge.put(EdgesMetaData.L, L);
        edge.put(EdgesMetaData.I, I);
        edge.put(EdgesMetaData.C, C);
        edge.put(EdgesMetaData.LOS, LOS);
        edge.put(EdgesMetaData.V, V);
        mDb.insert(EdgesMetaData.EDGES_TABLE, null, edge);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //========================================================= DBHELPER ===================================================================================//
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private class DbHelper extends SQLiteOpenHelper { //classe che ci aiuta nella creazione del db

        public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) { //solo quando il db viene creato, creiamo la tabella
            _db.execSQL(CREATE_USER_TABLE);   // Creo tabella user
            _db.execSQL(CREATE_NODES_TABLE);  // Creo tabella nodi
            _db.execSQL(CREATE_EDGES_TABLE);  // Creo tabella archi
            // TODO: E meglio inserire i dati qui o nella splash??
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            //qui mettiamo eventuali modifiche al db, se nella nostra nuova versione della app, il db cambia numero di versione

        }
    }
}