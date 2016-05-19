package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentId;
import com.google.android.gms.appdatasearch.UsageInfo;

public class zzj implements Creator<UsageInfo> {
   static void zza(UsageInfo var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzUs, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, var0.zzUt);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzUu);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzvp, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzUv, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzUw);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzUx);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzUy);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzy(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzat(var1);
   }

   public UsageInfo[] zzat(int var1) {
      return new UsageInfo[var1];
   }

   public UsageInfo zzy(Parcel var1) {
      DocumentContents var2 = null;
      int var3 = 0;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var5 = 0L;
      int var7 = -1;
      boolean var8 = false;
      String var9 = null;
      int var10 = 0;
      DocumentId var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var11 = (DocumentId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, DocumentId.CREATOR);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var13);
            break;
         case 3:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 4:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 5:
            var2 = (DocumentContents)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var13, DocumentContents.CREATOR);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 8:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 1000:
            var12 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new UsageInfo(var12, var11, var5, var10, var9, var2, var8, var7, var3);
      }
   }
}
