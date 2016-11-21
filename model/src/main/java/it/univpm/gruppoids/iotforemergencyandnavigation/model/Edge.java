package it.univpm.gruppoids.iotforemergencyandnavigation.model;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.IoTDB;

/**
 * Created by simon on 17/11/2016.
 */

public final class Edge implements Parcelable {

    /**
     * Implementation of a CREATOR for the creation of the instance
     */
    public static final Parcelable.Creator<Edge> CREATOR = new Parcelable.Creator<Edge>() {
        public Edge createFromParcel(Parcel in) {
            return new Edge(in);
        }

        public Edge[] newArray(int size) {
            return new Edge[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(NodeId_1);
        dest.writeString(NodeId_2);
        dest.writeFloat(L);
    }

    /**
     * Keys for the properties
     */
    public interface Keys {
        String NODEID_1 = "NodeId_1";
        String NODEID_2 = "NodeId_2";
        String L = "L";
    }

    public final String NodeId_1;

    public final String NodeId_2;

    public final float L;


    private Edge(final String NodeId_1, final String NodeId_2, final float L) {
        this.NodeId_1 = NodeId_1;
        this.NodeId_2 = NodeId_2;
        this.L = L;
    }

    private Edge(Parcel in) {
        NodeId_1 = in.readString();
        NodeId_2 = in.readString();
        L = in.readFloat();
    }

    /**
     * Copy Edge data into the given Intent
     *
     * @param intent The Intent for the Edge data
     */
    public void toIntent(final Intent intent) {
        intent.putExtra(Edge.Keys.NODEID_1, NodeId_1);
        intent.putExtra(Edge.Keys.NODEID_2, NodeId_2);
        intent.putExtra(Edge.Keys.L, L);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NodeId_1:" + NodeId_1)
                .append("NodeId_2:" + NodeId_2)
                .append(" Lenght:" + L);
        return stringBuilder.toString();
    }

    /**
     * Builder Pattern implementation for the Edge class
     */
    public static class Builder {

        private final String mNodeId_1;

        private final String mNodeId_2;

        private float mL;

        /**
         * Creates a Builder for the Edge class
         *
         * @param NodeId_1   The node 1 id
         * @param NodeId_2   The node 2 id
         */
        private Builder(final String NodeId_1, final String NodeId_2) {
            this.mNodeId_1 = NodeId_1;
            this.mNodeId_2 = NodeId_2;
        }

        /**
         * Static Factory method for the Builder of the Edge object
         *
         * @param NodeId_1   The node 1 id
         * @param NodeId_2   The node 2 id
         * @return The Builder for the Edge class
         */
        public static Edge.Builder create(final String NodeId_1, final String NodeId_2) {
            return new Edge.Builder(NodeId_1, NodeId_2);
        }

        /**
         * Set the position for the Edge
         *
         * @param L The edge lenght
         * @return The Edge itself
         */
        public Edge.Builder withLength(final float L) {
            this.mL = L;
            return this;
        }

        /**
         * @return The Edge with the given data
         */
        public Edge build() {
            return new Edge(mNodeId_1, mNodeId_2, mL);
        }

    }

    /**
     * @return The JSON representation of the current Edge
     * @throws JSONException In case of creation error
     */
    public JSONObject toJson() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put(Edge.Keys.NODEID_1, NodeId_1);
        jsonObject.put(Edge.Keys.NODEID_2, NodeId_2);
        jsonObject.put(Edge.Keys.L, L);
        return jsonObject;
    }

    /**
     * @return The data for this Edge into a ContentValue object
     */
    public ContentValues toContentValues() {
        final ContentValues values = new ContentValues();
        values.put(IoTDB.Edge.NODE_ID_1, NodeId_1);
        values.put(IoTDB.Edge.NODE_ID_2, NodeId_2);
        values.put(IoTDB.Edge.L, L);
        return values;
    }

    /**
     * Utility method that creates a Edge from data into an Intent
     *
     * @param inputIntent The Intent with the data
     * @return The created Edge
     */
    public static Edge fromIntent(final Intent inputIntent) {
        final String NodeId_1 = inputIntent.getStringExtra(Keys.NODEID_1);
        final String NodeId_2 = inputIntent.getStringExtra(Keys.NODEID_2);
        final float L = inputIntent.getFloatExtra(Edge.Keys.L, 0.0f);

        final Edge edge = Edge.Builder.create(NodeId_1, NodeId_2)
                .withLength(L)
                .build();
        return edge;
    }

    /**
     * We use this method to create the Edge from the JSON representation
     *
     * @param jsonObject The JSONObject with the Edge data
     * @return The Edge with the data from the JSONObject
     * @throws JSONException In case of parsing error
     */
    public static Edge fromJson(final JSONObject jsonObject) throws JSONException {
        final String NodeId_1 = jsonObject.getString(Edge.Keys.NODEID_1);
        final String NodeId_2 = jsonObject.getString(Edge.Keys.NODEID_2);
        final float L = (float) jsonObject.getDouble(Edge.Keys.L);

        final Edge edge = Edge.Builder.create(NodeId_1, NodeId_2)
                .withLength(L)
                .build();
        return edge;
    }

    /**
     * Utility method that returns a Edge from a given cursor
     *
     * @param cursor The Cursor for the data
     * @return The Edge if any
     */
    public static Edge fromCursor(@NonNull final Cursor cursor) {
        String NodeId_1 = cursor.getString(cursor.getColumnIndex(IoTDB.Edge.NODE_ID_1));
        String NodeId_2 = cursor.getString(cursor.getColumnIndex(IoTDB.Edge.NODE_ID_2));
        float L = cursor.getFloat(cursor.getColumnIndex(IoTDB.Edge.L));

        final Edge edge = Edge.Builder.create(NodeId_1, NodeId_2)
                .withLength(L)
                .build();
        return edge;
    }
}
