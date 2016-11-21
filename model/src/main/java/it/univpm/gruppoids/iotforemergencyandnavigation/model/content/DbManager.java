package it.univpm.gruppoids.iotforemergencyandnavigation.model.content;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.cursor.IoTCursorFactory;
import it.univpm.gruppoids.iotforemergencyandnavigation.model.util.IOUtils;

/**
 * This is a class that manages updates for the current DB file. The constant CURRENT_DB_VERSION
 * contains the version of the DB for this application. At every start we check if there are
 * DB for previous versions. If so we delete them and copy the new DB into the /database/ directory
 * for the application.
 */

public class DbManager {
    /**
     * The Tag for the Log
     */
    private static final String TAG = DbManager.class.getSimpleName();

    /**
     * The timeout for the initialization
     */
    private static final long TIMEOUT = 1200L;

    /**
     * This is the name for the Preferences that contains the version of the current DB
     */
    private static final String DB_PREFS_NAME = "DbVersion";

    /**
     * The name of the property related to the current DB version
     */
    private static final String DB_VERSION_KEY = ".key.DB_VERSION_KEY";

    /**
     * The path for the DB in assets
     */
    private static final String DB_ASSETS_PATH = "db/OfflineIoTDB.sqlite";

    /**
     * The last version of the DB
     */
    public static final int CURRENT_DB_VERSION = 1;

    /**
     * The Singleton instance for the DbManager
     */
    private static DbManager sInstance;

    /**
     * The reference to the ApplicationContext
     */
    private final Context mAppContext;

    /**
     * The CountDownLatch we use for initialization
     */
    private static final CountDownLatch mCountDownLatch = new CountDownLatch(1);

    /**
     * Private constructor
     */
    private DbManager(final Context context) {
        // We save the reference to the ApplicationContext
        this.mAppContext = context.getApplicationContext();
    }


    /**
     * This is the method that we invoke into the Application.onCreate() to manage the DB
     * initialization. This will make the check about the presence of another DB
     * and will copy the new if needed.
     *
     * @param context The Context
     */
    public static void init(final Context context) {
        if (sInstance == null) {
            sInstance = new DbManager(context);
            // We start the Thread that will initialize the DB for the application
            new Thread() {
                @Override
                public void run() {
                    // We update the DB
                    manageUpdate(context);
                }
            }.start();
        } else {
            throw new IllegalStateException("DbManager already initialized!");
        }
    }

    /**
     * We get the reference to the DbManager. This is a blocking method that will wait until
     * the DbManager initialization has been completed
     *
     * @return The DbManager singleton instance
     */
    public synchronized static DbManager get() { // TODO: ???????
        try {
            mCountDownLatch.await(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sInstance;
    }

    /**
     * This encapsulate the logic for the update of the local DB
     *
     * @param context tHe Context
     */
    private static void manageUpdate(final Context context) {
        // We check the current version for the DB
        final SharedPreferences dbPrefs = context.getSharedPreferences(DB_PREFS_NAME, Context.MODE_PRIVATE);
        final int currentDbVersion = dbPrefs.getInt(DB_VERSION_KEY, 0);
        if (currentDbVersion < CURRENT_DB_VERSION) {
            // In this case we have to update the DB that follows a specific naming convention
            final File oldDbFile = context.getDatabasePath(getDbName(currentDbVersion));
            // We create the DB using context
            final String newDbName = getDbName(CURRENT_DB_VERSION);
            // This is mandatory because the DB must be created by Android and not here as a file
            context.openOrCreateDatabase(newDbName, Context.MODE_PRIVATE, new IoTCursorFactory());
            // We create the file for the new DB
            final File newDbFile = context.getDatabasePath(newDbName);
            // We copy the new file
            try {
                copyDbFile(context, newDbFile);
                // If everything is ok we just delete the old file
                oldDbFile.delete();
                // And save the current version for the DB
                dbPrefs.edit().putInt(DB_VERSION_KEY, CURRENT_DB_VERSION).apply();
            } catch (IOException e) {
                Log.e(TAG, "Error copying DB for version ", e);
            }
        } else {
            // In this case the DB is ok because we already have the last version
            Log.d(TAG, "IoTDB already updated[" + currentDbVersion + "]");
        }
        // In any case we unlock the CountDownLatch
        mCountDownLatch.countDown();
    }


    /**
     * This create the name of the DB file from the related version
     *
     * @param version The Version of the DB
     * @return The File name for the given DB
     */
    private static String getDbName(final int version) {
        return "IoTDB_" + version;
    }


    /**
     * This is the method that copies the DB file into the related dir
     *
     * @param newDbFile The File for the new DB
     */
    private static void copyDbFile(final Context context, final File newDbFile) throws IOException {
        // The DB is into the assets
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(context.getAssets().open(DB_ASSETS_PATH));
            bos = new BufferedOutputStream(new FileOutputStream(newDbFile));
            IOUtils.copy(bis, bos);
        } finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(bos);
        }
    }
}
