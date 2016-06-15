package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_561;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;

// $FF: renamed from: com.google.android.gms.tagmanager.bl
class class_594 extends class_561 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2698;
   private final Context mContext;

   static {
      field_2698 = class_520.field_2240.toString();
   }

   public class_594(Context var1) {
      super(field_2698, new String[0]);
      this.mContext = var1;
   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1) {
      String var2 = this.method_3479(this.mContext);
      return var2 == null?class_635.method_3594():class_635.method_3597(var2);
   }

   // $FF: renamed from: Y (android.content.Context) java.lang.String
   protected String method_3479(Context var1) {
      return Secure.getString(var1.getContentResolver(), "android_id");
   }

   // $FF: renamed from: pe () boolean
   public boolean method_3450() {
      return true;
   }
}
