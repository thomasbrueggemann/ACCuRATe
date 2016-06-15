package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;
import com.google.android.gms.drive.internal.OnEventResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.aj
public class class_791 implements Creator<OnEventResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnEventResponse, android.os.Parcel, int) void
   static void method_4410(OnEventResponse var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_2891);
      class_599.method_3381(var1, 2, var0.field_2888);
      class_599.method_3365(var1, 3, var0.field_2889, var2, false);
      class_599.method_3365(var1, 4, var0.field_2890, var2, false);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ak (android.os.Parcel) com.google.android.gms.drive.internal.OnEventResponse
   public OnEventResponse method_4411(Parcel var1) {
      FileConflictEvent var2 = null;
      int var3 = 0;
      int var4 = class_600.method_3385(var1);
      ChangeEvent var5 = null;

      int var6;
      FileConflictEvent var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         ChangeEvent var9;
         int var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var3;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            int var14 = class_600.method_3402(var1, var7);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            ChangeEvent var12 = (ChangeEvent)class_600.method_3390(var1, var7, ChangeEvent.CREATOR);
            var10 = var3;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
            var8 = (FileConflictEvent)class_600.method_3390(var1, var7, FileConflictEvent.CREATOR);
            var9 = var5;
            var10 = var3;
            var11 = var6;
            break;
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var3;
            var11 = var6;
         }

         var6 = var11;
         var3 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new OnEventResponse(var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: bg (int) com.google.android.gms.drive.internal.OnEventResponse[]
   public OnEventResponse[] method_4412(int var1) {
      return new OnEventResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4411(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4412(var1);
   }
}
