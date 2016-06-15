package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.b
public class class_753 implements Creator<CastDevice> {
   // $FF: renamed from: a (com.google.android.gms.cast.CastDevice, android.os.Parcel, int) void
   static void method_4308(CastDevice var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3369(var1, 2, var0.getDeviceId(), false);
      class_599.method_3369(var1, 3, var0.field_1998, false);
      class_599.method_3369(var1, 4, var0.getFriendlyName(), false);
      class_599.method_3369(var1, 5, var0.getModelName(), false);
      class_599.method_3369(var1, 6, var0.getDeviceVersion(), false);
      class_599.method_3381(var1, 7, var0.getServicePort());
      class_599.method_3380(var1, 8, var0.getIcons(), false);
      class_599.method_3381(var1, 9, var0.getCapabilities());
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: P (int) com.google.android.gms.cast.CastDevice[]
   public CastDevice[] method_4309(int var1) {
      return new CastDevice[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4310(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4309(var1);
   }

   // $FF: renamed from: s (android.os.Parcel) com.google.android.gms.cast.CastDevice
   public CastDevice method_4310(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = class_600.method_3383(var1);
         switch(class_600.method_3394(var12)) {
         case 1:
            var11 = class_600.method_3402(var1, var12);
            break;
         case 2:
            var10 = class_600.method_3410(var1, var12);
            break;
         case 3:
            var9 = class_600.method_3410(var1, var12);
            break;
         case 4:
            var8 = class_600.method_3410(var1, var12);
            break;
         case 5:
            var7 = class_600.method_3410(var1, var12);
            break;
         case 6:
            var6 = class_600.method_3410(var1, var12);
            break;
         case 7:
            var5 = class_600.method_3402(var1, var12);
            break;
         case 8:
            var3 = class_600.method_3397(var1, var12, WebImage.CREATOR);
            break;
         case 9:
            var2 = class_600.method_3402(var1, var12);
            break;
         default:
            class_600.method_3395(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new CastDevice(var11, var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }
}
