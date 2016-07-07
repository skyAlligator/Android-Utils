package com.sky.utils;

/**
 * Created by Dinesh BS on 2/25/2016.
 * org HCL tech
 */

/**
 * Adapter for BgRunner Util class
 */
public abstract class BgAdapter {

    public void onStart() {
    }

    public abstract boolean onBg();

    public void onFinish(boolean success) {
    }

    public void onCancel() {
    }
}
