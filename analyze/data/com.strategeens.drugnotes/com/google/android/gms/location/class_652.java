package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_757;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.location.a
public class class_652 implements Creator<GeofencingRequest> {
   // $FF: renamed from: a (com.google.android.gms.location.GeofencingRequest, android.os.Parcel, int) void
   static void method_3722(GeofencingRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.method_5100(), false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.getInitialTrigger());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cI (android.os.Parcel) com.google.android.gms.location.GeofencingRequest
   public GeofencingRequest method_3723(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      ArrayList var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4068(var1, var6, class_757.CREATOR);
            break;
         case 2:
            var2 = class_705.method_4073(var1, var6);
            break;
         case 1000:
            var5 = class_705.method_4073(var1, var6);
            break;
         default:
            class_705.method_4066(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new GeofencingRequest(var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3723(var1);
   }

   // $FF: renamed from: ex (int) com.google.android.gms.location.GeofencingRequest[]
   public GeofencingRequest[] method_3724(int var1) {
      return new GeofencingRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3724(var1);
   }
}
