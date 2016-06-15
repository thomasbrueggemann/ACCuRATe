package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_519;
import com.google.android.gms.internal.class_520;
import com.google.android.gms.internal.class_57;
import com.google.android.gms.tagmanager.class_597;
import com.google.android.gms.tagmanager.class_635;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// $FF: renamed from: com.google.android.gms.tagmanager.ci
class class_602 extends class_597 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2704;
   private static final String asy;

   static {
      field_2704 = class_520.field_2250.toString();
      asy = class_519.field_2094.toString();
   }

   public class_602() {
      super(field_2704);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_3481(String var1, String var2, Map<String, class_57.class_1084> var3) {
      byte var4;
      if(class_635.method_3583((class_57.class_1084)var3.get(asy)).booleanValue()) {
         var4 = 66;
      } else {
         var4 = 64;
      }

      try {
         boolean var6 = Pattern.compile(var2, var4).matcher(var1).find();
         return var6;
      } catch (PatternSyntaxException var7) {
         return false;
      }
   }
}
