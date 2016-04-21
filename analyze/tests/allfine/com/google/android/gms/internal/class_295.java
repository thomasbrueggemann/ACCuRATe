package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_161;
import com.google.android.gms.internal.nb;

// $FF: renamed from: com.google.android.gms.internal.nd
public class class_295 extends e<nb> {
    public class_295(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4) {
        super(var1, var2, var3, var4, (String[])null);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        var1.method_957(var2, 6171000, this.getContext().getPackageName(), var3);
    }

    // $FF: renamed from: bB (android.os.IBinder) com.google.android.gms.internal.nb
    public class_161 method_1863(IBinder var1) {
        return class_161.class_1175.method_2186(var1);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.panorama.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    public IInterface method_1820(IBinder var1) {
        return this.method_1863(var1);
    }
}
