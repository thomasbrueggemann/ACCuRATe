package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequestEntity, android.os.Parcel, int) void
   static void method_2683(GameRequestEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getGame(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3365(var1, 2, var0.getSender(), var2, false);
      class_599.method_3373(var1, 3, var0.getData(), false);
      class_599.method_3369(var1, 4, var0.getRequestId(), false);
      class_599.method_3380(var1, 5, var0.getRecipients(), false);
      class_599.method_3381(var1, 7, var0.getType());
      class_599.method_3361(var1, 9, var0.getCreationTimestamp());
      class_599.method_3361(var1, 10, var0.getExpirationTimestamp());
      class_599.method_3362(var1, 11, var0.method_3279(), false);
      class_599.method_3381(var1, 12, var0.getStatus());
      class_599.method_3357(var1, var3);
   }

   public GameRequestEntity createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      GameEntity var4 = null;
      PlayerEntity var5 = null;
      byte[] var6 = null;
      String var7 = null;
      ArrayList var8 = null;
      int var9 = 0;
      long var10 = 0L;
      long var12 = 0L;
      Bundle var14 = null;
      int var15 = 0;

      while(var1.dataPosition() < var2) {
         int var16 = class_600.method_3383(var1);
         switch(class_600.method_3394(var16)) {
         case 1:
            var4 = (GameEntity)class_600.method_3390(var1, var16, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)class_600.method_3390(var1, var16, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = class_600.method_3413(var1, var16);
            break;
         case 4:
            var7 = class_600.method_3410(var1, var16);
            break;
         case 5:
            var8 = class_600.method_3397(var1, var16, PlayerEntity.CREATOR);
            break;
         case 7:
            var9 = class_600.method_3402(var1, var16);
            break;
         case 9:
            var10 = class_600.method_3404(var1, var16);
            break;
         case 10:
            var12 = class_600.method_3404(var1, var16);
            break;
         case 11:
            var14 = class_600.method_3412(var1, var16);
            break;
         case 12:
            var15 = class_600.method_3402(var1, var16);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var16);
            break;
         default:
            class_600.method_3395(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new GameRequestEntity(var3, var4, var5, var6, var7, var8, var9, var10, var12, var14, var15);
      }
   }

   public GameRequestEntity[] newArray(int var1) {
      return new GameRequestEntity[var1];
   }
}
