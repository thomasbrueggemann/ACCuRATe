package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.request.LargeParcelTeleporter;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<LargeParcelTeleporter> {
   static void zza(LargeParcelTeleporter var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (Parcelable)var0.zzIq, var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzl(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzJ(var1);
   }

   public LargeParcelTeleporter[] zzJ(int var1) {
      return new LargeParcelTeleporter[var1];
   }

   public LargeParcelTeleporter zzl(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      ParcelFileDescriptor var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var5)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var5);
            break;
         case 2:
            var4 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var5, ParcelFileDescriptor.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new LargeParcelTeleporter(var3, var4);
      }
   }
}
