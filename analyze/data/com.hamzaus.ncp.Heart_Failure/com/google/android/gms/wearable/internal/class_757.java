package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.ao;
import com.google.android.gms.wearable.internal.class_758;

// $FF: renamed from: com.google.android.gms.wearable.internal.ap
public class class_757 implements Creator<ao> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ao, android.os.Parcel, int) void
   static void method_4327(class_758 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4111);
      class_599.method_3363(var1, 2, var0.method_4330(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cI (android.os.Parcel) com.google.android.gms.wearable.internal.ao
   public class_758 method_4328(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      IBinder var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = class_600.method_3411(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_758(var3, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4328(var1);
   }

   // $FF: renamed from: er (int) com.google.android.gms.wearable.internal.ao[]
   public class_758[] method_4329(int var1) {
      return new class_758[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4329(var1);
   }
}
