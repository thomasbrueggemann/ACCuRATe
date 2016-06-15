package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_458;
import com.google.android.gms.internal.do;

// $FF: renamed from: com.google.android.gms.internal.dn
public class class_459 implements Creator<do> {
   // $FF: renamed from: a (com.google.android.gms.internal.do, android.os.Parcel, int) void
   static void method_2923(class_458 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4038(var1, 2, var0.field_1539, false);
      class_704.method_4038(var1, 3, var0.field_1540, false);
      class_704.method_4038(var1, 4, var0.mimeType, false);
      class_704.method_4038(var1, 5, var0.packageName, false);
      class_704.method_4038(var1, 6, var0.field_1541, false);
      class_704.method_4038(var1, 7, var0.field_1542, false);
      class_704.method_4038(var1, 8, var0.field_1543, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2924(var1);
   }

   // $FF: renamed from: e (android.os.Parcel) com.google.android.gms.internal.do
   public class_458 method_2924(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = class_705.method_4058(var1);
         switch(class_705.method_4065(var11)) {
         case 1:
            var4 = class_705.method_4073(var1, var11);
            break;
         case 2:
            var10 = class_705.method_4081(var1, var11);
            break;
         case 3:
            var9 = class_705.method_4081(var1, var11);
            break;
         case 4:
            var8 = class_705.method_4081(var1, var11);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var11);
            break;
         case 6:
            var6 = class_705.method_4081(var1, var11);
            break;
         case 7:
            var5 = class_705.method_4081(var1, var11);
            break;
         case 8:
            var2 = class_705.method_4081(var1, var11);
            break;
         default:
            class_705.method_4066(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_458(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: renamed from: m (int) com.google.android.gms.internal.do[]
   public class_458[] method_2925(int var1) {
      return new class_458[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2925(var1);
   }
}
