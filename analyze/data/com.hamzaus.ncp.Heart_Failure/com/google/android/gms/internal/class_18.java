package com.google.android.gms.internal;

import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_601;
import com.google.android.gms.internal.class_602;
import com.google.android.gms.internal.class_605;
import com.google.android.gms.internal.class_638;
import com.google.android.gms.internal.mb;
import java.io.IOException;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.iw
public interface class_18 {
   public static final class class_1087 extends mb<class_18.class_1087> {
      // $FF: renamed from: Uv com.google.android.gms.internal.iw$a$a[]
      public class_18.class_1088[] field_820;

      public class_1087() {
         this.method_1739();
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(this.field_820 != null && this.field_820.length > 0) {
            for(int var2 = 0; var2 < this.field_820.length; ++var2) {
               class_18.class_1088 var3 = this.field_820[var2];
               if(var3 != null) {
                  var1.method_3515(1, var3);
               }
            }
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1740(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(this.field_820 != null && this.field_820.length > 0) {
            for(int var2 = 0; var2 < this.field_820.length; ++var2) {
               class_18.class_1088 var3 = this.field_820[var2];
               if(var3 != null) {
                  var1 += class_601.method_3488(1, var3);
               }
            }
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_18.class_1087;
            var3 = false;
            if(var2) {
               class_18.class_1087 var4 = (class_18.class_1087)var1;
               boolean var5 = class_602.equals((Object[])this.field_820, (Object[])var4.field_820);
               var3 = false;
               if(var5) {
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
         int var1 = 31 * (527 + class_602.hashCode((Object[])this.field_820));
         int var2;
         if(this.amU != null && !this.amU.isEmpty()) {
            var2 = this.amU.hashCode();
         } else {
            var2 = 0;
         }

         return var2 + var1;
      }

      // $FF: renamed from: iL () com.google.android.gms.internal.iw$a
      public class_18.class_1087 method_1739() {
         this.field_820 = class_18.class_1088.method_1741();
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: n (com.google.android.gms.internal.lz) com.google.android.gms.internal.iw$a
      public class_18.class_1087 method_1740(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            int var4;
            class_18.class_1088[] var5;
            switch(var2) {
            case 10:
               int var3 = class_638.method_3656(var1, 10);
               if(this.field_820 == null) {
                  var4 = 0;
               } else {
                  var4 = this.field_820.length;
               }

               var5 = new class_18.class_1088[var3 + var4];
               if(var4 != 0) {
                  System.arraycopy(this.field_820, 0, var5, 0, var4);
               }
               break;
            default:
               if(this.a(var1, var2)) {
                  continue;
               }
            case 0:
               return this;
            }

            while(var4 < -1 + var5.length) {
               var5[var4] = new class_18.class_1088();
               var1.method_3551(var5[var4]);
               var1.method_3570();
               ++var4;
            }

            var5[var4] = new class_18.class_1088();
            var1.method_3551(var5[var4]);
            this.field_820 = var5;
         }
      }
   }

   public static final class class_1088 extends mb<class_18.class_1088> {
      // $FF: renamed from: Uw com.google.android.gms.internal.iw$a$a[]
      private static volatile class_18.class_1088[] field_821;
      // $FF: renamed from: Ux java.lang.String
      public String field_822;
      // $FF: renamed from: Uy java.lang.String
      public String field_823;
      public int viewId;

      public class_1088() {
         this.method_1742();
      }

      // $FF: renamed from: iM () com.google.android.gms.internal.iw$a$a[]
      public static class_18.class_1088[] method_1741() {
         // $FF: Couldn't be decompiled
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ma) void
      public void method_1721(class_601 var1) throws IOException {
         if(!this.field_822.equals("")) {
            var1.method_3521(1, this.field_822);
         }

         if(!this.field_823.equals("")) {
            var1.method_3521(2, this.field_823);
         }

         if(this.viewId != 0) {
            var1.method_3535(3, this.viewId);
         }

         super.method_1721(var1);
      }

      // $FF: renamed from: b (com.google.android.gms.internal.lz) com.google.android.gms.internal.mf
      // $FF: synthetic method
      public class_246 method_1722(class_605 var1) throws IOException {
         return this.method_1743(var1);
      }

      // $FF: renamed from: c () int
      protected int method_1723() {
         int var1 = super.method_1723();
         if(!this.field_822.equals("")) {
            var1 += class_601.method_3504(1, this.field_822);
         }

         if(!this.field_823.equals("")) {
            var1 += class_601.method_3504(2, this.field_823);
         }

         if(this.viewId != 0) {
            var1 += class_601.method_3506(3, this.viewId);
         }

         return var1;
      }

      public boolean equals(Object var1) {
         boolean var3;
         if(var1 == this) {
            var3 = true;
         } else {
            boolean var2 = var1 instanceof class_18.class_1088;
            var3 = false;
            if(var2) {
               class_18.class_1088 var4 = (class_18.class_1088)var1;
               if(this.field_822 == null) {
                  String var9 = var4.field_822;
                  var3 = false;
                  if(var9 != null) {
                     return var3;
                  }
               } else if(!this.field_822.equals(var4.field_822)) {
                  return false;
               }

               if(this.field_823 == null) {
                  String var8 = var4.field_823;
                  var3 = false;
                  if(var8 != null) {
                     return var3;
                  }
               } else if(!this.field_823.equals(var4.field_823)) {
                  return false;
               }

               int var5 = this.viewId;
               int var6 = var4.viewId;
               var3 = false;
               if(var5 == var6) {
                  if(this.amU != null && !this.amU.isEmpty()) {
                     return this.amU.equals(var4.amU);
                  }

                  if(var4.amU != null) {
                     boolean var7 = var4.amU.isEmpty();
                     var3 = false;
                     if(!var7) {
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
         int var1;
         if(this.field_822 == null) {
            var1 = 0;
         } else {
            var1 = this.field_822.hashCode();
         }

         int var2 = 31 * (var1 + 527);
         int var3;
         if(this.field_823 == null) {
            var3 = 0;
         } else {
            var3 = this.field_823.hashCode();
         }

         int var4 = 31 * (31 * (var3 + var2) + this.viewId);
         List var5 = this.amU;
         int var6 = 0;
         if(var5 != null) {
            boolean var7 = this.amU.isEmpty();
            var6 = 0;
            if(!var7) {
               var6 = this.amU.hashCode();
            }
         }

         return var4 + var6;
      }

      // $FF: renamed from: iN () com.google.android.gms.internal.iw$a$a
      public class_18.class_1088 method_1742() {
         this.field_822 = "";
         this.field_823 = "";
         this.viewId = 0;
         this.amU = null;
         this.amY = -1;
         return this;
      }

      // $FF: renamed from: o (com.google.android.gms.internal.lz) com.google.android.gms.internal.iw$a$a
      public class_18.class_1088 method_1743(class_605 var1) throws IOException {
         while(true) {
            int var2 = var1.method_3570();
            switch(var2) {
            case 10:
               this.field_822 = var1.readString();
               break;
            case 18:
               this.field_823 = var1.readString();
               break;
            case 24:
               this.viewId = var1.method_3573();
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
