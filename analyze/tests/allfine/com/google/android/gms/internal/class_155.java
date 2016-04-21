package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataTypeResult;

// $FF: renamed from: com.google.android.gms.internal.ko
public interface class_155 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.DataTypeResult) void
    void method_763(DataTypeResult var1) throws RemoteException;

    public abstract static class class_1365 extends Binder implements class_155 {
        public class_1365() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataTypeCallback");
        }

        // $FF: renamed from: ar (android.os.IBinder) com.google.android.gms.internal.ko
        public static class_155 method_3365(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
                return (class_155)(var1 != null && var1 instanceof class_155?(class_155)var1:new class_155.class_1366(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    DataTypeResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (DataTypeResult)DataTypeResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IDataTypeCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1366 implements class_155 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4568;

        class_1366(IBinder var1) {
            this.field_4568 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataTypeResult) void
        public void method_763(DataTypeResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4568;
        }
    }
}
