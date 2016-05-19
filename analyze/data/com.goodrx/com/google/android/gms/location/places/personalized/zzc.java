package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.location.places.personalized.PlaceAliasResult;
import com.google.android.gms.location.places.personalized.PlaceUserData;

public class zzc implements Creator<PlaceAliasResult> {
   static void zza(PlaceAliasResult var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.getStatus(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzzC(), var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzfr(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzie(var1);
   }

   public PlaceAliasResult zzfr(Parcel var1) {
      PlaceUserData var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;

      Status var5;
      PlaceUserData var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = zza.zzat(var1);
         Status var8;
         int var9;
         switch(zza.zzca(var6)) {
         case 1:
            Status var12 = (Status)zza.zza(var1, var6, Status.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = (PlaceUserData)zza.zza(var1, var6, PlaceUserData.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = zza.zzg(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new PlaceAliasResult(var4, var5, var2);
      }
   }

   public PlaceAliasResult[] zzie(int var1) {
      return new PlaceAliasResult[var1];
   }
}
