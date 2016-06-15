package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.PlayerEntity, android.os.Parcel, int) void
   static void method_3163(PlayerEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getPlayerId(), false);
      class_599.method_3369(var1, 2, var0.getDisplayName(), false);
      class_599.method_3365(var1, 3, var0.getIconImageUri(), var2, false);
      class_599.method_3365(var1, 4, var0.getHiResImageUri(), var2, false);
      class_599.method_3361(var1, 5, var0.getRetrievedTimestamp());
      class_599.method_3381(var1, 6, var0.method_226());
      class_599.method_3361(var1, 7, var0.getLastPlayedWithTimestamp());
      class_599.method_3369(var1, 8, var0.getIconImageUrl(), false);
      class_599.method_3369(var1, 9, var0.getHiResImageUrl(), false);
      class_599.method_3369(var1, 14, var0.getTitle(), false);
      class_599.method_3365(var1, 15, var0.method_228(), var2, false);
      class_599.method_3372(var1, 17, var0.method_227());
      class_599.method_3365(var1, 16, var0.getLevelInfo(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: be (android.os.Parcel) com.google.android.gms.games.PlayerEntity
   public PlayerEntity method_3164(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      Uri var6 = null;
      Uri var7 = null;
      long var8 = 0L;
      int var10 = 0;
      long var11 = 0L;
      String var13 = null;
      String var14 = null;
      String var15 = null;
      MostRecentGameInfoEntity var16 = null;
      PlayerLevelInfo var17 = null;
      boolean var18 = false;

      while(var1.dataPosition() < var2) {
         int var19 = class_600.method_3383(var1);
         switch(class_600.method_3394(var19)) {
         case 1:
            var4 = class_600.method_3410(var1, var19);
            break;
         case 2:
            var5 = class_600.method_3410(var1, var19);
            break;
         case 3:
            var6 = (Uri)class_600.method_3390(var1, var19, Uri.CREATOR);
            break;
         case 4:
            var7 = (Uri)class_600.method_3390(var1, var19, Uri.CREATOR);
            break;
         case 5:
            var8 = class_600.method_3404(var1, var19);
            break;
         case 6:
            var10 = class_600.method_3402(var1, var19);
            break;
         case 7:
            var11 = class_600.method_3404(var1, var19);
            break;
         case 8:
            var13 = class_600.method_3410(var1, var19);
            break;
         case 9:
            var14 = class_600.method_3410(var1, var19);
            break;
         case 14:
            var15 = class_600.method_3410(var1, var19);
            break;
         case 15:
            var16 = (MostRecentGameInfoEntity)class_600.method_3390(var1, var19, MostRecentGameInfoEntity.CREATOR);
            break;
         case 16:
            var17 = (PlayerLevelInfo)class_600.method_3390(var1, var19, PlayerLevelInfo.CREATOR);
            break;
         case 17:
            var18 = class_600.method_3398(var1, var19);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var19);
            break;
         default:
            class_600.method_3395(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new PlayerEntity(var3, var4, var5, var6, var7, var8, var10, var11, var13, var14, var15, var16, var17, var18);
      }
   }

   // $FF: renamed from: cc (int) com.google.android.gms.games.PlayerEntity[]
   public PlayerEntity[] method_3165(int var1) {
      return new PlayerEntity[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3164(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3165(var1);
   }
}
