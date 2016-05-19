package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.zzd;

public final class LoyaltyPointsBalance implements SafeParcelable {
   public static final Creator<LoyaltyPointsBalance> CREATOR = new zzd();
   private final int mVersionCode;
   String zzboF;
   int zzbqJ;
   String zzbqK;
   double zzbqL;
   long zzbqM;
   int zzbqN;

   LoyaltyPointsBalance() {
      this.mVersionCode = 1;
      this.zzbqN = -1;
      this.zzbqJ = -1;
      this.zzbqL = -1.0D;
   }

   LoyaltyPointsBalance(int var1, int var2, String var3, double var4, String var6, long var7, int var9) {
      this.mVersionCode = var1;
      this.zzbqJ = var2;
      this.zzbqK = var3;
      this.zzbqL = var4;
      this.zzboF = var6;
      this.zzbqM = var7;
      this.zzbqN = var9;
   }

   public int describeContents() {
      return 0;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzd.zza(this, var1, var2);
   }
}
