package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.class_1051;

// $FF: renamed from: com.google.android.gms.fitness.data.p
public class class_1048 implements Creator<Session> {
   // $FF: renamed from: a (com.google.android.gms.fitness.data.Session, android.os.Parcel, int) void
   static void method_5752(Session var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4030(var1, 1, var0.method_5699());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.method_5700());
      class_704.method_4038(var1, 3, var0.getName(), false);
      class_704.method_4038(var1, 4, var0.getIdentifier(), false);
      class_704.method_4038(var1, 5, var0.getDescription(), false);
      class_704.method_4050(var1, 7, var0.method_5698());
      class_704.method_4034(var1, 8, var0.method_5701(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bC (android.os.Parcel) com.google.android.gms.fitness.data.Session
   public Session method_5753(Parcel var1) {
      long var2 = 0L;
      int var4 = 0;
      class_1051 var5 = null;
      int var6 = class_705.method_4059(var1);
      String var7 = null;
      String var8 = null;
      String var9 = null;
      long var10 = var2;
      int var12 = 0;

      while(var1.dataPosition() < var6) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var10 = class_705.method_4075(var1, var13);
            break;
         case 2:
            var2 = class_705.method_4075(var1, var13);
            break;
         case 3:
            var9 = class_705.method_4081(var1, var13);
            break;
         case 4:
            var8 = class_705.method_4081(var1, var13);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var13);
            break;
         case 7:
            var4 = class_705.method_4073(var1, var13);
            break;
         case 8:
            var5 = (class_1051)class_705.method_4061(var1, var13, class_1051.CREATOR);
            break;
         case 1000:
            var12 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new class_705.class_1425("Overread allowed size end=" + var6, var1);
      } else {
         return new Session(var12, var10, var2, var9, var8, var7, var4, var5);
      }
   }

   // $FF: renamed from: cW (int) com.google.android.gms.fitness.data.Session[]
   public Session[] method_5754(int var1) {
      return new Session[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5753(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5754(var1);
   }
}
