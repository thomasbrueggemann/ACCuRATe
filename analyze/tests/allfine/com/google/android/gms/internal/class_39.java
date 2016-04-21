package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_41;

// $FF: renamed from: com.google.android.gms.internal.ct
public interface class_39 extends IInterface {
    // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cu
    class_41 method_172(String var1) throws RemoteException;

    // $FF: renamed from: y (java.lang.String) boolean
    boolean method_173(String var1) throws RemoteException;

    public abstract static class class_1422 extends Binder implements class_39 {
        public class_1422() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        }

        // $FF: renamed from: l (android.os.IBinder) com.google.android.gms.internal.ct
        public static class_39 method_2832(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                return (class_39)(var1 != null && var1 instanceof class_39?(class_39)var1:new class_39.class_1423(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    class_41 var7 = this.x(var2.readString());
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
                    var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    boolean var5 = this.y(var2.readString());
                    var3.writeNoException();
                    byte var6;
                    if(var5) {
                        var6 = 1;
                    } else {
                        var6 = 0;
                    }

                    var3.writeInt(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1423 implements class_39 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5051;

        class_1423(IBinder var1) {
            this.field_5051 = var1;
        }

        public IBinder asBinder() {
            return this.field_5051;
        }

        // $FF: renamed from: x (java.lang.String) com.google.android.gms.internal.cu
        public class_41 method_172(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            class_41 var6;
            try {
                var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                var2.writeString(var1);
                this.field_5051.transact(1, var2, var3, 0);
                var3.readException();
                var6 = class_41.class_1252.method_2841(var3.readStrongBinder());
            } finally {
                var3.recycle();
                var2.recycle();
            }

            return var6;
        }

        // $FF: renamed from: y (java.lang.String) boolean
        public boolean method_173(String var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var9 = false;

            int var6;
            try {
                var9 = true;
                var2.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
                var2.writeString(var1);
                this.field_5051.transact(2, var2, var3, 0);
                var3.readException();
                var6 = var3.readInt();
                var9 = false;
            } finally {
                if(var9) {
                    var3.recycle();
                    var2.recycle();
                }
            }

            boolean var7 = false;
            if(var6 != 0) {
                var7 = true;
            }

            var3.recycle();
            var2.recycle();
            return var7;
        }
    }
}
