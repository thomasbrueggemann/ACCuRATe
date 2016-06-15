package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentCardEntity, android.os.Parcel, int) void
   static void method_5112(AppContentCardEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getActions(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.method_237(), false);
      class_704.method_4051(var1, 3, var0.method_234(), false);
      class_704.method_4038(var1, 4, var0.method_235(), false);
      class_704.method_4050(var1, 5, var0.method_238());
      class_704.method_4038(var1, 6, var0.getDescription(), false);
      class_704.method_4031(var1, 7, var0.method_239(), false);
      class_704.method_4034(var1, 8, var0.getIconImageUri(), var2, false);
      class_704.method_4034(var1, 9, var0.method_236(), var2, false);
      class_704.method_4038(var1, 10, var0.method_240(), false);
      class_704.method_4038(var1, 11, var0.getTitle(), false);
      class_704.method_4050(var1, 12, var0.method_241());
      class_704.method_4038(var1, 13, var0.getType(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cp (android.os.Parcel) com.google.android.gms.games.appcontent.AppContentCardEntity
   public AppContentCardEntity method_5113(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      ArrayList var4 = null;
      ArrayList var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      int var8 = 0;
      String var9 = null;
      Bundle var10 = null;
      Uri var11 = null;
      Uri var12 = null;
      String var13 = null;
      String var14 = null;
      int var15 = 0;
      String var16 = null;

      while(var1.dataPosition() < var2) {
         int var17 = class_705.method_4058(var1);
         switch(class_705.method_4065(var17)) {
         case 1:
            var4 = class_705.method_4068(var1, var17, AppContentActionEntity.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4068(var1, var17, AppContentAnnotationEntity.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4068(var1, var17, AppContentConditionEntity.CREATOR);
            break;
         case 4:
            var7 = class_705.method_4081(var1, var17);
            break;
         case 5:
            var8 = class_705.method_4073(var1, var17);
            break;
         case 6:
            var9 = class_705.method_4081(var1, var17);
            break;
         case 7:
            var10 = class_705.method_4083(var1, var17);
            break;
         case 8:
            var11 = (Uri)class_705.method_4061(var1, var17, Uri.CREATOR);
            break;
         case 9:
            var12 = (Uri)class_705.method_4061(var1, var17, Uri.CREATOR);
            break;
         case 10:
            var13 = class_705.method_4081(var1, var17);
            break;
         case 11:
            var14 = class_705.method_4081(var1, var17);
            break;
         case 12:
            var15 = class_705.method_4073(var1, var17);
            break;
         case 13:
            var16 = class_705.method_4081(var1, var17);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var17);
            break;
         default:
            class_705.method_4066(var1, var17);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new AppContentCardEntity(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5113(var1);
   }

   // $FF: renamed from: dK (int) com.google.android.gms.games.appcontent.AppContentCardEntity[]
   public AppContentCardEntity[] method_5114(int var1) {
      return new AppContentCardEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5114(var1);
   }
}
