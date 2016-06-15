package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_361;
import com.google.android.gms.internal.class_368;
import com.google.android.gms.internal.class_438;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.fe
@ey
public final class class_435 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.fh, com.google.android.gms.internal.fe$a) com.google.android.gms.internal.gf
   public static class_360 method_2859(Context var0, class_440 var1, class_435.class_1523 var2) {
      return var1.field_1460.field_1124?method_2860(var0, var1, var2):method_2861(var0, var1, var2);
   }

   // $FF: renamed from: b (android.content.Context, com.google.android.gms.internal.fh, com.google.android.gms.internal.fe$a) com.google.android.gms.internal.gf
   private static class_360 method_2860(Context var0, class_440 var1, class_435.class_1523 var2) {
      class_368.method_2502("Fetching ad response from local ad request service.");
      class_361.class_1621 var3 = new class_361.class_1621(var0, var1, var2);
      var3.start();
      return var3;
   }

   // $FF: renamed from: c (android.content.Context, com.google.android.gms.internal.fh, com.google.android.gms.internal.fe$a) com.google.android.gms.internal.gf
   private static class_360 method_2861(Context var0, class_440 var1, class_435.class_1523 var2) {
      class_368.method_2502("Fetching ad response from remote ad request service.");
      if(GooglePlayServicesUtil.isGooglePlayServicesAvailable(var0) != 0) {
         class_368.method_2506("Failed to connect to remote ad request service.");
         return null;
      } else {
         return new class_361.class_1622(var0, var1, var2);
      }
   }

   public interface class_1523 {
      // $FF: renamed from: a (com.google.android.gms.internal.fj) void
      void method_666(class_438 var1);
   }
}
