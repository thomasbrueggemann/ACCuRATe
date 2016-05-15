package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
   static void zza(SnapshotMetadataEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getGame(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zza(var1, 2, (Parcelable)var0.getOwner(), var2, false);
      zzb.zza(var1, 3, (String)var0.getSnapshotId(), false);
      zzb.zza(var1, 5, (Parcelable)var0.getCoverImageUri(), var2, false);
      zzb.zza(var1, 6, (String)var0.getCoverImageUrl(), false);
      zzb.zza(var1, 7, (String)var0.getTitle(), false);
      zzb.zza(var1, 8, (String)var0.getDescription(), false);
      zzb.zza(var1, 9, var0.getLastModifiedTimestamp());
      zzb.zza(var1, 10, var0.getPlayedTime());
      zzb.zza(var1, 11, var0.getCoverImageAspectRatio());
      zzb.zza(var1, 12, (String)var0.getUniqueName(), false);
      zzb.zza(var1, 13, var0.hasChangePending());
      zzb.zza(var1, 14, var0.getProgressValue());
      zzb.zza(var1, 15, (String)var0.getDeviceName(), false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgU(var1);
   }

   public SnapshotMetadataEntity zzeD(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      GameEntity var4 = null;
      PlayerEntity var5 = null;
      String var6 = null;
      Uri var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      long var11 = 0L;
      long var13 = 0L;
      float var15 = 0.0F;
      String var16 = null;
      boolean var17 = false;
      long var18 = 0L;
      String var20 = null;

      while(var1.dataPosition() < var2) {
         int var21 = zza.zzat(var1);
         switch(zza.zzca(var21)) {
         case 1:
            var4 = (GameEntity)zza.zza(var1, var21, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)zza.zza(var1, var21, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = zza.zzp(var1, var21);
            break;
         case 5:
            var7 = (Uri)zza.zza(var1, var21, Uri.CREATOR);
            break;
         case 6:
            var8 = zza.zzp(var1, var21);
            break;
         case 7:
            var9 = zza.zzp(var1, var21);
            break;
         case 8:
            var10 = zza.zzp(var1, var21);
            break;
         case 9:
            var11 = zza.zzi(var1, var21);
            break;
         case 10:
            var13 = zza.zzi(var1, var21);
            break;
         case 11:
            var15 = zza.zzl(var1, var21);
            break;
         case 12:
            var16 = zza.zzp(var1, var21);
            break;
         case 13:
            var17 = zza.zzc(var1, var21);
            break;
         case 14:
            var18 = zza.zzi(var1, var21);
            break;
         case 15:
            var20 = zza.zzp(var1, var21);
            break;
         case 1000:
            var3 = zza.zzg(var1, var21);
            break;
         default:
            zza.zzb(var1, var21);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SnapshotMetadataEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var13, var15, var16, var17, var18, var20);
      }
   }

   public SnapshotMetadataEntity[] zzgU(int var1) {
      return new SnapshotMetadataEntity[var1];
   }
}
