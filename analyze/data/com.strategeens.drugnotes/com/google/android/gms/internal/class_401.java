package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_402;
import com.google.android.gms.internal.hf;

// $FF: renamed from: com.google.android.gms.internal.hg
public class class_401 implements Creator<hf> {
   // $FF: renamed from: a (com.google.android.gms.internal.hf, android.os.Parcel, int) void
   static void method_2705(class_402 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.field_1255, false);
      class_704.method_4050(var1, 1000, var0.field_1254);
      class_704.method_4038(var1, 2, var0.field_1256, false);
      class_704.method_4038(var1, 3, var0.field_1257, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: K (int) com.google.android.gms.internal.hf[]
   public class_402[] method_2706(int var1) {
      return new class_402[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2707(var1);
   }

   // $FF: renamed from: m (android.os.Parcel) com.google.android.gms.internal.hf
   public class_402 method_2707(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var6 = class_705.method_4081(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var7);
            break;
         case 3:
            var2 = class_705.method_4081(var1, var7);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_402(var4, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2706(var1);
   }
}
