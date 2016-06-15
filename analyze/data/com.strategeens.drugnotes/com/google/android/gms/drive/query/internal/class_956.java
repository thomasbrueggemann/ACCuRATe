package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.query.internal.MatchAllFilter;

// $FF: renamed from: com.google.android.gms.drive.query.internal.j
public class class_956 implements Creator<MatchAllFilter> {
   // $FF: renamed from: a (com.google.android.gms.drive.query.internal.MatchAllFilter, android.os.Parcel, int) void
   static void method_5265(MatchAllFilter var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1000, var0.field_1718);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aZ (android.os.Parcel) com.google.android.gms.drive.query.internal.MatchAllFilter
   public MatchAllFilter method_5266(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = class_705.method_4058(var1);
         switch(class_705.method_4065(var4)) {
         case 1000:
            var3 = class_705.method_4073(var1, var4);
            break;
         default:
            class_705.method_4066(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new MatchAllFilter(var3);
      }
   }

   // $FF: renamed from: co (int) com.google.android.gms.drive.query.internal.MatchAllFilter[]
   public MatchAllFilter[] method_5267(int var1) {
      return new MatchAllFilter[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5266(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5267(var1);
   }
}
