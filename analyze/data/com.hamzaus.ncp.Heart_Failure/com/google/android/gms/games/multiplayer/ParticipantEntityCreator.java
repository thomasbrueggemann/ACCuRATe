package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity, android.os.Parcel, int) void
   static void method_2860(ParticipantEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getParticipantId(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.getDisplayName(), false);
      class_599.method_3365(var1, 3, var0.getIconImageUri(), var2, false);
      class_599.method_3365(var1, 4, var0.getHiResImageUri(), var2, false);
      class_599.method_3381(var1, 5, var0.getStatus());
      class_599.method_3369(var1, 6, var0.method_232(), false);
      class_599.method_3372(var1, 7, var0.isConnectedToRoom());
      class_599.method_3365(var1, 8, var0.getPlayer(), var2, false);
      class_599.method_3381(var1, 9, var0.getCapabilities());
      class_599.method_3365(var1, 10, var0.getResult(), var2, false);
      class_599.method_3369(var1, 11, var0.getIconImageUrl(), false);
      class_599.method_3369(var1, 12, var0.getHiResImageUrl(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bm (android.os.Parcel) com.google.android.gms.games.multiplayer.ParticipantEntity
   public ParticipantEntity method_2861(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      Uri var6 = null;
      Uri var7 = null;
      int var8 = 0;
      String var9 = null;
      boolean var10 = false;
      PlayerEntity var11 = null;
      int var12 = 0;
      ParticipantResult var13 = null;
      String var14 = null;
      String var15 = null;

      while(var1.dataPosition() < var2) {
         int var16 = class_600.method_3383(var1);
         switch(class_600.method_3394(var16)) {
         case 1:
            var4 = class_600.method_3410(var1, var16);
            break;
         case 2:
            var5 = class_600.method_3410(var1, var16);
            break;
         case 3:
            var6 = (Uri)class_600.method_3390(var1, var16, Uri.CREATOR);
            break;
         case 4:
            var7 = (Uri)class_600.method_3390(var1, var16, Uri.CREATOR);
            break;
         case 5:
            var8 = class_600.method_3402(var1, var16);
            break;
         case 6:
            var9 = class_600.method_3410(var1, var16);
            break;
         case 7:
            var10 = class_600.method_3398(var1, var16);
            break;
         case 8:
            var11 = (PlayerEntity)class_600.method_3390(var1, var16, PlayerEntity.CREATOR);
            break;
         case 9:
            var12 = class_600.method_3402(var1, var16);
            break;
         case 10:
            var13 = (ParticipantResult)class_600.method_3390(var1, var16, ParticipantResult.CREATOR);
            break;
         case 11:
            var14 = class_600.method_3410(var1, var16);
            break;
         case 12:
            var15 = class_600.method_3410(var1, var16);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var16);
            break;
         default:
            class_600.method_3395(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new ParticipantEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2861(var1);
   }

   // $FF: renamed from: cy (int) com.google.android.gms.games.multiplayer.ParticipantEntity[]
   public ParticipantEntity[] method_2862(int var1) {
      return new ParticipantEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2862(var1);
   }
}
