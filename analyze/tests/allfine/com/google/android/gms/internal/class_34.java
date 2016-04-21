package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.eg
public interface class_34 extends IInterface {
    String getProductId() throws RemoteException;

    void recordPlayBillingResolution(int var1) throws RemoteException;

    void recordResolution(int var1) throws RemoteException;

    public abstract static class class_1476 extends Binder implements class_34 {
        public class_1476() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
        }

        // $FF: renamed from: s (android.os.IBinder) com.google.android.gms.internal.eg
        public static class_34 method_2888(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                return (class_34)(var1 != null && var1 instanceof class_34?(class_34)var1:new class_34.class_1477(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    String var5 = this.getProductId();
                    var3.writeNoException();
                    var3.writeString(var5);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    this.recordResolution(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    this.recordPlayBillingResolution(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1477 implements class_34 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4196;

        class_1477(IBinder var1) {
            this.field_4196 = var1;
        }

        public IBinder asBinder() {
            return this.field_4196;
        }

        public String getProductId() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                this.field_4196.transact(1, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public void recordPlayBillingResolution(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                var2.writeInt(var1);
                this.field_4196.transact(3, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void recordResolution(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
                var2.writeInt(var1);
                this.field_4196.transact(2, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }
    }
}
