package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

// $FF: renamed from: com.google.android.gms.maps.internal.p
public interface class_115 extends IInterface {
    void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera var1) throws RemoteException;

    public abstract static class class_1505 extends Binder implements class_115 {
        public class_1505() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
        }

        // $FF: renamed from: bg (android.os.IBinder) com.google.android.gms.maps.internal.p
        public static class_115 method_1627(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                return (class_115)(var1 != null && var1 instanceof class_115?(class_115)var1:new class_115.class_1506(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    StreetViewPanoramaCamera var5;
                    if(var2.readInt() != 0) {
                        var5 = StreetViewPanoramaCamera.CREATOR.method_5179(var2);
                    } else {
                        var5 = null;
                    }

                    this.onStreetViewPanoramaCameraChange(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1506 implements class_115 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3299;

        class_1506(IBinder var1) {
            this.field_3299 = var1;
        }

        public IBinder asBinder() {
            return this.field_3299;
        }

        public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
