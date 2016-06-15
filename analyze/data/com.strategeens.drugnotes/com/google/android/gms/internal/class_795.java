package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_730;
import java.util.HashSet;
import java.util.Set;

// $FF: renamed from: com.google.android.gms.internal.pk
public class class_795 implements Creator<class_730.class_1700> {
   // $FF: renamed from: a (com.google.android.gms.internal.pi$a, android.os.Parcel, int) void
   static void method_4427(class_730.class_1700 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      Set var4 = var0.aon;
      if(var4.contains(Integer.valueOf(1))) {
         class_704.method_4050(var1, 1, var0.field_3345);
      }

      if(var4.contains(Integer.valueOf(2))) {
         class_704.method_4050(var1, 2, var0.apE);
      }

      if(var4.contains(Integer.valueOf(3))) {
         class_704.method_4050(var1, 3, var0.apF);
      }

      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4428(var1);
   }

   // $FF: renamed from: dA (android.os.Parcel) com.google.android.gms.internal.pi$a
   public class_730.class_1700 method_4428(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      HashSet var4 = new HashSet();
      int var5 = 0;
      int var6 = 0;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4073(var1, var7);
            var4.add(Integer.valueOf(1));
            break;
         case 2:
            var5 = class_705.method_4073(var1, var7);
            var4.add(Integer.valueOf(2));
            break;
         case 3:
            var2 = class_705.method_4073(var1, var7);
            var4.add(Integer.valueOf(3));
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_730.class_1700(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: fy (int) com.google.android.gms.internal.pi$a[]
   public class_730.class_1700[] method_4429(int var1) {
      return new class_730.class_1700[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4429(var1);
   }
}
