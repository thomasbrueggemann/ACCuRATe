package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_27;

// $FF: renamed from: com.google.android.gms.internal.et
public interface class_26 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.es) void
    void method_151(class_27 var1) throws RemoteException;

    // $FF: renamed from: e (java.lang.String, java.lang.String) boolean
    boolean method_152(String var1, String var2) throws RemoteException;

    public abstract static class class_1181 extends Binder implements class_26 {
        public class_1181() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
        }

        // $FF: renamed from: A (android.os.IBinder) com.google.android.gms.internal.et
        public static class_26 method_2681(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                return (class_26)(var1 != null && var1 instanceof class_26?(class_26)var1:new class_26.class_1182(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    boolean var5 = this.e(var2.readString(), var2.readString());
                    var3.writeNoException();
                    byte var6;
                    if(var5) {
                        var6 = 1;
                    } else {
                        var6 = 0;
                    }

                    var3.writeInt(var6);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    this.a(class_27.class_1462.method_2667(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1182 implements class_26 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_1136;

        class_1182(IBinder var1) {
            this.field_1136 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.es) void
        public void method_151(class_27 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_1136;
        }

        // $FF: renamed from: e (java.lang.String, java.lang.String) boolean
        public boolean method_152(String var1, String var2) throws RemoteException {
            boolean var3 = true;
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();
            boolean var10 = false;

            int var8;
            try {
                var10 = true;
                var4.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlPublisherAdViewListener");
                var4.writeString(var1);
                var4.writeString(var2);
                this.field_1136.transact(1, var4, var5, 0);
                var5.readException();
                var8 = var5.readInt();
                var10 = false;
            } finally {
                if(var10) {
                    var5.recycle();
                    var4.recycle();
                }
            }

            if(var8 == 0) {
                var3 = false;
            }

            var5.recycle();
            var4.recycle();
            return var3;
        }
    }
}
