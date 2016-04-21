package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.class_192;
import com.google.android.gms.common.internal.class_291;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.class_146;
import com.google.android.gms.internal.class_147;
import com.google.android.gms.internal.lo;

// $FF: renamed from: com.google.android.gms.internal.lm
public class class_298 extends e<lo> {
    // $FF: renamed from: Dd java.lang.String
    private final String field_894;
    private class_298.class_1313 adM;
    private final int mTheme;
    // $FF: renamed from: nr android.app.Activity
    private Activity field_895;

    public class_298(Activity var1, Looper var2, GoogleApiClient.ConnectionCallbacks var3, GoogleApiClient.OnConnectionFailedListener var4, String var5, int var6) {
        super(var1, var2, var3, var4, new String[0]);
        this.field_894 = var5;
        this.field_895 = var1;
        this.mTheme = var6;
    }

    // $FF: renamed from: a (com.google.android.gms.common.internal.l, com.google.android.gms.common.internal.e$e) void
    protected void method_1814(class_192 var1, class_291.class_1750 var2) throws RemoteException {
        var1.method_971(var2, 6171000, this.getContext().getPackageName());
    }

    // $FF: renamed from: a (com.google.android.gms.identity.intents.UserAddressRequest, int) void
    public void method_1871(UserAddressRequest var1, int var2) {
        this.method_1874();
        this.adM = new class_298.class_1313(var2, this.field_895);

        try {
            Bundle var3 = new Bundle();
            var3.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", this.getContext().getPackageName());
            if(!TextUtils.isEmpty(this.field_894)) {
                var3.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.field_894, "com.google"));
            }

            var3.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            this.method_1873().method_753(this.adM, var1, var3);
        } catch (RemoteException var7) {
            Log.e("AddressClientImpl", "Exception requesting user address", var7);
            Bundle var6 = new Bundle();
            var6.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
            this.adM.method_752(1, var6);
        }
    }

    // $FF: renamed from: aF (android.os.IBinder) com.google.android.gms.internal.lo
    protected class_147 method_1872(IBinder var1) {
        return class_147.class_1533.method_5609(var1);
    }

    public void disconnect() {
        super.disconnect();
        if(this.adM != null) {
            this.adM.setActivity((Activity)null);
            this.adM = null;
        }

    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.identity.service.BIND";
    }

    // $FF: renamed from: j (android.os.IBinder) android.os.IInterface
    // $FF: synthetic method
    protected IInterface method_1820(IBinder var1) {
        return this.method_1872(var1);
    }

    // $FF: renamed from: lS () com.google.android.gms.internal.lo
    protected class_147 method_1873() {
        return (class_147)super.method_1819();
    }

    // $FF: renamed from: lT () void
    protected void method_1874() {
        super.method_1817();
    }

    public static final class class_1313 extends class_146.class_1531 {
        // $FF: renamed from: Lu int
        private final int field_4534;
        // $FF: renamed from: nr android.app.Activity
        private Activity field_4535;

        public class_1313(int var1, Activity var2) {
            this.field_4534 = var1;
            this.field_4535 = var2;
        }

        private void setActivity(Activity var1) {
            this.field_4535 = var1;
        }

        // $FF: renamed from: g (int, android.os.Bundle) void
        public void method_752(int param1, Bundle param2) {
            // $FF: Couldn't be decompiled
        }
    }
}
