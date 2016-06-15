package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.internal.class_57;

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
   private static class_57 aaj;

   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.a) void
   public static void method_4055(class_57 var0) {
      if(aaj == null) {
         aaj = (class_57)class_347.method_2170(var0);
      }
   }

   public static BitmapDescriptor defaultMarker() {
      try {
         BitmapDescriptor var0 = new BitmapDescriptor(method_4056().method_326());
         return var0;
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static BitmapDescriptor defaultMarker(float var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_324(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromAsset(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_321(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromBitmap(Bitmap var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_320(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromFile(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_322(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromPath(String var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_323(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   public static BitmapDescriptor fromResource(int var0) {
      try {
         BitmapDescriptor var1 = new BitmapDescriptor(method_4056().method_325(var0));
         return var1;
      } catch (RemoteException var3) {
         throw new RuntimeRemoteException(var3);
      }
   }

   // $FF: renamed from: jH () com.google.android.gms.maps.model.internal.a
   private static class_57 method_4056() {
      return (class_57)class_347.method_2166(aaj, "IBitmapDescriptorFactory is not initialized");
   }
}
