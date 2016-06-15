package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.internal.af;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_637;
import com.google.android.gms.internal.mb;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.android.gms.drive.internal.af
public final class class_248 extends mb<af> {
   // $FF: renamed from: Jq java.lang.String
   public String field_816;
   // $FF: renamed from: Jr long
   public long field_817;
   // $FF: renamed from: Js long
   public long field_818;
   public int versionCode;

   public class_248() {
      this.method_1729();
   }

   // $FF: renamed from: g (byte[]) com.google.android.gms.drive.internal.af
   public static class_248 method_1728(byte[] var0) throws class_637 {
      return (class_248)class_246.method_1717(new class_248(), var0);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ma) void
   public void method_1721(class_601 var1) throws IOException {
      var1.method_3535(1, this.versionCode);
      var1.method_3521(2, this.field_816);
      var1.method_3523(3, this.field_817);
      var1.method_3523(4, this.field_818);
      super.method_1721(var1);
   }

   // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
   // $FF: synthetic method
   public class_246 method_1722(class_605 var1) throws IOException {
      return this.method_1730(var1);
   }

   // $FF: renamed from: c () int
   protected int method_1723() {
      return super.method_1723() + class_601.method_3506(1, this.versionCode) + class_601.method_3504(2, this.field_816) + class_601.method_3497(3, this.field_817) + class_601.method_3497(4, this.field_818);
   }

   public boolean equals(Object var1) {
      boolean var3;
      if(var1 == this) {
         var3 = true;
      } else {
         boolean var2 = var1 instanceof class_248;
         var3 = false;
         if(var2) {
            class_248 var4 = (class_248)var1;
            int var5 = this.versionCode;
            int var6 = var4.versionCode;
            var3 = false;
            if(var5 == var6) {
               if(this.field_816 == null) {
                  String var10 = var4.field_816;
                  var3 = false;
                  if(var10 != null) {
                     return var3;
                  }
               } else if(!this.field_816.equals(var4.field_816)) {
                  return false;
               }

               long var11;
               int var7 = (var11 = this.field_817 - var4.field_817) == 0L?0:(var11 < 0L?-1:1);
               var3 = false;
               if(var7 == 0) {
                  long var12;
                  int var8 = (var12 = this.field_818 - var4.field_818) == 0L?0:(var12 < 0L?-1:1);
                  var3 = false;
                  if(var8 == 0) {
                     if(this.amU != null && !this.amU.isEmpty()) {
                        return this.amU.equals(var4.amU);
                     }

                     if(var4.amU != null) {
                        boolean var9 = var4.amU.isEmpty();
                        var3 = false;
                        if(!var9) {
                           return var3;
                        }
                     }

                     return true;
                  }
               }
            }
         }
      }

      return var3;
   }

   // $FF: renamed from: gn () com.google.android.gms.drive.internal.af
   public class_248 method_1729() {
      this.versionCode = 1;
      this.field_816 = "";
      this.field_817 = -1L;
      this.field_818 = -1L;
      this.amU = null;
      this.amY = -1;
      return this;
   }

   public int hashCode() {
      int var1 = 31 * (527 + this.versionCode);
      int var2;
      if(this.field_816 == null) {
         var2 = 0;
      } else {
         var2 = this.field_816.hashCode();
      }

      int var3 = 31 * (31 * (31 * (var2 + var1) + (int)(this.field_817 ^ this.field_817 >>> 32)) + (int)(this.field_818 ^ this.field_818 >>> 32));
      List var4 = this.amU;
      int var5 = 0;
      if(var4 != null) {
         boolean var6 = this.amU.isEmpty();
         var5 = 0;
         if(!var6) {
            var5 = this.amU.hashCode();
         }
      }

      return var3 + var5;
   }

   // $FF: renamed from: m (com.google.android.gms.internal.lz) com.google.android.gms.drive.internal.af
   public class_248 method_1730(class_605 var1) throws IOException {
      while(true) {
         int var2 = var1.method_3570();
         switch(var2) {
         case 8:
            this.versionCode = var1.method_3573();
            break;
         case 18:
            this.field_816 = var1.readString();
            break;
         case 24:
            this.field_817 = var1.method_3562();
            break;
         case 32:
            this.field_818 = var1.method_3562();
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
