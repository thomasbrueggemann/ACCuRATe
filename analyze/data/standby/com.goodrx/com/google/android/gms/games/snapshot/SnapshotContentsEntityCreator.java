package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;

public class SnapshotContentsEntityCreator implements Creator<SnapshotContentsEntity> {
   static void zza(SnapshotContentsEntity var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.zzsx(), var2, false);
      zzb.zzc(var1, 1000, var0.getVersionCode());
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzeA(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzgR(var1);
   }

   public SnapshotContentsEntity zzeA(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      Contents var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = (Contents)zza.zza(var1, var5, Contents.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new SnapshotContentsEntity(var3, var4);
      }
   }

   public SnapshotContentsEntity[] zzgR(int var1) {
      return new SnapshotContentsEntity[var1];
   }
}
