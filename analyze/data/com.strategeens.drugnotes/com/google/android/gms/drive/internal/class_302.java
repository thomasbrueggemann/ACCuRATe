package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.internal.ak;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_826;
import com.google.android.gms.internal.class_827;
import com.google.android.gms.internal.class_833;
import com.google.android.gms.internal.qq;
import java.io.IOException;

// $FF: renamed from: com.google.android.gms.drive.internal.ak
public final class class_302 extends qq<ak> {
   // $FF: renamed from: QG java.lang.String
   public String field_661;
   // $FF: renamed from: QH long
   public long field_662;
   // $FF: renamed from: QI long
   public long field_663;
   public int versionCode;

   public class_302() {
      this.method_2101();
   }

   // $FF: renamed from: g (byte[]) com.google.android.gms.drive.internal.ak
   public static class_302 method_2100(byte[] var0) throws class_833 {
      return (class_302)class_300.method_2085(new class_302(), var0);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.qp) void
   public void method_2089(class_826 var1) throws IOException {
      var1.method_4554(1, this.versionCode);
      var1.method_4537(2, this.field_661);
      var1.method_4540(3, this.field_662);
      var1.method_4540(4, this.field_663);
      super.method_2089(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.qo) com.google.android.gms.internal.qw
   // $FF: synthetic method
   public class_300 method_2090(class_827 var1) throws IOException {
      return this.method_2102(var1);
   }

   // $FF: renamed from: c () int
   protected int method_2091() {
      return super.method_2091() + class_826.method_4524(1, this.versionCode) + class_826.method_4521(2, this.field_661) + class_826.method_4513(3, this.field_662) + class_826.method_4513(4, this.field_663);
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof class_302;
         var3 = false;
         if(var2) {
            class_302 var4 = (class_302)var1;
            int var5 = this.versionCode;
            int var6 = var4.versionCode;
            var3 = false;
            if(var5 == var6) {
               if(this.field_661 == null) {
                  String var9 = var4.field_661;
                  var3 = false;
                  if(var9 != null) {
                     return var3;
                  }
               } else if(!this.field_661.equals(var4.field_661)) {
                  return false;
               }

               long var10;
               int var7 = (var10 = this.field_662 - var4.field_662) == 0L?0:(var10 < 0L?-1:1);
               var3 = false;
               if(var7 == 0) {
                  long var11;
                  int var8 = (var11 = this.field_663 - var4.field_663) == 0L?0:(var11 < 0L?-1:1);
                  var3 = false;
                  if(var8 == 0) {
                     return this.a(var4);
                  }
               }
            }
         }
      }

      return var3;
   }

   public int hashCode() {
      int var1 = 31 * (527 + this.versionCode);
      int var2;
      if(this.field_661 == null) {
         var2 = 0;
      } else {
         var2 = this.field_661.hashCode();
      }

      return 31 * (31 * (31 * (var2 + var1) + (int)(this.field_662 ^ this.field_662 >>> 32)) + (int)(this.field_663 ^ this.field_663 >>> 32)) + this.rQ();
   }

   // $FF: renamed from: iK () com.google.android.gms.drive.internal.ak
   public class_302 method_2101() {
      this.versionCode = 1;
      this.field_661 = "";
      this.field_662 = -1L;
      this.field_663 = -1L;
      this.ayW = null;
      this.azh = -1;
      return this;
   }

   // $FF: renamed from: m (com.google.android.gms.internal.qo) com.google.android.gms.drive.internal.ak
   public class_302 method_2102(class_827 var1) throws IOException {
      while(true) {
         int var2 = var1.method_4585();
         switch(var2) {
         case 8:
            this.versionCode = var1.method_4574();
            break;
         case 18:
            this.field_661 = var1.readString();
            break;
         case 24:
            this.field_662 = var1.method_4577();
            break;
         case 32:
            this.field_663 = var1.method_4577();
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
