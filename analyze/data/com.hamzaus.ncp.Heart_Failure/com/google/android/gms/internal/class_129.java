package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_51;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.mb;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.lf
public interface class_129 {
   public static final class class_1078 extends mb<class_129.class_1078> {
      public long aiD;
      public class_51.class_961 aiE;
      // $FF: renamed from: fK com.google.android.gms.internal.c$f
      public class_51.class_965 field_819;

      public class_1078() {
         this.method_1732();
      }

      // $FF: renamed from: l (byte[]) com.google.android.gms.internal.lf$a
      public static class_129.class_1078 method_1731(byte[] var0) throws class_637 {
         return (class_129.class_1078)class_246.method_1717(new class_129.class_1078(), var0);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         var1.method_3520(1, this.aiD);
         if(this.field_819 != null) {
            var1.method_3515(2, this.field_819);
         }

         if(this.aiE != null) {
            var1.method_3515(3, this.aiE);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1733(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723() + class_601.method_3495(1, this.aiD);
         if(this.field_819 != null) {
            var1 += class_601.method_3488(2, this.field_819);
         }

         if(this.aiE != null) {
            var1 += class_601.method_3488(3, this.aiE);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_129.class_1078;
            var3 = false;
            if(var2) {
               class_129.class_1078 var4 = (class_129.class_1078)var1;
               long var9;
               int var5 = (var9 = this.aiD - var4.aiD) == 0L?0:(var9 < 0L?-1:1);
               var3 = false;
               if(var5 == 0) {
                  if(this.field_819 == null) {
                     class_51.class_965 var8 = var4.field_819;
                     var3 = false;
                     if(var8 != null) {
                        return var3;
                     }
                  } else if(!this.field_819.equals(var4.field_819)) {
                     return false;
                  }

                  if(this.aiE == null) {
                     class_51.class_961 var7 = var4.aiE;
                     var3 = false;
                     if(var7 != null) {
                        return var3;
                     }
                  } else if(!this.aiE.equals(var4.aiE)) {
                     return false;
                  }

                  if(this.amU != null && !this.amU.isEmpty()) {
                     return this.amU.equals(var4.amU);
                  }

                  if(var4.amU != null) {
                     boolean var6 = var4.amU.isEmpty();
                     var3 = false;
                     if(!var6) {
                        return var3;
                     }
                  }

                  return true;
               }
            }
         }

         return var3;
      }

      public int hashCode() {
         int var1 = 31 * (527 + (int)(this.aiD ^ this.aiD >>> 32));
         int var2;
         if(this.field_819 == null) {
            var2 = 0;
         } else {
            var2 = this.field_819.hashCode();
         }

         int var3 = 31 * (var2 + var1);
         int var4;
         if(this.aiE == null) {
            var4 = 0;
         } else {
            var4 = this.aiE.hashCode();
         }

         int var5 = 31 * (var4 + var3);
         List var6 = this.amU;
         int var7 = 0;
         if(var6 != null) {
            boolean var8 = this.amU.isEmpty();
            var7 = 0;
            if(!var8) {
               var7 = this.amU.hashCode();
            }
         }

         return var5 + var7;
      }

      // $FF: renamed from: na () com.google.android.gms.internal.lf$a
      public class_129.class_1078 method_1732() {
         this.aiD = 0L;
         this.field_819 = null;
         this.aiE = null;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: p (com.google.android.gms.internal.lz) com.google.android.gms.internal.lf$a
      public class_129.class_1078 method_1733(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 8:
               this.aiD = var1.method_3572();
               break;
            case 18:
               if(this.field_819 == null) {
                  this.field_819 = new class_51.class_965();
               }

               var1.method_3551(this.field_819);
               break;
            case 26:
               if(this.aiE == null) {
                  this.aiE = new class_51.class_961();
               }

               var1.method_3551(this.aiE);
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
