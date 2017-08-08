package com.mntp;

import android.app.Application;

/**
 * Created by afei on 2017/4/28 0028.
 */
public class App extends Application{

    public static Application app;
    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
    }
}
