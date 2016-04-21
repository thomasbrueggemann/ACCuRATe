package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// $FF: renamed from: com.google.android.gms.internal.kt
public interface class_151 extends IInterface {
    // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
    void method_759(Status var1) throws RemoteException;

    public abstract static class class_1528 extends Binder implements class_151 {
        public class_1528() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.IStatusCallback");
        }

        // $FF: renamed from: aw (android.os.IBinder) com.google.android.gms.internal.kt
        public static class_151 method_5440(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
                return (class_151)(var1 != null && var1 instanceof class_151?(class_151)var1:new class_151.class_1529(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IStatusCallback");
                    Status var5;
                    if(var2.readInt() != 0) {
                        var5 = Status.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.k(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IStatusCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1529 implements class_151 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4828;

        class_1529(IBinder var1) {
            this.field_4828 = var1;
        }

        public IBinder asBinder() {
            return this.field_4828;
        }

        // $FF: renamed from: k (com.google.android.gms.common.api.Status) void
        public void method_759(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
