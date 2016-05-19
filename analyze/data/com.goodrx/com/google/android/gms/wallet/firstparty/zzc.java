package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;

public class zzc implements Creator<GetBuyFlowInitializationTokenResponse> {
   static void zza(GetBuyFlowInitializationTokenResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (byte[])var0.zzbpR, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhH(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlf(var1);
   }

   public GetBuyFlowInitializationTokenResponse zzhH(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      byte[] var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var3 = zza.zzg(var1, var5);
            break;
         case 2:
            var4 = zza.zzs(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new GetBuyFlowInitializationTokenResponse(var3, var4);
      }
   }

   public GetBuyFlowInitializationTokenResponse[] zzlf(int var1) {
      return new GetBuyFlowInitializationTokenResponse[var1];
   }
}
