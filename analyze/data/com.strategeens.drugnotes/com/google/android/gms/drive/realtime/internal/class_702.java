package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.q
public class class_702 implements Creator<ParcelableIndexReference> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, android.os.Parcel, int) void
   static void method_4013(ParcelableIndexReference var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3687);
      class_704.method_4038(var1, 2, var0.field_3688, false);
      class_704.method_4050(var1, 3, var0.mIndex);
      class_704.method_4041(var1, 4, var0.field_3689);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bf (android.os.Parcel) com.google.android.gms.drive.realtime.internal.ParcelableIndexReference
   public ParcelableIndexReference method_4014(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var4 = class_705.method_4081(var1, var7);
            break;
         case 3:
            var5 = class_705.method_4073(var1, var7);
            break;
         case 4:
            var2 = class_705.method_4069(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableIndexReference(var6, var4, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4014(var1);
   }

   // $FF: renamed from: cv (int) com.google.android.gms.drive.realtime.internal.ParcelableIndexReference[]
   public ParcelableIndexReference[] method_4015(int var1) {
      return new ParcelableIndexReference[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4015(var1);
   }
}
