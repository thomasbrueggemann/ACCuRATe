package com.google.android.gms.internal;

import com.google.android.gms.internal.class_335;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jv
public final class class_336 {
   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   // $FF: renamed from: h (java.lang.Object) com.google.android.gms.internal.jv$a
   public static class_336.class_1339 method_2312(Object var0) {
      return new class_336.class_1339(var0);
   }

   public static int hashCode(Object... var0) {
      return Arrays.hashCode(var0);
   }

   public static final class class_1339 {
      // $FF: renamed from: Nr java.util.List
      private final List<String> field_2606;
      // $FF: renamed from: Ns java.lang.Object
      private final Object field_2607;

      private class_1339(Object var1) {
         this.field_2607 = class_335.method_2311(var1);
         this.field_2606 = new ArrayList();
      }

      // $FF: synthetic method
      class_1339(Object var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (java.lang.String, java.lang.Object) com.google.android.gms.internal.jv$a
      public class_336.class_1339 method_3424(String var1, Object var2) {
         this.field_2606.add((String)class_335.method_2311(var1) + "=" + var2);
         return this;
      }

      public String toString() {
         StringBuilder var1 = (new StringBuilder(100)).append(this.field_2607.getClass().getSimpleName()).append('{');
         int var2 = this.field_2606.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.append((String)this.field_2606.get(var3));
            if(var3 < var2 - 1) {
               var1.append(", ");
            }
         }

         return var1.append('}').toString();
      }
   }
}
