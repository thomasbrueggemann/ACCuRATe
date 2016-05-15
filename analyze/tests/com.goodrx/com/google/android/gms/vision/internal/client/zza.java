package com.google.android.gms.vision.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public class zza implements Creator<FrameMetadataParcel> {
   static void zza(FrameMetadataParcel var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.versionCode);
      zzb.zzc(var1, 2, var0.width);
      zzb.zzc(var1, 3, var0.height);
      zzb.zzc(var1, 4, var0.field_635);
      zzb.zza(var1, 5, var0.zzboe);
      zzb.zzc(var1, 6, var0.rotation);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhn(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzkL(var1);
   }

   public FrameMetadataParcel zzhn(Parcel var1) {
      int var2 = 0;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      long var4 = 0L;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      while(var1.dataPosition() < var3) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(var1, var10);
            break;
         case 6:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new FrameMetadataParcel(var9, var8, var7, var6, var4, var2);
      }
   }

   public FrameMetadataParcel[] zzkL(int var1) {
      return new FrameMetadataParcel[var1];
   }
}
