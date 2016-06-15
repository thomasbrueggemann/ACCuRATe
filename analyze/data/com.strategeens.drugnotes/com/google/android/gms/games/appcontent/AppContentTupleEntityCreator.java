package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentTupleEntity, android.os.Parcel, int) void
   static void method_2876(AppContentTupleEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getName(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getValue(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2877(var1);
   }

   // $FF: renamed from: cs (android.os.Parcel) com.google.android.gms.games.appcontent.AppContentTupleEntity
   public AppContentTupleEntity method_2877(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4081(var1, var6);
            break;
         case 2:
            var2 = class_705.method_4081(var1, var6);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new AppContentTupleEntity(var4, var5, var2);
      }
   }

   // $FF: renamed from: dN (int) com.google.android.gms.games.appcontent.AppContentTupleEntity[]
   public AppContentTupleEntity[] method_2878(int var1) {
      return new AppContentTupleEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2878(var1);
   }
}
