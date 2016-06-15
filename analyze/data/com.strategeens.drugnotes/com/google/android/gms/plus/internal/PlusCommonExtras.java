package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_703;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.plus.internal.class_870;

public class PlusCommonExtras implements SafeParcelable {
   public static final class_870 CREATOR = new class_870();
   public static String TAG = "PlusCommonExtras";
   // $FF: renamed from: CK int
   private final int field_1724;
   private String anN;
   private String anO;

   public PlusCommonExtras() {
      this.field_1724 = 1;
      this.anN = "";
      this.anO = "";
   }

   PlusCommonExtras(int var1, String var2, String var3) {
      this.field_1724 = var1;
      this.anN = var2;
      this.anO = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof PlusCommonExtras) {
         PlusCommonExtras var2 = (PlusCommonExtras)var1;
         if(this.field_1724 == var2.field_1724 && class_336.equal(this.anN, var2.anN) && class_336.equal(this.anO, var2.anO)) {
            return true;
         }
      }

      return false;
   }

   public int getVersionCode() {
      return this.field_1724;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_1724), this.anN, this.anO};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: ox () java.lang.String
   public String method_3036() {
      return this.anN;
   }

   // $FF: renamed from: oy () java.lang.String
   public String method_3037() {
      return this.anO;
   }

   // $FF: renamed from: q (android.os.Bundle) void
   public void method_3038(Bundle var1) {
      var1.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", class_703.method_4022(this));
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("versionCode", Integer.valueOf(this.field_1724)).method_3424("Gpsrc", this.anN).method_3424("ClientCallingPackage", this.anO).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_870.method_4881(this, var1, var2);
   }
}
