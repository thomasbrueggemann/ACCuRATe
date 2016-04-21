package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.maps.internal.h
public interface class_123 extends IInterface {
    // $FF: renamed from: l (com.google.android.gms.dynamic.d) void
    void method_646(class_206 var1) throws RemoteException;

    public abstract static class class_1601 extends Binder implements class_123 {
        // $FF: renamed from: aY (android.os.IBinder) com.google.android.gms.maps.internal.h
        public static class_123 method_5945(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                return (class_123)(var1 != null && var1 instanceof class_123?(class_123)var1:new class_123.class_1602(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    this.l(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1602 implements class_123 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5167;

        class_1602(IBinder var1) {
            this.field_5167 = var1;
        }

        public IBinder asBinder() {
            return this.field_5167;
        }

        // $FF: renamed from: l (com.google.android.gms.dynamic.d) void
        public void method_646(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
