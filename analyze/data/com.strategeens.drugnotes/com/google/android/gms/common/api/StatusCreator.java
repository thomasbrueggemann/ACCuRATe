package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;

public class StatusCreator implements Creator<Status> {
   public static final int CONTENT_DESCRIPTION;

   // $FF: renamed from: a (com.google.android.gms.common.api.Status, android.os.Parcel, int) void
   static void method_4095(Status var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getStatusCode());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getStatusMessage(), false);
      class_704.method_4034(var1, 3, var0.method_5232(), var2, false);
      class_704.method_4026(var1, var3);
   }

   public Status createFromParcel(Parcel var1) {
      PendingIntent var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      String var5 = null;
      int var6 = 0;

      while(var1.dataPosition() < var4) {
         int var7 = class_705.method_4058(var1);
         switch(class_705.method_4065(var7)) {
         case 1:
            var3 = class_705.method_4073(var1, var7);
            break;
         case 2:
            var5 = class_705.method_4081(var1, var7);
            break;
         case 3:
            var2 = (PendingIntent)class_705.method_4061(var1, var7, PendingIntent.CREATOR);
            break;
         case 1000:
            var6 = class_705.method_4073(var1, var7);
            break;
         default:
            class_705.method_4066(var1, var7);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new Status(var6, var3, var5, var2);
      }
   }

   public Status[] newArray(int var1) {
      return new Status[var1];
   }
}
