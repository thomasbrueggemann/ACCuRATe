package com.google.android.gms.internal;

import com.google.android.gms.internal.class_167;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_814;
import com.google.android.gms.internal.class_818;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.os
public class class_817 {
   private final ArrayList<class_817.class_1075> amZ;
   private int ana;

   public class_817() {
      this(100);
   }

   public class_817(int var1) {
      this.amZ = new ArrayList();
      this.ana = var1;
   }

   // $FF: renamed from: oq () void
   private void method_4469() {
      while(this.getSize() > this.getCapacity()) {
         this.amZ.remove(0);
      }

   }

   // $FF: renamed from: a (com.google.android.gms.internal.ov, com.google.android.gms.internal.or) void
   public void method_4470(class_814 var1, class_818 var2) {
      this.amZ.add(new class_817.class_1075(var1, var2));
      this.method_4469();
   }

   public void clear() {
      this.amZ.clear();
   }

   public int getCapacity() {
      return this.ana;
   }

   public int getSize() {
      return this.amZ.size();
   }

   public boolean isEmpty() {
      return this.amZ.isEmpty();
   }

   // $FF: renamed from: op () java.util.ArrayList
   public ArrayList<class_817.class_1075> method_4471() {
      return this.amZ;
   }

   public static class class_1075 {
      public final class_814 anb;
      public final class_818 anc;
      public final class_167.class_1430 and;

      private class_1075(class_814 var1, class_818 var2) {
         this.anb = (class_814)class_335.method_2311(var1);
         this.anc = (class_818)class_335.method_2311(var2);
         this.and = null;
      }

      // $FF: synthetic method
      class_1075(class_814 var1, class_818 var2, Object var3) {
         this(var1, var2);
      }
   }
}
