package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.g
public class class_254 implements Creator<ValueChangedDetails> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails, android.os.Parcel, int) void
   static void method_1795(ValueChangedDetails var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_1582);
      class_599.method_3381(var1, 2, var0.field_1581);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aZ (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails
   public ValueChangedDetails method_1796(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      while(var1.dataPosition() < var3) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var2 = class_600.method_3402(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ValueChangedDetails(var4, var2);
      }
   }

   // $FF: renamed from: bW (int) com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails[]
   public ValueChangedDetails[] method_1797(int var1) {
      return new ValueChangedDetails[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1796(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1797(var1);
   }
}
