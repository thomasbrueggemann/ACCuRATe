package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_565;
import com.google.android.gms.wallet.wobs.j;

// $FF: renamed from: com.google.android.gms.wallet.wobs.j
public final class class_564 implements SafeParcelable {
   public static final Creator<j> CREATOR = new class_565();
   String akW;
   // $FF: renamed from: qb java.lang.String
   String field_2977;
   // $FF: renamed from: xJ int
   private final int field_2978;

   class_564() {
      this.field_2978 = 1;
   }

   class_564(int var1, String var2, String var3) {
      this.field_2978 = var1;
      this.akW = var2;
      this.field_2977 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2978;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_565.method_3157(this, var1, var2);
   }
}
