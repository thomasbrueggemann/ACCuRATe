package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

// $FF: renamed from: com.google.android.gms.internal.km
public interface class_157 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult) void
    void method_788(DataReadResult var1) throws RemoteException;

    public abstract static class class_1544 extends Binder implements class_157 {
        public class_1544() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataReadCallback");
        }

        // $FF: renamed from: ap (android.os.IBinder) com.google.android.gms.internal.km
        public static class_157 method_4554(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
                return (class_157)(var1 != null && var1 instanceof class_157?(class_157)var1:new class_157.class_1545(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
                    DataReadResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (DataReadResult)DataReadResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IDataReadCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1545 implements class_157 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3938;

        class_1545(IBinder var1) {
            this.field_3938 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataReadResult) void
        public void method_788(DataReadResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3938;
        }
    }
}
