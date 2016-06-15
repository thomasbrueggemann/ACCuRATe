package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.internal.request.GameRequestCluster;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
   // $FF: renamed from: a (com.google.android.gms.games.internal.request.GameRequestCluster, android.os.Parcel, int) void
   static void method_4359(GameRequestCluster var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3380(var1, 1, var0.method_4303(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bk (android.os.Parcel) com.google.android.gms.games.internal.request.GameRequestCluster
   public GameRequestCluster method_4360(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = class_600.method_3397(var1, var5, GameRequestEntity.CREATOR);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new GameRequestCluster(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4360(var1);
   }

   // $FF: renamed from: cv (int) com.google.android.gms.games.internal.request.GameRequestCluster[]
   public GameRequestCluster[] method_4361(int var1) {
      return new GameRequestCluster[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4361(var1);
   }
}
