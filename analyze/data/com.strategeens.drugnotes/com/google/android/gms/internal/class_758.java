package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_757;
import com.google.android.gms.internal.nn;

// $FF: renamed from: com.google.android.gms.internal.no
public class class_758 implements Creator<nn> {
   // $FF: renamed from: a (com.google.android.gms.internal.nn, android.os.Parcel, int) void
   static void method_4350(class_757 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getRequestId(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.getExpirationTime());
      class_704.method_4040(var1, 3, var0.method_4346());
      class_704.method_4028(var1, 4, var0.getLatitude());
      class_704.method_4028(var1, 5, var0.getLongitude());
      class_704.method_4029(var1, 6, var0.method_4347());
      class_704.method_4050(var1, 7, var0.method_4348());
      class_704.method_4050(var1, 8, var0.getNotificationResponsiveness());
      class_704.method_4050(var1, 9, var0.method_4349());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cN (android.os.Parcel) com.google.android.gms.internal.nn
   public class_757 method_4351(Parcel var1) {
      int var2 = class_705.method_4059(var1);
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
         int var16 = class_705.method_4058(var1);
         switch(class_705.method_4065(var16)) {
         case 1:
            var4 = class_705.method_4081(var1, var16);
            break;
         case 2:
            var12 = class_705.method_4075(var1, var16);
            break;
         case 3:
            var6 = class_705.method_4072(var1, var16);
            break;
         case 4:
            var7 = class_705.method_4079(var1, var16);
            break;
         case 5:
            var9 = class_705.method_4079(var1, var16);
            break;
         case 6:
            var11 = class_705.method_4078(var1, var16);
            break;
         case 7:
            var5 = class_705.method_4073(var1, var16);
            break;
         case 8:
            var14 = class_705.method_4073(var1, var16);
            break;
         case 9:
            var15 = class_705.method_4073(var1, var16);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var16);
            break;
         default:
            class_705.method_4066(var1, var16);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_757(var3, var4, var5, var6, var7, var9, var11, var12, var14, var15);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4351(var1);
   }

   // $FF: renamed from: eJ (int) com.google.android.gms.internal.nn[]
   public class_757[] method_4352(int var1) {
      return new class_757[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4352(var1);
   }
}
