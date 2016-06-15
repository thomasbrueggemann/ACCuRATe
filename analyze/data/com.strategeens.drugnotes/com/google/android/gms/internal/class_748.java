package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_747;
import com.google.android.gms.internal.class_749;
import com.google.android.gms.internal.oc;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.internal.od
public class class_748 implements Creator<oc> {
   // $FF: renamed from: a (com.google.android.gms.internal.oc, android.os.Parcel, int) void
   static void method_4319(class_749 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4038(var1, 1, var0.getName(), false);
      class_704.method_4050(var1, 1000, var0.field_3410);
      class_704.method_4034(var1, 2, var0.method_4322(), var2, false);
      class_704.method_4038(var1, 3, var0.getAddress(), false);
      class_704.method_4051(var1, 4, var0.method_4323(), false);
      class_704.method_4038(var1, 5, var0.getPhoneNumber(), false);
      class_704.method_4038(var1, 6, var0.method_4324(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cU (android.os.Parcel) com.google.android.gms.internal.oc
   public class_749 method_4320(Parcel var1) {
      String var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      ArrayList var6 = null;
      String var7 = null;
      LatLng var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var9 = class_705.method_4081(var1, var10);
            break;
         case 2:
            var8 = (LatLng)class_705.method_4061(var1, var10, LatLng.CREATOR);
            break;
         case 3:
            var7 = class_705.method_4081(var1, var10);
            break;
         case 4:
            var6 = class_705.method_4068(var1, var10, class_747.CREATOR);
            break;
         case 5:
            var5 = class_705.method_4081(var1, var10);
            break;
         case 6:
            var2 = class_705.method_4081(var1, var10);
            break;
         case 1000:
            var4 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_749(var4, var9, var8, var7, var6, var5, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4320(var1);
   }

   // $FF: renamed from: eQ (int) com.google.android.gms.internal.oc[]
   public class_749[] method_4321(int var1) {
      return new class_749[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4321(var1);
   }
}
