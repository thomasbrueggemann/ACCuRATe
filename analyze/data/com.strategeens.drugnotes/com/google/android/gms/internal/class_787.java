package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_797;
import com.google.android.gms.internal.pw;

// $FF: renamed from: com.google.android.gms.internal.px
public class class_787 implements Creator<pw> {
   // $FF: renamed from: a (com.google.android.gms.internal.pw, android.os.Parcel, int) void
   static void method_4409(class_797 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4043(var1, 2, var0.avX, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4410(var1);
   }

   // $FF: renamed from: dX (android.os.Parcel) com.google.android.gms.internal.pw
   public class_797 method_4410(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      int[] var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4087(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_797(var3, var4);
      }
   }

   // $FF: renamed from: ge (int) com.google.android.gms.internal.pw[]
   public class_797[] method_4411(int var1) {
      return new class_797[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4411(var1);
   }
}