package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_280;
import com.google.android.gms.internal.class_281;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_294;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_346;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.if;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.hz
public abstract class class_285 {
   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, java.lang.Object) void
   private void method_1877(StringBuilder var1, class_285.class_944 var2, Object var3) {
      if(var2.method_3224() == 11) {
         var1.append(((class_285)var2.method_3219().cast(var3)).toString());
      } else if(var2.method_3224() == 7) {
         var1.append("\"");
         var1.append(class_281.method_1867((String)var3));
         var1.append("\"");
      } else {
         var1.append(var3);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, java.util.ArrayList) void
   private void method_1878(StringBuilder var1, class_285.class_944 var2, ArrayList<Object> var3) {
      var1.append("[");
      int var5 = 0;

      for(int var6 = var3.size(); var5 < var6; ++var5) {
         if(var5 > 0) {
            var1.append(",");
         }

         Object var8 = var3.get(var5);
         if(var8 != null) {
            this.method_1877(var1, var2, var8);
         }
      }

      var1.append("]");
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz$a, java.lang.Object) java.lang.Object
   protected <O, I> I method_1879(class_285.class_944<I, O> var1, Object var2) {
      if(var1.field_3034 != null) {
         var2 = var1.method_3225(var2);
      }

      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz$a) boolean
   protected boolean method_1880(class_285.class_944 var1) {
      return var1.method_3213() == 11?(var1.method_3216()?this.method_1884(var1.method_3217()):this.method_1883(var1.method_3217())):this.method_1882(var1.method_3217());
   }

   // $FF: renamed from: aF (java.lang.String) java.lang.Object
   protected abstract Object method_1881(String var1);

   // $FF: renamed from: aG (java.lang.String) boolean
   protected abstract boolean method_1882(String var1);

   // $FF: renamed from: aH (java.lang.String) boolean
   protected boolean method_1883(String var1) {
      throw new UnsupportedOperationException("Concrete types not supported");
   }

   // $FF: renamed from: aI (java.lang.String) boolean
   protected boolean method_1884(String var1) {
      throw new UnsupportedOperationException("Concrete type arrays not supported");
   }

   // $FF: renamed from: b (com.google.android.gms.internal.hz$a) java.lang.Object
   protected Object method_1885(class_285.class_944 var1) {
      String var2 = var1.method_3217();
      if(var1.method_3219() != null) {
         boolean var3;
         if(this.method_1881(var1.method_3217()) == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{var1.method_3217()};
         class_347.method_2162(var3, "Concrete field shouldn\'t be value object: %s", var4);
         HashMap var5;
         if(var1.method_3216()) {
            var5 = this.method_1888();
         } else {
            var5 = this.method_1887();
         }

         if(var5 != null) {
            return var5.get(var2);
         } else {
            try {
               String var7 = "get" + Character.toUpperCase(var2.charAt(0)) + var2.substring(1);
               Object var8 = this.getClass().getMethod(var7, new Class[0]).invoke(this, new Object[0]);
               return var8;
            } catch (Exception var9) {
               throw new RuntimeException(var9);
            }
         }
      } else {
         return this.method_1881(var1.method_3217());
      }
   }

   // $FF: renamed from: fB () java.util.HashMap
   public abstract HashMap<String, class_285.class_944<?, ?>> method_1886();

   // $FF: renamed from: fC () java.util.HashMap
   public HashMap<String, Object> method_1887() {
      return null;
   }

   // $FF: renamed from: fD () java.util.HashMap
   public HashMap<String, Object> method_1888() {
      return null;
   }

   public String toString() {
      HashMap var1 = this.method_1886();
      StringBuilder var2 = new StringBuilder(100);
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var6 = (String)var3.next();
         class_285.class_944 var7 = (class_285.class_944)var1.get(var6);
         if(this.method_1880(var7)) {
            Object var8 = this.method_1879(var7, this.method_1885(var7));
            if(var2.length() == 0) {
               var2.append("{");
            } else {
               var2.append(",");
            }

            var2.append("\"").append(var6).append("\":");
            if(var8 == null) {
               var2.append("null");
            } else {
               switch(var7.method_3213()) {
               case 8:
                  var2.append("\"").append(class_283.method_1873((byte[])((byte[])var8))).append("\"");
                  break;
               case 9:
                  var2.append("\"").append(class_283.method_1874((byte[])((byte[])var8))).append("\"");
                  break;
               case 10:
                  class_280.method_1859(var2, (HashMap)var8);
                  break;
               default:
                  if(var7.method_3215()) {
                     this.method_1878(var2, var7, (ArrayList)var8);
                  } else {
                     this.method_1877(var2, var7, var8);
                  }
               }
            }
         }
      }

      if(var2.length() > 0) {
         var2.append("}");
      } else {
         var2.append("{}");
      }

      return var2.toString();
   }

   public static class class_944<I, O> implements SafeParcelable {
      public static final class_294 CREATOR = new class_294();
      // $FF: renamed from: GY int
      protected final int field_3025;
      // $FF: renamed from: GZ boolean
      protected final boolean field_3026;
      // $FF: renamed from: Ha int
      protected final int field_3027;
      // $FF: renamed from: Hb boolean
      protected final boolean field_3028;
      // $FF: renamed from: Hc java.lang.String
      protected final String field_3029;
      // $FF: renamed from: Hd int
      protected final int field_3030;
      // $FF: renamed from: He java.lang.Class
      protected final Class<? extends hz> field_3031;
      // $FF: renamed from: Hf java.lang.String
      protected final String field_3032;
      // $FF: renamed from: Hg com.google.android.gms.internal.ic
      private class_296 field_3033;
      // $FF: renamed from: Hh com.google.android.gms.internal.hz$b
      private class_285.class_945<I, O> field_3034;
      // $FF: renamed from: xJ int
      private final int field_3035;

      class_944(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, class_346 var9) {
         this.field_3035 = var1;
         this.field_3025 = var2;
         this.field_3026 = var3;
         this.field_3027 = var4;
         this.field_3028 = var5;
         this.field_3029 = var6;
         this.field_3030 = var7;
         if(var8 == null) {
            this.field_3031 = null;
            this.field_3032 = null;
         } else {
            this.field_3031 = if.class;
            this.field_3032 = var8;
         }

         if(var9 == null) {
            this.field_3034 = null;
         } else {
            this.field_3034 = var9.method_2158();
         }
      }

      protected class_944(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class<? extends hz> var7, class_285.class_945<I, O> var8) {
         this.field_3035 = 1;
         this.field_3025 = var1;
         this.field_3026 = var2;
         this.field_3027 = var3;
         this.field_3028 = var4;
         this.field_3029 = var5;
         this.field_3030 = var6;
         this.field_3031 = var7;
         if(var7 == null) {
            this.field_3032 = null;
         } else {
            this.field_3032 = var7.getCanonicalName();
         }

         this.field_3034 = var8;
      }

      // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.internal.hz$b, boolean) com.google.android.gms.internal.hz$a
      public static class_285.class_944 method_3203(String var0, int var1, class_285.class_945<?, ?> var2, boolean var3) {
         return new class_285.class_944(var2.method_403(), var3, var2.method_402(), false, var0, var1, (Class)null, var2);
      }

      // $FF: renamed from: a (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.hz$a
      public static <T extends hz> class_285.class_944<T, T> method_3204(String var0, int var1, Class<T> var2) {
         return new class_285.class_944(11, false, 11, false, var0, var1, var2, (class_285.class_945)null);
      }

      // $FF: renamed from: b (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.hz$a
      public static <T extends hz> class_285.class_944<ArrayList<T>, ArrayList<T>> method_3205(String var0, int var1, Class<T> var2) {
         return new class_285.class_944(11, true, 11, true, var0, var1, var2, (class_285.class_945)null);
      }

      // $FF: renamed from: g (java.lang.String, int) com.google.android.gms.internal.hz$a
      public static class_285.class_944<Integer, Integer> method_3207(String var0, int var1) {
         return new class_285.class_944(0, false, 0, false, var0, var1, (Class)null, (class_285.class_945)null);
      }

      // $FF: renamed from: h (java.lang.String, int) com.google.android.gms.internal.hz$a
      public static class_285.class_944<Double, Double> method_3208(String var0, int var1) {
         return new class_285.class_944(4, false, 4, false, var0, var1, (Class)null, (class_285.class_945)null);
      }

      // $FF: renamed from: i (java.lang.String, int) com.google.android.gms.internal.hz$a
      public static class_285.class_944<Boolean, Boolean> method_3209(String var0, int var1) {
         return new class_285.class_944(6, false, 6, false, var0, var1, (Class)null, (class_285.class_945)null);
      }

      // $FF: renamed from: j (java.lang.String, int) com.google.android.gms.internal.hz$a
      public static class_285.class_944<String, String> method_3210(String var0, int var1) {
         return new class_285.class_944(7, false, 7, false, var0, var1, (Class)null, (class_285.class_945)null);
      }

      // $FF: renamed from: k (java.lang.String, int) com.google.android.gms.internal.hz$a
      public static class_285.class_944<ArrayList<String>, ArrayList<String>> method_3211(String var0, int var1) {
         return new class_285.class_944(7, true, 7, true, var0, var1, (Class)null, (class_285.class_945)null);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.ic) void
      public void method_3212(class_296 var1) {
         this.field_3033 = var1;
      }

      public int describeContents() {
         class_294 var10000 = CREATOR;
         return 0;
      }

      // $FF: renamed from: fA () int
      public int method_3213() {
         return this.field_3027;
      }

      // $FF: renamed from: fE () com.google.android.gms.internal.hz$a
      public class_285.class_944<I, O> method_3214() {
         return new class_285.class_944(this.field_3035, this.field_3025, this.field_3026, this.field_3027, this.field_3028, this.field_3029, this.field_3030, this.field_3032, this.method_3222());
      }

      // $FF: renamed from: fF () boolean
      public boolean method_3215() {
         return this.field_3026;
      }

      // $FF: renamed from: fG () boolean
      public boolean method_3216() {
         return this.field_3028;
      }

      // $FF: renamed from: fH () java.lang.String
      public String method_3217() {
         return this.field_3029;
      }

      // $FF: renamed from: fI () int
      public int method_3218() {
         return this.field_3030;
      }

      // $FF: renamed from: fJ () java.lang.Class
      public Class<? extends hz> method_3219() {
         return this.field_3031;
      }

      // $FF: renamed from: fK () java.lang.String
      String method_3220() {
         return this.field_3032 == null?null:this.field_3032;
      }

      // $FF: renamed from: fL () boolean
      public boolean method_3221() {
         return this.field_3034 != null;
      }

      // $FF: renamed from: fM () com.google.android.gms.internal.hu
      class_346 method_3222() {
         return this.field_3034 == null?null:class_346.method_2156(this.field_3034);
      }

      // $FF: renamed from: fN () java.util.HashMap
      public HashMap<String, class_285.class_944<?, ?>> method_3223() {
         class_347.method_2170(this.field_3032);
         class_347.method_2170(this.field_3033);
         return this.field_3033.method_1981(this.field_3032);
      }

      // $FF: renamed from: fz () int
      public int method_3224() {
         return this.field_3025;
      }

      // $FF: renamed from: g (java.lang.Object) java.lang.Object
      public I method_3225(O var1) {
         return this.field_3034.method_404(var1);
      }

      public int getVersionCode() {
         return this.field_3035;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Field\n");
         var1.append("            versionCode=").append(this.field_3035).append('\n');
         var1.append("                 typeIn=").append(this.field_3025).append('\n');
         var1.append("            typeInArray=").append(this.field_3026).append('\n');
         var1.append("                typeOut=").append(this.field_3027).append('\n');
         var1.append("           typeOutArray=").append(this.field_3028).append('\n');
         var1.append("        outputFieldName=").append(this.field_3029).append('\n');
         var1.append("      safeParcelFieldId=").append(this.field_3030).append('\n');
         var1.append("       concreteTypeName=").append(this.method_3220()).append('\n');
         if(this.method_3219() != null) {
            var1.append("     concreteType.class=").append(this.method_3219().getCanonicalName()).append('\n');
         }

         StringBuilder var11 = var1.append("          converterName=");
         String var12;
         if(this.field_3034 == null) {
            var12 = "null";
         } else {
            var12 = this.field_3034.getClass().getCanonicalName();
         }

         var11.append(var12).append('\n');
         return var1.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_294 var10000 = CREATOR;
         class_294.method_1973(this, var1, var2);
      }
   }

   public interface class_945<I, O> {
      // $FF: renamed from: fA () int
      int method_402();

      // $FF: renamed from: fz () int
      int method_403();

      // $FF: renamed from: g (java.lang.Object) java.lang.Object
      I method_404(O var1);
   }
}
