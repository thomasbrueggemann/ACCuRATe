package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.realtime.RoomEntity, android.os.Parcel, int) void
   static void method_3897(RoomEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getRoomId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getCreatorId(), false);
      class_704.method_4030(var1, 3, var0.getCreationTimestamp());
      class_704.method_4050(var1, 4, var0.getStatus());
      class_704.method_4038(var1, 5, var0.getDescription(), false);
      class_704.method_4050(var1, 6, var0.getVariant());
      class_704.method_4031(var1, 7, var0.getAutoMatchCriteria(), false);
      class_704.method_4051(var1, 8, var0.getParticipants(), false);
      class_704.method_4050(var1, 9, var0.getAutoMatchWaitEstimateSeconds());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cC (android.os.Parcel) com.google.android.gms.games.multiplayer.realtime.RoomEntity
   public RoomEntity method_3898(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      long var5 = 0L;
      Bundle var7 = null;
      int var8 = 0;
      String var9 = null;
      int var10 = 0;
      String var11 = null;
      String var12 = null;
      int var13 = 0;

      while(var1.dataPosition() < var4) {
         int var14 = class_705.method_4058(var1);
         switch(class_705.method_4065(var14)) {
         case 1:
            var12 = class_705.method_4081(var1, var14);
            break;
         case 2:
            var11 = class_705.method_4081(var1, var14);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var14);
            break;
         case 4:
            var10 = class_705.method_4073(var1, var14);
            break;
         case 5:
            var9 = class_705.method_4081(var1, var14);
            break;
         case 6:
            var8 = class_705.method_4073(var1, var14);
            break;
         case 7:
            var7 = class_705.method_4083(var1, var14);
            break;
         case 8:
            var3 = class_705.method_4068(var1, var14, ParticipantEntity.CREATOR);
            break;
         case 9:
            var2 = class_705.method_4073(var1, var14);
            break;
         case 1000:
            var13 = class_705.method_4073(var1, var14);
            break;
         default:
            class_705.method_4066(var1, var14);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new RoomEntity(var13, var12, var11, var5, var10, var9, var8, var7, var3, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3898(var1);
   }

   // $FF: renamed from: eo (int) com.google.android.gms.games.multiplayer.realtime.RoomEntity[]
   public RoomEntity[] method_3899(int var1) {
      return new RoomEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3899(var1);
   }
}
