package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_59;

// $FF: renamed from: com.google.android.gms.maps.internal.f
public interface class_121 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.maps.model.internal.d) void
    void method_644(class_59 var1) throws RemoteException;

    void onIndoorBuildingFocused() throws RemoteException;

    public abstract static class class_1599 extends Binder implements class_121 {
        public class_1599() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        // $FF: renamed from: aW (android.os.IBinder) com.google.android.gms.maps.internal.f
        public static class_121 method_5262(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                return (class_121)(var1 != null && var1 instanceof class_121?(class_121)var1:new class_121.class_1600(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.onIndoorBuildingFocused();
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.a(class_59.class_1681.method_5079(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1600 implements class_121 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3939;

        class_1600(IBinder var1) {
            this.field_3939 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.internal.d) void
        public void method_644(class_59 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3939;
        }

        public void onIndoorBuildingFocused() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                this.field_3939.transact(1, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
