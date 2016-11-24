package it.univpm.gruppoids.iotforemergencyandnavigation.model.content;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by simon on 16/11/2016.
 */

public final class IoTDB {

    public static final String DB_NAME = "IoTDB.db";

    public static final int DB_VERSION = 1;

    /**
     * The Authority for the ContentProvider
     */
    public static final String AUTHORITY = "it.univpm.gruppoids.iotforemergencyandnavigation.model";

    /**
     * The class with the metadata for the Nodes table
     */
    public static final class Node implements BaseColumns {

        /**
         * The Path for this kind of resource
         */
        public static final String PATH = "Node";

        /**
         * The Uri for this resources
         */
        public static final Uri CONTENT_URI = Uri.parse(ContentResolver.SCHEME_CONTENT + "://"
                + AUTHORITY + "/" + PATH);

        /**
         * The mime type for the dir
         */
        public static final String MIME_TYPE_DIR = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd." + PATH;

        /**
         * The mime type for the single item
         */
        public static final String MIME_TYPE_ITEM = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + PATH;

        /**
         * The name of the table for the data
         */
        public static final String TABLE_NAME = "Nodes";

        /**
         * The Id for the Node (String)
         */
        public static final String NODE_ID = "nodeId";

        /**
         * The x of the Node (short)
         */
        public static final String X = "x";

        /**
         * The y of the Node (short)
         */
        public static final String Y = "y";

        /**
         * The z of the Node (short)
         */
        public static final String Z = "z";

        /**
         * The width of the Node (float)
         */
        public static final String WIDTH = "width";

        /**
         * The boolean data stair of the Node
         */
        public static final String STAIR= "stair";

        /**
         * The boolean data emergency of the Node
         */
        public static final String EMERGENCY= "emergency";

    }

    /**
     * The class with the metadata for the Edges table
     */
    public static final class Edge implements BaseColumns {

        /**
         * The Path for this kind of resource
         */
        public static final String PATH = "Edge";

        /**
         * The Uri for this resources
         */
        public static final Uri CONTENT_URI = Uri.parse(ContentResolver.SCHEME_CONTENT + "://"
                + AUTHORITY + "/" + PATH);

        /**
         * The mime type for the dir
         */
        public static final String MIME_TYPE_DIR = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd." + PATH;

        /**
         * The mime type for the single item
         */
        public static final String MIME_TYPE_ITEM = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + PATH;

        /**
         * The name of the table for the data
         */
        public static final String TABLE_NAME = "Edges";

        /**
         * The Node 1 id for the Edges (String)
         */
        public static final String NODE_ID_1 = "nodeId_1";

        /**
         * The Node 2 id for the Edges (String)
         */
        public static final String NODE_ID_2 = "nodeId_2";

        /**
         * The length of the Edges (float)
         */
        public static final String L = "L";

    }

    /**
     * The class with the metadata for the Users table
     */
    public static final class User implements BaseColumns {

        /**
         * The Path for this kind of resource
         */
        public static final String PATH = "Users";

        /**
         * The Uri for this resources
         */
        public static final Uri CONTENT_URI = Uri.parse(ContentResolver.SCHEME_CONTENT + "://"
                + AUTHORITY + "/" + PATH);

        /**
         * The mime type for the dir
         */
        public static final String MIME_TYPE_DIR = ContentResolver.CURSOR_DIR_BASE_TYPE + "/vnd." + PATH;

        /**
         * The mime type for the single item
         */
        public static final String MIME_TYPE_ITEM = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/vnd." + PATH;

        /**
         * The name of the table for the data
         */
        public static final String TABLE_NAME = "Users";

        /**
         * The name for the Users (String)
         */
        public static final String NOME = "nome";

        /**
         * The surname for the Users (String)
         */
        public static final String COGNOME = "cognome";

        /**
         * The email for the Users (String)
         */
        public static final String EMAIL = "email";

        /**
         * The username for the Users (String)
         */
        public static final String USERNAME = "username";

        /**
         * The password for the Users (String)
         */
        public static final String PASSWORD = "password";

    }
}
