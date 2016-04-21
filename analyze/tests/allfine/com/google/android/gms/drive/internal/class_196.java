package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.drive.internal.ae
public interface class_196 extends IInterface {
    // $FF: renamed from: L (boolean) void
    void method_999(boolean var1) throws RemoteException;

    public abstract static class class_1303 extends Binder implements class_196 {
        // $FF: renamed from: X (android.os.IBinder) com.google.android.gms.drive.internal.ae
        public static class_196 method_5958(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
                return (class_196)(var1 != null && var1 instanceof class_196?(class_196)var1:new class_196.class_1304(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    boolean var5;
                    if(var2.readInt() != 0) {
                        var5 = true;
                    } else {
                        var5 = false;
                    }

                    this.L(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.drive.internal.IEventReleaseCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1304 implements class_196 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4012;

        class_1304(IBinder var1) {
            this.field_4012 = var1;
        }

        // $FF: renamed from: L (boolean) void
        public void method_999(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4012;
        }
    }
}
