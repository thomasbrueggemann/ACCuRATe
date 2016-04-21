package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.internal.cv
public interface class_40 extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int var1) throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    public abstract static class class_1420 extends Binder implements class_40 {
        public class_1420() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        }

        // $FF: renamed from: n (android.os.IBinder) com.google.android.gms.internal.cv
        public static class_40 method_2827(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                return (class_40)(var1 != null && var1 instanceof class_40?(class_40)var1:new class_40.class_1421(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdClicked();
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdClosed();
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdFailedToLoad(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdLeftApplication();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdOpened();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    this.onAdLoaded();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1421 implements class_40 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4702;

        class_1421(IBinder var1) {
            this.field_4702 = var1;
        }

        public IBinder asBinder() {
            return this.field_4702;
        }

        public void onAdClicked() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                this.field_4702.transact(1, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onAdClosed() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                this.field_4702.transact(2, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onAdFailedToLoad(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                var2.writeInt(var1);
                this.field_4702.transact(3, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void onAdLeftApplication() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                this.field_4702.transact(4, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onAdLoaded() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                this.field_4702.transact(6, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onAdOpened() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                this.field_4702.transact(5, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
