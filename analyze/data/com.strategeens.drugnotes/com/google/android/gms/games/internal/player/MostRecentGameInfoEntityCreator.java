package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfoEntity, android.os.Parcel, int) void
   static void method_2671(MostRecentGameInfoEntity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.method_248(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.method_249(), false);
      class_704.method_4030(var1, 3, var0.method_250());
      class_704.method_4034(var1, 4, var0.method_251(), var2, false);
      class_704.method_4034(var1, 5, var0.method_246(), var2, false);
      class_704.method_4034(var1, 6, var0.method_247(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2672(var1);
   }

   // $FF: renamed from: cx (android.os.Parcel) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
   public MostRecentGameInfoEntity method_2672(Parcel var1) {
      Uri var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      long var5 = 0L;
      Uri var7 = null;
      Uri var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var10 = class_705.method_4081(var1, var11);
            break;
         case 2:
            var9 = class_705.method_4081(var1, var11);
            break;
         case 3:
            var5 = class_705.method_4075(var1, var11);
            break;
         case 4:
            var8 = (Uri)class_705.method_4061(var1, var11, Uri.CREATOR);
            break;
         case 5:
            var7 = (Uri)class_705.method_4061(var1, var11, Uri.CREATOR);
            break;
         case 6:
            var2 = (Uri)class_705.method_4061(var1, var11, Uri.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new MostRecentGameInfoEntity(var4, var10, var9, var5, var8, var7, var2);
      }
   }

   // $FF: renamed from: ei (int) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity[]
   public MostRecentGameInfoEntity[] method_2673(int var1) {
      return new MostRecentGameInfoEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2673(var1);
   }
}
