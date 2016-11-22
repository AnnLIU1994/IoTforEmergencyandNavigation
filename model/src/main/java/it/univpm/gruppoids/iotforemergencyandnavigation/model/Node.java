package it.univpm.gruppoids.iotforemergencyandnavigation.model;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.zxing.common.detector.MathUtils;

import org.json.JSONException;
import org.json.JSONObject;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.IoTDB;

/**
 * Created by simon on 16/11/2016.
 */

public final class Node implements Parcelable /* Serializable */ {

    /**
     * Implementation of a CREATOR for the creation of the instance
     */
    public static final Parcelable.Creator<Node> CREATOR = new Parcelable.Creator<Node>() {
        public Node createFromParcel(Parcel in) {
            return new Node(in);
        }

        public Node[] newArray(int size) {
            return new Node[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nodeId);
        dest.writeInt(x);
        dest.writeInt(y);
        dest.writeInt(z);
        dest.writeFloat(width);
        byte stairByte;
        if (stair)
            stairByte = 1;
        else stairByte = 0;
        dest.writeByte(stairByte);

        byte emergencyByte;
        if (emergency)
            emergencyByte = 1;
        else emergencyByte = 0;
        dest.writeByte(emergencyByte);

    }

    /**
     * Keys for the properties
     */
    public interface Keys {
        String ID = "nodeId";
        String X = "x";
        String Y = "y";
        String Z = "z";
        String WIDTH = "width";
        String STAIR = "stair";
        String EMERGENCY = "emergency";
    }

    public final String nodeId;

    public final short x;

    public final short y;

    public final short z;

    public final float width;

    public final boolean stair;

    public final boolean emergency;


    private Node(final String nodeId, final short x, final short y, final short z, final float width, final boolean stair, final boolean emergency) {
        this.nodeId = nodeId;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.stair = stair;
        this.emergency = emergency;
    }

    private Node(Parcel in) {
        nodeId = in.readString();
        x = (short) in.readInt();
        y = (short) in.readInt();
        z = (short) in.readInt();
        width = in.readFloat();
        byte stairByte = in.readByte();
        if (stairByte == 1)
            stair = true;
        else stair = false;

        byte emergencyByte = in.readByte();
        if (emergencyByte == 1)
            emergency = true;
        else emergency = false;
    }

    public int[] getPosition() {
        int[] position = {0, 0};
        int x;
        int y;
        int widthScreen = Resources.getSystem().getDisplayMetrics().widthPixels;
        int heightScreen = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (Resources.getSystem().getDisplayMetrics().density == 1.5 & Resources.getSystem().getDisplayMetrics().widthPixels == 480 &
                Resources.getSystem().getDisplayMetrics().heightPixels == 800) {
            x = this.x - 8;
            y = this.y - 28;
        } else {
            x = this.x;
            y = this.y;
        }
        position[0] = MathUtils.round((widthScreen * x)/1000);
        position[1] = MathUtils.round((heightScreen * y)/1000);
        return position;
    }

    /**
     * Copy Node data into the given Intent
     *
     * @param intent The Intent for the Node data
     */
    public void toIntent(final Intent intent) { // TODO: da utilizzare per il passaggio del nodo iniziale tra le activity
        intent.putExtra(Keys.ID, nodeId);
        intent.putExtra(Keys.X, x);
        intent.putExtra(Keys.Y, y);
        intent.putExtra(Keys.Z, z);
        intent.putExtra(Keys.WIDTH, width);
        intent.putExtra(Keys.STAIR, stair);
        intent.putExtra(Keys.EMERGENCY, emergency);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("nodeId:" + nodeId)
                .append(" x:" + x)
                .append(" y:" + y)
                .append(" z:" + z)
                .append(" width:" + width)
                .append(" stair:" + stair)
                .append(" emergency:" + emergency);
        return stringBuilder.toString();
    }

    /**
     * Builder Pattern implementation for the Node class
     */
    public static class Builder {

        private String mNodeId;

        private short mX;

        private short mY;

        private short mZ;

        private float mWidth;

        private boolean mStair;

        private boolean mEmergency;

        /**
         * Creates a Builder for the Node class
         *
         * @param nodeId   The id for the Node
         */
        private Builder(final String nodeId) {
            this.mNodeId = nodeId;
        }

        /**
         * Static Factory method for the Builder of the Node object
         *
         * @param id   The id for the Node
         * @return The Builder for the Node class
         */
        public static Builder create(final String id) {
            return new Builder(id);
        }

        /**
         * Set the position for the Node
         *
         * @param x The x value of Node
         * @param y The y value of Node
         * @param z The z value of Node
         * @return The Node itself
         */
        public Builder withPosition(final short x, final short y, final short z) {
            this.mX = x;
            this.mY = y;
            this.mZ = z;
            return this;
        }

        /**
         * Set the width value for the Node
         *
         * @param width The width for the Node
         * @return The Node itself
         */
        public Builder withWidth(final float width) {
            this.mWidth = width;
            return this;
        }

        /**
         * Set the stair and emergency attributes for the Node
         *
         * @param stair  The stair value for the Node
         * @param emergency The emergency value for the Node
         * @return The Node itself
         */
        public Builder withStairAndEmergency(final boolean stair, final boolean emergency) {
            this.mStair = stair;
            this.mEmergency = emergency;
            return this;
        }

        /**
         * @return The Node with the given data
         */
        public Node build() {
            return new Node(mNodeId, mX, mY, mZ, mWidth, mStair, mEmergency);
        }

    }

    /**
     * @return The JSON representation of the current Node
     * @throws JSONException In case of creation error
     */
    public JSONObject toJson() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put(Keys.ID, nodeId);
        jsonObject.put(Keys.X, x);
        jsonObject.put(Keys.Y, y);
        jsonObject.put(Keys.Z, z);
        jsonObject.put(Keys.WIDTH, width);
        jsonObject.put(Keys.STAIR, stair);
        jsonObject.put(Keys.EMERGENCY, emergency);
        return jsonObject;
    }

    /**
     * @return The data for this Node into a ContentValue object
     */
    public ContentValues toContentValues() {
        final ContentValues values = new ContentValues();
        values.put(IoTDB.Node.NODE_ID, nodeId);
        values.put(IoTDB.Node.X, x);
        values.put(IoTDB.Node.Y, y);
        values.put(IoTDB.Node.Z, z);
        values.put(IoTDB.Node.WIDTH, width);
        values.put(IoTDB.Node.STAIR, stair);
        values.put(IoTDB.Node.EMERGENCY, emergency);
        return values;
    }

    /**
     * Utility method that creates a Node from data into an Intent
     *
     * @param inputIntent The Intent with the data
     * @return The created Node
     */
    public static Node fromIntent(final Intent inputIntent) {
        final String nodeId = inputIntent.getStringExtra(Keys.ID);
        final short x = inputIntent.getShortExtra(Keys.X, Short.MIN_VALUE);
        final short y = inputIntent.getShortExtra(Keys.Y, Short.MIN_VALUE);
        final short z = inputIntent.getShortExtra(Keys.Z, Short.MIN_VALUE);
        final float width = inputIntent.getFloatExtra(Keys.WIDTH, 0.0f);
        final boolean stair = inputIntent.getBooleanExtra(Keys.STAIR, false);
        final boolean emergency = inputIntent.getBooleanExtra(Keys.EMERGENCY, false);

        final Node node = Node.Builder.create(nodeId)
                .withPosition(x, y, z)
                .withWidth(width)
                .withStairAndEmergency(stair, emergency)
                .build();
        return node;
    }

    /**
     * We use this method to create the Node from the JSON representation
     *
     * @param jsonObject The JSONObject with the Node data
     * @return The Node with the data from the JSONObject
     * @throws JSONException In case of parsing error
     */
    public static Node fromJson(final JSONObject jsonObject) throws JSONException {
        final String nodeId = jsonObject.getString(Keys.ID);
        final short x = (short) jsonObject.getInt(Keys.X);
        final short y = (short) jsonObject.getInt(Keys.Y);
        final short z = (short) jsonObject.getInt(Keys.Z);
        final float width = (float) jsonObject.getDouble(Keys.WIDTH);
        final boolean stair = jsonObject.getBoolean(Keys.STAIR);
        final boolean emergency = jsonObject.getBoolean(Keys.EMERGENCY);

        final Node node = Node.Builder.create(nodeId)
                .withPosition(x, y, z)
                .withWidth(width)
                .withStairAndEmergency(stair, emergency)
                .build();
        return node;
    }

    /**
     * Utility method that returns a Node from a given cursor
     *
     * @param cursor The Cursor for the data
     * @return The Node if any
     */
    public static Node fromCursor(@NonNull final Cursor cursor) {
        String nodeId = cursor.getString(cursor.getColumnIndex(IoTDB.Node.NODE_ID));
        short x = (short) cursor.getInt(cursor.getColumnIndex(IoTDB.Node.X));
        short y = (short) cursor.getInt(cursor.getColumnIndex(IoTDB.Node.Y));
        short z = (short) cursor.getInt(cursor.getColumnIndex(IoTDB.Node.Z));
        float width = cursor.getFloat(cursor.getColumnIndex(IoTDB.Node.WIDTH));
        int stairInt = cursor.getInt(cursor.getColumnIndex(IoTDB.Node.STAIR));

        boolean stair;
        if (stairInt == 0) {
            stair = false;
        } else {
            stair = true;
        }

        int emergencyInt = cursor.getInt(cursor.getColumnIndex(IoTDB.Node.EMERGENCY));

        boolean emergency;
        if (emergencyInt == 0) {
            emergency = false;
        } else {
            emergency = true;
        }

        final Node node = Node.Builder.create(nodeId)
                .withPosition(x, y, z)
                .withWidth(width)
                .withStairAndEmergency(stair, emergency)
                .build();
        return node;
    }
}
