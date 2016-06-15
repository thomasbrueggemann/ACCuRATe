package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity, android.os.Parcel, int) void
   static void method_3422(TurnBasedMatchEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getGame(), var2, false);
      class_599.method_3369(var1, 2, var0.getMatchId(), false);
      class_599.method_3369(var1, 3, var0.getCreatorId(), false);
      class_599.method_3361(var1, 4, var0.getCreationTimestamp());
      class_599.method_3369(var1, 5, var0.getLastUpdaterId(), false);
      class_599.method_3361(var1, 6, var0.getLastUpdatedTimestamp());
      class_599.method_3369(var1, 7, var0.getPendingParticipantId(), false);
      class_599.method_3381(var1, 8, var0.getStatus());
      class_599.method_3381(var1, 10, var0.getVariant());
      class_599.method_3381(var1, 11, var0.getVersion());
      class_599.method_3373(var1, 12, var0.getData(), false);
      class_599.method_3380(var1, 13, var0.getParticipants(), false);
      class_599.method_3369(var1, 14, var0.getRematchId(), false);
      class_599.method_3373(var1, 15, var0.getPreviousMatchData(), false);
      class_599.method_3362(var1, 17, var0.getAutoMatchCriteria(), false);
      class_599.method_3381(var1, 16, var0.getMatchNumber());
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3372(var1, 19, var0.isLocallyModified());
      class_599.method_3381(var1, 18, var0.getTurnStatus());
      class_599.method_3369(var1, 21, var0.getDescriptionParticipantId(), false);
      class_599.method_3369(var1, 20, var0.getDescription(), false);
      class_599.method_3357(var1, var3);
   }

   public TurnBasedMatchEntity createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      GameEntity var4 = null;
      String var5 = null;
      String var6 = null;
      long var7 = 0L;
      String var9 = null;
      long var10 = 0L;
      String var12 = null;
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      byte[] var16 = null;
      ArrayList var17 = null;
      String var18 = null;
      byte[] var19 = null;
      int var20 = 0;
      Bundle var21 = null;
      int var22 = 0;
      boolean var23 = false;
      String var24 = null;
      String var25 = null;

      while(var1.dataPosition() < var2) {
         int var26 = class_600.method_3383(var1);
         switch(class_600.method_3394(var26)) {
         case 1:
            var4 = (GameEntity)class_600.method_3390(var1, var26, GameEntity.CREATOR);
            break;
         case 2:
            var5 = class_600.method_3410(var1, var26);
            break;
         case 3:
            var6 = class_600.method_3410(var1, var26);
            break;
         case 4:
            var7 = class_600.method_3404(var1, var26);
            break;
         case 5:
            var9 = class_600.method_3410(var1, var26);
            break;
         case 6:
            var10 = class_600.method_3404(var1, var26);
            break;
         case 7:
            var12 = class_600.method_3410(var1, var26);
            break;
         case 8:
            var13 = class_600.method_3402(var1, var26);
            break;
         case 10:
            var14 = class_600.method_3402(var1, var26);
            break;
         case 11:
            var15 = class_600.method_3402(var1, var26);
            break;
         case 12:
            var16 = class_600.method_3413(var1, var26);
            break;
         case 13:
            var17 = class_600.method_3397(var1, var26, ParticipantEntity.CREATOR);
            break;
         case 14:
            var18 = class_600.method_3410(var1, var26);
            break;
         case 15:
            var19 = class_600.method_3413(var1, var26);
            break;
         case 16:
            var20 = class_600.method_3402(var1, var26);
            break;
         case 17:
            var21 = class_600.method_3412(var1, var26);
            break;
         case 18:
            var22 = class_600.method_3402(var1, var26);
            break;
         case 19:
            var23 = class_600.method_3398(var1, var26);
            break;
         case 20:
            var24 = class_600.method_3410(var1, var26);
            break;
         case 21:
            var25 = class_600.method_3410(var1, var26);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var26);
            break;
         default:
            class_600.method_3395(var1, var26);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new TurnBasedMatchEntity(var3, var4, var5, var6, var7, var9, var10, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25);
      }
   }

   public TurnBasedMatchEntity[] newArray(int var1) {
      return new TurnBasedMatchEntity[var1];
   }
}
