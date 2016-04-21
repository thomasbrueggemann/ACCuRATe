package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.class_525;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR = new class_525();
    // $FF: renamed from: BR int
    private final int field_4710;
    // $FF: renamed from: KS long
    private final long field_4711;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_4712;
    // $FF: renamed from: Sr long
    private final long field_4713;
    // $FF: renamed from: UN java.lang.String
    private final String field_4714;
    // $FF: renamed from: UO boolean
    private boolean field_4715;
    // $FF: renamed from: UP java.util.List
    private final List<String> field_4716;
    // $FF: renamed from: Uk java.util.List
    private final List<DataSource> field_4717;
    // $FF: renamed from: Uv boolean
    private final boolean field_4718;
    // $FF: renamed from: vL java.lang.String
    private final String field_4719;

    SessionReadRequest(int var1, String var2, String var3, long var4, long var6, List<DataType> var8, List<DataSource> var9, boolean var10, boolean var11, List<String> var12) {
        this.field_4710 = var1;
        this.field_4714 = var2;
        this.field_4719 = var3;
        this.field_4711 = var4;
        this.field_4713 = var6;
        this.field_4712 = Collections.unmodifiableList(var8);
        this.field_4717 = Collections.unmodifiableList(var9);
        this.field_4715 = var10;
        this.field_4718 = var11;
        this.field_4716 = var12;
    }

    private SessionReadRequest(SessionReadRequest.Builder var1) {
        this.field_4710 = 3;
        this.field_4714 = var1.field_2163;
        this.field_4719 = var1.field_2168;
        this.field_4711 = var1.field_2160;
        this.field_4713 = var1.field_2162;
        this.field_4712 = Collections.unmodifiableList(var1.field_2161);
        this.field_4717 = Collections.unmodifiableList(var1.field_2166);
        this.field_4715 = var1.field_2164;
        this.field_4718 = var1.field_2167;
        this.field_4716 = Collections.unmodifiableList(var1.field_2165);
    }

    // $FF: synthetic method
    SessionReadRequest(SessionReadRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.SessionReadRequest) boolean
    private boolean method_5324(SessionReadRequest var1) {
        return class_1089.equal(this.field_4714, var1.field_4714) && this.field_4719.equals(var1.field_4719) && this.field_4711 == var1.field_4711 && this.field_4713 == var1.field_4713 && class_1089.equal(this.field_4712, var1.field_4712) && class_1089.equal(this.field_4717, var1.field_4717) && this.field_4715 == var1.field_4715 && this.field_4716.equals(var1.field_4716) && this.field_4718 == var1.field_4718;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof SessionReadRequest && this.method_5324((SessionReadRequest)var1);
    }

    public List<DataSource> getDataSources() {
        return this.field_4717;
    }

    public List<DataType> getDataTypes() {
        return this.field_4712;
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_4713, TimeUnit.MILLISECONDS);
    }

    public List<String> getExcludedPackages() {
        return this.field_4716;
    }

    public String getSessionId() {
        return this.field_4719;
    }

    public String getSessionName() {
        return this.field_4714;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_4711, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.field_4710;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {this.field_4714, this.field_4719, Long.valueOf(this.field_4711), Long.valueOf(this.field_4713)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iD () long
    public long method_5325() {
        return this.field_4711;
    }

    // $FF: renamed from: iE () long
    public long method_5326() {
        return this.field_4713;
    }

    public boolean includeSessionsFromAllApps() {
        return this.field_4715;
    }

    // $FF: renamed from: jl () boolean
    public boolean method_5327() {
        return this.field_4718;
    }

    // $FF: renamed from: jz () boolean
    public boolean method_5328() {
        return this.field_4715;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("sessionName", this.field_4714).method_5425("sessionId", this.field_4719).method_5425("startTimeMillis", Long.valueOf(this.field_4711)).method_5425("endTimeMillis", Long.valueOf(this.field_4713)).method_5425("dataTypes", this.field_4712).method_5425("dataSources", this.field_4717).method_5425("sessionsFromAllApps", Boolean.valueOf(this.field_4715)).method_5425("excludedPackages", this.field_4716).method_5425("useServer", Boolean.valueOf(this.field_4718)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_525.method_3166(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: KS long
        private long field_2160 = 0L;
        // $FF: renamed from: SB java.util.List
        private List<DataType> field_2161 = new ArrayList();
        // $FF: renamed from: Sr long
        private long field_2162 = 0L;
        // $FF: renamed from: UN java.lang.String
        private String field_2163;
        // $FF: renamed from: UO boolean
        private boolean field_2164 = false;
        // $FF: renamed from: UP java.util.List
        private List<String> field_2165 = new ArrayList();
        // $FF: renamed from: Uk java.util.List
        private List<DataSource> field_2166 = new ArrayList();
        // $FF: renamed from: Uv boolean
        private boolean field_2167 = false;
        // $FF: renamed from: vL java.lang.String
        private String field_2168;

        public SessionReadRequest build() {
            boolean var1;
            if(this.field_2160 > 0L) {
                var1 = true;
            } else {
                var1 = false;
            }

            Object[] var2 = new Object[] {Long.valueOf(this.field_2160)};
            class_1090.method_5684(var1, "Invalid start time: %s", var2);
            boolean var3;
            if(this.field_2162 > 0L && this.field_2162 > this.field_2160) {
                var3 = true;
            } else {
                var3 = false;
            }

            Object[] var4 = new Object[] {Long.valueOf(this.field_2162)};
            class_1090.method_5684(var3, "Invalid end time: %s", var4);
            return new SessionReadRequest(this);
        }

        public SessionReadRequest.Builder enableServerQueries() {
            this.field_2167 = true;
            return this;
        }

        public SessionReadRequest.Builder excludePackage(String var1) {
            class_1090.method_5681(var1, "Attempting to use a null package name");
            if(!this.field_2165.contains(var1)) {
                this.field_2165.add(var1);
            }

            return this;
        }

        public SessionReadRequest.Builder read(DataSource var1) {
            class_1090.method_5681(var1, "Attempting to add a null data source");
            if(!this.field_2166.contains(var1)) {
                this.field_2166.add(var1);
            }

            return this;
        }

        public SessionReadRequest.Builder read(DataType var1) {
            class_1090.method_5681(var1, "Attempting to use a null data type");
            if(!this.field_2161.contains(var1)) {
                this.field_2161.add(var1);
            }

            return this;
        }

        public SessionReadRequest.Builder readSessionsFromAllApps() {
            this.field_2164 = true;
            return this;
        }

        public SessionReadRequest.Builder setSessionId(String var1) {
            this.field_2168 = var1;
            return this;
        }

        public SessionReadRequest.Builder setSessionName(String var1) {
            this.field_2163 = var1;
            return this;
        }

        public SessionReadRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
            this.field_2160 = var5.toMillis(var1);
            this.field_2162 = var5.toMillis(var3);
            return this;
        }
    }
}
