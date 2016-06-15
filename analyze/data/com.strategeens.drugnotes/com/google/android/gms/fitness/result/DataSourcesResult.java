package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.class_929;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
   public static final Creator<DataSourcesResult> CREATOR = new class_929();
   // $FF: renamed from: CK int
   private final int field_2753;
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_2754;
   // $FF: renamed from: VH java.util.List
   private final List<DataSource> field_2755;

   DataSourcesResult(int var1, List<DataSource> var2, Status var3) {
      this.field_2753 = var1;
      this.field_2755 = Collections.unmodifiableList(var2);
      this.field_2754 = var3;
   }

   public DataSourcesResult(List<DataSource> var1, Status var2) {
      this.field_2753 = 3;
      this.field_2755 = Collections.unmodifiableList(var1);
      this.field_2754 = var2;
   }

   // $FF: renamed from: D (com.google.android.gms.common.api.Status) com.google.android.gms.fitness.result.DataSourcesResult
   public static DataSourcesResult method_3610(Status var0) {
      return new DataSourcesResult(Collections.emptyList(), var0);
   }

   // $FF: renamed from: b (com.google.android.gms.fitness.result.DataSourcesResult) boolean
   private boolean method_3611(DataSourcesResult var1) {
      return this.field_2754.equals(var1.field_2754) && class_336.equal(this.field_2755, var1.field_2755);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataSourcesResult && this.method_3611((DataSourcesResult)var1);
   }

   public List<DataSource> getDataSources() {
      return this.field_2755;
   }

   public List<DataSource> getDataSources(DataType var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = this.field_2755.iterator();

      while(var3.hasNext()) {
         DataSource var4 = (DataSource)var3.next();
         if(var4.getDataType().equals(var1)) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableList(var2);
   }

   public Status getStatus() {
      return this.field_2754;
   }

   int getVersionCode() {
      return this.field_2753;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_2754, this.field_2755};
      return class_336.hashCode(var1);
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("status", this.field_2754).method_3424("dataSets", this.field_2755).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_929.method_5152(this, var1, var2);
   }
}
