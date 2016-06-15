package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.class_100;
import com.google.android.gms.maps.internal.class_101;
import com.google.android.gms.maps.internal.class_102;
import com.google.android.gms.maps.internal.class_103;
import com.google.android.gms.maps.internal.class_105;
import com.google.android.gms.maps.internal.class_106;
import com.google.android.gms.maps.internal.class_107;
import com.google.android.gms.maps.internal.class_109;
import com.google.android.gms.maps.internal.class_92;
import com.google.android.gms.maps.internal.class_93;
import com.google.android.gms.maps.internal.class_94;
import com.google.android.gms.maps.internal.class_95;
import com.google.android.gms.maps.internal.class_99;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.class_53;
import com.google.android.gms.maps.model.internal.class_55;
import com.google.android.gms.maps.model.internal.class_56;
import com.google.android.gms.maps.model.internal.class_58;
import com.google.android.gms.maps.model.internal.class_60;
import com.google.android.gms.maps.model.internal.class_61;

public interface IGoogleMapDelegate extends IInterface {
   class_60 addCircle(CircleOptions var1) throws RemoteException;

   class_61 addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

   class_55 addMarker(MarkerOptions var1) throws RemoteException;

   class_56 addPolygon(PolygonOptions var1) throws RemoteException;

   IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

   class_53 addTileOverlay(TileOverlayOptions var1) throws RemoteException;

   void animateCamera(class_157 var1) throws RemoteException;

   void animateCameraWithCallback(class_157 var1, class_109 var2) throws RemoteException;

   void animateCameraWithDurationAndCallback(class_157 var1, int var2, class_109 var3) throws RemoteException;

   void clear() throws RemoteException;

   CameraPosition getCameraPosition() throws RemoteException;

   class_58 getFocusedBuilding() throws RemoteException;

   int getMapType() throws RemoteException;

   float getMaxZoomLevel() throws RemoteException;

   float getMinZoomLevel() throws RemoteException;

   Location getMyLocation() throws RemoteException;

   IProjectionDelegate getProjection() throws RemoteException;

   class_157 getTestingHelper() throws RemoteException;

   IUiSettingsDelegate getUiSettings() throws RemoteException;

   boolean isBuildingsEnabled() throws RemoteException;

   boolean isIndoorEnabled() throws RemoteException;

   boolean isMyLocationEnabled() throws RemoteException;

   boolean isTrafficEnabled() throws RemoteException;

   void moveCamera(class_157 var1) throws RemoteException;

   void setBuildingsEnabled(boolean var1) throws RemoteException;

   boolean setIndoorEnabled(boolean var1) throws RemoteException;

   void setInfoWindowAdapter(class_100 var1) throws RemoteException;

   void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

   void setMapType(int var1) throws RemoteException;

   void setMyLocationEnabled(boolean var1) throws RemoteException;

   void setOnCameraChangeListener(class_101 var1) throws RemoteException;

   void setOnIndoorStateChangeListener(class_102 var1) throws RemoteException;

   void setOnInfoWindowClickListener(class_103 var1) throws RemoteException;

   void setOnMapClickListener(class_105 var1) throws RemoteException;

   void setOnMapLoadedCallback(class_106 var1) throws RemoteException;

   void setOnMapLongClickListener(class_107 var1) throws RemoteException;

   void setOnMarkerClickListener(class_92 var1) throws RemoteException;

   void setOnMarkerDragListener(class_93 var1) throws RemoteException;

   void setOnMyLocationButtonClickListener(class_94 var1) throws RemoteException;

   void setOnMyLocationChangeListener(class_95 var1) throws RemoteException;

   void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

   void setTrafficEnabled(boolean var1) throws RemoteException;

   void setWatermarkEnabled(boolean var1) throws RemoteException;

   void snapshot(class_99 var1, class_157 var2) throws RemoteException;

   void stopAnimation() throws RemoteException;

   public abstract static class class_942 extends Binder implements IGoogleMapDelegate {
      // $FF: renamed from: ay (android.os.IBinder) com.google.android.gms.maps.internal.IGoogleMapDelegate
      public static IGoogleMapDelegate method_2733(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (IGoogleMapDelegate)(var1 != null && var1 instanceof IGoogleMapDelegate?(IGoogleMapDelegate)var1:new IGoogleMapDelegate.class_943(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CameraPosition var54 = this.getCameraPosition();
            var3.writeNoException();
            if(var54 != null) {
               var3.writeInt(1);
               var54.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var53 = this.getMaxZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var53);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var52 = this.getMinZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var52);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.moveCamera(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCamera(class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithCallback(class_157.class_1317.method_4176(var2.readStrongBinder()), class_109.class_1145.method_3286(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithDurationAndCallback(class_157.class_1317.method_4176(var2.readStrongBinder()), var2.readInt(), class_109.class_1145.method_3286(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.stopAnimation();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolylineOptions var49;
            if(var2.readInt() != 0) {
               var49 = PolylineOptions.CREATOR.createFromParcel(var2);
            } else {
               var49 = null;
            }

            IPolylineDelegate var50 = this.addPolyline(var49);
            var3.writeNoException();
            IBinder var51 = null;
            if(var50 != null) {
               var51 = var50.asBinder();
            }

            var3.writeStrongBinder(var51);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolygonOptions var46;
            if(var2.readInt() != 0) {
               var46 = PolygonOptions.CREATOR.createFromParcel(var2);
            } else {
               var46 = null;
            }

            class_56 var47 = this.addPolygon(var46);
            var3.writeNoException();
            IBinder var48 = null;
            if(var47 != null) {
               var48 = var47.asBinder();
            }

            var3.writeStrongBinder(var48);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var43;
            if(var2.readInt() != 0) {
               var43 = MarkerOptions.CREATOR.createFromParcel(var2);
            } else {
               var43 = null;
            }

            class_55 var44 = this.addMarker(var43);
            var3.writeNoException();
            IBinder var45 = null;
            if(var44 != null) {
               var45 = var44.asBinder();
            }

            var3.writeStrongBinder(var45);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            GroundOverlayOptions var40;
            if(var2.readInt() != 0) {
               var40 = GroundOverlayOptions.CREATOR.createFromParcel(var2);
            } else {
               var40 = null;
            }

            class_61 var41 = this.addGroundOverlay(var40);
            var3.writeNoException();
            IBinder var42 = null;
            if(var41 != null) {
               var42 = var41.asBinder();
            }

            var3.writeStrongBinder(var42);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            TileOverlayOptions var37;
            if(var2.readInt() != 0) {
               var37 = TileOverlayOptions.CREATOR.createFromParcel(var2);
            } else {
               var37 = null;
            }

            class_53 var38 = this.addTileOverlay(var37);
            var3.writeNoException();
            IBinder var39 = null;
            if(var38 != null) {
               var39 = var38.asBinder();
            }

            var3.writeStrongBinder(var39);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.clear();
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var36 = this.getMapType();
            var3.writeNoException();
            var3.writeInt(var36);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setMapType(var2.readInt());
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var34 = this.isTrafficEnabled();
            var3.writeNoException();
            byte var35 = 0;
            if(var34) {
               var35 = 1;
            }

            var3.writeInt(var35);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var32 = var2.readInt();
            boolean var33 = false;
            if(var32 != 0) {
               var33 = true;
            }

            this.setTrafficEnabled(var33);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var30 = this.isIndoorEnabled();
            var3.writeNoException();
            byte var31 = 0;
            if(var30) {
               var31 = 1;
            }

            var3.writeInt(var31);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var27;
            if(var2.readInt() != 0) {
               var27 = true;
            } else {
               var27 = false;
            }

            boolean var28 = this.setIndoorEnabled(var27);
            var3.writeNoException();
            byte var29 = 0;
            if(var28) {
               var29 = 1;
            }

            var3.writeInt(var29);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var25 = this.isMyLocationEnabled();
            var3.writeNoException();
            byte var26 = 0;
            if(var25) {
               var26 = 1;
            }

            var3.writeInt(var26);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var23 = var2.readInt();
            boolean var24 = false;
            if(var23 != 0) {
               var24 = true;
            }

            this.setMyLocationEnabled(var24);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Location var22 = this.getMyLocation();
            var3.writeNoException();
            if(var22 != null) {
               var3.writeInt(1);
               var22.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setLocationSource(ILocationSourceDelegate.class_1179.method_4060(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IUiSettingsDelegate var20 = this.getUiSettings();
            var3.writeNoException();
            IBinder var21 = null;
            if(var20 != null) {
               var21 = var20.asBinder();
            }

            var3.writeStrongBinder(var21);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IProjectionDelegate var18 = this.getProjection();
            var3.writeNoException();
            IBinder var19 = null;
            if(var18 != null) {
               var19 = var18.asBinder();
            }

            var3.writeStrongBinder(var19);
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnCameraChangeListener(class_101.class_812.method_4017(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapClickListener(class_105.class_850.method_2529(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLongClickListener(class_107.class_1143.method_3307(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerClickListener(class_92.class_1109.method_3113(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerDragListener(class_93.class_1185.method_3114(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowClickListener(class_103.class_866.method_3116(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowAdapter(class_100.class_1147.method_3115(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 34:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            class_157 var16 = this.getTestingHelper();
            var3.writeNoException();
            IBinder var17 = null;
            if(var16 != null) {
               var17 = var16.asBinder();
            }

            var3.writeStrongBinder(var17);
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CircleOptions var13;
            if(var2.readInt() != 0) {
               var13 = CircleOptions.CREATOR.createFromParcel(var2);
            } else {
               var13 = null;
            }

            class_60 var14 = this.addCircle(var13);
            var3.writeNoException();
            IBinder var15 = null;
            if(var14 != null) {
               var15 = var14.asBinder();
            }

            var3.writeStrongBinder(var15);
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationChangeListener(class_95.class_1189.method_4058(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationButtonClickListener(class_94.class_1187.method_4061(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.snapshot(class_99.class_1183.method_3462(var2.readStrongBinder()), class_157.class_1317.method_4176(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 39:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setPadding(var2.readInt(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var11 = this.isBuildingsEnabled();
            var3.writeNoException();
            byte var12 = 0;
            if(var11) {
               var12 = 1;
            }

            var3.writeInt(var12);
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var9 = var2.readInt();
            boolean var10 = false;
            if(var9 != 0) {
               var10 = true;
            }

            this.setBuildingsEnabled(var10);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLoadedCallback(class_106.class_998.method_2857(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            class_58 var7 = this.getFocusedBuilding();
            var3.writeNoException();
            IBinder var8 = null;
            if(var7 != null) {
               var8 = var7.asBinder();
            }

            var3.writeStrongBinder(var8);
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnIndoorStateChangeListener(class_102.class_1139.method_4059(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 51:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var5 = var2.readInt();
            boolean var6 = false;
            if(var5 != 0) {
               var6 = true;
            }

            this.setWatermarkEnabled(var6);
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

   private static class class_943 implements IGoogleMapDelegate {
      // $FF: renamed from: ko android.os.IBinder
      private IBinder field_3599;

      class_943(IBinder var1) {
         this.field_3599 = var1;
      }

      public class_60 addCircle(CircleOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_61 addGroundOverlay(GroundOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_55 addMarker(MarkerOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_56 addPolygon(PolygonOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IPolylineDelegate addPolyline(PolylineOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public class_53 addTileOverlay(TileOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback(class_157 param1, class_109 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback(class_157 param1, int param2, class_109 param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.field_3599;
      }

      public void clear() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3599.transact(14, var1, var2, 0);
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
                  this.field_3599.transact(1, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = CameraPosition.CREATOR.createFromParcel(var2);
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

      public class_58 getFocusedBuilding() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_58 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3599.transact(44, var1, var2, 0);
            var2.readException();
            var5 = class_58.class_1211.method_3947(var2.readStrongBinder());
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
            this.field_3599.transact(15, var1, var2, 0);
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
            this.field_3599.transact(2, var1, var2, 0);
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
            this.field_3599.transact(3, var1, var2, 0);
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
               this.field_3599.transact(23, var1, var2, 0);
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
            this.field_3599.transact(26, var1, var2, 0);
            var2.readException();
            var5 = IProjectionDelegate.class_1022.method_3121(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public class_157 getTestingHelper() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         class_157 var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3599.transact(34, var1, var2, 0);
            var2.readException();
            var5 = class_157.class_1317.method_4176(var2.readStrongBinder());
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
            this.field_3599.transact(25, var1, var2, 0);
            var2.readException();
            var5 = IUiSettingsDelegate.class_1315.method_4173(var2.readStrongBinder());
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
            this.field_3599.transact(40, var1, var2, 0);
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
            this.field_3599.transact(19, var1, var2, 0);
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
            this.field_3599.transact(21, var1, var2, 0);
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
            this.field_3599.transact(17, var1, var2, 0);
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

      public void moveCamera(class_157 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setBuildingsEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public boolean setIndoorEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAdapter(class_100 param1) throws RemoteException {
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
            this.field_3599.transact(16, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setMyLocationEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnCameraChangeListener(class_101 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnIndoorStateChangeListener(class_102 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowClickListener(class_103 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapClickListener(class_105 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLoadedCallback(class_106 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLongClickListener(class_107 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerClickListener(class_92 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerDragListener(class_93 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationButtonClickListener(class_94 param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationChangeListener(class_95 param1) throws RemoteException {
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
            this.field_3599.transact(39, var5, var6, 0);
            var6.readException();
         } finally {
            var6.recycle();
            var5.recycle();
         }

      }

      public void setTrafficEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setWatermarkEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void snapshot(class_99 param1, class_157 param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void stopAnimation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.field_3599.transact(8, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }
   }
}
