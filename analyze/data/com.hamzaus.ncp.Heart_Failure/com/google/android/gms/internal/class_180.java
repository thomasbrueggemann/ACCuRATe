package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.class_157;
import com.google.android.gms.dynamic.class_176;
import com.google.android.gms.dynamic.class_741;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.internal.class_30;
import com.google.android.gms.internal.hk;

// $FF: renamed from: com.google.android.gms.internal.ho
public final class class_180 extends g<hk> {
   // $FF: renamed from: GI com.google.android.gms.internal.ho
   private static final class_180 field_577 = new class_180();

   private class_180() {
      super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
   }

   // $FF: renamed from: b (android.content.Context, int, int) android.view.View
   public static View method_1289(Context var0, int var1, int var2) throws class_176.class_1202 {
      return field_577.method_1290(var0, var1, var2);
   }

   // $FF: renamed from: c (android.content.Context, int, int) android.view.View
   private View method_1290(Context var1, int var2, int var3) throws class_176.class_1202 {
      try {
         class_157 var5 = class_741.method_4178(var1);
         View var6 = (View)class_741.method_4177(((class_30)this.D(var1)).method_151(var5, var2, var3));
         return var6;
      } catch (Exception var7) {
         throw new class_176.class_1202("Could not get button with size " + var2 + " and color " + var3, var7);
      }
   }

   // $FF: renamed from: N (android.os.IBinder) com.google.android.gms.internal.hk
   public class_30 method_1291(IBinder var1) {
      return class_30.class_974.method_2749(var1);
   }

   // $FF: renamed from: d (android.os.IBinder) java.lang.Object
   // $FF: synthetic method
   public Object method_1277(IBinder var1) {
      return this.method_1291(var1);
   }
}
