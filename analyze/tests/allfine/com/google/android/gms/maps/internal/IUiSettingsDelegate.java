package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUiSettingsDelegate extends IInterface {
    boolean isCompassEnabled() throws RemoteException;

    boolean isIndoorLevelPickerEnabled() throws RemoteException;

    boolean isMyLocationButtonEnabled() throws RemoteException;

    boolean isRotateGesturesEnabled() throws RemoteException;

    boolean isScrollGesturesEnabled() throws RemoteException;

    boolean isTiltGesturesEnabled() throws RemoteException;

    boolean isZoomControlsEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    void setAllGesturesEnabled(boolean var1) throws RemoteException;

    void setCompassEnabled(boolean var1) throws RemoteException;

    void setIndoorLevelPickerEnabled(boolean var1) throws RemoteException;

    void setMyLocationButtonEnabled(boolean var1) throws RemoteException;

    void setRotateGesturesEnabled(boolean var1) throws RemoteException;

    void setScrollGesturesEnabled(boolean var1) throws RemoteException;

    void setTiltGesturesEnabled(boolean var1) throws RemoteException;

    void setZoomControlsEnabled(boolean var1) throws RemoteException;

    void setZoomGesturesEnabled(boolean var1) throws RemoteException;

    public abstract static class class_1793 extends Binder implements IUiSettingsDelegate {
        // $FF: renamed from: bo (android.os.IBinder) com.google.android.gms.maps.internal.IUiSettingsDelegate
        public static IUiSettingsDelegate method_5433(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                return (IUiSettingsDelegate)(var1 != null && var1 instanceof IUiSettingsDelegate?(IUiSettingsDelegate)var1:new IUiSettingsDelegate.class_1794(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var37 = var2.readInt();
                    boolean var38 = false;
                    if(var37 != 0) {
                        var38 = true;
                    }

                    this.setZoomControlsEnabled(var38);
                    var3.writeNoException();
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var35 = var2.readInt();
                    boolean var36 = false;
                    if(var35 != 0) {
                        var36 = true;
                    }

                    this.setCompassEnabled(var36);
                    var3.writeNoException();
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var33 = var2.readInt();
                    boolean var34 = false;
                    if(var33 != 0) {
                        var34 = true;
                    }

                    this.setMyLocationButtonEnabled(var34);
                    var3.writeNoException();
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var31 = var2.readInt();
                    boolean var32 = false;
                    if(var31 != 0) {
                        var32 = true;
                    }

                    this.setScrollGesturesEnabled(var32);
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var29 = var2.readInt();
                    boolean var30 = false;
                    if(var29 != 0) {
                        var30 = true;
                    }

                    this.setZoomGesturesEnabled(var30);
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var27 = var2.readInt();
                    boolean var28 = false;
                    if(var27 != 0) {
                        var28 = true;
                    }

                    this.setTiltGesturesEnabled(var28);
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var25 = var2.readInt();
                    boolean var26 = false;
                    if(var25 != 0) {
                        var26 = true;
                    }

                    this.setRotateGesturesEnabled(var26);
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var23 = var2.readInt();
                    boolean var24 = false;
                    if(var23 != 0) {
                        var24 = true;
                    }

                    this.setAllGesturesEnabled(var24);
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var21 = this.isZoomControlsEnabled();
                    var3.writeNoException();
                    byte var22 = 0;
                    if(var21) {
                        var22 = 1;
                    }

                    var3.writeInt(var22);
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var19 = this.isCompassEnabled();
                    var3.writeNoException();
                    byte var20 = 0;
                    if(var19) {
                        var20 = 1;
                    }

                    var3.writeInt(var20);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var17 = this.isMyLocationButtonEnabled();
                    var3.writeNoException();
                    byte var18 = 0;
                    if(var17) {
                        var18 = 1;
                    }

                    var3.writeInt(var18);
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var15 = this.isScrollGesturesEnabled();
                    var3.writeNoException();
                    byte var16 = 0;
                    if(var15) {
                        var16 = 1;
                    }

                    var3.writeInt(var16);
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var13 = this.isZoomGesturesEnabled();
                    var3.writeNoException();
                    byte var14 = 0;
                    if(var13) {
                        var14 = 1;
                    }

                    var3.writeInt(var14);
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var11 = this.isTiltGesturesEnabled();
                    var3.writeNoException();
                    byte var12 = 0;
                    if(var11) {
                        var12 = 1;
                    }

                    var3.writeInt(var12);
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var9 = this.isRotateGesturesEnabled();
                    var3.writeNoException();
                    byte var10 = 0;
                    if(var9) {
                        var10 = 1;
                    }

                    var3.writeInt(var10);
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    int var7 = var2.readInt();
                    boolean var8 = false;
                    if(var7 != 0) {
                        var8 = true;
                    }

                    this.setIndoorLevelPickerEnabled(var8);
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    boolean var5 = this.isIndoorLevelPickerEnabled();
                    var3.writeNoException();
                    byte var6 = 0;
                    if(var5) {
                        var6 = 1;
                    }

                    var3.writeInt(var6);
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1794 implements IUiSettingsDelegate {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4788;

        class_1794(IBinder var1) {
            this.field_4788 = var1;
        }

        public IBinder asBinder() {
            return this.field_4788;
        }

        public boolean isCompassEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(10, var1, var2, 0);
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

        public boolean isIndoorLevelPickerEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(17, var1, var2, 0);
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

        public boolean isMyLocationButtonEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(11, var1, var2, 0);
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

        public boolean isRotateGesturesEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(15, var1, var2, 0);
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

        public boolean isScrollGesturesEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(12, var1, var2, 0);
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

        public boolean isTiltGesturesEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(14, var1, var2, 0);
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

        public boolean isZoomControlsEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(9, var1, var2, 0);
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

        public boolean isZoomGesturesEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                this.field_4788.transact(13, var1, var2, 0);
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

        public void setAllGesturesEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setCompassEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setIndoorLevelPickerEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setMyLocationButtonEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setRotateGesturesEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setScrollGesturesEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setTiltGesturesEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setZoomControlsEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setZoomGesturesEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }
    }
}
