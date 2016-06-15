package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_464;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.z
class class_465 extends class_464 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2823;
   private final Context mContext;

   static {
      field_2823 = class_445.field_2409.toString();
   }

   public class_465(Context var1) {
      super(field_2823, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: L (android.content.Context) java.lang.String
   protected String method_2883(Context var1) {
      return Secure.getString(var1.getContentResolver(), "android_id");
   }

   // $FF: renamed from: lc () boolean
   public boolean method_2881() {
      return true;
   }

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public class_52.class_816 method_2882(Map<String, class_52.class_816> var1) {
      String var2 = this.method_2883(this.mContext);
      return var2 == null?class_537.method_3020():class_537.method_3027(var2);
   }
}
