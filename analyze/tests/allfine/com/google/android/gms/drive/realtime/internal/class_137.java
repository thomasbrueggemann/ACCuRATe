package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.c
public interface class_137 extends IInterface {
    // $FF: renamed from: M (boolean) void
    void method_669(boolean var1) throws RemoteException;

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_670(Status var1) throws RemoteException;

    public abstract static class class_1154 extends Binder implements class_137 {
        // $FF: renamed from: Y (android.os.IBinder) com.google.android.gms.drive.realtime.internal.c
        public static class_137 method_1618(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                return (class_137)(var1 != null && var1 instanceof class_137?(class_137)var1:new class_137.class_1155(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    boolean var6;
                    if(var2.readInt() != 0) {
                        var6 = true;
                    } else {
                        var6 = false;
                    }

                    this.M(var6);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
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
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1155 implements class_137 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5297;

        class_1155(IBinder var1) {
            this.field_5297 = var1;
        }

        // $FF: renamed from: M (boolean) void
        public void method_669(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5297;
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_670(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
