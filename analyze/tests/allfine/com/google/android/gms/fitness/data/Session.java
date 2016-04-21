package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.class_1089;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.class_822;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.class_1138;
import com.google.android.gms.fitness.data.class_1141;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR = new class_1138();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    // $FF: renamed from: BR int
    private final int field_5211;
    // $FF: renamed from: KS long
    private final long field_5212;
    // $FF: renamed from: SC int
    private final int field_5213;
    // $FF: renamed from: SP com.google.android.gms.fitness.data.a
    private final class_1141 field_5214;
    // $FF: renamed from: Sr long
    private final long field_5215;
    // $FF: renamed from: Tq java.lang.String
    private final String field_5216;
    // $FF: renamed from: Tr java.lang.String
    private final String field_5217;
    private final String mName;

    Session(int var1, long var2, long var4, String var6, String var7, String var8, int var9, class_1141 var10) {
        this.field_5211 = var1;
        this.field_5212 = var2;
        this.field_5215 = var4;
        this.mName = var6;
        this.field_5216 = var7;
        this.field_5217 = var8;
        this.field_5213 = var9;
        this.field_5214 = var10;
    }

    private Session(Session.Builder var1) {
        this.field_5211 = 2;
        this.field_5212 = var1.field_5011;
        this.field_5215 = var1.field_5014;
        this.mName = var1.mName;
        this.field_5216 = var1.field_5015;
        this.field_5217 = var1.field_5016;
        this.field_5213 = var1.field_5012;
        this.field_5214 = var1.field_5013;
    }

    // $FF: synthetic method
    Session(Session.Builder var1, Object var2) {
        this(var1);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Session) boolean
    private boolean method_5845(Session var1) {
        return this.field_5212 == var1.field_5212 && this.field_5215 == var1.field_5215 && class_1089.equal(this.mName, var1.mName) && class_1089.equal(this.field_5216, var1.field_5216) && class_1089.equal(this.field_5217, var1.field_5217) && class_1089.equal(this.field_5214, var1.field_5214) && this.field_5213 == var1.field_5213;
    }

    public static Session extract(Intent var0) {
        return var0 == null?null:(Session)class_822.method_4294(var0, "vnd.google.fitness.session", CREATOR);
    }

    public static String getMimeType(String var0) {
        return "vnd.google.fitness.session/" + var0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return var1 == this || var1 instanceof Session && this.method_5845((Session)var1);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.field_5213);
    }

    public String getAppPackageName() {
        return this.field_5214 == null?null:this.field_5214.getPackageName();
    }

    public String getDescription() {
        return this.field_5217;
    }

    public long getEndTime(TimeUnit var1) {
        return var1.convert(this.field_5215, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.field_5216;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit var1) {
        return var1.convert(this.field_5212, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.field_5211;
    }

    public int hashCode() {
        Object[] var1 = new Object[] {Long.valueOf(this.field_5212), Long.valueOf(this.field_5215), this.field_5216};
        return class_1089.hashCode(var1);
    }

    // $FF: renamed from: iB () int
    public int method_5846() {
        return this.field_5213;
    }

    // $FF: renamed from: iD () long
    public long method_5847() {
        return this.field_5212;
    }

    // $FF: renamed from: iE () long
    public long method_5848() {
        return this.field_5215;
    }

    // $FF: renamed from: iM () com.google.android.gms.fitness.data.a
    public class_1141 method_5849() {
        return this.field_5214;
    }

    public boolean isOngoing() {
        return this.field_5215 == 0L;
    }

    public String toString() {
        return class_1089.method_5673(this).method_5425("startTime", Long.valueOf(this.field_5212)).method_5425("endTime", Long.valueOf(this.field_5215)).method_5425("name", this.mName).method_5425("identifier", this.field_5216).method_5425("description", this.field_5217).method_5425("activity", Integer.valueOf(this.field_5213)).method_5425("application", this.field_5214).toString();
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1138.method_5903(this, var1, var2);
    }

    public static class Builder {
        // $FF: renamed from: KS long
        private long field_5011 = 0L;
        // $FF: renamed from: SC int
        private int field_5012 = 4;
        // $FF: renamed from: SP com.google.android.gms.fitness.data.a
        private class_1141 field_5013;
        // $FF: renamed from: Sr long
        private long field_5014 = 0L;
        // $FF: renamed from: Tq java.lang.String
        private String field_5015;
        // $FF: renamed from: Tr java.lang.String
        private String field_5016;
        private String mName = null;

        public Session build() {
            boolean var1;
            if(this.field_5011 > 0L) {
                var1 = true;
            } else {
                var1 = false;
            }

            boolean var2;
            label24: {
                class_1090.method_5676(var1, "Start time should be specified.");
                if(this.field_5014 != 0L) {
                    long var6;
                    int var5 = (var6 = this.field_5014 - this.field_5011) == 0L?0:(var6 < 0L?-1:1);
                    var2 = false;
                    if(var5 <= 0) {
                        break label24;
                    }
                }

                var2 = true;
            }

            class_1090.method_5676(var2, "End time should be later than start time.");
            if(this.field_5015 == null) {
                StringBuilder var3 = new StringBuilder();
                String var4;
                if(this.mName == null) {
                    var4 = "";
                } else {
                    var4 = this.mName;
                }

                this.field_5015 = var3.append(var4).append(this.field_5011).toString();
            }

            return new Session(this);
        }

        // $FF: renamed from: cK (int) com.google.android.gms.fitness.data.Session$Builder
        public Session.Builder method_5537(int var1) {
            this.field_5012 = var1;
            return this;
        }

        public Session.Builder setActivity(String var1) {
            return this.method_5537(FitnessActivities.method_3152(var1));
        }

        public Session.Builder setDescription(String var1) {
            boolean var2;
            if(var1.length() <= 1000) {
                var2 = true;
            } else {
                var2 = false;
            }

            Object[] var3 = new Object[] {Integer.valueOf(1000)};
            class_1090.method_5684(var2, "Session description cannot exceed %d characters", var3);
            this.field_5016 = var1;
            return this;
        }

        public Session.Builder setEndTime(long var1, TimeUnit var3) {
            boolean var4;
            if(var1 >= 0L) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5676(var4, "End time should be positive.");
            this.field_5014 = var3.toMillis(var1);
            return this;
        }

        public Session.Builder setIdentifier(String var1) {
            boolean var2;
            if(var1 != null && TextUtils.getTrimmedLength(var1) > 0) {
                var2 = true;
            } else {
                var2 = false;
            }

            class_1090.method_5675(var2);
            this.field_5015 = var1;
            return this;
        }

        public Session.Builder setName(String var1) {
            boolean var2;
            if(var1.length() <= 100) {
                var2 = true;
            } else {
                var2 = false;
            }

            Object[] var3 = new Object[] {Integer.valueOf(100)};
            class_1090.method_5684(var2, "Session name cannot exceed %d characters", var3);
            this.mName = var1;
            return this;
        }

        public Session.Builder setStartTime(long var1, TimeUnit var3) {
            boolean var4;
            if(var1 > 0L) {
                var4 = true;
            } else {
                var4 = false;
            }

            class_1090.method_5676(var4, "Start time should be positive.");
            this.field_5011 = var3.toMillis(var1);
            return this;
        }
    }
}
