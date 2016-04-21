package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.plus.internal.c
public interface class_185 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int, java.lang.String, int) com.google.android.gms.dynamic.d
    class_206 method_868(class_206 var1, int var2, int var3, String var4, int var5) throws RemoteException;

    // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int, java.lang.String, java.lang.String) com.google.android.gms.dynamic.d
    class_206 method_869(class_206 var1, int var2, int var3, String var4, String var5) throws RemoteException;

    public abstract static class class_1369 extends Binder implements class_185 {
        // $FF: renamed from: bF (android.os.IBinder) com.google.android.gms.plus.internal.c
        public static class_185 method_4932(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                return (class_185)(var1 != null && var1 instanceof class_185?(class_185)var1:new class_185.class_1370(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    class_206 var7 = this.a(class_206.class_1795.method_5435(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readInt());
                    var3.writeNoException();
                    IBinder var8;
                    if(var7 != null) {
                        var8 = var7.asBinder();
                    } else {
                        var8 = null;
                    }

                    var3.writeStrongBinder(var8);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    class_206 var5 = this.a(class_206.class_1795.method_5435(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readString());
                    var3.writeNoException();
                    IBinder var6 = null;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1370 implements class_185 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_2946;

        class_1370(IBinder var1) {
            this.field_2946 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int, java.lang.String, int) com.google.android.gms.dynamic.d
        public class_206 method_868(class_206 param1, int param2, int param3, String param4, int param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int, java.lang.String, java.lang.String) com.google.android.gms.dynamic.d
        public class_206 method_869(class_206 param1, int param2, int param3, String param4, String param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_2946;
        }
    }
}
