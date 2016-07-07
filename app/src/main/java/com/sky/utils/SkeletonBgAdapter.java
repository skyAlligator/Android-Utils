package com.sky.utils;

public abstract class SkeletonBgAdapter<T> extends BgAdapter {

    @Override
    public void onFinish(boolean success) {
        onFinishWithData(success, getResponse(), getData());
    }

    public abstract T getData();

    public abstract String getResponse();

    public abstract void onFinishWithData(boolean success, String response, T t);


}
