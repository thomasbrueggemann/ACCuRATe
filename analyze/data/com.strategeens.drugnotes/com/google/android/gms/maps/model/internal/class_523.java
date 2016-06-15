package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.maps.model.internal.class_524;
import com.google.android.gms.maps.model.internal.class_526;
import com.google.android.gms.maps.model.internal.p;

// $FF: renamed from: com.google.android.gms.maps.model.internal.q
public class class_523 implements Creator<p> {
   // $FF: renamed from: a (com.google.android.gms.maps.model.internal.p, android.os.Parcel, int) void
   static void method_3234(class_524 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.method_3237(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3235(var1);
   }

   // $FF: renamed from: ds (android.os.Parcel) com.google.android.gms.maps.model.internal.p
   public class_524 method_3235(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      class_526 var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = (class_526)class_705.method_4061(var1, var5, class_526.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_524(var3, var4);
      }
   }

   // $FF: renamed from: fp (int) com.google.android.gms.maps.model.internal.p[]
   public class_524[] method_3236(int var1) {
      return new class_524[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3236(var1);
   }
}
