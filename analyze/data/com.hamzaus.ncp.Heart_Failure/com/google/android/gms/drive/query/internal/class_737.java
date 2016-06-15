package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.NotFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.j
public class class_737 implements Creator<NotFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.NotFilter, android.os.Parcel, int) void
   static void method_4152(NotFilter var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_2046);
      class_599.method_3365(var1, 1, var0.field_2045, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aN (android.os.Parcel) com.google.android.gms.drive.query.internal.NotFilter
   public NotFilter method_4153(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      FilterHolder var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = (FilterHolder)class_600.method_3390(var1, var5, FilterHolder.CREATOR);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new NotFilter(var3, var4);
      }
   }

   // $FF: renamed from: bJ (int) com.google.android.gms.drive.query.internal.NotFilter[]
   public NotFilter[] method_4154(int var1) {
      return new NotFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4153(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4154(var1);
   }
}
