package com.digi.portal.mobdev.android.aphone.helper;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Dinesh on 12/04/16.
 * Hcl
 */
/**
 * Preference helper class for easy access.
 */
public class PreferenceUtil {

	private static SharedPreferences preferences;

	/**
	 * initiate preference(usually in application class)
	 * 
	 * @param context
	 */
	public static void init(Application context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(context);
	}

	public static void save(String key, String val) {
		preferences.edit().putString(key, val).apply();
	}

	public static void save(String key, int val) {
		preferences.edit().putInt(key, val).apply();
	}

	public static void save(String key, boolean val) {
		preferences.edit().putBoolean(key, val).apply();
	}

	public static SharedPreferences getPref() {
		if (preferences == null)
			throw new RuntimeException("call init once before getPref");
		return preferences;
	}
}
