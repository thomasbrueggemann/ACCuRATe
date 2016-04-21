package com.google.android.gms.fitness.data;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;

// $FF: renamed from: com.google.android.gms.fitness.data.k
public interface class_200 extends IInterface {
    // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
    void method_1046(DataPoint var1) throws RemoteException;

    public abstract static class class_1284 extends Binder implements class_200 {
        public class_1284() {
            this.attachInterface(this, "com.google.android.gms.fitness.data.IDataSourceListener");
        }

        // $FF: renamed from: an (android.os.IBinder) com.google.android.gms.fitness.data.k
        public static class_200 method_3041(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
                return (class_200)(var1 != null && var1 instanceof class_200?(class_200)var1:new class_200.class_1285(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.data.IDataSourceListener");
                    DataPoint var5;
                    if(var2.readInt() != 0) {
                        var5 = (DataPoint)DataPoint.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.c(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.data.IDataSourceListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1285 implements class_200 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4500;

        class_1285(IBinder var1) {
            this.field_4500 = var1;
        }

        public IBinder asBinder() {
            return this.field_4500;
        }

        // $FF: renamed from: c (com.google.android.gms.fitness.data.DataPoint) void
        public void method_1046(DataPoint param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
