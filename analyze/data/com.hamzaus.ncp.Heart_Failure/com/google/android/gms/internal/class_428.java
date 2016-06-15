package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_358;
import com.google.android.gms.internal.class_359;
import com.google.android.gms.internal.class_370;
import com.google.android.gms.internal.class_431;
import com.google.android.gms.internal.class_433;

// $FF: renamed from: com.google.android.gms.internal.dq
public final class class_428 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.dt, com.google.android.gms.internal.dq$a) com.google.android.gms.internal.en
   public static class_358 method_2579(Context var0, class_433 var1, class_428.class_826 var2) {
      return var1.field_1901.field_1610?method_2580(var0, var1, var2):method_2581(var0, var1, var2);
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.dt, com.google.android.gms.internal.dq$a) com.google.android.gms.internal.en
   private static class_358 method_2580(Context var0, class_433 var1, class_428.class_826 var2) {
      class_370.method_2363("Fetching ad response from local ad request service.");
      class_359.class_1010 var3 = new class_359.class_1010(var0, var1, var2);
      var3.start();
      return var3;
   }

   // $FF: renamed from: c (android.content.Context, com.google.android.gms.internal.dt, com.google.android.gms.internal.dq$a) com.google.android.gms.internal.en
   private static class_358 method_2581(Context var0, class_433 var1, class_428.class_826 var2) {
      class_370.method_2363("Fetching ad response from remote ad request service.");
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
         class_370.method_2358("Failed to connect to remote ad request service.");
         return null;
      } else {
         return new class_359.class_1009(var0, var1, var2);
      }
   }

   public interface class_826 {
      // $FF: renamed from: a (com.google.android.gms.internal.dv) void
      void method_71(class_431 var1);
   }
}
