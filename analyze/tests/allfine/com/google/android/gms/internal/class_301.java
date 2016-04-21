package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.internal.class_37;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fm;

// $FF: renamed from: com.google.android.gms.internal.fh
@ez
public class class_301 extends e<fm> {
    // $FF: renamed from: pP int
    final int field_911;

    public class_301(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, int var4) {
        super(var1, var2, var3, new String[0]);
        this.field_911 = var4;
    }

    // $FF: renamed from: C (android.os.IBinder) com.google.android.gms.internal.fm
    protected class_37 method_2034(IBinder var1) {
        return class_37.class_1335.method_2757(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        var1.method_978(var2, this.field_911, this.getContext().getPackageName(), var3);
    }

    // $FF: renamed from: cE () com.google.android.gms.internal.fm
    public class_37 method_2035() {
        return (class_37)super.method_1819();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2034(var1);
    }
}
