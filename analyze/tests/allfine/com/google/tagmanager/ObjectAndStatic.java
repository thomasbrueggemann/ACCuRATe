package com.google.tagmanager;

class ObjectAndStatic<T> {
    private final boolean mIsStatic;
    private final T mObject;

    ObjectAndStatic(T var1, boolean var2) {
        this.mObject = var1;
        this.mIsStatic = var2;
    }

    public T getObject() {
        return this.mObject;
    }

    public boolean isStatic() {
        return this.mIsStatic;
    }
}
