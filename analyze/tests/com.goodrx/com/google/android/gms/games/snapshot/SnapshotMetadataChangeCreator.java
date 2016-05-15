package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChangeEntity> {
   static void zza(SnapshotMetadataChangeEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (String)var0.getDescription(), false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (Long)var0.getPlayedTimeMillis(), false);
      zzb.zza(var1, 4, (Parcelable)var0.getCoverImageUri(), var2, false);
      zzb.zza(var1, 5, (Parcelable)var0.zzxU(), var2, false);
      zzb.zza(var1, 6, (Long)var0.getProgressValue(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeC(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgT(var1);
   }

   public SnapshotMetadataChangeEntity zzeC(Parcel var1) {
      Long var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      Uri var5 = null;
      BitmapTeleporter var6 = null;
      Long var7 = null;
      String var8 = null;

      while(var1.dataPosition() < var3) {
         int var9 = zza.zzat(var1);
         switch(zza.zzca(var9)) {
         case 1:
            var8 = zza.zzp(var1, var9);
            break;
         case 2:
            var7 = zza.zzj(var1, var9);
            break;
         case 4:
            var5 = (Uri)zza.zza(var1, var9, Uri.CREATOR);
            break;
         case 5:
            var6 = (BitmapTeleporter)zza.zza(var1, var9, BitmapTeleporter.CREATOR);
            break;
         case 6:
            var2 = zza.zzj(var1, var9);
            break;
         case 1000:
            var4 = zza.zzg(var1, var9);
            break;
         default:
            zza.zzb(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SnapshotMetadataChangeEntity(var4, var8, var7, var6, var5, var2);
      }
   }

   public SnapshotMetadataChangeEntity[] zzgT(int var1) {
      return new SnapshotMetadataChangeEntity[var1];
   }
}
