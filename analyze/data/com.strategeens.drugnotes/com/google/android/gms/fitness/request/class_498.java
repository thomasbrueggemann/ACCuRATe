package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_497;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.p
public class class_498 implements Creator<o> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.o, android.os.Parcel, int) void
   static void method_3157(class_497 var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4034(var1, 1, var0.getDataSource(), var2, false);
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4034(var1, 2, var0.getDataType(), var2, false);
      class_704.method_4032(var1, 3, var0.method_3156(), false);
      class_704.method_4050(var1, 4, var0.field_1899);
      class_704.method_4050(var1, 5, var0.field_1900);
      class_704.method_4030(var1, 6, var0.method_3150());
      class_704.method_4030(var1, 7, var0.method_3153());
      class_704.method_4034(var1, 8, var0.method_3151(), var2, false);
      class_704.method_4030(var1, 9, var0.method_3152());
      class_704.method_4050(var1, 10, var0.getAccuracyMode());
      class_704.method_4051(var1, 11, var0.method_3154(), false);
      class_704.method_4030(var1, 12, var0.method_3155());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bQ (android.os.Parcel) com.google.android.gms.fitness.request.o
   public class_497 method_3158(Parcel var1) {
      int var2 = class_705.method_4059(var1);
      int var3 = 0;
      DataSource var4 = null;
      DataType var5 = null;
      IBinder var6 = null;
      int var7 = 0;
      int var8 = 0;
      long var9 = 0L;
      long var11 = 0L;
      PendingIntent var13 = null;
      long var14 = 0L;
      int var16 = 0;
      ArrayList var17 = null;
      long var18 = 0L;

      while(var1.dataPosition() < var2) {
         int var20 = class_705.method_4058(var1);
         switch(class_705.method_4065(var20)) {
         case 1:
            var4 = (DataSource)class_705.method_4061(var1, var20, DataSource.CREATOR);
            break;
         case 2:
            var5 = (DataType)class_705.method_4061(var1, var20, DataType.CREATOR);
            break;
         case 3:
            var6 = class_705.method_4082(var1, var20);
            break;
         case 4:
            var7 = class_705.method_4073(var1, var20);
            break;
         case 5:
            var8 = class_705.method_4073(var1, var20);
            break;
         case 6:
            var9 = class_705.method_4075(var1, var20);
            break;
         case 7:
            var11 = class_705.method_4075(var1, var20);
            break;
         case 8:
            var13 = (PendingIntent)class_705.method_4061(var1, var20, PendingIntent.CREATOR);
            break;
         case 9:
            var14 = class_705.method_4075(var1, var20);
            break;
         case 10:
            var16 = class_705.method_4073(var1, var20);
            break;
         case 11:
            var17 = class_705.method_4068(var1, var20, LocationRequest.CREATOR);
            break;
         case 12:
            var18 = class_705.method_4075(var1, var20);
            break;
         case 1000:
            var3 = class_705.method_4073(var1, var20);
            break;
         default:
            class_705.method_4066(var1, var20);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new class_705.class_1425("Overread allowed size end=" + var2, var1);
      } else {
         return new class_497(var3, var4, var5, var6, var7, var8, var9, var11, var13, var14, var16, var17, var18);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3158(var1);
   }

   // $FF: renamed from: dk (int) com.google.android.gms.fitness.request.o[]
   public class_497[] method_3159(int var1) {
      return new class_497[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3159(var1);
   }
}
