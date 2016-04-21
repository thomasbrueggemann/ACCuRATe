package com.google.android.gms.internal;

import com.google.android.gms.internal.class_384;
import com.google.android.gms.internal.ez;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

// $FF: renamed from: com.google.android.gms.internal.go
@ez
public class class_368 {
    // $FF: renamed from: wy com.google.android.gms.internal.go$a
    public static final class_368.class_1521<Void> field_1343 = new class_368.class_1521() {
        // $FF: renamed from: b (java.io.InputStream) java.lang.Object
        // $FF: synthetic method
        public Object method_376(InputStream var1) {
            return this.method_3852(var1);
        }

        // $FF: renamed from: c (java.io.InputStream) java.lang.Void
        public Void method_3852(InputStream var1) {
            return null;
        }

        // $FF: renamed from: cJ () java.lang.Object
        // $FF: synthetic method
        public Object method_377() {
            return this.method_3853();
        }

        // $FF: renamed from: dq () java.lang.Void
        public Void method_3853() {
            return null;
        }
    };

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.go$a) java.util.concurrent.Future
    public <T> Future<T> method_2416(final String var1, final class_368.class_1521<T> var2) {
        return class_384.submit(new Callable() {
            public T call() {
                // $FF: Couldn't be decompiled
            }
        });
    }

    public interface class_1521<T> {
        // $FF: renamed from: b (java.io.InputStream) java.lang.Object
        T method_376(InputStream var1);

        // $FF: renamed from: cJ () java.lang.Object
        T method_377();
    }
}
