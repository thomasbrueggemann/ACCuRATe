package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGameEntity, android.os.Parcel, int) void
   static void method_4316(ExtendedGameEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.method_2194(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.method_237());
      class_599.method_3372(var1, 3, var0.method_238());
      class_599.method_3381(var1, 4, var0.method_239());
      class_599.method_3361(var1, 5, var0.method_240());
      class_599.method_3361(var1, 6, var0.method_241());
      class_599.method_3369(var1, 7, var0.method_242(), false);
      class_599.method_3361(var1, 8, var0.method_243());
      class_599.method_3369(var1, 9, var0.method_244(), false);
      class_599.method_3380(var1, 10, var0.method_236(), false);
      class_599.method_3365(var1, 11, var0.method_245(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bg (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
   public ExtendedGameEntity method_4317(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      GameEntity var4 = null;
      int var5 = 0;
      boolean var6 = false;
      int var7 = 0;
      long var8 = 0L;
      long var10 = 0L;
      String var12 = null;
      long var13 = 0L;
      String var15 = null;
      ArrayList var16 = null;
      SnapshotMetadataEntity var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = class_600.method_3383(var1);
         switch(class_600.method_3394(var18)) {
         case 1:
            var4 = (GameEntity)class_600.method_3390(var1, var18, GameEntity.CREATOR);
            break;
         case 2:
            var5 = class_600.method_3402(var1, var18);
            break;
         case 3:
            var6 = class_600.method_3398(var1, var18);
            break;
         case 4:
            var7 = class_600.method_3402(var1, var18);
            break;
         case 5:
            var8 = class_600.method_3404(var1, var18);
            break;
         case 6:
            var10 = class_600.method_3404(var1, var18);
            break;
         case 7:
            var12 = class_600.method_3410(var1, var18);
            break;
         case 8:
            var13 = class_600.method_3404(var1, var18);
            break;
         case 9:
            var15 = class_600.method_3410(var1, var18);
            break;
         case 10:
            var16 = class_600.method_3397(var1, var18, GameBadgeEntity.CREATOR);
            break;
         case 11:
            var17 = (SnapshotMetadataEntity)class_600.method_3390(var1, var18, SnapshotMetadataEntity.CREATOR);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var18);
            break;
         default:
            class_600.method_3395(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new ExtendedGameEntity(var3, var4, var5, var6, var7, var8, var10, var12, var13, var15, var16, var17);
      }
   }

   // $FF: renamed from: co (int) com.google.android.gms.games.internal.game.ExtendedGameEntity[]
   public ExtendedGameEntity[] method_4318(int var1) {
      return new ExtendedGameEntity[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4317(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4318(var1);
   }
}
