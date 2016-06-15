package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// $FF: renamed from: com.google.android.gms.drive.internal.j
public class class_276 implements Creator<CreateFileIntentSenderRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, android.os.Parcel, int) void
   static void method_1748(CreateFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3781);
      class_704.method_4034(var1, 2, var0.field_3784, var2, false);
      class_704.method_4050(var1, 3, var0.field_3786);
      class_704.method_4038(var1, 4, var0.field_3782, false);
      class_704.method_4034(var1, 5, var0.field_3783, var2, false);
      class_704.method_4036(var1, 6, var0.field_3785, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ag (android.os.Parcel) com.google.android.gms.drive.internal.CreateFileIntentSenderRequest
   public CreateFileIntentSenderRequest method_1749(Parcel var1) {
      int var2 = 0;
      Integer var3 = null;
      int var4 = class_705.method_4059(var1);
      DriveId var5 = null;
      String var6 = null;
      MetadataBundle var7 = null;
      int var8 = 0;

      while(var1.dataPosition() < var4) {
         int var9 = class_705.method_4058(var1);
         switch(class_705.method_4065(var9)) {
         case 1:
            var8 = class_705.method_4073(var1, var9);
            break;
         case 2:
            var7 = (MetadataBundle)class_705.method_4061(var1, var9, MetadataBundle.CREATOR);
            break;
         case 3:
            var2 = class_705.method_4073(var1, var9);
            break;
         case 4:
            var6 = class_705.method_4081(var1, var9);
            break;
         case 5:
            var5 = (DriveId)class_705.method_4061(var1, var9, DriveId.CREATOR);
            break;
         case 6:
            var3 = class_705.method_4074(var1, var9);
            break;
         default:
            class_705.method_4066(var1, var9);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new CreateFileIntentSenderRequest(var8, var7, var2, var6, var5, var3);
      }
   }

   // $FF: renamed from: br (int) com.google.android.gms.drive.internal.CreateFileIntentSenderRequest[]
   public CreateFileIntentSenderRequest[] method_1750(int var1) {
      return new CreateFileIntentSenderRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1749(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1750(var1);
   }
}
