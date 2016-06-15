package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.j
public class class_304 implements Creator<ValuesSetDetails> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails, android.os.Parcel, int) void
   static void method_2169(ValuesSetDetails var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_1806);
      class_704.method_4050(var1, 2, var0.mIndex);
      class_704.method_4050(var1, 3, var0.field_1807);
      class_704.method_4050(var1, 4, var0.field_1808);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bp (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails
   public ValuesSetDetails method_2170(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 3:
            var4 = class_705.method_4073(var1, var7);
            break;
         case 4:
            var2 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new ValuesSetDetails(var6, var5, var4, var2);
      }
   }

   // $FF: renamed from: cF (int) com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails[]
   public ValuesSetDetails[] method_2171(int var1) {
      return new ValuesSetDetails[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2170(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2171(var1);
   }
}
