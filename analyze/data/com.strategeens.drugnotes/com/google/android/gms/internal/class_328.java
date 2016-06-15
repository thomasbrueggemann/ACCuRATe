package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_330;

// $FF: renamed from: com.google.android.gms.internal.if
public class class_328 implements SafeParcelable {
   public static final class_330 CREATOR = new class_330();
   // $FF: renamed from: Ep android.os.Bundle
   final Bundle field_882;
   // $FF: renamed from: Eq byte[]
   final byte[] field_883;
   final int responseCode;
   final int versionCode;

   public class_328(int var1, int var2, Bundle var3, byte[] var4) {
      this.versionCode = var1;
      this.responseCode = var2;
      this.field_882 = var3;
      this.field_883 = var4;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_330.method_2289(this, var1, var2);
   }
}
