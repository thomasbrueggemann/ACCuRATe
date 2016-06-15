package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.ListParentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.ad
public class class_796 implements Creator<ListParentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.ListParentsRequest, android.os.Parcel, int) void
   static void method_4425(ListParentsRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2692);
      class_599.method_3365(var1, 2, var0.field_2691, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: af (android.os.Parcel) com.google.android.gms.drive.internal.ListParentsRequest
   public ListParentsRequest method_4426(Parcel var1) {
      int var2 = class_600.method_3385(var1);
      int var3 = 0;
      DriveId var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = class_600.method_3383(var1);
         switch(class_600.method_3394(var5)) {
         case 1:
            var3 = class_600.method_3402(var1, var5);
            break;
         case 2:
            var4 = (DriveId)class_600.method_3390(var1, var5, DriveId.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_600.class_1103("Overread allowed size end=" + var2, var1);
      } else {
         return new ListParentsRequest(var3, var4);
      }
   }

   // $FF: renamed from: bb (int) com.google.android.gms.drive.internal.ListParentsRequest[]
   public ListParentsRequest[] method_4427(int var1) {
      return new ListParentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4426(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4427(var1);
   }
}
