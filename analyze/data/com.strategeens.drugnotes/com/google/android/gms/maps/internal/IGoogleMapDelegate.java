package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.class_101;
import com.google.android.gms.maps.internal.class_102;
import com.google.android.gms.maps.internal.class_103;
import com.google.android.gms.maps.internal.class_104;
import com.google.android.gms.maps.internal.class_105;
import com.google.android.gms.maps.internal.class_106;
import com.google.android.gms.maps.internal.class_107;
import com.google.android.gms.maps.internal.class_110;
import com.google.android.gms.maps.internal.class_111;
import com.google.android.gms.maps.internal.class_112;
import com.google.android.gms.maps.internal.class_113;
import com.google.android.gms.maps.internal.class_114;
import com.google.android.gms.maps.internal.class_116;
import com.google.android.gms.maps.internal.class_117;
import com.google.android.gms.maps.internal.class_119;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.class_524;
import com.google.android.gms.maps.model.internal.class_528;
import com.google.android.gms.maps.model.internal.class_530;
import com.google.android.gms.maps.model.internal.class_59;
import com.google.android.gms.maps.model.internal.class_60;
import com.google.android.gms.maps.model.internal.class_61;
import com.google.android.gms.maps.model.internal.class_63;
import com.google.android.gms.maps.model.internal.class_64;
import com.google.android.gms.maps.model.internal.class_65;

public interface IGoogleMapDelegate extends IInterface {
   class_60 addCircle(CircleOptions var1) throws RemoteException;

   class_61 addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

   class_61 addGroundOverlay2(GroundOverlayOptions var1, class_528 var2) throws RemoteException;

   class_63 addMarker(MarkerOptions var1) throws RemoteException;

   class_63 addMarker2(MarkerOptions var1, class_524 var2) throws RemoteException;

   class_64 addPolygon(PolygonOptions var1) throws RemoteException;

   IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

   class_59 addTileOverlay(TileOverlayOptions var1) throws RemoteException;

   void animateCamera(class_198 var1) throws RemoteException;

   void animateCamera2(class_530 var1) throws RemoteException;

   void animateCameraWithCallback(class_198 var1, class_119 var2) throws RemoteException;

   void animateCameraWithCallback2(class_530 var1, class_119 var2) throws RemoteException;

   void animateCameraWithDurationAndCallback(class_198 var1, int var2, class_119 var3) throws RemoteException;

   void animateCameraWithDurationAndCallback2(class_530 var1, int var2, class_119 var3) throws RemoteException;

   void clear() throws RemoteException;

   CameraPosition getCameraPosition() throws RemoteException;

   class_65 getFocusedBuilding() throws RemoteException;

   void getMapAsync(class_103 var1) throws RemoteException;

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

   void moveCamera(class_198 var1) throws RemoteException;

   void moveCamera2(class_530 var1) throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   void setBuildingsEnabled(boolean var1) throws RemoteException;

   void setContentDescription(String var1) throws RemoteException;

   boolean setIndoorEnabled(boolean var1) throws RemoteException;

   void setInfoWindowAdapter(class_110 var1) throws RemoteException;

   void setInfoWindowRenderer(class_111 var1) throws RemoteException;

   void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

   void setMapType(int var1) throws RemoteException;

   void setMyLocationEnabled(boolean var1) throws RemoteException;

   void setOnCameraChangeListener(class_112 var1) throws RemoteException;

   void setOnIndoorStateChangeListener(class_113 var1) throws RemoteException;

   void setOnInfoWindowClickListener(class_114 var1) throws RemoteException;

   void setOnMapClickListener(class_116 var1) throws RemoteException;

   void setOnMapLoadedCallback(class_117 var1) throws RemoteException;

   void setOnMapLongClickListener(class_102 var1) throws RemoteException;

   void setOnMarkerClickListener(class_104 var1) throws RemoteException;

   void setOnMarkerDragListener(class_105 var1) throws RemoteException;

   void setOnMyLocationButtonClickListener(class_106 var1) throws RemoteException;

   void setOnMyLocationChangeListener(class_107 var1) throws RemoteException;

   void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

   void setTrafficEnabled(boolean var1) throws RemoteException;

   void snapshot(class_101 var1, class_198 var2) throws RemoteException;

   void stopAnimation() throws RemoteException;

   boolean useViewLifecycleWhenInFragment() throws RemoteException;

   public abstract static class class_1237 extends Binder implements IGoogleMapDelegate {
      // $FF: renamed from: aT (android.os.IBinder) com.google.android.gms.maps.internal.IGoogleMapDelegate
      public static IGoogleMapDelegate method_3164(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (IGoogleMapDelegate)(var1 != null && var1 instanceof IGoogleMapDelegate?(IGoogleMapDelegate)var1:new IGoogleMapDelegate.class_1238(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CameraPosition var70 = this.getCameraPosition();
            var3.writeNoException();
            if(var70 != null) {
               var3.writeInt(1);
               var70.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var69 = this.getMaxZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var69);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var68 = this.getMinZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var68);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.moveCamera(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCamera(class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithCallback(class_198.class_1672.method_5291(var2.readStrongBinder()), class_119.class_1488.method_3921(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithDurationAndCallback(class_198.class_1672.method_5291(var2.readStrongBinder()), var2.readInt(), class_119.class_1488.method_3921(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.stopAnimation();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolylineOptions var65;
            if(var2.readInt() != 0) {
               var65 = PolylineOptions.CREATOR.method_5016(var2);
            } else {
               var65 = null;
            }

            IPolylineDelegate var66 = this.addPolyline(var65);
            var3.writeNoException();
            IBinder var67 = null;
            if(var66 != null) {
               var67 = var66.asBinder();
            }

            var3.writeStrongBinder(var67);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolygonOptions var62;
            if(var2.readInt() != 0) {
               var62 = PolygonOptions.CREATOR.method_5020(var2);
            } else {
               var62 = null;
            }

            class_64 var63 = this.addPolygon(var62);
            var3.writeNoException();
            IBinder var64 = null;
            if(var63 != null) {
               var64 = var63.asBinder();
            }

            var3.writeStrongBinder(var64);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var59;
            if(var2.readInt() != 0) {
               var59 = MarkerOptions.CREATOR.method_5008(var2);
            } else {
               var59 = null;
            }

            class_63 var60 = this.addMarker(var59);
            var3.writeNoException();
            IBinder var61 = null;
            if(var60 != null) {
               var61 = var60.asBinder();
            }

            var3.writeStrongBinder(var61);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            GroundOverlayOptions var56;
            if(var2.readInt() != 0) {
               var56 = GroundOverlayOptions.CREATOR.method_5004(var2);
            } else {
               var56 = null;
            }

            class_61 var57 = this.addGroundOverlay(var56);
            var3.writeNoException();
            IBinder var58 = null;
            if(var57 != null) {
               var58 = var57.asBinder();
            }

            var3.writeStrongBinder(var58);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            TileOverlayOptions var53;
            if(var2.readInt() != 0) {
               var53 = TileOverlayOptions.CREATOR.method_4977(var2);
            } else {
               var53 = null;
            }

            class_59 var54 = this.addTileOverlay(var53);
            var3.writeNoException();
            IBinder var55 = null;
            if(var54 != null) {
               var55 = var54.asBinder();
            }

            var3.writeStrongBinder(var55);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.clear();
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var52 = this.getMapType();
            var3.writeNoException();
            var3.writeInt(var52);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setMapType(var2.readInt());
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var50 = this.isTrafficEnabled();
            var3.writeNoException();
            byte var51;
            if(var50) {
               var51 = 1;
            } else {
               var51 = 0;
            }

            var3.writeInt(var51);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var48 = var2.readInt();
            boolean var49 = false;
            if(var48 != 0) {
               var49 = true;
            }

            this.setTrafficEnabled(var49);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var46 = this.isIndoorEnabled();
            var3.writeNoException();
            byte var47 = 0;
            if(var46) {
               var47 = 1;
            }

            var3.writeInt(var47);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var43;
            if(var2.readInt() != 0) {
               var43 = true;
            } else {
               var43 = false;
            }

            boolean var44 = this.setIndoorEnabled(var43);
            var3.writeNoException();
            byte var45 = 0;
            if(var44) {
               var45 = 1;
            }

            var3.writeInt(var45);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var41 = this.isMyLocationEnabled();
            var3.writeNoException();
            byte var42 = 0;
            if(var41) {
               var42 = 1;
            }

            var3.writeInt(var42);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var39 = var2.readInt();
            boolean var40 = false;
            if(var39 != 0) {
               var40 = true;
            }

            this.setMyLocationEnabled(var40);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Location var38 = this.getMyLocation();
            var3.writeNoException();
            if(var38 != null) {
               var3.writeInt(1);
               var38.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setLocationSource(ILocationSourceDelegate.class_1539.method_5119(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IUiSettingsDelegate var36 = this.getUiSettings();
            var3.writeNoException();
            IBinder var37 = null;
            if(var36 != null) {
               var37 = var36.asBinder();
            }

            var3.writeStrongBinder(var37);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IProjectionDelegate var34 = this.getProjection();
            var3.writeNoException();
            IBinder var35 = null;
            if(var34 != null) {
               var35 = var34.asBinder();
            }

            var3.writeStrongBinder(var35);
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnCameraChangeListener(class_112.class_1484.method_5122(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapClickListener(class_116.class_1323.method_3408(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLongClickListener(class_102.class_1453.method_4384(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerClickListener(class_104.class_1501.method_3711(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerDragListener(class_105.class_1499.method_3712(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowClickListener(class_114.class_1492.method_3714(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowAdapter(class_110.class_1486.method_3713(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CircleOptions var31;
            if(var2.readInt() != 0) {
               var31 = CircleOptions.CREATOR.method_5033(var2);
            } else {
               var31 = null;
            }

            class_60 var32 = this.addCircle(var31);
            var3.writeNoException();
            IBinder var33 = null;
            if(var32 != null) {
               var33 = var32.asBinder();
            }

            var3.writeStrongBinder(var33);
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationChangeListener(class_107.class_1314.method_3404(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationButtonClickListener(class_106.class_1423.method_5121(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.snapshot(class_101.class_1505.method_5120(var2.readStrongBinder()), class_198.class_1672.method_5291(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 39:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setPadding(var2.readInt(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var29 = this.isBuildingsEnabled();
            var3.writeNoException();
            byte var30 = 0;
            if(var29) {
               var30 = 1;
            }

            var3.writeInt(var30);
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var27 = var2.readInt();
            boolean var28 = false;
            if(var27 != 0) {
               var28 = true;
            }

            this.setBuildingsEnabled(var28);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLoadedCallback(class_117.class_1490.method_3953(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            class_65 var25 = this.getFocusedBuilding();
            var3.writeNoException();
            IBinder var26 = null;
            if(var25 != null) {
               var26 = var25.asBinder();
            }

            var3.writeStrongBinder(var26);
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnIndoorStateChangeListener(class_113.class_1171.method_5118(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.getMapAsync(class_103.class_1497.method_4908(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 54:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Bundle var24;
            if(var2.readInt() != 0) {
               var24 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var24 = null;
            }

            this.onCreate(var24);
            var3.writeNoException();
            return true;
         case 55:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onResume();
            var3.writeNoException();
            return true;
         case 56:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onPause();
            var3.writeNoException();
            return true;
         case 57:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onDestroy();
            var3.writeNoException();
            return true;
         case 58:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onLowMemory();
            var3.writeNoException();
            return true;
         case 59:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var22 = this.useViewLifecycleWhenInFragment();
            var3.writeNoException();
            byte var23 = 0;
            if(var22) {
               var23 = 1;
            }

            var3.writeInt(var23);
            return true;
         case 60:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Bundle var21;
            if(var2.readInt() != 0) {
               var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var21 = null;
            }

            this.onSaveInstanceState(var21);
            var3.writeNoException();
            if(var21 != null) {
               var3.writeInt(1);
               var21.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 61:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setContentDescription(var2.readString());
            var3.writeNoException();
            return true;
         case 64:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var19 = var2.readInt();
            class_530 var20 = null;
            if(var19 != 0) {
               var20 = class_530.CREATOR.method_3248(var2);
            }

            this.moveCamera2(var20);
            var3.writeNoException();
            return true;
         case 65:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var17 = var2.readInt();
            class_530 var18 = null;
            if(var17 != 0) {
               var18 = class_530.CREATOR.method_3248(var2);
            }

            this.animateCamera2(var18);
            var3.writeNoException();
            return true;
         case 66:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var15 = var2.readInt();
            class_530 var16 = null;
            if(var15 != 0) {
               var16 = class_530.CREATOR.method_3248(var2);
            }

            this.animateCameraWithCallback2(var16, class_119.class_1488.method_3921(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 67:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var13 = var2.readInt();
            class_530 var14 = null;
            if(var13 != 0) {
               var14 = class_530.CREATOR.method_3248(var2);
            }

            this.animateCameraWithDurationAndCallback2(var14, var2.readInt(), class_119.class_1488.method_3921(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 68:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var9;
            if(var2.readInt() != 0) {
               var9 = MarkerOptions.CREATOR.method_5008(var2);
            } else {
               var9 = null;
            }

            class_524 var10;
            if(var2.readInt() != 0) {
               var10 = class_524.CREATOR.method_3235(var2);
            } else {
               var10 = null;
            }

            class_63 var11 = this.addMarker2(var9, var10);
            var3.writeNoException();
            IBinder var12 = null;
            if(var11 != null) {
               var12 = var11.asBinder();
            }

            var3.writeStrongBinder(var12);
            return true;
         case 69:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowRenderer(class_111.class_1080.method_5056(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 70:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            GroundOverlayOptions var5;
            if(var2.readInt() != 0) {
               var5 = GroundOverlayOptions.CREATOR.method_5004(var2);
            } else {
               var5 = null;
            }

            class_528 var6;
            if(var2.readInt() != 0) {
               var6 = class_528.CREATOR.method_3240(var2);
            } else {
               var6 = null;
            }

            class_61 var7 = this.addGroundOverlay2(var5, var6);
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 1598968902:
            var3.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return true;
         default:
            return super.onTransact(var1, var2, var3, var4);
         }
      }
   }

   private static class class_1238 implements IGoogleMapDelegate {
      // $FF: renamed from: le android.os.IBinder
      private IBinder field_3737;

      class_1238(IBinder var1) {
         this.field_3737 = var1;
      }

      public class_60 addCircle(CircleOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_61 addGroundOverlay(GroundOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_61 addGroundOverlay2(GroundOverlayOptions param1, class_528 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_63 addMarker(MarkerOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_63 addMarker2(MarkerOptions param1, class_524 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_64 addPolygon(PolygonOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IPolylineDelegate addPolyline(PolylineOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_59 addTileOverlay(TileOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera2(class_530 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback(class_198 param1, class_119 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback2(class_530 param1, class_119 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback(class_198 param1, int param2, class_119 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback2(class_530 param1, int param2, class_119 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3737;
      }

      public void clear() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(14, var1, var2, 0);
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
                  this.field_3737.transact(1, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = CameraPosition.CREATOR.method_5038(var2);
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

      public class_65 getFocusedBuilding() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_65 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(44, var1, var2, 0);
            var2.readException();
            var5 = class_65.class_1648.method_5864(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void getMapAsync(class_103 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getMapType() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(15, var1, var2, 0);
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
            this.field_3737.transact(2, var1, var2, 0);
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
            this.field_3737.transact(3, var1, var2, 0);
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
               this.field_3737.transact(23, var1, var2, 0);
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
            this.field_3737.transact(26, var1, var2, 0);
            var2.readException();
            var5 = IProjectionDelegate.class_1343.method_3725(var2.readStrongBinder());
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
            this.field_3737.transact(25, var1, var2, 0);
            var2.readException();
            var5 = IUiSettingsDelegate.class_1670.method_5289(var2.readStrongBinder());
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
            this.field_3737.transact(40, var1, var2, 0);
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
            this.field_3737.transact(19, var1, var2, 0);
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
            this.field_3737.transact(21, var1, var2, 0);
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
            this.field_3737.transact(17, var1, var2, 0);
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

      public void moveCamera(class_198 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void moveCamera2(class_530 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onCreate(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onDestroy() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(57, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onLowMemory() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(58, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onPause() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(56, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onResume() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(55, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onSaveInstanceState(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setBuildingsEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setContentDescription(String var1) throws RemoteException {
         Parcel var2 = Parcel.obtain();
         Parcel var3 = Parcel.obtain();

         try {
            var2.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            var2.writeString(var1);
            this.field_3737.transact(61, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public boolean setIndoorEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAdapter(class_110 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowRenderer(class_111 param1) throws RemoteException {
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
            this.field_3737.transact(16, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setMyLocationEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnCameraChangeListener(class_112 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnIndoorStateChangeListener(class_113 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowClickListener(class_114 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapClickListener(class_116 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLoadedCallback(class_117 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLongClickListener(class_102 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerClickListener(class_104 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerDragListener(class_105 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationButtonClickListener(class_106 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationChangeListener(class_107 param1) throws RemoteException {
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
            this.field_3737.transact(39, var5, var6, 0);
            var6.readException();
         } finally {
            var6.recycle();
            var5.recycle();
         }

      }

      public void setTrafficEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void snapshot(class_101 param1, class_198 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void stopAnimation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public boolean useViewLifecycleWhenInFragment() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();
         boolean var8 = false;

         int var5;
         try {
            var8 = true;
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3737.transact(59, var1, var2, 0);
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
   }
}
