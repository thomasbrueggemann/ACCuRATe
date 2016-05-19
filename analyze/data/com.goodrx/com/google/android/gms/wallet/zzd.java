package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.CreateWalletObjectsRequest;
import com.google.android.gms.wallet.GiftCardWalletObject;
import com.google.android.gms.wallet.LoyaltyWalletObject;
import com.google.android.gms.wallet.OfferWalletObject;

public class zzd implements Creator<CreateWalletObjectsRequest> {
   static void zza(CreateWalletObjectsRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzbol, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzbom, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzbon, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhr(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkP(var1);
   }

   public CreateWalletObjectsRequest zzhr(Parcel var1) {
      GiftCardWalletObject var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      OfferWalletObject var5 = null;

      LoyaltyWalletObject var6;
      GiftCardWalletObject var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         OfferWalletObject var9;
         LoyaltyWalletObject var10;
         int var11;
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var7)) {
         case 1:
            int var16 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            LoyaltyWalletObject var14 = (LoyaltyWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, LoyaltyWalletObject.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            OfferWalletObject var12 = (OfferWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, OfferWalletObject.CREATOR);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (GiftCardWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var7, GiftCardWalletObject.CREATOR);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new CreateWalletObjectsRequest(var4, var6, var5, var2);
      }
   }

   public CreateWalletObjectsRequest[] zzkP(int var1) {
      return new CreateWalletObjectsRequest[var1];
   }
}
