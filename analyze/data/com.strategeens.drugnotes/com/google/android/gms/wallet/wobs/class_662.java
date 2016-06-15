package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_663;
import com.google.android.gms.wallet.wobs.n;

// $FF: renamed from: com.google.android.gms.wallet.wobs.n
public final class class_662 implements SafeParcelable {
   public static final Creator<n> CREATOR = new class_663();
   // $FF: renamed from: CK int
   private final int field_2877;
   String awW;
   String description;

   class_662() {
      this.field_2877 = 1;
   }

   class_662(int var1, String var2, String var3) {
      this.field_2877 = var1;
      this.awW = var2;
      this.description = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2877;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_663.method_3786(this, var1, var2);
   }
}
