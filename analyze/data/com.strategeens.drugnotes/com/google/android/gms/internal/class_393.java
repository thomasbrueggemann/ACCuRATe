package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_388;
import com.google.android.gms.internal.class_394;
import com.google.android.gms.internal.hh;

// $FF: renamed from: com.google.android.gms.internal.hi
public class class_393 implements Creator<hh> {
   // $FF: renamed from: a (com.google.android.gms.internal.hh, android.os.Parcel, int) void
   static void method_2677(class_394 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.field_1225, false);
      class_704.method_4050(var1, 1000, var0.field_1224);
      class_704.method_4034(var1, 3, var0.field_1226, var2, false);
      class_704.method_4050(var1, 4, var0.field_1227);
      class_704.method_4042(var1, 5, var0.field_1228, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: L (int) com.google.android.gms.internal.hh[]
   public class_394[] method_2678(int var1) {
      return new class_394[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2679(var1);
   }

   // $FF: renamed from: n (android.os.Parcel) com.google.android.gms.internal.hh
   public class_394 method_2679(Parcel var1) {
      byte[] var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = -1;
      class_388 var6 = null;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var6 = (class_388)class_705.method_4061(var1, var8, class_388.CREATOR);
            break;
         case 4:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 5:
            var2 = class_705.method_4084(var1, var8);
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
         return new class_394(var4, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2678(var1);
   }
}
