package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.internal.ej
public interface class_31 extends IInterface {
    // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
    IBinder method_160(class_206 var1) throws RemoteException;

    public abstract static class class_1472 extends Binder implements class_31 {
        // $FF: renamed from: v (android.os.IBinder) com.google.android.gms.internal.ej
        public static class_31 method_4997(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                return (class_31)(var1 != null && var1 instanceof class_31?(class_31)var1:new class_31.class_1473(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    IBinder var5 = this.b(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    var3.writeStrongBinder(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1473 implements class_31 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4738;

        class_1473(IBinder var1) {
            this.field_4738 = var1;
        }

        public IBinder asBinder() {
            return this.field_4738;
        }

        // $FF: renamed from: b (com.google.android.gms.dynamic.d) android.os.IBinder
        public IBinder method_160(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
