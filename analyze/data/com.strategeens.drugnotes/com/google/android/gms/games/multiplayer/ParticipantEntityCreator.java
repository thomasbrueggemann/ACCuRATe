package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantEntity, android.os.Parcel, int) void
   static void method_3418(ParticipantEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getParticipantId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getDisplayName(), false);
      class_704.method_4034(var1, 3, var0.getIconImageUri(), var2, false);
      class_704.method_4034(var1, 4, var0.getHiResImageUri(), var2, false);
      class_704.method_4050(var1, 5, var0.getStatus());
      class_704.method_4038(var1, 6, var0.method_257(), false);
      class_704.method_4041(var1, 7, var0.isConnectedToRoom());
      class_704.method_4034(var1, 8, var0.getPlayer(), var2, false);
      class_704.method_4050(var1, 9, var0.getCapabilities());
      class_704.method_4034(var1, 10, var0.getResult(), var2, false);
      class_704.method_4038(var1, 11, var0.getIconImageUrl(), false);
      class_704.method_4038(var1, 12, var0.getHiResImageUrl(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cA (android.os.Parcel) com.google.android.gms.games.multiplayer.ParticipantEntity
   public ParticipantEntity method_3419(Parcel var1) {
      int var2 = class_705.method_4059(var1);
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
         int var16 = class_705.method_4058(var1);
         switch(class_705.method_4065(var16)) {
         case 1:
            var4 = class_705.method_4081(var1, var16);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var16);
            break;
         case 3:
            var6 = (Uri)class_705.method_4061(var1, var16, Uri.CREATOR);
            break;
         case 4:
            var7 = (Uri)class_705.method_4061(var1, var16, Uri.CREATOR);
            break;
         case 5:
            var8 = class_705.method_4073(var1, var16);
            break;
         case 6:
            var9 = class_705.method_4081(var1, var16);
            break;
         case 7:
            var10 = class_705.method_4069(var1, var16);
            break;
         case 8:
            var11 = (PlayerEntity)class_705.method_4061(var1, var16, PlayerEntity.CREATOR);
            break;
         case 9:
            var12 = class_705.method_4073(var1, var16);
            break;
         case 10:
            var13 = (ParticipantResult)class_705.method_4061(var1, var16, ParticipantResult.CREATOR);
            break;
         case 11:
            var14 = class_705.method_4081(var1, var16);
            break;
         case 12:
            var15 = class_705.method_4081(var1, var16);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var16);
            break;
         default:
            class_705.method_4066(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new ParticipantEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3419(var1);
   }

   // $FF: renamed from: em (int) com.google.android.gms.games.multiplayer.ParticipantEntity[]
   public ParticipantEntity[] method_3420(int var1) {
      return new ParticipantEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3420(var1);
   }
}
