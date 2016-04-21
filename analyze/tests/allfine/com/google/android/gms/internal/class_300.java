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
import com.google.android.gms.internal.ch;
import com.google.android.gms.internal.class_44;
import com.google.android.gms.internal.ez;

// $FF: renamed from: com.google.android.gms.internal.cg
@ez
public class class_300 extends e<ch> {
    // $FF: renamed from: pP int
    final int field_910;

    public class_300(Context var1, GooglePlayServicesClient.ConnectionCallbacks var2, GooglePlayServicesClient.OnConnectionFailedListener var3, int var4) {
        super(var1, var2, var3, new String[0]);
        this.field_910 = var4;
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        Bundle var3 = new Bundle();
        var1.method_978(var2, this.field_910, this.getContext().getPackageName(), var3);
    }

    // $FF: renamed from: bC () com.google.android.gms.internal.ch
    public class_44 method_2032() {
        return (class_44)super.method_1819();
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.gservice.IGservicesValueService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.ads.gservice.START";
    }

    // $FF: renamed from: i (android.os.IBinder) com.google.android.gms.internal.ch
    protected class_44 method_2033(IBinder var1) {
        return class_44.class_1418.method_5415(var1);
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_2033(var1);
    }
}
