package com.google.android.gms.internal;

import com.google.android.gms.internal.class_821;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_829;
import com.google.android.gms.internal.class_830;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qw;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.qq
public abstract class class_301<M extends qq<M>> extends qw {
   protected class_830 ayW;

   // $FF: renamed from: a (com.google.android.gms.internal.qr) java.lang.Object
   public final <T> T method_2094(qr<M, T> var1) {
      if(this.ayW != null) {
         class_829 var2 = this.ayW.method_4597(class_822.method_4486(var1.tag));
         if(var2 != null) {
            return var2.method_4590(var1);
         }
      }

      return null;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   public void method_2089(class_826 var1) throws IOException {
      if(this.ayW != null) {
         for(int var2 = 0; var2 < this.ayW.size(); ++var2) {
            this.ayW.method_4598(var2).method_4588(var1);
         }
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.qo, int) boolean
   protected final boolean method_2095(class_827 var1, int var2) throws IOException {
      int var3 = var1.getPosition();
      if(!var1.method_4566(var2)) {
         return false;
      } else {
         int var4 = class_822.method_4486(var2);
         class_821 var5 = new class_821(var2, var1.method_4586(var3, var1.getPosition() - var3));
         class_829 var6 = null;
         if(this.ayW == null) {
            this.ayW = new class_830();
         } else {
            var6 = this.ayW.method_4597(var4);
         }

         if(var6 == null) {
            var6 = new class_829();
            this.ayW.method_4596(var4, var6);
         }

         var6.method_4589(var5);
         return true;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qq) boolean
   protected final boolean method_2096(M var1) {
      return this.ayW != null && !this.ayW.isEmpty()?this.ayW.equals(var1.ayW):var1.ayW == null || var1.ayW.isEmpty();
   }

   // $FF: renamed from: c () int
   protected int method_2091() {
      int var1 = 0;
      int var2;
      if(this.ayW != null) {
         for(var2 = 0; var1 < this.ayW.size(); ++var1) {
            var2 += this.ayW.method_4598(var1).method_4591();
         }
      } else {
         var2 = 0;
      }

      return var2;
   }

   // $FF: renamed from: rQ () int
   protected final int method_2097() {
      return this.ayW != null && !this.ayW.isEmpty()?this.ayW.hashCode():0;
   }
}
