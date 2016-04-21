package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.class_34;

// $FF: renamed from: com.google.android.gms.internal.eh
public interface class_35 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.internal.eg) void
    void method_162(class_34 var1) throws RemoteException;

    public abstract static class class_1474 extends Binder implements class_35 {
        public class_1474() {
            this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        }

        // $FF: renamed from: t (android.os.IBinder) com.google.android.gms.internal.eh
        public static class_35 method_2669(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                return (class_35)(var1 != null && var1 instanceof class_35?(class_35)var1:new class_35.class_1475(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    this.a(class_34.class_1476.method_2888(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1475 implements class_35 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_5219;

        class_1475(IBinder var1) {
            this.field_5219 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.internal.eg) void
        public void method_162(class_34 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_5219;
        }
    }
}
