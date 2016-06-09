package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.Feature;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;

public class zzi implements Creator<RegisterSectionInfo> {
   static void zza(RegisterSectionInfo var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.name, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzUd, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, var0.zzUe);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.weight);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzUf);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzUg, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable[])var0.zzUh, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (int[])var0.zzUi, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (String)var0.zzUj, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzx(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaq(var1);
   }

   public RegisterSectionInfo[] zzaq(int var1) {
      return new RegisterSectionInfo[var1];
   }

   public RegisterSectionInfo zzx(Parcel var1) {
      boolean var2 = false;
      String var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var5 = 1;
      int[] var6 = null;
      Feature[] var7 = null;
      String var8 = null;
      boolean var9 = false;
      String var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var13)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var13);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var13);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
            break;
         case 7:
            var7 = (Feature[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var13, Feature.CREATOR);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzv(var1, var13);
            break;
         case 11:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var13);
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
         return new RegisterSectionInfo(var12, var11, var10, var9, var5, var2, var8, var7, var6, var3);
      }
   }
}
