package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevelCreator;

public final class PlayerLevel implements SafeParcelable {
   public static final Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();
   private final int mVersionCode;
   private final int zzaDa;
   private final long zzaDb;
   private final long zzaDc;

   PlayerLevel(int var1, int var2, long var3, long var5) {
      boolean var7 = true;
      super();
      boolean var8;
      if(var3 >= 0L) {
         var8 = var7;
      } else {
         var8 = false;
      }

      zzx.zza(var8, "Min XP must be positive!");
      if(var5 <= var3) {
         var7 = false;
      }

      zzx.zza(var7, "Max XP must be more than min XP!");
      this.mVersionCode = var1;
      this.zzaDa = var2;
      this.zzaDb = var3;
      this.zzaDc = var5;
   }

   public PlayerLevel(int var1, long var2, long var4) {
      this(1, var1, var2, var4);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof PlayerLevel)) {
         var2 = false;
      } else if(this != var1) {
         PlayerLevel var3 = (PlayerLevel)var1;
         if(!zzw.equal(Integer.valueOf(var3.getLevelNumber()), Integer.valueOf(this.getLevelNumber())) || !zzw.equal(Long.valueOf(var3.getMinXp()), Long.valueOf(this.getMinXp())) || !zzw.equal(Long.valueOf(var3.getMaxXp()), Long.valueOf(this.getMaxXp()))) {
            return false;
         }
      }

      return var2;
   }

   public int getLevelNumber() {
      return this.zzaDa;
   }

   public long getMaxXp() {
      return this.zzaDc;
   }

   public long getMinXp() {
      return this.zzaDb;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzaDa), Long.valueOf(this.zzaDb), Long.valueOf(this.zzaDc)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("LevelNumber", Integer.valueOf(this.getLevelNumber())).zzg("MinXp", Long.valueOf(this.getMinXp())).zzg("MaxXp", Long.valueOf(this.getMaxXp())).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelCreator.zza(this, var1, var2);
   }
}
