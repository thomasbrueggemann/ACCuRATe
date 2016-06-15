package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.PlayerLevelInfo, android.os.Parcel, int) void
   static void method_3668(PlayerLevelInfo var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3361(var1, 1, var0.getCurrentXpTotal());
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.getLastLevelUpTimestamp());
      class_599.method_3365(var1, 3, var0.getCurrentLevel(), var2, false);
      class_599.method_3365(var1, 4, var0.getNextLevel(), var2, false);
      class_599.method_3357(var1, var3);
   }

   public PlayerLevelInfo createFromParcel(Parcel var1) {
      long var2 = 0L;
      PlayerLevel var4 = null;
      int var5 = class_600.method_3385(var1);
      int var6 = 0;
      PlayerLevel var7 = null;
      long var8 = var2;

      while(var1.dataPosition() < var5) {
         int var10 = class_600.method_3383(var1);
         switch(class_600.method_3394(var10)) {
         case 1:
            var8 = class_600.method_3404(var1, var10);
            break;
         case 2:
            var2 = class_600.method_3404(var1, var10);
            break;
         case 3:
            var7 = (PlayerLevel)class_600.method_3390(var1, var10, PlayerLevel.CREATOR);
            break;
         case 4:
            var4 = (PlayerLevel)class_600.method_3390(var1, var10, PlayerLevel.CREATOR);
            break;
         case 1000:
            var6 = class_600.method_3402(var1, var10);
            break;
         default:
            class_600.method_3395(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_600.class_1103("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevelInfo(var6, var8, var2, var7, var4);
      }
   }

   public PlayerLevelInfo[] newArray(int var1) {
      return new PlayerLevelInfo[var1];
   }
}
