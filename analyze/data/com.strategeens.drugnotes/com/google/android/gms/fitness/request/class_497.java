package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.class_193;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.class_498;
import com.google.android.gms.fitness.request.o;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.fitness.request.o
public class class_497 implements SafeParcelable {
   public static final Creator<o> CREATOR = new class_498();
   // $FF: renamed from: CK int
   private final int field_1893;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_1894;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_1895;
   // $FF: renamed from: UQ long
   private final long field_1896;
   // $FF: renamed from: UR int
   private final int field_1897;
   // $FF: renamed from: VW com.google.android.gms.fitness.data.k
   private class_193 field_1898;
   // $FF: renamed from: VX int
   int field_1899;
   // $FF: renamed from: VY int
   int field_1900;
   // $FF: renamed from: VZ long
   private final long field_1901;
   // $FF: renamed from: Wa long
   private final long field_1902;
   // $FF: renamed from: Wb java.util.List
   private final List<LocationRequest> field_1903;
   // $FF: renamed from: Wc long
   private final long field_1904;
   // $FF: renamed from: Wd java.util.List
   private final List field_1905;
   private final PendingIntent mPendingIntent;

   class_497(int var1, DataSource var2, DataType var3, IBinder var4, int var5, int var6, long var7, long var9, PendingIntent var11, long var12, int var14, List<LocationRequest> var15, long var16) {
      this.field_1893 = var1;
      this.field_1895 = var2;
      this.field_1894 = var3;
      class_193 var18;
      if(var4 == null) {
         var18 = null;
      } else {
         var18 = class_193.class_1212.method_3082(var4);
      }

      this.field_1898 = var18;
      if(var7 == 0L) {
         var7 = (long)var5;
      }

      this.field_1896 = var7;
      this.field_1902 = var12;
      if(var9 == 0L) {
         var9 = (long)var6;
      }

      this.field_1901 = var9;
      this.field_1903 = var15;
      this.mPendingIntent = var11;
      this.field_1897 = var14;
      this.field_1905 = Collections.emptyList();
      this.field_1904 = var16;
   }

   private class_497(DataSource var1, DataType var2, class_193 var3, PendingIntent var4, long var5, long var7, long var9, int var11, List var12, List var13, long var14) {
      this.field_1893 = 4;
      this.field_1895 = var1;
      this.field_1894 = var2;
      this.field_1898 = var3;
      this.mPendingIntent = var4;
      this.field_1896 = var5;
      this.field_1902 = var7;
      this.field_1901 = var9;
      this.field_1897 = var11;
      this.field_1903 = var12;
      this.field_1905 = var13;
      this.field_1904 = var14;
   }

   public class_497(SensorRequest var1, class_193 var2, PendingIntent var3) {
      this(var1.getDataSource(), var1.getDataType(), var2, var3, var1.getSamplingRate(TimeUnit.MICROSECONDS), var1.getFastestRate(TimeUnit.MICROSECONDS), var1.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), var1.getAccuracyMode(), (List)null, Collections.emptyList(), var1.method_3138());
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.o) boolean
   private boolean method_3149(class_497 var1) {
      return class_336.equal(this.field_1895, var1.field_1895) && class_336.equal(this.field_1894, var1.field_1894) && this.field_1896 == var1.field_1896 && this.field_1902 == var1.field_1902 && this.field_1901 == var1.field_1901 && this.field_1897 == var1.field_1897 && class_336.equal(this.field_1903, var1.field_1903);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof class_497 && this.method_3149((class_497)var1);
   }

   public int getAccuracyMode() {
      return this.field_1897;
   }

   public DataSource getDataSource() {
      return this.field_1895;
   }

   public DataType getDataType() {
      return this.field_1894;
   }

   int getVersionCode() {
      return this.field_1893;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1895, this.field_1894, this.field_1898, Long.valueOf(this.field_1896), Long.valueOf(this.field_1902), Long.valueOf(this.field_1901), Integer.valueOf(this.field_1897), this.field_1903};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jI () long
   public long method_3150() {
      return this.field_1896;
   }

   // $FF: renamed from: kb () android.app.PendingIntent
   public PendingIntent method_3151() {
      return this.mPendingIntent;
   }

   // $FF: renamed from: kc () long
   public long method_3152() {
      return this.field_1902;
   }

   // $FF: renamed from: kd () long
   public long method_3153() {
      return this.field_1901;
   }

   // $FF: renamed from: ke () java.util.List
   public List<LocationRequest> method_3154() {
      return this.field_1903;
   }

   // $FF: renamed from: kf () long
   public long method_3155() {
      return this.field_1904;
   }

   // $FF: renamed from: kg () android.os.IBinder
   IBinder method_3156() {
      return this.field_1898 == null?null:this.field_1898.asBinder();
   }

   public String toString() {
      Object[] var1 = new Object[]{this.field_1894, this.field_1895, Long.valueOf(this.field_1896), Long.valueOf(this.field_1902), Long.valueOf(this.field_1901)};
      return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_498.method_3157(this, var1, var2);
   }
}
