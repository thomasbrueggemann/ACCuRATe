package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;

public class GameEntityCreator implements Creator<GameEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.GameEntity, android.os.Parcel, int) void
   static void method_3118(GameEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getApplicationId(), false);
      class_704.method_4038(var1, 2, var0.getDisplayName(), false);
      class_704.method_4038(var1, 3, var0.getPrimaryCategory(), false);
      class_704.method_4038(var1, 4, var0.getSecondaryCategory(), false);
      class_704.method_4038(var1, 5, var0.getDescription(), false);
      class_704.method_4038(var1, 6, var0.getDeveloperName(), false);
      class_704.method_4034(var1, 7, var0.getIconImageUri(), var2, false);
      class_704.method_4034(var1, 8, var0.getHiResImageUri(), var2, false);
      class_704.method_4034(var1, 9, var0.getFeaturedImageUri(), var2, false);
      class_704.method_4041(var1, 10, var0.method_232());
      class_704.method_4041(var1, 11, var0.method_229());
      class_704.method_4038(var1, 12, var0.method_230(), false);
      class_704.method_4050(var1, 13, var0.method_231());
      class_704.method_4050(var1, 14, var0.getAchievementTotalCount());
      class_704.method_4050(var1, 15, var0.getLeaderboardCount());
      class_704.method_4041(var1, 17, var0.isTurnBasedMultiplayerEnabled());
      class_704.method_4041(var1, 16, var0.isRealTimeMultiplayerEnabled());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 19, var0.getHiResImageUrl(), false);
      class_704.method_4038(var1, 18, var0.getIconImageUrl(), false);
      class_704.method_4041(var1, 21, var0.isMuted());
      class_704.method_4038(var1, 20, var0.getFeaturedImageUrl(), false);
      class_704.method_4041(var1, 23, var0.areSnapshotsEnabled());
      class_704.method_4041(var1, 22, var0.method_233());
      class_704.method_4038(var1, 24, var0.getThemeColor(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cl (android.os.Parcel) com.google.android.gms.games.GameEntity
   public GameEntity method_3119(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      Uri var10 = null;
      Uri var11 = null;
      Uri var12 = null;
      boolean var13 = false;
      boolean var14 = false;
      String var15 = null;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      boolean var19 = false;
      boolean var20 = false;
      String var21 = null;
      String var22 = null;
      String var23 = null;
      boolean var24 = false;
      boolean var25 = false;
      boolean var26 = false;
      String var27 = null;

      while(var1.dataPosition() < var2) {
         int var28 = class_705.method_4058(var1);
         switch(class_705.method_4065(var28)) {
         case 1:
            var4 = class_705.method_4081(var1, var28);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var28);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var28);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var28);
            break;
         case 5:
            var8 = class_705.method_4081(var1, var28);
            break;
         case 6:
            var9 = class_705.method_4081(var1, var28);
            break;
         case 7:
            var10 = (Uri)class_705.method_4061(var1, var28, Uri.CREATOR);
            break;
         case 8:
            var11 = (Uri)class_705.method_4061(var1, var28, Uri.CREATOR);
            break;
         case 9:
            var12 = (Uri)class_705.method_4061(var1, var28, Uri.CREATOR);
            break;
         case 10:
            var13 = class_705.method_4069(var1, var28);
            break;
         case 11:
            var14 = class_705.method_4069(var1, var28);
            break;
         case 12:
            var15 = class_705.method_4081(var1, var28);
            break;
         case 13:
            var16 = class_705.method_4073(var1, var28);
            break;
         case 14:
            var17 = class_705.method_4073(var1, var28);
            break;
         case 15:
            var18 = class_705.method_4073(var1, var28);
            break;
         case 16:
            var19 = class_705.method_4069(var1, var28);
            break;
         case 17:
            var20 = class_705.method_4069(var1, var28);
            break;
         case 18:
            var21 = class_705.method_4081(var1, var28);
            break;
         case 19:
            var22 = class_705.method_4081(var1, var28);
            break;
         case 20:
            var23 = class_705.method_4081(var1, var28);
            break;
         case 21:
            var24 = class_705.method_4069(var1, var28);
            break;
         case 22:
            var25 = class_705.method_4069(var1, var28);
            break;
         case 23:
            var26 = class_705.method_4069(var1, var28);
            break;
         case 24:
            var27 = class_705.method_4081(var1, var28);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var28);
            break;
         default:
            class_705.method_4066(var1, var28);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new GameEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3119(var1);
   }

   // $FF: renamed from: dG (int) com.google.android.gms.games.GameEntity[]
   public GameEntity[] method_3120(int var1) {
      return new GameEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3120(var1);
   }
}
