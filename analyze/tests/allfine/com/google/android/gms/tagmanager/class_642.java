package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.tagmanager.class_610;
import com.google.android.gms.tagmanager.class_612;
import com.google.android.gms.tagmanager.class_619;
import com.google.android.gms.tagmanager.class_641;
import com.google.android.gms.tagmanager.class_72;
import com.google.android.gms.tagmanager.class_73;
import com.google.android.gms.tagmanager.class_75;

// $FF: renamed from: com.google.android.gms.tagmanager.cy
class class_642 extends class_641 {
    private static class_642 arA;
    // $FF: renamed from: yc java.lang.Object
    private static final Object field_3170 = new Object();
    private Context arq;
    private class_72 arr;
    private volatile class_75 ars;
    private int art = 1800000;
    private boolean aru = true;
    private boolean arv = false;
    private boolean arw = true;
    private class_73 arx = new class_73() {
        // $FF: renamed from: z (boolean) void
        public void method_340(boolean var1) {
            class_642.this.method_3631(var1, class_642.this.connected);
        }
    };
    private class_610 ary;
    private boolean arz = false;
    private boolean connected = true;
    private Handler handler;

    // $FF: renamed from: ea () void
    private void method_3626() {
        this.ary = new class_610(this);
        this.ary.method_3452(this.arq);
    }

    // $FF: renamed from: eb () void
    private void method_3627() {
        this.handler = new Handler(this.arq.getMainLooper(), new Callback() {
            public boolean handleMessage(Message var1) {
                if(1 == var1.what && class_642.field_3170.equals(var1.obj)) {
                    class_642.this.dispatch();
                    if(class_642.this.art > 0 && !class_642.this.arz) {
                        class_642.this.handler.sendMessageDelayed(class_642.this.handler.obtainMessage(1, class_642.field_3170), (long)class_642.this.art);
                    }
                }

                return true;
            }
        });
        if(this.art > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, field_3170), (long)this.art);
        }

    }

    // $FF: renamed from: pw () com.google.android.gms.tagmanager.cy
    public static class_642 method_3629() {
        if(arA == null) {
            arA = new class_642();
        }

        return arA;
    }

    // $FF: renamed from: A (boolean) void
    void method_3619(boolean var1) {
        synchronized(this) {}

        try {
            this.method_3631(this.arz, var1);
        } finally {
            ;
        }

    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.tagmanager.ar) void
    void method_3630(Context param1, class_75 param2) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: a (boolean, boolean) void
    void method_3631(boolean param1, boolean param2) {
        // $FF: Couldn't be decompiled
    }

    public void dispatch() {
        synchronized(this) {}

        try {
            if(!this.arv) {
                class_612.method_3458("Dispatch call queued. Dispatch will run once initialization is complete.");
                this.aru = true;
            } else {
                this.ars.method_343(new Runnable() {
                    public void run() {
                        class_642.this.arr.dispatch();
                    }
                });
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: ed () void
    void method_3620() {
        synchronized(this) {}

        try {
            if(!this.arz && this.connected && this.art > 0) {
                this.handler.removeMessages(1, field_3170);
                this.handler.sendMessage(this.handler.obtainMessage(1, field_3170));
            }
        } finally {
            ;
        }

    }

    // $FF: renamed from: px () com.google.android.gms.tagmanager.at
    class_72 method_3632() {
        synchronized(this) {}

        class_72 var2;
        try {
            if(this.arr == null) {
                if(this.arq == null) {
                    throw new IllegalStateException("Cant get a store unless we have a context");
                }

                this.arr = new class_619(this.arx, this.arq);
            }

            if(this.handler == null) {
                this.method_3627();
            }

            this.arv = true;
            if(this.aru) {
                this.dispatch();
                this.aru = false;
            }

            if(this.ary == null && this.arw) {
                this.method_3626();
            }

            var2 = this.arr;
        } finally {
            ;
        }

        return var2;
    }
}
