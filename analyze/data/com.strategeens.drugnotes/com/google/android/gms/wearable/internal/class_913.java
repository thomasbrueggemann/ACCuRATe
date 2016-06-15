package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.wearable.internal.class_908;
import com.google.android.gms.wearable.internal.m;

// $FF: renamed from: com.google.android.gms.wearable.internal.n
public class class_913 implements Creator<m> {
   // $FF: renamed from: a (com.google.android.gms.wearable.internal.m, android.os.Parcel, int) void
   static void method_5076(class_908 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3831);
      class_704.method_4034(var1, 2, var0.getUri(), var2, false);
      class_704.method_4031(var1, 4, var0.method_5060(), false);
      class_704.method_4042(var1, 5, var0.getData(), false);
      class_704.method_4026(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5077(var1);
   }

   // $FF: renamed from: eq (android.os.Parcel) com.google.android.gms.wearable.internal.m
   public class_908 method_5077(Parcel var1) {
      byte[] var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      Bundle var5 = null;

      Uri var6;
      byte[] var8;
      for(var6 = null; var1.dataPosition() < var3; var2 = var8) {
         int var7 = class_705.method_4058(var1);
         Bundle var9;
         Uri var10;
         int var11;
         switch(class_705.method_4065(var7)) {
         case 1:
            int var16 = class_705.method_4073(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var16;
            var8 = var2;
            break;
         case 2:
            Uri var14 = (Uri)class_705.method_4061(var1, var7, Uri.CREATOR);
            var11 = var4;
            var10 = var14;
            var8 = var2;
            var9 = var5;
            break;
         case 3:
         default:
            class_705.method_4066(var1, var7);
            var8 = var2;
            var9 = var5;
            var10 = var6;
            var11 = var4;
            break;
         case 4:
            Bundle var12 = class_705.method_4083(var1, var7);
            var10 = var6;
            var11 = var4;
            var9 = var12;
            var8 = var2;
            break;
         case 5:
            var8 = class_705.method_4084(var1, var7);
            var9 = var5;
            var10 = var6;
            var11 = var4;
         }

         var4 = var11;
         var6 = var10;
         var5 = var9;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new class_908(var4, var6, var5, var2);
      }
   }

   // $FF: renamed from: gz (int) com.google.android.gms.wearable.internal.m[]
   public class_908[] method_5078(int var1) {
      return new class_908[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5078(var1);
   }
}
