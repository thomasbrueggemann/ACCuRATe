package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.internal.class_314;
import com.google.android.gms.internal.ji;

// $FF: renamed from: com.google.android.gms.internal.jj
public class class_313 implements Creator<ji> {
   // $FF: renamed from: a (com.google.android.gms.internal.ji, android.os.Parcel, int) void
   static void method_2029(class_314 var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3369(var1, 1, var0.getRequestId(), false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.getExpirationTime());
      class_599.method_3371(var1, 3, var0.method_2038());
      class_599.method_3359(var1, 4, var0.getLatitude());
      class_599.method_3359(var1, 5, var0.getLongitude());
      class_599.method_3360(var1, 6, var0.method_2039());
      class_599.method_3381(var1, 7, var0.method_2040());
      class_599.method_3381(var1, 8, var0.getNotificationResponsiveness());
      class_599.method_3381(var1, 9, var0.method_2041());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: bt (android.os.Parcel) com.google.android.gms.internal.ji
   public class_314 method_2030(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      String var4 = null;
      int var5 = 0;
      short var6 = 0;
      double var7 = 0.0D;
      double var9 = 0.0D;
      float var11 = 0.0F;
      long var12 = 0L;
      int var14 = 0;
      int var15 = -1;

      while(var1.dataPosition() < var2) {
         int var16 = class_600.method_3383(var1);
         switch(class_600.method_3394(var16)) {
         case 1:
            var4 = class_600.method_3410(var1, var16);
            break;
         case 2:
            var12 = class_600.method_3404(var1, var16);
            break;
         case 3:
            var6 = class_600.method_3401(var1, var16);
            break;
         case 4:
            var7 = class_600.method_3408(var1, var16);
            break;
         case 5:
            var9 = class_600.method_3408(var1, var16);
            break;
         case 6:
            var11 = class_600.method_3407(var1, var16);
            break;
         case 7:
            var5 = class_600.method_3402(var1, var16);
            break;
         case 8:
            var14 = class_600.method_3402(var1, var16);
            break;
         case 9:
            var15 = class_600.method_3402(var1, var16);
            break;
         case 1000:
            var3 = class_600.method_3402(var1, var16);
            break;
         default:
            class_600.method_3395(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new class_314(var3, var4, var5, var6, var7, var9, var11, var12, var14, var15);
      }
   }

   // $FF: renamed from: cO (int) com.google.android.gms.internal.ji[]
   public class_314[] method_2031(int var1) {
      return new class_314[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2030(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2031(var1);
   }
}
