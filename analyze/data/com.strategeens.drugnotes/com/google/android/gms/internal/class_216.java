package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.class_198;
import com.google.android.gms.dynamic.class_211;
import com.google.android.gms.dynamic.class_960;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_20;
import com.google.android.gms.internal.ju;

// $FF: renamed from: com.google.android.gms.internal.jy
public final class class_216 extends g<ju> {
   // $FF: renamed from: Nt com.google.android.gms.internal.jy
   private static final class_216 field_355 = new class_216();

   private class_216() {
      super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
   }

   // $FF: renamed from: b (android.content.Context, int, int) android.view.View
   public static View method_1525(Context var0, int var1, int var2) throws class_211.class_1565 {
      return field_355.method_1526(var0, var1, var2);
   }

   // $FF: renamed from: c (android.content.Context, int, int) android.view.View
   private View method_1526(Context var1, int var2, int var3) throws class_211.class_1565 {
      try {
         class_198 var5 = class_960.method_5293(var1);
         View var6 = (View)class_960.method_5292(((class_20)this.L(var1)).method_170(var5, var2, var3));
         return var6;
      } catch (Exception var7) {
         throw new class_211.class_1565("Could not get button with size " + var2 + " and color " + var3, var7);
      }
   }

   // $FF: renamed from: S (android.os.IBinder) com.google.android.gms.internal.ju
   public class_20 method_1527(IBinder var1) {
      return class_20.class_1129.method_2740(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   public Object method_1511(IBinder var1) {
      return this.method_1527(var1);
   }
}
