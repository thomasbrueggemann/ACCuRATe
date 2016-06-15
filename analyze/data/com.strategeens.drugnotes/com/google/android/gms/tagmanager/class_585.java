package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.cj
class class_585 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2688;
   private final Context mContext;

   static {
      field_2688 = class_520.field_2201.toString();
   }

   public class_585(Context var1) {
      super(field_2688, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
      int var3 = var2.widthPixels;
      int var4 = var2.heightPixels;
      return class_635.method_3597(var3 + "x" + var4);
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
