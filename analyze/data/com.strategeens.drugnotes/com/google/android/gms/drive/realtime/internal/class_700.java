package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest;

// $FF: renamed from: com.google.android.gms.drive.realtime.internal.b
public class class_700 implements Creator<EndCompoundOperationRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, android.os.Parcel, int) void
   static void method_4007(EndCompoundOperationRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_4351);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bd (android.os.Parcel) com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest
   public EndCompoundOperationRequest method_4008(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;

      while(var1.dataPosition() < var2) {
         int var4 = class_705.method_4058(var1);
         switch(class_705.method_4065(var4)) {
         case 1:
            var3 = class_705.method_4073(var1, var4);
            break;
         default:
            class_705.method_4066(var1, var4);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new EndCompoundOperationRequest(var3);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4008(var1);
   }

   // $FF: renamed from: cs (int) com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest[]
   public EndCompoundOperationRequest[] method_4009(int var1) {
      return new EndCompoundOperationRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4009(var1);
   }
}
