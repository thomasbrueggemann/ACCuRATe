package com.google.android.gms.internal;

import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_636;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.mf;
import com.google.android.gms.internal.mh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.mb
public abstract class class_247<M extends mb<M>> extends mf {
   protected List<mh> amU;

   // $FF: renamed from: a (com.google.android.gms.internal.mc) java.lang.Object
   public final <T> T method_1726(mc<M, T> var1) {
      return var1.method_3543(this.amU);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ma) void
   public void method_1721(class_601 var1) throws IOException {
      int var2;
      if(this.amU == null) {
         var2 = 0;
      } else {
         var2 = this.amU.size();
      }

      for(int var3 = 0; var3 < var2; ++var3) {
         class_636 var4 = (class_636)this.amU.get(var3);
         var1.method_3531(var4.tag);
         var1.method_3539(var4.amZ);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.lz, int) boolean
   protected final boolean method_1727(class_605 var1, int var2) throws IOException {
      int var3 = var1.getPosition();
      if(!var1.method_3556(var2)) {
         return false;
      } else {
         if(this.amU == null) {
            this.amU = new ArrayList();
         }

         byte[] var4 = var1.method_3574(var3, var1.getPosition() - var3);
         this.amU.add(new class_636(var2, var4));
         return true;
      }
   }

   // $FF: renamed from: c () int
   protected int method_1723() {
      int var1;
      if(this.amU == null) {
         var1 = 0;
      } else {
         var1 = this.amU.size();
      }

      int var2 = 0;

      int var3;
      for(var3 = 0; var2 < var1; ++var2) {
         class_636 var4 = (class_636)this.amU.get(var2);
         var3 = var3 + class_601.method_3501(var4.tag) + var4.amZ.length;
      }

      return var3;
   }
}
