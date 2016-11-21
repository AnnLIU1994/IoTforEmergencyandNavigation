package it.univpm.gruppoids.iotforemergencyandnavigation;

import android.app.Application;

import it.univpm.gruppoids.iotforemergencyandnavigation.model.content.DbManager;

/**
 * Classe che viene chiamata all'avvio dell'applicazione. Crea un'istanza singleton della classe DbManager
 */

public class IoTApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbManager.init(this);
    }

}
