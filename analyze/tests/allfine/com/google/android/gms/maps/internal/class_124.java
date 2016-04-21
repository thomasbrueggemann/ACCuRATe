package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;

// $FF: renamed from: com.google.android.gms.maps.internal.i
public interface class_124 extends IInterface {
    void onMapClick(LatLng var1) throws RemoteException;

    public abstract static class class_1223 extends Binder implements class_124 {
        public class_1223() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
        }

        // $FF: renamed from: aZ (android.os.IBinder) com.google.android.gms.maps.internal.i
        public static class_124 method_2844(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
                return (class_124)(var1 != null && var1 instanceof class_124?(class_124)var1:new class_124.class_1224(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
                    LatLng var5;
                    if(var2.readInt() != 0) {
                        var5 = LatLng.CREATOR.method_5161(var2);
                    } else {
                        var5 = null;
                    }

                    this.onMapClick(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1224 implements class_124 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5032;

        class_1224(IBinder var1) {
            this.field_5032 = var1;
        }

        public IBinder asBinder() {
            return this.field_5032;
        }

        public void onMapClick(LatLng param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
