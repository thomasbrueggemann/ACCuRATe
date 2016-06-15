package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.internal.CloseContentsRequest;

// $FF: renamed from: com.google.android.gms.drive.internal.g
public class class_273 implements Creator<CloseContentsRequest> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.CloseContentsRequest, android.os.Parcel, int) void
   static void method_1738(CloseContentsRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_3927);
      class_704.method_4034(var1, 2, var0.field_3928, var2, false);
      class_704.method_4035(var1, 3, var0.field_3929, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: ae (android.os.Parcel) com.google.android.gms.drive.internal.CloseContentsRequest
   public CloseContentsRequest method_1739(Parcel var1) {
      Boolean var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;

      Contents var5;
      Boolean var7;
      for(var5 = null; var1.dataPosition() < var3; var2 = var7) {
         int var6 = class_705.method_4058(var1);
         Contents var8;
         int var9;
         switch(class_705.method_4065(var6)) {
         case 1:
            int var11 = class_705.method_4073(var1, var6);
            var8 = var5;
            var9 = var11;
            var7 = var2;
            break;
         case 2:
            Contents var10 = (Contents)class_705.method_4061(var1, var6, Contents.CREATOR);
            var9 = var4;
            var7 = var2;
            var8 = var10;
            break;
         case 3:
            var7 = class_705.method_4070(var1, var6);
            var8 = var5;
            var9 = var4;
            break;
         default:
            class_705.method_4066(var1, var6);
            var7 = var2;
            var8 = var5;
            var9 = var4;
         }

         var4 = var9;
         var5 = var8;
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new CloseContentsRequest(var4, var5, var2);
      }
   }

   // $FF: renamed from: bo (int) com.google.android.gms.drive.internal.CloseContentsRequest[]
   public CloseContentsRequest[] method_1740(int var1) {
      return new CloseContentsRequest[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_1739(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_1740(var1);
   }
}
