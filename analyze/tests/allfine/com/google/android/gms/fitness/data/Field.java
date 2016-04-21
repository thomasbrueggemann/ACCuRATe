package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_1129;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR = new class_1129();
    public static final Field FIELD_ACCURACY = method_4918("accuracy");
    public static final Field FIELD_ACTIVITY = method_4917("activity");
    public static final Field FIELD_ALTITUDE = method_4918("altitude");
    public static final Field FIELD_AVERAGE = method_4918("average");
    public static final Field FIELD_BPM = method_4918("bpm");
    public static final Field FIELD_CALORIES = method_4918("calories");
    public static final Field FIELD_CONFIDENCE = method_4918("confidence");
    public static final Field FIELD_DISTANCE = method_4918("distance");
    public static final Field FIELD_DURATION = method_4917("duration");
    public static final Field FIELD_HEIGHT = method_4918("height");
    public static final Field FIELD_HIGH_LATITUDE = method_4918("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = method_4918("high_longitude");
    public static final Field FIELD_LATITUDE = method_4918("latitude");
    public static final Field FIELD_LONGITUDE = method_4918("longitude");
    public static final Field FIELD_LOW_LATITUDE = method_4918("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = method_4918("low_longitude");
    public static final Field FIELD_MAX = method_4918("max");
    public static final Field FIELD_MIN = method_4918("min");
    public static final Field FIELD_NUM_SEGMENTS = method_4917("num_segments");
    public static final Field FIELD_REVOLUTIONS = method_4917("revolutions");
    public static final Field FIELD_RPM = method_4918("rpm");
    public static final Field FIELD_SPEED = method_4918("speed");
    public static final Field FIELD_STEPS = method_4917("steps");
    public static final Field FIELD_WATTS = method_4918("watts");
    public static final Field FIELD_WEIGHT = method_4918("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    // $FF: renamed from: Td com.google.android.gms.fitness.data.Field
    public static final Field field_4336 = method_4917("edge_type");
    // $FF: renamed from: Te com.google.android.gms.fitness.data.Field
    public static final Field field_4337 = method_4918("x");
    // $FF: renamed from: Tf com.google.android.gms.fitness.data.Field
    public static final Field field_4338 = method_4918("y");
    // $FF: renamed from: Tg com.google.android.gms.fitness.data.Field
    public static final Field field_4339 = method_4918("z");
    // $FF: renamed from: BR int
    private final int field_4340;
    // $FF: renamed from: Th int
    private final int field_4341;
    private final String mName;

    Field(int var1, String var2, int var3) {
        this.field_4340 = var1;
        this.mName = var2;
        this.field_4341 = var3;
    }

    public Field(String var1, int var2) {
        this(1, var1, var2);
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.Field) boolean
    private boolean method_4916(Field var1) {
        return this.mName.equals(var1.mName) && this.field_4341 == var1.field_4341;
    }

    // $FF: renamed from: br (java.lang.String) com.google.android.gms.fitness.data.Field
    private static Field method_4917(String var0) {
        return new Field(var0, 1);
    }

    // $FF: renamed from: bs (java.lang.String) com.google.android.gms.fitness.data.Field
    private static Field method_4918(String var0) {
        return new Field(var0, 2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof Field && this.method_4916((Field)var1);
    }

    public int getFormat() {
        return this.field_4341;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.field_4340;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        Object[] var1 = new Object[] {this.mName, null};
        String var2;
        if(this.field_4341 == 1) {
            var2 = "i";
        } else {
            var2 = "f";
        }

        var1[1] = var2;
        return String.format("%s(%s)", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1129.method_5877(this, var1, var2);
    }
}
