package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.ci
class class_488 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2846;
   private final Context mContext;

   static {
      field_2846 = class_445.field_2402.toString();
   }

   public class_488(Context var1) {
      super(field_2846, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
      int var3 = var2.widthPixels;
      int var4 = var2.heightPixels;
      return class_537.method_3027(var3 + "x" + var4);
   }
}
