package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

// $FF: renamed from: com.google.android.gms.maps.internal.r
public interface class_117 extends IInterface {
    void onStreetViewPanoramaClick(StreetViewPanoramaOrientation var1) throws RemoteException;

    public abstract static class class_1213 extends Binder implements class_117 {
        public class_1213() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
        }

        // $FF: renamed from: bi (android.os.IBinder) com.google.android.gms.maps.internal.r
        public static class_117 method_1625(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                return (class_117)(var1 != null && var1 instanceof class_117?(class_117)var1:new class_117.class_1214(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    StreetViewPanoramaOrientation var5;
                    if(var2.readInt() != 0) {
                        var5 = StreetViewPanoramaOrientation.CREATOR.method_5123(var2);
                    } else {
                        var5 = null;
                    }

                    this.onStreetViewPanoramaClick(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnStreetViewPanoramaClickListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1214 implements class_117 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2240;

        class_1214(IBinder var1) {
            this.field_2240 = var1;
        }

        public IBinder asBinder() {
            return this.field_2240;
        }

        public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
