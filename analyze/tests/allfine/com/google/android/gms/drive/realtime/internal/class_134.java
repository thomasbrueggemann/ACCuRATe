package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.j
public interface class_134 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
    void method_663(ParcelableEventList var1) throws RemoteException;

    // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
    void method_664(Status var1) throws RemoteException;

    public abstract static class class_1383 extends Binder implements class_134 {
        // $FF: renamed from: af (android.os.IBinder) com.google.android.gms.drive.realtime.internal.j
        public static class_134 method_5938(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                return (class_134)(var1 != null && var1 instanceof class_134?(class_134)var1:new class_134.class_1384(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    int var7 = var2.readInt();
                    ParcelableEventList var8 = null;
                    if(var7 != 0) {
                        var8 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    int var5 = var2.readInt();
                    Status var6 = null;
                    if(var5 != 0) {
                        var6 = Status.CREATOR.createFromParcel(var2);
                    }

                    this.o(var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1384 implements class_134 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2974;

        class_1384(IBinder var1) {
            this.field_2974 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ParcelableEventList) void
        public void method_663(ParcelableEventList param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2974;
        }

        // $FF: renamed from: o (com.google.android.gms.common.api.Status) void
        public void method_664(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
