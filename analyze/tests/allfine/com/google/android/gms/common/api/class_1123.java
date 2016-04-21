package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.class_1090;

// $FF: renamed from: com.google.android.gms.common.api.c
public final class class_1123<L> {
    // $FF: renamed from: Js com.google.android.gms.common.api.c$a
    private final com/google/android/gms/common/api/c<L>.a field_5192;
    private volatile L mListener;

    class_1123(Looper var1, L var2) {
        this.field_5192 = new class_1123.class_1386(var1);
        this.mListener = class_1090.method_5681(var2, "Listener must not be null");
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.c$b) void
    public void method_5817(class_1123.class_1385<L> var1) {
        class_1090.method_5681(var1, "Notifier must not be null");
        Message var3 = this.field_5192.obtainMessage(1, var1);
        this.field_5192.sendMessage(var3);
    }

    // $FF: renamed from: b (com.google.android.gms.common.api.c$b) void
    void method_5818(class_1123.class_1385<L> var1) {
        Object var2 = this.mListener;
        if(var2 == null) {
            var1.method_325();
        } else {
            try {
                var1.method_324(var2);
            } catch (Exception var4) {
                Log.w("ListenerHolder", "Notifying listener failed", var4);
                var1.method_325();
            }
        }
    }

    public void clear() {
        this.mListener = null;
    }

    private final class class_1386 extends Handler {
        public class_1386(Looper var2) {
            super(var2);
        }

        public void handleMessage(Message var1) {
            byte var2 = 1;
            if(var1.what != var2) {
                var2 = 0;
            }

            class_1090.method_5675((boolean)var2);
            class_1123.this.method_5818((class_1123.class_1385)var1.obj);
        }
    }

    public interface class_1385<L> {
        // $FF: renamed from: d (java.lang.Object) void
        void method_324(L var1);

        // $FF: renamed from: gr () void
        void method_325();
    }
}
