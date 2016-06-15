package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ActivityRecognitionResultCreator implements Creator<ActivityRecognitionResult> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.location.ActivityRecognitionResult, android.os.Parcel, int) void
   static void method_2854(ActivityRecognitionResult var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3380(var1, 1, var0.field_3343, false);
      class_599.method_3381(var1, 1000, var0.getVersionCode());
      class_599.method_3361(var1, 2, var0.field_3344);
      class_599.method_3361(var1, 3, var0.field_3345);
      class_599.method_3357(var1, var3);
   }

   public ActivityRecognitionResult createFromParcel(Parcel var1) {
      long var2 = 0L;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      ArrayList var6 = null;
      long var7 = var2;

      while(var1.dataPosition() < var4) {
         int var9 = class_600.method_3383(var1);
         switch(class_600.method_3394(var9)) {
         case 1:
            var6 = class_600.method_3397(var1, var9, DetectedActivity.CREATOR);
            break;
         case 2:
            var7 = class_600.method_3404(var1, var9);
            break;
         case 3:
            var2 = class_600.method_3404(var1, var9);
            break;
         case 1000:
            var5 = class_600.method_3402(var1, var9);
            break;
         default:
            class_600.method_3395(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new ActivityRecognitionResult(var5, var6, var7, var2);
      }
   }

   public ActivityRecognitionResult[] newArray(int var1) {
      return new ActivityRecognitionResult[var1];
   }
}
