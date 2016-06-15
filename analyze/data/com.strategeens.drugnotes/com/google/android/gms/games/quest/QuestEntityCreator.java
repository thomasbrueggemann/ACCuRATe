package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.quest.QuestEntity, android.os.Parcel, int) void
   static void method_4155(QuestEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getGame(), var2, false);
      class_704.method_4038(var1, 2, var0.getQuestId(), false);
      class_704.method_4030(var1, 3, var0.getAcceptedTimestamp());
      class_704.method_4034(var1, 4, var0.getBannerImageUri(), var2, false);
      class_704.method_4038(var1, 5, var0.getBannerImageUrl(), false);
      class_704.method_4038(var1, 6, var0.getDescription(), false);
      class_704.method_4030(var1, 7, var0.getEndTimestamp());
      class_704.method_4030(var1, 8, var0.getLastUpdatedTimestamp());
      class_704.method_4034(var1, 9, var0.getIconImageUri(), var2, false);
      class_704.method_4038(var1, 10, var0.getIconImageUrl(), false);
      class_704.method_4038(var1, 12, var0.getName(), false);
      class_704.method_4030(var1, 13, var0.method_265());
      class_704.method_4030(var1, 14, var0.getStartTimestamp());
      class_704.method_4050(var1, 15, var0.getState());
      class_704.method_4051(var1, 17, var0.method_264(), false);
      class_704.method_4050(var1, 16, var0.getType());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4026(var1, var3);
   }

   public QuestEntity createFromParcel(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      GameEntity var4 = null;
      String var5 = null;
      long var6 = 0L;
      Uri var8 = null;
      String var9 = null;
      String var10 = null;
      long var11 = 0L;
      long var13 = 0L;
      Uri var15 = null;
      String var16 = null;
      String var17 = null;
      long var18 = 0L;
      long var20 = 0L;
      int var22 = 0;
      int var23 = 0;
      ArrayList var24 = null;

      while(var1.dataPosition() < var2) {
         int var25 = class_705.method_4058(var1);
         switch(class_705.method_4065(var25)) {
         case 1:
            var4 = (GameEntity)class_705.method_4061(var1, var25, GameEntity.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var25);
            break;
         case 3:
            var6 = class_705.method_4075(var1, var25);
            break;
         case 4:
            var8 = (Uri)class_705.method_4061(var1, var25, Uri.CREATOR);
            break;
         case 5:
            var9 = class_705.method_4081(var1, var25);
            break;
         case 6:
            var10 = class_705.method_4081(var1, var25);
            break;
         case 7:
            var11 = class_705.method_4075(var1, var25);
            break;
         case 8:
            var13 = class_705.method_4075(var1, var25);
            break;
         case 9:
            var15 = (Uri)class_705.method_4061(var1, var25, Uri.CREATOR);
            break;
         case 10:
            var16 = class_705.method_4081(var1, var25);
            break;
         case 12:
            var17 = class_705.method_4081(var1, var25);
            break;
         case 13:
            var18 = class_705.method_4075(var1, var25);
            break;
         case 14:
            var20 = class_705.method_4075(var1, var25);
            break;
         case 15:
            var22 = class_705.method_4073(var1, var25);
            break;
         case 16:
            var23 = class_705.method_4073(var1, var25);
            break;
         case 17:
            var24 = class_705.method_4068(var1, var25, MilestoneEntity.CREATOR);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var25);
            break;
         default:
            class_705.method_4066(var1, var25);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new QuestEntity(var3, var4, var5, var6, var8, var9, var10, var11, var13, var15, var16, var17, var18, var20, var22, var23, var24);
      }
   }

   public QuestEntity[] newArray(int var1) {
      return new QuestEntity[var1];
   }
}
