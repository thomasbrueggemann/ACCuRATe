package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.PlayerLevel;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.PlayerLevel, android.os.Parcel, int) void
   static void method_4143(PlayerLevel var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getLevelNumber());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.getMinXp());
      class_704.method_4030(var1, 3, var0.getMaxXp());
      class_704.method_4026(var1, var3);
   }

   public PlayerLevel createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = class_705.method_4059(var1);
      long var6 = var2;
      int var8 = 0;

      while(var1.dataPosition() < var5) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var4 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var6 = class_705.method_4075(var1, var9);
            break;
         case 3:
            var2 = class_705.method_4075(var1, var9);
            break;
         case 1000:
            var8 = class_705.method_4073(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_705.class_1425("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevel(var8, var4, var6, var2);
      }
   }

   public PlayerLevel[] newArray(int var1) {
      return new PlayerLevel[var1];
   }
}
