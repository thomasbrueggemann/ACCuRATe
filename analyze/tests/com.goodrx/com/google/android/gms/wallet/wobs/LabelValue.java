package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.zzb;

public final class LabelValue implements SafeParcelable {
   public static final Creator<LabelValue> CREATOR = new zzb();
   String label;
   private final int mVersionCode;
   String value;

   LabelValue() {
      this.mVersionCode = 1;
   }

   LabelValue(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.label = var2;
      this.value = var3;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
