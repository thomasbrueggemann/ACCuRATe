package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfoCreator;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;

public final class PlayerLevelInfo implements SafeParcelable {
   public static final PlayerLevelInfoCreator CREATOR = new PlayerLevelInfoCreator();
   // $FF: renamed from: MZ long
   private final long field_2763;
   // $FF: renamed from: Na long
   private final long field_2764;
   // $FF: renamed from: Nb com.google.android.gms.games.PlayerLevel
   private final PlayerLevel field_2765;
   // $FF: renamed from: Nc com.google.android.gms.games.PlayerLevel
   private final PlayerLevel field_2766;
   // $FF: renamed from: xJ int
   private final int field_2767;

   PlayerLevelInfo(int var1, long var2, long var4, PlayerLevel var6, PlayerLevel var7) {
      boolean var8;
      if(var2 != -1L) {
         var8 = true;
      } else {
         var8 = false;
      }

      class_347.method_2159(var8);
      class_347.method_2170(var6);
      class_347.method_2170(var7);
      this.field_2767 = var1;
      this.field_2763 = var2;
      this.field_2764 = var4;
      this.field_2765 = var6;
      this.field_2766 = var7;
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
         if(!class_349.equal(Long.valueOf(this.field_2763), Long.valueOf(var3.field_2763)) || !class_349.equal(Long.valueOf(this.field_2764), Long.valueOf(var3.field_2764)) || !class_349.equal(this.field_2765, var3.field_2765) || !class_349.equal(this.field_2766, var3.field_2766)) {
            return false;
         }
      }

      return var2;
   }

   public PlayerLevel getCurrentLevel() {
      return this.field_2765;
   }

   public long getCurrentXpTotal() {
      return this.field_2763;
   }

   public long getLastLevelUpTimestamp() {
      return this.field_2764;
   }

   public PlayerLevel getNextLevel() {
      return this.field_2766;
   }

   public int getVersionCode() {
      return this.field_2767;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.field_2763), Long.valueOf(this.field_2764), this.field_2765, this.field_2766};
      return class_349.hashCode(var1);
   }

   public boolean isMaxLevel() {
      return this.field_2765.equals(this.field_2766);
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelInfoCreator.method_3668(this, var1, var2);
   }
}
