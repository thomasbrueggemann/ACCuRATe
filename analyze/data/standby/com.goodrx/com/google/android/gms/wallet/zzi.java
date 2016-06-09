package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.IsReadyToPayRequest;

public class zzi implements Creator<IsReadyToPayRequest> {
   static void zza(IsReadyToPayRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhw(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkU(var1);
   }

   public IsReadyToPayRequest zzhw(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var4)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var4);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new IsReadyToPayRequest(var3);
      }
   }

   public IsReadyToPayRequest[] zzkU(int var1) {
      return new IsReadyToPayRequest[var1];
   }
}
