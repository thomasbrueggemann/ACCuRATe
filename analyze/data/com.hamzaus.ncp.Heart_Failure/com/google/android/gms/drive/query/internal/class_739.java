package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.internal.h
public class class_739 implements Creator<LogicalFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.LogicalFilter, android.os.Parcel, int) void
   static void method_4158(LogicalFilter var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_4137);
      class_599.method_3365(var1, 1, var0.field_4135, var2, false);
      class_599.method_3380(var1, 2, var0.field_4136, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aL (android.os.Parcel) com.google.android.gms.drive.query.internal.LogicalFilter
   public LogicalFilter method_4159(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      Operator var5;
      ArrayList var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_600.method_3383(var1);
         Operator var8;
         int var9;
         switch(class_600.method_3394(var6)) {
         case 1:
            Operator var10 = (Operator)class_600.method_3390(var1, var6, Operator.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 2:
            var7 = class_600.method_3397(var1, var6, FilterHolder.CREATOR);
            var8 = var5;
            var9 = var4;
            break;
         case 1000:
            int var11 = class_600.method_3402(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         default:
            class_600.method_3395(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new LogicalFilter(var4, var5, var2);
      }
   }

   // $FF: renamed from: bH (int) com.google.android.gms.drive.query.internal.LogicalFilter[]
   public LogicalFilter[] method_4160(int var1) {
      return new LogicalFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4159(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4160(var1);
   }
}
