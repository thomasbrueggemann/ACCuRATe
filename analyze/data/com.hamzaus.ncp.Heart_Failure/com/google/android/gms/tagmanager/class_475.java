package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_515;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.h
class class_475 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2834;
   private final Context mContext;

   static {
      field_2834 = class_445.field_2463.toString();
   }

   public class_475(Context var1) {
      super(field_2834, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      try {
         class_52.class_816 var3 = class_537.method_3027(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
         return var3;
      } catch (NameNotFoundException var4) {
         class_515.method_2916("Package name " + this.mContext.getPackageName() + " not found. " + var4.getMessage());
         return class_537.method_3020();
      }
   }
}
