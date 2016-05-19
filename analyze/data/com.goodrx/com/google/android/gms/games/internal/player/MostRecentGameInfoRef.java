package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
   private final PlayerColumnNames zzaDh;

   public MostRecentGameInfoRef(DataHolder var1, int var2, PlayerColumnNames var3) {
      super(var1, var2);
      this.zzaDh = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return MostRecentGameInfoEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzxE();
   }

   public int hashCode() {
      return MostRecentGameInfoEntity.zza(this);
   }

   public String toString() {
      return MostRecentGameInfoEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((MostRecentGameInfoEntity)this.zzxE()).writeToParcel(var1, var2);
   }

   public long zzxA() {
      return this.getLong(this.zzaDh.zzaIM);
   }

   public Uri zzxB() {
      return this.zzcA(this.zzaDh.zzaIN);
   }

   public Uri zzxC() {
      return this.zzcA(this.zzaDh.zzaIO);
   }

   public Uri zzxD() {
      return this.zzcA(this.zzaDh.zzaIP);
   }

   public MostRecentGameInfo zzxE() {
      return new MostRecentGameInfoEntity(this);
   }

   public String zzxy() {
      return this.getString(this.zzaDh.zzaIK);
   }

   public String zzxz() {
      return this.getString(this.zzaDh.zzaIL);
   }
}
