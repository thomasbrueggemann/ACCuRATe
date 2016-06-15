package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.PlayerLevel;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.PlayerLevel, android.os.Parcel, int) void
   static void method_3465(PlayerLevel var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getLevelNumber());
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.getMinXp());
      class_599.method_3361(var1, 3, var0.getMaxXp());
      class_599.method_3357(var1, var3);
   }

   public PlayerLevel createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      int var5 = class_600.method_3385(var1);
      long var6 = var2;
      int var8 = 0;

      while(var1.dataPosition() < var5) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var4 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var6 = class_600.method_3404(var1, var9);
            break;
         case 3:
            var2 = class_600.method_3404(var1, var9);
            break;
         case 1000:
            var8 = class_600.method_3402(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_600.class_1103("Overread allowed size end=" + var5, var1);
      } else {
         return new PlayerLevel(var8, var4, var6, var2);
      }
   }

   public PlayerLevel[] newArray(int var1) {
      return new PlayerLevel[var1];
   }
}
