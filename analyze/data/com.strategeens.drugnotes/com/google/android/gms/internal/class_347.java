package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_337;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.jg
public final class class_347 {
   // $FF: renamed from: JJ android.view.View
   private final View field_1041;
   // $FF: renamed from: Mw com.google.android.gms.internal.jg$a
   private final class_347.class_1103 field_1042;

   public class_347(String var1, Collection<String> var2, int var3, View var4, String var5) {
      this.field_1042 = new class_347.class_1103(var1, var2, var3, var5);
      this.field_1041 = var4;
   }

   public String getAccountName() {
      return this.field_1042.getAccountName();
   }

   // $FF: renamed from: hm () java.lang.String
   public String method_2418() {
      return this.field_1042.method_2319();
   }

   // $FF: renamed from: hn () int
   public int method_2419() {
      return this.field_1042.method_2320();
   }

   // $FF: renamed from: ho () java.util.List
   public List<String> method_2420() {
      return this.field_1042.method_2321();
   }

   // $FF: renamed from: hp () java.lang.String[]
   public String[] method_2421() {
      return (String[])this.field_1042.method_2321().toArray(new String[0]);
   }

   // $FF: renamed from: hq () java.lang.String
   public String method_2422() {
      return this.field_1042.method_2322();
   }

   // $FF: renamed from: hr () android.view.View
   public View method_2423() {
      return this.field_1041;
   }

   public static final class class_1103 implements SafeParcelable {
      public static final class_337 CREATOR = new class_337();
      // $FF: renamed from: CK int
      private final int field_891;
      // $FF: renamed from: DZ java.lang.String
      private final String field_892;
      // $FF: renamed from: JI int
      private final int field_893;
      // $FF: renamed from: JK java.lang.String
      private final String field_894;
      // $FF: renamed from: Kh java.util.List
      private final List<String> field_895;

      class_1103(int var1, String var2, List<String> var3, int var4, String var5) {
         this.field_895 = new ArrayList();
         this.field_891 = var1;
         this.field_892 = var2;
         this.field_895.addAll(var3);
         this.field_893 = var4;
         this.field_894 = var5;
      }

      public class_1103(String var1, Collection<String> var2, int var3, String var4) {
         this(3, var1, new ArrayList(var2), var3, var4);
      }

      public int describeContents() {
         return 0;
      }

      public String getAccountName() {
         return this.field_892;
      }

      public int getVersionCode() {
         return this.field_891;
      }

      // $FF: renamed from: hm () java.lang.String
      public String method_2319() {
         return this.field_892 != null?this.field_892:"<<default account>>";
      }

      // $FF: renamed from: hn () int
      public int method_2320() {
         return this.field_893;
      }

      // $FF: renamed from: ho () java.util.List
      public List<String> method_2321() {
         return new ArrayList(this.field_895);
      }

      // $FF: renamed from: hq () java.lang.String
      public String method_2322() {
         return this.field_894;
      }

      public void writeToParcel(Parcel var1, int var2) {
         class_337.method_2313(this, var1, var2);
      }
   }
}
