package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.internal.class_1072;
import com.google.android.gms.wearable.internal.class_1082;
import com.google.android.gms.wearable.internal.class_190;

public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    // $FF: renamed from: BZ java.lang.String
    private String field_5320;
    // $FF: renamed from: LZ android.os.IBinder
    private IBinder field_5321;
    // $FF: renamed from: NX int
    private volatile int field_5322 = -1;
    private Handler avc;
    private Object avd = new Object();
    private boolean ave;

    // $FF: renamed from: a (com.google.android.gms.wearable.WearableListenerService) java.lang.String
    // $FF: synthetic method
    static String method_5971(WearableListenerService var0) {
        return var0.field_5320;
    }

    // $FF: renamed from: b (com.google.android.gms.wearable.WearableListenerService) void
    // $FF: synthetic method
    static void method_5972(WearableListenerService var0) throws SecurityException {
        var0.method_5977();
    }

    // $FF: renamed from: bc (int) boolean
    private boolean method_5973(int var1) {
        String[] var2 = this.getPackageManager().getPackagesForUid(var1);
        boolean var3 = false;
        if(var2 != null) {
            int var4 = 0;

            while(true) {
                int var5 = var2.length;
                var3 = false;
                if(var4 >= var5) {
                    break;
                }

                if("com.google.android.gms".equals(var2[var4])) {
                    var3 = true;
                    break;
                }

                ++var4;
            }
        }

        return var3;
    }

    // $FF: renamed from: c (com.google.android.gms.wearable.WearableListenerService) java.lang.Object
    // $FF: synthetic method
    static Object method_5974(WearableListenerService var0) {
        return var0.avd;
    }

    // $FF: renamed from: d (com.google.android.gms.wearable.WearableListenerService) boolean
    // $FF: synthetic method
    static boolean method_5975(WearableListenerService var0) {
        return var0.ave;
    }

    // $FF: renamed from: e (com.google.android.gms.wearable.WearableListenerService) android.os.Handler
    // $FF: synthetic method
    static Handler method_5976(WearableListenerService var0) {
        return var0.avc;
    }

    // $FF: renamed from: pU () void
    private void method_5977() throws SecurityException {
        int var1 = Binder.getCallingUid();
        if(var1 != this.field_5322) {
            if(GooglePlayServicesUtil.method_4965(this.getPackageManager(), "com.google.android.gms") && this.method_5973(var1)) {
                this.field_5322 = var1;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
    }

    public final IBinder onBind(Intent var1) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(var1.getAction())?this.field_5321:null;
    }

    public void onCreate() {
        super.onCreate();
        if(Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + this.getPackageName());
        }

        this.field_5320 = this.getPackageName();
        HandlerThread var1 = new HandlerThread("WearableListenerService");
        var1.start();
        this.avc = new Handler(var1.getLooper());
        this.field_5321 = new WearableListenerService.class_1564();
    }

    public void onDataChanged(DataEventBuffer var1) {
    }

    public void onDestroy() {
        // $FF: Couldn't be decompiled
    }

    public void onMessageReceived(MessageEvent var1) {
    }

    public void onPeerConnected(Node var1) {
    }

    public void onPeerDisconnected(Node var1) {
    }

    private class class_1564 extends class_190.class_1376 {
        private class_1564() {
        }

        // $FF: synthetic method
        class_1564(Object var2) {
            this();
        }

        // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
        public void method_923(DataHolder param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ah) void
        public void method_924(class_1082 param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ak) void
        public void method_925(class_1072 param1) {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ak) void
        public void method_926(class_1072 param1) {
            // $FF: Couldn't be decompiled
        }
    }
}
