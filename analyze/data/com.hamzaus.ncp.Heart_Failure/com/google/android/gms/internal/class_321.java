package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.hr;

// $FF: renamed from: com.google.android.gms.internal.gx
public final class class_321 extends hr<class_321.class_906, Drawable> {
   public class_321() {
      super(10);
   }

   public static final class class_906 {
      // $FF: renamed from: FP int
      public final int field_2153;
      // $FF: renamed from: FQ int
      public final int field_2154;

      public class_906(int var1, int var2) {
         this.field_2153 = var1;
         this.field_2154 = var2;
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if(!(var1 instanceof class_321.class_906)) {
            var2 = false;
         } else if(this != var1) {
            class_321.class_906 var3 = (class_321.class_906)var1;
            if(var3.field_2153 != this.field_2153 || var3.field_2154 != this.field_2154) {
               return false;
            }
         }

         return var2;
      }

      public int hashCode() {
         Object[] var1 = new Object[]{Integer.valueOf(this.field_2153), Integer.valueOf(this.field_2154)};
         return class_349.hashCode(var1);
      }
   }
}
