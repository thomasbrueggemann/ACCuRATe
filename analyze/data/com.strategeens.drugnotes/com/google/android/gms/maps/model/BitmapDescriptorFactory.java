package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_62;

public final class BitmapDescriptorFactory {
   public static final float HUE_AZURE = 210.0F;
   public static final float HUE_BLUE = 240.0F;
   public static final float HUE_CYAN = 180.0F;
   public static final float HUE_GREEN = 120.0F;
   public static final float HUE_MAGENTA = 300.0F;
   public static final float HUE_ORANGE = 30.0F;
   public static final float HUE_RED = 0.0F;
   public static final float HUE_ROSE = 330.0F;
   public static final float HUE_VIOLET = 270.0F;
   public static final float HUE_YELLOW = 60.0F;
   private static class_62 alM;

   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.g) void
   public static void method_5115(class_62 var0) {
      if(alM == null) {
         alM = (class_62)class_335.method_2311(var0);
      }
   }

   public static BitmapDescriptor defaultMarker() {
      try {
         BitmapDescriptor var0 = new BitmapDescriptor(method_5116().method_368());
         return var0;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static BitmapDescriptor defaultMarker(float var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_363(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromAsset(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_364(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromBitmap(Bitmap var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_362(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromFile(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_365(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromPath(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_366(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromResource(int var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_5116().method_367(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   // $FF: renamed from: oc () com.google.android.gms.maps.model.internal.g
   private static class_62 method_5116() {
      return (class_62)class_335.method_2306(alM, "IBitmapDescriptorFactory is not initialized");
   }
}
