package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.am;
import com.google.android.gms.wearable.internal.class_696;
import com.google.android.gms.wearable.internal.class_764;

// $FF: renamed from: com.google.android.gms.wearable.internal.an
public class class_763 implements Creator<am> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.am, android.os.Parcel, int) void
   static void method_4337(class_764 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3381(var1, 2, var0.statusCode);
      class_599.method_3365(var1, 3, var0.alL, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cH (android.os.Parcel) com.google.android.gms.wearable.internal.am
   public class_764 method_4338(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      class_696 var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var5 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var2 = class_600.method_3402(var1, var6);
            break;
         case 3:
            var4 = (class_696)class_600.method_3390(var1, var6, class_696.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_764(var5, var2, var4);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4338(var1);
   }

   // $FF: renamed from: eq (int) com.google.android.gms.wearable.internal.am[]
   public class_764[] method_4339(int var1) {
      return new class_764[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4339(var1);
   }
}
