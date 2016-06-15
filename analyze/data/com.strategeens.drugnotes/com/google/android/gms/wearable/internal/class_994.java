package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.ar;
import com.google.android.gms.wearable.internal.class_983;

// $FF: renamed from: com.google.android.gms.wearable.internal.as
public class class_994 implements Creator<ar> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.ar, android.os.Parcel, int) void
   static void method_5488(class_983 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4251);
      class_704.method_4032(var1, 2, var0.method_5476(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5489(var1);
   }

   // $FF: renamed from: eC (android.os.Parcel) com.google.android.gms.wearable.internal.ar
   public class_983 method_5489(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      IBinder var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4082(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_983(var3, var4);
      }
   }

   // $FF: renamed from: gL (int) com.google.android.gms.wearable.internal.ar[]
   public class_983[] method_5490(int var1) {
      return new class_983[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5490(var1);
   }
}
