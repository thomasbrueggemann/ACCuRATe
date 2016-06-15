package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_218;
import com.google.android.gms.internal.class_237;
import com.google.android.gms.internal.class_369;
import com.google.android.gms.internal.class_440;
import com.google.android.gms.internal.fh;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.fi
public class class_441 implements Creator<fh> {
   // $FF: renamed from: a (com.google.android.gms.internal.fh, android.os.Parcel, int) void
   static void method_2882(class_440 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.versionCode);
      class_704.method_4031(var1, 2, var0.field_1463, false);
      class_704.method_4034(var1, 3, var0.field_1464, var2, false);
      class_704.method_4034(var1, 4, var0.field_1461, var2, false);
      class_704.method_4038(var1, 5, var0.field_1459, false);
      class_704.method_4034(var1, 6, var0.applicationInfo, var2, false);
      class_704.method_4034(var1, 7, var0.field_1465, var2, false);
      class_704.method_4038(var1, 8, var0.field_1466, false);
      class_704.method_4038(var1, 9, var0.field_1467, false);
      class_704.method_4038(var1, 10, var0.field_1468, false);
      class_704.method_4034(var1, 11, var0.field_1460, var2, false);
      class_704.method_4031(var1, 12, var0.field_1469, false);
      class_704.method_4050(var1, 13, var0.field_1470);
      class_704.method_4049(var1, 14, var0.field_1462, false);
      class_704.method_4031(var1, 15, var0.field_1471, false);
      class_704.method_4041(var1, 16, var0.field_1472);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_2883(var1);
   }

   // $FF: renamed from: h (android.os.Parcel) com.google.android.gms.internal.fh
   public class_440 method_2883(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      Bundle var4 = null;
      class_218 var5 = null;
      class_237 var6 = null;
      String var7 = null;
      ApplicationInfo var8 = null;
      PackageInfo var9 = null;
      String var10 = null;
      String var11 = null;
      String var12 = null;
      class_369 var13 = null;
      Bundle var14 = null;
      int var15 = 0;
      ArrayList var16 = null;
      Bundle var17 = null;
      boolean var18 = false;

      while(var1.dataPosition() < var2) {
         int var19 = class_705.method_4058(var1);
         switch(class_705.method_4065(var19)) {
         case 1:
            var3 = class_705.method_4073(var1, var19);
            break;
         case 2:
            var4 = class_705.method_4083(var1, var19);
            break;
         case 3:
            var5 = (class_218)class_705.method_4061(var1, var19, class_218.CREATOR);
            break;
         case 4:
            var6 = (class_237)class_705.method_4061(var1, var19, class_237.CREATOR);
            break;
         case 5:
            var7 = class_705.method_4081(var1, var19);
            break;
         case 6:
            var8 = (ApplicationInfo)class_705.method_4061(var1, var19, ApplicationInfo.CREATOR);
            break;
         case 7:
            var9 = (PackageInfo)class_705.method_4061(var1, var19, PackageInfo.CREATOR);
            break;
         case 8:
            var10 = class_705.method_4081(var1, var19);
            break;
         case 9:
            var11 = class_705.method_4081(var1, var19);
            break;
         case 10:
            var12 = class_705.method_4081(var1, var19);
            break;
         case 11:
            var13 = (class_369)class_705.method_4061(var1, var19, class_369.CREATOR);
            break;
         case 12:
            var14 = class_705.method_4083(var1, var19);
            break;
         case 13:
            var15 = class_705.method_4073(var1, var19);
            break;
         case 14:
            var16 = class_705.method_4055(var1, var19);
            break;
         case 15:
            var17 = class_705.method_4083(var1, var19);
            break;
         case 16:
            var18 = class_705.method_4069(var1, var19);
            break;
         default:
            class_705.method_4066(var1, var19);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_440(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18);
      }
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_2884(var1);
   }

   // $FF: renamed from: q (int) com.google.android.gms.internal.fh[]
   public class_440[] method_2884(int var1) {
      return new class_440[var1];
   }
}
