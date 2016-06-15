package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.a
public class class_594 implements Creator<BeginCompoundOperationRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest, android.os.Parcel, int) void
   static void method_3337(BeginCompoundOperationRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_4074);
      class_599.method_3372(var1, 2, var0.field_4073);
      class_599.method_3369(var1, 3, var0.mName, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: aP (android.os.Parcel) com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest
   public BeginCompoundOperationRequest method_3338(Parcel var1) {
      boolean var2 = false;
      int var3 = class_600.method_3385(var1);
      String var4 = null;
      int var5 = 0;

      while(var1.dataPosition() < var3) {
         int var6 = class_600.method_3383(var1);
         switch(class_600.method_3394(var6)) {
         case 1:
            var5 = class_600.method_3402(var1, var6);
            break;
         case 2:
            var2 = class_600.method_3398(var1, var6);
            break;
         case 3:
            var4 = class_600.method_3410(var1, var6);
            break;
         default:
            class_600.method_3395(var1, var6);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new BeginCompoundOperationRequest(var5, var2, var4);
      }
   }

   // $FF: renamed from: bL (int) com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest[]
   public BeginCompoundOperationRequest[] method_3339(int var1) {
      return new BeginCompoundOperationRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3338(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3339(var1);
   }
}
