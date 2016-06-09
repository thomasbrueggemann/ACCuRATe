package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzd implements Creator<FieldMappingDictionary.Entry> {
   static void zza(FieldMappingDictionary.Entry var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.className, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzamY, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcj(var1);
   }

   public FieldMappingDictionary.Entry zzaD(Parcel var1) {
      ArrayList var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var6)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var6);
            break;
         case 2:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var6);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var6, FieldMappingDictionary.FieldMapPair.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FieldMappingDictionary.Entry(var4, var5, var2);
      }
   }

   public FieldMappingDictionary.Entry[] zzcj(int var1) {
      return new FieldMappingDictionary.Entry[var1];
   }
}
