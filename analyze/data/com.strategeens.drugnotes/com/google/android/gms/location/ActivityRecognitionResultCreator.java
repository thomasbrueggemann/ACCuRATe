package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.location.ActivityRecognitionResult, android.os.Parcel, int) void
   static void method_3401(ActivityRecognitionResult var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4051(var1, 1, var0.afX, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.afY);
      class_704.method_4030(var1, 3, var0.afZ);
      class_704.method_4026(var1, var3);
   }

   public ActivityRecognitionResult createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      ArrayList var6 = null;
      long var7 = var2;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var6 = class_705.method_4068(var1, var9, DetectedActivity.CREATOR);
            break;
         case 2:
            var7 = class_705.method_4075(var1, var9);
            break;
         case 3:
            var2 = class_705.method_4075(var1, var9);
            break;
         case 1000:
            var5 = class_705.method_4073(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new ActivityRecognitionResult(var5, var6, var7, var2);
      }
   }

   public ActivityRecognitionResult[] newArray(int var1) {
      return new ActivityRecognitionResult[var1];
   }
}
