package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;

public class zzi implements Creator<ValuesAddedDetails> {
   static void zza(ValuesAddedDetails var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.mIndex);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzauP);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzauQ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzavo, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 6, var0.zzavp);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcK(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeG(var1);
   }

   public ValuesAddedDetails zzcK(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      while(var1.dataPosition() < var3) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 3:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 5:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ValuesAddedDetails(var8, var7, var6, var5, var4, var2);
      }
   }

   public ValuesAddedDetails[] zzeG(int var1) {
      return new ValuesAddedDetails[var1];
   }
}
