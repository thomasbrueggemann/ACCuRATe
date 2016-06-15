package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.class_962;
import com.google.android.gms.wearable.internal.class_915;
import com.google.android.gms.wearable.internal.t;

// $FF: renamed from: com.google.android.gms.wearable.internal.u
public class class_914 implements Creator<t> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.t, android.os.Parcel, int) void
   static void method_5079(class_915 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4050(var1, 2, var0.statusCode);
      class_704.method_4044(var1, 3, var0.axK, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5080(var1);
   }

   // $FF: renamed from: et (android.os.Parcel) com.google.android.gms.wearable.internal.t
   public class_915 method_5080(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      class_962[] var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var2 = class_705.method_4073(var1, var6);
            break;
         case 3:
            var4 = (class_962[])class_705.method_4067(var1, var6, class_962.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_915(var5, var2, var4);
      }
   }

   // $FF: renamed from: gC (int) com.google.android.gms.wearable.internal.t[]
   public class_915[] method_5081(int var1) {
      return new class_915[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5081(var1);
   }
}
