package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;

// $FF: renamed from: com.google.android.gms.internal.es
public interface class_27 extends IInterface {
    // $FF: renamed from: ar () void
    void method_153() throws RemoteException;

    // $FF: renamed from: as () void
    void method_154() throws RemoteException;

    // $FF: renamed from: c (com.google.android.gms.dynamic.d) void
    void method_155(class_206 var1) throws RemoteException;

    // $FF: renamed from: cu () java.lang.String
    String method_156() throws RemoteException;

    // $FF: renamed from: cv () java.lang.String
    String method_157() throws RemoteException;

    public abstract static class class_1462 extends Binder implements class_27 {
        public class_1462() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
        }

        // $FF: renamed from: z (android.os.IBinder) com.google.android.gms.internal.es
        public static class_27 method_2667(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                return (class_27)(var1 != null && var1 instanceof class_27?(class_27)var1:new class_27.class_1463(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    String var6 = this.cu();
                    var3.writeNoException();
                    var3.writeString(var6);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    String var5 = this.cv();
                    var3.writeNoException();
                    var3.writeString(var5);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.c(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.ar();
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    this.as();
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1463 implements class_27 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_3969;

        class_1463(IBinder var1) {
            this.field_3969 = var1;
        }

        // $FF: renamed from: ar () void
        public void method_153() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                this.field_3969.transact(4, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        // $FF: renamed from: as () void
        public void method_154() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                this.field_3969.transact(5, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public IBinder asBinder() {
            return this.field_3969;
        }

        // $FF: renamed from: c (com.google.android.gms.dynamic.d) void
        public void method_155(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        // $FF: renamed from: cu () java.lang.String
        public String method_156() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                this.field_3969.transact(1, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        // $FF: renamed from: cv () java.lang.String
        public String method_157() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
                this.field_3969.transact(2, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }
    }
}
