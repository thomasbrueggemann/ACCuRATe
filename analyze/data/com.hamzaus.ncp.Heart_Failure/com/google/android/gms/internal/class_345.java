package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_340;
import com.google.android.gms.internal.hs;

// $FF: renamed from: com.google.android.gms.internal.ht
public class class_345 implements Creator<hs> {
   // $FF: renamed from: a (com.google.android.gms.internal.hs, android.os.Parcel, int) void
   static void method_2150(class_340 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_1409);
      class_599.method_3369(var1, 2, var0.field_1407, false);
      class_599.method_3381(var1, 3, var0.field_1408);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: D (android.os.Parcel) com.google.android.gms.internal.hs
   public class_340 method_2151(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var5 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var4 = class_600.method_3410(var1, var6);
            break;
         case 3:
            var2 = class_600.method_3402(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_340(var5, var4, var2);
      }
   }

   // $FF: renamed from: as (int) com.google.android.gms.internal.hs[]
   public class_340[] method_2152(int var1) {
      return new class_340[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2151(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2152(var1);
   }
}
