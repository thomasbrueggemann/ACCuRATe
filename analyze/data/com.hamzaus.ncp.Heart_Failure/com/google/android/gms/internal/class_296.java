package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_290;
import com.google.android.gms.internal.class_293;
import com.google.android.gms.internal.class_295;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.hz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ic
public class class_296 implements SafeParcelable {
   public static final class_295 CREATOR = new class_295();
   // $FF: renamed from: Hi java.util.HashMap
   private final HashMap<String, HashMap<String, class_285.class_944<?, ?>>> field_1001;
   // $FF: renamed from: Hj java.util.ArrayList
   private final ArrayList<class_296.class_957> field_1002;
   // $FF: renamed from: Hk java.lang.String
   private final String field_1003;
   // $FF: renamed from: xJ int
   private final int field_1004;

   class_296(int var1, ArrayList<class_296.class_957> var2, String var3) {
      this.field_1004 = var1;
      this.field_1002 = null;
      this.field_1001 = method_1979(var2);
      this.field_1003 = (String)class_347.method_2170(var3);
      this.method_1983();
   }

   public class_296(Class<? extends hz> var1) {
      this.field_1004 = 1;
      this.field_1002 = null;
      this.field_1001 = new HashMap();
      this.field_1003 = var1.getCanonicalName();
   }

   // $FF: renamed from: b (java.util.ArrayList) java.util.HashMap
   private static HashMap<String, HashMap<String, class_285.class_944<?, ?>>> method_1979(ArrayList<class_296.class_957> var0) {
      HashMap var1 = new HashMap();
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         class_296.class_957 var4 = (class_296.class_957)var0.get(var3);
         var1.put(var4.className, var4.method_3461());
      }

      return var1;
   }

   // $FF: renamed from: a (java.lang.Class, java.util.HashMap) void
   public void method_1980(Class<? extends hz> var1, HashMap<String, class_285.class_944<?, ?>> var2) {
      this.field_1001.put(var1.getCanonicalName(), var2);
   }

   // $FF: renamed from: aJ (java.lang.String) java.util.HashMap
   public HashMap<String, class_285.class_944<?, ?>> method_1981(String var1) {
      return (HashMap)this.field_1001.get(var1);
   }

   // $FF: renamed from: b (java.lang.Class) boolean
   public boolean method_1982(Class<? extends hz> var1) {
      return this.field_1001.containsKey(var1.getCanonicalName());
   }

   public int describeContents() {
      class_295 var10000 = CREATOR;
      return 0;
   }

   // $FF: renamed from: fO () void
   public void method_1983() {
      Iterator var1 = this.field_1001.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var3 = (HashMap)this.field_1001.get(var2);
         Iterator var4 = var3.keySet().iterator();

         while(var4.hasNext()) {
            ((class_285.class_944)var3.get((String)var4.next())).method_3212(this);
         }
      }

   }

   // $FF: renamed from: fP () void
   public void method_1984() {
      Iterator var1 = this.field_1001.keySet().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         HashMap var3 = (HashMap)this.field_1001.get(var2);
         HashMap var4 = new HashMap();
         Iterator var5 = var3.keySet().iterator();

         while(var5.hasNext()) {
            String var7 = (String)var5.next();
            var4.put(var7, ((class_285.class_944)var3.get(var7)).method_3214());
         }

         this.field_1001.put(var2, var4);
      }

   }

   // $FF: renamed from: fQ () java.util.ArrayList
   ArrayList<class_296.class_957> method_1985() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_1001.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new class_296.class_957(var3, (HashMap)this.field_1001.get(var3)));
      }

      return var1;
   }

   // $FF: renamed from: fR () java.lang.String
   public String method_1986() {
      return this.field_1003;
   }

   int getVersionCode() {
      return this.field_1004;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.field_1001.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(var3).append(":\n");
         HashMap var5 = (HashMap)this.field_1001.get(var3);
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
      class_295 var10000 = CREATOR;
      class_295.method_1976(this, var1, var2);
   }

   public static class class_957 implements SafeParcelable {
      public static final class_290 CREATOR = new class_290();
      // $FF: renamed from: Hl java.util.ArrayList
      final ArrayList<class_296.class_958> field_3267;
      final String className;
      final int versionCode;

      class_957(int var1, String var2, ArrayList<class_296.class_958> var3) {
         this.versionCode = var1;
         this.className = var2;
         this.field_3267 = var3;
      }

      class_957(String var1, HashMap<String, class_285.class_944<?, ?>> var2) {
         this.versionCode = 1;
         this.className = var1;
         this.field_3267 = method_3460(var2);
      }

      // $FF: renamed from: a (java.util.HashMap) java.util.ArrayList
      private static ArrayList<class_296.class_958> method_3460(HashMap<String, class_285.class_944<?, ?>> var0) {
         if(var0 == null) {
            return null;
         } else {
            ArrayList var1 = new ArrayList();
            Iterator var2 = var0.keySet().iterator();

            while(var2.hasNext()) {
               String var3 = (String)var2.next();
               var1.add(new class_296.class_958(var3, (class_285.class_944)var0.get(var3)));
            }

            return var1;
         }
      }

      public int describeContents() {
         class_290 var10000 = CREATOR;
         return 0;
      }

      // $FF: renamed from: fS () java.util.HashMap
      HashMap<String, class_285.class_944<?, ?>> method_3461() {
         HashMap var1 = new HashMap();
         int var2 = this.field_3267.size();

         for(int var3 = 0; var3 < var2; ++var3) {
            class_296.class_958 var4 = (class_296.class_958)this.field_3267.get(var3);
            var1.put(var4.field_3149, var4.field_3148);
         }

         return var1;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_290 var10000 = CREATOR;
         class_290.method_1955(this, var1, var2);
      }
   }

   public static class class_958 implements SafeParcelable {
      public static final class_293 CREATOR = new class_293();
      // $FF: renamed from: Hm com.google.android.gms.internal.hz$a
      final class_285.class_944<?, ?> field_3148;
      // $FF: renamed from: eM java.lang.String
      final String field_3149;
      final int versionCode;

      class_958(int var1, String var2, class_285.class_944<?, ?> var3) {
         this.versionCode = var1;
         this.field_3149 = var2;
         this.field_3148 = var3;
      }

      class_958(String var1, class_285.class_944<?, ?> var2) {
         this.versionCode = 1;
         this.field_3149 = var1;
         this.field_3148 = var2;
      }

      public int describeContents() {
         class_293 var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_293 var10000 = CREATOR;
         class_293.method_1970(this, var1, var2);
      }
   }
}
