package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

// $FF: renamed from: com.google.android.gms.internal.kr
public interface class_154 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
    void method_762(SessionReadResult var1) throws RemoteException;

    public abstract static class class_1250 extends Binder implements class_154 {
        public class_1250() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.ISessionReadCallback");
        }

        // $FF: renamed from: au (android.os.IBinder) com.google.android.gms.internal.kr
        public static class_154 method_5199(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                return (class_154)(var1 != null && var1 instanceof class_154?(class_154)var1:new class_154.class_1251(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    SessionReadResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (SessionReadResult)SessionReadResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.ISessionReadCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1251 implements class_154 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2053;

        class_1251(IBinder var1) {
            this.field_2053 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult) void
        public void method_762(SessionReadResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2053;
        }
    }
}
