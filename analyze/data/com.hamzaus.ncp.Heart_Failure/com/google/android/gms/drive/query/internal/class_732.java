package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.internal.InFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.g
public class class_732 implements Creator<InFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.InFilter, android.os.Parcel, int) void
   static void method_4139(InFilter var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_4140);
      class_599.method_3365(var1, 1, var0.field_4138, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aK (android.os.Parcel) com.google.android.gms.drive.query.internal.InFilter
   public InFilter method_4140(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      MetadataBundle var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = (MetadataBundle)class_600.method_3390(var1, var5, MetadataBundle.CREATOR);
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
         return new InFilter(var3, var4);
      }
   }

   // $FF: renamed from: bG (int) com.google.android.gms.drive.query.internal.InFilter[]
   public InFilter[] method_4141(int var1) {
      return new InFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4140(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4141(var1);
   }
}
