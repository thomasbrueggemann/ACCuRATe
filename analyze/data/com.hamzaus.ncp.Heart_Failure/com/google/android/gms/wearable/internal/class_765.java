package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.internal.as;
import com.google.android.gms.wearable.internal.class_762;
import com.google.android.gms.wearable.internal.class_766;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.wearable.internal.at
public class class_765 implements Creator<as> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.as, android.os.Parcel, int) void
   static void method_4340(class_766 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.versionCode);
      class_599.method_3381(var1, 2, var0.statusCode);
      class_599.method_3361(var1, 3, var0.alY);
      class_599.method_3380(var1, 4, var0.ama, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: cK (android.os.Parcel) com.google.android.gms.wearable.internal.as
   public class_766 method_4341(Parcel var1) {
      int var2 = 0;
      int var3 = class_600.method_3385(var1);
      long var4 = 0L;
      ArrayList var6 = null;
      int var7 = 0;

      while(var1.dataPosition() < var3) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var7 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var2 = class_600.method_3402(var1, var8);
            break;
         case 3:
            var4 = class_600.method_3404(var1, var8);
            break;
         case 4:
            var6 = class_600.method_3397(var1, var8, class_762.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new class_766(var7, var2, var4, var6);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4341(var1);
   }

   // $FF: renamed from: et (int) com.google.android.gms.wearable.internal.as[]
   public class_766[] method_4342(int var1) {
      return new class_766[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4342(var1);
   }
}
