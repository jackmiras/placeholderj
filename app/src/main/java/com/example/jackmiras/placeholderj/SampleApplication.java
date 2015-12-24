package com.example.jackmiras.placeholderj;

import android.app.Application;

import com.example.jackmiras.placeholderj.library.PlaceHolderManager;

/**
 * Created by jackson on 14/12/15.
 */
public class SampleApplication extends Application {

    private static PlaceHolderManager placeHolderManager;

    @Override
    public void onCreate() {
        super.onCreate();

        placeHolderManager = new PlaceHolderManager.Configurator()
                .config();
    }

    public static PlaceHolderManager getPlaceHolderManager() {
        return placeHolderManager;
    }
}
