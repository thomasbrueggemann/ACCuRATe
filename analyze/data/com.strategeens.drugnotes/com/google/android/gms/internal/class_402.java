package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_401;

// $FF: renamed from: com.google.android.gms.internal.hf
public class class_402 implements SafeParcelable {
   public static final class_401 CREATOR = new class_401();
   // $FF: renamed from: CK int
   final int field_1254;
   // $FF: renamed from: CS java.lang.String
   final String field_1255;
   // $FF: renamed from: CT java.lang.String
   final String field_1256;
   // $FF: renamed from: CU java.lang.String
   final String field_1257;

   class_402(int var1, String var2, String var3, String var4) {
      this.field_1254 = var1;
      this.field_1255 = var2;
      this.field_1256 = var3;
      this.field_1257 = var4;
   }

   public class_402(String var1, String var2, String var3) {
      this(1, var1, var2, var3);
   }

   public int describeContents() {
      class_401 var10000 = CREATOR;
      return 0;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1255, this.field_1256, this.field_1257};
      return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_401 var10000 = CREATOR;
      class_401.method_2705(this, var1, var2);
   }
}
