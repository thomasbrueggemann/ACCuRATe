package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.zzg;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmr;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType implements SafeParcelable {
   public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
   public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
   public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
   @Deprecated
   public static final DataType AGGREGATE_CALORIES_CONSUMED;
   public static final DataType AGGREGATE_CALORIES_EXPENDED;
   public static final DataType AGGREGATE_DISTANCE_DELTA;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.BODY_SENSORS"
   )
   public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
   public static final Set<DataType> AGGREGATE_INPUT_TYPES;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
   public static final DataType AGGREGATE_NUTRITION_SUMMARY;
   public static final DataType AGGREGATE_POWER_SUMMARY;
   public static final DataType AGGREGATE_SPEED_SUMMARY;
   public static final DataType AGGREGATE_STEP_COUNT_DELTA;
   public static final DataType AGGREGATE_WEIGHT_SUMMARY;
   public static final Creator<DataType> CREATOR;
   public static final DataType TYPE_ACTIVITY_SAMPLE;
   public static final DataType TYPE_ACTIVITY_SEGMENT;
   public static final DataType TYPE_BASAL_METABOLIC_RATE;
   public static final DataType TYPE_BODY_FAT_PERCENTAGE;
   public static final DataType TYPE_CALORIES_CONSUMED;
   public static final DataType TYPE_CALORIES_EXPENDED;
   public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
   public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
   public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
   public static final DataType TYPE_CYCLING_WHEEL_RPM;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   @KeepName
   public static final DataType TYPE_DISTANCE_CUMULATIVE;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   public static final DataType TYPE_DISTANCE_DELTA;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.BODY_SENSORS"
   )
   public static final DataType TYPE_HEART_RATE_BPM;
   public static final DataType TYPE_HEIGHT;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   public static final DataType TYPE_LOCATION_SAMPLE;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   public static final DataType TYPE_LOCATION_TRACK;
   public static final DataType TYPE_NUTRITION;
   public static final DataType TYPE_POWER_SAMPLE;
   @RequiresPermission(
      conditional = true,
      value = "android.permission.ACCESS_FINE_LOCATION"
   )
   public static final DataType TYPE_SPEED;
   public static final DataType TYPE_STEP_COUNT_CADENCE;
   @KeepName
   public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
   public static final DataType TYPE_STEP_COUNT_DELTA;
   public static final DataType TYPE_WEIGHT;
   public static final DataType TYPE_WORKOUT_EXERCISE;
   public static final DataType zzawA;
   public static final DataType zzawB;
   private static final Map<DataType, List<DataType>> zzawC;
   public static final DataType[] zzawD;
   public static final DataType zzawv;
   public static final DataType zzaww;
   public static final DataType zzawx;
   public static final DataType zzawy;
   public static final DataType zzawz;
   private final String mName;
   private final int mVersionCode;
   private final List<Field> zzawE;

   static {
      Field[] var0 = new Field[]{Field.FIELD_STEPS};
      TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", var0);
      Field[] var1 = new Field[]{Field.FIELD_STEPS};
      TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", var1);
      Field[] var2 = new Field[]{Field.FIELD_RPM};
      TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", var2);
      Field[] var3 = new Field[]{Field.FIELD_ACTIVITY};
      TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", var3);
      Field[] var4 = new Field[]{Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE, Field.zzawQ, Field.zzawT};
      zzawv = new DataType("com.google.floor_change", var4);
      Field[] var5 = new Field[]{Field.FIELD_CALORIES};
      TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", var5);
      Field[] var6 = new Field[]{Field.FIELD_CALORIES};
      TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", var6);
      Field[] var7 = new Field[]{Field.FIELD_CALORIES};
      TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", var7);
      Field[] var8 = new Field[]{Field.FIELD_WATTS};
      TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", var8);
      Field[] var9 = new Field[]{Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE};
      TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", var9);
      Field[] var10 = new Field[]{Field.zzawW, Field.zzawX, Field.zzawY};
      zzaww = new DataType("com.google.accelerometer", var10);
      Field[] var11 = new Field[]{Field.FIELD_BPM};
      TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", var11);
      Field[] var12 = new Field[]{Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE};
      TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", var12);
      Field[] var13 = new Field[]{Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE};
      TYPE_LOCATION_TRACK = new DataType("com.google.location.track", var13);
      Field[] var14 = new Field[]{Field.FIELD_DISTANCE};
      TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", var14);
      Field[] var15 = new Field[]{Field.FIELD_DISTANCE};
      TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", var15);
      Field[] var16 = new Field[]{Field.FIELD_SPEED};
      TYPE_SPEED = new DataType("com.google.speed", var16);
      Field[] var17 = new Field[]{Field.FIELD_REVOLUTIONS};
      TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", var17);
      Field[] var18 = new Field[]{Field.FIELD_RPM};
      TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", var18);
      Field[] var19 = new Field[]{Field.FIELD_REVOLUTIONS};
      TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", var19);
      Field[] var20 = new Field[]{Field.FIELD_RPM};
      TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", var20);
      Field[] var21 = new Field[]{Field.FIELD_HEIGHT};
      TYPE_HEIGHT = new DataType("com.google.height", var21);
      Field[] var22 = new Field[]{Field.FIELD_WEIGHT};
      TYPE_WEIGHT = new DataType("com.google.weight", var22);
      Field[] var23 = new Field[]{Field.FIELD_PERCENTAGE};
      TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", var23);
      Field[] var24 = new Field[]{Field.FIELD_CIRCUMFERENCE};
      zzawx = new DataType("com.google.body.waist.circumference", var24);
      Field[] var25 = new Field[]{Field.FIELD_CIRCUMFERENCE};
      zzawy = new DataType("com.google.body.hip.circumference", var25);
      Field[] var26 = new Field[]{Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE, Field.FIELD_FOOD_ITEM};
      TYPE_NUTRITION = new DataType("com.google.nutrition", var26);
      Field[] var27 = new Field[]{Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.FIELD_DURATION, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE};
      TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", var27);
      DataType[] var28 = new DataType[]{TYPE_STEP_COUNT_DELTA, TYPE_DISTANCE_DELTA, TYPE_ACTIVITY_SEGMENT, zzawv, TYPE_SPEED, TYPE_HEART_RATE_BPM, TYPE_WEIGHT, TYPE_LOCATION_SAMPLE, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_BODY_FAT_PERCENTAGE, zzawy, zzawx, TYPE_NUTRITION};
      AGGREGATE_INPUT_TYPES = zzmr.zzc(var28);
      Field[] var29 = new Field[]{Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.FIELD_NUM_SEGMENTS};
      AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", var29);
      Field[] var30 = new Field[]{Field.zzawO, Field.zzawP, Field.zzawR, Field.zzawS, Field.zzawU, Field.zzawV};
      zzawz = new DataType("com.google.floor_change.summary", var30);
      Field[] var31 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", var31);
      AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
      AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
      AGGREGATE_CALORIES_CONSUMED = TYPE_CALORIES_CONSUMED;
      AGGREGATE_CALORIES_EXPENDED = TYPE_CALORIES_EXPENDED;
      Field[] var32 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", var32);
      Field[] var33 = new Field[]{Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE};
      AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", var33);
      Field[] var34 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", var34);
      Field[] var35 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", var35);
      Field[] var36 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", var36);
      Field[] var37 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      zzawA = new DataType("com.google.body.hip.circumference.summary", var37);
      Field[] var38 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      zzawB = new DataType("com.google.body.waist.circumference.summary", var38);
      Field[] var39 = new Field[]{Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN};
      AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", var39);
      Field[] var40 = new Field[]{Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE};
      AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", var40);
      zzawC = new HashMap();
      zzawC.put(TYPE_ACTIVITY_SEGMENT, Collections.singletonList(AGGREGATE_ACTIVITY_SUMMARY));
      zzawC.put(TYPE_BASAL_METABOLIC_RATE, Collections.singletonList(AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY));
      zzawC.put(TYPE_BODY_FAT_PERCENTAGE, Collections.singletonList(AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY));
      zzawC.put(zzawy, Collections.singletonList(zzawA));
      zzawC.put(zzawx, Collections.singletonList(zzawB));
      zzawC.put(TYPE_CALORIES_CONSUMED, Collections.singletonList(AGGREGATE_CALORIES_CONSUMED));
      zzawC.put(TYPE_CALORIES_EXPENDED, Collections.singletonList(AGGREGATE_CALORIES_EXPENDED));
      zzawC.put(TYPE_DISTANCE_DELTA, Collections.singletonList(AGGREGATE_DISTANCE_DELTA));
      zzawC.put(zzawv, Collections.singletonList(zzawz));
      zzawC.put(TYPE_LOCATION_SAMPLE, Collections.singletonList(AGGREGATE_LOCATION_BOUNDING_BOX));
      zzawC.put(TYPE_NUTRITION, Collections.singletonList(AGGREGATE_NUTRITION_SUMMARY));
      zzawC.put(TYPE_POWER_SAMPLE, Collections.singletonList(AGGREGATE_POWER_SUMMARY));
      zzawC.put(TYPE_HEART_RATE_BPM, Collections.singletonList(AGGREGATE_HEART_RATE_SUMMARY));
      zzawC.put(TYPE_SPEED, Collections.singletonList(AGGREGATE_SPEED_SUMMARY));
      zzawC.put(TYPE_STEP_COUNT_DELTA, Collections.singletonList(AGGREGATE_STEP_COUNT_DELTA));
      zzawC.put(TYPE_WEIGHT, Collections.singletonList(AGGREGATE_WEIGHT_SUMMARY));
      DataType[] var57 = new DataType[]{zzaww, TYPE_WORKOUT_EXERCISE, TYPE_ACTIVITY_SAMPLE, TYPE_ACTIVITY_SEGMENT, AGGREGATE_ACTIVITY_SUMMARY, TYPE_BODY_FAT_PERCENTAGE, AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY, zzawy, zzawA, zzawx, zzawB, TYPE_BASAL_METABOLIC_RATE, AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY, TYPE_CALORIES_CONSUMED, TYPE_CALORIES_EXPENDED, TYPE_CYCLING_PEDALING_CADENCE, TYPE_CYCLING_PEDALING_CUMULATIVE, TYPE_CYCLING_WHEEL_REVOLUTION, TYPE_CYCLING_WHEEL_RPM, TYPE_DISTANCE_CUMULATIVE, TYPE_DISTANCE_DELTA, zzawv, zzawz, TYPE_HEART_RATE_BPM, AGGREGATE_HEART_RATE_SUMMARY, TYPE_HEIGHT, AGGREGATE_LOCATION_BOUNDING_BOX, TYPE_LOCATION_SAMPLE, TYPE_LOCATION_TRACK, TYPE_NUTRITION, AGGREGATE_NUTRITION_SUMMARY, TYPE_POWER_SAMPLE, AGGREGATE_POWER_SUMMARY, TYPE_SPEED, AGGREGATE_SPEED_SUMMARY, TYPE_STEP_COUNT_CADENCE, TYPE_STEP_COUNT_CUMULATIVE, TYPE_STEP_COUNT_DELTA, TYPE_WEIGHT, AGGREGATE_WEIGHT_SUMMARY};
      zzawD = var57;
      CREATOR = new zzg();
   }

   DataType(int var1, String var2, List<Field> var3) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzawE = Collections.unmodifiableList(var3);
   }

   public DataType(String var1, Field... var2) {
      this(1, var1, zzmn.zzb(var2));
   }

   private boolean zza(DataType var1) {
      return this.mName.equals(var1.mName) && this.zzawE.equals(var1.zzawE);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataType && this.zza((DataType)var1);
   }

   public List<Field> getFields() {
      return this.zzawE;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return this.mName.hashCode();
   }

   public String toString() {
      Object[] var1 = new Object[]{this.mName, this.zzawE};
      return String.format("DataType{%s%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }

   public String zzuo() {
      return this.mName.startsWith("com.google.")?this.mName.substring(11):this.mName;
   }
}
