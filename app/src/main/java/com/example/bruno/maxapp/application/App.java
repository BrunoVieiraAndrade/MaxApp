package com.example.bruno.maxapp.application;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App extends Application {

    static Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        gson = new GsonBuilder().create();
    }

    public static Gson getGson(){
        return gson;
    }
}
