package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.b
public class class_976 implements Creator<CastDevice> {
   // $FF: renamed from: a (com.google.android.gms.cast.CastDevice, android.os.Parcel, int) void
   static void method_5436(CastDevice var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getDeviceId(), false);
      class_704.method_4038(var1, 3, var0.field_1627, false);
      class_704.method_4038(var1, 4, var0.getFriendlyName(), false);
      class_704.method_4038(var1, 5, var0.getModelName(), false);
      class_704.method_4038(var1, 6, var0.getDeviceVersion(), false);
      class_704.method_4050(var1, 7, var0.getServicePort());
      class_704.method_4051(var1, 8, var0.getIcons(), false);
      class_704.method_4050(var1, 9, var0.getCapabilities());
      class_704.method_4050(var1, 10, var0.getStatus());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: Z (int) com.google.android.gms.cast.CastDevice[]
   public CastDevice[] method_5437(int var1) {
      return new CastDevice[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5438(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5437(var1);
   }

   // $FF: renamed from: v (android.os.Parcel) com.google.android.gms.cast.CastDevice
   public CastDevice method_5438(Parcel var1) {
      int var2 = 0;
      ArrayList var3 = null;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      int var6 = 0;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;
      String var11 = null;
      int var12 = 0;

      while(var1.dataPosition() < var4) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var12 = class_705.method_4073(var1, var13);
            break;
         case 2:
            var11 = class_705.method_4081(var1, var13);
            break;
         case 3:
            var10 = class_705.method_4081(var1, var13);
            break;
         case 4:
            var9 = class_705.method_4081(var1, var13);
            break;
         case 5:
            var8 = class_705.method_4081(var1, var13);
            break;
         case 6:
            var7 = class_705.method_4081(var1, var13);
            break;
         case 7:
            var6 = class_705.method_4073(var1, var13);
            break;
         case 8:
            var3 = class_705.method_4068(var1, var13, WebImage.CREATOR);
            break;
         case 9:
            var5 = class_705.method_4073(var1, var13);
            break;
         case 10:
            var2 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CastDevice(var12, var11, var10, var9, var8, var7, var6, var3, var5, var2);
      }
   }
}
