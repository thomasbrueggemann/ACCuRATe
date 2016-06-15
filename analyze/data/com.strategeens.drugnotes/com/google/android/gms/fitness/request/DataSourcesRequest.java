package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_505;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_724;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
   public static final Creator<DataSourcesRequest> CREATOR = new class_505();
   // $FF: renamed from: CK int
   private final int field_3612;
   // $FF: renamed from: TY java.util.List
   private final List<DataType> field_3613;
   // $FF: renamed from: VS java.util.List
   private final List<Integer> field_3614;
   // $FF: renamed from: VT boolean
   private final boolean field_3615;

   DataSourcesRequest(int var1, List<DataType> var2, List<Integer> var3, boolean var4) {
      this.field_3612 = var1;
      this.field_3613 = var2;
      this.field_3614 = var3;
      this.field_3615 = var4;
   }

   private DataSourcesRequest(DataSourcesRequest.Builder var1) {
      this.field_3612 = 2;
      this.field_3613 = class_724.method_4215(var1.field_3285);
      this.field_3614 = Arrays.asList(class_724.method_4214(var1.field_3286));
      this.field_3615 = var1.field_3284;
   }

   // $FF: synthetic method
   DataSourcesRequest(DataSourcesRequest.Builder var1, Object var2) {
      this(var1);
   }

   public int describeContents() {
      return 0;
   }

   public List<DataType> getDataTypes() {
      return Collections.unmodifiableList(this.field_3613);
   }

   int getVersionCode() {
      return this.field_3612;
   }

   // $FF: renamed from: jY () boolean
   public boolean method_4815() {
      return this.field_3615;
   }

   // $FF: renamed from: jZ () java.util.List
   List<Integer> method_4816() {
      return this.field_3614;
   }

   public String toString() {
      class_336.class_1339 var1 = class_336.method_2312(this).method_3424("dataTypes", this.field_3613).method_3424("sourceTypes", this.field_3614);
      if(this.field_3615) {
         var1.method_3424("includeDbOnlySources", "true");
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_505.method_3177(this, var1, var2);
   }

   public static class Builder {
      // $FF: renamed from: VT boolean
      private boolean field_3284 = false;
      // $FF: renamed from: VU com.google.android.gms.fitness.data.DataType[]
      private DataType[] field_3285 = new DataType[0];
      // $FF: renamed from: VV int[]
      private int[] field_3286 = new int[]{0, 1};

      public DataSourcesRequest build() {
         boolean var1 = true;
         boolean var2;
         if(this.field_3285.length > 0) {
            var2 = var1;
         } else {
            var2 = false;
         }

         class_335.method_2302(var2, "Must add at least one data type");
         if(this.field_3286.length <= 0) {
            var1 = false;
         }

         class_335.method_2302(var1, "Must add at least one data source type");
         return new DataSourcesRequest(this);
      }

      public DataSourcesRequest.Builder setDataSourceTypes(int... var1) {
         this.field_3286 = var1;
         return this;
      }

      public DataSourcesRequest.Builder setDataTypes(DataType... var1) {
         this.field_3285 = var1;
         return this;
      }
   }
}
