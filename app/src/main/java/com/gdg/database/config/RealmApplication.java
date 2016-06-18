package com.gdg.database.config;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by viphat on 18/06/2016.
 */
public class RealmApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Log.e("debug","Application Started");
        // build realm default configuration
        RealmConfiguration config = new
                RealmConfiguration.Builder(mContext).build();
        Realm.setDefaultConfiguration(config);

    }

    public static Context getContext() {
        return mContext;
    }





}
