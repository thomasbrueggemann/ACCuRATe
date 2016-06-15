package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.g
class class_570 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2674;
   private final Context mContext;

   static {
      field_2674 = class_520.field_2273.toString();
   }

   public class_570(Context var1) {
      super(field_2674, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      try {
         PackageManager var3 = this.mContext.getPackageManager();
         class_57.class_1084 var4 = class_635.method_3597(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
         return var4;
      } catch (NameNotFoundException var5) {
         class_613.method_3495("App name is not found.", var5);
         return class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
