package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.b
public class class_858 implements Creator<SortOrder> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.SortOrder, android.os.Parcel, int) void
   static void method_4781(SortOrder var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1000, var0.field_749);
      class_704.method_4051(var1, 1, var0.field_750, false);
      class_704.method_4041(var1, 2, var0.field_751);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aR (android.os.Parcel) com.google.android.gms.drive.query.SortOrder
   public SortOrder method_4782(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      ArrayList var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4068(var1, var6, FieldWithSortOrder.CREATOR);
            break;
         case 2:
            var2 = class_705.method_4069(var1, var6);
            break;
         case 1000:
            var5 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new SortOrder(var5, var4, var2);
      }
   }

   // $FF: renamed from: cg (int) com.google.android.gms.drive.query.SortOrder[]
   public SortOrder[] method_4783(int var1) {
      return new SortOrder[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4782(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4783(var1);
   }
}
