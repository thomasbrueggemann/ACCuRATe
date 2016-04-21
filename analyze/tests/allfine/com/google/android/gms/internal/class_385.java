package com.google.android.gms.internal;

import com.google.android.gms.internal.ez;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.gl
@ez
public class class_385<T> implements Future<T> {
    // $FF: renamed from: wq java.lang.Object
    private final T field_1410;

    public class_385(T var1) {
        this.field_1410 = var1;
    }

    public boolean cancel(boolean var1) {
        return false;
    }

    public T get() {
        return this.field_1410;
    }

    public T get(long var1, TimeUnit var3) {
        return this.field_1410;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }
}
