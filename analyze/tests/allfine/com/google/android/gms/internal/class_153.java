package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// $FF: renamed from: com.google.android.gms.internal.kq
public interface class_153 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
    void method_761(ListSubscriptionsResult var1) throws RemoteException;

    public abstract static class class_1548 extends Binder implements class_153 {
        public class_1548() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        }

        // $FF: renamed from: at (android.os.IBinder) com.google.android.gms.internal.kq
        public static class_153 method_4392(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                return (class_153)(var1 != null && var1 instanceof class_153?(class_153)var1:new class_153.class_1549(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    ListSubscriptionsResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (ListSubscriptionsResult)ListSubscriptionsResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1549 implements class_153 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4011;

        class_1549(IBinder var1) {
            this.field_4011 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.ListSubscriptionsResult) void
        public void method_761(ListSubscriptionsResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4011;
        }
    }
}
