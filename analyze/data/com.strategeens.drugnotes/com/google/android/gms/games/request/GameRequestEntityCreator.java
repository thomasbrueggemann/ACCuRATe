package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.request.GameRequestEntity, android.os.Parcel, int) void
   static void method_3040(GameRequestEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getGame(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getSender(), var2, false);
      class_704.method_4042(var1, 3, var0.getData(), false);
      class_704.method_4038(var1, 4, var0.getRequestId(), false);
      class_704.method_4051(var1, 5, var0.getRecipients(), false);
      class_704.method_4050(var1, 7, var0.getType());
      class_704.method_4030(var1, 9, var0.getCreationTimestamp());
      class_704.method_4030(var1, 10, var0.getExpirationTimestamp());
      class_704.method_4031(var1, 11, var0.method_3893(), false);
      class_704.method_4050(var1, 12, var0.getStatus());
      class_704.method_4026(var1, var3);
   }

   public GameRequestEntity createFromParcel(Parcel var1) {
      int var2 = class_705.method_4059(var1);
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
         int var16 = class_705.method_4058(var1);
         switch(class_705.method_4065(var16)) {
         case 1:
            var4 = (GameEntity)class_705.method_4061(var1, var16, GameEntity.CREATOR);
            break;
         case 2:
            var5 = (PlayerEntity)class_705.method_4061(var1, var16, PlayerEntity.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4084(var1, var16);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var16);
            break;
         case 5:
            var8 = class_705.method_4068(var1, var16, PlayerEntity.CREATOR);
            break;
         case 7:
            var9 = class_705.method_4073(var1, var16);
            break;
         case 9:
            var10 = class_705.method_4075(var1, var16);
            break;
         case 10:
            var12 = class_705.method_4075(var1, var16);
            break;
         case 11:
            var14 = class_705.method_4083(var1, var16);
            break;
         case 12:
            var15 = class_705.method_4073(var1, var16);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var16);
            break;
         default:
            class_705.method_4066(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new GameRequestEntity(var3, var4, var5, var6, var7, var8, var9, var10, var12, var14, var15);
      }
   }

   public GameRequestEntity[] newArray(int var1) {
      return new GameRequestEntity[var1];
   }
}
