package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.location.LocationRequest;

// $FF: renamed from: com.google.android.gms.location.d
public class class_649 implements Creator<LocationRequest> {
   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest, android.os.Parcel, int) void
   static void method_3718(LocationRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.mPriority);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.agr);
      class_704.method_4030(var1, 3, var0.ags);
      class_704.method_4041(var1, 4, var0.field_3810);
      class_704.method_4030(var1, 5, var0.age);
      class_704.method_4050(var1, 6, var0.agt);
      class_704.method_4029(var1, 7, var0.agu);
      class_704.method_4030(var1, 8, var0.agv);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cJ (android.os.Parcel) com.google.android.gms.location.LocationRequest
   public LocationRequest method_3719(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      int var4 = 102;
      long var5 = 3600000L;
      long var7 = 600000L;
      boolean var9 = false;
      long var10 = Long.MAX_VALUE;
      int var12 = Integer.MAX_VALUE;
      float var13 = 0.0F;
      long var14 = 0L;

      while(var1.dataPosition() < var2) {
         int var16 = class_705.method_4058(var1);
         switch(class_705.method_4065(var16)) {
         case 1:
            var4 = class_705.method_4073(var1, var16);
            break;
         case 2:
            var5 = class_705.method_4075(var1, var16);
            break;
         case 3:
            var7 = class_705.method_4075(var1, var16);
            break;
         case 4:
            var9 = class_705.method_4069(var1, var16);
            break;
         case 5:
            var10 = class_705.method_4075(var1, var16);
            break;
         case 6:
            var12 = class_705.method_4073(var1, var16);
            break;
         case 7:
            var13 = class_705.method_4078(var1, var16);
            break;
         case 8:
            var14 = class_705.method_4075(var1, var16);
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
         return new LocationRequest(var3, var4, var5, var7, var9, var10, var12, var13, var14);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3719(var1);
   }

   // $FF: renamed from: eA (int) com.google.android.gms.location.LocationRequest[]
   public LocationRequest[] method_3720(int var1) {
      return new LocationRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3720(var1);
   }
}
