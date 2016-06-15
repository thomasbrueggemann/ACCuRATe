package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.PlayerLevelCreator;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_349;

public final class PlayerLevel implements SafeParcelable {
   public static final PlayerLevelCreator CREATOR = new PlayerLevelCreator();
   // $FF: renamed from: MW int
   private final int field_4091;
   // $FF: renamed from: MX long
   private final long field_4092;
   // $FF: renamed from: MY long
   private final long field_4093;
   // $FF: renamed from: xJ int
   private final int field_4094;

   PlayerLevel(int var1, int var2, long var3, long var5) {
      boolean var7 = true;
      super();
      boolean var8;
      if(var3 >= 0L) {
         var8 = var7;
      } else {
         var8 = false;
      }

      class_347.method_2161(var8, "Min XP must be positive!");
      if(var5 <= var3) {
         var7 = false;
      }

      class_347.method_2161(var7, "Max XP must be more than min XP!");
      this.field_4094 = var1;
      this.field_4091 = var2;
      this.field_4092 = var3;
      this.field_4093 = var5;
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
         if(!class_349.equal(Integer.valueOf(var3.getLevelNumber()), Integer.valueOf(this.getLevelNumber())) || !class_349.equal(Long.valueOf(var3.getMinXp()), Long.valueOf(this.getMinXp())) || !class_349.equal(Long.valueOf(var3.getMaxXp()), Long.valueOf(this.getMaxXp()))) {
            return false;
         }
      }

      return var2;
   }

   public int getLevelNumber() {
      return this.field_4091;
   }

   public long getMaxXp() {
      return this.field_4093;
   }

   public long getMinXp() {
      return this.field_4092;
   }

   public int getVersionCode() {
      return this.field_4094;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_4091), Long.valueOf(this.field_4092), Long.valueOf(this.field_4093)};
      return class_349.hashCode(var1);
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("LevelNumber", Integer.valueOf(this.getLevelNumber())).method_4301("MinXp", Long.valueOf(this.getMinXp())).method_4301("MaxXp", Long.valueOf(this.getMaxXp())).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      PlayerLevelCreator.method_3465(this, var1, var2);
   }
}
