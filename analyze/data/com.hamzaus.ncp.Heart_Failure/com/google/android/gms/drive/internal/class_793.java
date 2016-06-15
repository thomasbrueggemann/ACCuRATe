package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_599;
import com.google.android.gms.common.internal.safeparcel.class_600;
import com.google.android.gms.drive.internal.OnDownloadProgressResponse;

// $FF: renamed from: com.google.android.gms.drive.internal.ah
public class class_793 implements Creator<OnDownloadProgressResponse> {
   // $FF: renamed from: a (com.google.android.gms.drive.internal.OnDownloadProgressResponse, android.os.Parcel, int) void
   static void method_4416(OnDownloadProgressResponse var0, Parcel var1, int var2) {
      int var3 = class_599.method_3354(var1);
      class_599.method_3381(var1, 1, var0.field_3071);
      class_599.method_3361(var1, 2, var0.field_3069);
      class_599.method_3361(var1, 3, var0.field_3070);
      class_599.method_3357(var1, var3);
   }

   // $FF: renamed from: ai (android.os.Parcel) com.google.android.gms.drive.internal.OnDownloadProgressResponse
   public OnDownloadProgressResponse method_4417(Parcel var1) {
      long var2 = 0L;
      int var4 = class_600.method_3385(var1);
      int var5 = 0;
      long var6 = var2;

      while(var1.dataPosition() < var4) {
         int var8 = class_600.method_3383(var1);
         switch(class_600.method_3394(var8)) {
         case 1:
            var5 = class_600.method_3402(var1, var8);
            break;
         case 2:
            var6 = class_600.method_3404(var1, var8);
            break;
         case 3:
            var2 = class_600.method_3404(var1, var8);
            break;
         default:
            class_600.method_3395(var1, var8);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new class_600.class_1103("Overread allowed size end=" + var4, var1);
      } else {
         return new OnDownloadProgressResponse(var5, var6, var2);
      }
   }

   // $FF: renamed from: be (int) com.google.android.gms.drive.internal.OnDownloadProgressResponse[]
   public OnDownloadProgressResponse[] method_4418(int var1) {
      return new OnDownloadProgressResponse[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4417(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4418(var1);
   }
}
