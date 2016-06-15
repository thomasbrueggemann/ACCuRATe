package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.request.class_500;
import com.google.android.gms.fitness.request.j;

// $FF: renamed from: com.google.android.gms.fitness.request.k
public class class_501 implements Creator<j> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.j, android.os.Parcel, int) void
   static void method_3166(class_500 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getName(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bO (android.os.Parcel) com.google.android.gms.fitness.request.j
   public class_500 method_3167(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      String var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var4 = class_705.method_4081(var1, var5);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_500(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3167(var1);
   }

   // $FF: renamed from: di (int) com.google.android.gms.fitness.request.j[]
   public class_500[] method_3168(int var1) {
      return new class_500[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3168(var1);
   }
}
