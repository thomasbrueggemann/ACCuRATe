package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wallet.CountrySpecification;

// $FF: renamed from: com.google.android.gms.wallet.c
public class class_723 implements Creator<CountrySpecification> {
   // $FF: renamed from: a (com.google.android.gms.wallet.CountrySpecification, android.os.Parcel, int) void
   static void method_4101(CountrySpecification var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.field_4313, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bS (android.os.Parcel) com.google.android.gms.wallet.CountrySpecification
   public CountrySpecification method_4102(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new CountrySpecification(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4102(var1);
   }

   // $FF: renamed from: dy (int) com.google.android.gms.wallet.CountrySpecification[]
   public CountrySpecification[] method_4103(int var1) {
      return new CountrySpecification[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4103(var1);
   }
}
