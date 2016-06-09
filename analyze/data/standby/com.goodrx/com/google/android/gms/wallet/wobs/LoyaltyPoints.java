package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.LoyaltyPointsBalance;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.zze;

public final class LoyaltyPoints implements SafeParcelable {
   public static final Creator<LoyaltyPoints> CREATOR = new zze();
   String label;
   private final int mVersionCode;
   String type;
   TimeInterval zzboY;
   LoyaltyPointsBalance zzbqI;

   LoyaltyPoints() {
      this.mVersionCode = 1;
   }

   LoyaltyPoints(int var1, String var2, LoyaltyPointsBalance var3, String var4, TimeInterval var5) {
      this.mVersionCode = var1;
      this.label = var2;
      this.zzbqI = var3;
      this.type = var4;
      this.zzboY = var5;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze.zza(this, var1, var2);
   }
}
