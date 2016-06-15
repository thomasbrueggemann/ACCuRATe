package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.j
public class class_250 implements Creator<ValuesSetDetails> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails, android.os.Parcel, int) void
   static void method_1783(ValuesSetDetails var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2111);
      class_599.method_3381(var1, 2, var0.mIndex);
      class_599.method_3381(var1, 3, var0.field_2109);
      class_599.method_3381(var1, 4, var0.field_2110);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bZ (int) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails[]
   public ValuesSetDetails[] method_1784(int var1) {
      return new ValuesSetDetails[var1];
   }

   // $FF: renamed from: bc (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
   public ValuesSetDetails method_1785(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var6 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var5 = class_600.method_3402(var1, var7);
            break;
         case 3:
            var4 = class_600.method_3402(var1, var7);
            break;
         case 4:
            var2 = class_600.method_3402(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ValuesSetDetails(var6, var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1785(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1784(var1);
   }
}
