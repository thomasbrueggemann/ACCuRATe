package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.common.internal.m
public interface class_193 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
    class_206 method_996(class_206 var1, int var2, int var3) throws RemoteException;

    public abstract static class class_1630 extends Binder implements class_193 {
        // $FF: renamed from: R (android.os.IBinder) com.google.android.gms.common.internal.m
        public static class_193 method_5083(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                return (class_193)(var1 != null && var1 instanceof class_193?(class_193)var1:new class_193.class_1631(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                    class_206 var5 = this.a(class_206.class_1795.method_5435(var2.readStrongBinder()), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    IBinder var6;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    } else {
                        var6 = null;
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1631 implements class_193 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4724;

        class_1631(IBinder var1) {
            this.field_4724 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, int, int) com.google.android.gms.dynamic.d
        public class_206 method_996(class_206 param1, int param2, int param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4724;
        }
    }
}
