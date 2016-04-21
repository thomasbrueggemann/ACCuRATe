package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_514;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new class_514();
    public static final int NO_LIMIT;
    // $FF: renamed from: BR int
    private final int field_4652;
    // $FF: renamed from: KS long
    private final long field_4653;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_4654;
    // $FF: renamed from: SE int
    private final int field_4655;
    // $FF: renamed from: Sr long
    private final long field_4656;
    // $FF: renamed from: Uk java.util.List
    private final List<DataSource> field_4657;
    // $FF: renamed from: Uo java.util.List
    private final List<DataType> field_4658;
    // $FF: renamed from: Up java.util.List
    private final List<DataSource> field_4659;
    // $FF: renamed from: Uq long
    private final long field_4660;
    // $FF: renamed from: Ur com.google.android.gms.fitness.data.DataSource
    private final DataSource field_4661;
    // $FF: renamed from: Us int
    private final int field_4662;
    // $FF: renamed from: Ut boolean
    private final boolean field_4663;
    // $FF: renamed from: Uu boolean
    private final boolean field_4664;
    // $FF: renamed from: Uv boolean
    private final boolean field_4665;

    DataReadRequest(int var1, List<DataType> var2, List<DataSource> var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, int var10, long var11, DataSource var13, int var14, boolean var15, boolean var16, boolean var17) {
        this.field_4652 = var1;
        this.field_4654 = Collections.unmodifiableList(var2);
        this.field_4657 = Collections.unmodifiableList(var3);
        this.field_4653 = var4;
        this.field_4656 = var6;
        this.field_4658 = Collections.unmodifiableList(var8);
        this.field_4659 = Collections.unmodifiableList(var9);
        this.field_4655 = var10;
        this.field_4660 = var11;
        this.field_4661 = var13;
        this.field_4662 = var14;
        this.field_4663 = var15;
        this.field_4664 = var16;
        this.field_4665 = var17;
    }

    private DataReadRequest(DataReadRequest.Builder var1) {
        this.field_4652 = 2;
        this.field_4654 = Collections.unmodifiableList(var1.field_3197);
        this.field_4657 = Collections.unmodifiableList(var1.field_3200);
        this.field_4653 = var1.field_3196;
        this.field_4656 = var1.field_3199;
        this.field_4658 = Collections.unmodifiableList(var1.field_3201);
        this.field_4659 = Collections.unmodifiableList(var1.field_3202);
        this.field_4655 = var1.field_3198;
        this.field_4660 = var1.field_3203;
        this.field_4661 = var1.field_3204;
        this.field_4662 = var1.field_3205;
        this.field_4663 = var1.field_3206;
        this.field_4664 = var1.field_3207;
        this.field_4665 = var1.field_3208;
    }

    // $FF: synthetic method
    DataReadRequest(DataReadRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataReadRequest) boolean
    private boolean method_5267(DataReadRequest var1) {
        return this.field_4654.equals(var1.field_4654) && this.field_4657.equals(var1.field_4657) && this.field_4653 == var1.field_4653 && this.field_4656 == var1.field_4656 && this.field_4655 == var1.field_4655 && this.field_4659.equals(var1.field_4659) && this.field_4658.equals(var1.field_4658) && class_1089.equal(this.field_4661, var1.field_4661) && this.field_4660 == var1.field_4660 && this.field_4665 == var1.field_4665;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataReadRequest && this.method_5267((DataReadRequest)var1);
    }

    public DataSource getActivityDataSource() {
        return this.field_4661;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.field_4659;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.field_4658;
    }

    public long getBucketDuration(TimeUnit var1) {
        return var1.convert(this.field_4660, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.field_4655;
    }

    public List<DataSource> getDataSources() {
        return this.field_4657;
    }

    public List<DataType> getDataTypes() {
        return this.field_4654;
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_4656, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.field_4662;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_4653, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.field_4652;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Integer.valueOf(this.field_4655), Long.valueOf(this.field_4653), Long.valueOf(this.field_4656)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iD () long
    public long method_5268() {
        return this.field_4653;
    }

    // $FF: renamed from: iE () long
    public long method_5269() {
        return this.field_4656;
    }

    // $FF: renamed from: jk () boolean
    public boolean method_5270() {
        return this.field_4663;
    }

    // $FF: renamed from: jl () boolean
    public boolean method_5271() {
        return this.field_4665;
    }

    // $FF: renamed from: jm () boolean
    public boolean method_5272() {
        return this.field_4664;
    }

    // $FF: renamed from: jn () long
    public long method_5273() {
        return this.field_4660;
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder();
        var1.append("DataReadRequest{");
        if(!this.field_4654.isEmpty()) {
            Iterator var17 = this.field_4654.iterator();

            while(var17.hasNext()) {
                var1.append(((DataType)var17.next()).method_5599()).append(" ");
            }
        }

        if(!this.field_4657.isEmpty()) {
            Iterator var15 = this.field_4657.iterator();

            while(var15.hasNext()) {
                var1.append(((DataSource)var15.next()).toDebugString()).append(" ");
            }
        }

        if(this.field_4655 != 0) {
            var1.append("bucket by ").append(Bucket.method_5192(this.field_4655));
            if(this.field_4660 > 0L) {
                var1.append(" >").append(this.field_4660).append("ms");
            }

            var1.append(": ");
        }

        if(!this.field_4658.isEmpty()) {
            Iterator var10 = this.field_4658.iterator();

            while(var10.hasNext()) {
                var1.append(((DataType)var10.next()).method_5599()).append(" ");
            }
        }

        if(!this.field_4659.isEmpty()) {
            Iterator var8 = this.field_4659.iterator();

            while(var8.hasNext()) {
                var1.append(((DataSource)var8.next()).toDebugString()).append(" ");
            }
        }

        Object[] var3 = new Object[] {Long.valueOf(this.field_4653), Long.valueOf(this.field_4653), Long.valueOf(this.field_4656), Long.valueOf(this.field_4656)};
        var1.append(String.format("(%tF %tT - %tF %tT)", var3));
        if(this.field_4661 != null) {
            var1.append("activities: ").append(this.field_4661.toDebugString());
        }

        if(this.field_4665) {
            var1.append(" +server");
        }

        var1.append("}");
        return var1.toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_514.method_3131(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: KS long
        private long field_3196;
        // $FF: renamed from: SB java.util.List
        private List<DataType> field_3197 = new ArrayList();
        // $FF: renamed from: SE int
        private int field_3198 = 0;
        // $FF: renamed from: Sr long
        private long field_3199;
        // $FF: renamed from: Uk java.util.List
        private List<DataSource> field_3200 = new ArrayList();
        // $FF: renamed from: Uo java.util.List
        private List<DataType> field_3201 = new ArrayList();
        // $FF: renamed from: Up java.util.List
        private List<DataSource> field_3202 = new ArrayList();
        // $FF: renamed from: Uq long
        private long field_3203 = 0L;
        // $FF: renamed from: Ur com.google.android.gms.fitness.data.DataSource
        private DataSource field_3204;
        // $FF: renamed from: Us int
        private int field_3205 = 0;
        // $FF: renamed from: Ut boolean
        private boolean field_3206 = false;
        // $FF: renamed from: Uu boolean
        private boolean field_3207 = false;
        // $FF: renamed from: Uv boolean
        private boolean field_3208 = false;

        public DataReadRequest.Builder aggregate(DataSource var1, DataType var2) {
            class_1090.method_5681(var1, "Attempting to add a null data source");
            boolean var4;
            if(!this.field_3200.contains(var1)) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5676(var4, "Cannot add the same data source for aggregated and detailed");
            DataType var5 = var1.getDataType();
            class_1090.method_5684(DataType.AGGREGATE_INPUT_TYPES.contains(var5), "Unsupported input data type specified for aggregation: %s", new Object[] {var5});
            class_1090.method_5684(DataType.getAggregatesForInput(var5).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[] {var5, var2});
            if(!this.field_3202.contains(var1)) {
                this.field_3202.add(var1);
            }

            return this;
        }

        public DataReadRequest.Builder aggregate(DataType var1, DataType var2) {
            class_1090.method_5681(var1, "Attempting to use a null data type");
            boolean var4;
            if(!this.field_3197.contains(var1)) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5676(var4, "Cannot add the same data type as aggregated and detailed");
            class_1090.method_5684(DataType.AGGREGATE_INPUT_TYPES.contains(var1), "Unsupported input data type specified for aggregation: %s", new Object[] {var1});
            class_1090.method_5684(DataType.getAggregatesForInput(var1).contains(var2), "Invalid output aggregate data type specified: %s -> %s", new Object[] {var1, var2});
            if(!this.field_3201.contains(var1)) {
                this.field_3201.add(var1);
            }

            return this;
        }

        public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2) {
            boolean var3;
            if(this.field_3198 == 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var3, "Bucketing strategy already set to %s", var4);
            boolean var5;
            if(var1 > 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            Object[] var6 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
            this.field_3198 = 4;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest.Builder bucketByActivitySegment(int var1, TimeUnit var2, DataSource var3) {
            boolean var4;
            if(this.field_3198 == 0) {
                var4 = true;
            } else {
                var4 = false;
            }

            Object[] var5 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var4, "Bucketing strategy already set to %s", var5);
            boolean var6;
            if(var1 > 0) {
                var6 = true;
            } else {
                var6 = false;
            }

            Object[] var7 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var6, "Must specify a valid minimum duration for an activity segment: %d", var7);
            boolean var8;
            if(var3 != null) {
                var8 = true;
            } else {
                var8 = false;
            }

            class_1090.method_5683(var8, "Invalid activity data source specified");
            class_1090.method_5684(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] {var3});
            this.field_3204 = var3;
            this.field_3198 = 4;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2) {
            boolean var3;
            if(this.field_3198 == 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var3, "Bucketing strategy already set to %s", var4);
            boolean var5;
            if(var1 > 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            Object[] var6 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
            this.field_3198 = 3;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest.Builder bucketByActivityType(int var1, TimeUnit var2, DataSource var3) {
            boolean var4;
            if(this.field_3198 == 0) {
                var4 = true;
            } else {
                var4 = false;
            }

            Object[] var5 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var4, "Bucketing strategy already set to %s", var5);
            boolean var6;
            if(var1 > 0) {
                var6 = true;
            } else {
                var6 = false;
            }

            Object[] var7 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var6, "Must specify a valid minimum duration for an activity segment: %d", var7);
            boolean var8;
            if(var3 != null) {
                var8 = true;
            } else {
                var8 = false;
            }

            class_1090.method_5683(var8, "Invalid activity data source specified");
            class_1090.method_5684(var3.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] {var3});
            this.field_3204 = var3;
            this.field_3198 = 3;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest.Builder bucketBySession(int var1, TimeUnit var2) {
            boolean var3;
            if(this.field_3198 == 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var3, "Bucketing strategy already set to %s", var4);
            boolean var5;
            if(var1 > 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            Object[] var6 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
            this.field_3198 = 2;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest.Builder bucketByTime(int var1, TimeUnit var2) {
            boolean var3;
            if(this.field_3198 == 0) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {Integer.valueOf(this.field_3198)};
            class_1090.method_5684(var3, "Bucketing strategy already set to %s", var4);
            boolean var5;
            if(var1 > 0) {
                var5 = true;
            } else {
                var5 = false;
            }

            Object[] var6 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var5, "Must specify a valid minimum duration for an activity segment: %d", var6);
            this.field_3198 = 1;
            this.field_3203 = var2.toMillis((long)var1);
            return this;
        }

        public DataReadRequest build() {
            byte var1 = 1;
            byte var2;
            if(this.field_3200.isEmpty() && this.field_3197.isEmpty() && this.field_3202.isEmpty() && this.field_3201.isEmpty()) {
                var2 = 0;
            } else {
                var2 = var1;
            }

            class_1090.method_5676((boolean)var2, "Must add at least one data source (aggregated or detailed)");
            byte var3;
            if(this.field_3196 > 0L) {
                var3 = var1;
            } else {
                var3 = 0;
            }

            Object[] var4 = new Object[var1];
            var4[0] = Long.valueOf(this.field_3196);
            class_1090.method_5677((boolean)var3, "Invalid start time: %s", var4);
            byte var5;
            if(this.field_3199 > 0L && this.field_3199 > this.field_3196) {
                var5 = var1;
            } else {
                var5 = 0;
            }

            Object[] var6 = new Object[var1];
            var6[0] = Long.valueOf(this.field_3199);
            class_1090.method_5677((boolean)var5, "Invalid end time: %s", var6);
            byte var7;
            if(this.field_3202.isEmpty() && this.field_3201.isEmpty()) {
                var7 = var1;
            } else {
                var7 = 0;
            }

            if((var7 == 0 || this.field_3198 != 0) && (var7 != 0 || this.field_3198 == 0)) {
                var1 = 0;
            }

            class_1090.method_5676((boolean)var1, "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest(this);
        }

        public DataReadRequest.Builder enableServerQueries() {
            this.field_3208 = true;
            return this;
        }

        public DataReadRequest.Builder read(DataSource var1) {
            class_1090.method_5681(var1, "Attempting to add a null data source");
            boolean var3;
            if(!this.field_3202.contains(var1)) {
                var3 = true;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "Cannot add the same data source as aggregated and detailed");
            if(!this.field_3200.contains(var1)) {
                this.field_3200.add(var1);
            }

            return this;
        }

        public DataReadRequest.Builder read(DataType var1) {
            class_1090.method_5681(var1, "Attempting to use a null data type");
            boolean var3;
            if(!this.field_3201.contains(var1)) {
                var3 = true;
            } else {
                var3 = false;
            }

            class_1090.method_5676(var3, "Cannot add the same data type as aggregated and detailed");
            if(!this.field_3197.contains(var1)) {
                this.field_3197.add(var1);
            }

            return this;
        }

        public DataReadRequest.Builder setLimit(int var1) {
            boolean var2;
            if(var1 > 0) {
                var2 = true;
            } else {
                var2 = false;
            }

            Object[] var3 = new Object[] {Integer.valueOf(var1)};
            class_1090.method_5684(var2, "Invalid limit %d is specified", var3);
            this.field_3205 = var1;
            return this;
        }

        public DataReadRequest.Builder setTimeRange(long var1, long var3, TimeUnit var5) {
            this.field_3196 = var5.toMillis(var1);
            this.field_3199 = var5.toMillis(var3);
            return this;
        }
    }
}
