package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.class_335;

// $FF: renamed from: com.google.android.gms.internal.lm
public class class_713 {
   // $FF: renamed from: d (java.lang.String[]) com.google.android.gms.common.api.Scope[]
   public static Scope[] method_4186(String[] var0) {
      class_335.method_2306(var0, "scopeStrings can\'t be null.");
      Scope[] var2 = new Scope[var0.length];

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var2[var3] = new Scope(var0[var3]);
      }

      return var2;
   }
}
