package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.InvitationEntity, android.os.Parcel, int) void
   static void method_3665(InvitationEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.getGame(), var2, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.getInvitationId(), false);
      class_599.method_3361(var1, 3, var0.getCreationTimestamp());
      class_599.method_3381(var1, 4, var0.getInvitationType());
      class_599.method_3365(var1, 5, var0.getInviter(), var2, false);
      class_599.method_3380(var1, 6, var0.getParticipants(), false);
      class_599.method_3381(var1, 7, var0.getVariant());
      class_599.method_3381(var1, 8, var0.getAvailableAutoMatchSlots());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bl (android.os.Parcel) com.google.android.gms.games.multiplayer.InvitationEntity
   public InvitationEntity method_3666(Parcel var1) {
      ArrayList var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      long var5 = 0L;
      int var7 = 0;
      ParticipantEntity var8 = null;
      int var9 = 0;
      String var10 = null;
      GameEntity var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_600.method_3383(var1);
         switch(class_600.method_3394(var13)) {
         case 1:
            var11 = (GameEntity)class_600.method_3390(var1, var13, GameEntity.CREATOR);
            break;
         case 2:
            var10 = class_600.method_3410(var1, var13);
            break;
         case 3:
            var5 = class_600.method_3404(var1, var13);
            break;
         case 4:
            var9 = class_600.method_3402(var1, var13);
            break;
         case 5:
            var8 = (ParticipantEntity)class_600.method_3390(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 6:
            var2 = class_600.method_3397(var1, var13, ParticipantEntity.CREATOR);
            break;
         case 7:
            var7 = class_600.method_3402(var1, var13);
            break;
         case 8:
            var3 = class_600.method_3402(var1, var13);
            break;
         case 1000:
            var12 = class_600.method_3402(var1, var13);
            break;
         default:
            class_600.method_3395(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new InvitationEntity(var12, var11, var10, var5, var9, var8, var2, var7, var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3666(var1);
   }

   // $FF: renamed from: cx (int) com.google.android.gms.games.multiplayer.InvitationEntity[]
   public InvitationEntity[] method_3667(int var1) {
      return new InvitationEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3667(var1);
   }
}
