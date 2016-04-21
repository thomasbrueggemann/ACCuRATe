package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.internal.class_242;
import com.google.android.gms.internal.class_39;

// $FF: renamed from: com.google.android.gms.internal.be
public interface class_6 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.ct, int) android.os.IBinder
    IBinder method_12(class_206 var1, class_242 var2, String var3, class_39 var4, int var5) throws RemoteException;

    public abstract static class class_1655 extends Binder implements class_6 {
        // $FF: renamed from: g (android.os.IBinder) com.google.android.gms.internal.be
        public static class_6 method_6000(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                return (class_6)(var1 != null && var1 instanceof class_6?(class_6)var1:new class_6.class_1656(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    class_206 var5 = class_206.class_1795.method_5435(var2.readStrongBinder());
                    class_242 var6;
                    if(var2.readInt() != 0) {
                        var6 = class_242.CREATOR.method_1592(var2);
                    } else {
                        var6 = null;
                    }

                    IBinder var7 = this.a(var5, var6, var2.readString(), class_39.class_1422.method_2832(var2.readStrongBinder()), var2.readInt());
                    var3.writeNoException();
                    var3.writeStrongBinder(var7);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.client.IAdManagerCreator");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1656 implements class_6 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4818;

        class_1656(IBinder var1) {
            this.field_4818 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.dynamic.d, com.google.android.gms.internal.ay, java.lang.String, com.google.android.gms.internal.ct, int) android.os.IBinder
        public IBinder method_12(class_206 param1, class_242 param2, String param3, class_39 param4, int param5) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4818;
        }
    }
}
