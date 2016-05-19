package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenRequest;

public class zzb implements Creator<GetBuyFlowInitializationTokenRequest> {
   static void zza(GetBuyFlowInitializationTokenRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (byte[])var0.zzbpP, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (byte[])var0.zzbpQ, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhG(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzle(var1);
   }

   public GetBuyFlowInitializationTokenRequest zzhG(Parcel var1) {
      byte[] var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      byte[] var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = zza.zzat(var1);
         switch(zza.zzca(var6)) {
         case 1:
            var4 = zza.zzg(var1, var6);
            break;
         case 2:
            var5 = zza.zzs(var1, var6);
            break;
         case 3:
            var2 = zza.zzs(var1, var6);
            break;
         default:
            zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new GetBuyFlowInitializationTokenRequest(var4, var5, var2);
      }
   }

   public GetBuyFlowInitializationTokenRequest[] zzle(int var1) {
      return new GetBuyFlowInitializationTokenRequest[var1];
   }
}
