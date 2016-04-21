package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_2178;
    // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
    private final DataSource field_2179;
    // $FF: renamed from: Tt long
    private final long field_2180;
    // $FF: renamed from: Tu int
    private final int field_2181;
    // $FF: renamed from: UD long
    private final long field_2182;
    // $FF: renamed from: UE long
    private final long field_2183;
    // $FF: renamed from: UI com.google.android.gms.location.LocationRequest
    private final LocationRequest field_2184;
    // $FF: renamed from: UJ long
    private final long field_2185;

    private SensorRequest(DataSource var1, LocationRequest var2) {
        this.field_2184 = var2;
        this.field_2180 = TimeUnit.MILLISECONDS.toMicros(var2.getInterval());
        this.field_2183 = TimeUnit.MILLISECONDS.toMicros(var2.getFastestInterval());
        this.field_2182 = this.field_2180;
        this.field_2178 = var1.getDataType();
        this.field_2181 = method_3093(var2);
        this.field_2179 = var1;
        long var3 = var2.getExpirationTime();
        if(var3 == Long.MAX_VALUE) {
            this.field_2185 = Long.MAX_VALUE;
        } else {
            this.field_2185 = TimeUnit.MILLISECONDS.toMicros(var3 - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(SensorRequest.Builder var1) {
        this.field_2179 = var1.field_4502;
        this.field_2178 = var1.field_4501;
        this.field_2180 = var1.field_4503;
        this.field_2183 = var1.field_4506;
        this.field_2182 = var1.field_4505;
        this.field_2181 = var1.field_4504;
        this.field_2184 = null;
        this.field_2185 = var1.field_4507;
    }

    // $FF: synthetic method
    SensorRequest(SensorRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.location.LocationRequest) int
    private static int method_3093(LocationRequest var0) {
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
    private boolean method_3094(SensorRequest var1) {
        return class_1089.equal(this.field_2179, var1.field_2179) && class_1089.equal(this.field_2178, var1.field_2178) && this.field_2180 == var1.field_2180 && this.field_2183 == var1.field_2183 && this.field_2182 == var1.field_2182 && this.field_2181 == var1.field_2181 && class_1089.equal(this.field_2184, var1.field_2184) && this.field_2185 == var1.field_2185;
    }

    // $FF: renamed from: da (int) int
    public static int method_3095(int var0) {
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
        return this == var1 || var1 instanceof SensorRequest && this.method_3094((SensorRequest)var1);
    }

    public int getAccuracyMode() {
        return this.field_2181;
    }

    public DataSource getDataSource() {
        return this.field_2179;
    }

    public DataType getDataType() {
        return this.field_2178;
    }

    public long getFastestRate(TimeUnit var1) {
        return var1.convert(this.field_2183, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit var1) {
        return var1.convert(this.field_2182, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit var1) {
        return var1.convert(this.field_2180, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_2179, this.field_2178, Long.valueOf(this.field_2180), Long.valueOf(this.field_2183), Long.valueOf(this.field_2182), Integer.valueOf(this.field_2181), this.field_2184, Long.valueOf(this.field_2185)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: jx () long
    public long method_3096() {
        return this.field_2185;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("dataSource", this.field_2179).method_5425("dataType", this.field_2178).method_5425("samplingRateMicros", Long.valueOf(this.field_2180)).method_5425("deliveryLatencyMicros", Long.valueOf(this.field_2182)).method_5425("timeOutMicros", Long.valueOf(this.field_2185)).toString();
    }

    public static class Builder {
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private DataType field_4501;
        // $FF: renamed from: Sq com.google.android.gms.fitness.data.DataSource
        private DataSource field_4502;
        // $FF: renamed from: Tt long
        private long field_4503 = -1L;
        // $FF: renamed from: Tu int
        private int field_4504 = 2;
        // $FF: renamed from: UD long
        private long field_4505 = 0L;
        // $FF: renamed from: UE long
        private long field_4506 = 0L;
        // $FF: renamed from: UJ long
        private long field_4507 = Long.MAX_VALUE;
        // $FF: renamed from: UK boolean
        private boolean field_4508 = false;

        public SensorRequest build() {
            boolean var1;
            if(this.field_4502 == null && this.field_4501 == null) {
                var1 = false;
            } else {
                var1 = true;
            }

            boolean var2;
            label17: {
                class_1090.method_5676(var1, "Must call setDataSource() or setDataType()");
                if(this.field_4501 != null && this.field_4502 != null) {
                    boolean var3 = this.field_4501.equals(this.field_4502.getDataType());
                    var2 = false;
                    if(!var3) {
                        break label17;
                    }
                }

                var2 = true;
            }

            class_1090.method_5676(var2, "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }

        public SensorRequest.Builder setAccuracyMode(int var1) {
            this.field_4504 = SensorRequest.method_3095(var1);
            return this;
        }

        public SensorRequest.Builder setDataSource(DataSource var1) {
            this.field_4502 = var1;
            return this;
        }

        public SensorRequest.Builder setDataType(DataType var1) {
            this.field_4501 = var1;
            return this;
        }

        public SensorRequest.Builder setFastestRate(int var1, TimeUnit var2) {
            boolean var3;
            if(var1 >= 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "Cannot use a negative interval");
            this.field_4508 = true;
            this.field_4506 = var2.toMicros((long)var1);
            return this;
        }

        public SensorRequest.Builder setMaxDeliveryLatency(int var1, TimeUnit var2) {
            boolean var3;
            if(var1 >= 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "Cannot use a negative delivery interval");
            this.field_4505 = var2.toMicros((long)var1);
            return this;
        }

        public SensorRequest.Builder setSamplingRate(long var1, TimeUnit var3) {
            boolean var4;
            if(var1 >= 0L) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5683(var4, "Cannot use a negative sampling interval");
            this.field_4503 = var3.toMicros(var1);
            if(!this.field_4508) {
                this.field_4506 = this.field_4503 / 2L;
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
            class_1090.method_5684((boolean)var5, "Invalid time out value specified: %d", var6);
            if(var3 == null) {
                var4 = 0;
            }

            class_1090.method_5683((boolean)var4, "Invalid time unit specified");
            this.field_4507 = var3.toMicros(var1);
            return this;
        }
    }
}
