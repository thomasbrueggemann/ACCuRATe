package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.kj;

// $FF: renamed from: com.google.android.gms.internal.jc
public final class class_352 extends kj<class_352.class_1620, Drawable> {
   public class_352() {
      super(10);
   }

   public static final class class_1620 {
      // $FF: renamed from: Mt int
      public final int field_4432;
      // $FF: renamed from: Mu int
      public final int field_4433;

      public class_1620(int var1, int var2) {
         this.field_4432 = var1;
         this.field_4433 = var2;
      }

      public boolean equals(Object var1) {
         boolean var2 = true;
         if(!(var1 instanceof class_352.class_1620)) {
            var2 = false;
         } else if(this != var1) {
            class_352.class_1620 var3 = (class_352.class_1620)var1;
            if(var3.field_4432 != this.field_4432 || var3.field_4433 != this.field_4433) {
               return false;
            }
         }

         return var2;
      }

      public int hashCode() {
         Object[] var1 = new Object[]{Integer.valueOf(this.field_4432), Integer.valueOf(this.field_4433)};
         return class_336.hashCode(var1);
      }
   }
}
