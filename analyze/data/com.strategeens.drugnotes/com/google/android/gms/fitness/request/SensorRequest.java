package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
   public static final int ACCURACY_MODE_DEFAULT = 2;
   public static final int ACCURACY_MODE_HIGH = 3;
   public static final int ACCURACY_MODE_LOW = 1;
   // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
   private final DataType field_1878;
   // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
   private final DataSource field_1879;
   // $FF: renamed from: UQ long
   private final long field_1880;
   // $FF: renamed from: UR int
   private final int field_1881;
   // $FF: renamed from: VZ long
   private final long field_1882;
   // $FF: renamed from: Wa long
   private final long field_1883;
   // $FF: renamed from: We com.google.android.gms.location.LocationRequest
   private final LocationRequest field_1884;
   // $FF: renamed from: Wf long
   private final long field_1885;

   private SensorRequest(DataSource var1, LocationRequest var2) {
      this.field_1884 = var2;
      this.field_1880 = TimeUnit.MILLISECONDS.toMicros(var2.getInterval());
      this.field_1883 = TimeUnit.MILLISECONDS.toMicros(var2.getFastestInterval());
      this.field_1882 = this.field_1880;
      this.field_1878 = var1.getDataType();
      this.field_1881 = method_3135(var2);
      this.field_1879 = var1;
      long var3 = var2.getExpirationTime();
      if(var3 == Long.MAX_VALUE) {
         this.field_1885 = Long.MAX_VALUE;
      } else {
         this.field_1885 = TimeUnit.MILLISECONDS.toMicros(var3 - SystemClock.elapsedRealtime());
      }
   }

   private SensorRequest(SensorRequest.Builder var1) {
      this.field_1879 = var1.field_3765;
      this.field_1878 = var1.field_3764;
      this.field_1880 = var1.field_3766;
      this.field_1883 = var1.field_3769;
      this.field_1882 = var1.field_3768;
      this.field_1881 = var1.field_3767;
      this.field_1884 = null;
      this.field_1885 = var1.field_3770;
   }

   // $FF: synthetic method
   SensorRequest(SensorRequest.Builder var1, Object var2) {
      this(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.location.LocationRequest) int
   private static int method_3135(LocationRequest var0) {
      switch(var0.getPriority()) {
      case 100:
         return 3;
      case 104:
         return 1;
      default:
         return 2;
      }
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.request.SensorRequest) boolean
   private boolean method_3136(SensorRequest var1) {
      return class_336.equal(this.field_1879, var1.field_1879) && class_336.equal(this.field_1878, var1.field_1878) && this.field_1880 == var1.field_1880 && this.field_1883 == var1.field_1883 && this.field_1882 == var1.field_1882 && this.field_1881 == var1.field_1881 && class_336.equal(this.field_1884, var1.field_1884) && this.field_1885 == var1.field_1885;
   }

   // $FF: renamed from: dl (int) int
   public static int method_3137(int var0) {
      switch(var0) {
      case 2:
      default:
         var0 = 2;
      case 1:
      case 3:
         return var0;
      }
   }

   public static SensorRequest fromLocationRequest(DataSource var0, LocationRequest var1) {
      return new SensorRequest(var0, var1);
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof SensorRequest && this.method_3136((SensorRequest)var1);
   }

   public int getAccuracyMode() {
      return this.field_1881;
   }

   public DataSource getDataSource() {
      return this.field_1879;
   }

   public DataType getDataType() {
      return this.field_1878;
   }

   public long getFastestRate(TimeUnit var1) {
      return var1.convert(this.field_1883, TimeUnit.MICROSECONDS);
   }

   public long getMaxDeliveryLatency(TimeUnit var1) {
      return var1.convert(this.field_1882, TimeUnit.MICROSECONDS);
   }

   public long getSamplingRate(TimeUnit var1) {
      return var1.convert(this.field_1880, TimeUnit.MICROSECONDS);
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1879, this.field_1878, Long.valueOf(this.field_1880), Long.valueOf(this.field_1883), Long.valueOf(this.field_1882), Integer.valueOf(this.field_1881), this.field_1884, Long.valueOf(this.field_1885)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: kh () long
   public long method_3138() {
      return this.field_1885;
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("dataSource", this.field_1879).method_3424("dataType", this.field_1878).method_3424("samplingRateMicros", Long.valueOf(this.field_1880)).method_3424("deliveryLatencyMicros", Long.valueOf(this.field_1882)).method_3424("timeOutMicros", Long.valueOf(this.field_1885)).toString();
   }

   public static class Builder {
      // $FF: renamed from: TM com.google.android.gms.fitness.data.DataType
      private DataType field_3764;
      // $FF: renamed from: TN com.google.android.gms.fitness.data.DataSource
      private DataSource field_3765;
      // $FF: renamed from: UQ long
      private long field_3766 = -1L;
      // $FF: renamed from: UR int
      private int field_3767 = 2;
      // $FF: renamed from: VZ long
      private long field_3768 = 0L;
      // $FF: renamed from: Wa long
      private long field_3769 = 0L;
      // $FF: renamed from: Wf long
      private long field_3770 = Long.MAX_VALUE;
      // $FF: renamed from: Wg boolean
      private boolean field_3771 = false;

      public SensorRequest build() {
         boolean var1;
         if(this.field_3765 == null && this.field_3764 == null) {
            var1 = false;
         } else {
            var1 = true;
         }

         boolean var2;
         label17: {
            class_335.method_2302(var1, "Must call setDataSource() or setDataType()");
            if(this.field_3764 != null && this.field_3765 != null) {
               boolean var3 = this.field_3764.equals(this.field_3765.getDataType());
               var2 = false;
               if(!var3) {
                  break label17;
               }
            }

            var2 = true;
         }

         class_335.method_2302(var2, "Specified data type is incompatible with specified data source");
         return new SensorRequest(this);
      }

      public SensorRequest.Builder setAccuracyMode(int var1) {
         this.field_3767 = SensorRequest.method_3137(var1);
         return this;
      }

      public SensorRequest.Builder setDataSource(DataSource var1) {
         this.field_3765 = var1;
         return this;
      }

      public SensorRequest.Builder setDataType(DataType var1) {
         this.field_3764 = var1;
         return this;
      }

      public SensorRequest.Builder setFastestRate(int var1, TimeUnit var2) {
         boolean var3;
         if(var1 >= 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "Cannot use a negative interval");
         this.field_3771 = true;
         this.field_3769 = var2.toMicros((long)var1);
         return this;
      }

      public SensorRequest.Builder setMaxDeliveryLatency(int var1, TimeUnit var2) {
         boolean var3;
         if(var1 >= 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         class_335.method_2308(var3, "Cannot use a negative delivery interval");
         this.field_3768 = var2.toMicros((long)var1);
         return this;
      }

      public SensorRequest.Builder setSamplingRate(long var1, TimeUnit var3) {
         boolean var4;
         if(var1 >= 0L) {
            var4 = true;
         } else {
            var4 = false;
         }

         class_335.method_2308(var4, "Cannot use a negative sampling interval");
         this.field_3766 = var3.toMicros(var1);
         if(!this.field_3771) {
            this.field_3769 = this.field_3766 / 2L;
         }

         return this;
      }

      public SensorRequest.Builder setTimeout(long var1, TimeUnit var3) {
         byte var4 = 1;
         byte var5;
         if(var1 > 0L) {
            var5 = var4;
         } else {
            var5 = 0;
         }

         Object[] var6 = new Object[var4];
         var6[0] = Long.valueOf(var1);
         class_335.method_2309((boolean)var5, "Invalid time out value specified: %d", var6);
         if(var3 == null) {
            var4 = 0;
         }

         class_335.method_2308((boolean)var4, "Invalid time unit specified");
         this.field_3770 = var3.toMicros(var1);
         return this;
      }
   }
}
