package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.internal.CreateContentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.h
public class class_274 implements Creator<CreateContentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateContentsRequest, android.os.Parcel, int) void
   static void method_1741(CreateContentsRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4180);
      class_704.method_4050(var1, 2, var0.field_4181);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: af (android.os.Parcel) com.google.android.gms.drive.internal.CreateContentsRequest
   public CreateContentsRequest method_1742(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      int var4 = 536870912;

      while(var1.dataPosition() < var2) {
         int var5 = class_705.method_4058(var1);
         switch(class_705.method_4065(var5)) {
         case 1:
            var3 = class_705.method_4073(var1, var5);
            break;
         case 2:
            var4 = class_705.method_4073(var1, var5);
            break;
         default:
            class_705.method_4066(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new CreateContentsRequest(var3, var4);
      }
   }

   // $FF: renamed from: bp (int) com.google.android.gms.drive.internal.CreateContentsRequest[]
   public CreateContentsRequest[] method_1743(int var1) {
      return new CreateContentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1742(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1743(var1);
   }
}
