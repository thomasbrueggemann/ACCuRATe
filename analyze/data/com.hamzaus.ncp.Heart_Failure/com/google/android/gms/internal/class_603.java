package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_636;
import com.google.android.gms.internal.class_638;
import com.google.android.gms.internal.mb;
import com.google.android.gms.internal.mc;
import com.google.android.gms.internal.mf;
import com.google.android.gms.internal.mh;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.mc
public class class_603<M extends mb<M>, T> {
   protected final Class<T> amV;
   protected final boolean amW;
   protected final int tag;
   protected final int type;

   private class_603(int var1, Class<T> var2, int var3, boolean var4) {
      this.type = var1;
      this.amV = var2;
      this.tag = var3;
      this.amW = var4;
   }

   // $FF: renamed from: a (int, java.lang.Class, int) com.google.android.gms.internal.mc
   public static <M extends mb<M>, T extends mf> mc<M, T> method_3540(int var0, Class<T> var1, int var2) {
      return new class_603(var0, var1, var2, false);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.mh, java.util.List) void
   protected void method_3541(mh var1, List<Object> var2) {
      var2.add(this.method_3544(class_605.method_3550(var1.amZ)));
   }

   // $FF: renamed from: eM (int) boolean
   protected boolean method_3542(int var1) {
      return var1 == this.tag;
   }

   // $FF: renamed from: i (java.util.List) java.lang.Object
   final T method_3543(List<mh> var1) {
      int var2 = 0;
      Object var6;
      if(var1 == null) {
         var6 = null;
      } else {
         if(!this.amW) {
            int var8 = -1 + var1.size();

            class_636 var9;
            class_636 var10;
            for(var9 = null; var9 == null && var8 >= 0; var9 = var10) {
               var10 = (class_636)var1.get(var8);
               if(!this.method_3542(var10.tag) || var10.amZ.length == 0) {
                  var10 = var9;
               }

               --var8;
            }

            if(var9 == null) {
               return null;
            }

            return this.amV.cast(this.method_3544(class_605.method_3550(var9.amZ)));
         }

         ArrayList var3 = new ArrayList();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            class_636 var7 = (class_636)var1.get(var4);
            if(this.method_3542(var7.tag) && var7.amZ.length != 0) {
               this.method_3541(var7, var3);
            }
         }

         int var5 = var3.size();
         if(var5 == 0) {
            return null;
         }

         for(var6 = this.amV.cast(Array.newInstance(this.amV.getComponentType(), var5)); var2 < var5; ++var2) {
            Array.set(var6, var2, var3.get(var2));
         }
      }

      return var6;
   }

   // $FF: renamed from: u (com.google.android.gms.internal.lz) java.lang.Object
   protected Object method_3544(class_605 var1) {
      Class var2;
      if(this.amW) {
         var2 = this.amV.getComponentType();
      } else {
         var2 = this.amV;
      }

      try {
         switch(this.type) {
         case 10:
            class_246 var7 = (class_246)var2.newInstance();
            var1.method_3552(var7, class_638.method_3658(this.tag));
            return var7;
         case 11:
            class_246 var6 = (class_246)var2.newInstance();
            var1.method_3551(var6);
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
