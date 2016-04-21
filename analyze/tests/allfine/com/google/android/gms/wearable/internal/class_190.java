package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_1072;
import com.google.android.gms.wearable.internal.class_1082;

// $FF: renamed from: com.google.android.gms.wearable.internal.ae
public interface class_190 extends IInterface {
    // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
    void method_923(DataHolder var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ah) void
    void method_924(class_1082 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ak) void
    void method_925(class_1072 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ak) void
    void method_926(class_1072 var1) throws RemoteException;

    public abstract static class class_1376 extends Binder implements class_190 {
        public class_1376() {
            this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        // $FF: renamed from: bS (android.os.IBinder) com.google.android.gms.wearable.internal.ae
        public static class_190 method_3368(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                return (class_190)(var1 != null && var1 instanceof class_190?(class_190)var1:new class_190.class_1377(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    int var11 = var2.readInt();
                    DataHolder var12 = null;
                    if(var11 != 0) {
                        var12 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.Z(var12);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    int var9 = var2.readInt();
                    class_1082 var10 = null;
                    if(var9 != 0) {
                        var10 = (class_1082)class_1082.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    int var7 = var2.readInt();
                    class_1072 var8 = null;
                    if(var7 != 0) {
                        var8 = (class_1072)class_1072.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
                    int var5 = var2.readInt();
                    class_1072 var6 = null;
                    if(var5 != 0) {
                        var6 = (class_1072)class_1072.CREATOR.createFromParcel(var2);
                    }

                    this.b(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wearable.internal.IWearableListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1377 implements class_190 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5314;

        class_1377(IBinder var1) {
            this.field_5314 = var1;
        }

        // $FF: renamed from: Z (com.google.android.gms.common.data.DataHolder) void
        public void method_923(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ah) void
        public void method_924(class_1082 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ak) void
        public void method_925(class_1072 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5314;
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ak) void
        public void method_926(class_1072 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
