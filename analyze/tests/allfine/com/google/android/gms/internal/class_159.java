package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_872;
import com.google.android.gms.internal.class_876;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.nm;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.nh
public interface class_159 extends IInterface {
    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
    void method_790(String var1, class_876 var2, class_872 var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, java.util.List) void
    void method_791(String var1, nm var2, List<ni> var3) throws RemoteException;

    // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, byte[]) void
    void method_792(String var1, class_876 var2, byte[] var3) throws RemoteException;

    public abstract static class class_1542 extends Binder implements class_159 {
        // $FF: renamed from: bC (android.os.IBinder) com.google.android.gms.internal.nh
        public static class_159 method_5790(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                return (class_159)(var1 != null && var1 instanceof class_159?(class_159)var1:new class_159.class_1543(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 2:
                    var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String var11 = var2.readString();
                    class_876 var12;
                    if(var2.readInt() != 0) {
                        var12 = class_876.CREATOR.method_4526(var2);
                    } else {
                        var12 = null;
                    }

                    int var13 = var2.readInt();
                    class_872 var14 = null;
                    if(var13 != 0) {
                        var14 = class_872.CREATOR.method_4539(var2);
                    }

                    this.a(var11, var12, var14);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String var8 = var2.readString();
                    int var9 = var2.readInt();
                    class_876 var10 = null;
                    if(var9 != 0) {
                        var10 = class_876.CREATOR.method_4526(var2);
                    }

                    this.a(var8, var10, var2.createTypedArrayList(class_872.CREATOR));
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.playlog.internal.IPlayLogService");
                    String var5 = var2.readString();
                    int var6 = var2.readInt();
                    class_876 var7 = null;
                    if(var6 != 0) {
                        var7 = class_876.CREATOR.method_4526(var2);
                    }

                    this.a(var5, var7, var2.createByteArray());
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.playlog.internal.IPlayLogService");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1543 implements class_159 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4532;

        class_1543(IBinder var1) {
            this.field_4532 = var1;
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, com.google.android.gms.internal.ni) void
        public void method_790(String param1, class_876 param2, class_872 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, java.util.List) void
        public void method_791(String param1, nm param2, List<ni> param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (java.lang.String, com.google.android.gms.internal.nm, byte[]) void
        public void method_792(String param1, class_876 param2, byte[] param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4532;
        }
    }
}
