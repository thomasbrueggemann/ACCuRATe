package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.cast.a
public class class_977 implements Creator<ApplicationMetadata> {
   // $FF: renamed from: a (com.google.android.gms.cast.ApplicationMetadata, android.os.Parcel, int) void
   static void method_5439(ApplicationMetadata var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4050(var1, 1, var0.getVersionCode());
      class_704.method_4038(var1, 2, var0.getApplicationId(), false);
      class_704.method_4038(var1, 3, var0.getName(), false);
      class_704.method_4051(var1, 4, var0.getImages(), false);
      class_704.method_4049(var1, 5, var0.field_3677, false);
      class_704.method_4038(var1, 6, var0.getSenderAppIdentifier(), false);
      class_704.method_4034(var1, 7, var0.method_4830(), var2, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: V (int) com.google.android.gms.cast.ApplicationMetadata[]
   public ApplicationMetadata[] method_5440(int var1) {
      return new ApplicationMetadata[var1];
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_5441(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_5440(var1);
   }

   // $FF: renamed from: u (android.os.Parcel) com.google.android.gms.cast.ApplicationMetadata
   public ApplicationMetadata method_5441(Parcel var1) {
      Uri var2 = null;
      int var3 = class_705.method_4059(var1);
      int var4 = 0;
      String var5 = null;
      ArrayList var6 = null;
      ArrayList var7 = null;
      String var8 = null;
      String var9 = null;

      while(var1.dataPosition() < var3) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var4 = class_705.method_4073(var1, var10);
            break;
         case 2:
            var9 = class_705.method_4081(var1, var10);
            break;
         case 3:
            var8 = class_705.method_4081(var1, var10);
            break;
         case 4:
            var7 = class_705.method_4068(var1, var10, WebImage.CREATOR);
            break;
         case 5:
            var6 = class_705.method_4055(var1, var10);
            break;
         case 6:
            var5 = class_705.method_4081(var1, var10);
            break;
         case 7:
            var2 = (Uri)class_705.method_4061(var1, var10, Uri.CREATOR);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new class_705.class_1425("Overread allowed size end=" + var3, var1);
      } else {
         return new ApplicationMetadata(var4, var9, var8, var7, var6, var5, var2);
      }
   }
}
