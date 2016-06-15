package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.player.MostRecentGameInfoEntity, android.os.Parcel, int) void
   static void method_2153(MostRecentGameInfoEntity var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.method_220(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.method_221(), false);
      class_599.method_3361(var1, 3, var0.method_222());
      class_599.method_3365(var1, 4, var0.method_223(), var2, false);
      class_599.method_3365(var1, 5, var0.method_224(), var2, false);
      class_599.method_3365(var1, 6, var0.method_225(), var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bj (android.os.Parcel) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
   public MostRecentGameInfoEntity method_2154(Parcel var1) {
      Uri var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      long var5 = 0L;
      Uri var7 = null;
      Uri var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var10 = class_600.method_3410(var1, var11);
            break;
         case 2:
            var9 = class_600.method_3410(var1, var11);
            break;
         case 3:
            var5 = class_600.method_3404(var1, var11);
            break;
         case 4:
            var8 = (Uri)class_600.method_3390(var1, var11, Uri.CREATOR);
            break;
         case 5:
            var7 = (Uri)class_600.method_3390(var1, var11, Uri.CREATOR);
            break;
         case 6:
            var2 = (Uri)class_600.method_3390(var1, var11, Uri.CREATOR);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var11);
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new MostRecentGameInfoEntity(var4, var10, var9, var5, var8, var7, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2154(var1);
   }

   // $FF: renamed from: cu (int) com.google.android.gms.games.internal.player.MostRecentGameInfoEntity[]
   public MostRecentGameInfoEntity[] method_2155(int var1) {
      return new MostRecentGameInfoEntity[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2155(var1);
   }
}
