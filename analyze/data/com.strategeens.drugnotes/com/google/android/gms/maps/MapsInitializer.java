package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.class_118;
import com.google.android.gms.maps.internal.class_696;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
   // $FF: renamed from: a (com.google.android.gms.maps.internal.c) void
   public static void method_5563(class_118 var0) {
      try {
         CameraUpdateFactory.method_5175(var0.method_664());
         BitmapDescriptorFactory.method_5115(var0.method_665());
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static int initialize(Context var0) {
      class_335.method_2311(var0);

      class_118 var3;
      try {
         var3 = class_696.method_3989(var0);
      } catch (GooglePlayServicesNotAvailableException var4) {
         return var4.errorCode;
      }

      method_5563(var3);
      return 0;
   }
}
