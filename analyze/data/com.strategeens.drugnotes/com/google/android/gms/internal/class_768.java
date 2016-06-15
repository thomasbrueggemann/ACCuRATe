package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.internal.class_767;
import com.google.android.gms.internal.class_770;
import com.google.android.gms.internal.nl;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

// $FF: renamed from: com.google.android.gms.internal.nm
public class class_768 implements Creator<nl> {
   // $FF: renamed from: a (com.google.android.gms.internal.nl, android.os.Parcel, int) void
   static void method_4380(class_767 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.field_3427, var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4041(var1, 2, var0.ahh);
      class_704.method_4041(var1, 3, var0.ahi);
      class_704.method_4041(var1, 4, var0.ahj);
      class_704.method_4051(var1, 5, var0.ahk, false);
      class_704.method_4038(var1, 6, var0.mTag, false);
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: cM (android.os.Parcel) com.google.android.gms.internal.nl
   public class_767 method_4381(Parcel var1) {
      String var2 = null;
      boolean var3 = true;
      boolean var4 = false;
      int var5 = class_705.method_4059(var1);
      Object var6 = class_767.ahg;
      boolean var7 = var3;
      LocationRequest var8 = null;
      int var9 = 0;

      while(var1.dataPosition() < var5) {
         int var10 = class_705.method_4058(var1);
         switch(class_705.method_4065(var10)) {
         case 1:
            var8 = (LocationRequest)class_705.method_4061(var1, var10, LocationRequest.CREATOR);
            break;
         case 2:
            var4 = class_705.method_4069(var1, var10);
            break;
         case 3:
            var7 = class_705.method_4069(var1, var10);
            break;
         case 4:
            var3 = class_705.method_4069(var1, var10);
            break;
         case 5:
            var6 = class_705.method_4068(var1, var10, class_770.CREATOR);
            break;
         case 6:
            var2 = class_705.method_4081(var1, var10);
            break;
         case 1000:
            var9 = class_705.method_4073(var1, var10);
            break;
         default:
            class_705.method_4066(var1, var10);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new class_705.class_1425("Overread allowed size end=" + var5, var1);
      } else {
         return new class_767(var9, var8, var4, var7, var3, (List)var6, var2);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_4381(var1);
   }

   // $FF: renamed from: eG (int) com.google.android.gms.internal.nl[]
   public class_767[] method_4382(int var1) {
      return new class_767[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_4382(var1);
   }
}
