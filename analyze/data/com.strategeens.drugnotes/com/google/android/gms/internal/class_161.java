package com.google.android.gms.internal;

import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_55;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.qq;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.internal.pu
public interface class_161 {
   public static final class class_1310 extends qq<class_161.class_1310> {
      public long auB;
      public class_55.class_1260 auC;
      // $FF: renamed from: gs com.google.android.gms.internal.c$f
      public class_55.class_1269 field_666;

      public class_1310() {
         this.method_2134();
      }

      // $FF: renamed from: l (byte[]) com.google.android.gms.internal.pu$a
      public static class_161.class_1310 method_2133(byte[] var0) throws class_833 {
         return (class_161.class_1310)class_300.method_2085(new class_161.class_1310(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.qp) void
      public void method_2089(class_826 var1) throws IOException {
         var1.method_4536(1, this.auB);
         if(this.field_666 != null) {
            var1.method_4532(2, this.field_666);
         }

         if(this.auC != null) {
            var1.method_4532(3, this.auC);
         }

         super.method_2089(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
      // $FF: synthetic method
      public class_300 method_2090(class_827 var1) throws IOException {
         return this.method_2135(var1);
      }

      // $FF: renamed from: c () int
      protected int method_2091() {
         int var1 = super.method_2091() + class_826.method_4509(1, this.auB);
         if(this.field_666 != null) {
            var1 += class_826.method_4507(2, this.field_666);
         }

         if(this.auC != null) {
            var1 += class_826.method_4507(3, this.auC);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_161.class_1310;
            var3 = false;
            if(var2) {
               class_161.class_1310 var4 = (class_161.class_1310)var1;
               long var8;
               int var5 = (var8 = this.auB - var4.auB) == 0L?0:(var8 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  if(this.field_666 == null) {
                     class_55.class_1269 var7 = var4.field_666;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.field_666.equals(var4.field_666)) {
                     return false;
                  }

                  if(this.auC == null) {
                     class_55.class_1260 var6 = var4.auC;
                     var3 = false;
                     if(var6 != null) {
                        return var3;
                     }
                  } else if(!this.auC.equals(var4.auC)) {
                     return false;
                  }

                  return this.a(var4);
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + (int)(this.auB ^ this.auB >>> 32));
         int var2;
         if(this.field_666 == null) {
            var2 = 0;
         } else {
            var2 = this.field_666.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         class_55.class_1260 var4 = this.auC;
         int var5 = 0;
         if(var4 != null) {
            var5 = this.auC.hashCode();
         }

         return 31 * (var3 + var5) + this.rQ();
      }

      // $FF: renamed from: rc () com.google.android.gms.internal.pu$a
      public class_161.class_1310 method_2134() {
         this.auB = 0L;
         this.field_666 = null;
         this.auC = null;
         this.ayW = null;
         this.azh = -1;
         return this;
      }

      // $FF: renamed from: s (com.google.android.gms.internal.qo) com.google.android.gms.internal.pu$a
      public class_161.class_1310 method_2135(class_827 var1) throws IOException {
         while(true) {
            int var2 = var1.method_4585();
            switch(var2) {
            case 8:
               this.auB = var1.method_4573();
               break;
            case 18:
               if(this.field_666 == null) {
                  this.field_666 = new class_55.class_1269();
               }

               var1.method_4563(this.field_666);
               break;
            case 26:
               if(this.auC == null) {
                  this.auC = new class_55.class_1260();
               }

               var1.method_4563(this.auC);
               break;
            default:
               if(this.a(var1, var2)) {
                  break;
               }
            case 0:
               return this;
            }
         }
      }
   }
}
