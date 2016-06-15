package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfoCreator;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

public final class PlayerLevelInfo implements SafeParcelable {
   public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
   // $FF: renamed from: CK int
   private final int field_2567;
   // $FF: renamed from: Xr long
   private final long field_2568;
   // $FF: renamed from: Xs long
   private final long field_2569;
   // $FF: renamed from: Xt com.google.android.gms.games.PlayerLevel
   private final PlayerLevel field_2570;
   // $FF: renamed from: Xu com.google.android.gms.games.PlayerLevel
   private final PlayerLevel field_2571;

   PlayerLevelInfo(int var1, long var2, long var4, PlayerLevel var6, PlayerLevel var7) {
      boolean var8;
      if(var2 != -1L) {
         var8 = true;
      } else {
         var8 = false;
      }

      class_335.method_2300(var8);
      class_335.method_2311(var6);
      class_335.method_2311(var7);
      this.field_2567 = var1;
      this.field_2568 = var2;
      this.field_2569 = var4;
      this.field_2570 = var6;
      this.field_2571 = var7;
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
         if(!class_336.equal(Long.valueOf(this.field_2568), Long.valueOf(var3.field_2568)) || !class_336.equal(Long.valueOf(this.field_2569), Long.valueOf(var3.field_2569)) || !class_336.equal(this.field_2570, var3.field_2570) || !class_336.equal(this.field_2571, var3.field_2571)) {
            return false;
         }
      }

      return var2;
   }

   public PlayerLevel getCurrentLevel() {
      return this.field_2570;
   }

   public long getCurrentXpTotal() {
      return this.field_2568;
   }

   public long getLastLevelUpTimestamp() {
      return this.field_2569;
   }

   public PlayerLevel getNextLevel() {
      return this.field_2571;
   }

   public int getVersionCode() {
      return this.field_2567;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_2568), Long.valueOf(this.field_2569), this.field_2570, this.field_2571};
      return class_336.hashCode(var1);
   }

   public boolean isMaxLevel() {
      return this.field_2570.equals(this.field_2571);
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelInfoCreator.method_4624(this, var1, var2);
   }
}
