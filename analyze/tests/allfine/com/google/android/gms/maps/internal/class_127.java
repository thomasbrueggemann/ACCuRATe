package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.model.internal.class_58;

// $FF: renamed from: com.google.android.gms.maps.internal.c
public interface class_127 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.maps.GoogleMapOptions) com.google.android.gms.maps.internal.IMapViewDelegate
    IMapViewDelegate method_647(class_206 var1, GoogleMapOptions var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.maps.StreetViewPanoramaOptions) com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
    IStreetViewPanoramaViewDelegate method_648(class_206 var1, StreetViewPanoramaOptions var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, int) void
    void method_649(class_206 var1, int var2) throws RemoteException;

    // $FF: renamed from: i (com.google.android.gms.dynamic.d) void
    void method_650(class_206 var1) throws RemoteException;

    // $FF: renamed from: j (com.google.android.gms.dynamic.d) com.google.android.gms.maps.internal.IMapFragmentDelegate
    IMapFragmentDelegate method_651(class_206 var1) throws RemoteException;

    // $FF: renamed from: k (com.google.android.gms.dynamic.d) com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    IStreetViewPanoramaFragmentDelegate method_652(class_206 var1) throws RemoteException;

    // $FF: renamed from: mI () com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    ICameraUpdateFactoryDelegate method_653() throws RemoteException;

    // $FF: renamed from: mJ () com.google.android.gms.maps.model.internal.a
    class_58 method_654() throws RemoteException;

    public abstract static class class_1356 extends Binder implements class_127 {
        // $FF: renamed from: aP (android.os.IBinder) com.google.android.gms.maps.internal.c
        public static class_127 method_4423(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                return (class_127)(var1 != null && var1 instanceof class_127?(class_127)var1:new class_127.class_1357(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.i(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate var19 = this.j(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    IBinder var20 = null;
                    if(var19 != null) {
                        var20 = var19.asBinder();
                    }

                    var3.writeStrongBinder(var20);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    class_206 var15 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    GoogleMapOptions var16;
                    if(var2.readInt() != 0) {
                        var16 = GoogleMapOptions.CREATOR.method_5543(var2);
                    } else {
                        var16 = null;
                    }

                    IMapViewDelegate var17 = this.a(var15, var16);
                    var3.writeNoException();
                    IBinder var18 = null;
                    if(var17 != null) {
                        var18 = var17.asBinder();
                    }

                    var3.writeStrongBinder(var18);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate var13 = this.mI();
                    var3.writeNoException();
                    IBinder var14 = null;
                    if(var13 != null) {
                        var14 = var13.asBinder();
                    }

                    var3.writeStrongBinder(var14);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    class_58 var11 = this.mJ();
                    var3.writeNoException();
                    IBinder var12 = null;
                    if(var11 != null) {
                        var12 = var11.asBinder();
                    }

                    var3.writeStrongBinder(var12);
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    this.a(class_206.class_1795.method_5435(var2.readStrongBinder()), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    class_206 var7 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    StreetViewPanoramaOptions var8;
                    if(var2.readInt() != 0) {
                        var8 = StreetViewPanoramaOptions.CREATOR.method_5540(var2);
                    } else {
                        var8 = null;
                    }

                    IStreetViewPanoramaViewDelegate var9 = this.a(var7, var8);
                    var3.writeNoException();
                    IBinder var10 = null;
                    if(var9 != null) {
                        var10 = var9.asBinder();
                    }

                    var3.writeStrongBinder(var10);
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate var5 = this.k(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    IBinder var6 = null;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1357 implements class_127 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2934;

        class_1357(IBinder var1) {
            this.field_2934 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.maps.GoogleMapOptions) com.google.android.gms.maps.internal.IMapViewDelegate
        public IMapViewDelegate method_647(class_206 param1, GoogleMapOptions param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.maps.StreetViewPanoramaOptions) com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate
        public IStreetViewPanoramaViewDelegate method_648(class_206 param1, StreetViewPanoramaOptions param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, int) void
        public void method_649(class_206 param1, int param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2934;
        }

        // $FF: renamed from: i (com.google.android.gms.dynamic.d) void
        public void method_650(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: j (com.google.android.gms.dynamic.d) com.google.android.gms.maps.internal.IMapFragmentDelegate
        public IMapFragmentDelegate method_651(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: k (com.google.android.gms.dynamic.d) com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
        public IStreetViewPanoramaFragmentDelegate method_652(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: mI () com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
        public ICameraUpdateFactoryDelegate method_653() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            ICameraUpdateFactoryDelegate var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                this.field_2934.transact(4, var1, var2, 0);
                var2.readException();
                var5 = ICameraUpdateFactoryDelegate.class_1480.method_3683(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: mJ () com.google.android.gms.maps.model.internal.a
        public class_58 method_654() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            class_58 var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                this.field_2934.transact(5, var1, var2, 0);
                var2.readException();
                var5 = class_58.class_1379.method_5979(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }
    }
}
