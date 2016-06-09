package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo;

public class zzd implements Creator<DocumentSection> {
   static void zza(DocumentSection var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (String)var0.zzTO, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzTP, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzTQ);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (byte[])var0.zzTR, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzt(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzak(var1);
   }

   public DocumentSection[] zzak(int var1) {
      return new DocumentSection[var1];
   }

   public DocumentSection zzt(Parcel var1) {
      byte[] var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      int var5 = -1;
      RegisterSectionInfo var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var8)) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var8);
            break;
         case 3:
            var6 = (RegisterSectionInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var8, RegisterSectionInfo.CREATOR);
            break;
         case 4:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzs(var1, var8);
            break;
         case 1000:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new DocumentSection(var4, var7, var6, var5, var2);
      }
   }
}
