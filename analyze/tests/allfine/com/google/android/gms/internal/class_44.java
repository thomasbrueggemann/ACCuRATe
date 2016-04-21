package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.ch
public interface class_44 extends IInterface {
    // $FF: renamed from: bD () android.os.Bundle
    Bundle method_180() throws RemoteException;

    public abstract static class class_1418 extends Binder implements class_44 {
        // $FF: renamed from: k (android.os.IBinder) com.google.android.gms.internal.ch
        public static class_44 method_5415(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                return (class_44)(var1 != null && var1 instanceof class_44?(class_44)var1:new class_44.class_1419(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    Bundle var5 = this.bD();
                    var3.writeNoException();
                    if(var5 != null) {
                        var3.writeInt(1);
                        var5.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1419 implements class_44 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3896;

        class_1419(IBinder var1) {
            this.field_3896 = var1;
        }

        public IBinder asBinder() {
            return this.field_3896;
        }

        // $FF: renamed from: bD () android.os.Bundle
        public Bundle method_180() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Bundle var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.ads.internal.gservice.IGservicesValueService");
                    this.field_3896.transact(1, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }
    }
}
