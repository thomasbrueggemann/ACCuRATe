package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.class_561;
import com.google.android.gms.wallet.wobs.n;

// $FF: renamed from: com.google.android.gms.wallet.wobs.n
public final class class_560 implements SafeParcelable {
   public static final Creator<n> CREATOR = new class_561();
   String akZ;
   String description;
   // $FF: renamed from: xJ int
   private final int field_2974;

   class_560() {
      this.field_2974 = 1;
   }

   class_560(int var1, String var2, String var3) {
      this.field_2974 = var1;
      this.akZ = var2;
      this.description = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.field_2974;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_561.method_3151(this, var1, var2);
   }
}
