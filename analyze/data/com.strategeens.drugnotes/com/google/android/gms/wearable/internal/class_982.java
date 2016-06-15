package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.an;
import com.google.android.gms.wearable.internal.class_987;

// $FF: renamed from: com.google.android.gms.wearable.internal.ao
public class class_982 implements Creator<an> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.an, android.os.Parcel, int) void
   static void method_5473(class_987 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4038(var1, 2, var0.packageName, false);
      class_704.method_4038(var1, 3, var0.label, false);
      class_704.method_4030(var1, 4, var0.ayc);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5474(var1);
   }

   // $FF: renamed from: eA (android.os.Parcel) com.google.android.gms.wearable.internal.an
   public class_987 method_5474(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      long var5 = 0L;
      String var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var4 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var7 = class_705.method_4081(var1, var8);
            break;
         case 3:
            var2 = class_705.method_4081(var1, var8);
            break;
         case 4:
            var5 = class_705.method_4075(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_987(var4, var7, var2, var5);
      }
   }

   // $FF: renamed from: gJ (int) com.google.android.gms.wearable.internal.an[]
   public class_987[] method_5475(int var1) {
      return new class_987[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5475(var1);
   }
}
