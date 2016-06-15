package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.internal.OnResourceIdSetResponse;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.drive.internal.ao
public class class_787 implements Creator<OnResourceIdSetResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnResourceIdSetResponse, android.os.Parcel, int) void
   static void method_4398(OnResourceIdSetResponse var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.getVersionCode());
      class_599.method_3370(var1, 2, var0.method_3103(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ap (android.os.Parcel) com.google.android.gms.drive.internal.OnResourceIdSetResponse
   public OnResourceIdSetResponse method_4399(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      ArrayList var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = class_600.method_3386(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new OnResourceIdSetResponse(var3, var4);
      }
   }

   // $FF: renamed from: bl (int) com.google.android.gms.drive.internal.OnResourceIdSetResponse[]
   public OnResourceIdSetResponse[] method_4400(int var1) {
      return new OnResourceIdSetResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4399(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4400(var1);
   }
}
