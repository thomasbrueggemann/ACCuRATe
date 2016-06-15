package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.common.data.g
public abstract class class_469<T> extends DataBuffer<T> {
   // $FF: renamed from: Lr boolean
   private boolean field_1601 = false;
   // $FF: renamed from: Ls java.util.ArrayList
   private ArrayList<Integer> field_1602;

   protected class_469(DataHolder var1) {
      super(var1);
   }

   // $FF: renamed from: hb () void
   private void method_2984() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: ax (int) int
   int method_2985(int var1) {
      if(var1 >= 0 && var1 < this.field_1602.size()) {
         return ((Integer)this.field_1602.get(var1)).intValue();
      } else {
         throw new IllegalArgumentException("Position " + var1 + " is out of bounds for this buffer");
      }
   }

   // $FF: renamed from: ay (int) int
   protected int method_2986(int var1) {
      int var2;
      if(var1 >= 0 && var1 != this.field_1602.size()) {
         if(var1 == -1 + this.field_1602.size()) {
            var2 = this.JG.getCount() - ((Integer)this.field_1602.get(var1)).intValue();
         } else {
            var2 = ((Integer)this.field_1602.get(var1 + 1)).intValue() - ((Integer)this.field_1602.get(var1)).intValue();
         }

         if(var2 == 1) {
            int var3 = this.method_2985(var1);
            int var4 = this.JG.method_5829(var3);
            String var5 = this.method_2989();
            if(var5 != null && this.JG.method_5831(var5, var3, var4) == null) {
               return 0;
            }
         }
      } else {
         var2 = 0;
      }

      return var2;
   }

   // $FF: renamed from: f (int, int) java.lang.Object
   protected abstract T method_2987(int var1, int var2);

   public final T get(int var1) {
      this.method_2984();
      return this.method_2987(this.method_2985(var1), this.method_2986(var1));
   }

   public int getCount() {
      this.method_2984();
      return this.field_1602.size();
   }

   // $FF: renamed from: ha () java.lang.String
   protected abstract String method_2988();

   // $FF: renamed from: hc () java.lang.String
   protected String method_2989() {
      return null;
   }
}
