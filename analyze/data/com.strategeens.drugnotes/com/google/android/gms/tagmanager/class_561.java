package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_57;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.aj
abstract class class_561 {
   private final Set<String> art;
   private final String aru;

   public class_561(String var1, String... var2) {
      this.aru = var1;
      this.art = new HashSet(var2.length);
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.art.add(var5);
      }

   }

   // $FF: renamed from: B (java.util.Map) com.google.android.gms.internal.d$a
   public abstract class_57.class_1084 method_3446(Map<String, class_57.class_1084> var1);

   // $FF: renamed from: a (java.util.Set) boolean
   boolean method_3447(Set<String> var1) {
      return var1.containsAll(this.art);
   }

   // $FF: renamed from: pI () java.lang.String
   public String method_3448() {
      return this.aru;
   }

   // $FF: renamed from: pJ () java.util.Set
   public Set<String> method_3449() {
      return this.art;
   }

   // $FF: renamed from: pe () boolean
   public abstract boolean method_3450();
}
