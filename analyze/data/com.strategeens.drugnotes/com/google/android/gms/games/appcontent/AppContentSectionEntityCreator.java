package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentSectionEntity, android.os.Parcel, int) void
   static void method_3439(AppContentSectionEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getActions(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.method_261(), var2, false);
      class_704.method_4051(var1, 3, var0.method_262(), false);
      class_704.method_4038(var1, 4, var0.method_258(), false);
      class_704.method_4031(var1, 5, var0.method_259(), false);
      class_704.method_4038(var1, 6, var0.method_260(), false);
      class_704.method_4038(var1, 7, var0.getTitle(), false);
      class_704.method_4038(var1, 8, var0.getType(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cr (android.os.Parcel) com.google.android.gms.games.appcontent.AppContentSectionEntity
   public AppContentSectionEntity method_3440(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      Bundle var7 = null;
      String var8 = null;
      ArrayList var9 = null;
      Uri var10 = null;
      ArrayList var11 = null;

      while(var1.dataPosition() < var3) {
         int var12 = class_705.method_4058(var1);
         switch(class_705.method_4065(var12)) {
         case 1:
            var11 = class_705.method_4068(var1, var12, AppContentActionEntity.CREATOR);
            break;
         case 2:
            var10 = (Uri)class_705.method_4061(var1, var12, Uri.CREATOR);
            break;
         case 3:
            var9 = class_705.method_4068(var1, var12, AppContentCardEntity.CREATOR);
            break;
         case 4:
            var8 = class_705.method_4081(var1, var12);
            break;
         case 5:
            var7 = class_705.method_4083(var1, var12);
            break;
         case 6:
            var6 = class_705.method_4081(var1, var12);
            break;
         case 7:
            var5 = class_705.method_4081(var1, var12);
            break;
         case 8:
            var2 = class_705.method_4081(var1, var12);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var12);
            break;
         default:
            class_705.method_4066(var1, var12);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentSectionEntity(var4, var11, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3440(var1);
   }

   // $FF: renamed from: dM (int) com.google.android.gms.games.appcontent.AppContentSectionEntity[]
   public AppContentSectionEntity[] method_3441(int var1) {
      return new AppContentSectionEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3441(var1);
   }
}
