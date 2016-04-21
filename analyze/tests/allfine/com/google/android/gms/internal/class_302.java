package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_22;
import com.google.android.gms.internal.hv;

// $FF: renamed from: com.google.android.gms.internal.hy
public class class_302 extends e<hv> {
    public class_302(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
        super(var1, var2, var3, var4, new String[0]);
    }

    // $FF: renamed from: H (android.os.IBinder) com.google.android.gms.internal.hv
    protected class_22 method_2036(IBinder var1) {
        return class_22.class_1367.method_5795(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_966(var2, 6171000, this.getContext().getPackageName());
    }

    // $FF: renamed from: fn () com.google.android.gms.internal.hv
    public class_22 method_2037() {
        return (class_22)this.gS();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2036(var1);
    }
}
