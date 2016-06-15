package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_348;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.gz
public final class class_323 {
   // $FF: renamed from: DG android.view.View
   private final View field_1295;
   // $FF: renamed from: FR com.google.android.gms.internal.gz$a
   private final class_323.class_1226 field_1296;

   public class_323(String var1, Collection<String> var2, int var3, View var4, String var5) {
      this.field_1296 = new class_323.class_1226(var1, var2, var3, var5);
      this.field_1295 = var4;
   }

   // $FF: renamed from: fe () java.lang.String
   public String method_2055() {
      return this.field_1296.method_4295();
   }

   // $FF: renamed from: ff () int
   public int method_2056() {
      return this.field_1296.method_4296();
   }

   // $FF: renamed from: fg () java.util.List
   public List<String> method_2057() {
      return this.field_1296.method_4297();
   }

   // $FF: renamed from: fh () java.lang.String[]
   public String[] method_2058() {
      return (String[])this.field_1296.method_4297().toArray(new String[0]);
   }

   // $FF: renamed from: fi () java.lang.String
   public String method_2059() {
      return this.field_1296.method_4298();
   }

   // $FF: renamed from: fj () android.view.View
   public View method_2060() {
      return this.field_1295;
   }

   public String getAccountName() {
      return this.field_1296.getAccountName();
   }

   public static final class class_1226 implements SafeParcelable {
      public static final class_348 CREATOR = new class_348();
      // $FF: renamed from: DF int
      private final int field_4051;
      // $FF: renamed from: DH java.lang.String
      private final String field_4052;
      // $FF: renamed from: Ec java.util.List
      private final List<String> field_4053;
      // $FF: renamed from: xJ int
      private final int field_4054;
      // $FF: renamed from: yN java.lang.String
      private final String field_4055;

      class_1226(int var1, String var2, List<String> var3, int var4, String var5) {
         this.field_4053 = new ArrayList();
         this.field_4054 = var1;
         this.field_4055 = var2;
         this.field_4053.addAll(var3);
         this.field_4051 = var4;
         this.field_4052 = var5;
      }

      public class_1226(String var1, Collection<String> var2, int var3, String var4) {
         this(3, var1, new ArrayList(var2), var3, var4);
      }

      public int describeContents() {
         return 0;
      }

      // $FF: renamed from: fe () java.lang.String
      public String method_4295() {
         return this.field_4055 != null?this.field_4055:"<<default account>>";
      }

      // $FF: renamed from: ff () int
      public int method_4296() {
         return this.field_4051;
      }

      // $FF: renamed from: fg () java.util.List
      public List<String> method_4297() {
         return new ArrayList(this.field_4053);
      }

      // $FF: renamed from: fi () java.lang.String
      public String method_4298() {
         return this.field_4052;
      }

      public String getAccountName() {
         return this.field_4055;
      }

      public int getVersionCode() {
         return this.field_4054;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_348.method_2171(this, var1, var2);
      }
   }
}
