package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.class_197;
import com.google.android.gms.drive.internal.class_266;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    // $FF: renamed from: NV java.util.concurrent.CountDownLatch
    private CountDownLatch field_1039;
    // $FF: renamed from: NW com.google.android.gms.drive.events.DriveEventService$a
    DriveEventService.class_1177 field_1040;
    // $FF: renamed from: NX int
    int field_1041;
    private final String mName;

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String var1) {
        this.field_1041 = -1;
        this.mName = var1;
    }

    // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEventService) void
    // $FF: synthetic method
    static void method_2214(DriveEventService var0) throws SecurityException {
        var0.method_2219();
    }

    // $FF: renamed from: a (com.google.android.gms.drive.internal.OnEventResponse) void
    private void method_2216(OnEventResponse var1) {
        DriveEvent var2 = var1.method_3527();
        class_266.method_1685("DriveEventService", "handleEventMessage: " + var2);

        try {
            switch(var2.getType()) {
                case 1:
                    this.onChange((ChangeEvent)var2);
                    return;
                case 2:
                    this.onCompletion((CompletionEvent)var2);
                    return;
                default:
                    class_266.method_1686(this.mName, "Unhandled event: " + var2);
            }
        } catch (Exception var4) {
            class_266.method_1683(this.mName, var4, "Error handling event: " + var2);
        }
    }

    // $FF: renamed from: bc (int) boolean
    private boolean method_2218(int var1) {
        String[] var2 = this.getPackageManager().getPackagesForUid(var1);
        boolean var3 = false;
        if(var2 != null) {
            int var4 = var2.length;
            int var5 = 0;

            while(true) {
                var3 = false;
                if(var5 >= var4) {
                    break;
                }

                if("com.google.android.gms".equals(var2[var5])) {
                    var3 = true;
                    break;
                }

                ++var5;
            }
        }

        return var3;
    }

    // $FF: renamed from: hV () void
    private void method_2219() throws SecurityException {
        int var1 = this.getCallingUid();
        if(var1 != this.field_1041) {
            if(GooglePlayServicesUtil.method_4965(this.getPackageManager(), "com.google.android.gms") && this.method_2218(var1)) {
                this.field_1041 = var1;
            } else {
                throw new SecurityException("Caller is not GooglePlayServices");
            }
        }
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final IBinder onBind(Intent var1) {
        synchronized(this) {}
        boolean var10 = false;

        IBinder var3;
        IBinder var7;
        label79: {
            try {
                var10 = true;
                if("com.google.android.gms.drive.events.HANDLE_EVENT".equals(var1.getAction())) {
                    if(this.field_1040 == null) {
                        final CountDownLatch var4 = new CountDownLatch(1);
                        this.field_1039 = new CountDownLatch(1);
                        (new Thread() {
                            public void run() {
                                try {
                                    Looper.prepare();
                                    DriveEventService.this.field_1040 = DriveEventService.this.new class_1177();
                                    var4.countDown();
                                    class_266.method_1685("DriveEventService", "Bound and starting loop");
                                    Looper.loop();
                                    class_266.method_1685("DriveEventService", "Finished loop");
                                } finally {
                                    DriveEventService.this.field_1039.countDown();
                                }

                            }
                        }).start();

                        try {
                            var4.await(5000L, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException var11) {
                            throw new RuntimeException("Unable to start event handler", var11);
                        }
                    }

                    var7 = (new DriveEventService.class_1178()).asBinder();
                    var10 = false;
                    break label79;
                }

                var10 = false;
            } finally {
                if(var10) {
                    ;
                }
            }

            var3 = null;
            return var3;
        }

        var3 = var7;
        return var3;
    }

    public void onChange(ChangeEvent var1) {
        class_266.method_1686(this.mName, "Unhandled change event: " + var1);
    }

    public void onCompletion(CompletionEvent var1) {
        class_266.method_1686(this.mName, "Unhandled completion event: " + var1);
    }

    public void onDestroy() {
        synchronized(this) {}

        try {
            class_266.method_1685("DriveEventService", "onDestroy");
            if(this.field_1040 != null) {
                Message var2 = this.field_1040.method_5636();
                this.field_1040.sendMessage(var2);
                this.field_1040 = null;

                try {
                    this.field_1039.await(5000L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException var7) {
                    ;
                }

                this.field_1039 = null;
            }

            super.onDestroy();
        } finally {
            ;
        }

    }

    public boolean onUnbind(Intent var1) {
        return true;
    }

    final class class_1177 extends Handler {
        // $FF: renamed from: a (com.google.android.gms.drive.events.DriveEventService$a, com.google.android.gms.drive.internal.OnEventResponse) android.os.Message
        // $FF: synthetic method
        static Message method_5634(DriveEventService.class_1177 var0, OnEventResponse var1) {
            return var0.method_5635(var1);
        }

        // $FF: renamed from: b (com.google.android.gms.drive.internal.OnEventResponse) android.os.Message
        private Message method_5635(OnEventResponse var1) {
            return this.obtainMessage(1, var1);
        }

        // $FF: renamed from: hW () android.os.Message
        private Message method_5636() {
            return this.obtainMessage(2);
        }

        public void handleMessage(Message var1) {
            class_266.method_1685("DriveEventService", "handleMessage message type:" + var1.what);
            switch(var1.what) {
                case 1:
                    DriveEventService.this.method_2216((OnEventResponse)var1.obj);
                    return;
                case 2:
                    this.getLooper().quit();
                    return;
                default:
                    class_266.method_1686("DriveEventService", "Unexpected message type:" + var1.what);
            }
        }
    }

    final class class_1178 extends class_197.class_1305 {
        // $FF: renamed from: c (com.google.android.gms.drive.internal.OnEventResponse) void
        public void method_1000(OnEventResponse param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
