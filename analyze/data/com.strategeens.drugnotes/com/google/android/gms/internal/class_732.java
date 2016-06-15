package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_734;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.kx
public class class_732 implements Creator<class_734.class_1432> {
   // $FF: renamed from: a (com.google.android.gms.internal.kv$a, android.os.Parcel, int) void
   static void method_4261(class_734.class_1432 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4038(var1, 2, var0.className, false);
      class_704.method_4051(var1, 3, var0.field_2838, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: P (android.os.Parcel) com.google.android.gms.internal.kv$a
   public class_734.class_1432 method_4262(Parcel var1) {
      ArrayList var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var6);
            break;
         case 3:
            var2 = class_705.method_4068(var1, var6, class_734.class_1433.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_734.class_1432(var4, var5, var2);
      }
   }

   // $FF: renamed from: aQ (int) com.google.android.gms.internal.kv$a[]
   public class_734.class_1432[] method_4263(int var1) {
      return new class_734.class_1432[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4262(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4263(var1);
   }
}
