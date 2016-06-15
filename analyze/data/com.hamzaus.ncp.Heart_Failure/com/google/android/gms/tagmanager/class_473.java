package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.g
class class_473 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2832;
   private final Context mContext;

   static {
      field_2832 = class_445.field_2462.toString();
   }

   public class_473(Context var1) {
      super(field_2832, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      try {
         PackageManager var3 = this.mContext.getPackageManager();
         class_52.class_816 var4 = class_537.method_3027(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
         return var4;
      } catch (NameNotFoundException var5) {
         class_515.method_2920("App name is not found.", var5);
         return class_537.method_3020();
      }
   }
}
