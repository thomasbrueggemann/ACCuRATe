package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_280;
import com.google.android.gms.internal.class_281;
import com.google.android.gms.internal.class_283;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_291;
import com.google.android.gms.internal.class_292;
import com.google.android.gms.internal.class_296;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hz;
import com.google.android.gms.internal.if;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

// $FF: renamed from: com.google.android.gms.internal.if
public class class_289 extends class_285 implements SafeParcelable {
   public static final class_292 CREATOR = new class_292();
   // $FF: renamed from: Hg com.google.android.gms.internal.ic
   private final class_296 field_994;
   // $FF: renamed from: Hn android.os.Parcel
   private final Parcel field_995;
   // $FF: renamed from: Ho int
   private final int field_996;
   // $FF: renamed from: Hp int
   private int field_997;
   // $FF: renamed from: Hq int
   private int field_998;
   private final String mClassName;
   // $FF: renamed from: xJ int
   private final int field_999;

   class_289(int var1, Parcel var2, class_296 var3) {
      this.field_999 = var1;
      this.field_995 = (Parcel)class_347.method_2170(var2);
      this.field_996 = 2;
      this.field_994 = var3;
      if(this.field_994 == null) {
         this.mClassName = null;
      } else {
         this.mClassName = this.field_994.method_1986();
      }

      this.field_997 = 2;
   }

   private class_289(SafeParcelable var1, class_296 var2, String var3) {
      this.field_999 = 1;
      this.field_995 = Parcel.obtain();
      var1.writeToParcel(this.field_995, 0);
      this.field_996 = 1;
      this.field_994 = (class_296)class_347.method_2170(var2);
      this.mClassName = (String)class_347.method_2170(var3);
      this.field_997 = 2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.hz) com.google.android.gms.internal.if
   public static <T extends hz & SafeParcelable> if method_1941(T var0) {
      String var1 = var0.getClass().getCanonicalName();
      class_296 var2 = method_1947(var0);
      return new class_289((SafeParcelable)var0, var2, var1);
   }

   // $FF: renamed from: a (com.google.android.gms.internal.ic, com.google.android.gms.internal.hz) void
   private static void method_1942(class_296 var0, class_285 var1) {
      Class var2 = var1.getClass();
      if(!var0.method_1982(var2)) {
         HashMap var3 = var1.method_1886();
         var0.method_1980(var2, var1.method_1886());
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            class_285.class_944 var5 = (class_285.class_944)var3.get((String)var4.next());
            Class var6 = var5.method_3219();
            if(var6 != null) {
               try {
                  method_1942(var0, (class_285)var6.newInstance());
               } catch (InstantiationException var9) {
                  throw new IllegalStateException("Could not instantiate an object of type " + var5.method_3219().getCanonicalName(), var9);
               } catch (IllegalAccessException var10) {
                  throw new IllegalStateException("Could not access object of type " + var5.method_3219().getCanonicalName(), var10);
               }
            }
         }
      }

   }

   // $FF: renamed from: a (java.lang.StringBuilder, int, java.lang.Object) void
   private void method_1943(StringBuilder var1, int var2, Object var3) {
      switch(var2) {
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
         var1.append(var3);
         return;
      case 7:
         var1.append("\"").append(class_281.method_1867(var3.toString())).append("\"");
         return;
      case 8:
         var1.append("\"").append(class_283.method_1873((byte[])((byte[])var3))).append("\"");
         return;
      case 9:
         var1.append("\"").append(class_283.method_1874((byte[])((byte[])var3)));
         var1.append("\"");
         return;
      case 10:
         class_280.method_1859(var1, (HashMap)var3);
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown type = " + var2);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, android.os.Parcel, int) void
   private void method_1944(StringBuilder var1, class_285.class_944<?, ?> var2, Parcel var3, int var4) {
      switch(var2.method_3213()) {
      case 0:
         this.method_1950(var1, var2, this.a(var2, Integer.valueOf(class_600.method_3402(var3, var4))));
         return;
      case 1:
         this.method_1950(var1, var2, this.a(var2, class_600.method_3406(var3, var4)));
         return;
      case 2:
         this.method_1950(var1, var2, this.a(var2, Long.valueOf(class_600.method_3404(var3, var4))));
         return;
      case 3:
         this.method_1950(var1, var2, this.a(var2, Float.valueOf(class_600.method_3407(var3, var4))));
         return;
      case 4:
         this.method_1950(var1, var2, this.a(var2, Double.valueOf(class_600.method_3408(var3, var4))));
         return;
      case 5:
         this.method_1950(var1, var2, this.a(var2, class_600.method_3409(var3, var4)));
         return;
      case 6:
         this.method_1950(var1, var2, this.a(var2, Boolean.valueOf(class_600.method_3398(var3, var4))));
         return;
      case 7:
         this.method_1950(var1, var2, this.a(var2, class_600.method_3410(var3, var4)));
         return;
      case 8:
      case 9:
         this.method_1950(var1, var2, this.a(var2, class_600.method_3413(var3, var4)));
         return;
      case 10:
         this.method_1950(var1, var2, this.a(var2, method_1952(class_600.method_3412(var3, var4))));
         return;
      case 11:
         throw new IllegalArgumentException("Method does not accept concrete type.");
      default:
         throw new IllegalArgumentException("Unknown field out type = " + var2.method_3213());
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.lang.String, com.google.android.gms.internal.hz$a, android.os.Parcel, int) void
   private void method_1945(StringBuilder var1, String var2, class_285.class_944<?, ?> var3, Parcel var4, int var5) {
      var1.append("\"").append(var2).append("\":");
      if(var3.method_3221()) {
         this.method_1944(var1, var3, var4, var5);
      } else {
         this.method_1949(var1, var3, var4, var5);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, java.util.HashMap, android.os.Parcel) void
   private void method_1946(StringBuilder var1, HashMap<String, class_285.class_944<?, ?>> var2, Parcel var3) {
      HashMap var4 = method_1948(var2);
      var1.append('{');
      int var6 = class_600.method_3385(var3);
      boolean var7 = false;

      while(var3.dataPosition() < var6) {
         int var9 = class_600.method_3383(var3);
         Entry var10 = (Entry)var4.get(Integer.valueOf(class_600.method_3394(var9)));
         if(var10 != null) {
            if(var7) {
               var1.append(",");
            }

            this.method_1945(var1, (String)var10.getKey(), (class_285.class_944)var10.getValue(), var3, var9);
            var7 = true;
         }
      }

      if(var3.dataPosition() != var6) {
         throw new class_600.class_1103("Overread allowed size end=" + var6, var3);
      } else {
         var1.append('}');
      }
   }

   // $FF: renamed from: b (com.google.android.gms.internal.hz) com.google.android.gms.internal.ic
   private static class_296 method_1947(class_285 var0) {
      class_296 var1 = new class_296(var0.getClass());
      method_1942(var1, var0);
      var1.method_1984();
      var1.method_1983();
      return var1;
   }

   // $FF: renamed from: b (java.util.HashMap) java.util.HashMap
   private static HashMap<Integer, Entry<String, class_285.class_944<?, ?>>> method_1948(HashMap<String, class_285.class_944<?, ?>> var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.put(Integer.valueOf(((class_285.class_944)var3.getValue()).method_3218()), var3);
      }

      return var1;
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, android.os.Parcel, int) void
   private void method_1949(StringBuilder var1, class_285.class_944<?, ?> var2, Parcel var3, int var4) {
      if(!var2.method_3216()) {
         switch(var2.method_3213()) {
         case 0:
            var1.append(class_600.method_3402(var3, var4));
            return;
         case 1:
            var1.append(class_600.method_3406(var3, var4));
            return;
         case 2:
            var1.append(class_600.method_3404(var3, var4));
            return;
         case 3:
            var1.append(class_600.method_3407(var3, var4));
            return;
         case 4:
            var1.append(class_600.method_3408(var3, var4));
            return;
         case 5:
            var1.append(class_600.method_3409(var3, var4));
            return;
         case 6:
            var1.append(class_600.method_3398(var3, var4));
            return;
         case 7:
            String var23 = class_600.method_3410(var3, var4);
            var1.append("\"").append(class_281.method_1867(var23)).append("\"");
            return;
         case 8:
            byte[] var21 = class_600.method_3413(var3, var4);
            var1.append("\"").append(class_283.method_1873(var21)).append("\"");
            return;
         case 9:
            byte[] var18 = class_600.method_3413(var3, var4);
            var1.append("\"").append(class_283.method_1874(var18));
            var1.append("\"");
            return;
         case 10:
            Bundle var6 = class_600.method_3412(var3, var4);
            Set var7 = var6.keySet();
            var7.size();
            var1.append("{");
            Iterator var10 = var7.iterator();

            for(boolean var11 = true; var10.hasNext(); var11 = false) {
               String var13 = (String)var10.next();
               if(!var11) {
                  var1.append(",");
               }

               var1.append("\"").append(var13).append("\"");
               var1.append(":");
               var1.append("\"").append(class_281.method_1867(var6.getString(var13))).append("\"");
            }

            var1.append("}");
            return;
         case 11:
            Parcel var5 = class_600.method_3387(var3, var4);
            var5.setDataPosition(0);
            this.method_1946(var1, var2.method_3223(), var5);
            return;
         default:
            throw new IllegalStateException("Unknown field type out");
         }
      } else {
         var1.append("[");
         label56:
         switch(var2.method_3213()) {
         case 0:
            class_291.method_1961(var1, class_600.method_3416(var3, var4));
            break;
         case 1:
            class_291.method_1963(var1, class_600.method_3418(var3, var4));
            break;
         case 2:
            class_291.method_1962(var1, class_600.method_3417(var3, var4));
            break;
         case 3:
            class_291.method_1960(var1, class_600.method_3419(var3, var4));
            break;
         case 4:
            class_291.method_1959(var1, class_600.method_3420(var3, var4));
            break;
         case 5:
            class_291.method_1963(var1, class_600.method_3421(var3, var4));
            break;
         case 6:
            class_291.method_1965(var1, class_600.method_3415(var3, var4));
            break;
         case 7:
            class_291.method_1964(var1, class_600.method_3384(var3, var4));
            break;
         case 8:
         case 9:
         case 10:
            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
         case 11:
            Parcel[] var33 = class_600.method_3388(var3, var4);
            int var34 = var33.length;
            int var35 = 0;

            while(true) {
               if(var35 >= var34) {
                  break label56;
               }

               if(var35 > 0) {
                  var1.append(",");
               }

               var33[var35].setDataPosition(0);
               this.method_1946(var1, var2.method_3223(), var33[var35]);
               ++var35;
            }
         default:
            throw new IllegalStateException("Unknown field type out.");
         }

         var1.append("]");
      }
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, java.lang.Object) void
   private void method_1950(StringBuilder var1, class_285.class_944<?, ?> var2, Object var3) {
      if(var2.method_3215()) {
         this.method_1951(var1, var2, (ArrayList)var3);
      } else {
         this.method_1943(var1, var2.method_3224(), var3);
      }
   }

   // $FF: renamed from: b (java.lang.StringBuilder, com.google.android.gms.internal.hz$a, java.util.ArrayList) void
   private void method_1951(StringBuilder var1, class_285.class_944<?, ?> var2, ArrayList<?> var3) {
      var1.append("[");
      int var5 = var3.size();

      for(int var6 = 0; var6 < var5; ++var6) {
         if(var6 != 0) {
            var1.append(",");
         }

         this.method_1943(var1, var2.method_3224(), var3.get(var6));
      }

      var1.append("]");
   }

   // $FF: renamed from: d (android.os.Bundle) java.util.HashMap
   public static HashMap<String, String> method_1952(Bundle var0) {
      HashMap var1 = new HashMap();
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.put(var3, var0.getString(var3));
      }

      return var1;
   }

   // $FF: renamed from: aF (java.lang.String) java.lang.Object
   protected Object method_1881(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   // $FF: renamed from: aG (java.lang.String) boolean
   protected boolean method_1882(String var1) {
      throw new UnsupportedOperationException("Converting to JSON does not require this method.");
   }

   public int describeContents() {
      class_292 var10000 = CREATOR;
      return 0;
   }

   // $FF: renamed from: fB () java.util.HashMap
   public HashMap<String, class_285.class_944<?, ?>> method_1886() {
      return this.field_994 == null?null:this.field_994.method_1981(this.mClassName);
   }

   // $FF: renamed from: fT () android.os.Parcel
   public Parcel method_1953() {
      switch(this.field_997) {
      case 0:
         this.field_998 = class_599.method_3354(this.field_995);
         class_599.method_3357(this.field_995, this.field_998);
         this.field_997 = 2;
         break;
      case 1:
         class_599.method_3357(this.field_995, this.field_998);
         this.field_997 = 2;
      }

      return this.field_995;
   }

   // $FF: renamed from: fU () com.google.android.gms.internal.ic
   class_296 method_1954() {
      switch(this.field_996) {
      case 0:
         return null;
      case 1:
         return this.field_994;
      case 2:
         return this.field_994;
      default:
         throw new IllegalStateException("Invalid creation type: " + this.field_996);
      }
   }

   public int getVersionCode() {
      return this.field_999;
   }

   public String toString() {
      class_347.method_2166(this.field_994, "Cannot convert to JSON on client side.");
      Parcel var2 = this.method_1953();
      var2.setDataPosition(0);
      StringBuilder var3 = new StringBuilder(100);
      this.method_1946(var3, this.field_994.method_1981(this.mClassName), var2);
      return var3.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_292 var10000 = CREATOR;
      class_292.method_1967(this, var1, var2);
   }
}
