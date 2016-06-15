package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.result.g
public class class_932 implements Creator<SessionStopResult> {
   // $FF: renamed from: a (com.google.android.gms.fitness.result.SessionStopResult, android.os.Parcel, int) void
   static void method_5161(SessionStopResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getStatus(), var2, false);
      class_704.method_4051(var1, 3, var0.getSessions(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cj (android.os.Parcel) com.google.android.gms.fitness.result.SessionStopResult
   public SessionStopResult method_5162(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      Status var5;
      ArrayList var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         Status var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 2:
            Status var10 = (Status)class_705.method_4061(var1, var6, Status.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_705.method_4068(var1, var6, Session.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new SessionStopResult(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5162(var1);
   }

   // $FF: renamed from: dE (int) com.google.android.gms.fitness.result.SessionStopResult[]
   public SessionStopResult[] method_5163(int var1) {
      return new SessionStopResult[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5163(var1);
   }
}
