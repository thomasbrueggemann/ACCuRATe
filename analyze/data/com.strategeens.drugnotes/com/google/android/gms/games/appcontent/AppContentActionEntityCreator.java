package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentActionEntityCreator implements Creator<AppContentActionEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentActionEntity, android.os.Parcel, int) void
   static void method_3774(AppContentActionEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.method_226(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.method_227(), false);
      class_704.method_4031(var1, 3, var0.getExtras(), false);
      class_704.method_4038(var1, 4, var0.getLabel(), false);
      class_704.method_4038(var1, 5, var0.method_228(), false);
      class_704.method_4038(var1, 6, var0.getType(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cn (android.os.Parcel) com.google.android.gms.games.appcontent.AppContentActionEntity
   public AppContentActionEntity method_3775(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      Bundle var7 = null;
      String var8 = null;
      ArrayList var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4068(var1, var10, AppContentConditionEntity.CREATOR);
            break;
         case 2:
            var8 = class_705.method_4081(var1, var10);
            break;
         case 3:
            var7 = class_705.method_4083(var1, var10);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var10);
            break;
         case 5:
            var5 = class_705.method_4081(var1, var10);
            break;
         case 6:
            var2 = class_705.method_4081(var1, var10);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentActionEntity(var4, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3775(var1);
   }

   // $FF: renamed from: dI (int) com.google.android.gms.games.appcontent.AppContentActionEntity[]
   public AppContentActionEntity[] method_3776(int var1) {
      return new AppContentActionEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3776(var1);
   }
}
