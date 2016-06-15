package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.Operator;

// $FF: renamed from: com.google.android.gms.drive.query.internal.a
public class class_731 implements Creator<ComparisonFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.ComparisonFilter, android.os.Parcel, int) void
   static void method_4136(ComparisonFilter var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_3851);
      class_599.method_3365(var1, 1, var0.field_3848, var2, false);
      class_599.method_3365(var1, 2, var0.field_3849, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aF (android.os.Parcel) com.google.android.gms.drive.query.internal.ComparisonFilter
   public ComparisonFilter method_4137(Parcel var1) {
      MetadataBundle var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      Operator var5;
      MetadataBundle var7;
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
            var7 = (MetadataBundle)class_600.method_3390(var1, var6, MetadataBundle.CREATOR);
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
         return new ComparisonFilter(var4, var5, var2);
      }
   }

   // $FF: renamed from: bB (int) com.google.android.gms.drive.query.internal.ComparisonFilter[]
   public ComparisonFilter[] method_4138(int var1) {
      return new ComparisonFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4137(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4138(var1);
   }
}
