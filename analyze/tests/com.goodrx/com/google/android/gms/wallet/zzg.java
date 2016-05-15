package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.wallet.GiftCardWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzg implements Creator<GiftCardWalletObject> {
   static void zza(GiftCardWalletObject var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.getVersionCode());
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzboB, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzboC, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.pin, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzboD, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzboE);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzboF, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzboG);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (String)var0.zzboH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhu(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkS(var1);
   }

   public GiftCardWalletObject zzhu(Parcel var1) {
      long var2 = 0L;
      String var4 = null;
      int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var6 = 0;
      String var7 = null;
      long var8 = var2;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      CommonWalletObject var13 = null;

      while(var1.dataPosition() < var5) {
         int var14 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var14)) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var14);
            break;
         case 2:
            var13 = (CommonWalletObject)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var14, CommonWalletObject.CREATOR);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 4:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var14);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var14);
            break;
         case 9:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var14);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var14);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var5, var1);
      } else {
         return new GiftCardWalletObject(var6, var13, var12, var11, var10, var8, var7, var2, var4);
      }
   }

   public GiftCardWalletObject[] zzkS(int var1) {
      return new GiftCardWalletObject[var1];
   }
}
