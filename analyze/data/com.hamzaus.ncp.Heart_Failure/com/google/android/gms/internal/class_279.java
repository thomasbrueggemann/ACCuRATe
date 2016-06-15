package com.google.android.gms.internal;

import com.google.android.gms.internal.class_19;
import com.google.android.gms.internal.im;

// $FF: renamed from: com.google.android.gms.internal.im
public final class class_279 implements class_19 {
   // $FF: renamed from: Hs com.google.android.gms.internal.im
   private static class_279 field_946;

   // $FF: renamed from: fW () com.google.android.gms.internal.ik
   public static class_19 method_1858() {
      synchronized(im.class){}

      class_279 var1;
      try {
         if(field_946 == null) {
            field_946 = new class_279();
         }

         var1 = field_946;
      } finally {
         ;
      }

      return var1;
   }

   public long currentTimeMillis() {
      return System.currentTimeMillis();
   }
}
