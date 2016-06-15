package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.internal.MatchAllFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.i
public class class_738 implements Creator<MatchAllFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.MatchAllFilter, android.os.Parcel, int) void
   static void method_4155(MatchAllFilter var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_3475);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aM (android.os.Parcel) com.google.android.gms.drive.query.internal.MatchAllFilter
   public MatchAllFilter method_4156(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = class_600.method_3383(var1);
         switch(class_600.method_3394(var4)) {
         case 1000:
            var3 = class_600.method_3402(var1, var4);
            break;
         default:
            class_600.method_3395(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new MatchAllFilter(var3);
      }
   }

   // $FF: renamed from: bI (int) com.google.android.gms.drive.query.internal.MatchAllFilter[]
   public MatchAllFilter[] method_4157(int var1) {
      return new MatchAllFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4156(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4157(var1);
   }
}
