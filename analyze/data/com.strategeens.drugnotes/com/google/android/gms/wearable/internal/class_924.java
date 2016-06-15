package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.b;
import com.google.android.gms.wearable.internal.class_923;

// $FF: renamed from: com.google.android.gms.wearable.internal.c
public class class_924 implements Creator<b> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.b, android.os.Parcel, int) void
   static void method_5097(class_923 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3847);
      class_704.method_4032(var1, 2, var0.method_5096(), false);
      class_704.method_4044(var1, 3, var0.axw, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5098(var1);
   }

   // $FF: renamed from: eo (android.os.Parcel) com.google.android.gms.wearable.internal.b
   public class_923 method_5098(Parcel var1) {
      IntentFilter[] var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      IBinder var5 = null;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var5 = class_705.method_4082(var1, var6);
            break;
         case 3:
            var2 = (IntentFilter[])class_705.method_4067(var1, var6, IntentFilter.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_923(var4, var5, var2);
      }
   }

   // $FF: renamed from: gx (int) com.google.android.gms.wearable.internal.b[]
   public class_923[] method_5099(int var1) {
      return new class_923[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5099(var1);
   }
}
