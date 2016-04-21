package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.k
public interface class_135 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) void
    void method_665(ParcelableIndexReference var1) throws RemoteException;

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_666(Status var1) throws RemoteException;

    public abstract static class class_1148 extends Binder implements class_135 {
        // $FF: renamed from: ag (android.os.IBinder) com.google.android.gms.drive.realtime.internal.k
        public static class_135 method_1582(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                return (class_135)(var1 != null && var1 instanceof class_135?(class_135)var1:new class_135.class_1149(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    int var7 = var2.readInt();
                    ParcelableIndexReference var8 = null;
                    if(var7 != 0) {
                        var8 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    int var5 = var2.readInt();
                    Status var6 = null;
                    if(var5 != 0) {
                        var6 = Status.CREATOR.createFromParcel(var2);
                    }

                    this.o(var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1149 implements class_135 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4358;

        class_1149(IBinder var1) {
            this.field_4358 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) void
        public void method_665(ParcelableIndexReference param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4358;
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_666(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
