package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_56;

// $FF: renamed from: com.google.android.gms.maps.internal.g
public interface class_122 extends IInterface {
    // $FF: renamed from: e (com.google.android.gms.maps.model.internal.f) void
    void method_645(class_56 var1) throws RemoteException;

    public abstract static class class_1258 extends Binder implements class_122 {
        public class_1258() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
        }

        // $FF: renamed from: aX (android.os.IBinder) com.google.android.gms.maps.internal.g
        public static class_122 method_3708(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                return (class_122)(var1 != null && var1 instanceof class_122?(class_122)var1:new class_122.class_1259(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    this.e(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1259 implements class_122 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2072;

        class_1259(IBinder var1) {
            this.field_2072 = var1;
        }

        public IBinder asBinder() {
            return this.field_2072;
        }

        // $FF: renamed from: e (com.google.android.gms.maps.model.internal.f) void
        public void method_645(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
