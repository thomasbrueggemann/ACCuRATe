package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.jx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.jx
public final class class_299 implements SafeParcelable {
   public static final class_300 CREATOR;
   // $FF: renamed from: YM com.google.android.gms.internal.jx
   public static final class_299 field_1010 = method_1987("test_type", 1);
   // $FF: renamed from: YN com.google.android.gms.internal.jx
   public static final class_299 field_1011 = method_1987("saved_offers", 4);
   // $FF: renamed from: YO java.util.Set
   public static final Set<jx> field_1012;
   // $FF: renamed from: YP int
   final int field_1013;
   // $FF: renamed from: qU java.lang.String
   final String field_1014;
   // $FF: renamed from: xJ int
   final int field_1015;

   static {
      class_299[] var0 = new class_299[]{field_1010, field_1011};
      field_1012 = Collections.unmodifiableSet(new HashSet(Arrays.asList(var0)));
      CREATOR = new class_300();
   }

   class_299(int var1, String var2, int var3) {
      class_347.method_2163(var2);
      this.field_1015 = var1;
      this.field_1014 = var2;
      this.field_1013 = var3;
   }

   // $FF: renamed from: w (java.lang.String, int) com.google.android.gms.internal.jx
   private static class_299 method_1987(String var0, int var1) {
      return new class_299(0, var0, var1);
   }

   public int describeContents() {
      class_300 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_299)) {
            return false;
         }

         class_299 var2 = (class_299)var1;
         if(!this.field_1014.equals(var2.field_1014) || this.field_1013 != var2.field_1013) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.field_1014.hashCode();
   }

   public String toString() {
      return this.field_1014;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_300 var10000 = CREATOR;
      class_300.method_1988(this, var1, var2);
   }
}
