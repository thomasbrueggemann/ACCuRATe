package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.realtime.internal.ParcelableCollaborator;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.d
public interface class_138 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
    void method_671(ParcelableCollaborator var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
    void method_672(ParcelableCollaborator var1) throws RemoteException;

    public abstract static class class_1349 extends Binder implements class_138 {
        // $FF: renamed from: Z (android.os.IBinder) com.google.android.gms.drive.realtime.internal.d
        public static class_138 method_3259(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                return (class_138)(var1 != null && var1 instanceof class_138?(class_138)var1:new class_138.class_1350(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    int var7 = var2.readInt();
                    ParcelableCollaborator var8 = null;
                    if(var7 != 0) {
                        var8 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    int var5 = var2.readInt();
                    ParcelableCollaborator var6 = null;
                    if(var5 != 0) {
                        var6 = (ParcelableCollaborator)ParcelableCollaborator.CREATOR.createFromParcel(var2);
                    }

                    this.b(var6);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorEventCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1350 implements class_138 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3440;

        class_1350(IBinder var1) {
            this.field_3440 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
        public void method_671(ParcelableCollaborator param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3440;
        }

        // $FF: renamed from: b (com.google.android.gms.drive.realtime.internal.ParcelableCollaborator) void
        public void method_672(ParcelableCollaborator param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
