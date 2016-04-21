package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataSourcesResult;

// $FF: renamed from: com.google.android.gms.internal.kn
public interface class_158 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
    void method_789(DataSourcesResult var1) throws RemoteException;

    public abstract static class class_1546 extends Binder implements class_158 {
        public class_1546() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.IDataSourcesCallback");
        }

        // $FF: renamed from: aq (android.os.IBinder) com.google.android.gms.internal.kn
        public static class_158 method_4222(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                return (class_158)(var1 != null && var1 instanceof class_158?(class_158)var1:new class_158.class_1547(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    DataSourcesResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (DataSourcesResult)DataSourcesResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IDataSourcesCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1547 implements class_158 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4753;

        class_1547(IBinder var1) {
            this.field_4753 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.DataSourcesResult) void
        public void method_789(DataSourcesResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4753;
        }
    }
}
