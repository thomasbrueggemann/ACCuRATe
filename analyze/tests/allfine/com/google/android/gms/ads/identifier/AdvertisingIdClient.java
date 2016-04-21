package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.class_949;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.internal.class_65;
import java.io.IOException;

public final class AdvertisingIdClient {
    // $FF: renamed from: lk com.google.android.gms.common.a
    class_949 field_3403;
    // $FF: renamed from: ll com.google.android.gms.internal.s
    class_65 field_3404;
    // $FF: renamed from: lm boolean
    boolean field_3405;
    final Context mContext;

    public AdvertisingIdClient(Context var1) {
        class_1090.method_5685(var1);
        this.mContext = var1;
        this.field_3405 = false;
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.common.a) com.google.android.gms.internal.s
    static class_65 method_3848(Context var0, class_949 var1) throws IOException {
        try {
            class_65 var3 = class_65.class_1413.method_5917(var1.method_4986());
            return var3;
        } catch (InterruptedException var4) {
            throw new IOException("Interrupted exception");
        }
    }

    public static AdvertisingIdClient.Info getAdvertisingIdInfo(Context var0) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient var1 = new AdvertisingIdClient(var0);

        AdvertisingIdClient.Info var3;
        try {
            var1.start();
            var3 = var1.method_3850();
        } finally {
            var1.finish();
        }

        return var3;
    }

    // $FF: renamed from: i (android.content.Context) com.google.android.gms.common.a
    static class_949 method_3849(Context var0) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            var0.getPackageManager().getPackageInfo("com.android.vending", 0);
        } catch (NameNotFoundException var7) {
            throw new GooglePlayServicesNotAvailableException(9);
        }

        try {
            GooglePlayServicesUtil.method_4955(var0);
        } catch (GooglePlayServicesNotAvailableException var6) {
            throw new IOException(var6);
        }

        class_949 var4 = new class_949();
        Intent var5 = new Intent("com.google.android.gms.ads.identifier.service.START");
        var5.setPackage("com.google.android.gms");
        if(var0.bindService(var5, var4, 1)) {
            return var4;
        } else {
            throw new IOException("Connection failure");
        }
    }

    // $FF: renamed from: W () com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
    public AdvertisingIdClient.Info method_3850() throws IOException {
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        class_1090.method_5685(this.field_3403);
        class_1090.method_5685(this.field_3404);
        if(!this.field_3405) {
            throw new IOException("AdvertisingIdService is not connected.");
        } else {
            try {
                AdvertisingIdClient.Info var3 = new AdvertisingIdClient.Info(this.field_3404.getId(), this.field_3404.method_316(true));
                return var3;
            } catch (RemoteException var5) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", var5);
                throw new IOException("Remote exception");
            }
        }
    }

    public void finish() {
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        if(this.mContext != null && this.field_3403 != null) {
            try {
                if(this.field_3405) {
                    this.mContext.unbindService(this.field_3403);
                }
            } catch (IllegalArgumentException var2) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", var2);
            }

            this.field_3405 = false;
            this.field_3404 = null;
            this.field_3403 = null;
        }
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        class_1090.method_5679("Calling this from your main thread can lead to deadlock");
        if(this.field_3405) {
            this.finish();
        }

        this.field_3403 = method_3849(this.mContext);
        this.field_3404 = method_3848(this.mContext, this.field_3403);
        this.field_3405 = true;
    }

    public static final class Info {
        // $FF: renamed from: ln java.lang.String
        private final String field_5263;
        // $FF: renamed from: lo boolean
        private final boolean field_5264;

        public Info(String var1, boolean var2) {
            this.field_5263 = var1;
            this.field_5264 = var2;
        }

        public String getId() {
            return this.field_5263;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.field_5264;
        }

        public String toString() {
            return "{" + this.field_5263 + "}" + this.field_5264;
        }
    }
}
