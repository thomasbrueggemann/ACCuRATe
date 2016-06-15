package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.QuestEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.quest.QuestEntity, android.os.Parcel, int) void
   static void method_3466(QuestEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getGame(), var2, false);
      class_599.method_3369(var1, 2, var0.getQuestId(), false);
      class_599.method_3361(var1, 3, var0.getAcceptedTimestamp());
      class_599.method_3365(var1, 4, var0.getBannerImageUri(), var2, false);
      class_599.method_3369(var1, 5, var0.getBannerImageUrl(), false);
      class_599.method_3369(var1, 6, var0.getDescription(), false);
      class_599.method_3361(var1, 7, var0.getEndTimestamp());
      class_599.method_3361(var1, 8, var0.getLastUpdatedTimestamp());
      class_599.method_3365(var1, 9, var0.getIconImageUri(), var2, false);
      class_599.method_3369(var1, 10, var0.getIconImageUrl(), false);
      class_599.method_3369(var1, 12, var0.getName(), false);
      class_599.method_3361(var1, 13, var0.method_235());
      class_599.method_3361(var1, 14, var0.getStartTimestamp());
      class_599.method_3381(var1, 15, var0.getState());
      class_599.method_3380(var1, 17, var0.method_234(), false);
      class_599.method_3381(var1, 16, var0.getType());
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3357(var1, var3);
   }

   public QuestEntity createFromParcel(Parcel var1) {
      int var2 = class_600.method_3385(var1);
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
         int var25 = class_600.method_3383(var1);
         switch(class_600.method_3394(var25)) {
         case 1:
            var4 = (GameEntity)class_600.method_3390(var1, var25, GameEntity.CREATOR);
            break;
         case 2:
            var5 = class_600.method_3410(var1, var25);
            break;
         case 3:
            var6 = class_600.method_3404(var1, var25);
            break;
         case 4:
            var8 = (Uri)class_600.method_3390(var1, var25, Uri.CREATOR);
            break;
         case 5:
            var9 = class_600.method_3410(var1, var25);
            break;
         case 6:
            var10 = class_600.method_3410(var1, var25);
            break;
         case 7:
            var11 = class_600.method_3404(var1, var25);
            break;
         case 8:
            var13 = class_600.method_3404(var1, var25);
            break;
         case 9:
            var15 = (Uri)class_600.method_3390(var1, var25, Uri.CREATOR);
            break;
         case 10:
            var16 = class_600.method_3410(var1, var25);
            break;
         case 12:
            var17 = class_600.method_3410(var1, var25);
            break;
         case 13:
            var18 = class_600.method_3404(var1, var25);
            break;
         case 14:
            var20 = class_600.method_3404(var1, var25);
            break;
         case 15:
            var22 = class_600.method_3402(var1, var25);
            break;
         case 16:
            var23 = class_600.method_3402(var1, var25);
            break;
         case 17:
            var24 = class_600.method_3397(var1, var25, MilestoneEntity.CREATOR);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var25);
            break;
         default:
            class_600.method_3395(var1, var25);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new QuestEntity(var3, var4, var5, var6, var8, var9, var10, var11, var13, var15, var16, var17, var18, var20, var22, var23, var24);
      }
   }

   public QuestEntity[] newArray(int var1) {
      return new QuestEntity[var1];
   }
}
