package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_821;
import com.google.android.gms.internal.class_822;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qr;
import com.google.android.gms.internal.qw;
import com.google.android.gms.internal.qy;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.qr
public class class_831<M extends qq<M>, T> {
   protected final Class<T> ayX;
   protected final boolean ayY;
   public final int tag;
   protected final int type;

   private class_831(int var1, Class<T> var2, int var3, boolean var4) {
      this.type = var1;
      this.ayX = var2;
      this.tag = var3;
      this.ayY = var4;
   }

   // $FF: renamed from: a (int, java.lang.Class, int) com.google.android.gms.internal.qr
   public static <M extends qq<M>, T extends qw> qr<M, T> method_4599(int var0, Class<T> var1, int var2) {
      return new class_831(var0, var1, var2, false);
   }

   // $FF: renamed from: n (java.util.List) java.lang.Object
   private T method_4600(List<qy> var1) {
      int var2 = 0;
      ArrayList var3 = new ArrayList();

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         class_821 var7 = (class_821)var1.get(var4);
         if(var7.azi.length != 0) {
            this.method_4605(var7, var3);
         }
      }

      int var5 = var3.size();
      Object var6;
      if(var5 == 0) {
         var6 = null;
      } else {
         for(var6 = this.ayX.cast(Array.newInstance(this.ayX.getComponentType(), var5)); var2 < var5; ++var2) {
            Array.set(var6, var2, var3.get(var2));
         }
      }

      return var6;
   }

   // $FF: renamed from: o (java.util.List) java.lang.Object
   private T method_4601(List<qy> var1) {
      if(var1.isEmpty()) {
         return null;
      } else {
         class_821 var2 = (class_821)var1.get(-1 + var1.size());
         return this.ayX.cast(this.method_4610(class_827.method_4561(var2.azi)));
      }
   }

   // $FF: renamed from: B (java.lang.Object) int
   int method_4602(Object var1) {
      return this.ayY?this.method_4603(var1):this.method_4604(var1);
   }

   // $FF: renamed from: C (java.lang.Object) int
   protected int method_4603(Object var1) {
      int var2 = 0;
      int var3 = Array.getLength(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(Array.get(var1, var4) != null) {
            var2 += this.method_4604(Array.get(var1, var4));
         }
      }

      return var2;
   }

   // $FF: renamed from: D (java.lang.Object) int
   protected int method_4604(Object var1) {
      int var2 = class_822.method_4486(this.tag);
      switch(this.type) {
      case 10:
         return class_826.method_4503(var2, (class_300)var1);
      case 11:
         return class_826.method_4507(var2, (class_300)var1);
      default:
         throw new IllegalArgumentException("Unknown type " + this.type);
      }
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qy, java.util.List) void
   protected void method_4605(qy var1, List<Object> var2) {
      var2.add(this.method_4610(class_827.method_4561(var1.azi)));
   }

   // $FF: renamed from: a (java.lang.Object, com.google.android.gms.internal.qp) void
   void method_4606(Object var1, class_826 var2) throws IOException {
      if(this.ayY) {
         this.method_4608(var1, var2);
      } else {
         this.method_4607(var1, var2);
      }
   }

   // $FF: renamed from: b (java.lang.Object, com.google.android.gms.internal.qp) void
   protected void method_4607(Object var1, class_826 var2) {
      try {
         var2.method_4549(this.tag);
         switch(this.type) {
         case 10:
            class_300 var4 = (class_300)var1;
            int var5 = class_822.method_4486(this.tag);
            var2.method_4539(var4);
            var2.method_4557(var5, 4);
            return;
         case 11:
            var2.method_4541((class_300)var1);
            return;
         default:
            throw new IllegalArgumentException("Unknown type " + this.type);
         }
      } catch (IOException var6) {
         throw new IllegalStateException(var6);
      }
   }

   // $FF: renamed from: c (java.lang.Object, com.google.android.gms.internal.qp) void
   protected void method_4608(Object var1, class_826 var2) {
      int var3 = Array.getLength(var1);

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = Array.get(var1, var4);
         if(var5 != null) {
            this.method_4607(var5, var2);
         }
      }

   }

   // $FF: renamed from: m (java.util.List) java.lang.Object
   final T method_4609(List<qy> var1) {
      return var1 == null?null:(this.ayY?this.method_4600(var1):this.method_4601(var1));
   }

   // $FF: renamed from: x (com.google.android.gms.internal.qo) java.lang.Object
   protected Object method_4610(class_827 var1) {
      Class var2;
      if(this.ayY) {
         var2 = this.ayX.getComponentType();
      } else {
         var2 = this.ayX;
      }

      try {
         switch(this.type) {
         case 10:
            class_300 var7 = (class_300)var2.newInstance();
            var1.method_4564(var7, class_822.method_4486(this.tag));
            return var7;
         case 11:
            class_300 var6 = (class_300)var2.newInstance();
            var1.method_4563(var6);
            return var6;
         default:
            throw new IllegalArgumentException("Unknown type " + this.type);
         }
      } catch (InstantiationException var8) {
         throw new IllegalArgumentException("Error creating instance of class " + var2, var8);
      } catch (IllegalAccessException var9) {
         throw new IllegalArgumentException("Error creating instance of class " + var2, var9);
      } catch (IOException var10) {
         throw new IllegalArgumentException("Error reading extension field", var10);
      }
   }
}
