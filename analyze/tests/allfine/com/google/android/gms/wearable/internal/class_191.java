package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.class_1048;
import com.google.android.gms.wearable.internal.class_1008;
import com.google.android.gms.wearable.internal.class_1070;
import com.google.android.gms.wearable.internal.class_189;

// $FF: renamed from: com.google.android.gms.wearable.internal.af
public interface class_191 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad) void
    void method_927(class_189 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
    void method_928(class_189 var1, Uri var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.Asset) void
    void method_929(class_189 var1, Asset var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.PutDataRequest) void
    void method_930(class_189 var1, PutDataRequest var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
    void method_931(class_189 var1, class_1048 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.aq) void
    void method_932(class_189 var1, class_1070 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.b) void
    void method_933(class_189 var1, class_1008 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String) void
    void method_934(class_189 var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String, java.lang.String, byte[]) void
    void method_935(class_189 var1, String var2, String var3, byte[] var4) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad) void
    void method_936(class_189 var1) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
    void method_937(class_189 var1, Uri var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
    void method_938(class_189 var1, class_1048 var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, java.lang.String) void
    void method_939(class_189 var1, String var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad) void
    void method_940(class_189 var1) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
    void method_941(class_189 var1, Uri var2) throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, java.lang.String) void
    void method_942(class_189 var1, String var2) throws RemoteException;

    // $FF: renamed from: d (com.google.android.gms.wearable.internal.ad) void
    void method_943(class_189 var1) throws RemoteException;

    // $FF: renamed from: e (com.google.android.gms.wearable.internal.ad) void
    void method_944(class_189 var1) throws RemoteException;

    // $FF: renamed from: f (com.google.android.gms.wearable.internal.ad) void
    void method_945(class_189 var1) throws RemoteException;

    // $FF: renamed from: g (com.google.android.gms.wearable.internal.ad) void
    void method_946(class_189 var1) throws RemoteException;

    // $FF: renamed from: h (com.google.android.gms.wearable.internal.ad) void
    void method_947(class_189 var1) throws RemoteException;

    // $FF: renamed from: i (com.google.android.gms.wearable.internal.ad) void
    void method_948(class_189 var1) throws RemoteException;

    public abstract static class class_1208 extends Binder implements class_191 {
        // $FF: renamed from: bT (android.os.IBinder) com.google.android.gms.wearable.internal.af
        public static class_191 method_2682(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                return (class_191)(var1 != null && var1 instanceof class_191?(class_191)var1:new class_191.class_1209(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 2:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var5 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var6 = var2.readInt();
                    class_1048 var7 = null;
                    if(var6 != 0) {
                        var7 = (class_1048)class_1048.CREATOR.createFromParcel(var2);
                    }

                    this.b(var5, var7);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.g(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.h(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.i(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var26 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var27 = var2.readInt();
                    PutDataRequest var28 = null;
                    if(var27 != 0) {
                        var28 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(var2);
                    }

                    this.a(var26, var28);
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var23 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var24 = var2.readInt();
                    Uri var25 = null;
                    if(var24 != 0) {
                        var25 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    }

                    this.a(var23, var25);
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.b(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var20 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var21 = var2.readInt();
                    Uri var22 = null;
                    if(var21 != 0) {
                        var22 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    }

                    this.b(var20, var22);
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var17 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var18 = var2.readInt();
                    Uri var19 = null;
                    if(var18 != 0) {
                        var19 = (Uri)Uri.CREATOR.createFromParcel(var2);
                    }

                    this.c(var17, var19);
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.a(class_189.class_1297.method_3255(var2.readStrongBinder()), var2.readString(), var2.readString(), var2.createByteArray());
                    var3.writeNoException();
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var14 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var15 = var2.readInt();
                    Asset var16 = null;
                    if(var15 != 0) {
                        var16 = (Asset)Asset.CREATOR.createFromParcel(var2);
                    }

                    this.a(var14, var16);
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.c(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.d(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var11 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var12 = var2.readInt();
                    class_1008 var13 = null;
                    if(var12 != 0) {
                        var13 = (class_1008)class_1008.CREATOR.createFromParcel(var2);
                    }

                    this.a(var11, var13);
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var8 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var9 = var2.readInt();
                    class_1070 var10 = null;
                    if(var9 != 0) {
                        var10 = (class_1070)class_1070.CREATOR.createFromParcel(var2);
                    }

                    this.a(var8, var10);
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.e(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.f(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    class_189 var29 = class_189.class_1297.method_3255(var2.readStrongBinder());
                    int var30 = var2.readInt();
                    class_1048 var31 = null;
                    if(var30 != 0) {
                        var31 = (class_1048)class_1048.CREATOR.createFromParcel(var2);
                    }

                    this.a(var29, var31);
                    var3.writeNoException();
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.a(class_189.class_1297.method_3255(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.a(class_189.class_1297.method_3255(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.b(class_189.class_1297.method_3255(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
                    this.c(class_189.class_1297.method_3255(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.wearable.internal.IWearableService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1209 implements class_191 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3937;

        class_1209(IBinder var1) {
            this.field_3937 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad) void
        public void method_927(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
        public void method_928(class_189 param1, Uri param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.Asset) void
        public void method_929(class_189 param1, Asset param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.PutDataRequest) void
        public void method_930(class_189 param1, PutDataRequest param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
        public void method_931(class_189 param1, class_1048 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.aq) void
        public void method_932(class_189 param1, class_1070 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.internal.b) void
        public void method_933(class_189 param1, class_1008 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String) void
        public void method_934(class_189 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.wearable.internal.ad, java.lang.String, java.lang.String, byte[]) void
        public void method_935(class_189 param1, String param2, String param3, byte[] param4) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_3937;
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad) void
        public void method_936(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
        public void method_937(class_189 param1, Uri param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, com.google.android.gms.wearable.c) void
        public void method_938(class_189 param1, class_1048 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: b (com.google.android.gms.wearable.internal.ad, java.lang.String) void
        public void method_939(class_189 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad) void
        public void method_940(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, android.net.Uri) void
        public void method_941(class_189 param1, Uri param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: c (com.google.android.gms.wearable.internal.ad, java.lang.String) void
        public void method_942(class_189 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: d (com.google.android.gms.wearable.internal.ad) void
        public void method_943(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: e (com.google.android.gms.wearable.internal.ad) void
        public void method_944(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: f (com.google.android.gms.wearable.internal.ad) void
        public void method_945(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: g (com.google.android.gms.wearable.internal.ad) void
        public void method_946(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: h (com.google.android.gms.wearable.internal.ad) void
        public void method_947(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: i (com.google.android.gms.wearable.internal.ad) void
        public void method_948(class_189 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
