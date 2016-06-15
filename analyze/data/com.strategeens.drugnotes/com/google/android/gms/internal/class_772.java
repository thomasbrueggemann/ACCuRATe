package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.class_148;
import com.google.android.gms.internal.mz;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;

// $FF: renamed from: com.google.android.gms.internal.mz
public class class_772 {
   // $FF: renamed from: DZ java.lang.String
   private final String field_3430;
   // $FF: renamed from: Ee com.google.android.gms.internal.np
   private final np<ni> field_3431;
   // $FF: renamed from: JK java.lang.String
   private final String field_3432;
   private class_148 agz;
   private final Context mContext;

   private class_772(Context var1, String var2, String var3, np<ni> var4) {
      this.mContext = var1;
      this.field_3430 = var2;
      this.field_3431 = var4;
      this.agz = null;
      this.field_3432 = var3;
   }

   // $FF: renamed from: a (android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.internal.np) com.google.android.gms.internal.mz
   public static mz method_4391(Context var0, String var1, String var2, np<ni> var3) {
      return new class_772(var0, var1, var2, var3);
   }
}
