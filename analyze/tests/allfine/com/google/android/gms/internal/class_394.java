package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.BaseImplementation;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_22;
import com.google.android.gms.internal.class_24;
import com.google.android.gms.internal.class_302;
import com.google.android.gms.internal.class_397;
import com.google.android.gms.internal.class_414;
import com.google.android.gms.internal.hs;
import com.google.android.gms.internal.hx;
import com.google.android.gms.internal.hy;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hz
public final class class_394 implements AppIndexApi, class_24 {
    // $FF: renamed from: a (java.lang.String, android.net.Uri) android.net.Uri
    public static Uri method_2598(String var0, Uri var1) {
        if(!"android-app".equals(var1.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + var1);
        } else if(!var0.equals(var1.getHost())) {
            throw new IllegalArgumentException("Uri host must match package name: " + var1);
        } else {
            List var2 = var1.getPathSegments();
            if(!var2.isEmpty() && !((String)var2.get(0)).isEmpty()) {
                String var3 = (String)var2.get(0);
                Builder var4 = new Builder();
                var4.scheme(var3);
                if(var2.size() > 1) {
                    var4.authority((String)var2.get(1));

                    for(int var9 = 2; var9 < var2.size(); ++var9) {
                        var4.appendPath((String)var2.get(var9));
                    }
                }

                var4.encodedQuery(var1.getEncodedQuery());
                var4.encodedFragment(var1.getEncodedFragment());
                return var4.build();
            } else {
                throw new IllegalArgumentException("Uri path must exist: " + var1);
            }
        }
    }

    // $FF: renamed from: a (com.google.android.gms.common.api.GoogleApiClient, com.google.android.gms.internal.hs[]) com.google.android.gms.common.api.PendingResult
    public PendingResult<Status> method_2599(GoogleApiClient var1, final hs... var2) {
        return var1.method_897(new class_394.class_1573(null) {
            // $FF: renamed from: CJ java.lang.String
            // $FF: synthetic field
            final String field_95;

            {
                this.field_95 = var2x;
            }

            // $FF: renamed from: a (com.google.android.gms.internal.hv) void
            protected void method_1202(class_22 var1) throws RemoteException {
                var1.method_141(new class_394.class_1572(this), this.field_95, var2);
            }
        });
    }

    public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Intent var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
        String var7 = ((class_302)var1.method_896(class_414.field_1535)).getContext().getPackageName();
        class_397[] var8 = new class_397[] {new class_397(var7, var3, var4, var5, (String)null, var6)};
        return this.method_2599(var1, var8);
    }

    public PendingResult<Status> view(GoogleApiClient var1, Activity var2, Uri var3, String var4, Uri var5, List<AppIndexApi.AppIndexingLink> var6) {
        return this.view(var1, var2, new Intent("android.intent.action.VIEW", method_2598(((class_302)var1.method_896(class_414.field_1535)).getContext().getPackageName(), var3)), var4, var5, var6);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Intent var3) {
        return this.method_2599(var1, new class_397[] {new class_397(class_397.method_2616(((class_302)var1.method_896(class_414.field_1535)).getContext().getPackageName(), var3), System.currentTimeMillis(), 3)});
    }

    public PendingResult<Status> viewEnd(GoogleApiClient var1, Activity var2, Uri var3) {
        return this.viewEnd(var1, var2, new Intent("android.intent.action.VIEW", method_2598(((class_302)var1.method_896(class_414.field_1535)).getContext().getPackageName(), var3)));
    }

    private abstract static class class_1576<T> implements Result {
        // $FF: renamed from: CM com.google.android.gms.common.api.Status
        private final Status field_3464;
        // $FF: renamed from: CN java.lang.Object
        protected final T field_3465;

        public class_1576(Status var1, T var2) {
            this.field_3464 = var1;
            this.field_3465 = var2;
        }

        public Status getStatus() {
            return this.field_3464;
        }
    }

    static class class_1575 extends class_394.class_1576<ParcelFileDescriptor> implements class_24.class_1456 {
        public class_1575(Status var1, ParcelFileDescriptor var2) {
            super(var1, var2);
        }
    }

    private abstract static class class_1574<T extends Result> extends BaseImplementation.class_1146<T, hy> {
        public class_1574() {
            super(class_414.field_1535);
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hv) void
        protected abstract void method_1202(class_22 var1) throws RemoteException;

        // $FF: renamed from: a (com.google.android.gms.internal.hy) void
        protected final void method_1203(class_302 var1) throws RemoteException {
            this.method_1202(var1.method_2037());
        }
    }

    private abstract static class class_1573<T extends Result> extends class_394.class_1574<Status> {
        private class_1573() {
        }

        // $FF: synthetic method
        class_1573(Object var1) {
            this();
        }

        // $FF: renamed from: c (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Result
        // $FF: synthetic method
        protected Result method_1104(Status var1) {
            return this.method_1205(var1);
        }

        // $FF: renamed from: d (com.google.android.gms.common.api.Status) com.google.android.gms.common.api.Status
        protected Status method_1205(Status var1) {
            return var1;
        }
    }

    private static final class class_1572 extends hx<Status> {
        public class_1572(BaseImplementation.class_1147<Status> var1) {
            super(var1);
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
        public void method_144(Status var1) {
            this.CH.method_120(var1);
        }
    }
}
