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
import com.google.android.gms.internal.class_156;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kp;

// $FF: renamed from: com.google.android.gms.internal.kl
public class class_297 extends e<kp> implements kk {
    // $FF: renamed from: Dd java.lang.String
    private final String field_893;

    public class_297(Context var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
        super(var1, var2, var3, var4, var6);
        this.field_893 = var5;
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_962(var2, 6171000, this.getContext().getPackageName(), this.field_893, this.gR(), new Bundle());
    }

    // $FF: renamed from: ao (android.os.IBinder) com.google.android.gms.internal.kp
    protected class_156 method_1870(IBinder var1) {
        return class_156.class_1201.method_2415(var1);
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.fitness.internal.IGoogleFitnessService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.fitness.GoogleFitnessService.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1870(var1);
    }

    // $FF: renamed from: jb () com.google.android.gms.internal.kp
    public class_156 method_372() {
        return (class_156)this.gS();
    }
}
