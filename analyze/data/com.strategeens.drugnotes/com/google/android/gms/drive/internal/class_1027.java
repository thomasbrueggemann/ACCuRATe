package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.RemoveEventListenerRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.bc
public class class_1027 implements Creator<RemoveEventListenerRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.RemoveEventListenerRequest, android.os.Parcel, int) void
   static void method_5633(RemoveEventListenerRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3659);
      class_704.method_4034(var1, 2, var0.field_3660, var2, false);
      class_704.method_4050(var1, 3, var0.field_3661);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: aG (android.os.Parcel) com.google.android.gms.drive.internal.RemoveEventListenerRequest
   public RemoveEventListenerRequest method_5634(Parcel var1) {
      int var2 = 0;
      int var3 = class_705.method_4059(var1);
      DriveId var4 = null;

      int var5;
      int var7;
      for(var5 = 0; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         DriveId var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var4;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            DriveId var10 = (DriveId)class_705.method_4061(var1, var6, DriveId.CREATOR);
            var9 = var5;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_705.method_4073(var1, var6);
            var8 = var4;
            var9 = var5;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var4;
            var9 = var5;
         }

         var5 = var9;
         var4 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new RemoveEventListenerRequest(var5, var4, var2);
      }
   }

   // $FF: renamed from: bV (int) com.google.android.gms.drive.internal.RemoveEventListenerRequest[]
   public RemoveEventListenerRequest[] method_5635(int var1) {
      return new RemoveEventListenerRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5634(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5635(var1);
   }
}
