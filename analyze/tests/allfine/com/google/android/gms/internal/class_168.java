package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.ov
public interface class_168 extends IInterface {
    // $FF: renamed from: b (int, int, android.os.Bundle) void
    void method_805(int var1, int var2, Bundle var3) throws RemoteException;

    public abstract static class class_1514 extends Binder implements class_168 {
        // $FF: renamed from: bN (android.os.IBinder) com.google.android.gms.internal.ov
        public static class_168 method_5852(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
                return (class_168)(var1 != null && var1 instanceof class_168?(class_168)var1:new class_168.class_1515(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
                    int var5 = var2.readInt();
                    int var6 = var2.readInt();
                    Bundle var7;
                    if(var2.readInt() != 0) {
                        var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.b(var5, var6, var7);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wallet.internal.IWalletInternalServiceCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1515 implements class_168 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4685;

        class_1515(IBinder var1) {
            this.field_4685 = var1;
        }

        public IBinder asBinder() {
            return this.field_4685;
        }

        // $FF: renamed from: b (int, int, android.os.Bundle) void
        public void method_805(int param1, int param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
