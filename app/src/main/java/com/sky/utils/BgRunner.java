package com.sky.utils;

import android.os.Handler;

import java.util.ArrayList;

/**
 * Created by Dinesh BS on 2/25/2016.
 * org HCL tech
 */

/**
 * A Simplified Thread mechanism for an alternate of AsyncTask.
 */
public final class BgRunner extends Thread {

    private static ArrayList<BgRunner> runners = new ArrayList<>();
    private BgAdapter listener;
    private Handler handler;
    private boolean cancel;
    private Object tag;

    /**
     * Accept listener to run background and post results
     *
     * @param listener
     */
    private BgRunner(Object tag, BgAdapter listener) {
        if (listener == null)
            throw new RuntimeException("BgRunner : Listener should not be null for backgroung thread");

        handler = new Handler();
        this.tag = tag;
        this.listener = listener;
        this.listener.onStart();

        setName(tag.toString());
    }

    /**
     * start the thread
     *
     * @param tag
     * @param listener
     * @return returns running thread
     * @author Dinesh BS
     */
    public static BgRunner start(final Object tag, BgAdapter listener) {

        if (tag == null)
            throw new NullPointerException("Tag should not be NULL");

        BgRunner bgRunner = getBgRunner(tag);

        if (bgRunner != null && bgRunner.isAlive()) return bgRunner;

        bgRunner = new BgRunner(tag, listener);
        runners.add(bgRunner);
        bgRunner.start();
        return bgRunner;
    }

    /**
     * get the running thread from the thread pool
     *
     * @param tag
     * @return
     * @author Dinesh BS
     */
    public static BgRunner getBgRunner(final Object tag) {
        return AppCollections.searchItem(runners, new AppCollections.Compare<BgRunner>() {

            @Override
            public boolean forItem(BgRunner runner) {
                return runner.tag.equals(tag);
            }
        });
    }

    public void setListener(BgAdapter listener) {
        this.listener = listener;
    }

    @Override
    public void run() {
        final boolean success = listener.onBg();

        if (cancel) {
            listener.onCancel();
            runners.remove(this);
        } else
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onFinish(success);
                    runners.remove(BgRunner.this);
                }
            });
    }

    /**
     * cancel the pending background thread actions(doesn't call onFinish()).
     */
    public void cancel() {
        this.cancel = true;
    }

}
