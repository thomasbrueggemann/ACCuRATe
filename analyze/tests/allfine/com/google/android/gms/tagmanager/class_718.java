package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.tagmanager.class_612;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.tagmanager.a
class class_718 {
    private static class_718 anQ;
    // $FF: renamed from: xz java.lang.Object
    private static Object field_3466 = new Object();
    private volatile long anM;
    private volatile long anN;
    private volatile long anO;
    private class_718.class_1803 anP;
    private volatile boolean mClosed;
    private final Context mContext;
    // $FF: renamed from: wf java.lang.Thread
    private final Thread field_3467;
    // $FF: renamed from: xB com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
    private volatile AdvertisingIdClient.Info field_3468;
    // $FF: renamed from: yD com.google.android.gms.internal.ju
    private final class_20 field_3469;

    private class_718(Context var1) {
        this(var1, (class_718.class_1803)null, class_346.method_2326());
    }

    class_718(Context var1, class_718.class_1803 var2, class_20 var3) {
        this.anM = 900000L;
        this.anN = 30000L;
        this.mClosed = false;
        this.anP = new class_718.class_1803() {
            // $FF: renamed from: nM () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
            public AdvertisingIdClient.Info method_891() {
                try {
                    AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(class_718.this.mContext);
                    return var6;
                } catch (IllegalStateException var7) {
                    class_612.method_3459("IllegalStateException getting Advertising Id Info");
                    return null;
                } catch (GooglePlayServicesRepairableException var8) {
                    class_612.method_3459("GooglePlayServicesRepairableException getting Advertising Id Info");
                    return null;
                } catch (IOException var9) {
                    class_612.method_3459("IOException getting Ad Id Info");
                    return null;
                } catch (GooglePlayServicesNotAvailableException var10) {
                    class_612.method_3459("GooglePlayServicesNotAvailableException getting Advertising Id Info");
                    return null;
                } catch (Exception var11) {
                    class_612.method_3459("Unknown exception. Could not get the Advertising Id Info.");
                    return null;
                }
            }
        };
        this.field_3469 = var3;
        if(var1 != null) {
            this.mContext = var1.getApplicationContext();
        } else {
            this.mContext = var1;
        }

        if(var2 != null) {
            this.anP = var2;
        }

        this.field_3467 = new Thread(new Runnable() {
            public void run() {
                class_718.this.method_3924();
            }
        });
    }

    // $FF: renamed from: W (android.content.Context) com.google.android.gms.tagmanager.a
    static class_718 method_3921(Context param0) {
        // $FF: Couldn't be decompiled
    }

    // $FF: renamed from: nK () void
    private void method_3924() {
        Process.setThreadPriority(10);

        while(!this.mClosed) {
            try {
                this.field_3468 = this.anP.method_891();
                Thread.sleep(this.anM);
            } catch (InterruptedException var2) {
                class_612.method_3457("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }

    }

    // $FF: renamed from: nL () void
    private void method_3925() {
        if(this.field_3469.currentTimeMillis() - this.anO >= this.anN) {
            this.interrupt();
            this.anO = this.field_3469.currentTimeMillis();
        }
    }

    void interrupt() {
        this.field_3467.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        this.method_3925();
        return this.field_3468 == null?true:this.field_3468.isLimitAdTrackingEnabled();
    }

    // $FF: renamed from: nJ () java.lang.String
    public String method_3926() {
        this.method_3925();
        return this.field_3468 == null?null:this.field_3468.getId();
    }

    void start() {
        this.field_3467.start();
    }

    public interface class_1803 {
        // $FF: renamed from: nM () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
        AdvertisingIdClient.Info method_891();
    }
}
