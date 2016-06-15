package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_732;
import com.google.android.gms.internal.class_733;
import com.google.android.gms.internal.class_735;
import com.google.android.gms.internal.kr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.kv
public class class_734 implements SafeParcelable {
   public static final class_733 CREATOR = new class_733();
   // $FF: renamed from: CK int
   private final int field_3375;
   // $FF: renamed from: NV java.util.HashMap
   private final HashMap<String, HashMap<String, class_726.class_1680<?, ?>>> field_3376;
   // $FF: renamed from: NW java.util.ArrayList
   private final ArrayList<class_734.class_1432> field_3377;
   // $FF: renamed from: NX java.lang.String
   private final String field_3378;

   class_734(int var1, ArrayList<class_734.class_1432> var2, String var3) {
      this.field_3375 = var1;
      this.field_3377 = null;
      this.field_3376 = method_4267(var2);
      this.field_3378 = (String)class_335.method_2311(var3);
      this.method_4271();
   }

   public class_734(Class<? extends kr> var1) {
      this.field_3375 = 1;
      this.field_3377 = null;
      this.field_3376 = new HashMap();
      this.field_3378 = var1.getCanonicalName();
   }

   // $FF: renamed from: c (java.util.ArrayList) java.util.HashMap
   private static HashMap<String, HashMap<String, class_726.class_1680<?, ?>>> method_4267(ArrayList<class_734.class_1432> var0) {
      HashMap var1 = new HashMap();
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         class_734.class_1432 var4 = (class_734.class_1432)var0.get(var3);
         var1.put(var4.className, var4.method_3738());
      }

      return var1;
   }

   // $FF: renamed from: a (java.lang.Class, java.util.HashMap) void
   public void method_4268(Class<? extends kr> var1, HashMap<String, class_726.class_1680<?, ?>> var2) {
      this.field_3376.put(var1.getCanonicalName(), var2);
   }

   // $FF: renamed from: b (java.lang.Class) boolean
   public boolean method_4269(Class<? extends kr> var1) {
      return this.field_3376.containsKey(var1.getCanonicalName());
   }

   // $FF: renamed from: bg (java.lang.String) java.util.HashMap
   public HashMap<String, class_726.class_1680<?, ?>> method_4270(String var1) {
      return (HashMap)this.field_3376.get(var1);
   }

   public int describeContents() {
      class_733 var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.field_3375;
   }

   // $FF: renamed from: hX () void
   public void method_4271() {
      Iterator var1 = this.field_3376.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var3 = (HashMap)this.field_3376.get(var2);
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            ((class_726.class_1680)var3.get((String)var4.next())).method_5318(this);
         }
      }

   }

   // $FF: renamed from: hY () void
   public void method_4272() {
      Iterator var1 = this.field_3376.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var3 = (HashMap)this.field_3376.get(var2);
         HashMap var4 = new HashMap();
         Iterator var5 = var3.keySet().iterator();

         while(var5.hasNext()) {
            String var7 = (String)var5.next();
            var4.put(var7, ((class_726.class_1680)var3.get(var7)).method_5321());
         }

         this.field_3376.put(var2, var4);
      }

   }

   // $FF: renamed from: hZ () java.util.ArrayList
   ArrayList<class_734.class_1432> method_4273() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_3376.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new class_734.class_1432(var3, (HashMap)this.field_3376.get(var3)));
      }

      return var1;
   }

   // $FF: renamed from: ia () java.lang.String
   public String method_4274() {
      return this.field_3378;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.field_3376.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(var3).append(":\n");
         HashMap var5 = (HashMap)this.field_3376.get(var3);
         Iterator var6 = var5.keySet().iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var1.append("  ").append(var7).append(": ");
            var1.append(var5.get(var7));
         }
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_733 var10000 = CREATOR;
      class_733.method_4264(this, var1, var2);
   }

   public static class class_1432 implements SafeParcelable {
      public static final class_732 CREATOR = new class_732();
      // $FF: renamed from: NY java.util.ArrayList
      final ArrayList<class_734.class_1433> field_2838;
      final String className;
      final int versionCode;

      class_1432(int var1, String var2, ArrayList<class_734.class_1433> var3) {
         this.versionCode = var1;
         this.className = var2;
         this.field_2838 = var3;
      }

      class_1432(String var1, HashMap<String, class_726.class_1680<?, ?>> var2) {
         this.versionCode = 1;
         this.className = var1;
         this.field_2838 = method_3737(var2);
      }

      // $FF: renamed from: a (java.util.HashMap) java.util.ArrayList
      private static ArrayList<class_734.class_1433> method_3737(HashMap<String, class_726.class_1680<?, ?>> var0) {
         if(var0 == null) {
            return null;
         } else {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.keySet().iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               var1.add(new class_734.class_1433(var3, (class_726.class_1680)var0.get(var3)));
            }

            return var1;
         }
      }

      public int describeContents() {
         class_732 var10000 = CREATOR;
         return 0;
      }

      // $FF: renamed from: ib () java.util.HashMap
      HashMap<String, class_726.class_1680<?, ?>> method_3738() {
         HashMap var1 = new HashMap();
         int var2 = this.field_2838.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            class_734.class_1433 var4 = (class_734.class_1433)this.field_2838.get(var3);
            var1.put(var4.field_2840, var4.field_2839);
         }

         return var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_732 var10000 = CREATOR;
         class_732.method_4261(this, var1, var2);
      }
   }

   public static class class_1433 implements SafeParcelable {
      public static final class_735 CREATOR = new class_735();
      // $FF: renamed from: NZ com.google.android.gms.internal.kr$a
      final class_726.class_1680<?, ?> field_2839;
      // $FF: renamed from: fv java.lang.String
      final String field_2840;
      final int versionCode;

      class_1433(int var1, String var2, class_726.class_1680<?, ?> var3) {
         this.versionCode = var1;
         this.field_2840 = var2;
         this.field_2839 = var3;
      }

      class_1433(String var1, class_726.class_1680<?, ?> var2) {
         this.versionCode = 1;
         this.field_2840 = var1;
         this.field_2839 = var2;
      }

      public int describeContents() {
         class_735 var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_735 var10000 = CREATOR;
         class_735.method_4275(this, var1, var2);
      }
   }
}
