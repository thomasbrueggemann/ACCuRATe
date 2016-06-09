package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class zzac {
   public static void zza(Bundle var0, String var1, Parcelable var2) {
      var0.setClassLoader(zzac.class.getClassLoader());
      Bundle var3 = var0.getBundle("map_state");
      if(var3 == null) {
         var3 = new Bundle();
      }

      var3.setClassLoader(zzac.class.getClassLoader());
      var3.putParcelable(var1, var2);
      var0.putBundle("map_state", var3);
   }
}
