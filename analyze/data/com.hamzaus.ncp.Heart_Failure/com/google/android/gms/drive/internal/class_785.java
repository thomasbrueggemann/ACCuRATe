package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.internal.OnSyncMoreResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.aq
public class class_785 implements Creator<OnSyncMoreResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnSyncMoreResponse, android.os.Parcel, int) void
   static void method_4392(OnSyncMoreResponse var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4030);
      class_599.method_3372(var1, 2, var0.field_4029);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ar (android.os.Parcel) com.google.android.gms.drive.internal.OnSyncMoreResponse
   public OnSyncMoreResponse method_4393(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;

      while(var1.dataPosition() < var3) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var4 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var2 = class_600.method_3398(var1, var5);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new OnSyncMoreResponse(var4, var2);
      }
   }

   // $FF: renamed from: bn (int) com.google.android.gms.drive.internal.OnSyncMoreResponse[]
   public OnSyncMoreResponse[] method_4394(int var1) {
      return new OnSyncMoreResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4393(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4394(var1);
   }
}
