package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_309;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.internal.jt;
import com.google.android.gms.internal.jx;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.jn
public final class class_310 implements SafeParcelable {
   public static final class_309 CREATOR = new class_309();
   // $FF: renamed from: VZ java.util.List
   final List<jt> field_1158;
   // $FF: renamed from: Wa java.lang.String
   private final String field_1159;
   // $FF: renamed from: Wb boolean
   private final boolean field_1160;
   // $FF: renamed from: Wc java.util.List
   final List<jx> field_1161;
   // $FF: renamed from: Wd java.lang.String
   private final String field_1162;
   // $FF: renamed from: We java.util.List
   final List<String> field_1163;
   // $FF: renamed from: Wf java.util.Set
   private final Set<jt> field_1164;
   // $FF: renamed from: Wg java.util.Set
   private final Set<jx> field_1165;
   // $FF: renamed from: Wh java.util.Set
   private final Set<String> field_1166;
   // $FF: renamed from: xJ int
   final int field_1167;

   class_310(int var1, List<jt> var2, String var3, boolean var4, List<jx> var5, String var6, List<String> var7) {
      this.field_1167 = var1;
      List var8;
      if(var2 == null) {
         var8 = Collections.emptyList();
      } else {
         var8 = Collections.unmodifiableList(var2);
      }

      this.field_1158 = var8;
      if(var3 == null) {
         var3 = "";
      }

      this.field_1159 = var3;
      this.field_1160 = var4;
      List var9;
      if(var5 == null) {
         var9 = Collections.emptyList();
      } else {
         var9 = Collections.unmodifiableList(var5);
      }

      this.field_1161 = var9;
      if(var6 == null) {
         var6 = "";
      }

      this.field_1162 = var6;
      List var10;
      if(var7 == null) {
         var10 = Collections.emptyList();
      } else {
         var10 = Collections.unmodifiableList(var7);
      }

      this.field_1163 = var10;
      this.field_1164 = method_2015(this.field_1158);
      this.field_1165 = method_2015(this.field_1161);
      this.field_1166 = method_2015(this.field_1163);
   }

   // $FF: renamed from: c (java.util.List) java.util.Set
   private static <E> Set<E> method_2015(List<E> var0) {
      return var0.isEmpty()?Collections.emptySet():Collections.unmodifiableSet(new HashSet(var0));
   }

   public int describeContents() {
      class_309 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_310)) {
            return false;
         }

         class_310 var2 = (class_310)var1;
         if(!this.field_1164.equals(var2.field_1164) || this.field_1160 != var2.field_1160 || !this.field_1162.equals(var2.field_1162) || !this.field_1165.equals(var2.field_1165) || !this.field_1166.equals(var2.field_1166)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1164, Boolean.valueOf(this.field_1160), this.field_1165, this.field_1162, this.field_1166};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: jb () java.lang.String
   @Deprecated
   public String method_2016() {
      return this.field_1159;
   }

   // $FF: renamed from: jc () boolean
   public boolean method_2017() {
      return this.field_1160;
   }

   // $FF: renamed from: jd () java.lang.String
   public String method_2018() {
      return this.field_1162;
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("types", this.field_1164).method_4301("placeIds", this.field_1166).method_4301("requireOpenNow", Boolean.valueOf(this.field_1160)).method_4301("userAccountName", this.field_1162).method_4301("requestedUserDataTypes", this.field_1165).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_309 var10000 = CREATOR;
      class_309.method_2012(this, var1, var2);
   }
}
