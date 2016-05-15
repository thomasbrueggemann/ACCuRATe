package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.zzh;

public final class InstrumentInfo implements SafeParcelable {
   public static final Creator<InstrumentInfo> CREATOR = new zzh();
   private final int mVersionCode;
   private String zzboI;
   private String zzboJ;

   InstrumentInfo(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzboI = var2;
      this.zzboJ = var3;
   }

   public int describeContents() {
      return 0;
   }

   public String getInstrumentDetails() {
      return this.zzboJ;
   }

   public String getInstrumentType() {
      return this.zzboI;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
