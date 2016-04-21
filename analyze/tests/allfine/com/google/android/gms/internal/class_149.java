package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.BleDevicesResult;

// $FF: renamed from: com.google.android.gms.internal.lf
public interface class_149 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
    void method_757(BleDevicesResult var1) throws RemoteException;

    public abstract static class class_1536 extends Binder implements class_149 {
        public class_1536() {
            this.attachInterface(this, "com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
        }

        // $FF: renamed from: ax (android.os.IBinder) com.google.android.gms.internal.lf
        public static class_149 method_3952(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                return (class_149)(var1 != null && var1 instanceof class_149?(class_149)var1:new class_149.class_1537(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    BleDevicesResult var5;
                    if(var2.readInt() != 0) {
                        var5 = (BleDevicesResult)BleDevicesResult.CREATOR.createFromParcel(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.fitness.internal.ble.IBleDevicesCallback");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1537 implements class_149 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5054;

        class_1537(IBinder var1) {
            this.field_5054 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.fitness.result.BleDevicesResult) void
        public void method_757(BleDevicesResult param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5054;
        }
    }
}
