package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_444;
import com.google.android.gms.internal.class_445;
import com.google.android.gms.internal.class_52;
import com.google.android.gms.tagmanager.class_498;
import com.google.android.gms.tagmanager.class_537;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// $FF: renamed from: com.google.android.gms.tagmanager.ch
class class_503 extends class_498 {
   // $FF: renamed from: ID java.lang.String
   private static final String field_2860;
   private static final String agG;

   static {
      field_2860 = class_445.field_2439.toString();
      agG = class_444.field_2257.toString();
   }

   public class_503() {
      super(field_2860);
   }

   // $FF: renamed from: a (java.lang.String, java.lang.String, java.util.Map) boolean
   protected boolean method_2907(String var1, String var2, Map<String, class_52.class_816> var3) {
      byte var4;
      if(class_537.method_3022((class_52.class_816)var3.get(agG)).booleanValue()) {
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
