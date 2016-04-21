package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.maps.model.internal.g
public interface class_57 extends IInterface {
    // $FF: renamed from: a (com.google.android.gms.maps.model.internal.g) boolean
    boolean method_299(class_57 var1) throws RemoteException;

    int getFillColor() throws RemoteException;

    List getHoles() throws RemoteException;

    String getId() throws RemoteException;

    List<LatLng> getPoints() throws RemoteException;

    int getStrokeColor() throws RemoteException;

    float getStrokeWidth() throws RemoteException;

    float getZIndex() throws RemoteException;

    int hashCodeRemote() throws RemoteException;

    boolean isGeodesic() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void remove() throws RemoteException;

    void setFillColor(int var1) throws RemoteException;

    void setGeodesic(boolean var1) throws RemoteException;

    void setHoles(List var1) throws RemoteException;

    void setPoints(List<LatLng> var1) throws RemoteException;

    void setStrokeColor(int var1) throws RemoteException;

    void setStrokeWidth(float var1) throws RemoteException;

    void setVisible(boolean var1) throws RemoteException;

    void setZIndex(float var1) throws RemoteException;

    public abstract static class class_1241 extends Binder implements class_57 {
        // $FF: renamed from: bv (android.os.IBinder) com.google.android.gms.maps.model.internal.g
        public static class_57 method_3180(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                return (class_57)(var1 != null && var1 instanceof class_57?(class_57)var1:new class_57.class_1242(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.remove();
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    String var22 = this.getId();
                    var3.writeNoException();
                    var3.writeString(var22);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setPoints(var2.createTypedArrayList(LatLng.CREATOR));
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    List var21 = this.getPoints();
                    var3.writeNoException();
                    var3.writeTypedList(var21);
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setHoles(var2.readArrayList(this.getClass().getClassLoader()));
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    List var20 = this.getHoles();
                    var3.writeNoException();
                    var3.writeList(var20);
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setStrokeWidth(var2.readFloat());
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    float var19 = this.getStrokeWidth();
                    var3.writeNoException();
                    var3.writeFloat(var19);
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setStrokeColor(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    int var18 = this.getStrokeColor();
                    var3.writeNoException();
                    var3.writeInt(var18);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setFillColor(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    int var17 = this.getFillColor();
                    var3.writeNoException();
                    var3.writeInt(var17);
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    this.setZIndex(var2.readFloat());
                    var3.writeNoException();
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    float var16 = this.getZIndex();
                    var3.writeNoException();
                    var3.writeFloat(var16);
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    int var14 = var2.readInt();
                    boolean var15 = false;
                    if(var14 != 0) {
                        var15 = true;
                    }

                    this.setVisible(var15);
                    var3.writeNoException();
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    boolean var12 = this.isVisible();
                    var3.writeNoException();
                    byte var13 = 0;
                    if(var12) {
                        var13 = 1;
                    }

                    var3.writeInt(var13);
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    int var10 = var2.readInt();
                    boolean var11 = false;
                    if(var10 != 0) {
                        var11 = true;
                    }

                    this.setGeodesic(var11);
                    var3.writeNoException();
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    boolean var8 = this.isGeodesic();
                    var3.writeNoException();
                    byte var9 = 0;
                    if(var8) {
                        var9 = 1;
                    }

                    var3.writeInt(var9);
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    boolean var6 = this.a(method_3180(var2.readStrongBinder()));
                    var3.writeNoException();
                    byte var7 = 0;
                    if(var6) {
                        var7 = 1;
                    }

                    var3.writeInt(var7);
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    int var5 = this.hashCodeRemote();
                    var3.writeNoException();
                    var3.writeInt(var5);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1242 implements class_57 {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_1985;

        class_1242(IBinder var1) {
            this.field_1985 = var1;
        }

        // $FF: renamed from: a (com.google.android.gms.maps.model.internal.g) boolean
        public boolean method_299(class_57 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_1985;
        }

        public int getFillColor() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(12, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public List getHoles() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            ArrayList var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(6, var1, var2, 0);
                var2.readException();
                var5 = var2.readArrayList(this.getClass().getClassLoader());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public String getId() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            String var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(2, var1, var2, 0);
                var2.readException();
                var5 = var2.readString();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public List<LatLng> getPoints() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            ArrayList var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(4, var1, var2, 0);
                var2.readException();
                var5 = var2.createTypedArrayList(LatLng.CREATOR);
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public int getStrokeColor() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(10, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public float getStrokeWidth() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            float var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(8, var1, var2, 0);
                var2.readException();
                var5 = var2.readFloat();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public float getZIndex() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            float var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(14, var1, var2, 0);
                var2.readException();
                var5 = var2.readFloat();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public int hashCodeRemote() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(20, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public boolean isGeodesic() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(18, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var2.recycle();
                    var1.recycle();
                }
            }

            boolean var6 = false;
            if(var5 != 0) {
                var6 = true;
            }

            var2.recycle();
            var1.recycle();
            return var6;
        }

        public boolean isVisible() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(16, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
                var8 = false;
            } finally {
                if(var8) {
                    var2.recycle();
                    var1.recycle();
                }
            }

            boolean var6 = false;
            if(var5 != 0) {
                var6 = true;
            }

            var2.recycle();
            var1.recycle();
            return var6;
        }

        public void remove() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                this.field_1985.transact(1, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public void setFillColor(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeInt(var1);
                this.field_1985.transact(11, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setGeodesic(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setHoles(List var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeList(var1);
                this.field_1985.transact(5, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setPoints(List<LatLng> var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeTypedList(var1);
                this.field_1985.transact(3, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setStrokeColor(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeInt(var1);
                this.field_1985.transact(9, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setStrokeWidth(float var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeFloat(var1);
                this.field_1985.transact(7, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setVisible(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setZIndex(float var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.model.internal.IPolygonDelegate");
                var2.writeFloat(var1);
                this.field_1985.transact(13, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }
    }
}
