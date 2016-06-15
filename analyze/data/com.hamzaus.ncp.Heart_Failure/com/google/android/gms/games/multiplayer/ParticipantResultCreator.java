package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantResult, android.os.Parcel, int) void
   static void method_2492(ParticipantResult var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getParticipantId(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3381(var1, 2, var0.getResult());
      class_599.method_3381(var1, 3, var0.getPlacing());
      class_599.method_3357(var1, var3);
   }

   public ParticipantResult createFromParcel(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var4 = class_600.method_3410(var1, var7);
            break;
         case 2:
            var5 = class_600.method_3402(var1, var7);
            break;
         case 3:
            var2 = class_600.method_3402(var1, var7);
            break;
         case 1000:
            var6 = class_600.method_3402(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ParticipantResult(var6, var4, var5, var2);
      }
   }

   public ParticipantResult[] newArray(int var1) {
      return new ParticipantResult[var1];
   }
}
