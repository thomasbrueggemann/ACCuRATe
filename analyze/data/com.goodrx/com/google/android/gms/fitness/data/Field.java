package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;

public final class Field implements SafeParcelable {
   public static final Creator<Field> CREATOR = new zzj();
   public static final Field FIELD_ACCURACY = zzdp("accuracy");
   public static final Field FIELD_ACTIVITY = zzdo("activity");
   public static final Field FIELD_ALTITUDE = zzdq("altitude");
   public static final Field FIELD_AVERAGE = zzdp("average");
   public static final Field FIELD_BPM = zzdp("bpm");
   public static final Field FIELD_CALORIES = zzdp("calories");
   public static final Field FIELD_CIRCUMFERENCE = zzdp("circumference");
   public static final Field FIELD_CONFIDENCE = zzdp("confidence");
   public static final Field FIELD_DISTANCE = zzdp("distance");
   public static final Field FIELD_DURATION = zzdo("duration");
   public static final Field FIELD_EXERCISE = zzdr("exercise");
   public static final Field FIELD_FOOD_ITEM = zzdr("food_item");
   public static final Field FIELD_HEIGHT = zzdp("height");
   public static final Field FIELD_HIGH_LATITUDE = zzdp("high_latitude");
   public static final Field FIELD_HIGH_LONGITUDE = zzdp("high_longitude");
   public static final Field FIELD_LATITUDE = zzdp("latitude");
   public static final Field FIELD_LONGITUDE = zzdp("longitude");
   public static final Field FIELD_LOW_LATITUDE = zzdp("low_latitude");
   public static final Field FIELD_LOW_LONGITUDE = zzdp("low_longitude");
   public static final Field FIELD_MAX = zzdp("max");
   public static final Field FIELD_MEAL_TYPE = zzdo("meal_type");
   public static final Field FIELD_MIN = zzdp("min");
   public static final Field FIELD_NUM_SEGMENTS = zzdo("num_segments");
   public static final Field FIELD_NUTRIENTS = zzds("nutrients");
   public static final Field FIELD_PERCENTAGE = zzdp("percentage");
   public static final Field FIELD_REPETITIONS = zzdo("repetitions");
   public static final Field FIELD_RESISTANCE = zzdp("resistance");
   public static final Field FIELD_RESISTANCE_TYPE = zzdo("resistance_type");
   public static final Field FIELD_REVOLUTIONS = zzdo("revolutions");
   public static final Field FIELD_RPM = zzdp("rpm");
   public static final Field FIELD_SPEED = zzdp("speed");
   public static final Field FIELD_STEPS = zzdo("steps");
   public static final Field FIELD_WATTS = zzdp("watts");
   public static final Field FIELD_WEIGHT = zzdp("weight");
   public static final Field zzawM = zzds("activity_confidence");
   public static final Field zzawN = zzds("activity_duration");
   public static final Field zzawO = zzds("activity_duration.ascending");
   public static final Field zzawP = zzds("activity_duration.descending");
   public static final Field zzawQ = zzdp("elevation.change");
   public static final Field zzawR = zzds("elevation.gain");
   public static final Field zzawS = zzds("elevation.loss");
   public static final Field zzawT = zzdp("floors");
   public static final Field zzawU = zzds("floor.gain");
   public static final Field zzawV = zzds("floor.loss");
   public static final Field zzawW = zzdp("x");
   public static final Field zzawX = zzdp("y");
   public static final Field zzawY = zzdp("z");
   private final String mName;
   private final int mVersionCode;
   private final int zzawZ;
   private final Boolean zzaxa;

   Field(int var1, String var2, int var3, Boolean var4) {
      this.mVersionCode = var1;
      this.mName = (String)zzx.zzz(var2);
      this.zzawZ = var3;
      this.zzaxa = var4;
   }

   private Field(String var1, int var2) {
      this(2, var1, var2, (Boolean)null);
   }

   private Field(String var1, int var2, Boolean var3) {
      this(2, var1, var2, var3);
   }

   private boolean zza(Field var1) {
      return this.mName.equals(var1.mName) && this.zzawZ == var1.zzawZ;
   }

   private static Field zzdo(String var0) {
      return new Field(var0, 1);
   }

   private static Field zzdp(String var0) {
      return new Field(var0, 2);
   }

   private static Field zzdq(String var0) {
      return new Field(var0, 2, Boolean.valueOf(true));
   }

   private static Field zzdr(String var0) {
      return new Field(var0, 3);
   }

   private static Field zzds(String var0) {
      return new Field(var0, 4);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Field && this.zza((Field)var1);
   }

   public int getFormat() {
      return this.zzawZ;
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

   public Boolean isOptional() {
      return this.zzaxa;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.mName, null};
      String var2;
      if(this.zzawZ == 1) {
         var2 = "i";
      } else {
         var2 = "f";
      }

      var1[1] = var2;
      return String.format("%s(%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzj.zza(this, var1, var2);
   }
}
