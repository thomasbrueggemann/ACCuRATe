package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_229;
import com.google.android.gms.internal.class_360;
import com.google.android.gms.internal.class_362;
import com.google.android.gms.internal.class_364;
import com.google.android.gms.internal.class_371;
import com.google.android.gms.internal.class_43;
import com.google.android.gms.internal.class_432;
import com.google.android.gms.internal.class_548;
import com.google.android.gms.internal.ey;

// $FF: renamed from: com.google.android.gms.internal.fc
@ey
public final class class_437 {
   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.u, com.google.android.gms.internal.fy$a, com.google.android.gms.internal.gu, com.google.android.gms.internal.cy, com.google.android.gms.internal.fc$a) com.google.android.gms.internal.gf
   public static class_360 method_2875(Context var0, class_548 var1, class_432.class_1521 var2, class_371 var3, class_43 var4, class_437.class_1183 var5) {
      Object var6;
      if(var2.field_4105.field_1457) {
         var6 = new class_362(var0, var1, new class_229(), var2, var5);
      } else {
         var6 = new class_364(var0, var2, var3, var4, var5);
      }

      ((class_360)var6).start();
      return (class_360)var6;
   }

   public interface class_1183 {
      // $FF: renamed from: a (com.google.android.gms.internal.fy) void
      void method_225(class_432 var1);
   }
}
