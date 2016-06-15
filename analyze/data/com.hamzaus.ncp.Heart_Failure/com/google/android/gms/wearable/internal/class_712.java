package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_711;

// $FF: renamed from: com.google.android.gms.wearable.internal.c
public class class_712 implements Creator<b> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.b, android.os.Parcel, int) void
   static void method_4046(class_711 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3706);
      class_599.method_3363(var1, 2, var0.method_4045(), false);
      class_599.method_3375(var1, 3, var0.alx, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4047(var1);
   }

   // $FF: renamed from: cv (android.os.Parcel) com.google.android.gms.wearable.internal.b
   public class_711 method_4047(Parcel var1) {
      IntentFilter[] var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      IBinder var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var4 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var5 = class_600.method_3411(var1, var6);
            break;
         case 3:
            var2 = (IntentFilter[])class_600.method_3396(var1, var6, IntentFilter.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_711(var4, var5, var2);
      }
   }

   // $FF: renamed from: ee (int) com.google.android.gms.wearable.internal.b[]
   public class_711[] method_4048(int var1) {
      return new class_711[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4048(var1);
   }
}
