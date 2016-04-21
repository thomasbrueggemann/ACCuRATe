package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.fitness.data.class_1125;
import com.google.android.gms.fitness.data.class_1141;
import com.google.android.gms.internal.class_848;

public class DataSource implements SafeParcelable {
    public static final Creator<DataSource> CREATOR = new class_1125();
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW;
    // $FF: renamed from: BR int
    private final int field_2169;
    // $FF: renamed from: FD int
    private final int field_2170;
    // $FF: renamed from: SO com.google.android.gms.fitness.data.Device
    private final Device field_2171;
    // $FF: renamed from: SP com.google.android.gms.fitness.data.a
    private final class_1141 field_2172;
    // $FF: renamed from: SQ java.lang.String
    private final String field_2173;
    // $FF: renamed from: SR boolean
    private final boolean field_2174;
    // $FF: renamed from: SS java.lang.String
    private final String field_2175;
    // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
    private final DataType field_2176;
    private final String mName;

    DataSource(int var1, DataType var2, String var3, int var4, Device var5, class_1141 var6, String var7, boolean var8) {
        this.field_2169 = var1;
        this.field_2176 = var2;
        this.field_2170 = var4;
        this.mName = var3;
        this.field_2171 = var5;
        this.field_2172 = var6;
        this.field_2173 = var7;
        this.field_2174 = var8;
        this.field_2175 = this.method_3089();
    }

    private DataSource(DataSource.Builder var1) {
        this.field_2169 = 3;
        this.field_2176 = var1.field_4693;
        this.field_2170 = var1.field_4688;
        this.mName = var1.mName;
        this.field_2171 = var1.field_4689;
        this.field_2172 = var1.field_4690;
        this.field_2173 = var1.field_4691;
        this.field_2174 = var1.field_4692;
        this.field_2175 = this.method_3089();
    }

    // $FF: synthetic method
    DataSource(DataSource.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataSource) boolean
    private boolean method_3088(DataSource var1) {
        return this.field_2175.equals(var1.field_2175);
    }

    public static DataSource extract(Intent var0) {
        return var0 == null?null:(DataSource)class_822.method_4294(var0, "vnd.google.fitness.data_source", CREATOR);
    }

    private String getTypeString() {
        switch(this.field_2170) {
            case 0:
                return "raw";
            case 1:
                return "derived";
            default:
                throw new IllegalArgumentException("invalid type value");
        }
    }

    // $FF: renamed from: iN () java.lang.String
    private String method_3089() {
        StringBuilder var1 = new StringBuilder();
        var1.append(this.getTypeString());
        var1.append(":").append(this.field_2176.getName());
        if(this.field_2172 != null) {
            var1.append(":").append(this.field_2172.getPackageName());
        }

        if(this.field_2171 != null) {
            var1.append(":").append(this.field_2171.getStreamIdentifier());
        }

        if(this.field_2173 != null) {
            var1.append(":").append(this.field_2173);
        }

        return var1.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataSource && this.method_3088((DataSource)var1);
    }

    public String getAppPackageName() {
        return this.field_2172 == null?null:this.field_2172.getPackageName();
    }

    public DataType getDataType() {
        return this.field_2176;
    }

    public Device getDevice() {
        return this.field_2171;
    }

    public String getName() {
        return this.mName;
    }

    public String getStreamIdentifier() {
        return this.field_2175;
    }

    public String getStreamName() {
        return this.field_2173;
    }

    public int getType() {
        return this.field_2170;
    }

    int getVersionCode() {
        return this.field_2169;
    }

    public int hashCode() {
        return this.field_2175.hashCode();
    }

    // $FF: renamed from: iM () com.google.android.gms.fitness.data.a
    public class_1141 method_3090() {
        return this.field_2172;
    }

    // $FF: renamed from: iO () boolean
    public boolean method_3091() {
        return this.field_2174;
    }

    // $FF: renamed from: iP () com.google.android.gms.fitness.data.DataSource
    public DataSource method_3092() {
        Device var1;
        if(this.field_2171 == null) {
            var1 = null;
        } else {
            var1 = this.field_2171.method_2610();
        }

        class_1141 var2;
        if(this.field_2172 == null) {
            var2 = null;
        } else {
            var2 = this.field_2172.method_5913();
        }

        return new DataSource(3, this.field_2176, this.mName, this.field_2170, var1, var2, class_848.method_4469(this.field_2173), this.field_2174);
    }

    public String toDebugString() {
        StringBuilder var1 = new StringBuilder();
        String var2;
        if(this.field_2170 == 0) {
            var2 = "r";
        } else {
            var2 = "d";
        }

        StringBuilder var3 = var1.append(var2).append(":").append(this.field_2176.method_5599());
        String var4;
        if(this.field_2172 == null) {
            var4 = "";
        } else if(this.field_2172.equals(class_1141.field_5248)) {
            var4 = ":gms";
        } else {
            var4 = ":" + this.field_2172.getPackageName();
        }

        StringBuilder var5 = var3.append(var4);
        String var6;
        if(this.field_2171 != null) {
            var6 = ":" + this.field_2171.getModel() + ":" + this.field_2171.getUid();
        } else {
            var6 = "";
        }

        StringBuilder var7 = var5.append(var6);
        String var8;
        if(this.field_2173 != null) {
            var8 = ":" + this.field_2173;
        } else {
            var8 = "";
        }

        return var7.append(var8).toString();
    }

    public String toString() {
        StringBuilder var1 = new StringBuilder("DataSource{");
        var1.append(this.getTypeString());
        if(this.mName != null) {
            var1.append(":").append(this.mName);
        }

        if(this.field_2172 != null) {
            var1.append(":").append(this.field_2172);
        }

        if(this.field_2171 != null) {
            var1.append(":").append(this.field_2171);
        }

        if(this.field_2173 != null) {
            var1.append(":").append(this.field_2173);
        }

        var1.append(":").append(this.field_2176);
        return var1.append("}").toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1125.method_5865(class_848.method_4470(this), var1, var2);
    }

    public static final class Builder {
        // $FF: renamed from: FD int
        private int field_4688 = -1;
        // $FF: renamed from: SO com.google.android.gms.fitness.data.Device
        private Device field_4689;
        // $FF: renamed from: SP com.google.android.gms.fitness.data.a
        private class_1141 field_4690;
        // $FF: renamed from: SQ java.lang.String
        private String field_4691 = "";
        // $FF: renamed from: SR boolean
        private boolean field_4692 = false;
        // $FF: renamed from: Sp com.google.android.gms.fitness.data.DataType
        private DataType field_4693;
        private String mName;

        public DataSource build() {
            boolean var1 = true;
            boolean var2;
            if(this.field_4693 != null) {
                var2 = var1;
            } else {
                var2 = false;
            }

            class_1090.method_5676(var2, "Must set data type");
            if(this.field_4688 < 0) {
                var1 = false;
            }

            class_1090.method_5676(var1, "Must set data source type");
            return new DataSource(this);
        }

        public DataSource.Builder setAppPackageName(Context var1) {
            return this.setAppPackageName(var1.getPackageName());
        }

        public DataSource.Builder setAppPackageName(String var1) {
            this.field_4690 = new class_1141(var1, (String)null, (String)null);
            return this;
        }

        public DataSource.Builder setDataType(DataType var1) {
            this.field_4693 = var1;
            return this;
        }

        public DataSource.Builder setDevice(Device var1) {
            this.field_4689 = var1;
            return this;
        }

        public DataSource.Builder setName(String var1) {
            this.mName = var1;
            return this;
        }

        public DataSource.Builder setObfuscated(boolean var1) {
            this.field_4692 = var1;
            return this;
        }

        public DataSource.Builder setStreamName(String var1) {
            boolean var2;
            if(var1 != null) {
                var2 = true;
            } else {
                var2 = false;
            }

            class_1090.method_5683(var2, "Must specify a valid stream name");
            this.field_4691 = var1;
            return this;
        }

        public DataSource.Builder setType(int var1) {
            this.field_4688 = var1;
            return this;
        }
    }
}
