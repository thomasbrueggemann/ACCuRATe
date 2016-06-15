package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.query.a
public class class_857 implements Creator<Query> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.Query, android.os.Parcel, int) void
   static void method_4772(Query var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1000, var0.field_3275);
      class_704.method_4034(var1, 1, var0.field_3276, var2, false);
      class_704.method_4038(var1, 3, var0.field_3277, false);
      class_704.method_4034(var1, 4, var0.field_3278, var2, false);
      class_704.method_4049(var1, 5, var0.field_3279, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aQ (android.os.Parcel) com.google.android.gms.drive.query.Query
   public Query method_4773(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      SortOrder var5 = null;
      String var6 = null;
      LogicalFilter var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = (LogicalFilter)class_705.method_4061(var1, var8, LogicalFilter.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var5 = (SortOrder)class_705.method_4061(var1, var8, SortOrder.CREATOR);
            break;
         case 5:
            var2 = class_705.method_4055(var1, var8);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new Query(var4, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: cf (int) com.google.android.gms.drive.query.Query[]
   public Query[] method_4774(int var1) {
      return new Query[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4773(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4774(var1);
   }
}
