package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.d
public class class_735 implements Creator<FilterHolder> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.FilterHolder, android.os.Parcel, int) void
   static void method_4146(FilterHolder var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3365(var1, 1, var0.field_720, var2, false);
      class_599.method_3381(var1, 1000, var0.field_728);
      class_599.method_3365(var1, 2, var0.field_721, var2, false);
      class_599.method_3365(var1, 3, var0.field_722, var2, false);
      class_599.method_3365(var1, 4, var0.field_723, var2, false);
      class_599.method_3365(var1, 5, var0.field_724, var2, false);
      class_599.method_3365(var1, 6, var0.field_725, var2, false);
      class_599.method_3365(var1, 7, var0.field_726, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aI (android.os.Parcel) com.google.android.gms.drive.query.internal.FilterHolder
   public FilterHolder method_4147(Parcel var1) {
      HasFilter var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      MatchAllFilter var5 = null;
      InFilter var6 = null;
      NotFilter var7 = null;
      LogicalFilter var8 = null;
      FieldOnlyFilter var9 = null;
      ComparisonFilter var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_600.method_3383(var1);
         switch(class_600.method_3394(var11)) {
         case 1:
            var10 = (ComparisonFilter)class_600.method_3390(var1, var11, ComparisonFilter.CREATOR);
            break;
         case 2:
            var9 = (FieldOnlyFilter)class_600.method_3390(var1, var11, FieldOnlyFilter.CREATOR);
            break;
         case 3:
            var8 = (LogicalFilter)class_600.method_3390(var1, var11, LogicalFilter.CREATOR);
            break;
         case 4:
            var7 = (NotFilter)class_600.method_3390(var1, var11, NotFilter.CREATOR);
            break;
         case 5:
            var6 = (InFilter)class_600.method_3390(var1, var11, InFilter.CREATOR);
            break;
         case 6:
            var5 = (MatchAllFilter)class_600.method_3390(var1, var11, MatchAllFilter.CREATOR);
            break;
         case 7:
            var2 = (HasFilter)class_600.method_3390(var1, var11, HasFilter.CREATOR);
            break;
         case 1000:
            var4 = class_600.method_3402(var1, var11);
            break;
         default:
            class_600.method_3395(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new FilterHolder(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: bE (int) com.google.android.gms.drive.query.internal.FilterHolder[]
   public FilterHolder[] method_4148(int var1) {
      return new FilterHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4147(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4148(var1);
   }
}
