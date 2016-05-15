package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.zzg;

public final class TimeInterval implements SafeParcelable {
   public static final Creator<TimeInterval> CREATOR = new zzg();
   private final int mVersionCode;
   long zzbqP;
   long zzbqQ;

   TimeInterval() {
      this.mVersionCode = 1;
   }

   TimeInterval(int var1, long var2, long var4) {
      this.mVersionCode = var1;
      this.zzbqP = var2;
      this.zzbqQ = var4;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }
}
