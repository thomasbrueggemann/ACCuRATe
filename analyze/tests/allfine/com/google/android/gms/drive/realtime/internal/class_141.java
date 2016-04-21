package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.o
public interface class_141 extends IInterface {
    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_716(Status var1) throws RemoteException;

    void onSuccess() throws RemoteException;

    public abstract static class class_1607 extends Binder implements class_141 {
        // $FF: renamed from: ak (android.os.IBinder) com.google.android.gms.drive.realtime.internal.o
        public static class_141 method_4425(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                return (class_141)(var1 != null && var1 instanceof class_141?(class_141)var1:new class_141.class_1608(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    this.onSuccess();
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
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
                    var3.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1608 implements class_141 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4790;

        class_1608(IBinder var1) {
            this.field_4790 = var1;
        }

        public IBinder asBinder() {
            return this.field_4790;
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_716(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void onSuccess() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                this.field_4790.transact(1, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
