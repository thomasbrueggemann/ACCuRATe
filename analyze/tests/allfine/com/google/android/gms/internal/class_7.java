package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_223;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_26;
import com.google.android.gms.internal.class_29;
import com.google.android.gms.internal.class_33;
import com.google.android.gms.internal.class_35;
import com.google.android.gms.internal.class_4;
import com.google.android.gms.internal.class_5;

// $FF: renamed from: com.google.android.gms.internal.bd
public interface class_7 extends IInterface {
    // $FF: renamed from: X () com.google.android.gms.dynamic.d
    class_206 method_13() throws RemoteException;

    // $FF: renamed from: Y () com.google.android.gms.internal.ay
    class_242 method_14() throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.ay) void
    void method_15(class_242 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.bc) void
    void method_16(class_5 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.bf) void
    void method_17(class_4 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.eh) void
    void method_18(class_35 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.el, java.lang.String) void
    void method_19(class_33 var1, String var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.et) void
    void method_20(class_26 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.eu) void
    void method_21(class_29 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
    boolean method_22(class_223 var1) throws RemoteException;

    // $FF: renamed from: aj () void
    void method_23() throws RemoteException;

    void destroy() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    public abstract static class class_1579 extends Binder implements class_7 {
        public class_1579() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
        }

        // $FF: renamed from: f (android.os.IBinder) com.google.android.gms.internal.bd
        public static class_7 method_3274(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return (class_7)(var1 != null && var1 instanceof class_7?(class_7)var1:new class_7.class_1580(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    class_206 var15 = this.X();
                    var3.writeNoException();
                    IBinder var16 = null;
                    if(var15 != null) {
                        var16 = var15.asBinder();
                    }

                    var3.writeStrongBinder(var16);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.destroy();
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    boolean var13 = this.isReady();
                    var3.writeNoException();
                    byte var14;
                    if(var13) {
                        var14 = 1;
                    } else {
                        var14 = 0;
                    }

                    var3.writeInt(var14);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    int var9 = var2.readInt();
                    class_223 var10 = null;
                    if(var9 != 0) {
                        var10 = class_223.CREATOR.method_1501(var2);
                    }

                    boolean var11 = this.a(var10);
                    var3.writeNoException();
                    byte var12 = 0;
                    if(var11) {
                        var12 = 1;
                    }

                    var3.writeInt(var12);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.pause();
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.resume();
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_5.class_1256.method_1532(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_4.class_1321.method_1590(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.showInterstitial();
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.stopLoading();
                    var3.writeNoException();
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.aj();
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    class_242 var8 = this.Y();
                    var3.writeNoException();
                    if(var8 != null) {
                        var3.writeInt(1);
                        var8.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    int var6 = var2.readInt();
                    class_242 var7 = null;
                    if(var6 != 0) {
                        var7 = class_242.CREATOR.method_1592(var2);
                    }

                    this.a(var7);
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_35.class_1474.method_2669(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_33.class_1470.method_2668(var2.readStrongBinder()), var2.readString());
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_26.class_1181.method_2681(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    this.a(class_29.class_1466.method_2680(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
                    String var5 = this.getMediationAdapterClassName();
                    var3.writeNoException();
                    var3.writeString(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.client.IAdManager");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1580 implements class_7 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3472;

        class_1580(IBinder var1) {
            this.field_3472 = var1;
        }

        // $FF: renamed from: X () com.google.android.gms.dynamic.d
        public class_206 method_13() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            class_206 var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(1, var1, var2, 0);
                var2.readException();
                var5 = class_206.class_1795.method_5435(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: Y () com.google.android.gms.internal.ay
        public class_242 method_14() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            class_242 var5;
            label42: {
                class_242 var6;
                label41: {
                    try {
                        var8 = true;
                        var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                        this.field_3472.transact(12, var1, var2, 0);
                        var2.readException();
                        if(var2.readInt() != 0) {
                            var6 = class_242.CREATOR.method_1592(var2);
                            var8 = false;
                            break label41;
                        }

                        var8 = false;
                    } finally {
                        if(var8) {
                            var2.recycle();
                            var1.recycle();
                        }
                    }

                    var5 = null;
                    break label42;
                }

                var5 = var6;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.ay) void
        public void method_15(class_242 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.bc) void
        public void method_16(class_5 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.bf) void
        public void method_17(class_4 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.eh) void
        public void method_18(class_35 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.el, java.lang.String) void
        public void method_19(class_33 param1, String param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.et) void
        public void method_20(class_26 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.eu) void
        public void method_21(class_29 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.av) boolean
        public boolean method_22(class_223 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: aj () void
        public void method_23() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(11, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public IBinder asBinder() {
            return this.field_3472;
        }

        public void destroy() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(2, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public String getMediationAdapterClassName() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(18, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public boolean isReady() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(3, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var2.recycle();
                    var1.recycle();
                }
            }

            boolean var6 = false;
            if(var5 != 0) {
                var6 = true;
            }

            var2.recycle();
            var1.recycle();
            return var6;
        }

        public void pause() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(5, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void resume() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(6, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void showInterstitial() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(9, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void stopLoading() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
                this.field_3472.transact(10, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
