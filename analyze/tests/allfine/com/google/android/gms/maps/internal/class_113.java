package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// $FF: renamed from: com.google.android.gms.maps.internal.n
public interface class_113 extends IInterface {
    boolean onMyLocationButtonClick() throws RemoteException;

    public abstract static class class_1595 extends Binder implements class_113 {
        public class_1595() {
            this.attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
        }

        // $FF: renamed from: be (android.os.IBinder) com.google.android.gms.maps.internal.n
        public static class_113 method_5264(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                return (class_113)(var1 != null && var1 instanceof class_113?(class_113)var1:new class_113.class_1596(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    boolean var5 = this.onMyLocationButtonClick();
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
                    var3.writeString("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1596 implements class_113 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4628;

        class_1596(IBinder var1) {
            this.field_4628 = var1;
        }

        public IBinder asBinder() {
            return this.field_4628;
        }

        public boolean onMyLocationButtonClick() throws RemoteException {
            boolean var1 = true;
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();
            boolean var8 = false;

            int var6;
            try {
                var8 = true;
                var2.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
                this.field_4628.transact(1, var2, var3, 0);
                var3.readException();
                var6 = var3.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var3.recycle();
                    var2.recycle();
                }
            }

            if(var6 == 0) {
                var1 = false;
            }

            var3.recycle();
            var2.recycle();
            return var1;
        }
    }
}
