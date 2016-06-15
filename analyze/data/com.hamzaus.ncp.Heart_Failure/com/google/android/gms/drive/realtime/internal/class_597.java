package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.ParcelableIndexReference;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.q
public class class_597 implements Creator<ParcelableIndexReference> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, android.os.Parcel, int) void
   static void method_3349(ParcelableIndexReference var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3567);
      class_599.method_3369(var1, 2, var0.field_3565, false);
      class_599.method_3381(var1, 3, var0.mIndex);
      class_599.method_3372(var1, 4, var0.field_3566);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aS (android.os.Parcel) com.google.android.gms.drive.realtime.internal.ParcelableIndexReference
   public ParcelableIndexReference method_3350(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var6 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var7);
            break;
         case 3:
            var5 = class_600.method_3402(var1, var7);
            break;
         case 4:
            var2 = class_600.method_3398(var1, var7);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new ParcelableIndexReference(var6, var4, var5, var2);
      }
   }

   // $FF: renamed from: bP (int) com.google.android.gms.drive.realtime.internal.ParcelableIndexReference[]
   public ParcelableIndexReference[] method_3351(int var1) {
      return new ParcelableIndexReference[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3350(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3351(var1);
   }
}
