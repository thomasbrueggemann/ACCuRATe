package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.an
public class class_1015 implements Creator<OnDownloadProgressResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse, android.os.Parcel, int) void
   static void method_5594(OnDownloadProgressResponse var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.field_2934);
      class_704.method_4030(var1, 2, var0.field_2935);
      class_704.method_4030(var1, 3, var0.field_2936);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: as (android.os.Parcel) com.google.android.gms.drive.internal.OnDownloadProgressResponse
   public OnDownloadProgressResponse method_5595(Parcel var1) {
      long var2 = 0L;
      int var4 = class_705.method_4059(var1);
      int var5 = 0;
      long var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = class_705.method_4058(var1);
         switch(class_705.method_4065(var8)) {
         case 1:
            var5 = class_705.method_4073(var1, var8);
            break;
         case 2:
            var6 = class_705.method_4075(var1, var8);
            break;
         case 3:
            var2 = class_705.method_4075(var1, var8);
            break;
         default:
            class_705.method_4066(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_705.class_1425("Overread allowed size end=" + var4, var1);
      } else {
         return new OnDownloadProgressResponse(var5, var6, var2);
      }
   }

   // $FF: renamed from: bH (int) com.google.android.gms.drive.internal.OnDownloadProgressResponse[]
   public OnDownloadProgressResponse[] method_5596(int var1) {
      return new OnDownloadProgressResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5595(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5596(var1);
   }
}
