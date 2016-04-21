package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.class_1046;
import com.google.android.gms.dynamic.class_205;
import com.google.android.gms.dynamic.class_216;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_169;
import com.google.android.gms.internal.class_171;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.internal.ou;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.oz
public class class_219 extends g<ou> {
    private static class_219 aux;

    protected class_219() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    // $FF: renamed from: a (android.app.Activity, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.os) com.google.android.gms.internal.or
    public static class_172 method_1512(Activity var0, class_205 var1, WalletFragmentOptions var2, class_171 var3) throws GooglePlayServicesNotAvailableException {
        int var4 = GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0);
        if(var4 != 0) {
            throw new GooglePlayServicesNotAvailableException(var4);
        } else {
            try {
                class_172 var7 = ((class_169)method_1513().L(var0)).method_806(class_1046.method_5437(var0), var1, var2, var3);
                return var7;
            } catch (RemoteException var8) {
                throw new RuntimeException(var8);
            } catch (class_216.class_1677 var9) {
                throw new RuntimeException(var9);
            }
        }
    }

    // $FF: renamed from: pP () com.google.android.gms.internal.oz
    private static class_219 method_1513() {
        if(aux == null) {
            aux = new class_219();
        }

        return aux;
    }

    // $FF: renamed from: bQ (android.os.IBinder) com.google.android.gms.internal.ou
    protected class_169 method_1514(IBinder var1) {
        return class_169.class_1516.method_5514(var1);
    }

    // $FF: renamed from: d (android.os.IBinder) java.lang.Object
    // $FF: synthetic method
    protected Object method_1506(IBinder var1) {
        return this.method_1514(var1);
    }
}
