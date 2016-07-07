package com.sky.utils;

import android.util.Log;

/**
 * Created by dinesh on 14/5/16.
 * --------------
 */

/**
 * Log controller
 * Features like passing class object as TAG  EX: Log.d(Anonymous.class,"message");
 */
public class Logger {

    /**
     * flag for log enable/disable.. set this to false when build goes to production.
     */
    private static boolean logEnabled = true;

    /**
     * Only use this method in Non Main thread to differentiate other Application logs
     *
     * @param cls
     * @param txt
     */
    public static void bg(Class<?> cls, String txt) {
        if (logEnabled)
            Log.i(cls.getSimpleName(), "< " + Thread.currentThread().getName() + " >" + txt);
    }

    public static void v(Class<?> cls, String txt) {
        if (logEnabled)
            Log.v(cls.getSimpleName(), txt);
    }

    public static void i(Class<?> cls, String txt) {
        if (logEnabled)
            Log.i(cls.getSimpleName(), txt);
    }

    public static void d(Class<?> cls, String txt) {
        if (logEnabled)
            Log.d(cls.getSimpleName(), txt);
    }

    public static void w(Class<?> cls, String txt) {
        if (logEnabled)
            Log.w(cls.getSimpleName(), txt);
    }

    public static void e(Class<?> cls, Throwable e) {
        if (logEnabled)
            Log.e(cls.getSimpleName(), e.toString(), e);
    }

    public static void e(Class<?> cls, String txt) {
        if (logEnabled)
            Log.e(cls.getSimpleName(), txt);
    }

    public static void p(String txt) {
        if (logEnabled)
            Log.v(Logger.class.getSimpleName(), txt);
    }

    public static void p(Object o) {
        if (logEnabled)
            Log.v(Logger.class.getSimpleName(), String.valueOf(o));
    }


    public static void v(String tag, String txt) {
        if (logEnabled)
            Log.v(tag, txt);
    }

    public static void i(String tag, String txt) {
        if (logEnabled)
            Log.i(tag, txt);
    }

    public static void e(String tag, String txt) {
        if (logEnabled)
            Log.e(tag, txt);
    }

    public static void d(String tag, String txt) {
        if (logEnabled)
            Log.d(tag, txt);
    }

    public static void w(String tag, String txt) {
        if (logEnabled)
            Log.w(tag, txt);
    }

    public static void wtf(String tag, String txt) {
        if (logEnabled)
            Log.wtf(tag, txt);
    }
}
