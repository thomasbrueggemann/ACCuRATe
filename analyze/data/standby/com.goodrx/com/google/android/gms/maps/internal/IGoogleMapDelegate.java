package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.internal.ILocationSourceDelegate;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.internal.zzab;
import com.google.android.gms.maps.internal.zzb;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.internal.zze;
import com.google.android.gms.maps.internal.zzf;
import com.google.android.gms.maps.internal.zzg;
import com.google.android.gms.maps.internal.zzh;
import com.google.android.gms.maps.internal.zzi;
import com.google.android.gms.maps.internal.zzj;
import com.google.android.gms.maps.internal.zzl;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.internal.zzn;
import com.google.android.gms.maps.internal.zzo;
import com.google.android.gms.maps.internal.zzp;
import com.google.android.gms.maps.internal.zzq;
import com.google.android.gms.maps.internal.zzr;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.internal.zzv;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public interface IGoogleMapDelegate extends IInterface {
   com.google.android.gms.maps.model.internal.zzb addCircle(CircleOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.zzc addGroundOverlay(GroundOverlayOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.zzf addMarker(MarkerOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.zzg addPolygon(PolygonOptions var1) throws RemoteException;

   IPolylineDelegate addPolyline(PolylineOptions var1) throws RemoteException;

   com.google.android.gms.maps.model.internal.zzh addTileOverlay(TileOverlayOptions var1) throws RemoteException;

   void animateCamera(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   void animateCameraWithCallback(com.google.android.gms.dynamic.zzd var1, zzb var2) throws RemoteException;

   void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd var1, int var2, zzb var3) throws RemoteException;

   void clear() throws RemoteException;

   CameraPosition getCameraPosition() throws RemoteException;

   com.google.android.gms.maps.model.internal.zzd getFocusedBuilding() throws RemoteException;

   void getMapAsync(zzo var1) throws RemoteException;

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

   void moveCamera(com.google.android.gms.dynamic.zzd var1) throws RemoteException;

   void onCreate(Bundle var1) throws RemoteException;

   void onDestroy() throws RemoteException;

   void onEnterAmbient(Bundle var1) throws RemoteException;

   void onExitAmbient() throws RemoteException;

   void onLowMemory() throws RemoteException;

   void onPause() throws RemoteException;

   void onResume() throws RemoteException;

   void onSaveInstanceState(Bundle var1) throws RemoteException;

   void setBuildingsEnabled(boolean var1) throws RemoteException;

   void setContentDescription(String var1) throws RemoteException;

   boolean setIndoorEnabled(boolean var1) throws RemoteException;

   void setInfoWindowAdapter(zzd var1) throws RemoteException;

   void setLocationSource(ILocationSourceDelegate var1) throws RemoteException;

   void setMapType(int var1) throws RemoteException;

   void setMyLocationEnabled(boolean var1) throws RemoteException;

   void setOnCameraChangeListener(zze var1) throws RemoteException;

   void setOnGroundOverlayClickListener(zzf var1) throws RemoteException;

   void setOnIndoorStateChangeListener(zzg var1) throws RemoteException;

   void setOnInfoWindowClickListener(zzh var1) throws RemoteException;

   void setOnInfoWindowCloseListener(zzi var1) throws RemoteException;

   void setOnInfoWindowLongClickListener(zzj var1) throws RemoteException;

   void setOnMapClickListener(zzl var1) throws RemoteException;

   void setOnMapLoadedCallback(zzm var1) throws RemoteException;

   void setOnMapLongClickListener(zzn var1) throws RemoteException;

   void setOnMarkerClickListener(zzp var1) throws RemoteException;

   void setOnMarkerDragListener(zzq var1) throws RemoteException;

   void setOnMyLocationButtonClickListener(zzr var1) throws RemoteException;

   void setOnMyLocationChangeListener(zzs var1) throws RemoteException;

   void setOnPoiClickListener(zzt var1) throws RemoteException;

   void setOnPolygonClickListener(zzu var1) throws RemoteException;

   void setOnPolylineClickListener(zzv var1) throws RemoteException;

   void setPadding(int var1, int var2, int var3, int var4) throws RemoteException;

   void setTrafficEnabled(boolean var1) throws RemoteException;

   void snapshot(zzab var1, com.google.android.gms.dynamic.zzd var2) throws RemoteException;

   void stopAnimation() throws RemoteException;

   boolean useViewLifecycleWhenInFragment() throws RemoteException;

   public abstract static class zza extends Binder implements IGoogleMapDelegate {
      public static IGoogleMapDelegate zzcv(IBinder var0) {
         if(var0 == null) {
            return null;
         } else {
            IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            return (IGoogleMapDelegate)(var1 != null && var1 instanceof IGoogleMapDelegate?(IGoogleMapDelegate)var1:new IGoogleMapDelegate.zza(var0));
         }
      }

      public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
         switch(var1) {
         case 1:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CameraPosition var55 = this.getCameraPosition();
            var3.writeNoException();
            if(var55 != null) {
               var3.writeInt(1);
               var55.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 2:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var54 = this.getMaxZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var54);
            return true;
         case 3:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            float var53 = this.getMinZoomLevel();
            var3.writeNoException();
            var3.writeFloat(var53);
            return true;
         case 4:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.moveCamera(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 5:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCamera(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 6:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithCallback(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), zzb.zza.zzct(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 7:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()), var2.readInt(), zzb.zza.zzct(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 8:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.stopAnimation();
            var3.writeNoException();
            return true;
         case 9:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolylineOptions var50;
            if(var2.readInt() != 0) {
               var50 = PolylineOptions.CREATOR.zzfD(var2);
            } else {
               var50 = null;
            }

            IPolylineDelegate var51 = this.addPolyline(var50);
            var3.writeNoException();
            IBinder var52 = null;
            if(var51 != null) {
               var52 = var51.asBinder();
            }

            var3.writeStrongBinder(var52);
            return true;
         case 10:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            PolygonOptions var47;
            if(var2.readInt() != 0) {
               var47 = PolygonOptions.CREATOR.zzfC(var2);
            } else {
               var47 = null;
            }

            com.google.android.gms.maps.model.internal.zzg var48 = this.addPolygon(var47);
            var3.writeNoException();
            IBinder var49 = null;
            if(var48 != null) {
               var49 = var48.asBinder();
            }

            var3.writeStrongBinder(var49);
            return true;
         case 11:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            MarkerOptions var44;
            if(var2.readInt() != 0) {
               var44 = MarkerOptions.CREATOR.zzfA(var2);
            } else {
               var44 = null;
            }

            com.google.android.gms.maps.model.internal.zzf var45 = this.addMarker(var44);
            var3.writeNoException();
            IBinder var46 = null;
            if(var45 != null) {
               var46 = var45.asBinder();
            }

            var3.writeStrongBinder(var46);
            return true;
         case 12:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            GroundOverlayOptions var41;
            if(var2.readInt() != 0) {
               var41 = GroundOverlayOptions.CREATOR.zzfx(var2);
            } else {
               var41 = null;
            }

            com.google.android.gms.maps.model.internal.zzc var42 = this.addGroundOverlay(var41);
            var3.writeNoException();
            IBinder var43 = null;
            if(var42 != null) {
               var43 = var42.asBinder();
            }

            var3.writeStrongBinder(var43);
            return true;
         case 13:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            TileOverlayOptions var38;
            if(var2.readInt() != 0) {
               var38 = TileOverlayOptions.CREATOR.zzfJ(var2);
            } else {
               var38 = null;
            }

            com.google.android.gms.maps.model.internal.zzh var39 = this.addTileOverlay(var38);
            var3.writeNoException();
            IBinder var40 = null;
            if(var39 != null) {
               var40 = var39.asBinder();
            }

            var3.writeStrongBinder(var40);
            return true;
         case 14:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.clear();
            var3.writeNoException();
            return true;
         case 15:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var37 = this.getMapType();
            var3.writeNoException();
            var3.writeInt(var37);
            return true;
         case 16:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setMapType(var2.readInt());
            var3.writeNoException();
            return true;
         case 17:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var35 = this.isTrafficEnabled();
            var3.writeNoException();
            byte var36;
            if(var35) {
               var36 = 1;
            } else {
               var36 = 0;
            }

            var3.writeInt(var36);
            return true;
         case 18:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var33 = var2.readInt();
            boolean var34 = false;
            if(var33 != 0) {
               var34 = true;
            }

            this.setTrafficEnabled(var34);
            var3.writeNoException();
            return true;
         case 19:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var31 = this.isIndoorEnabled();
            var3.writeNoException();
            byte var32 = 0;
            if(var31) {
               var32 = 1;
            }

            var3.writeInt(var32);
            return true;
         case 20:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var28;
            if(var2.readInt() != 0) {
               var28 = true;
            } else {
               var28 = false;
            }

            boolean var29 = this.setIndoorEnabled(var28);
            var3.writeNoException();
            byte var30 = 0;
            if(var29) {
               var30 = 1;
            }

            var3.writeInt(var30);
            return true;
         case 21:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var26 = this.isMyLocationEnabled();
            var3.writeNoException();
            byte var27 = 0;
            if(var26) {
               var27 = 1;
            }

            var3.writeInt(var27);
            return true;
         case 22:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var24 = var2.readInt();
            boolean var25 = false;
            if(var24 != 0) {
               var25 = true;
            }

            this.setMyLocationEnabled(var25);
            var3.writeNoException();
            return true;
         case 23:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Location var23 = this.getMyLocation();
            var3.writeNoException();
            if(var23 != null) {
               var3.writeInt(1);
               var23.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 24:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setLocationSource(ILocationSourceDelegate.zza.zzcx(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 25:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IUiSettingsDelegate var21 = this.getUiSettings();
            var3.writeNoException();
            IBinder var22 = null;
            if(var21 != null) {
               var22 = var21.asBinder();
            }

            var3.writeStrongBinder(var22);
            return true;
         case 26:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            IProjectionDelegate var19 = this.getProjection();
            var3.writeNoException();
            IBinder var20 = null;
            if(var19 != null) {
               var20 = var19.asBinder();
            }

            var3.writeStrongBinder(var20);
            return true;
         case 27:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnCameraChangeListener(zze.zza.zzcA(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 28:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapClickListener(zzl.zza.zzcH(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 29:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLongClickListener(zzn.zza.zzcJ(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 30:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerClickListener(zzp.zza.zzcL(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 31:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMarkerDragListener(zzq.zza.zzcM(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 32:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowClickListener(zzh.zza.zzcD(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 33:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setInfoWindowAdapter(zzd.zza.zzcw(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 35:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            CircleOptions var16;
            if(var2.readInt() != 0) {
               var16 = CircleOptions.CREATOR.zzfw(var2);
            } else {
               var16 = null;
            }

            com.google.android.gms.maps.model.internal.zzb var17 = this.addCircle(var16);
            var3.writeNoException();
            IBinder var18 = null;
            if(var17 != null) {
               var18 = var17.asBinder();
            }

            var3.writeStrongBinder(var18);
            return true;
         case 36:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationChangeListener(zzs.zza.zzcO(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 37:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMyLocationButtonClickListener(zzr.zza.zzcN(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 38:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.snapshot(zzab.zza.zzcY(var2.readStrongBinder()), com.google.android.gms.dynamic.zzd.zza.zzbs(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 39:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setPadding(var2.readInt(), var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            return true;
         case 40:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            boolean var14 = this.isBuildingsEnabled();
            var3.writeNoException();
            byte var15 = 0;
            if(var14) {
               var15 = 1;
            }

            var3.writeInt(var15);
            return true;
         case 41:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            int var12 = var2.readInt();
            boolean var13 = false;
            if(var12 != 0) {
               var13 = true;
            }

            this.setBuildingsEnabled(var13);
            var3.writeNoException();
            return true;
         case 42:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnMapLoadedCallback(zzm.zza.zzcI(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 44:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            com.google.android.gms.maps.model.internal.zzd var10 = this.getFocusedBuilding();
            var3.writeNoException();
            IBinder var11 = null;
            if(var10 != null) {
               var11 = var10.asBinder();
            }

            var3.writeStrongBinder(var11);
            return true;
         case 45:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnIndoorStateChangeListener(zzg.zza.zzcC(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 53:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.getMapAsync(zzo.zza.zzcK(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 54:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Bundle var9;
            if(var2.readInt() != 0) {
               var9 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var9 = null;
            }

            this.onCreate(var9);
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
            boolean var7 = this.useViewLifecycleWhenInFragment();
            var3.writeNoException();
            byte var8 = 0;
            if(var7) {
               var8 = 1;
            }

            var3.writeInt(var8);
            return true;
         case 60:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Bundle var6;
            if(var2.readInt() != 0) {
               var6 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var6 = null;
            }

            this.onSaveInstanceState(var6);
            var3.writeNoException();
            if(var6 != null) {
               var3.writeInt(1);
               var6.writeToParcel(var3, 1);
               return true;
            }

            var3.writeInt(0);
            return true;
         case 61:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setContentDescription(var2.readString());
            var3.writeNoException();
            return true;
         case 80:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnPoiClickListener(zzt.zza.zzcP(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 81:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            Bundle var5;
            if(var2.readInt() != 0) {
               var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
            } else {
               var5 = null;
            }

            this.onEnterAmbient(var5);
            var3.writeNoException();
            return true;
         case 82:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.onExitAmbient();
            var3.writeNoException();
            return true;
         case 83:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnGroundOverlayClickListener(zzf.zza.zzcB(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 84:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowLongClickListener(zzj.zza.zzcF(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 85:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnPolygonClickListener(zzu.zza.zzcQ(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 86:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnInfoWindowCloseListener(zzi.zza.zzcE(var2.readStrongBinder()));
            var3.writeNoException();
            return true;
         case 87:
            var2.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.setOnPolylineClickListener(zzv.zza.zzcR(var2.readStrongBinder()));
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

   private static class zza implements IGoogleMapDelegate {
      private IBinder zzoz;

      zza(IBinder var1) {
         this.zzoz = var1;
      }

      public com.google.android.gms.maps.model.internal.zzb addCircle(CircleOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.zzc addGroundOverlay(GroundOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.zzf addMarker(MarkerOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.zzg addPolygon(PolygonOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IPolylineDelegate addPolyline(PolylineOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public com.google.android.gms.maps.model.internal.zzh addTileOverlay(TileOverlayOptions param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCamera(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithCallback(com.google.android.gms.dynamic.zzd param1, zzb param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.zzd param1, int param2, zzb param3) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public IBinder asBinder() {
         return this.zzoz;
      }

      public void clear() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.zzoz.transact(14, var1, var2, 0);
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
                  this.zzoz.transact(1, var1, var2, 0);
                  var2.readException();
                  if(var2.readInt() != 0) {
                     var6 = CameraPosition.CREATOR.zzfv(var2);
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

      public com.google.android.gms.maps.model.internal.zzd getFocusedBuilding() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         com.google.android.gms.maps.model.internal.zzd var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.zzoz.transact(44, var1, var2, 0);
            var2.readException();
            var5 = com.google.android.gms.maps.model.internal.zzd.zza.zzdg(var2.readStrongBinder());
         } finally {
            var2.recycle();
            var1.recycle();
         }

         return var5;
      }

      public void getMapAsync(zzo param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public int getMapType() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         int var5;
         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.zzoz.transact(15, var1, var2, 0);
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
            this.zzoz.transact(2, var1, var2, 0);
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
            this.zzoz.transact(3, var1, var2, 0);
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
               this.zzoz.transact(23, var1, var2, 0);
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
            this.zzoz.transact(26, var1, var2, 0);
            var2.readException();
            var5 = IProjectionDelegate.zza.zzcX(var2.readStrongBinder());
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
            this.zzoz.transact(25, var1, var2, 0);
            var2.readException();
            var5 = IUiSettingsDelegate.zza.zzdc(var2.readStrongBinder());
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
            this.zzoz.transact(40, var1, var2, 0);
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
            this.zzoz.transact(19, var1, var2, 0);
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
            this.zzoz.transact(21, var1, var2, 0);
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
            this.zzoz.transact(17, var1, var2, 0);
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

      public void moveCamera(com.google.android.gms.dynamic.zzd param1) throws RemoteException {
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
            this.zzoz.transact(57, var1, var2, 0);
            var2.readException();
         } finally {
            var2.recycle();
            var1.recycle();
         }

      }

      public void onEnterAmbient(Bundle param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void onExitAmbient() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.zzoz.transact(82, var1, var2, 0);
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
            this.zzoz.transact(58, var1, var2, 0);
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
            this.zzoz.transact(56, var1, var2, 0);
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
            this.zzoz.transact(55, var1, var2, 0);
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
            this.zzoz.transact(61, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public boolean setIndoorEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setInfoWindowAdapter(zzd param1) throws RemoteException {
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
            this.zzoz.transact(16, var2, var3, 0);
            var3.readException();
         } finally {
            var3.recycle();
            var2.recycle();
         }

      }

      public void setMyLocationEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnCameraChangeListener(zze param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnGroundOverlayClickListener(zzf param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnIndoorStateChangeListener(zzg param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowClickListener(zzh param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowCloseListener(zzi param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnInfoWindowLongClickListener(zzj param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapClickListener(zzl param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLoadedCallback(zzm param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMapLongClickListener(zzn param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerClickListener(zzp param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMarkerDragListener(zzq param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationButtonClickListener(zzr param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnMyLocationChangeListener(zzs param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnPoiClickListener(zzt param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnPolygonClickListener(zzu param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void setOnPolylineClickListener(zzv param1) throws RemoteException {
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
            this.zzoz.transact(39, var5, var6, 0);
            var6.readException();
         } finally {
            var6.recycle();
            var5.recycle();
         }

      }

      public void setTrafficEnabled(boolean param1) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void snapshot(zzab param1, com.google.android.gms.dynamic.zzd param2) throws RemoteException {
         // $FF: Couldn't be decompiled
      }

      public void stopAnimation() throws RemoteException {
         Parcel var1 = Parcel.obtain();
         Parcel var2 = Parcel.obtain();

         try {
            var1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            this.zzoz.transact(8, var1, var2, 0);
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
            this.zzoz.transact(59, var1, var2, 0);
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
