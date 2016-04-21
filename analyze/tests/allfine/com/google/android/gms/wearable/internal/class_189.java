package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.class_1000;
import com.google.android.gms.wearable.internal.class_1002;
import com.google.android.gms.wearable.internal.class_1003;
import com.google.android.gms.wearable.internal.class_1005;
import com.google.android.gms.wearable.internal.class_1007;
import com.google.android.gms.wearable.internal.class_1068;
import com.google.android.gms.wearable.internal.class_1076;
import com.google.android.gms.wearable.internal.class_1078;
import com.google.android.gms.wearable.internal.class_1080;
import com.google.android.gms.wearable.internal.class_997;

// $FF: renamed from: com.google.android.gms.wearable.internal.ad
public interface class_189 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
    void method_911(Status var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
    void method_912(class_1080 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ao) void
    void method_913(class_1068 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.as) void
    void method_914(class_1076 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
    void method_915(class_1078 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
    void method_916(class_997 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
    void method_917(class_1002 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
    void method_918(class_1000 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
    void method_919(class_1005 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
    void method_920(class_1003 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
    void method_921(class_1007 var1) throws RemoteException;

    // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
    void method_922(DataHolder var1) throws RemoteException;

    public abstract static class class_1297 extends Binder implements class_189 {
        public class_1297() {
            this.attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        // $FF: renamed from: bR (android.os.IBinder) com.google.android.gms.wearable.internal.ad
        public static class_189 method_3255(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                return (class_189)(var1 != null && var1 instanceof class_189?(class_189)var1:new class_189.class_1298(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 2:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var27 = var2.readInt();
                    class_1002 var28 = null;
                    if(var27 != 0) {
                        var28 = (class_1002)class_1002.CREATOR.createFromParcel(var2);
                    }

                    this.a(var28);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var23 = var2.readInt();
                    class_1068 var24 = null;
                    if(var23 != 0) {
                        var24 = (class_1068)class_1068.CREATOR.createFromParcel(var2);
                    }

                    this.a(var24);
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var21 = var2.readInt();
                    class_1003 var22 = null;
                    if(var21 != 0) {
                        var22 = (class_1003)class_1003.CREATOR.createFromParcel(var2);
                    }

                    this.a(var22);
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var19 = var2.readInt();
                    DataHolder var20 = null;
                    if(var19 != 0) {
                        var20 = DataHolder.CREATOR.method_5521(var2);
                    }

                    this.aa(var20);
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var17 = var2.readInt();
                    class_997 var18 = null;
                    if(var17 != 0) {
                        var18 = (class_997)class_997.CREATOR.createFromParcel(var2);
                    }

                    this.a(var18);
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var15 = var2.readInt();
                    class_1076 var16 = null;
                    if(var15 != 0) {
                        var16 = (class_1076)class_1076.CREATOR.createFromParcel(var2);
                    }

                    this.a(var16);
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var13 = var2.readInt();
                    class_1007 var14 = null;
                    if(var13 != 0) {
                        var14 = (class_1007)class_1007.CREATOR.createFromParcel(var2);
                    }

                    this.a(var14);
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var11 = var2.readInt();
                    class_1080 var12 = null;
                    if(var11 != 0) {
                        var12 = (class_1080)class_1080.CREATOR.createFromParcel(var2);
                    }

                    this.a(var12);
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var9 = var2.readInt();
                    class_1005 var10 = null;
                    if(var9 != 0) {
                        var10 = (class_1005)class_1005.CREATOR.createFromParcel(var2);
                    }

                    this.a(var10);
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var7 = var2.readInt();
                    Status var8 = null;
                    if(var7 != 0) {
                        var8 = Status.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8);
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var5 = var2.readInt();
                    class_1078 var6 = null;
                    if(var5 != 0) {
                        var6 = (class_1078)class_1078.CREATOR.createFromParcel(var2);
                    }

                    this.a(var6);
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    int var25 = var2.readInt();
                    class_1000 var26 = null;
                    if(var25 != 0) {
                        var26 = (class_1000)class_1000.CREATOR.createFromParcel(var2);
                    }

                    this.a(var26);
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1298 implements class_189 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2177;

        class_1298(IBinder var1) {
            this.field_2177 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.common.api.Status) void
        public void method_911(Status param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ab) void
        public void method_912(class_1080 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ao) void
        public void method_913(class_1068 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.as) void
        public void method_914(class_1076 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.au) void
        public void method_915(class_1078 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.p) void
        public void method_916(class_997 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.r) void
        public void method_917(class_1002 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.t) void
        public void method_918(class_1000 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.v) void
        public void method_919(class_1005 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.x) void
        public void method_920(class_1003 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.z) void
        public void method_921(class_1007 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: aa (com.google.android.gms.common.data.DataHolder) void
        public void method_922(DataHolder param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2177;
        }
    }
}
