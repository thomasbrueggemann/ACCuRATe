package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.PlayerLevelInfo, android.os.Parcel, int) void
   static void method_4624(PlayerLevelInfo var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4030(var1, 1, var0.getCurrentXpTotal());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.getLastLevelUpTimestamp());
      class_704.method_4034(var1, 3, var0.getCurrentLevel(), var2, false);
      class_704.method_4034(var1, 4, var0.getNextLevel(), var2, false);
      class_704.method_4026(var1, var3);
   }

   public PlayerLevelInfo createFromParcel(Parcel var1) {
      long var2 = 0L;
      PlayerLevel var4 = null;
      int var5 = class_705.method_4059(var1);
      int var6 = 0;
      PlayerLevel var7 = null;
      long var8 = var2;

      while(var1.dataPosition() < var5) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var8 = class_705.method_4075(var1, var10);
            break;
         case 2:
            var2 = class_705.method_4075(var1, var10);
            break;
         case 3:
            var7 = (PlayerLevel)class_705.method_4061(var1, var10, PlayerLevel.CREATOR);
            break;
         case 4:
            var4 = (PlayerLevel)class_705.method_4061(var1, var10, PlayerLevel.CREATOR);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_705.class_1425("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevelInfo(var6, var8, var2, var7, var4);
      }
   }

   public PlayerLevelInfo[] newArray(int var1) {
      return new PlayerLevelInfo[var1];
   }
}
