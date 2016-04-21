package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.auth.api.IGoogleAuthService;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;

public final class GoogleAuthApiClientImpl extends e<IGoogleAuthService> {
    public static final String ACTION_START_SERVICE = "com.google.android.gms.auth.service.START";
    public static final String SERVICE_DESCRIPTOR = "com.google.android.gms.auth.api.IGoogleAuthService";
    // $FF: renamed from: Dd java.lang.String
    private final String field_908;
    // $FF: renamed from: Ds java.lang.String[]
    private String[] field_909;

    public GoogleAuthApiClientImpl(Context var1, Looper var2, ClientSettings var3, GoogleApiClient.ConnectionCallbacks var4, GoogleApiClient.OnConnectionFailedListener var5, String var6, String[] var7) {
        super(var1, var2, var4, var5, var7);
        this.field_908 = var6;
        this.field_909 = var7;
    }

    public GoogleAuthApiClientImpl(Context var1, ClientSettings var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, String[] var6) {
        this(var1, var1.getMainLooper(), var2, var3, var4, var5, var6);
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_968(var2, 6171000, this.getContext().getPackageName(), this.field_908, this.gR());
    }

    protected IGoogleAuthService createServiceInterface(IBinder var1) {
        return IGoogleAuthService.Stub.asInterface(var1);
    }

    public String getAccountName() {
        return this.field_908;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.IGoogleAuthService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.createServiceInterface(var1);
    }
}
