package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.wearable.PutDataRequest;

// $FF: renamed from: com.google.android.gms.wearable.e
public class class_745 implements Creator<PutDataRequest> {
   // $FF: renamed from: a (com.google.android.gms.wearable.PutDataRequest, android.os.Parcel, int) void
   static void method_4265(PutDataRequest var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_677);
      class_599.method_3365(var1, 2, var0.getUri(), var2, false);
      class_599.method_3362(var1, 4, var0.method_1339(), false);
      class_599.method_3373(var1, 5, var0.getData(), false);
      class_599.method_3357(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4266(var1);
   }

   // $FF: renamed from: cu (android.os.Parcel) com.google.android.gms.wearable.PutDataRequest
   public PutDataRequest method_4266(Parcel var1) {
      byte[] var2 = null;
      int var3 = class_600.method_3385(var1);
      int var4 = 0;
      Bundle var5 = null;

      Uri var6;
      byte[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_600.method_3383(var1);
         Bundle var9;
         Uri var10;
         int var11;
         switch(class_600.method_3394(var7)) {
         case 1:
            int var16 = class_600.method_3402(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Uri var14 = (Uri)class_600.method_3390(var1, var7, Uri.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
         default:
            class_600.method_3395(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 4:
            Bundle var12 = class_600.method_3412(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 5:
            var8 = class_600.method_3413(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_600.class_1103("Overread allowed size end=" + var3, var1);
      } else {
         return new PutDataRequest(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: ec (int) com.google.android.gms.wearable.PutDataRequest[]
   public PutDataRequest[] method_4267(int var1) {
      return new PutDataRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4267(var1);
   }
}
