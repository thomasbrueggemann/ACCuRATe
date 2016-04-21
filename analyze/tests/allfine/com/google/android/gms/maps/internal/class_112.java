package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.class_56;

// $FF: renamed from: com.google.android.gms.maps.internal.m
public interface class_112 extends IInterface {
    // $FF: renamed from: b (com.google.android.gms.maps.model.internal.f) void
    void method_637(class_56 var1) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.maps.model.internal.f) void
    void method_638(class_56 var1) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.maps.model.internal.f) void
    void method_639(class_56 var1) throws RemoteException;

    public abstract static class class_1589 extends Binder implements class_112 {
        public class_1589() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        // $FF: renamed from: bd (android.os.IBinder) com.google.android.gms.maps.internal.m
        public static class_112 method_3706(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                return (class_112)(var1 != null && var1 instanceof class_112?(class_112)var1:new class_112.class_1590(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    this.b(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    this.d(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    this.c(class_56.class_1647.method_4262(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1590 implements class_112 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4148;

        class_1590(IBinder var1) {
            this.field_4148 = var1;
        }

        public IBinder asBinder() {
            return this.field_4148;
        }

        // $FF: renamed from: b (com.google.android.gms.maps.model.internal.f) void
        public void method_637(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.maps.model.internal.f) void
        public void method_638(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.maps.model.internal.f) void
        public void method_639(class_56 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
