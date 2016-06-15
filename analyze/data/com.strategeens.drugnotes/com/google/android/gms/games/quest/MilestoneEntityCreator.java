package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.quest.MilestoneEntity;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.quest.MilestoneEntity, android.os.Parcel, int) void
   static void method_4102(MilestoneEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getMilestoneId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.getCurrentProgress());
      class_704.method_4030(var1, 3, var0.getTargetProgress());
      class_704.method_4042(var1, 4, var0.getCompletionRewardData(), false);
      class_704.method_4050(var1, 5, var0.getState());
      class_704.method_4038(var1, 6, var0.getEventId(), false);
      class_704.method_4026(var1, var3);
   }

   public MilestoneEntity createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      String var5 = null;
      int var6 = class_705.method_4059(var1);
      byte[] var7 = null;
      long var8 = var2;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var6) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var10 = class_705.method_4081(var1, var12);
            break;
         case 2:
            var8 = class_705.method_4075(var1, var12);
            break;
         case 3:
            var2 = class_705.method_4075(var1, var12);
            break;
         case 4:
            var7 = class_705.method_4084(var1, var12);
            break;
         case 5:
            var4 = class_705.method_4073(var1, var12);
            break;
         case 6:
            var5 = class_705.method_4081(var1, var12);
            break;
         case 1000:
            var11 = class_705.method_4073(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new class_705.class_1425("Overread allowed size end=" + var6, var1);
      } else {
         return new MilestoneEntity(var11, var10, var8, var2, var7, var4, var5);
      }
   }

   public MilestoneEntity[] newArray(int var1) {
      return new MilestoneEntity[var1];
   }
}
