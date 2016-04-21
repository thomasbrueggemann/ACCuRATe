package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_23;
import com.google.android.gms.internal.class_397;
import com.google.android.gms.internal.class_407;

// $FF: renamed from: com.google.android.gms.internal.hv
public interface class_22 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.hm$a, com.google.android.gms.internal.hw) void
    void method_139(class_407.class_1640 var1, class_23 var2) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.hw) void
    void method_140(class_23 var1) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.hw, java.lang.String, com.google.android.gms.internal.hs[]) void
    void method_141(class_23 var1, String var2, class_397[] var3) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.internal.hw, boolean) void
    void method_142(class_23 var1, boolean var2) throws RemoteException;

    // $FF: renamed from: b (com.google.android.gms.internal.hw) void
    void method_143(class_23 var1) throws RemoteException;

    public abstract static class class_1367 extends Binder implements class_22 {
        // $FF: renamed from: F (android.os.IBinder) com.google.android.gms.internal.hv
        public static class_22 method_5795(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                return (class_22)(var1 != null && var1 instanceof class_22?(class_22)var1:new class_22.class_1368(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    this.a(class_23.class_1457.method_2600(var2.readStrongBinder()), var2.readString(), (class_397[])var2.createTypedArray(class_397.CREATOR));
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    this.a(class_23.class_1457.method_2600(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    this.b(class_23.class_1457.method_2600(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    class_23 var6 = class_23.class_1457.method_2600(var2.readStrongBinder());
                    boolean var7;
                    if(var2.readInt() != 0) {
                        var7 = true;
                    } else {
                        var7 = false;
                    }

                    this.a(var6, var7);
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    class_407.class_1640 var5;
                    if(var2.readInt() != 0) {
                        var5 = class_407.class_1640.CREATOR.method_2644(var2);
                    } else {
                        var5 = null;
                    }

                    this.a(var5, class_23.class_1457.method_2600(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1368 implements class_22 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2945;

        class_1368(IBinder var1) {
            this.field_2945 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hm$a, com.google.android.gms.internal.hw) void
        public void method_139(class_407.class_1640 param1, class_23 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hw) void
        public void method_140(class_23 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hw, java.lang.String, com.google.android.gms.internal.hs[]) void
        public void method_141(class_23 param1, String param2, class_397[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.internal.hw, boolean) void
        public void method_142(class_23 param1, boolean param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2945;
        }

        // $FF: renamed from: b (com.google.android.gms.internal.hw) void
        public void method_143(class_23 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
