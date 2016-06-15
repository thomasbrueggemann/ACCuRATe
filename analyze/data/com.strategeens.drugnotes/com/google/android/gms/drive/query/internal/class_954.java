package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.NotFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.d
public class class_954 implements Creator<FilterHolder> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.FilterHolder, android.os.Parcel, int) void
   static void method_5259(FilterHolder var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.field_578, var2, false);
      class_704.method_4050(var1, 1000, var0.field_577);
      class_704.method_4034(var1, 2, var0.field_579, var2, false);
      class_704.method_4034(var1, 3, var0.field_580, var2, false);
      class_704.method_4034(var1, 4, var0.field_581, var2, false);
      class_704.method_4034(var1, 5, var0.field_582, var2, false);
      class_704.method_4034(var1, 6, var0.field_583, var2, false);
      class_704.method_4034(var1, 7, var0.field_584, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aV (android.os.Parcel) com.google.android.gms.drive.query.internal.FilterHolder
   public FilterHolder method_5260(Parcel var1) {
      HasFilter var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      MatchAllFilter var5 = null;
      InFilter var6 = null;
      NotFilter var7 = null;
      LogicalFilter var8 = null;
      FieldOnlyFilter var9 = null;
      ComparisonFilter var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var10 = (ComparisonFilter)class_705.method_4061(var1, var11, ComparisonFilter.CREATOR);
            break;
         case 2:
            var9 = (FieldOnlyFilter)class_705.method_4061(var1, var11, FieldOnlyFilter.CREATOR);
            break;
         case 3:
            var8 = (LogicalFilter)class_705.method_4061(var1, var11, LogicalFilter.CREATOR);
            break;
         case 4:
            var7 = (NotFilter)class_705.method_4061(var1, var11, NotFilter.CREATOR);
            break;
         case 5:
            var6 = (InFilter)class_705.method_4061(var1, var11, InFilter.CREATOR);
            break;
         case 6:
            var5 = (MatchAllFilter)class_705.method_4061(var1, var11, MatchAllFilter.CREATOR);
            break;
         case 7:
            var2 = (HasFilter)class_705.method_4061(var1, var11, HasFilter.CREATOR);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new FilterHolder(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: ck (int) com.google.android.gms.drive.query.internal.FilterHolder[]
   public FilterHolder[] method_5261(int var1) {
      return new FilterHolder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5260(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5261(var1);
   }
}
