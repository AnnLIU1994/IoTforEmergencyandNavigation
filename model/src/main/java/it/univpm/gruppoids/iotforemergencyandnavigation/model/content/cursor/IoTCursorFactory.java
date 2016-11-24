package it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.Edge;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.Node;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.IoTDB;

/**
 * Created by simon on 16/11/2016.
 */

public class IoTCursorFactory implements SQLiteDatabase.CursorFactory {

    /**
     * This is the class that implements the Cursor for the Nodes table
     */
    public static class NodesCursor extends SQLiteCursor {

        /**
         * Index for nodeId column
         */
        private static int sNodeIdIndex = -1;
        /**
         * Index for x column
         */
        private static int sXIndex;
        /**
         * Index for y column
         */
        private static int sYIndex;
        /**
         * Index for z column
         */
        private static int sZIndex;
        /**
         * Index for width column
         */
        private static int sWidthIndex;
        /**
         * Index for stair column
         */
        private static int sStairIndex;
        /**
         * Index for emergency column
         */
        private static int sEmergencyIndex;

        /**
         * The constructor for the NodeCursor
         *
         * @param driver    The Driver reference
         * @param editTable The name for the table
         * @param query     Encapsulate information about the executed query
         */
        private NodesCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
            super(driver, editTable, query);
            // We read the information we need for reading data from the cursor
            if (sNodeIdIndex == -1) {
                // It means we have to initialize indexes
                sNodeIdIndex = getColumnIndex(IoTDB.Node.NODE_ID);
                sXIndex = getColumnIndex(IoTDB.Node.X);
                sYIndex = getColumnIndex(IoTDB.Node.Y);
                sZIndex = getColumnIndex(IoTDB.Node.Z);
                sWidthIndex = getColumnIndex(IoTDB.Node.WIDTH);
                sStairIndex = getColumnIndex(IoTDB.Node.STAIR);
                sEmergencyIndex = getColumnIndex(IoTDB.Node.EMERGENCY);
            }
        }

        /**
         * @return The current nodeId
         */
        public String getNodeId() {
            return getString(sNodeIdIndex);
        }

        /**
         * @return The current x
         */
        public short getX() {
            return getShort(sXIndex);
        }

        /**
         * @return The current y
         */
        public short getY() {
            return getShort(sYIndex);
        }

        /**
         * @return The current z
         */
        public short getZ() {
            return getShort(sZIndex);
        }

        /**
         * @return The current width
         */
        public float getWidth() {
            return getFloat(sWidthIndex);
        }

        /**
         * @return The current stair
         */
        public boolean getStair() {
            if (getInt(sStairIndex) == 1) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * @return The current emergency
         */
        public boolean getEmergency() {
            if (getInt(sEmergencyIndex) == 1) {
                return true;
            } else
                return false;
        }

        /**
         * @return The current item as Node
         */
        public Node getNode() {
            return Node.Builder.create(getNodeId())
                    .withPosition(getX(), getY(), getZ())
                    .withWidth(getWidth())
                    .withStairAndEmergency(getStair(), getEmergency())
                    .build();
        }

    }

    /**
     * This is the class that implements the Cursor for the Edges table
     */
    public static class EdgesCursor extends SQLiteCursor {

        /**
         * Index for nodeId_1 column
         */
        private static int sNodeId_1Index = -1;
        /**
         * Index for nodeId_2 column
         */
        private static int sNodeId_2Index = -1;
        /**
         * Index for x column
         */
        private static int sLIndex;

        /**
         * The constructor for the NodeCursor
         *
         * @param driver    The Driver reference
         * @param editTable The name for the table
         * @param query     Encapsulate information about the executed query
         */
        private EdgesCursor(SQLiteCursorDriver driver, String editTable, SQLiteQuery query) {
            super(driver, editTable, query);
            // We read the information we need for reading data from the cursor
            if (sNodeId_1Index == -1 && sNodeId_2Index == -1) {
                // It means we have to initialize indexes
                sNodeId_1Index = getColumnIndex(IoTDB.Edge.NODE_ID_1);
                sNodeId_2Index = getColumnIndex(IoTDB.Edge.NODE_ID_2);
                sLIndex = getColumnIndex(IoTDB.Edge.L);
            }
        }

        /**
         * @return The couple of nodeId
         */
        public String[] getCoupleOfNodes() {
            String[] couple = new String[2];
            couple[0] = getString(sNodeId_1Index);
            couple[1] = getString(sNodeId_2Index);
            return couple;
        }

        /**
         * @return The Edge length
         */
        public float getLength() {
            return getFloat(sLIndex);
        }

        /**
         * @return The current item as Edge
         */
        public Edge getEdge() {
            return Edge.Builder.create(getCoupleOfNodes()[0], getCoupleOfNodes()[1])
                    .withLength(getLength())
                    .build();
        }

    }

    // Prevista per l'utilizzo del CursorFactory. Crea l'implementazione del cursor da utilizzare
    @Override
    public Cursor newCursor(SQLiteDatabase db, SQLiteCursorDriver masterQuery, String editTable, SQLiteQuery query) {
        // Just create the NodesCursor instance
        if (IoTDB.Node.TABLE_NAME.equals(editTable)) {
            return new NodesCursor(masterQuery, editTable, query);
        } else if (IoTDB.Edge.TABLE_NAME.equals(editTable)) {
            return new EdgesCursor(masterQuery, editTable, query);
        } else {
            throw new IllegalArgumentException("The table" + editTable + " is not supported!");
        }
    }

}