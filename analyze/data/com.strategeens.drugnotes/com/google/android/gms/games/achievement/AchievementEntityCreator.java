package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.achievement.AchievementEntity, android.os.Parcel, int) void
   static void method_3165(AchievementEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getAchievementId(), false);
      class_704.method_4050(var1, 2, var0.getType());
      class_704.method_4038(var1, 3, var0.getName(), false);
      class_704.method_4038(var1, 4, var0.getDescription(), false);
      class_704.method_4034(var1, 5, var0.getUnlockedImageUri(), var2, false);
      class_704.method_4038(var1, 6, var0.getUnlockedImageUrl(), false);
      class_704.method_4034(var1, 7, var0.getRevealedImageUri(), var2, false);
      class_704.method_4038(var1, 8, var0.getRevealedImageUrl(), false);
      class_704.method_4050(var1, 9, var0.getTotalSteps());
      class_704.method_4038(var1, 10, var0.getFormattedTotalSteps(), false);
      class_704.method_4034(var1, 11, var0.getPlayer(), var2, false);
      class_704.method_4050(var1, 12, var0.getState());
      class_704.method_4050(var1, 13, var0.getCurrentSteps());
      class_704.method_4038(var1, 14, var0.getFormattedCurrentSteps(), false);
      class_704.method_4030(var1, 15, var0.getLastUpdatedTimestamp());
      class_704.method_4030(var1, 16, var0.getXpValue());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4026(var1, var3);
   }

   public AchievementEntity createFromParcel(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      Uri var8 = null;
      String var9 = null;
      Uri var10 = null;
      String var11 = null;
      int var12 = 0;
      String var13 = null;
      PlayerEntity var14 = null;
      int var15 = 0;
      int var16 = 0;
      String var17 = null;
      long var18 = 0L;
      long var20 = 0L;

      while(var1.dataPosition() < var2) {
         int var22 = class_705.method_4058(var1);
         switch(class_705.method_4065(var22)) {
         case 1:
            var4 = class_705.method_4081(var1, var22);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var22);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var22);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var22);
            break;
         case 5:
            var8 = (Uri)class_705.method_4061(var1, var22, Uri.CREATOR);
            break;
         case 6:
            var9 = class_705.method_4081(var1, var22);
            break;
         case 7:
            var10 = (Uri)class_705.method_4061(var1, var22, Uri.CREATOR);
            break;
         case 8:
            var11 = class_705.method_4081(var1, var22);
            break;
         case 9:
            var12 = class_705.method_4073(var1, var22);
            break;
         case 10:
            var13 = class_705.method_4081(var1, var22);
            break;
         case 11:
            var14 = (PlayerEntity)class_705.method_4061(var1, var22, PlayerEntity.CREATOR);
            break;
         case 12:
            var15 = class_705.method_4073(var1, var22);
            break;
         case 13:
            var16 = class_705.method_4073(var1, var22);
            break;
         case 14:
            var17 = class_705.method_4081(var1, var22);
            break;
         case 15:
            var18 = class_705.method_4075(var1, var22);
            break;
         case 16:
            var20 = class_705.method_4075(var1, var22);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var22);
            break;
         default:
            class_705.method_4066(var1, var22);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new AchievementEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var20);
      }
   }

   public AchievementEntity[] newArray(int var1) {
      return new AchievementEntity[var1];
   }
}
