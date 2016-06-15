package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.ni;
import com.google.android.gms.internal.np;

// $FF: renamed from: com.google.android.gms.internal.ie
public class class_329 {
   // $FF: renamed from: Ee com.google.android.gms.internal.np
   private final np<ni> field_884;
   private final Context mContext;

   private class_329(Context var1, np<ni> var2) {
      this.mContext = var1;
      this.field_884 = var2;
   }

   // $FF: renamed from: a (android.content.Context, com.google.android.gms.internal.np) com.google.android.gms.internal.ie
   public static ie method_2287(Context var0, np<ni> var1) {
      return new class_329(var0, var1);
   }
}
