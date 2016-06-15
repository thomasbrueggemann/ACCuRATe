package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_738;
import com.google.android.gms.internal.class_740;
import com.google.android.gms.internal.km;

// $FF: renamed from: com.google.android.gms.internal.kn
public class class_741 implements Creator<km> {
   // $FF: renamed from: a (com.google.android.gms.internal.km, android.os.Parcel, int) void
   static void method_4302(class_740 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.method_4300(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: J (android.os.Parcel) com.google.android.gms.internal.km
   public class_740 method_4303(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      class_738 var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = (class_738)class_705.method_4061(var1, var5, class_738.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_740(var3, var4);
      }
   }

   // $FF: renamed from: aK (int) com.google.android.gms.internal.km[]
   public class_740[] method_4304(int var1) {
      return new class_740[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4303(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4304(var1);
   }
}
