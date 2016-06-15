package com.google.android.gms.internal;

import com.google.android.gms.internal.class_347;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.hl
public final class class_349 {
   // $FF: renamed from: e (java.lang.Object) com.google.android.gms.internal.hl$a
   public static class_349.class_1264 method_2174(Object var0) {
      return new class_349.class_1264(var0);
   }

   public static boolean equal(Object var0, Object var1) {
      return var0 == var1 || var0 != null && var0.equals(var1);
   }

   public static int hashCode(Object... var0) {
      return Arrays.hashCode(var0);
   }

   public static final class class_1264 {
      // $FF: renamed from: GG java.util.List
      private final List<String> field_4068;
      // $FF: renamed from: GH java.lang.Object
      private final Object field_4069;

      private class_1264(Object var1) {
         this.field_4069 = class_347.method_2170(var1);
         this.field_4068 = new ArrayList();
      }

      // $FF: synthetic method
      class_1264(Object var1, Object var2) {
         this(var1);
      }

      // $FF: renamed from: a (java.lang.String, java.lang.Object) com.google.android.gms.internal.hl$a
      public class_349.class_1264 method_4301(String var1, Object var2) {
         this.field_4068.add((String)class_347.method_2170(var1) + "=" + var2);
         return this;
      }

      public String toString() {
         StringBuilder var1 = (new StringBuilder(100)).append(this.field_4069.getClass().getSimpleName()).append('{');
         int var2 = this.field_4068.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            var1.append((String)this.field_4068.get(var3));
            if(var3 < var2 - 1) {
               var1.append(", ");
            }
         }

         return var1.append('}').toString();
      }
   }
}
