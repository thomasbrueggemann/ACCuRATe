package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.internal.OnEventResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.aq
public class class_1014 implements Creator<OnEventResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnEventResponse, android.os.Parcel, int) void
   static void method_5591(OnEventResponse var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2742);
      class_704.method_4050(var1, 2, var0.field_2743);
      class_704.method_4034(var1, 3, var0.field_2744, var2, false);
      class_704.method_4034(var1, 5, var0.field_2745, var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: av (android.os.Parcel) com.google.android.gms.drive.internal.OnEventResponse
   public OnEventResponse method_5592(Parcel var1) {
      CompletionEvent var2 = null;
      int var3 = 0;
      int var4 = class_705.method_4059(var1);
      ChangeEvent var5 = null;

      int var6;
      CompletionEvent var8;
      for(var6 = 0; var1.dataPosition() < var4; var2 = var8) {
         int var7 = class_705.method_4058(var1);
         ChangeEvent var9;
         int var10;
         int var11;
         switch(class_705.method_4065(var7)) {
         case 1:
            int var16 = class_705.method_4073(var1, var7);
            var9 = var5;
            var10 = var3;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            int var14 = class_705.method_4073(var1, var7);
            var11 = var6;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
            ChangeEvent var12 = (ChangeEvent)class_705.method_4061(var1, var7, ChangeEvent.CREATOR);
            var10 = var3;
            var11 = var6;
            var9 = var12;
            var8 = var2;
            break;
         case 4:
         default:
            class_705.method_4066(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var3;
            var11 = var6;
            break;
         case 5:
            var8 = (CompletionEvent)class_705.method_4061(var1, var7, CompletionEvent.CREATOR);
            var9 = var5;
            var10 = var3;
            var11 = var6;
         }

         var6 = var11;
         var3 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new OnEventResponse(var6, var3, var5, var2);
      }
   }

   // $FF: renamed from: bK (int) com.google.android.gms.drive.internal.OnEventResponse[]
   public OnEventResponse[] method_5593(int var1) {
      return new OnEventResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5592(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5593(var1);
   }
}
