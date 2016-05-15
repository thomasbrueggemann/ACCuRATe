package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;

public class zzi implements Creator<WalletObjectMessage> {
   static void zza(WalletObjectMessage var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzbqO, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.body, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzbqR, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzbqS, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzbqT, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhW(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzlx(var1);
   }

   public WalletObjectMessage zzhW(Parcel var1) {
      UriData var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      UriData var5 = null;
      TimeInterval var6 = null;
      String var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 4:
            var6 = (TimeInterval)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, TimeInterval.CREATOR);
            break;
         case 5:
            var5 = (UriData)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, UriData.CREATOR);
            break;
         case 6:
            var2 = (UriData)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, UriData.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new WalletObjectMessage(var4, var8, var7, var6, var5, var2);
      }
   }

   public WalletObjectMessage[] zzlx(int var1) {
      return new WalletObjectMessage[var1];
   }
}
