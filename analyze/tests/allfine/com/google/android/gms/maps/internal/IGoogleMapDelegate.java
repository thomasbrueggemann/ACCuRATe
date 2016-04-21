package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_206;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.class_111;
import com.google.android.gms.maps.internal.class_112;
import com.google.android.gms.maps.internal.class_113;
import com.google.android.gms.maps.internal.class_114;
import com.google.android.gms.maps.internal.class_118;
import com.google.android.gms.maps.internal.class_119;
import com.google.android.gms.maps.internal.class_120;
import com.google.android.gms.maps.internal.class_121;
import com.google.android.gms.maps.internal.class_122;
import com.google.android.gms.maps.internal.class_124;
import com.google.android.gms.maps.internal.class_125;
import com.google.android.gms.maps.internal.class_126;
import com.google.android.gms.maps.internal.class_128;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.class_54;
import com.google.android.gms.maps.model.internal.class_56;
import com.google.android.gms.maps.model.internal.class_57;
import com.google.android.gms.maps.model.internal.class_59;
import com.google.android.gms.maps.model.internal.class_61;
import com.google.android.gms.maps.model.internal.class_62;

public interface IGoogleMapDelegate extends IInterface {
    class_61 addCircle(CircleOptions var1) throws RemoteException;

    class_62 addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

    class_56 addMarker(MarkerOptions var1) throws RemoteException;

    class_57 addPolygon(PolygonOptions var1) throws RemoteException;

    IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

    class_54 addTileOverlay(TileOverlayOptions var1) throws RemoteException;

    void animateCamera(class_206 var1) throws RemoteException;

    void animateCameraWithCallback(class_206 var1, class_128 var2) throws RemoteException;

    void animateCameraWithDurationAndCallback(class_206 var1, int var2, class_128 var3) throws RemoteException;

    void clear() throws RemoteException;

    CameraPosition getCameraPosition() throws RemoteException;

    class_59 getFocusedBuilding() throws RemoteException;

    int getMapType() throws RemoteException;

    float getMaxZoomLevel() throws RemoteException;

    float getMinZoomLevel() throws RemoteException;

    Location getMyLocation() throws RemoteException;

    IProjectionDelegate getProjection() throws RemoteException;

    IUiSettingsDelegate getUiSettings() throws RemoteException;

    boolean isBuildingsEnabled() throws RemoteException;

    boolean isIndoorEnabled() throws RemoteException;

    boolean isMyLocationEnabled() throws RemoteException;

    boolean isTrafficEnabled() throws RemoteException;

    void moveCamera(class_206 var1) throws RemoteException;

    void setBuildingsEnabled(boolean var1) throws RemoteException;

    boolean setIndoorEnabled(boolean var1) throws RemoteException;

    void setInfoWindowAdapter(class_119 var1) throws RemoteException;

    void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

    void setMapType(int var1) throws RemoteException;

    void setMyLocationEnabled(boolean var1) throws RemoteException;

    void setOnCameraChangeListener(class_120 var1) throws RemoteException;

    void setOnIndoorStateChangeListener(class_121 var1) throws RemoteException;

    void setOnInfoWindowClickListener(class_122 var1) throws RemoteException;

    void setOnMapClickListener(class_124 var1) throws RemoteException;

    void setOnMapLoadedCallback(class_125 var1) throws RemoteException;

    void setOnMapLongClickListener(class_126 var1) throws RemoteException;

    void setOnMarkerClickListener(class_111 var1) throws RemoteException;

    void setOnMarkerDragListener(class_112 var1) throws RemoteException;

    void setOnMyLocationButtonClickListener(class_113 var1) throws RemoteException;

    void setOnMyLocationChangeListener(class_114 var1) throws RemoteException;

    void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

    void setTrafficEnabled(boolean var1) throws RemoteException;

    void snapshot(class_118 var1, class_206 var2) throws RemoteException;

    void stopAnimation() throws RemoteException;

    public abstract static class class_1308 extends Binder implements IGoogleMapDelegate {
        // $FF: renamed from: aQ (android.os.IBinder) com.google.android.gms.maps.internal.IGoogleMapDelegate
        public static IGoogleMapDelegate method_3121(IBinder var0) {
            if(var0 == null) {
                return null;
            } else {
                IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                return (IGoogleMapDelegate)(var1 != null && var1 instanceof IGoogleMapDelegate?(IGoogleMapDelegate)var1:new IGoogleMapDelegate.class_1309(var0));
            }
        }

        public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
            switch(var1) {
                case 1:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CameraPosition var50 = this.getCameraPosition();
                    var3.writeNoException();
                    if(var50 != null) {
                        var3.writeInt(1);
                        var50.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 2:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float var49 = this.getMaxZoomLevel();
                    var3.writeNoException();
                    var3.writeFloat(var49);
                    return true;
                case 3:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    float var48 = this.getMinZoomLevel();
                    var3.writeNoException();
                    var3.writeFloat(var48);
                    return true;
                case 4:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.moveCamera(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 5:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCamera(class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 6:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCameraWithCallback(class_206.class_1795.method_5435(var2.readStrongBinder()), class_128.class_1603.method_4196(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 7:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.animateCameraWithDurationAndCallback(class_206.class_1795.method_5435(var2.readStrongBinder()), var2.readInt(), class_128.class_1603.method_4196(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 8:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.stopAnimation();
                    var3.writeNoException();
                    return true;
                case 9:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    PolylineOptions var45;
                    if(var2.readInt() != 0) {
                        var45 = PolylineOptions.CREATOR.method_5165(var2);
                    } else {
                        var45 = null;
                    }

                    IPolylineDelegate var46 = this.addPolyline(var45);
                    var3.writeNoException();
                    IBinder var47 = null;
                    if(var46 != null) {
                        var47 = var46.asBinder();
                    }

                    var3.writeStrongBinder(var47);
                    return true;
                case 10:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    PolygonOptions var42;
                    if(var2.readInt() != 0) {
                        var42 = PolygonOptions.CREATOR.method_5169(var2);
                    } else {
                        var42 = null;
                    }

                    class_57 var43 = this.addPolygon(var42);
                    var3.writeNoException();
                    IBinder var44 = null;
                    if(var43 != null) {
                        var44 = var43.asBinder();
                    }

                    var3.writeStrongBinder(var44);
                    return true;
                case 11:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    MarkerOptions var39;
                    if(var2.readInt() != 0) {
                        var39 = MarkerOptions.CREATOR.method_5157(var2);
                    } else {
                        var39 = null;
                    }

                    class_56 var40 = this.addMarker(var39);
                    var3.writeNoException();
                    IBinder var41 = null;
                    if(var40 != null) {
                        var41 = var40.asBinder();
                    }

                    var3.writeStrongBinder(var41);
                    return true;
                case 12:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    GroundOverlayOptions var36;
                    if(var2.readInt() != 0) {
                        var36 = GroundOverlayOptions.CREATOR.method_5153(var2);
                    } else {
                        var36 = null;
                    }

                    class_62 var37 = this.addGroundOverlay(var36);
                    var3.writeNoException();
                    IBinder var38 = null;
                    if(var37 != null) {
                        var38 = var37.asBinder();
                    }

                    var3.writeStrongBinder(var38);
                    return true;
                case 13:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    TileOverlayOptions var33;
                    if(var2.readInt() != 0) {
                        var33 = TileOverlayOptions.CREATOR.method_5126(var2);
                    } else {
                        var33 = null;
                    }

                    class_54 var34 = this.addTileOverlay(var33);
                    var3.writeNoException();
                    IBinder var35 = null;
                    if(var34 != null) {
                        var35 = var34.asBinder();
                    }

                    var3.writeStrongBinder(var35);
                    return true;
                case 14:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.clear();
                    var3.writeNoException();
                    return true;
                case 15:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int var32 = this.getMapType();
                    var3.writeNoException();
                    var3.writeInt(var32);
                    return true;
                case 16:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setMapType(var2.readInt());
                    var3.writeNoException();
                    return true;
                case 17:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean var30 = this.isTrafficEnabled();
                    var3.writeNoException();
                    byte var31 = 0;
                    if(var30) {
                        var31 = 1;
                    }

                    var3.writeInt(var31);
                    return true;
                case 18:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int var28 = var2.readInt();
                    boolean var29 = false;
                    if(var28 != 0) {
                        var29 = true;
                    }

                    this.setTrafficEnabled(var29);
                    var3.writeNoException();
                    return true;
                case 19:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean var26 = this.isIndoorEnabled();
                    var3.writeNoException();
                    byte var27 = 0;
                    if(var26) {
                        var27 = 1;
                    }

                    var3.writeInt(var27);
                    return true;
                case 20:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean var23;
                    if(var2.readInt() != 0) {
                        var23 = true;
                    } else {
                        var23 = false;
                    }

                    boolean var24 = this.setIndoorEnabled(var23);
                    var3.writeNoException();
                    byte var25 = 0;
                    if(var24) {
                        var25 = 1;
                    }

                    var3.writeInt(var25);
                    return true;
                case 21:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean var21 = this.isMyLocationEnabled();
                    var3.writeNoException();
                    byte var22 = 0;
                    if(var21) {
                        var22 = 1;
                    }

                    var3.writeInt(var22);
                    return true;
                case 22:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int var19 = var2.readInt();
                    boolean var20 = false;
                    if(var19 != 0) {
                        var20 = true;
                    }

                    this.setMyLocationEnabled(var20);
                    var3.writeNoException();
                    return true;
                case 23:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    Location var18 = this.getMyLocation();
                    var3.writeNoException();
                    if(var18 != null) {
                        var3.writeInt(1);
                        var18.writeToParcel(var3, 1);
                        return true;
                    }

                    var3.writeInt(0);
                    return true;
                case 24:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setLocationSource(ILocationSourceDelegate.class_1653.method_5263(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 25:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IUiSettingsDelegate var16 = this.getUiSettings();
                    var3.writeNoException();
                    IBinder var17 = null;
                    if(var16 != null) {
                        var17 = var16.asBinder();
                    }

                    var3.writeStrongBinder(var17);
                    return true;
                case 26:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    IProjectionDelegate var14 = this.getProjection();
                    var3.writeNoException();
                    IBinder var15 = null;
                    if(var14 != null) {
                        var15 = var14.asBinder();
                    }

                    var3.writeStrongBinder(var15);
                    return true;
                case 27:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnCameraChangeListener(class_120.class_1170.method_5208(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 28:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMapClickListener(class_124.class_1223.method_2844(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 29:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMapLongClickListener(class_126.class_1605.method_4200(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 30:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMarkerClickListener(class_111.class_1550.method_3705(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 31:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMarkerDragListener(class_112.class_1589.method_3706(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 32:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnInfoWindowClickListener(class_122.class_1258.method_3708(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 33:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setInfoWindowAdapter(class_119.class_1591.method_3707(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 35:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    CircleOptions var11;
                    if(var2.readInt() != 0) {
                        var11 = CircleOptions.CREATOR.method_5182(var2);
                    } else {
                        var11 = null;
                    }

                    class_61 var12 = this.addCircle(var11);
                    var3.writeNoException();
                    IBinder var13 = null;
                    if(var12 != null) {
                        var13 = var12.asBinder();
                    }

                    var3.writeStrongBinder(var13);
                    return true;
                case 36:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMyLocationChangeListener(class_114.class_1597.method_5261(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 37:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMyLocationButtonClickListener(class_113.class_1595.method_5264(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 38:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.snapshot(class_118.class_1593.method_4403(var2.readStrongBinder()), class_206.class_1795.method_5435(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 39:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setPadding(var2.readInt(), var2.readInt(), var2.readInt(), var2.readInt());
                    var3.writeNoException();
                    return true;
                case 40:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    boolean var9 = this.isBuildingsEnabled();
                    var3.writeNoException();
                    byte var10 = 0;
                    if(var9) {
                        var10 = 1;
                    }

                    var3.writeInt(var10);
                    return true;
                case 41:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    int var7 = var2.readInt();
                    boolean var8 = false;
                    if(var7 != 0) {
                        var8 = true;
                    }

                    this.setBuildingsEnabled(var8);
                    var3.writeNoException();
                    return true;
                case 42:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnMapLoadedCallback(class_125.class_1363.method_3364(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 44:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    class_59 var5 = this.getFocusedBuilding();
                    var3.writeNoException();
                    IBinder var6 = null;
                    if(var5 != null) {
                        var6 = var5.asBinder();
                    }

                    var3.writeStrongBinder(var6);
                    return true;
                case 45:
                    var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.setOnIndoorStateChangeListener(class_121.class_1599.method_5262(var2.readStrongBinder()));
                    var3.writeNoException();
                    return true;
                case 1598968902:
                    var3.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    return true;
                default:
                    return super.onTransact(var1, var2, var3, var4);
            }
        }
    }

    private static class class_1309 implements IGoogleMapDelegate {
        // $FF: renamed from: lb android.os.IBinder
        private IBinder field_4485;

        class_1309(IBinder var1) {
            this.field_4485 = var1;
        }

        public class_61 addCircle(CircleOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public class_62 addGroundOverlay(GroundOverlayOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public class_56 addMarker(MarkerOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public class_57 addPolygon(PolygonOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IPolylineDelegate addPolyline(PolylineOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public class_54 addTileOverlay(TileOverlayOptions param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void animateCamera(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void animateCameraWithCallback(class_206 param1, class_128 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void animateCameraWithDurationAndCallback(class_206 param1, int param2, class_128 param3) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public IBinder asBinder() {
            return this.field_4485;
        }

        public void clear() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(14, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }

        public CameraPosition getCameraPosition() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            CameraPosition var5;
            label42: {
                CameraPosition var6;
                label41: {
                    try {
                        var8 = true;
                        var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                        this.field_4485.transact(1, var1, var2, 0);
                        var2.readException();
                        if(var2.readInt() != 0) {
                            var6 = CameraPosition.CREATOR.method_5186(var2);
                            var8 = false;
                            break label41;
                        }

                        var8 = false;
                    } finally {
                        if(var8) {
                            var2.recycle();
                            var1.recycle();
                        }
                    }

                    var5 = null;
                    break label42;
                }

                var5 = var6;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        public class_59 getFocusedBuilding() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            class_59 var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(44, var1, var2, 0);
                var2.readException();
                var5 = class_59.class_1681.method_5079(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public int getMapType() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            int var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(15, var1, var2, 0);
                var2.readException();
                var5 = var2.readInt();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public float getMaxZoomLevel() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            float var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(2, var1, var2, 0);
                var2.readException();
                var5 = var2.readFloat();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public float getMinZoomLevel() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            float var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(3, var1, var2, 0);
                var2.readException();
                var5 = var2.readFloat();
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public Location getMyLocation() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var7 = false;

            Location var5;
            label36: {
                try {
                    var7 = true;
                    var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                    this.field_4485.transact(23, var1, var2, 0);
                    var2.readException();
                    if(var2.readInt() != 0) {
                        var5 = (Location)Location.CREATOR.createFromParcel(var2);
                        var7 = false;
                        break label36;
                    }

                    var7 = false;
                } finally {
                    if(var7) {
                        var2.recycle();
                        var1.recycle();
                    }
                }

                var5 = null;
            }

            var2.recycle();
            var1.recycle();
            return var5;
        }

        public IProjectionDelegate getProjection() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            IProjectionDelegate var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(26, var1, var2, 0);
                var2.readException();
                var5 = IProjectionDelegate.class_1393.method_3752(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public IUiSettingsDelegate getUiSettings() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            IUiSettingsDelegate var5;
            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(25, var1, var2, 0);
                var2.readException();
                var5 = IUiSettingsDelegate.class_1793.method_5433(var2.readStrongBinder());
            } finally {
                var2.recycle();
                var1.recycle();
            }

            return var5;
        }

        public boolean isBuildingsEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(40, var1, var2, 0);
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

        public boolean isIndoorEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(19, var1, var2, 0);
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

        public boolean isMyLocationEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(21, var1, var2, 0);
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

        public boolean isTrafficEnabled() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();
            boolean var8 = false;

            int var5;
            try {
                var8 = true;
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(17, var1, var2, 0);
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

        public void moveCamera(class_206 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setBuildingsEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public boolean setIndoorEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setInfoWindowAdapter(class_119 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setLocationSource(ILocationSourceDelegate param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setMapType(int var1) throws RemoteException {
            Parcel var2 = Parcel.obtain();
            Parcel var3 = Parcel.obtain();

            try {
                var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                var2.writeInt(var1);
                this.field_4485.transact(16, var2, var3, 0);
                var3.readException();
            } finally {
                var3.recycle();
                var2.recycle();
            }

        }

        public void setMyLocationEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnCameraChangeListener(class_120 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnIndoorStateChangeListener(class_121 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnInfoWindowClickListener(class_122 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMapClickListener(class_124 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMapLoadedCallback(class_125 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMapLongClickListener(class_126 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMarkerClickListener(class_111 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMarkerDragListener(class_112 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMyLocationButtonClickListener(class_113 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setOnMyLocationChangeListener(class_114 param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void setPadding(int var1, int var2, int var3, int var4) throws RemoteException {
            Parcel var5 = Parcel.obtain();
            Parcel var6 = Parcel.obtain();

            try {
                var5.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                var5.writeInt(var1);
                var5.writeInt(var2);
                var5.writeInt(var3);
                var5.writeInt(var4);
                this.field_4485.transact(39, var5, var6, 0);
                var6.readException();
            } finally {
                var6.recycle();
                var5.recycle();
            }

        }

        public void setTrafficEnabled(boolean param1) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void snapshot(class_118 param1, class_206 param2) throws RemoteException {
            // $FF: Couldn't be decompiled
        }

        public void stopAnimation() throws RemoteException {
            Parcel var1 = Parcel.obtain();
            Parcel var2 = Parcel.obtain();

            try {
                var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
                this.field_4485.transact(8, var1, var2, 0);
                var2.readException();
            } finally {
                var2.recycle();
                var1.recycle();
            }

        }
    }
}
