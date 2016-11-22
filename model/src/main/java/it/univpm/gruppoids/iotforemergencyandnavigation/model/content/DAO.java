package it.univpm.gruppoids.iotforemergencyandnavigation.model.content;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.Node;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor.IoTCursorFactory;

/**
 * Created by simon on 16/11/2016.
 */

public class DAO {

    /**
     * The Tag for the Log
     */
    private static final String TAG_LOG = DAO.class.getName();


    /**
     * The Reference to the IoTDB
     */
    private DbHelper mDbHelper;

    /**
     * Private constructor
     *
     * @param context The Context
     */
    private DAO(Context context) {
        mDbHelper = new DbHelper(context);
    }

    /**
     * Static Factory Method for the DAO
     *
     * @param context The Context
     * @return The DAO instance
     */
    public static synchronized DAO get(final Context context) {
        return new DAO(context.getApplicationContext());
    }

    /**
     * This method open the IoT DB
     */
    public void open() {
        // Empty
    }

    /**
     * This method deletes the Node with the given id
     *
     * @param stopId The id of the Node to delete
     * @return The number of Node deleted (should be 1) or -1 in case of problems
     */
    public int deleteNodeById(@NonNull final String stopId) {
        int deleteResult = -1;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        final String where = IoTDB.Node.NODE_ID + " = ?";
        final String[] whereArgs = new String[]{stopId};
        deleteResult = db.delete(IoTDB.Node.TABLE_NAME, where, whereArgs);
        return deleteResult;
    }

    /**
     * Method to insert a Node into the DB
     *
     * @param Node The Node to insert
     * @return The new Id for the DB
     */
    public long insertNode(@NonNull final Node Node) {
        long newId = -1;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        newId = db.insert(IoTDB.Node.TABLE_NAME, "NULL", Node.toContentValues());
        return newId;
    }

    /**
     * This method update the given Node which must have a stopId
     *
     * @param data The BusModel to update
     * @return The number of updated data (0, 1 ore -1)
     */
    public int updateNode(@NonNull final Node data) {
        int updated = -1;
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // We create the Values
        final ContentValues values = data.toContentValues();
        final String where = IoTDB.Node.NODE_ID + " = ?";
        final String[] whereArgs = new String[]{data.nodeId};
        // We update the values into the DB
        updated = db.update(IoTDB.Node.TABLE_NAME, values, where, whereArgs);
        return updated;
    }

    /**
     * The standard version of query method. It returns the Cursor that should be managed by the caller object
     *
     * @param where     The where clause
     * @param whereArgs The arguments for the where clause
     * @return The Cursor implementations with the result
     */
    public Cursor simpleQuery(final String where, final String[] whereArgs) {
        Cursor cursor;
        // We execute the query
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        cursor = db.query(IoTDB.Node.TABLE_NAME, null, where, whereArgs, null, null, null);
        return cursor;
    }

    public Cursor fetchNodes() {
        Cursor cursor;
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        cursor = db.query(IoTDB.Node.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    /**
     * The simpler version of query method. It returns the Cursor that should be managed by the caller object
     *
     * @param where     The where clause
     * @param whereArgs The arguments for the where clause
     * @return The Cursor implementations with the result
     */
    public IoTCursorFactory.NodesCursor customNodeQuery(final String where, final String[] whereArgs) {
        IoTCursorFactory.NodesCursor cursor = null;
        // We execute the query
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        cursor = (IoTCursorFactory.NodesCursor) db.query(IoTDB.Node.TABLE_NAME, null, where, whereArgs, null, null, null);
        return cursor;
    }

    /**
     * The simpler version of query method. It returns the Cursor that should be managed by the caller object
     *
     * @param where     The where clause
     * @param whereArgs The arguments for the where clause
     * @return The Cursor implementations with the result
     */
    public IoTCursorFactory.EdgesCursor customEdgeQuery(final String where, final String[] whereArgs) {
        IoTCursorFactory.EdgesCursor cursor = null;
        // We execute the query
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        cursor = (IoTCursorFactory.EdgesCursor) db.query(IoTDB.Edge.TABLE_NAME, null, where, whereArgs, null, null, null);
        return cursor;
    }

    /**
     * This method closes the IoTDB. It's safe so if already closed it does nothing
     */

    public void close() {
        mDbHelper.close();
    }

}