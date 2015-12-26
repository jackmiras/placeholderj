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

        /**
         *  If you don't pass any value to the configurator than PlaceHolderJ will use the default interface
         */
        placeHolderManager = new PlaceHolderManager.Configurator().config();

        /**
         *  Sample of how customize PlaceHolderJ Views (Uncomment the code below)
         */
        /*placeHolderManager = new PlaceHolderManager.Configurator()
                .loadingBackground(android.R.color.holo_green_light)
                .errorText(R.string.global_custom_error, 0, 0)
                .config();*/
    }

    public static PlaceHolderManager getPlaceHolderManager() {
        return placeHolderManager;
    }
}
