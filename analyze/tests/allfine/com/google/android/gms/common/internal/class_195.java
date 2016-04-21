package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.common.internal.k
public interface class_195 extends IInterface {
    // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
    void method_997(int var1, IBinder var2, Bundle var3) throws RemoteException;

    public abstract static class class_1625 extends Binder implements class_195 {
        public class_1625() {
            this.attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
        }

        // $FF: renamed from: P (android.os.IBinder) com.google.android.gms.common.internal.k
        public static class_195 method_5574(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                return (class_195)(var1 != null && var1 instanceof class_195?(class_195)var1:new class_195.class_1626(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    int var5 = var2.readInt();
                    IBinder var6 = var2.readStrongBinder();
                    Bundle var7;
                    if(var2.readInt() != 0) {
                        var7 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
                    } else {
                        var7 = null;
                    }

                    this.b(var5, var6, var7);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1626 implements class_195 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4357;

        class_1626(IBinder var1) {
            this.field_4357 = var1;
        }

        public IBinder asBinder() {
            return this.field_4357;
        }

        // $FF: renamed from: b (int, android.os.IBinder, android.os.Bundle) void
        public void method_997(int param1, IBinder param2, Bundle param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
