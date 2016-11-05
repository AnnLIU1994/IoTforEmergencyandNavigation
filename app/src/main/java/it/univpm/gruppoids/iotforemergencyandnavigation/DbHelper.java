package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by simon on 02/11/2016.
 */

public class DbHelper extends SQLiteOpenHelper { // Contiene tutto quello che serve per lavorare sul db, inizializzarlo ed aggiornarlo

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "IoTDb.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    ////////////////////////////////////////////////////////////--------USER--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class UserMetaData {  // i metadati della tabella, accessibili ovunque
        static final String USER_TABLE = "Users";
        static final String NOME = "nome";
        static final String COGNOME = "cognome";
        static final String EMAIL = "email";
        static final String USERNAME = "username";
        static final String PASSWORD = "password";
    }

    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + UserMetaData.USER_TABLE + "(" +
            UserMetaData.NOME + "TEXT, " +
            UserMetaData.COGNOME + "TEXT, " +
            UserMetaData.EMAIL + "TEXT NOT NULL, " +
            UserMetaData.USERNAME + "TEXT NOT NULL, " +
            UserMetaData.PASSWORD + "TEXT NOT NULL, " +
            "PRIMARY KEY (" + UserMetaData.NOME + ", " + UserMetaData.COGNOME + "));";

    ////////////////////////////////////////////////////////////--------NODES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class NodesMetaData {  // i metadati della tabella, accessibili ovunque
        static final String NODES_TABLE = "Nodes";
        static final String ID = "id";
        static final String X = "x";
        static final String Y = "y";
        static final String Z = "z";
        static final String WIDTH = "width";
        static final String STAIR = "stair";
        static final String EMERGENCY = "emergency";
    }

    private static final String CREATE_NODES_TABLE = "CREATE TABLE IF NOT EXISTS " + NodesMetaData.NODES_TABLE + "(" +
            NodesMetaData.ID + "TEXT PRIMARY KEY, " +
            NodesMetaData.X + "INTEGER NOT NULL, " + //SMALLINT può assumere 65536 valori. Ponendolo UNSIGNED non si utilizzano i numeri negativi
            NodesMetaData.Y + "INTEGER NOT NULL, " +
            NodesMetaData.Z + "INTEGER NOT NULL, " +
            NodesMetaData.WIDTH + "REAL NOT NULL, " + // DECIMAL(2,1) permette di utilizzare numeri con una cifra unitaria e una decimale
            NodesMetaData.STAIR + "INTEGER, " + // TINYINT(1) al posto del booleano
            NodesMetaData.EMERGENCY + "INTEGER);";

    ////////////////////////////////////////////////////////////--------EDGES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    static class EdgesMetaData {  // i metadati della tabella, accessibili ovunque
        static final String EDGES_TABLE = "Edges";
        static final String ID1 = "id_1";
        static final String ID2 = "id_2";
        static final String L = "L";
    }

    private static final String CREATE_EDGES_TABLE = "CREATE TABLE IF NOT EXISTS " + EdgesMetaData.EDGES_TABLE + "(" +
            EdgesMetaData.ID1 + "TEXT, " +
            EdgesMetaData.ID2 + "TEXT, " +
            EdgesMetaData.L + "INTEGER  NOT NULL);";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_NODES_TABLE);
        db.execSQL(CREATE_EDGES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserMetaData.USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + NodesMetaData.NODES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + EdgesMetaData.EDGES_TABLE);
        // Creating tables again
        onCreate(db);

    }
}
