package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_496;
import com.google.android.gms.fitness.request.m;

// $FF: renamed from: com.google.android.gms.fitness.request.m
public class class_495 implements SafeParcelable {
   public static final Creator<m> CREATOR = new class_496();
   // $FF: renamed from: CK int
   private final int field_1891;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_1892;

   class_495(int var1, DataType var2) {
      this.field_1891 = var1;
      this.field_1892 = var2;
   }

   private class_495(class_495.class_1283 var1) {
      this.field_1891 = 1;
      this.field_1892 = var1.field_2478;
   }

   // $FF: synthetic method
   class_495(class_495.class_1283 var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public DataType getDataType() {
      return this.field_1892;
   }

   int getVersionCode() {
      return this.field_1891;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_496.method_3146(this, var1, var2);
   }

   public static class class_1283 {
      // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
      private DataType field_2478;

      // $FF: renamed from: c (com.google.android.gms.fitness.data.DataType) com.google.android.gms.fitness.request.m$a
      public class_495.class_1283 method_3243(DataType var1) {
         this.field_2478 = var1;
         return this;
      }

      // $FF: renamed from: ka () com.google.android.gms.fitness.request.m
      public class_495 method_3244() {
         return new class_495(this);
      }
   }
}
