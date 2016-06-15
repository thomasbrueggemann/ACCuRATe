package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_726;
import com.google.android.gms.internal.class_737;
import com.google.android.gms.internal.class_739;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// $FF: renamed from: com.google.android.gms.internal.ko
public final class class_738 implements SafeParcelable, class_726.class_1681<String, Integer> {
   public static final class_739 CREATOR = new class_739();
   // $FF: renamed from: CK int
   private final int field_3384;
   // $FF: renamed from: NG java.util.HashMap
   private final HashMap<String, Integer> field_3385;
   // $FF: renamed from: NH java.util.HashMap
   private final HashMap<Integer, String> field_3386;
   // $FF: renamed from: NI java.util.ArrayList
   private final ArrayList<class_738.class_1325> field_3387;

   public class_738() {
      this.field_3384 = 1;
      this.field_3385 = new HashMap();
      this.field_3386 = new HashMap();
      this.field_3387 = null;
   }

   class_738(int var1, ArrayList<class_738.class_1325> var2) {
      this.field_3384 = var1;
      this.field_3385 = new HashMap();
      this.field_3386 = new HashMap();
      this.field_3387 = null;
      this.method_4284(var2);
   }

   // $FF: renamed from: b (java.util.ArrayList) void
   private void method_4284(ArrayList<class_738.class_1325> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class_738.class_1325 var3 = (class_738.class_1325)var2.next();
         this.method_4286(var3.field_2595, var3.field_2596);
      }

   }

   // $FF: renamed from: a (java.lang.Integer) java.lang.String
   public String method_4285(Integer var1) {
      String var2 = (String)this.field_3386.get(var1);
      if(var2 == null && this.field_3385.containsKey("gms_unknown")) {
         var2 = "gms_unknown";
      }

      return var2;
   }

   // $FF: synthetic method
   public Object convertBack(Object var1) {
      return this.method_4285((Integer)var1);
   }

   public int describeContents() {
      class_739 var10000 = CREATOR;
      return 0;
   }

   int getVersionCode() {
      return this.field_3384;
   }

   // $FF: renamed from: h (java.lang.String, int) com.google.android.gms.internal.ko
   public class_738 method_4286(String var1, int var2) {
      this.field_3385.put(var1, Integer.valueOf(var2));
      this.field_3386.put(Integer.valueOf(var2), var1);
      return this;
   }

   // $FF: renamed from: hH () java.util.ArrayList
   ArrayList<class_738.class_1325> method_4287() {
      ArrayList var1 = new ArrayList();
      Iterator var2 = this.field_3385.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new class_738.class_1325(var3, ((Integer)this.field_3385.get(var3)).intValue()));
      }

      return var1;
   }

   // $FF: renamed from: hI () int
   public int method_938() {
      return 7;
   }

   // $FF: renamed from: hJ () int
   public int method_939() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_739 var10000 = CREATOR;
      class_739.method_4288(this, var1, var2);
   }

   public static final class class_1325 implements SafeParcelable {
      public static final class_737 CREATOR = new class_737();
      // $FF: renamed from: NJ java.lang.String
      final String field_2595;
      // $FF: renamed from: NK int
      final int field_2596;
      final int versionCode;

      class_1325(int var1, String var2, int var3) {
         this.versionCode = var1;
         this.field_2595 = var2;
         this.field_2596 = var3;
      }

      class_1325(String var1, int var2) {
         this.versionCode = 1;
         this.field_2595 = var1;
         this.field_2596 = var2;
      }

      public int describeContents() {
         class_737 var10000 = CREATOR;
         return 0;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_737 var10000 = CREATOR;
         class_737.method_4281(this, var1, var2);
      }
   }
}
