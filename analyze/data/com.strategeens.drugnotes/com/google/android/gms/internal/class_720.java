package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.class_141;
import com.google.android.gms.internal.lf;

// $FF: renamed from: com.google.android.gms.internal.lf
public final class class_720 implements class_141 {
   // $FF: renamed from: Of com.google.android.gms.internal.lf
   private static class_720 field_3331;

   // $FF: renamed from: if () com.google.android.gms.internal.ld
   public static class_141 method_4198() {
      synchronized(lf.class){}

      class_720 var1;
      try {
         if(field_3331 == null) {
            field_3331 = new class_720();
         }

         var1 = field_3331;
      } finally {
         ;
      }

      return var1;
   }

   public long currentTimeMillis() {
      return System.currentTimeMillis();
   }

   public long elapsedRealtime() {
      return SystemClock.elapsedRealtime();
   }
}
