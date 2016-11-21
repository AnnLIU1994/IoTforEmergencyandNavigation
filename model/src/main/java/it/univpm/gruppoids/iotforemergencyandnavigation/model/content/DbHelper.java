package it.univpm.gruppoids.iotforemergencyandnavigation.model.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.R;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor.IoTCursorFactory;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.util.ResourceUtils;

/**
 * Created by simon on 18/11/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    /**
     * The Tag for the Log
     */
    private static final String TAG = DbHelper.class.getSimpleName();

    /**
     * The Insert prepared statement
     */
    private static final String INSERT_NODE = "INSERT INTO Nodes (nodeId, x, y, z, width, " +
            "stair, emergency) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private static final String INSERT_EDGE = "INSERT INTO Edges (nodeId_1, nodeId_2, L) " +
            "VALUES (?, ?, ?);";

    /**
     * The Context
     */
    private final Context mContext;

    /**
     * Create a DbHelper to manage DB lifecycle
     *
     * @param context The Context
     */
    public DbHelper(Context context) {
        super(context, IoTDB.DB_NAME, new IoTCursorFactory(), IoTDB.DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            final String createSQL = ResourceUtils.getRawAsString(mContext, R.raw.create_schemas);
            db.execSQL(createSQL);
            insertMockDataNodes(db);
            insertMockDataEdges(db);
            db.setTransactionSuccessful();
        } catch (IOException ioe) {
            Log.e(TAG, "Error reading create SQL", ioe);
        } finally {
            db.endTransaction();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.beginTransaction();
            final String dropSQL = ResourceUtils.getRawAsString(mContext, R.raw.drop_schemas);
            db.execSQL(dropSQL);
            db.setTransactionSuccessful();
        } catch (IOException ioe) {
            Log.e(TAG, "Error reading create SQL", ioe);
        } finally {
            db.endTransaction();
        }
        onCreate(db);
    }

    /**
     * Utility method to create mock data node
     *
     * @param db The SQLiteDatabase
     */
    private void insertMockDataNodes(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            final String dataAsText = ResourceUtils.getRawAsString(mContext, R.raw.mock_data_nodes);
            final BufferedReader reader = new BufferedReader(new StringReader(dataAsText));
            String currentLine;
            ContentValues rowNode = new ContentValues();
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(";");
                rowNode.put(IoTDB.Node.NODE_ID, data[0]);
                rowNode.put(IoTDB.Node.X, Integer.valueOf(data[1]));
                rowNode.put(IoTDB.Node.Y, Integer.valueOf(data[2]));
                rowNode.put(IoTDB.Node.Z, Integer.valueOf(data[3]));
                rowNode.put(IoTDB.Node.WIDTH, Float.valueOf(data[4]));
                rowNode.put(IoTDB.Node.STAIR, Integer.valueOf(data[5]));
                rowNode.put(IoTDB.Node.EMERGENCY, Integer.valueOf(data[6]));
                //db.execSQL(INSERT_NODE, data);
                db.insert(IoTDB.Node.TABLE_NAME, null, rowNode);
            }
            db.setTransactionSuccessful();
        } catch (IOException ioe) {
            Log.e(TAG, "Error reading create SQL", ioe);
        } finally {
            db.endTransaction();
        }
    }

    /**
     * Utility method to create mock data edge
     *
     * @param db The SQLiteDatabase
     */
    private void insertMockDataEdges(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            final String dataAsText = ResourceUtils.getRawAsString(mContext, R.raw.mock_data_edges);
            final BufferedReader reader = new BufferedReader(new StringReader(dataAsText));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(";");
                db.execSQL(INSERT_EDGE, data);
            }
            db.setTransactionSuccessful();
        } catch (IOException ioe) {
            Log.e(TAG, "Error reading create SQL", ioe);
        } finally {
            db.endTransaction();
        }
    }
}
