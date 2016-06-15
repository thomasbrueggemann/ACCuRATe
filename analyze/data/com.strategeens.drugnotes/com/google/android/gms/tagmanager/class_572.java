package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_613;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.h
class class_572 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2676;
   private final Context mContext;

   static {
      field_2676 = class_520.field_2274.toString();
   }

   public class_572(Context var1) {
      super(field_2676, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      try {
         class_57.class_1084 var3 = class_635.method_3597(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
         return var3;
      } catch (NameNotFoundException var4) {
         class_613.method_3491("Package name " + this.mContext.getPackageName() + " not found. " + var4.getMessage());
         return class_635.method_3594();
      }
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
