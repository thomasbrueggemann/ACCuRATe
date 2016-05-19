package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm implements Creator<CreateFileIntentSenderRequest> {
   static void zza(CreateFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaqw, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 3, var0.zzaox);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzapg, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzapj, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Integer)var0.zzaqx, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbj(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzda(var1);
   }

   public CreateFileIntentSenderRequest zzbj(Parcel var1) {
      int var2 = 0;
      Integer var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      DriveId var5 = null;
      String var6 = null;
      MetadataBundle var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var9)) {
         case 1:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 2:
            var7 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, MetadataBundle.CREATOR);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var9);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var9);
            break;
         case 5:
            var5 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var9, DriveId.CREATOR);
            break;
         case 6:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzh(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileIntentSenderRequest(var8, var7, var2, var6, var5, var3);
      }
   }

   public CreateFileIntentSenderRequest[] zzda(int var1) {
      return new CreateFileIntentSenderRequest[var1];
   }
}
