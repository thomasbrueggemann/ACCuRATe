package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_328;
import com.google.android.gms.internal.if;

// $FF: renamed from: com.google.android.gms.internal.ig
public class class_330 implements Creator<if> {
   // $FF: renamed from: a (com.google.android.gms.internal.if, android.os.Parcel, int) void
   static void method_2289(class_328 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.responseCode);
      class_704.method_4050(var1, 1000, var0.versionCode);
      class_704.method_4031(var1, 2, var0.field_882, false);
      class_704.method_4042(var1, 3, var0.field_883, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: U (int) com.google.android.gms.internal.if[]
   public class_328[] method_2290(int var1) {
      return new class_328[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2291(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2290(var1);
   }

   // $FF: renamed from: t (android.os.Parcel) com.google.android.gms.internal.if
   public class_328 method_2291(Parcel var1) {
      byte[] var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      Bundle var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var3 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4083(var1, var7);
            break;
         case 3:
            var2 = class_705.method_4084(var1, var7);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_328(var6, var3, var5, var2);
      }
   }
}
