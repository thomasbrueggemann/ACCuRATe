package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.class_448;
import com.google.android.gms.internal.class_455;
import com.google.android.gms.internal.class_460;
import com.google.android.gms.internal.class_65;
import com.google.android.gms.internal.class_66;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.k
public class class_461 extends class_460 {
   private class_461(Context var1, class_65 var2, class_66 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: a (java.lang.String, android.content.Context) com.google.android.gms.internal.k
   public static class_461 method_2852(String var0, Context var1) {
      class_448 var2 = new class_448();
      a(var0, var1, var2);
      return new class_461(var1, var2, new class_455(239));
   }

   // $FF: renamed from: b (android.content.Context) void
   protected void method_2840(Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: f (android.content.Context) com.google.android.gms.internal.k$a
   class_461.class_973 method_2853(Context var1) throws IOException, GooglePlayServicesNotAvailableException {
      int var2 = 0;

      AdvertisingIdClient.Info var4;
      try {
         var4 = AdvertisingIdClient.getAdvertisingIdInfo(var1);
      } catch (GooglePlayServicesRepairableException var9) {
         throw new IOException(var9);
      }

      String var5 = var4.getId();
      String var6;
      if(var5 != null && var5.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
         byte[] var7 = new byte[16];

         for(int var8 = 0; var2 < var5.length(); var2 += 2) {
            if(var2 == 8 || var2 == 13 || var2 == 18 || var2 == 23) {
               ++var2;
            }

            var7[var8] = (byte)((Character.digit(var5.charAt(var2), 16) << 4) + Character.digit(var5.charAt(var2 + 1), 16));
            ++var8;
         }

         var6 = this.jQ.method_338(var7, true);
      } else {
         var6 = var5;
      }

      return new class_461.class_973(var6, var4.isLimitAdTrackingEnabled());
   }

   class class_973 {
      // $FF: renamed from: kb java.lang.String
      private String field_2188;
      // $FF: renamed from: kc boolean
      private boolean field_2189;

      public class_973(String var2, boolean var3) {
         this.field_2188 = var2;
         this.field_2189 = var3;
      }

      public String getId() {
         return this.field_2188;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.field_2189;
      }
   }
}
