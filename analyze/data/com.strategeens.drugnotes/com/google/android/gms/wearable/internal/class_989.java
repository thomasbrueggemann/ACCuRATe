package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.aw;
import com.google.android.gms.wearable.internal.class_987;
import com.google.android.gms.wearable.internal.class_990;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wearable.internal.ax
public class class_989 implements Creator<aw> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.aw, android.os.Parcel, int) void
   static void method_5483(class_990 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4050(var1, 2, var0.statusCode);
      class_704.method_4030(var1, 3, var0.ayc);
      class_704.method_4051(var1, 4, var0.aye, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5484(var1);
   }

   // $FF: renamed from: eE (android.os.Parcel) com.google.android.gms.wearable.internal.aw
   public class_990 method_5484(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      long var4 = 0L;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var7 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var2 = class_705.method_4073(var1, var8);
            break;
         case 3:
            var4 = class_705.method_4075(var1, var8);
            break;
         case 4:
            var6 = class_705.method_4068(var1, var8, class_987.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_990(var7, var2, var4, var6);
      }
   }

   // $FF: renamed from: gO (int) com.google.android.gms.wearable.internal.aw[]
   public class_990[] method_5485(int var1) {
      return new class_990[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5485(var1);
   }
}
