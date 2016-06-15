package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.class_912;
import com.google.android.gms.wearable.internal.p;

// $FF: renamed from: com.google.android.gms.wearable.internal.q
public class class_911 implements Creator<p> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.p, android.os.Parcel, int) void
   static void method_5073(class_912 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4050(var1, 2, var0.statusCode);
      class_704.method_4050(var1, 3, var0.axI);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5074(var1);
   }

   // $FF: renamed from: er (android.os.Parcel) com.google.android.gms.wearable.internal.p
   public class_912 method_5074(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var5 = class_705.method_4073(var1, var6);
            break;
         case 2:
            var4 = class_705.method_4073(var1, var6);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_912(var5, var4, var2);
      }
   }

   // $FF: renamed from: gA (int) com.google.android.gms.wearable.internal.p[]
   public class_912[] method_5075(int var1) {
      return new class_912[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5075(var1);
   }
}
