package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.dynamic.d
public interface class_206 extends IInterface {
    public abstract static class class_1795 extends Binder implements class_206 {
        public class_1795() {
            this.attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        // $FF: renamed from: am (android.os.IBinder) com.google.android.gms.dynamic.d
        public static class_206 method_5435(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
                return (class_206)(var1 != null && var1 instanceof class_206?(class_206)var1:new class_206.class_1796(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1598968902:
                    var3.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1796 implements class_206 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4863;

        class_1796(IBinder var1) {
            this.field_4863 = var1;
        }

        public IBinder asBinder() {
            return this.field_4863;
        }
    }
}
