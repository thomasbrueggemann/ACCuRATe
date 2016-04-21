package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.class_349;
import com.google.android.gms.fitness.request.class_50;
import com.google.android.gms.fitness.request.class_503;
import com.google.android.gms.internal.class_348;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
    public static final Creator<StartBleScanRequest> CREATOR = new class_503();
    // $FF: renamed from: BR int
    private final int field_2080;
    // $FF: renamed from: SB java.util.List
    private final List<DataType> field_2081;
    // $FF: renamed from: UQ com.google.android.gms.fitness.request.l
    private final class_50 field_2082;
    // $FF: renamed from: UR int
    private final int field_2083;

    StartBleScanRequest(int var1, List<DataType> var2, IBinder var3, int var4) {
        this.field_2080 = var1;
        this.field_2081 = var2;
        this.field_2082 = class_50.class_1193.method_2343(var3);
        this.field_2083 = var4;
    }

    private StartBleScanRequest(StartBleScanRequest.Builder var1) {
        this.field_2080 = 2;
        this.field_2081 = class_348.method_2341(var1.field_1774);
        this.field_2082 = var1.field_1772;
        this.field_2083 = var1.field_1773;
    }

    // $FF: synthetic method
    StartBleScanRequest(StartBleScanRequest.Builder var1, Object var2) {
        this(var1);
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.field_2081);
    }

    public int getTimeoutSecs() {
        return this.field_2083;
    }

    int getVersionCode() {
        return this.field_2080;
    }

    // $FF: renamed from: jC () android.os.IBinder
    public IBinder method_3009() {
        return this.field_2082.asBinder();
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("dataTypes", this.field_2081).method_5425("timeoutSecs", Integer.valueOf(this.field_2083)).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_503.method_3068(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: UQ com.google.android.gms.fitness.request.l
        private class_50 field_1772;
        // $FF: renamed from: UR int
        private int field_1773 = 10;
        // $FF: renamed from: Uy com.google.android.gms.fitness.data.DataType[]
        private DataType[] field_1774 = new DataType[0];

        // $FF: renamed from: a (com.google.android.gms.fitness.request.l) com.google.android.gms.fitness.request.StartBleScanRequest$Builder
        public StartBleScanRequest.Builder method_2840(class_50 var1) {
            this.field_1772 = var1;
            return this;
        }

        public StartBleScanRequest build() {
            boolean var1;
            if(this.field_1772 != null) {
                var1 = true;
            } else {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must set BleScanCallback");
            return new StartBleScanRequest(this);
        }

        public StartBleScanRequest.Builder setBleScanCallback(BleScanCallback var1) {
            this.method_2840(class_349.class_1362.method_3361().method_3362(var1));
            return this;
        }

        public StartBleScanRequest.Builder setDataTypes(DataType... var1) {
            this.field_1774 = var1;
            return this;
        }

        public StartBleScanRequest.Builder setTimeoutSecs(int var1) {
            boolean var2 = true;
            boolean var3;
            if(var1 > 0) {
                var3 = var2;
            } else {
                var3 = false;
            }

            class_1090.method_5683(var3, "Stop time must be greater than zero");
            if(var1 > 60) {
                var2 = false;
            }

            class_1090.method_5683(var2, "Stop time must be less than 1 minute");
            this.field_1773 = var1;
            return this;
        }
    }
}
