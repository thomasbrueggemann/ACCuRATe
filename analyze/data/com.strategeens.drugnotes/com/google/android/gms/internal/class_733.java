package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_734;
import com.google.android.gms.internal.kv;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.kw
public class class_733 implements Creator<kv> {
   // $FF: renamed from: a (com.google.android.gms.internal.kv, android.os.Parcel, int) void
   static void method_4264(class_734 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4051(var1, 2, var0.method_4273(), false);
      class_704.method_4038(var1, 3, var0.method_4274(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: O (android.os.Parcel) com.google.android.gms.internal.kv
   public class_734 method_4265(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      ArrayList var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var5 = class_705.method_4068(var1, var6, class_734.class_1432.CREATOR);
            break;
         case 3:
            var2 = class_705.method_4081(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_734(var4, var5, var2);
      }
   }

   // $FF: renamed from: aP (int) com.google.android.gms.internal.kv[]
   public class_734[] method_4266(int var1) {
      return new class_734[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4265(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4266(var1);
   }
}
