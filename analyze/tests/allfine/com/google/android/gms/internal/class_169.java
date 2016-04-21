package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_205;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_171;
import com.google.android.gms.internal.class_172;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// $FF: renamed from: com.google.android.gms.internal.ou
public interface class_169 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.os) com.google.android.gms.internal.or
    class_172 method_806(class_206 var1, class_205 var2, WalletFragmentOptions var3, class_171 var4) throws RemoteException;

    public abstract static class class_1516 extends Binder implements class_169 {
        // $FF: renamed from: bM (android.os.IBinder) com.google.android.gms.internal.ou
        public static class_169 method_5514(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                return (class_169)(var1 != null && var1 instanceof class_169?(class_169)var1:new class_169.class_1517(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    class_206 var5 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    class_205 var6 = class_205.class_1416.method_5582(var2.readStrongBinder());
                    WalletFragmentOptions var7;
                    if(var2.readInt() != 0) {
                        var7 = (WalletFragmentOptions)WalletFragmentOptions.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    class_172 var8 = this.a(var5, var6, var7, class_171.class_1162.method_1642(var2.readStrongBinder()));
                    var3.writeNoException();
                    IBinder var9 = null;
                    if(var8 != null) {
                        var9 = var8.asBinder();
                    }

                    var3.writeStrongBinder(var9);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wallet.internal.IWalletDynamiteCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1517 implements class_169 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5044;

        class_1517(IBinder var1) {
            this.field_5044 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.dynamic.c, com.google.android.gms.wallet.fragment.WalletFragmentOptions, com.google.android.gms.internal.os) com.google.android.gms.internal.or
        public class_172 method_806(class_206 param1, class_205 param2, WalletFragmentOptions param3, class_171 param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5044;
        }
    }
}
