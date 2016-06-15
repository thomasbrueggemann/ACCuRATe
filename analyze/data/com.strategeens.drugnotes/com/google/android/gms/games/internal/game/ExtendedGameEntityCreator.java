package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadgeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.game.ExtendedGameEntity, android.os.Parcel, int) void
   static void method_5449(ExtendedGameEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.method_2382(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.method_267());
      class_704.method_4041(var1, 3, var0.method_268());
      class_704.method_4050(var1, 4, var0.method_269());
      class_704.method_4030(var1, 5, var0.method_270());
      class_704.method_4030(var1, 6, var0.method_271());
      class_704.method_4038(var1, 7, var0.method_272(), false);
      class_704.method_4030(var1, 8, var0.method_273());
      class_704.method_4038(var1, 9, var0.method_274(), false);
      class_704.method_4051(var1, 10, var0.method_266(), false);
      class_704.method_4034(var1, 11, var0.method_275(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5450(var1);
   }

   // $FF: renamed from: cu (android.os.Parcel) com.google.android.gms.games.internal.game.ExtendedGameEntity
   public ExtendedGameEntity method_5450(Parcel var1) {
      int var2 = class_705.method_4059(var1);
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
         int var18 = class_705.method_4058(var1);
         switch(class_705.method_4065(var18)) {
         case 1:
            var4 = (GameEntity)class_705.method_4061(var1, var18, GameEntity.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var18);
            break;
         case 3:
            var6 = class_705.method_4069(var1, var18);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var18);
            break;
         case 5:
            var8 = class_705.method_4075(var1, var18);
            break;
         case 6:
            var10 = class_705.method_4075(var1, var18);
            break;
         case 7:
            var12 = class_705.method_4081(var1, var18);
            break;
         case 8:
            var13 = class_705.method_4075(var1, var18);
            break;
         case 9:
            var15 = class_705.method_4081(var1, var18);
            break;
         case 10:
            var16 = class_705.method_4068(var1, var18, GameBadgeEntity.CREATOR);
            break;
         case 11:
            var17 = (SnapshotMetadataEntity)class_705.method_4061(var1, var18, SnapshotMetadataEntity.CREATOR);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var18);
            break;
         default:
            class_705.method_4066(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new ExtendedGameEntity(var3, var4, var5, var6, var7, var8, var10, var12, var13, var15, var16, var17);
      }
   }

   // $FF: renamed from: eb (int) com.google.android.gms.games.internal.game.ExtendedGameEntity[]
   public ExtendedGameEntity[] method_5451(int var1) {
      return new ExtendedGameEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5451(var1);
   }
}
