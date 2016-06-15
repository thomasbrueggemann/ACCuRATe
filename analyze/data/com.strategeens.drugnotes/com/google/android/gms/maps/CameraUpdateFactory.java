package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
   private static ICameraUpdateFactoryDelegate akl;

   // $FF: renamed from: a (com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate) void
   public static void method_5175(ICameraUpdateFactoryDelegate var0) {
      akl = (ICameraUpdateFactoryDelegate)class_335.method_2311(var0);
   }

   // $FF: renamed from: nB () com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
   private static ICameraUpdateFactoryDelegate method_5176() {
      return (ICameraUpdateFactoryDelegate)class_335.method_2306(akl, "CameraUpdateFactory is not initialized");
   }

   public static CameraUpdate newCameraPosition(CameraPosition var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(method_5176().newCameraPosition(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static CameraUpdate newLatLng(LatLng var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(method_5176().newLatLng(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(method_5176().newLatLngBounds(var0, var1));
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static CameraUpdate newLatLngBounds(LatLngBounds var0, int var1, int var2, int var3) {
      try {
         CameraUpdate var4 = new CameraUpdate(method_5176().newLatLngBoundsWithSize(var0, var1, var2, var3));
         return var4;
      } catch (RemoteException var6) {
         throw new RuntimeRemoteException(var6);
      }
   }

   public static CameraUpdate newLatLngZoom(LatLng var0, float var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(method_5176().newLatLngZoom(var0, var1));
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static CameraUpdate scrollBy(float var0, float var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(method_5176().scrollBy(var0, var1));
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static CameraUpdate zoomBy(float var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(method_5176().zoomBy(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static CameraUpdate zoomBy(float var0, Point var1) {
      try {
         CameraUpdate var2 = new CameraUpdate(method_5176().zoomByWithFocus(var0, var1.x, var1.y));
         return var2;
      } catch (RemoteException var4) {
         throw new RuntimeRemoteException(var4);
      }
   }

   public static CameraUpdate zoomIn() {
      try {
         CameraUpdate var0 = new CameraUpdate(method_5176().zoomIn());
         return var0;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate zoomOut() {
      try {
         CameraUpdate var0 = new CameraUpdate(method_5176().zoomOut());
         return var0;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static CameraUpdate zoomTo(float var0) {
      try {
         CameraUpdate var1 = new CameraUpdate(method_5176().zoomTo(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }
}
