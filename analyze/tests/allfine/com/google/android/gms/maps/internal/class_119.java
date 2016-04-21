package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.model.internal.class_56;

// $FF: renamed from: com.google.android.gms.maps.internal.d
public interface class_119 extends IInterface {
    // $FF: renamed from: f (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
    class_206 method_642(class_56 var1) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
    class_206 method_643(class_56 var1) throws RemoteException;

    public abstract static class class_1591 extends Binder implements class_119 {
        public class_1591() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        // $FF: renamed from: aR (android.os.IBinder) com.google.android.gms.maps.internal.d
        public static class_119 method_3707(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                return (class_119)(var1 != null && var1 instanceof class_119?(class_119)var1:new class_119.class_1592(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    class_206 var7 = this.f(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    IBinder var8 = null;
                    if(var7 != null) {
                        var8 = var7.asBinder();
                    }

                    var3.writeStrongBinder(var8);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    class_206 var5 = this.g(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    IBinder var6 = null;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1592 implements class_119 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4491;

        class_1592(IBinder var1) {
            this.field_4491 = var1;
        }

        public IBinder asBinder() {
            return this.field_4491;
        }

        // $FF: renamed from: f (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
        public class_206 method_642(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: g (com.google.android.gms.maps.model.internal.f) com.google.android.gms.dynamic.d
        public class_206 method_643(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
