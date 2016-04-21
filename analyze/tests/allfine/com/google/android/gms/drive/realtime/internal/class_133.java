package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.i
public interface class_133 extends IInterface {
    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_662(Status var1) throws RemoteException;

    public abstract static class class_1247 extends Binder implements class_133 {
        // $FF: renamed from: ae (android.os.IBinder) com.google.android.gms.drive.realtime.internal.i
        public static class_133 method_5566(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                return (class_133)(var1 != null && var1 instanceof class_133?(class_133)var1:new class_133.class_1248(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    Status var5;
                    if(var2.readInt() != 0) {
                        var5 = Status.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.o(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1248 implements class_133 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2051;

        class_1248(IBinder var1) {
            this.field_2051 = var1;
        }

        public IBinder asBinder() {
            return this.field_2051;
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_662(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
