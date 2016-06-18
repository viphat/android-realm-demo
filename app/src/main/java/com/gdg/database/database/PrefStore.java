package com.gdg.database.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by viphat on 18/06/2016.
 */
public class PrefStore {
    private static final String PREF_SORT_TYPE = "pref_sort_type";
    private static final int DEFAULT_SORT_TYPE = 0;

    public static int getSortType(Context context) {
        SharedPreferences preferences = PreferenceManager.
                getDefaultSharedPreferences(context);
        return preferences.getInt(PREF_SORT_TYPE, DEFAULT_SORT_TYPE);
    }

    public static void setSortType(Context context, int sortType) {
        SharedPreferences preferences = PreferenceManager.
                getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREF_SORT_TYPE, sortType);
        editor.commit();
    }


}
