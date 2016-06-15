package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.af;
import com.google.android.gms.fitness.request.class_488;

// $FF: renamed from: com.google.android.gms.fitness.request.ag
public class class_489 implements Creator<af> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.af, android.os.Parcel, int) void
   static void method_3088(class_488 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.method_3086(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4041(var1, 2, var0.method_3087());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ca (android.os.Parcel) com.google.android.gms.fitness.request.af
   public class_488 method_3089(Parcel var1) {
      boolean var2 = false;
      int var3 = class_705.method_4059(var1);
      Subscription var4 = null;

      int var5;
      boolean var7;
      for(var5 = 0; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         Subscription var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            Subscription var12 = (Subscription)class_705.method_4061(var1, var6, Subscription.CREATOR);
            var9 = var5;
            var7 = var2;
            var8 = var12;
            break;
         case 2:
            var7 = class_705.method_4069(var1, var6);
            var8 = var4;
            var9 = var5;
            break;
         case 1000:
            int var10 = class_705.method_4073(var1, var6);
            var8 = var4;
            var9 = var10;
            var7 = var2;
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
         return new class_488(var5, var4, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3089(var1);
   }

   // $FF: renamed from: dv (int) com.google.android.gms.fitness.request.af[]
   public class_488[] method_3090(int var1) {
      return new class_488[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3090(var1);
   }
}
