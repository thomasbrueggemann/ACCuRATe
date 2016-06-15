package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.LogicalFilter;

// $FF: renamed from: com.google.android.gms.drive.query.a
public class class_663 implements Creator<Query> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.Query, android.os.Parcel, int) void
   static void method_3814(Query var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_3317);
      class_599.method_3365(var1, 1, var0.field_3314, var2, false);
      class_599.method_3369(var1, 3, var0.field_3315, false);
      class_599.method_3365(var1, 4, var0.field_3316, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aD (android.os.Parcel) com.google.android.gms.drive.query.Query
   public Query method_3815(Parcel var1) {
      SortOrder var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String var5 = null;

      LogicalFilter var6;
      SortOrder var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         String var9;
         LogicalFilter var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            LogicalFilter var14 = (LogicalFilter)class_600.method_3390(var1, var7, LogicalFilter.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            String var12 = class_600.method_3410(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (SortOrder)class_600.method_3390(var1, var7, SortOrder.CREATOR);
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 1000:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new Query(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: bz (int) com.google.android.gms.drive.query.Query[]
   public Query[] method_3816(int var1) {
      return new Query[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3815(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3816(var1);
   }
}
