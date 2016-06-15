package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.service.SensorEventDispatcher;
import com.google.android.gms.fitness.service.class_965;
import com.google.android.gms.fitness.service.class_966;
import com.google.android.gms.internal.class_336;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
   public static final Creator<FitnessSensorServiceRequest> CREATOR = new class_965();
   public static final int UNSPECIFIED = -1;
   // $FF: renamed from: CK int
   private final int field_3837;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_3838;
   // $FF: renamed from: VW com.google.android.gms.fitness.data.k
   private final class_193 field_3839;
   // $FF: renamed from: Wy long
   private final long field_3840;
   // $FF: renamed from: Wz long
   private final long field_3841;

   FitnessSensorServiceRequest(int var1, DataSource var2, IBinder var3, long var4, long var6) {
      this.field_3837 = var1;
      this.field_3838 = var2;
      this.field_3839 = class_193.class_1212.method_3082(var3);
      this.field_3840 = var4;
      this.field_3841 = var6;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.service.FitnessSensorServiceRequest) boolean
   private boolean method_5091(FitnessSensorServiceRequest var1) {
      return class_336.equal(this.field_3838, var1.field_3838) && this.field_3840 == var1.field_3840 && this.field_3841 == var1.field_3841;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof FitnessSensorServiceRequest && this.method_5091((FitnessSensorServiceRequest)var1);
   }

   public long getBatchInterval(TimeUnit var1) {
      return var1.convert(this.field_3841, TimeUnit.MICROSECONDS);
   }

   public DataSource getDataSource() {
      return this.field_3838;
   }

   public SensorEventDispatcher getDispatcher() {
      return new class_966(this.field_3839);
   }

   public long getSamplingRate(TimeUnit var1) {
      return this.field_3840 == -1L?-1L:var1.convert(this.field_3840, TimeUnit.MICROSECONDS);
   }

   int getVersionCode() {
      return this.field_3837;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_3838, Long.valueOf(this.field_3840), Long.valueOf(this.field_3841)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jI () long
   public long method_5092() {
      return this.field_3840;
   }

   // $FF: renamed from: kg () android.os.IBinder
   IBinder method_5093() {
      return this.field_3839.asBinder();
   }

   // $FF: renamed from: kx () long
   public long method_5094() {
      return this.field_3841;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_3838};
      return String.format("FitnessSensorServiceRequest{%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_965.method_5385(this, var1, var2);
   }
}
