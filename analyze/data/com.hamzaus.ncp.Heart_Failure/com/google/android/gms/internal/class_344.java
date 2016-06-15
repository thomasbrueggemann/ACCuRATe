package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_285;
import com.google.android.gms.internal.class_338;
import com.google.android.gms.internal.class_339;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.hw
public final class class_344 implements SafeParcelable, class_285.class_945<String, Integer> {
   public static final class_338 CREATOR = new class_338();
   // $FF: renamed from: GT java.util.HashMap
   private final HashMap<String, Integer> field_1410;
   // $FF: renamed from: GU java.util.HashMap
   private final HashMap<Integer, String> field_1411;
   // $FF: renamed from: GV java.util.ArrayList
   private final ArrayList<class_344.class_1265> field_1412;
   // $FF: renamed from: xJ int
   private final int field_1413;

   public class_344() {
      this.field_1413 = 1;
      this.field_1410 = new HashMap();
      this.field_1411 = new HashMap();
      this.field_1412 = null;
   }

   class_344(int var1, ArrayList<class_344.class_1265> var2) {
      this.field_1413 = var1;
      this.field_1410 = new HashMap();
      this.field_1411 = new HashMap();
      this.field_1412 = null;
      this.method_2146(var2);
   }

   // $FF: renamed from: a (java.util.ArrayList) void
   private void method_2146(ArrayList<class_344.class_1265> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class_344.class_1265 var3 = (class_344.class_1265)var2.next();
         this.method_2148(var3.field_3498, var3.field_3499);
      }

   }

   // $FF: renamed from: a (java.lang.Integer) java.lang.String
   public String method_2147(Integer var1) {
      String var2 = (String)this.field_1411.get(var1);
      if(var2 == null && this.field_1410.containsKey("gms_unknown")) {
         var2 = "gms_unknown";
      }

      return var2;
   }

   public int describeContents() {
      class_338 var10000 = CREATOR;
      return 0;
   }

   // $FF: renamed from: f (java.lang.String, int) com.google.android.gms.internal.hw
   public class_344 method_2148(String var1, int var2) {
      this.field_1410.put(var1, Integer.valueOf(var2));
      this.field_1411.put(Integer.valueOf(var2), var1);
      return this;
   }

   // $FF: renamed from: fA () int
   public int method_402() {
      return 0;
   }

   // $FF: renamed from: fy () java.util.ArrayList
   ArrayList<class_344.class_1265> method_2149() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_1410.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new class_344.class_1265(var3, ((Integer)this.field_1410.get(var3)).intValue()));
      }

      return var1;
   }

   // $FF: renamed from: fz () int
   public int method_403() {
      return 7;
   }

   // $FF: renamed from: g (java.lang.Object) java.lang.Object
   // $FF: synthetic method
   public Object method_404(Object var1) {
      return this.method_2147((Integer)var1);
   }

   int getVersionCode() {
      return this.field_1413;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_338 var10000 = CREATOR;
      class_338.method_2131(this, var1, var2);
   }

   public static final class class_1265 implements SafeParcelable {
      public static final class_339 CREATOR = new class_339();
      // $FF: renamed from: GW java.lang.String
      final String field_3498;
      // $FF: renamed from: GX int
      final int field_3499;
      final int versionCode;

      class_1265(int var1, String var2, int var3) {
         this.versionCode = var1;
         this.field_3498 = var2;
         this.field_3499 = var3;
      }

      class_1265(String var1, int var2) {
         this.versionCode = 1;
         this.field_3498 = var1;
         this.field_3499 = var2;
      }

      public int describeContents() {
         class_339 var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_339 var10000 = CREATOR;
         class_339.method_2134(this, var1, var2);
      }
   }
}
