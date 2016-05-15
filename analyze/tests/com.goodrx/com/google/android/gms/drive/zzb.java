package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;

public class zzb implements Creator<Contents> {
   static void zza(Contents var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzajL, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaox);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 4, var0.zzaoy);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, var0.zzaoA);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (String)var0.zzsU, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaI(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcr(var1);
   }

   public Contents zzaI(Parcel var1) {
      String var2 = null;
      boolean var3 = false;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DriveId var5 = null;
      int var6 = 0;
      int var7 = 0;
      ParcelFileDescriptor var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var4) {
         int var10 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var10)) {
         case 1:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 2:
            var8 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, ParcelFileDescriptor.CREATOR);
            break;
         case 3:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var10);
            break;
         case 5:
            var5 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var10, DriveId.CREATOR);
            break;
         case 6:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var10);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var10);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var10);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Contents(var9, var8, var7, var6, var5, var3, var2);
      }
   }

   public Contents[] zzcr(int var1) {
      return new Contents[var1];
   }
}
