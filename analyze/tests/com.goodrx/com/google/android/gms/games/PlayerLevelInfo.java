package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfoCreator;

public final class PlayerLevelInfo implements SafeParcelable {
   public static final Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
   private final int mVersionCode;
   private final long zzaDd;
   private final long zzaDe;
   private final PlayerLevel zzaDf;
   private final PlayerLevel zzaDg;

   PlayerLevelInfo(int var1, long var2, long var4, PlayerLevel var6, PlayerLevel var7) {
      boolean var8;
      if(var2 != -1L) {
         var8 = true;
      } else {
         var8 = false;
      }

      zzx.zzab(var8);
      zzx.zzz(var6);
      zzx.zzz(var7);
      this.mVersionCode = var1;
      this.zzaDd = var2;
      this.zzaDe = var4;
      this.zzaDf = var6;
      this.zzaDg = var7;
   }

   public PlayerLevelInfo(long var1, long var3, PlayerLevel var5, PlayerLevel var6) {
      this(1, var1, var3, var5, var6);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof PlayerLevelInfo)) {
         var2 = false;
      } else if(var1 != this) {
         PlayerLevelInfo var3 = (PlayerLevelInfo)var1;
         if(!zzw.equal(Long.valueOf(this.zzaDd), Long.valueOf(var3.zzaDd)) || !zzw.equal(Long.valueOf(this.zzaDe), Long.valueOf(var3.zzaDe)) || !zzw.equal(this.zzaDf, var3.zzaDf) || !zzw.equal(this.zzaDg, var3.zzaDg)) {
            return false;
         }
      }

      return var2;
   }

   public PlayerLevel getCurrentLevel() {
      return this.zzaDf;
   }

   public long getCurrentXpTotal() {
      return this.zzaDd;
   }

   public long getLastLevelUpTimestamp() {
      return this.zzaDe;
   }

   public PlayerLevel getNextLevel() {
      return this.zzaDg;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzaDd), Long.valueOf(this.zzaDe), this.zzaDf, this.zzaDg};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelInfoCreator.zza(this, var1, var2);
   }
}
