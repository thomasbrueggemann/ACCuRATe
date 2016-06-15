package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.internal.game.GameBadgeEntity;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.game.GameBadgeEntity, android.os.Parcel, int) void
   static void method_5376(GameBadgeEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getType());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getTitle(), false);
      class_704.method_4038(var1, 3, var0.getDescription(), false);
      class_704.method_4034(var1, 4, var0.getIconImageUri(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5377(var1);
   }

   // $FF: renamed from: cv (android.os.Parcel) com.google.android.gms.games.internal.game.GameBadgeEntity
   public GameBadgeEntity method_5377(Parcel var1) {
      int var2 = 0;
      Uri var3 = null;
      int var4 = class_705.method_4059(var1);
      String var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var2 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var5 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var3 = (Uri)class_705.method_4061(var1, var8, Uri.CREATOR);
            break;
         case 1000:
            var7 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new GameBadgeEntity(var7, var2, var6, var5, var3);
      }
   }

   // $FF: renamed from: ed (int) com.google.android.gms.games.internal.game.GameBadgeEntity[]
   public GameBadgeEntity[] method_5378(int var1) {
      return new GameBadgeEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5378(var1);
   }
}
