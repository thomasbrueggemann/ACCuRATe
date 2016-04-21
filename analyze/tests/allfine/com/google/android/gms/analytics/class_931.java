package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.analytics.class_173;
import com.google.android.gms.analytics.class_174;
import com.google.android.gms.analytics.class_175;
import com.google.android.gms.analytics.class_930;
import com.google.android.gms.analytics.class_934;
import com.google.android.gms.analytics.class_938;
import com.google.android.gms.analytics.class_940;
import com.google.android.gms.analytics.class_951;

// $FF: renamed from: com.google.android.gms.analytics.q
class class_931 extends class_930 {
    // $FF: renamed from: yc java.lang.Object
    private static final Object field_4248 = new Object();
    // $FF: renamed from: yo com.google.android.gms.analytics.q
    private static class_931 field_4249;
    private Context mContext;
    private Handler mHandler;
    // $FF: renamed from: yd com.google.android.gms.analytics.d
    private class_175 field_4250;
    // $FF: renamed from: ye com.google.android.gms.analytics.f
    private volatile class_174 field_4251;
    // $FF: renamed from: yf int
    private int field_4252 = 1800;
    // $FF: renamed from: yg boolean
    private boolean field_4253 = true;
    // $FF: renamed from: yh boolean
    private boolean field_4254;
    // $FF: renamed from: yi java.lang.String
    private String field_4255;
    // $FF: renamed from: yj boolean
    private boolean field_4256 = true;
    // $FF: renamed from: yk boolean
    private boolean field_4257 = true;
    // $FF: renamed from: yl com.google.android.gms.analytics.e
    private class_173 field_4258 = new class_173() {
        // $FF: renamed from: z (boolean) void
        public void method_818(boolean var1) {
            class_931.this.method_4819(var1, class_931.this.field_4256);
        }
    };
    // $FF: renamed from: ym com.google.android.gms.analytics.p
    private class_934 field_4259;
    // $FF: renamed from: yn boolean
    private boolean field_4260 = false;

    // $FF: renamed from: dZ () com.google.android.gms.analytics.q
    public static class_931 method_4814() {
        if(field_4249 == null) {
            field_4249 = new class_931();
        }

        return field_4249;
    }

    // $FF: renamed from: ea () void
    private void method_4815() {
        this.field_4259 = new class_934(this);
        this.field_4259.method_4842(this.mContext);
    }

    // $FF: renamed from: eb () void
    private void method_4816() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new Callback() {
            public boolean handleMessage(Message var1) {
                if(1 == var1.what && class_931.field_4248.equals(var1.obj)) {
                    class_940.method_4863().method_4864(true);
                    class_931.this.dispatchLocalHits();
                    class_940.method_4863().method_4864(false);
                    if(class_931.this.field_4252 > 0 && !class_931.this.field_4260) {
                        class_931.this.mHandler.sendMessageDelayed(class_931.this.mHandler.obtainMessage(1, class_931.field_4248), (long)(1000 * class_931.this.field_4252));
                    }
                }

                return true;
            }
        });
        if(this.field_4252 > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, field_4248), (long)(1000 * this.field_4252));
        }

    }

    // $FF: renamed from: A (boolean) void
    void method_4808(boolean var1) {
        synchronized(this) {}

        try {
            this.method_4819(this.field_4260, var1);
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.analytics.f) void
    void method_4818(Context param1, class_174 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (boolean, boolean) void
    void method_4819(boolean param1, boolean param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: dN () void
    void method_4820() {
        if(this.field_4251 == null) {
            class_938.method_4860("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.field_4254 = true;
        } else {
            class_940.method_4863().method_4865(class_940.class_1617.field_4908);
            this.field_4251.method_820();
        }
    }

    void dispatchLocalHits() {
        synchronized(this) {}

        try {
            if(this.field_4251 == null) {
                class_938.method_4860("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.field_4253 = true;
            } else {
                class_940.method_4863().method_4865(class_940.class_1617.field_4938);
                this.field_4251.dispatch();
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: ec () com.google.android.gms.analytics.d
    class_175 method_4821() {
        synchronized(this) {}

        class_175 var2;
        try {
            if(this.field_4250 == null) {
                if(this.mContext == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }

                this.field_4250 = new class_951(this.field_4258, this.mContext);
                if(this.field_4255 != null) {
                    this.field_4250.method_824().method_827(this.field_4255);
                    this.field_4255 = null;
                }
            }

            if(this.mHandler == null) {
                this.method_4816();
            }

            if(this.field_4259 == null && this.field_4257) {
                this.method_4815();
            }

            var2 = this.field_4250;
        } finally {
            ;
        }

        return var2;
    }

    // $FF: renamed from: ed () void
    void method_4809() {
        synchronized(this) {}

        try {
            if(!this.field_4260 && this.field_4256 && this.field_4252 > 0) {
                this.mHandler.removeMessages(1, field_4248);
                this.mHandler.sendMessage(this.mHandler.obtainMessage(1, field_4248));
            }
        } finally {
            ;
        }

    }

    void setLocalDispatchPeriod(int param1) {
        // $FF: Couldn't be decompiled
    }
}
