package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_716;
import com.google.android.gms.internal.class_717;
import com.google.android.gms.internal.class_723;
import com.google.android.gms.internal.class_734;
import com.google.android.gms.internal.class_736;
import com.google.android.gms.internal.class_740;
import com.google.android.gms.internal.kr;
import com.google.android.gms.internal.ky;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.kr
public abstract class class_726 {
   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, java.lang.Object) void
   private void method_4221(StringBuilder var1, class_726.class_1680 var2, Object var3) {
      if(var2.method_5319() == 11) {
         var1.append(((class_726)var2.method_5326().cast(var3)).toString());
      } else if(var2.method_5319() == 7) {
         var1.append("\"");
         var1.append(class_716.method_4193((String)var3));
         var1.append("\"");
      } else {
         var1.append(var3);
      }
   }

   // $FF: renamed from: a (java.lang.StringBuilder, com.google.android.gms.internal.kr$a, java.util.ArrayList) void
   private void method_4222(StringBuilder var1, class_726.class_1680 var2, ArrayList<Object> var3) {
      var1.append("[");
      int var5 = 0;

      for(int var6 = var3.size(); var5 < var6; ++var5) {
         if(var5 > 0) {
            var1.append(",");
         }

         Object var8 = var3.get(var5);
         if(var8 != null) {
            this.method_4221(var1, var2, var8);
         }
      }

      var1.append("]");
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$a, java.lang.Object) java.lang.Object
   protected <O, I> I method_4223(class_726.class_1680<I, O> var1, Object var2) {
      if(var1.field_4032 != null) {
         var2 = var1.convertBack(var2);
      }

      return var2;
   }

   // $FF: renamed from: a (com.google.android.gms.internal.kr$a) boolean
   protected boolean method_4224(class_726.class_1680 var1) {
      return var1.method_5320() == 11?(var1.method_5323()?this.method_4229(var1.method_5324()):this.method_4228(var1.method_5324())):this.method_4227(var1.method_5324());
   }

   // $FF: renamed from: b (com.google.android.gms.internal.kr$a) java.lang.Object
   protected Object method_4225(class_726.class_1680 var1) {
      String var2 = var1.method_5324();
      if(var1.method_5326() != null) {
         boolean var3;
         if(this.method_4226(var1.method_5324()) == null) {
            var3 = true;
         } else {
            var3 = false;
         }

         Object[] var4 = new Object[]{var1.method_5324()};
         class_335.method_2303(var3, "Concrete field shouldn\'t be value object: %s", var4);
         HashMap var5;
         if(var1.method_5323()) {
            var5 = this.method_4232();
         } else {
            var5 = this.method_4231();
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
         return this.method_4226(var1.method_5324());
      }
   }

   // $FF: renamed from: bc (java.lang.String) java.lang.Object
   protected abstract Object method_4226(String var1);

   // $FF: renamed from: bd (java.lang.String) boolean
   protected abstract boolean method_4227(String var1);

   // $FF: renamed from: be (java.lang.String) boolean
   protected boolean method_4228(String var1) {
      throw new UnsupportedOperationException("Concrete types not supported");
   }

   // $FF: renamed from: bf (java.lang.String) boolean
   protected boolean method_4229(String var1) {
      throw new UnsupportedOperationException("Concrete type arrays not supported");
   }

   // $FF: renamed from: hK () java.util.HashMap
   public abstract HashMap<String, class_726.class_1680<?, ?>> method_4230();

   // $FF: renamed from: hL () java.util.HashMap
   public HashMap<String, Object> method_4231() {
      return null;
   }

   // $FF: renamed from: hM () java.util.HashMap
   public HashMap<String, Object> method_4232() {
      return null;
   }

   public String toString() {
      HashMap var1 = this.method_4230();
      StringBuilder var2 = new StringBuilder(100);
      Iterator var3 = var1.keySet().iterator();

      while(var3.hasNext()) {
         String var6 = (String)var3.next();
         class_726.class_1680 var7 = (class_726.class_1680)var1.get(var6);
         if(this.method_4224(var7)) {
            Object var8 = this.method_4223(var7, this.method_4225(var7));
            if(var2.length() == 0) {
               var2.append("{");
            } else {
               var2.append(",");
            }

            var2.append("\"").append(var6).append("\":");
            if(var8 == null) {
               var2.append("null");
            } else {
               switch(var7.method_5320()) {
               case 8:
                  var2.append("\"").append(class_723.method_4204((byte[])((byte[])var8))).append("\"");
                  break;
               case 9:
                  var2.append("\"").append(class_723.method_4205((byte[])((byte[])var8))).append("\"");
                  break;
               case 10:
                  class_717.method_4195(var2, (HashMap)var8);
                  break;
               default:
                  if(var7.method_5322()) {
                     this.method_4222(var2, var7, (ArrayList)var8);
                  } else {
                     this.method_4221(var2, var7, var8);
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

   public static class class_1680<I, O> implements SafeParcelable {
      public static final class_736 CREATOR = new class_736();
      // $FF: renamed from: CK int
      private final int field_4022;
      // $FF: renamed from: NL int
      protected final int field_4023;
      // $FF: renamed from: NM boolean
      protected final boolean field_4024;
      // $FF: renamed from: NN int
      protected final int field_4025;
      // $FF: renamed from: NO boolean
      protected final boolean field_4026;
      // $FF: renamed from: NP java.lang.String
      protected final String field_4027;
      // $FF: renamed from: NQ int
      protected final int field_4028;
      // $FF: renamed from: NR java.lang.Class
      protected final Class<? extends kr> field_4029;
      // $FF: renamed from: NS java.lang.String
      protected final String field_4030;
      // $FF: renamed from: NT com.google.android.gms.internal.kv
      private class_734 field_4031;
      // $FF: renamed from: NU com.google.android.gms.internal.kr$b
      private class_726.class_1681<I, O> field_4032;

      class_1680(int var1, int var2, boolean var3, int var4, boolean var5, String var6, int var7, String var8, class_740 var9) {
         this.field_4022 = var1;
         this.field_4023 = var2;
         this.field_4024 = var3;
         this.field_4025 = var4;
         this.field_4026 = var5;
         this.field_4027 = var6;
         this.field_4028 = var7;
         if(var8 == null) {
            this.field_4029 = null;
            this.field_4030 = null;
         } else {
            this.field_4029 = ky.class;
            this.field_4030 = var8;
         }

         if(var9 == null) {
            this.field_4032 = null;
         } else {
            this.field_4032 = var9.method_4301();
         }
      }

      protected class_1680(int var1, boolean var2, int var3, boolean var4, String var5, int var6, Class<? extends kr> var7, class_726.class_1681<I, O> var8) {
         this.field_4022 = 1;
         this.field_4023 = var1;
         this.field_4024 = var2;
         this.field_4025 = var3;
         this.field_4026 = var4;
         this.field_4027 = var5;
         this.field_4028 = var6;
         this.field_4029 = var7;
         if(var7 == null) {
            this.field_4030 = null;
         } else {
            this.field_4030 = var7.getCanonicalName();
         }

         this.field_4032 = var8;
      }

      // $FF: renamed from: a (java.lang.String, int, com.google.android.gms.internal.kr$b, boolean) com.google.android.gms.internal.kr$a
      public static class_726.class_1680 method_5309(String var0, int var1, class_726.class_1681<?, ?> var2, boolean var3) {
         return new class_726.class_1680(var2.method_938(), var3, var2.method_939(), false, var0, var1, (Class)null, var2);
      }

      // $FF: renamed from: a (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.kr$a
      public static <T extends kr> class_726.class_1680<T, T> method_5310(String var0, int var1, Class<T> var2) {
         return new class_726.class_1680(11, false, 11, false, var0, var1, var2, (class_726.class_1681)null);
      }

      // $FF: renamed from: b (java.lang.String, int, java.lang.Class) com.google.android.gms.internal.kr$a
      public static <T extends kr> class_726.class_1680<ArrayList<T>, ArrayList<T>> method_5311(String var0, int var1, Class<T> var2) {
         return new class_726.class_1680(11, true, 11, true, var0, var1, var2, (class_726.class_1681)null);
      }

      // $FF: renamed from: i (java.lang.String, int) com.google.android.gms.internal.kr$a
      public static class_726.class_1680<Integer, Integer> method_5313(String var0, int var1) {
         return new class_726.class_1680(0, false, 0, false, var0, var1, (Class)null, (class_726.class_1681)null);
      }

      // $FF: renamed from: j (java.lang.String, int) com.google.android.gms.internal.kr$a
      public static class_726.class_1680<Double, Double> method_5314(String var0, int var1) {
         return new class_726.class_1680(4, false, 4, false, var0, var1, (Class)null, (class_726.class_1681)null);
      }

      // $FF: renamed from: k (java.lang.String, int) com.google.android.gms.internal.kr$a
      public static class_726.class_1680<Boolean, Boolean> method_5315(String var0, int var1) {
         return new class_726.class_1680(6, false, 6, false, var0, var1, (Class)null, (class_726.class_1681)null);
      }

      // $FF: renamed from: l (java.lang.String, int) com.google.android.gms.internal.kr$a
      public static class_726.class_1680<String, String> method_5316(String var0, int var1) {
         return new class_726.class_1680(7, false, 7, false, var0, var1, (Class)null, (class_726.class_1681)null);
      }

      // $FF: renamed from: m (java.lang.String, int) com.google.android.gms.internal.kr$a
      public static class_726.class_1680<ArrayList<String>, ArrayList<String>> method_5317(String var0, int var1) {
         return new class_726.class_1680(7, true, 7, true, var0, var1, (Class)null, (class_726.class_1681)null);
      }

      // $FF: renamed from: a (com.google.android.gms.internal.kv) void
      public void method_5318(class_734 var1) {
         this.field_4031 = var1;
      }

      public I convertBack(O var1) {
         return this.field_4032.convertBack(var1);
      }

      public int describeContents() {
         class_736 var10000 = CREATOR;
         return 0;
      }

      public int getVersionCode() {
         return this.field_4022;
      }

      // $FF: renamed from: hI () int
      public int method_5319() {
         return this.field_4023;
      }

      // $FF: renamed from: hJ () int
      public int method_5320() {
         return this.field_4025;
      }

      // $FF: renamed from: hN () com.google.android.gms.internal.kr$a
      public class_726.class_1680<I, O> method_5321() {
         return new class_726.class_1680(this.field_4022, this.field_4023, this.field_4024, this.field_4025, this.field_4026, this.field_4027, this.field_4028, this.field_4030, this.method_5329());
      }

      // $FF: renamed from: hO () boolean
      public boolean method_5322() {
         return this.field_4024;
      }

      // $FF: renamed from: hP () boolean
      public boolean method_5323() {
         return this.field_4026;
      }

      // $FF: renamed from: hQ () java.lang.String
      public String method_5324() {
         return this.field_4027;
      }

      // $FF: renamed from: hR () int
      public int method_5325() {
         return this.field_4028;
      }

      // $FF: renamed from: hS () java.lang.Class
      public Class<? extends kr> method_5326() {
         return this.field_4029;
      }

      // $FF: renamed from: hT () java.lang.String
      String method_5327() {
         return this.field_4030 == null?null:this.field_4030;
      }

      // $FF: renamed from: hU () boolean
      public boolean method_5328() {
         return this.field_4032 != null;
      }

      // $FF: renamed from: hV () com.google.android.gms.internal.km
      class_740 method_5329() {
         return this.field_4032 == null?null:class_740.method_4299(this.field_4032);
      }

      // $FF: renamed from: hW () java.util.HashMap
      public HashMap<String, class_726.class_1680<?, ?>> method_5330() {
         class_335.method_2311(this.field_4030);
         class_335.method_2311(this.field_4031);
         return this.field_4031.method_4270(this.field_4030);
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder();
         var1.append("Field\n");
         var1.append("            versionCode=").append(this.field_4022).append('\n');
         var1.append("                 typeIn=").append(this.field_4023).append('\n');
         var1.append("            typeInArray=").append(this.field_4024).append('\n');
         var1.append("                typeOut=").append(this.field_4025).append('\n');
         var1.append("           typeOutArray=").append(this.field_4026).append('\n');
         var1.append("        outputFieldName=").append(this.field_4027).append('\n');
         var1.append("      safeParcelFieldId=").append(this.field_4028).append('\n');
         var1.append("       concreteTypeName=").append(this.method_5327()).append('\n');
         if(this.method_5326() != null) {
            var1.append("     concreteType.class=").append(this.method_5326().getCanonicalName()).append('\n');
         }

         StringBuilder var11 = var1.append("          converterName=");
         String var12;
         if(this.field_4032 == null) {
            var12 = "null";
         } else {
            var12 = this.field_4032.getClass().getCanonicalName();
         }

         var11.append(var12).append('\n');
         return var1.toString();
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_736 var10000 = CREATOR;
         class_736.method_4278(this, var1, var2);
      }
   }

   public interface class_1681<I, O> {
      I convertBack(O var1);

      // $FF: renamed from: hI () int
      int method_938();

      // $FF: renamed from: hJ () int
      int method_939();
   }
}
