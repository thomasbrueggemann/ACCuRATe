package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.as
public class class_783 implements Creator<OpenFileIntentSenderRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, android.os.Parcel, int) void
   static void method_4386(OpenFileIntentSenderRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3974);
      class_599.method_3369(var1, 2, var0.field_3971, false);
      class_599.method_3376(var1, 3, var0.field_3972, false);
      class_599.method_3365(var1, 4, var0.field_3973, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: at (android.os.Parcel) com.google.android.gms.drive.internal.OpenFileIntentSenderRequest
   public OpenFileIntentSenderRequest method_4387(Parcel var1) {
      DriveId var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      String[] var5 = null;
      String var6 = null;

      while(var1.dataPosition() < var3) {
         int var7 = class_600.method_3383(var1);
         switch(class_600.method_3394(var7)) {
         case 1:
            var4 = class_600.method_3402(var1, var7);
            break;
         case 2:
            var6 = class_600.method_3410(var1, var7);
            break;
         case 3:
            var5 = class_600.method_3384(var1, var7);
            break;
         case 4:
            var2 = (DriveId)class_600.method_3390(var1, var7, DriveId.CREATOR);
            break;
         default:
            class_600.method_3395(var1, var7);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new OpenFileIntentSenderRequest(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: bp (int) com.google.android.gms.drive.internal.OpenFileIntentSenderRequest[]
   public OpenFileIntentSenderRequest[] method_4388(int var1) {
      return new OpenFileIntentSenderRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4387(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4388(var1);
   }
}
