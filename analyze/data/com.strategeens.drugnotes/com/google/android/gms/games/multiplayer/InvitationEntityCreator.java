package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.InvitationEntity, android.os.Parcel, int) void
   static void method_4479(InvitationEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getGame(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getInvitationId(), false);
      class_704.method_4030(var1, 3, var0.getCreationTimestamp());
      class_704.method_4050(var1, 4, var0.getInvitationType());
      class_704.method_4034(var1, 5, var0.getInviter(), var2, false);
      class_704.method_4051(var1, 6, var0.getParticipants(), false);
      class_704.method_4050(var1, 7, var0.getVariant());
      class_704.method_4050(var1, 8, var0.getAvailableAutoMatchSlots());
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4480(var1);
   }

   // $FF: renamed from: cz (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
   public InvitationEntity method_4480(Parcel var1) {
      ArrayList var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      int var7 = 0;
      ParticipantEntity var8 = null;
      int var9 = 0;
      String var10 = null;
      GameEntity var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var11 = (GameEntity)class_705.method_4061(var1, var13, GameEntity.CREATOR);
            break;
         case 2:
            var10 = class_705.method_4081(var1, var13);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var13);
            break;
         case 4:
            var9 = class_705.method_4073(var1, var13);
            break;
         case 5:
            var8 = (ParticipantEntity)class_705.method_4061(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 6:
            var2 = class_705.method_4068(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 7:
            var7 = class_705.method_4073(var1, var13);
            break;
         case 8:
            var3 = class_705.method_4073(var1, var13);
            break;
         case 1000:
            var12 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new InvitationEntity(var12, var11, var10, var5, var9, var8, var2, var7, var3);
      }
   }

   // $FF: renamed from: el (int) com.google.android.gms.games.multiplayer.InvitationEntity[]
   public InvitationEntity[] method_4481(int var1) {
      return new InvitationEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4481(var1);
   }
}
