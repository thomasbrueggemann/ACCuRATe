package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.maps.internal.o
public interface class_114 extends IInterface {
    // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
    void method_640(class_206 var1) throws RemoteException;

    public abstract static class class_1597 extends Binder implements class_114 {
        public class_1597() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        }

        // $FF: renamed from: bf (android.os.IBinder) com.google.android.gms.maps.internal.o
        public static class_114 method_5261(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                return (class_114)(var1 != null && var1 instanceof class_114?(class_114)var1:new class_114.class_1598(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    this.g(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1598 implements class_114 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5108;

        class_1598(IBinder var1) {
            this.field_5108 = var1;
        }

        public IBinder asBinder() {
            return this.field_5108;
        }

        // $FF: renamed from: g (com.google.android.gms.dynamic.d) void
        public void method_640(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
