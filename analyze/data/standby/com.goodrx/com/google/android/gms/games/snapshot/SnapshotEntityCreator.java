package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
   static void zza(SnapshotEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getMetadata(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 3, (Parcelable)var0.getSnapshotContents(), var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeB(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgS(var1);
   }

   public SnapshotEntity zzeB(Parcel var1) {
      SnapshotContentsEntity var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;

      SnapshotMetadataEntity var5;
      SnapshotContentsEntity var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = zza.zzat(var1);
         SnapshotMetadataEntity var8;
         int var9;
         switch(zza.zzca(var6)) {
         case 1:
            SnapshotMetadataEntity var12 = (SnapshotMetadataEntity)zza.zza(var1, var6, SnapshotMetadataEntity.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var12;
            break;
         case 3:
            var7 = (SnapshotContentsEntity)zza.zza(var1, var6, SnapshotContentsEntity.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var10 = zza.zzg(var1, var6);
            var8 = var5;
            var9 = var10;
            var7 = var2;
            break;
         default:
            zza.zzb(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new SnapshotEntity(var4, var5, var2);
      }
   }

   public SnapshotEntity[] zzgS(int var1) {
      return new SnapshotEntity[var1];
   }
}
