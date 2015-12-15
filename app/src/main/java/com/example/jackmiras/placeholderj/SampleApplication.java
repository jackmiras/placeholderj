package com.example.jackmiras.placeholderj;

import android.app.Application;

import com.example.jackmiras.placeholderj.library.PlaceHolderManager;

/**
 * Created by jackson on 14/12/15.
 */
public class SampleApplication extends Application{

    PlaceHolderManager.Configurator configurator;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
