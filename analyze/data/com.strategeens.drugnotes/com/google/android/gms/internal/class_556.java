package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.class_555;
import com.google.android.gms.internal.class_71;
import com.google.android.gms.internal.class_72;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

// $FF: renamed from: com.google.android.gms.internal.j
public class class_556 extends class_555 {
   // $FF: renamed from: kO com.google.android.gms.ads.identifier.AdvertisingIdClient
   private static AdvertisingIdClient field_2559;
   // $FF: renamed from: kP java.util.concurrent.CountDownLatch
   private static CountDownLatch field_2560 = new CountDownLatch(1);
   // $FF: renamed from: kQ boolean
   private static boolean field_2561;

   protected class_556(Context var1, class_71 var2, class_72 var3) {
      super(var1, var2, var3);
   }

   // $FF: renamed from: A () com.google.android.gms.ads.identifier.AdvertisingIdClient
   // $FF: synthetic method
   static AdvertisingIdClient method_3383() {
      return field_2559;
   }

   // $FF: renamed from: B () java.util.concurrent.CountDownLatch
   // $FF: synthetic method
   static CountDownLatch method_3384() {
      return field_2560;
   }

   // $FF: renamed from: a (com.google.android.gms.ads.identifier.AdvertisingIdClient) com.google.android.gms.ads.identifier.AdvertisingIdClient
   // $FF: synthetic method
   static AdvertisingIdClient method_3385(AdvertisingIdClient var0) {
      field_2559 = var0;
      return var0;
   }

   // $FF: renamed from: a (java.lang.String, android.content.Context) com.google.android.gms.internal.j
   public static class_556 method_3386(String param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: a (boolean) boolean
   // $FF: synthetic method
   static boolean method_3387(boolean var0) {
      field_2561 = var0;
      return var0;
   }

   // $FF: renamed from: b (android.content.Context) void
   protected void method_3368(Context param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: z () com.google.android.gms.internal.j$a
   class_556.class_1661 method_3388() throws IOException {
      // $FF: Couldn't be decompiled
   }

   class class_1661 {
      // $FF: renamed from: kR java.lang.String
      private String field_4186;
      // $FF: renamed from: kS boolean
      private boolean field_4187;

      public class_1661(String var2, boolean var3) {
         this.field_4186 = var2;
         this.field_4187 = var3;
      }

      public String getId() {
         return this.field_4186;
      }

      public boolean isLimitAdTrackingEnabled() {
         return this.field_4187;
      }
   }
}
