package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.request.class_518;
import com.google.android.gms.fitness.request.q;

// $FF: renamed from: com.google.android.gms.fitness.request.r
public class class_517 implements Creator<q> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.q, android.os.Parcel, int) void
   static void method_3213(class_518 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4032(var1, 1, var0.method_3217(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.method_3216(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bR (android.os.Parcel) com.google.android.gms.fitness.request.q
   public class_518 method_3214(Parcel var1) {
      PendingIntent var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      IBinder var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4082(var1, var6);
            break;
         case 2:
            var2 = (PendingIntent)class_705.method_4061(var1, var6, PendingIntent.CREATOR);
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
         return new class_518(var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3214(var1);
   }

   // $FF: renamed from: dm (int) com.google.android.gms.fitness.request.q[]
   public class_518[] method_3215(int var1) {
      return new class_518[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3215(var1);
   }
}
