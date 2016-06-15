package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_750;
import com.google.android.gms.internal.oe;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.oe
public final class class_751 implements SafeParcelable {
   public static final class_750 CREATOR;
   public static final class_751 akb = method_4328("test_type", 1);
   public static final class_751 akc = method_4328("labeled_place", 6);
   public static final Set<oe> akd;
   // $FF: renamed from: CK int
   final int field_3412;
   final int ake;
   // $FF: renamed from: vc java.lang.String
   final String field_3413;

   static {
      class_751[] var0 = new class_751[]{akb, akc};
      akd = Collections.unmodifiableSet(new HashSet(Arrays.asList(var0)));
      CREATOR = new class_750();
   }

   class_751(int var1, String var2, int var3) {
      class_335.method_2310(var2);
      this.field_3412 = var1;
      this.field_3413 = var2;
      this.ake = var3;
   }

   // $FF: renamed from: A (java.lang.String, int) com.google.android.gms.internal.oe
   private static class_751 method_4328(String var0, int var1) {
      return new class_751(0, var0, var1);
   }

   public int describeContents() {
      class_750 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof class_751)) {
            return false;
         }

         class_751 var2 = (class_751)var1;
         if(!this.field_3413.equals(var2.field_3413) || this.ake != var2.ake) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.field_3413.hashCode();
   }

   public String toString() {
      return this.field_3413;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_750 var10000 = CREATOR;
      class_750.method_4325(this, var1, var2);
   }
}
