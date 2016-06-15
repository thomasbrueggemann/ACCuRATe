package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.b
public class class_664 implements Creator<SortOrder> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.SortOrder, android.os.Parcel, int) void
   static void method_3826(SortOrder var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1000, var0.field_904);
      class_599.method_3380(var1, 1, var0.field_903, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aE (android.os.Parcel) com.google.android.gms.drive.query.SortOrder
   public SortOrder method_3827(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = class_600.method_3397(var1, var5, FieldWithSortOrder.CREATOR);
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
         return new SortOrder(var3, var4);
      }
   }

   // $FF: renamed from: bA (int) com.google.android.gms.drive.query.SortOrder[]
   public SortOrder[] method_3828(int var1) {
      return new SortOrder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3827(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3828(var1);
   }
}
