package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.class_1000;

// $FF: renamed from: com.google.android.gms.wearable.internal.aj
public class class_1001 implements Creator<ai> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ai, android.os.Parcel, int) void
   static void method_5499(class_1000 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4262);
      class_704.method_4050(var1, 2, var0.getRequestId());
      class_704.method_4038(var1, 3, var0.getPath(), false);
      class_704.method_4042(var1, 4, var0.getData(), false);
      class_704.method_4038(var1, 5, var0.getSourceNodeId(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5500(var1);
   }

   // $FF: renamed from: ey (android.os.Parcel) com.google.android.gms.wearable.internal.ai
   public class_1000 method_5500(Parcel var1) {
      int var2 = 0;
      String var3 = null;
      int var4 = class_705.method_4059(var1);
      byte[] var5 = null;
      String var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var2 = class_705.method_4073(var1, var8);
            break;
         case 3:
            var6 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var5 = class_705.method_4084(var1, var8);
            break;
         case 5:
            var3 = class_705.method_4081(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new class_1000(var7, var2, var6, var5, var3);
      }
   }

   // $FF: renamed from: gH (int) com.google.android.gms.wearable.internal.ai[]
   public class_1000[] method_5501(int var1) {
      return new class_1000[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5501(var1);
   }
}
