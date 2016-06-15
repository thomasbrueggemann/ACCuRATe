package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.class_704;
import com.google.android.gms.common.internal.safeparcel.class_705;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import java.util.ArrayList;

// $FF: renamed from: com.google.android.gms.fitness.request.d
public class class_508 implements Creator<DataDeleteRequest> {
   // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest, android.os.Parcel, int) void
   static void method_3184(DataDeleteRequest var0, Parcel var1, int var2) {
      int var3 = class_704.method_4025(var1);
      class_704.method_4030(var1, 1, var0.method_5335());
      class_704.method_4050(var1, 1000, var0.getVersionCode());
      class_704.method_4030(var1, 2, var0.method_5336());
      class_704.method_4051(var1, 3, var0.getDataSources(), false);
      class_704.method_4051(var1, 4, var0.getDataTypes(), false);
      class_704.method_4051(var1, 5, var0.getSessions(), false);
      class_704.method_4041(var1, 6, var0.method_5333());
      class_704.method_4041(var1, 7, var0.method_5334());
      class_704.method_4026(var1, var3);
   }

   // $FF: renamed from: bJ (android.os.Parcel) com.google.android.gms.fitness.request.DataDeleteRequest
   public DataDeleteRequest method_3185(Parcel var1) {
      long var2 = 0L;
      ArrayList var4 = null;
      boolean var5 = false;
      int var6 = class_705.method_4059(var1);
      boolean var7 = false;
      ArrayList var8 = null;
      ArrayList var9 = null;
      long var10 = var2;
      int var12 = 0;

      while(var1.dataPosition() < var6) {
         int var13 = class_705.method_4058(var1);
         switch(class_705.method_4065(var13)) {
         case 1:
            var10 = class_705.method_4075(var1, var13);
            break;
         case 2:
            var2 = class_705.method_4075(var1, var13);
            break;
         case 3:
            var9 = class_705.method_4068(var1, var13, DataSource.CREATOR);
            break;
         case 4:
            var8 = class_705.method_4068(var1, var13, DataType.CREATOR);
            break;
         case 5:
            var4 = class_705.method_4068(var1, var13, Session.CREATOR);
            break;
         case 6:
            var7 = class_705.method_4069(var1, var13);
            break;
         case 7:
            var5 = class_705.method_4069(var1, var13);
            break;
         case 1000:
            var12 = class_705.method_4073(var1, var13);
            break;
         default:
            class_705.method_4066(var1, var13);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new class_705.class_1425("Overread allowed size end=" + var6, var1);
      } else {
         return new DataDeleteRequest(var12, var10, var2, var9, var8, var4, var7, var5);
      }
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.method_3185(var1);
   }

   // $FF: renamed from: dd (int) com.google.android.gms.fitness.request.DataDeleteRequest[]
   public DataDeleteRequest[] method_3186(int var1) {
      return new DataDeleteRequest[var1];
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.method_3186(var1);
   }
}
