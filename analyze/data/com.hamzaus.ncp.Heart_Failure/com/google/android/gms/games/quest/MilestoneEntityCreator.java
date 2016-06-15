package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.quest.MilestoneEntity;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.quest.MilestoneEntity, android.os.Parcel, int) void
   static void method_3433(MilestoneEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getMilestoneId(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.getCurrentProgress());
      class_599.method_3361(var1, 3, var0.getTargetProgress());
      class_599.method_3373(var1, 4, var0.getCompletionRewardData(), false);
      class_599.method_3381(var1, 5, var0.getState());
      class_599.method_3369(var1, 6, var0.getEventId(), false);
      class_599.method_3357(var1, var3);
   }

   public MilestoneEntity createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      String var5 = null;
      int var6 = class_600.method_3385(var1);
      byte[] var7 = null;
      long var8 = var2;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var6) {
         int var12 = class_600.method_3383(var1);
         switch(class_600.method_3394(var12)) {
         case 1:
            var10 = class_600.method_3410(var1, var12);
            break;
         case 2:
            var8 = class_600.method_3404(var1, var12);
            break;
         case 3:
            var2 = class_600.method_3404(var1, var12);
            break;
         case 4:
            var7 = class_600.method_3413(var1, var12);
            break;
         case 5:
            var4 = class_600.method_3402(var1, var12);
            break;
         case 6:
            var5 = class_600.method_3410(var1, var12);
            break;
         case 1000:
            var11 = class_600.method_3402(var1, var12);
            break;
         default:
            class_600.method_3395(var1, var12);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new class_600.class_1103("Overread allowed size end=" + var6, var1);
      } else {
         return new MilestoneEntity(var11, var10, var8, var2, var7, var4, var5);
      }
   }

   public MilestoneEntity[] newArray(int var1) {
      return new MilestoneEntity[var1];
   }
}
