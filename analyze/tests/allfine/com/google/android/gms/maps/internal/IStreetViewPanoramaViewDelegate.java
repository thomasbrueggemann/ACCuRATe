package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

public interface IStreetViewPanoramaViewDelegate extends IInterface {
    IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException;

    class_206 getView() throws RemoteException;

    void onCreate(Bundle var1) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle var1) throws RemoteException;

    public abstract static class class_1670 extends Binder implements IStreetViewPanoramaViewDelegate {
        // $FF: renamed from: bn (android.os.IBinder) com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
        public static IStreetViewPanoramaViewDelegate method_5375(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                return (IStreetViewPanoramaViewDelegate)(var1 != null && var1 instanceof IStreetViewPanoramaViewDelegate?(IStreetViewPanoramaViewDelegate)var1:new IStreetViewPanoramaViewDelegate.class_1671(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    IStreetViewPanoramaDelegate var11 = this.getStreetViewPanorama();
                    var3.writeNoException();
                    IBinder var12 = null;
                    if(var11 != null) {
                        var12 = var11.asBinder();
                    }

                    var3.writeStrongBinder(var12);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    int var9 = var2.readInt();
                    Bundle var10 = null;
                    if(var9 != 0) {
                        var10 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    this.onCreate(var10);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.onResume();
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.onPause();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.onDestroy();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    this.onLowMemory();
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    int var7 = var2.readInt();
                    Bundle var8 = null;
                    if(var7 != 0) {
                        var8 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    }

                    this.onSaveInstanceState(var8);
                    var3.writeNoException();
                    if(var8 != null) {
                        var3.writeInt(1);
                        var8.writeToParcel(var3, 1);
                    } else {
                        var3.writeInt(0);
                    }

                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    class_206 var5 = this.getView();
                    var3.writeNoException();
                    IBinder var6 = null;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1671 implements IStreetViewPanoramaViewDelegate {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3993;

        class_1671(IBinder var1) {
            this.field_3993 = var1;
        }

        public IBinder asBinder() {
            return this.field_3993;
        }

        public IStreetViewPanoramaDelegate getStreetViewPanorama() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            IStreetViewPanoramaDelegate var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(1, var1, var2, 0);
                var2.readException();
                var5 = IStreetViewPanoramaDelegate.class_1267.method_5320(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public class_206 getView() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            class_206 var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(8, var1, var2, 0);
                var2.readException();
                var5 = class_206.class_1795.method_5435(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public void onCreate(Bundle param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onDestroy() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(5, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onLowMemory() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(6, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onPause() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(4, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onResume() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate");
                this.field_3993.transact(3, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void onSaveInstanceState(Bundle param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
