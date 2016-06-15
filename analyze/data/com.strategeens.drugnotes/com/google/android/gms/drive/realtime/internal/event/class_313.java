package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.event.a
public class class_313 implements Creator<ObjectChangedDetails> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails, android.os.Parcel, int) void
   static void method_2196(ObjectChangedDetails var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_1201);
      class_704.method_4050(var1, 2, var0.field_1202);
      class_704.method_4050(var1, 3, var0.field_1203);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bg (android.os.Parcel) com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails
   public ObjectChangedDetails method_2197(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new ObjectChangedDetails(var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2197(var1);
   }

   // $FF: renamed from: cw (int) com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails[]
   public ObjectChangedDetails[] method_2198(int var1) {
      return new ObjectChangedDetails[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2198(var1);
   }
}
