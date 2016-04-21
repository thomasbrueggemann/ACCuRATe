package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_160;
import com.google.android.gms.internal.class_161;
import com.google.android.gms.internal.class_295;
import com.google.android.gms.internal.class_877;
import com.google.android.gms.internal.class_878;
import com.google.android.gms.internal.nd;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

// $FF: renamed from: com.google.android.gms.internal.nc
public class class_879 implements PanoramaApi {
    // $FF: renamed from: a (android.content.Context, android.net.Uri) void
    private static void method_4550(Context var0, Uri var1) {
        var0.revokeUriPermission(var1, 1);
    }

    // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.nb, com.google.android.gms.internal.na, android.net.Uri, android.os.Bundle) void
    private static void method_4551(final Context var0, class_161 var1, final class_160 var2, final Uri var3, Bundle var4) throws RemoteException {
        var0.grantUriPermission("com.google.android.gms", var3, 1);
        class_160.class_1354 var5 = new class_160.class_1354() {
            // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
            public void method_793(int var1, Bundle var2x, int var3x, Intent var4) throws RemoteException {
                class_879.method_4550(var0, var3);
                var2.method_793(var1, var2x, var3x, var4);
            }
        };

        try {
            var1.method_794(var5, var3, var4, true);
        } catch (RemoteException var8) {
            method_4550(var0, var3);
            throw var8;
        } catch (RuntimeException var9) {
            method_4550(var0, var3);
            throw var9;
        }
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient var1, final Uri var2) {
        return var1.method_897(new class_879.class_1754(null) {
            // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.nb) void
            protected void method_1144(Context var1, class_161 var2x) throws RemoteException {
                var2x.method_794(new class_879.class_1745(this), var2, (Bundle)null, false);
            }
        });
    }

    public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient var1, final Uri var2) {
        return var1.method_897(new class_879.class_1754(null) {
            // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.nb) void
            protected void method_1144(Context var1, class_161 var2x) throws RemoteException {
                class_879.method_4551(var1, var2x, new class_879.class_1745(this), var2, (Bundle)null);
            }
        });
    }

    private static final class class_1755 extends class_160.class_1354 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<PanoramaApi.class_1676> field_2870;

        public class_1755(BaseImplementation.class_1147<PanoramaApi.class_1676> var1) {
            this.field_2870 = var1;
        }

        // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
        public void method_793(int var1, Bundle var2, int var3, Intent var4) {
            PendingIntent var5;
            if(var2 != null) {
                var5 = (PendingIntent)var2.getParcelable("pendingIntent");
            } else {
                var5 = null;
            }

            Status var6 = new Status(var1, (String)null, var5);
            this.field_2870.method_120(new class_878(var6, var4, var3));
        }
    }

    private abstract static class class_1754 extends class_879.class_1744<PanoramaApi.PanoramaResult> {
        private class_1754() {
        }

        // $FF: synthetic method
        class_1754(Object var1) {
            this();
        }

        // $FF: renamed from: az (com.google.android.gms.common.api.Status) com.google.android.gms.panorama.PanoramaApi$PanoramaResult
        protected PanoramaApi.PanoramaResult method_1146(Status var1) {
            return new class_877(var1, (Intent)null);
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1146(var1);
        }
    }

    private static final class class_1745 extends class_160.class_1354 {
        // $FF: renamed from: De com.google.android.gms.common.api.BaseImplementation$b
        private final BaseImplementation.class_1147<PanoramaApi.PanoramaResult> field_2871;

        public class_1745(BaseImplementation.class_1147<PanoramaApi.PanoramaResult> var1) {
            this.field_2871 = var1;
        }

        // $FF: renamed from: a (int, android.os.Bundle, int, android.content.Intent) void
        public void method_793(int var1, Bundle var2, int var3, Intent var4) {
            PendingIntent var5;
            if(var2 != null) {
                var5 = (PendingIntent)var2.getParcelable("pendingIntent");
            } else {
                var5 = null;
            }

            Status var6 = new Status(var1, (String)null, var5);
            this.field_2871.method_120(new class_877(var6, var4));
        }
    }

    private abstract static class class_1744<R extends Result> extends BaseImplementation.class_1146<R, nd> {
        protected class_1744() {
            super(Panorama.field_5150);
        }

        // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.nb) void
        protected abstract void method_1144(Context var1, class_161 var2) throws RemoteException;

        // $FF: renamed from: a (com.google.android.gms.internal.nd) void
        protected final void method_1145(class_295 var1) throws RemoteException {
            this.method_1144(var1.getContext(), (class_161)var1.gS());
        }
    }
}
