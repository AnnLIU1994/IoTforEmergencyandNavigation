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
    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS user ( " +
            "Nome VARCHAR(15) NOT NULL, " +
            "Cognome VARCHAR(20) NOT NULL, " +
            "Email VARCHAR(30) NOT NULL, " +
            "Username VARCHAR(15) NOT NULL, " +
            "Password VARCHAR(20) NOT NULL, " +
            "PRIMARY KEY (Nome, Cognome), " +
            "UNIQUE (Username));";

    ////////////////////////////////////////////////////////////--------NODES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String CREATE_NODES_TABLE = "CREATE TABLE IF NOT EXISTS nodes ( " +
            "Id VARCHAR(9) NOT NULL PRIMARY KEY, " +
            "x  NOT NULL, " + //TODO: che tipo di dato?
            "y  NOT NULL, " +
            "z int(3) NOT NULL, " +
            "Width  NOT NULL, " +
            "Stair BOOLEAN," +
            "Emergency BOOLEAN);";

    ////////////////////////////////////////////////////////////--------EDGES--------/////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String CREATE_EDGES_TABLE = "CREATE TABLE IF NOT EXISTS edges ( " +
            "Id_1 VARCHAR(9) NOT NULL, " +
            "Id_2 VARCHAR(9) NOT NULL, " +
            "L  NOT NULL, " + //TODO: che tipo di dato?
            "I  NOT NULL, " +
            "C  NOT NULL, " +
            "LOS  NOT NULL, " +
            "V  NOT NULL, " +
            "FOREIGN KEY (Id_1, Id_2) REFERENCES nodes(Id));";

    /*//Inserisce dati nella tabella Nodes
    public void insertNodes(int x,int width, int y,int id){ //metodo per inserire i dati
        ContentValues cont=new ContentValues();
        cont.put(NodesMetaData.NODES_X, x);
        cont.put(NodesMetaData.NODES_ID, id );
        cont.put(NodesMetaData.NODES_WIDTH, width );
        cont.put(NodesMetaData.NODES_Y, y );
        mDb.insert(NodesMetaData.NODES_TABLE, null, cont);
    }


    //legge le informazioni della tabella nodes in base ai parametri di query
    public Cursor fetchNodes(){
        return mDb.query(NodesMetaData.NODES_TABLE, null,null,null,null,null,null);
    }

    public void insertArch(int startNodes,int lenght, int finalNodes,int dinamicWeight){
        ContentValues cont=new ContentValues();
        cont.put(ArchMetaData.ARCH_START_NODES, startNodes);
        cont.put(ArchMetaData.ARCH_LENGHT, lenght );
        cont.put(ArchMetaData.ARCH_FINAL_NODES, finalNodes );
        cont.put(ArchMetaData.ARCH_DINAMIC_WEIGHT, dinamicWeight );
        mDb.insert(ArchMetaData.ARCH_TABLE, null, cont);
    }

    public Cursor fetchArch(){
        return mDb.query(ArchMetaData.ARCH_TABLE, null,null,null,null,null,null);
    }

    public void insertUtente(int id, String Username,String Pass){
        ContentValues cont=new ContentValues();
        cont.put(UserMetaData.USER_ID,id);
        cont.put(UserMetaData.USER_USERNAME, Username );
        cont.put(UserMetaData.USER_PASS, Pass );
        mDb.insert(UserMetaData.USER_TABLE, null, cont);
    }

    public Cursor fetchUser(){ //metodo per fare la query di tutti i dati
        return mDb.query(UserMetaData.USER_TABLE, null,null,null,null,null,null);
    }

    }*/

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
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            //qui mettiamo eventuali modifiche al db, se nella nostra nuova versione della app, il db cambia numero di versione

        }
    }
}