package com.google.tagmanager;

import com.google.tagmanager.LoadCallback;

class TypeOrFailure<T> {
    private LoadCallback.Failure mFailure;
    private T mType;

    public TypeOrFailure(LoadCallback.Failure var1) {
        this.mFailure = var1;
    }

    public TypeOrFailure(T var1) {
        this.mType = var1;
    }

    public LoadCallback.Failure getFailure() {
        return this.mFailure;
    }

    public T getType() {
        return this.mType;
    }
}
