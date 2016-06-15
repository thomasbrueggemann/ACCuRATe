package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.common.data.g
public abstract class class_437<T> extends DataBuffer<T> {
   // $FF: renamed from: ER boolean
   private boolean field_1926 = false;
   // $FF: renamed from: ES java.util.ArrayList
   private ArrayList<Integer> field_1927;

   protected class_437(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: eV () void
   private void method_2623() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ah (int) int
   int method_2624(int var1) {
      if(var1 >= 0 && var1 < this.field_1927.size()) {
         return ((Integer)this.field_1927.get(var1)).intValue();
      } else {
         throw new IllegalArgumentException("Position " + var1 + " is out of bounds for this buffer");
      }
   }

   // $FF: renamed from: ai (int) int
   protected int method_2625(int var1) {
      int var2;
      if(var1 >= 0 && var1 != this.field_1927.size()) {
         if(var1 == -1 + this.field_1927.size()) {
            var2 = this.DD.getCount() - ((Integer)this.field_1927.get(var1)).intValue();
         } else {
            var2 = ((Integer)this.field_1927.get(var1 + 1)).intValue() - ((Integer)this.field_1927.get(var1)).intValue();
         }

         if(var2 == 1) {
            int var3 = this.method_2624(var1);
            int var4 = this.DD.method_4556(var3);
            String var5 = this.method_2628();
            if(var5 != null && this.DD.method_4560(var5, var3, var4) == null) {
               return 0;
            }
         }
      } else {
         var2 = 0;
      }

      return var2;
   }

   // $FF: renamed from: c (int, int) java.lang.Object
   protected abstract T method_2626(int var1, int var2);

   // $FF: renamed from: eU () java.lang.String
   protected abstract String method_2627();

   // $FF: renamed from: eW () java.lang.String
   protected String method_2628() {
      return null;
   }

   public final T get(int var1) {
      this.method_2623();
      return this.method_2626(this.method_2624(var1), this.method_2625(var1));
   }

   public int getCount() {
      this.method_2623();
      return this.field_1927.size();
   }
}
