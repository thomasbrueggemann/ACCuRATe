package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.class_920;
import com.google.android.gms.wearable.internal.class_985;
import com.google.android.gms.wearable.internal.v;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wearable.internal.w
public class class_921 implements Creator<v> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.v, android.os.Parcel, int) void
   static void method_5088(class_920 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4050(var1, 2, var0.statusCode);
      class_704.method_4051(var1, 3, var0.axL, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5089(var1);
   }

   // $FF: renamed from: eu (android.os.Parcel) com.google.android.gms.wearable.internal.v
   public class_920 method_5089(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      ArrayList var4 = null;
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
            var4 = class_705.method_4068(var1, var6, class_985.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_920(var5, var2, var4);
      }
   }

   // $FF: renamed from: gD (int) com.google.android.gms.wearable.internal.v[]
   public class_920[] method_5090(int var1) {
      return new class_920[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5090(var1);
   }
}
