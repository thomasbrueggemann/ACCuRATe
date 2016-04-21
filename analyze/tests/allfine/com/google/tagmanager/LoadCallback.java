package com.google.tagmanager;

interface LoadCallback<T> {
    void onFailure(LoadCallback.Failure var1);

    void onSuccess(T var1);

    void startLoad();

    public static enum Failure {
        IO_ERROR,
        NOT_AVAILABLE,
        SERVER_ERROR;

        static {
            LoadCallback.Failure[] var0 = new LoadCallback.Failure[]{NOT_AVAILABLE, IO_ERROR, SERVER_ERROR};
        }
    }
}
