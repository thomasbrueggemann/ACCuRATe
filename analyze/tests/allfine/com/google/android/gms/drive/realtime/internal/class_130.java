package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.f
public interface class_130 extends IInterface {
    // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder) void
    void method_657(DataHolder var1) throws RemoteException;

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_658(Status var1) throws RemoteException;

    public abstract static class class_1688 extends Binder implements class_130 {
        // $FF: renamed from: ab (android.os.IBinder) com.google.android.gms.drive.realtime.internal.f
        public static class_130 method_4424(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                return (class_130)(var1 != null && var1 instanceof class_130?(class_130)var1:new class_130.class_1689(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    int var7 = var2.readInt();
                    DataHolder var8 = null;
                    if(var7 != 0) {
                        var8 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.b(var8);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    int var5 = var2.readInt();
                    Status var6 = null;
                    if(var5 != 0) {
                        var6 = Status.CREATOR.createFromParcel(var2);
                    }

                    this.o(var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1689 implements class_130 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5158;

        class_1689(IBinder var1) {
            this.field_5158 = var1;
        }

        public IBinder asBinder() {
            return this.field_5158;
        }

        // $FF: renamed from: b (com.google.android.gms.common.data.DataHolder) void
        public void method_657(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_658(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
