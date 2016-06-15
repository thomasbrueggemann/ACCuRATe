package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.i
public class class_252 implements Creator<ValuesRemovedDetails> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails, android.os.Parcel, int) void
   static void method_1789(ValuesRemovedDetails var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2107);
      class_599.method_3381(var1, 2, var0.mIndex);
      class_599.method_3381(var1, 3, var0.field_2103);
      class_599.method_3381(var1, 4, var0.field_2104);
      class_599.method_3369(var1, 5, var0.field_2105, false);
      class_599.method_3381(var1, 6, var0.field_2106);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bY (int) com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails[]
   public ValuesRemovedDetails[] method_1790(int var1) {
      return new ValuesRemovedDetails[var1];
   }

   // $FF: renamed from: bb (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails
   public ValuesRemovedDetails method_1791(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      while(var1.dataPosition() < var3) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var8 = class_600.method_3402(var1, var9);
            break;
         case 2:
            var7 = class_600.method_3402(var1, var9);
            break;
         case 3:
            var6 = class_600.method_3402(var1, var9);
            break;
         case 4:
            var5 = class_600.method_3402(var1, var9);
            break;
         case 5:
            var4 = class_600.method_3410(var1, var9);
            break;
         case 6:
            var2 = class_600.method_3402(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ValuesRemovedDetails(var8, var7, var6, var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1791(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1790(var1);
   }
}
