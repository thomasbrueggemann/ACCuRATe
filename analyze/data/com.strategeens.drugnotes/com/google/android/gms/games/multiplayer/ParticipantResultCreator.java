package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.games.multiplayer.ParticipantResult;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.ParticipantResult, android.os.Parcel, int) void
   static void method_2885(ParticipantResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getParticipantId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.getResult());
      class_704.method_4050(var1, 3, var0.getPlacing());
      class_704.method_4026(var1, var3);
   }

   public ParticipantResult createFromParcel(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var4 = class_705.method_4081(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var7);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new ParticipantResult(var6, var4, var5, var2);
      }
   }

   public ParticipantResult[] newArray(int var1) {
      return new ParticipantResult[var1];
   }
}
