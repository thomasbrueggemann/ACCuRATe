package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class RewardItemParcel implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   public final String type;
   public final int versionCode;
   public final int zzKS;

   public RewardItemParcel(int var1, String var2, int var3) {
      this.versionCode = var1;
      this.type = var2;
      this.zzKS = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != null && var1 instanceof RewardItemParcel) {
         RewardItemParcel var2 = (RewardItemParcel)var1;
         if(zzw.equal(this.type, var2.type) && zzw.equal(Integer.valueOf(this.zzKS), Integer.valueOf(var2.zzKS))) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.type, Integer.valueOf(this.zzKS)};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
