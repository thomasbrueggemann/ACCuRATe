package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1047;
import com.google.android.gms.fitness.result.SessionReadResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.f
public class class_930 implements Creator<SessionReadResult> {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionReadResult, android.os.Parcel, int) void
   static void method_5155(SessionReadResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.getSessions(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.method_3523(), false);
      class_704.method_4034(var1, 3, var0.getStatus(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ci (android.os.Parcel) com.google.android.gms.fitness.result.SessionReadResult
   public SessionReadResult method_5156(Parcel var1) {
      Status var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ArrayList var5 = null;
      ArrayList var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4068(var1, var7, Session.CREATOR);
            break;
         case 2:
            var5 = class_705.method_4068(var1, var7, class_1047.CREATOR);
            break;
         case 3:
            var2 = (Status)class_705.method_4061(var1, var7, Status.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionReadResult(var4, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5156(var1);
   }

   // $FF: renamed from: dD (int) com.google.android.gms.fitness.result.SessionReadResult[]
   public SessionReadResult[] method_5157(int var1) {
      return new SessionReadResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5157(var1);
   }
}
