package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.location.DetectedActivity;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.location.DetectedActivity, android.os.Parcel, int) void
   static void method_3497(DetectedActivity var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.agb);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4050(var1, 2, var0.agc);
      class_704.method_4026(var1, var3);
   }

   public DetectedActivity createFromParcel(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_705.method_4058(var1);
         switch(class_705.method_4065(var6)) {
         case 1:
            var4 = class_705.method_4073(var1, var6);
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
         return new DetectedActivity(var5, var4, var2);
      }
   }

   public DetectedActivity[] newArray(int var1) {
      return new DetectedActivity[var1];
   }
}
