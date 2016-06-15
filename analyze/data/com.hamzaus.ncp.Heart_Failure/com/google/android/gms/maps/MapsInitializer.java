package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.internal.class_108;
import com.google.android.gms.maps.internal.class_590;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer {
   // $FF: renamed from: a (com.google.android.gms.maps.internal.c) void
   public static void method_4367(class_108 var0) {
      try {
         CameraUpdateFactory.method_4069(var0.method_609());
         BitmapDescriptorFactory.method_4055(var0.method_610());
      } catch (RemoteException var2) {
         throw new RuntimeRemoteException(var2);
      }
   }

   public static int initialize(Context var0) {
      class_347.method_2170(var0);

      class_108 var3;
      try {
         var3 = class_590.method_3324(var0);
      } catch (GooglePlayServicesNotAvailableException var4) {
         return var4.errorCode;
      }

      method_4367(var3);
      return 0;
   }
}
