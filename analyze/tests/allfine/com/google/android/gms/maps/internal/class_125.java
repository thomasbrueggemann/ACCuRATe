package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.j
public interface class_125 extends IInterface {
    void onMapLoaded() throws RemoteException;

    public abstract static class class_1363 extends Binder implements class_125 {
        public class_1363() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
        }

        // $FF: renamed from: ba (android.os.IBinder) com.google.android.gms.maps.internal.j
        public static class_125 method_3364(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                return (class_125)(var1 != null && var1 instanceof class_125?(class_125)var1:new class_125.class_1364(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    this.onMapLoaded();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1364 implements class_125 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2947;

        class_1364(IBinder var1) {
            this.field_2947 = var1;
        }

        public IBinder asBinder() {
            return this.field_2947;
        }

        public void onMapLoaded() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
                this.field_2947.transact(1, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
