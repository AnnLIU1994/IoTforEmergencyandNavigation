package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by FABIO on 22/08/16.
 */

public class Database {

    SQLiteDatabase mDb;
    DbHelper mDbHelper;
    Context mContext;
    private static final String DB_NAME="database";    //nome del db
    private static final int DB_VERSION=1;             //numero di versione del nostro db

    public Database(Context ct){
        mContext=ct;
        mDbHelper=new DbHelper(ct, DB_NAME, null, DB_VERSION);   //quando istanziamo questa classe, istanziamo anche l'helper,che aiuta a
        //creare il db
    }

    public void open(){                   //rende leggibile/scrivibile il database
        mDb=mDbHelper.getWritableDatabase();

    }

    public void close(){ //chiudiamo il database su cui agiamo
        mDb.close();
    }





    //Inserisce dati nella tabella Nodes
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
    //creazione dati tabella NODES
    static class NodesMetaData {  // i metadati della tabella, accessibili ovunque
        static final String NODES_TABLE= "nodes";
        static final String NODES_ID = "id";
        static final String NODES_WIDTH = "width";
        static final String NODES_X = "x";
        static final String NODES_Y = "y";
    }
    //creazione tabella Nodes
    private static final String NODES_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "  //codice sql di creazione della tabella
            + NodesMetaData.NODES_TABLE + " (  "
            + NodesMetaData.NODES_ID + " integer primary key autoincrement, "
            + NodesMetaData.NODES_WIDTH + " integer not null, "
            + NodesMetaData.NODES_X + " integer not null,"
            + NodesMetaData.NODES_Y + " integer not null);";


    private static final String USER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "  //codice sql di creazione della tabella
            + UserMetaData.USER_TABLE + " (  "
            + UserMetaData.USER_ID + " integer primary key autoincrement, "
            + UserMetaData.USER_USERNAME + " varchar, "
            + UserMetaData.USER_PASS + " varchar);";

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

    static class ArchMetaData {
        static final String ARCH_TABLE= "Arch";
        static final String ARCH_START_NODES = "startNodes";
        static final String ARCH_LENGHT="lenght";
        static final String ARCH_FINAL_NODES = "finalNodes";
        static final String ARCH_DINAMIC_WEIGHT = "dinamicWeight";
    }



    private static final String ARCH_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "  //codice sql di creazione della tabella
            + ArchMetaData.ARCH_TABLE + " (  "
            + ArchMetaData.ARCH_START_NODES + " integer primary key autoincrement, "
            + ArchMetaData.ARCH_LENGHT + " integer not null, "
            + ArchMetaData.ARCH_FINAL_NODES + " integer not null,"
            + ArchMetaData.ARCH_DINAMIC_WEIGHT + " integer not null);";






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

    static class UserMetaData {  // i metadati della tabella, accessibili ovunque
        static final String USER_TABLE= "User";
        static final String USER_ID = "id";
        static final String USER_USERNAME="username";
        static final String USER_PASS = "password";

    }









    private class DbHelper extends SQLiteOpenHelper { //classe che ci aiuta nella creazione del db

        public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        //onCreate
        @Override
        public void onCreate(SQLiteDatabase _db) { //solo quando il db viene creato, creiamo la tabella
            _db.execSQL(USER_TABLE_CREATE);
            _db.execSQL(NODES_TABLE_CREATE);
            _db.execSQL(ARCH_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            //qui mettiamo eventuali modifiche al db, se nella nostra nuova versione della app, il db cambia numero di versione

        }


    }




}