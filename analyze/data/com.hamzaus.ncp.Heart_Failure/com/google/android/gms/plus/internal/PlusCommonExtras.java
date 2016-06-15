package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_598;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.plus.internal.class_673;

public class PlusCommonExtras implements SafeParcelable {
   public static final class_673 CREATOR = new class_673();
   public static String TAG = "PlusCommonExtras";
   private String abN;
   private String abO;
   // $FF: renamed from: xJ int
   private final int field_2051;

   public PlusCommonExtras() {
      this.field_2051 = 1;
      this.abN = "";
      this.abO = "";
   }

   PlusCommonExtras(int var1, String var2, String var3) {
      this.field_2051 = var1;
      this.abN = var2;
      this.abO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlusCommonExtras) {
         PlusCommonExtras var2 = (PlusCommonExtras)var1;
         if(this.field_2051 == var2.field_2051 && class_349.equal(this.abN, var2.abN) && class_349.equal(this.abO, var2.abO)) {
            return true;
         }
      }

      return false;
   }

   public int getVersionCode() {
      return this.field_2051;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_2051), this.abN, this.abO};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: jS () java.lang.String
   public String method_2679() {
      return this.abN;
   }

   // $FF: renamed from: jT () java.lang.String
   public String method_2680() {
      return this.abO;
   }

   // $FF: renamed from: n (android.os.Bundle) void
   public void method_2681(Bundle var1) {
      var1.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", class_598.method_3353(this));
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("versionCode", Integer.valueOf(this.field_2051)).method_4301("Gpsrc", this.abN).method_4301("ClientCallingPackage", this.abO).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_673.method_3919(this, var1, var2);
   }
}
