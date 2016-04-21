package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.class_1131;
import com.google.android.gms.internal.class_348;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType implements SafeParcelable {
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
    public static final DataType AGGREGATE_DISTANCE_DELTA;
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
    public static final Set<DataType> AGGREGATE_INPUT_TYPES;
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
    public static final DataType AGGREGATE_POWER_SUMMARY;
    public static final DataType AGGREGATE_SPEED_SUMMARY;
    public static final DataType AGGREGATE_STEP_COUNT_DELTA;
    public static final DataType AGGREGATE_WEIGHT_SUMMARY;
    public static final Creator<DataType> CREATOR;
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";
    // $FF: renamed from: ST com.google.android.gms.fitness.data.DataType
    public static final DataType field_5099;
    // $FF: renamed from: SU com.google.android.gms.fitness.data.DataType
    public static final DataType field_5100;
    // $FF: renamed from: SV java.util.Map
    private static final Map<DataType, List<DataType>> field_5101;
    // $FF: renamed from: SW com.google.android.gms.fitness.data.DataType[]
    public static final DataType[] field_5102;
    // $FF: renamed from: SX java.lang.String[]
    public static final String[] field_5103;
    public static final DataType TYPE_ACTIVITY_SAMPLE;
    public static final DataType TYPE_ACTIVITY_SEGMENT;
    public static final DataType TYPE_CALORIES_CONSUMED;
    public static final DataType TYPE_CALORIES_EXPENDED;
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
    public static final DataType TYPE_CYCLING_WHEEL_RPM;
    public static final DataType TYPE_DISTANCE_CUMULATIVE;
    public static final DataType TYPE_DISTANCE_DELTA;
    public static final DataType TYPE_HEART_RATE_BPM;
    public static final DataType TYPE_HEIGHT;
    public static final DataType TYPE_LOCATION_SAMPLE;
    public static final DataType TYPE_POWER_SAMPLE;
    public static final DataType TYPE_SPEED;
    public static final DataType TYPE_STEP_COUNT_CADENCE;
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
    public static final DataType TYPE_STEP_COUNT_DELTA;
    public static final DataType TYPE_WEIGHT;
    // $FF: renamed from: BR int
    private final int field_5104;
    // $FF: renamed from: SY java.util.List
    private final List<Field> field_5105;
    private final String mName;

    static {
        Field[] var0 = new Field[] {Field.FIELD_STEPS};
        TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", var0);
        Field[] var1 = new Field[] {Field.FIELD_STEPS};
        TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", var1);
        Field[] var2 = new Field[] {Field.FIELD_RPM};
        TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", var2);
        Field[] var3 = new Field[] {Field.FIELD_ACTIVITY};
        TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", var3);
        Field[] var4 = new Field[] {Field.FIELD_CALORIES};
        TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", var4);
        Field[] var5 = new Field[] {Field.FIELD_CALORIES};
        TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", var5);
        Field[] var6 = new Field[] {Field.FIELD_WATTS};
        TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", var6);
        Field[] var7 = new Field[] {Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE};
        TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", var7);
        Field[] var8 = new Field[] {Field.FIELD_ACTIVITY, Field.field_4336};
        field_5099 = new DataType("com.google.activity.edge", var8);
        Field[] var9 = new Field[] {Field.field_4337, Field.field_4338, Field.field_4339};
        field_5100 = new DataType("com.google.accelerometer", var9);
        Field[] var10 = new Field[] {Field.FIELD_BPM};
        TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", var10);
        Field[] var11 = new Field[] {Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE};
        TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", var11);
        Field[] var12 = new Field[] {Field.FIELD_DISTANCE};
        TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", var12);
        Field[] var13 = new Field[] {Field.FIELD_DISTANCE};
        TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", var13);
        Field[] var14 = new Field[] {Field.FIELD_SPEED};
        TYPE_SPEED = new DataType("com.google.speed", var14);
        Field[] var15 = new Field[] {Field.FIELD_REVOLUTIONS};
        TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", var15);
        Field[] var16 = new Field[] {Field.FIELD_RPM};
        TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", var16);
        Field[] var17 = new Field[] {Field.FIELD_REVOLUTIONS};
        TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", var17);
        Field[] var18 = new Field[] {Field.FIELD_RPM};
        TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", var18);
        Field[] var19 = new Field[] {Field.FIELD_HEIGHT};
        TYPE_HEIGHT = new DataType("com.google.height", var19);
        Field[] var20 = new Field[] {Field.FIELD_WEIGHT};
        TYPE_WEIGHT = new DataType("com.google.weight", var20);
        DataType[] var21 = new DataType[] {TYPE_STEP_COUNT_DELTA, TYPE_DISTANCE_DELTA, TYPE_ACTIVITY_SEGMENT, TYPE_SPEED, TYPE_HEART_RATE_BPM, TYPE_WEIGHT, TYPE_LOCATION_SAMPLE};
        AGGREGATE_INPUT_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(var21)));
        Field[] var22 = new Field[] {Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.FIELD_NUM_SEGMENTS};
        AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", var22);
        AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
        AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
        Field[] var23 = new Field[] {Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
        AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", var23);
        Field[] var24 = new Field[] {Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE};
        AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", var24);
        Field[] var25 = new Field[] {Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
        AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", var25);
        Field[] var26 = new Field[] {Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
        AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", var26);
        Field[] var27 = new Field[] {Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
        AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", var27);
        field_5101 = new HashMap() {
            {
                DataType var1 = DataType.TYPE_ACTIVITY_SEGMENT;
                DataType[] var2 = new DataType[] {DataType.AGGREGATE_ACTIVITY_SUMMARY};
                this.put(var1, Arrays.asList(var2));
                DataType var4 = DataType.TYPE_DISTANCE_DELTA;
                DataType[] var5 = new DataType[] {DataType.AGGREGATE_DISTANCE_DELTA};
                this.put(var4, Arrays.asList(var5));
                DataType var7 = DataType.TYPE_LOCATION_SAMPLE;
                DataType[] var8 = new DataType[] {DataType.AGGREGATE_LOCATION_BOUNDING_BOX};
                this.put(var7, Arrays.asList(var8));
                DataType var10 = DataType.TYPE_POWER_SAMPLE;
                DataType[] var11 = new DataType[] {DataType.AGGREGATE_POWER_SUMMARY};
                this.put(var10, Arrays.asList(var11));
                DataType var13 = DataType.TYPE_HEART_RATE_BPM;
                DataType[] var14 = new DataType[] {DataType.AGGREGATE_HEART_RATE_SUMMARY};
                this.put(var13, Arrays.asList(var14));
                DataType var16 = DataType.TYPE_SPEED;
                DataType[] var17 = new DataType[] {DataType.AGGREGATE_SPEED_SUMMARY};
                this.put(var16, Arrays.asList(var17));
                DataType var19 = DataType.TYPE_STEP_COUNT_DELTA;
                DataType[] var20 = new DataType[] {DataType.AGGREGATE_STEP_COUNT_DELTA};
                this.put(var19, Arrays.asList(var20));
                DataType var22 = DataType.TYPE_WEIGHT;
                DataType[] var23 = new DataType[] {DataType.AGGREGATE_WEIGHT_SUMMARY};
                this.put(var22, Arrays.asList(var23));
            }
        };
        DataType[] var28 = new DataType[] {field_5100, field_5099, TYPE_ACTIVITY_SAMPLE, TYPE_ACTIVITY_SEGMENT, AGGREGATE_ACTIVITY_SUMMARY, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_CYCLING_PEDALING_CADENCE, TYPE_CYCLING_PEDALING_CUMULATIVE, TYPE_CYCLING_WHEEL_REVOLUTION, TYPE_CYCLING_WHEEL_RPM, TYPE_DISTANCE_CUMULATIVE, TYPE_DISTANCE_DELTA, TYPE_HEART_RATE_BPM, AGGREGATE_HEART_RATE_SUMMARY, TYPE_HEIGHT, AGGREGATE_LOCATION_BOUNDING_BOX, TYPE_LOCATION_SAMPLE, TYPE_POWER_SAMPLE, AGGREGATE_POWER_SUMMARY, TYPE_SPEED, AGGREGATE_SPEED_SUMMARY, TYPE_STEP_COUNT_CADENCE, TYPE_STEP_COUNT_CUMULATIVE, TYPE_STEP_COUNT_DELTA, TYPE_WEIGHT, AGGREGATE_WEIGHT_SUMMARY};
        field_5102 = var28;
        String[] var29 = new String[] {field_5100.getName(), field_5099.getName(), TYPE_ACTIVITY_SAMPLE.getName(), TYPE_ACTIVITY_SEGMENT.getName(), AGGREGATE_ACTIVITY_SUMMARY.getName(), TYPE_CALORIES_CONSUMED.getName(), TYPE_CALORIES_EXPENDED.getName(), TYPE_CYCLING_PEDALING_CADENCE.getName(), TYPE_CYCLING_PEDALING_CUMULATIVE.getName(), TYPE_CYCLING_WHEEL_REVOLUTION.getName(), TYPE_CYCLING_WHEEL_RPM.getName(), TYPE_DISTANCE_CUMULATIVE.getName(), TYPE_DISTANCE_DELTA.getName(), TYPE_HEART_RATE_BPM.getName(), AGGREGATE_HEART_RATE_SUMMARY.getName(), TYPE_HEIGHT.getName(), AGGREGATE_LOCATION_BOUNDING_BOX.getName(), TYPE_LOCATION_SAMPLE.getName(), TYPE_POWER_SAMPLE.getName(), AGGREGATE_POWER_SUMMARY.getName(), TYPE_SPEED.getName(), AGGREGATE_SPEED_SUMMARY.getName(), TYPE_STEP_COUNT_CADENCE.getName(), TYPE_STEP_COUNT_CUMULATIVE.getName(), TYPE_STEP_COUNT_DELTA.getName(), TYPE_WEIGHT.getName(), AGGREGATE_WEIGHT_SUMMARY.getName()};
        field_5103 = var29;
        CREATOR = new class_1131();
    }

    DataType(int var1, String var2, List<Field> var3) {
        this.field_5104 = var1;
        this.mName = var2;
        this.field_5105 = Collections.unmodifiableList(var3);
    }

    public DataType(String var1, Field... var2) {
        this(1, var1, class_348.method_2341(var2));
    }

    // $FF: renamed from: a (com.google.android.gms.fitness.data.DataType) boolean
    private boolean method_5598(DataType var1) {
        return this.mName.equals(var1.mName) && this.field_5105.equals(var1.field_5105);
    }

    public static List<DataType> getAggregatesForInput(DataType var0) {
        List var1 = (List)field_5101.get(var0);
        return var1 == null?Collections.emptyList():Collections.unmodifiableList(var1);
    }

    public static String getMimeType(DataType var0) {
        return "vnd.google.fitness.data_type/" + var0.getName();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return this == var1 || var1 instanceof DataType && this.method_5598((DataType)var1);
    }

    public List<Field> getFields() {
        return this.field_5105;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.field_5104;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    // $FF: renamed from: iQ () java.lang.String
    public String method_5599() {
        return this.mName.startsWith("com.google.")?this.mName.substring(11):this.mName;
    }

    public int indexOf(Field var1) {
        if(this.field_5105.contains(var1)) {
            return this.field_5105.indexOf(var1);
        } else {
            throw new IllegalArgumentException(String.format("%s not a field of %s", new Object[] {var1, this}));
        }
    }

    public String toString() {
        Object[] var1 = new Object[] {this.mName, this.field_5105};
        return String.format("DataType{%s%s}", var1);
    }

    public void writeToParcel(Parcel var1, int var2) {
        class_1131.method_5883(this, var1, var2);
    }
}
