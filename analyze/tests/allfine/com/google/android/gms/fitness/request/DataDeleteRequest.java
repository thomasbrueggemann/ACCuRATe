package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.class_518;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new class_518();
    // $FF: renamed from: BR int
    private final int field_4820;
    // $FF: renamed from: KS long
    private final long field_4821;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_4822;
    // $FF: renamed from: Sr long
    private final long field_4823;
    // $FF: renamed from: Uk java.util.List
    private final List<DataSource> field_4824;
    // $FF: renamed from: Ul java.util.List
    private final List<Session> field_4825;
    // $FF: renamed from: Um boolean
    private final boolean field_4826;
    // $FF: renamed from: Un boolean
    private final boolean field_4827;

    DataDeleteRequest(int var1, long var2, long var4, List<DataSource> var6, List<DataType> var7, List<Session> var8, boolean var9, boolean var10) {
        this.field_4820 = var1;
        this.field_4821 = var2;
        this.field_4823 = var4;
        this.field_4824 = Collections.unmodifiableList(var6);
        this.field_4822 = Collections.unmodifiableList(var7);
        this.field_4825 = var8;
        this.field_4826 = var9;
        this.field_4827 = var10;
    }

    private DataDeleteRequest(DataDeleteRequest.Builder var1) {
        this.field_4820 = 1;
        this.field_4821 = var1.field_536;
        this.field_4823 = var1.field_538;
        this.field_4824 = Collections.unmodifiableList(var1.field_539);
        this.field_4822 = Collections.unmodifiableList(var1.field_537);
        this.field_4825 = Collections.unmodifiableList(var1.field_540);
        this.field_4826 = var1.field_541;
        this.field_4827 = var1.field_542;
    }

    // $FF: synthetic method
    DataDeleteRequest(DataDeleteRequest.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.request.DataDeleteRequest) boolean
    private boolean method_5450(DataDeleteRequest var1) {
        return this.field_4821 == var1.field_4821 && this.field_4823 == var1.field_4823 && class_1089.equal(this.field_4824, var1.field_4824) && class_1089.equal(this.field_4822, var1.field_4822) && class_1089.equal(this.field_4825, var1.field_4825) && this.field_4826 == var1.field_4826 && this.field_4827 == var1.field_4827;
    }

    public boolean deleteAllData() {
        return this.field_4826;
    }

    public boolean deleteAllSessions() {
        return this.field_4827;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof DataDeleteRequest && this.method_5450((DataDeleteRequest)var1);
    }

    public List<DataSource> getDataSources() {
        return this.field_4824;
    }

    public List<DataType> getDataTypes() {
        return this.field_4822;
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_4823, TimeUnit.MILLISECONDS);
    }

    public List<Session> getSessions() {
        return this.field_4825;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_4821, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.field_4820;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_4821), Long.valueOf(this.field_4823)};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iD () long
    public long method_5451() {
        return this.field_4821;
    }

    // $FF: renamed from: iE () long
    public long method_5452() {
        return this.field_4823;
    }

    // $FF: renamed from: jg () boolean
    public boolean method_5453() {
        return this.field_4826;
    }

    // $FF: renamed from: jh () boolean
    public boolean method_5454() {
        return this.field_4827;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("startTimeMillis", Long.valueOf(this.field_4821)).method_5425("endTimeMillis", Long.valueOf(this.field_4823)).method_5425("dataSources", this.field_4824).method_5425("dateTypes", this.field_4822).method_5425("sessions", this.field_4825).method_5425("deleteAllData", Boolean.valueOf(this.field_4826)).method_5425("deleteAllSessions", Boolean.valueOf(this.field_4827)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_518.method_3141(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: KS long
        private long field_536;
        // $FF: renamed from: SB java.util.List
        private List<DataType> field_537 = new ArrayList();
        // $FF: renamed from: Sr long
        private long field_538;
        // $FF: renamed from: Uk java.util.List
        private List<DataSource> field_539 = new ArrayList();
        // $FF: renamed from: Ul java.util.List
        private List<Session> field_540 = new ArrayList();
        // $FF: renamed from: Um boolean
        private boolean field_541 = false;
        // $FF: renamed from: Un boolean
        private boolean field_542 = false;

        // $FF: renamed from: ji () void
        private void method_1499() {
            if(!this.field_540.isEmpty()) {
                Iterator var1 = this.field_540.iterator();

                while(var1.hasNext()) {
                    Session var2 = (Session)var1.next();
                    boolean var3;
                    if(var2.getStartTime(TimeUnit.MILLISECONDS) >= this.field_536 && var2.getEndTime(TimeUnit.MILLISECONDS) <= this.field_538) {
                        var3 = true;
                    } else {
                        var3 = false;
                    }

                    Object[] var4 = new Object[] {var2, Long.valueOf(this.field_536), Long.valueOf(this.field_538)};
                    class_1090.method_5677(var3, "Session %s is outside the time interval [%d, %d]", var4);
                }
            }

        }

        public DataDeleteRequest.Builder addDataSource(DataSource var1) {
            boolean var2 = true;
            boolean var3;
            if(!this.field_541) {
                var3 = var2;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "All data is already marked for deletion");
            if(var1 == null) {
                var2 = false;
            }

            class_1090.method_5683(var2, "Must specify a valid data source");
            if(!this.field_539.contains(var1)) {
                this.field_539.add(var1);
            }

            return this;
        }

        public DataDeleteRequest.Builder addDataType(DataType var1) {
            boolean var2 = true;
            boolean var3;
            if(!this.field_541) {
                var3 = var2;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "All data is already marked for deletion");
            if(var1 == null) {
                var2 = false;
            }

            class_1090.method_5683(var2, "Must specify a valid data type");
            if(!this.field_537.contains(var1)) {
                this.field_537.add(var1);
            }

            return this;
        }

        public DataDeleteRequest.Builder addSession(Session var1) {
            boolean var2 = true;
            boolean var3;
            if(!this.field_542) {
                var3 = var2;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "All sessions already marked for deletion");
            boolean var4;
            if(var1 != null) {
                var4 = var2;
            } else {
                var4 = false;
            }

            class_1090.method_5683(var4, "Must specify a valid session");
            if(var1.getEndTime(TimeUnit.MILLISECONDS) <= 0L) {
                var2 = false;
            }

            class_1090.method_5683(var2, "Must specify a session that has already ended");
            this.field_540.add(var1);
            return this;
        }

        public DataDeleteRequest build() {
            boolean var1;
            if(this.field_536 > 0L && this.field_538 > this.field_536) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must specify a valid time interval");
            boolean var2;
            if(!this.field_541 && this.field_539.isEmpty() && this.field_537.isEmpty()) {
                var2 = false;
            } else {
                var2 = true;
            }

            boolean var3;
            if(!this.field_542 && this.field_540.isEmpty()) {
                var3 = false;
            } else {
                var3 = true;
            }

            boolean var4;
            label24: {
                if(!var2) {
                    var4 = false;
                    if(!var3) {
                        break label24;
                    }
                }

                var4 = true;
            }

            class_1090.method_5676(var4, "No data or session marked for deletion");
            this.method_1499();
            return new DataDeleteRequest(this);
        }

        public DataDeleteRequest.Builder deleteAllData() {
            boolean var1;
            if(this.field_537.isEmpty() && this.field_539.isEmpty()) {
                var1 = true;
            } else {
                var1 = false;
            }

            Object[] var2 = new Object[] {this.field_539, this.field_537};
            class_1090.method_5684(var1, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", var2);
            this.field_541 = true;
            return this;
        }

        public DataDeleteRequest.Builder deleteAllSessions() {
            boolean var1 = this.field_540.isEmpty();
            Object[] var2 = new Object[] {this.field_540};
            class_1090.method_5684(var1, "Specific sessions already added for deletion: %s", var2);
            this.field_542 = true;
            return this;
        }

        public DataDeleteRequest.Builder setTimeInterval(long var1, long var3, TimeUnit var5) {
            boolean var6;
            if(var1 > 0L) {
                var6 = true;
            } else {
                var6 = false;
            }

            Object[] var7 = new Object[] {Long.valueOf(var1)};
            class_1090.method_5684(var6, "Invalid start time :%d", var7);
            boolean var8;
            if(var3 > var1) {
                var8 = true;
            } else {
                var8 = false;
            }

            Object[] var9 = new Object[] {Long.valueOf(var3)};
            class_1090.method_5684(var8, "Invalid end time :%d", var9);
            this.field_536 = var5.toMillis(var1);
            this.field_538 = var5.toMillis(var3);
            return this;
        }
    }
}
