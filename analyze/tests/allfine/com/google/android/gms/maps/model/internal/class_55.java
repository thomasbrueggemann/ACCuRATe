package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

// $FF: renamed from: com.google.android.gms.maps.model.internal.i
public interface class_55 extends IInterface {
    Tile getTile(int var1, int var2, int var3) throws RemoteException;

    public abstract static class class_1801 extends Binder implements class_55 {
        public class_1801() {
            this.attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        // $FF: renamed from: by (android.os.IBinder) com.google.android.gms.maps.model.internal.i
        public static class_55 method_3051(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                return (class_55)(var1 != null && var1 instanceof class_55?(class_55)var1:new class_55.class_1802(var0));
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    Tile var5 = this.getTile(var2.readInt(), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    if(var5 != null) {
                        var3.writeInt(1);
                        var5.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1802 implements class_55 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4807;

        class_1802(IBinder var1) {
            this.field_4807 = var1;
        }

        public IBinder asBinder() {
            return this.field_4807;
        }

        public Tile getTile(int var1, int var2, int var3) throws RemoteException {
            Parcel var4 = Parcel.obtain();
            Parcel var5 = Parcel.obtain();
            boolean var11 = false;

            Tile var8;
            label42: {
                Tile var9;
                label41: {
                    try {
                        var11 = true;
                        var4.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                        var4.writeInt(var1);
                        var4.writeInt(var2);
                        var4.writeInt(var3);
                        this.field_4807.transact(1, var4, var5, 0);
                        var5.readException();
                        if(var5.readInt() != 0) {
                            var9 = Tile.CREATOR.method_5120(var5);
                            var11 = false;
                            break label41;
                        }

                        var11 = false;
                    } finally {
                        if(var11) {
                            var5.recycle();
                            var4.recycle();
                        }
                    }

                    var8 = null;
                    break label42;
                }

                var8 = var9;
            }

            var5.recycle();
            var4.recycle();
            return var8;
        }
    }
}
