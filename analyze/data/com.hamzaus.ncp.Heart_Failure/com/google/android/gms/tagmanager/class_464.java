package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.class_52;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.tagmanager.aj
abstract class class_464 {
   private final String afA;
   private final Set<String> afz;

   public class_464(String var1, String... var2) {
      this.afA = var1;
      this.afz = new HashSet(var2.length);
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         this.afz.add(var5);
      }

   }

   // $FF: renamed from: a (java.util.Set) boolean
   boolean method_2878(Set<String> var1) {
      return var1.containsAll(this.afz);
   }

   // $FF: renamed from: lG () java.lang.String
   public String method_2879() {
      return this.afA;
   }

   // $FF: renamed from: lH () java.util.Set
   public Set<String> method_2880() {
      return this.afz;
   }

   // $FF: renamed from: lc () boolean
   public abstract boolean method_2881();

   // $FF: renamed from: w (java.util.Map) com.google.android.gms.internal.d$a
   public abstract class_52.class_816 method_2882(Map<String, class_52.class_816> var1);
}
