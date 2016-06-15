package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_1039;
import com.google.android.gms.internal.class_335;

public final class Field implements SafeParcelable {
   public static final Creator<Field> CREATOR = new class_1039();
   public static final Field FIELD_ACCURACY = method_4762("accuracy");
   public static final Field FIELD_ACTIVITY = method_4761("activity");
   public static final Field FIELD_ALTITUDE = method_4762("altitude");
   public static final Field FIELD_AVERAGE = method_4762("average");
   public static final Field FIELD_BPM = method_4762("bpm");
   public static final Field FIELD_CALORIES = method_4762("calories");
   public static final Field FIELD_CONFIDENCE = method_4762("confidence");
   public static final Field FIELD_DISTANCE = method_4762("distance");
   public static final Field FIELD_DURATION = method_4761("duration");
   public static final Field FIELD_HEIGHT = method_4762("height");
   public static final Field FIELD_HIGH_LATITUDE = method_4762("high_latitude");
   public static final Field FIELD_HIGH_LONGITUDE = method_4762("high_longitude");
   public static final Field FIELD_LATITUDE = method_4762("latitude");
   public static final Field FIELD_LONGITUDE = method_4762("longitude");
   public static final Field FIELD_LOW_LATITUDE = method_4762("low_latitude");
   public static final Field FIELD_LOW_LONGITUDE = method_4762("low_longitude");
   public static final Field FIELD_MAX = method_4762("max");
   public static final Field FIELD_MIN = method_4762("min");
   public static final Field FIELD_NUM_SEGMENTS = method_4761("num_segments");
   public static final Field FIELD_REVOLUTIONS = method_4761("revolutions");
   public static final Field FIELD_RPM = method_4762("rpm");
   public static final Field FIELD_SPEED = method_4762("speed");
   public static final Field FIELD_STEPS = method_4761("steps");
   public static final Field FIELD_WATTS = method_4762("watts");
   public static final Field FIELD_WEIGHT = method_4762("weight");
   public static final int FORMAT_FLOAT = 2;
   public static final int FORMAT_INT32 = 1;
   // $FF: renamed from: UA com.google.android.gms.fitness.data.Field
   public static final Field field_3583 = method_4761("edge_type");
   // $FF: renamed from: UB com.google.android.gms.fitness.data.Field
   public static final Field field_3584 = method_4762("x");
   // $FF: renamed from: UC com.google.android.gms.fitness.data.Field
   public static final Field field_3585 = method_4762("y");
   // $FF: renamed from: UD com.google.android.gms.fitness.data.Field
   public static final Field field_3586 = method_4762("z");
   // $FF: renamed from: CK int
   private final int field_3587;
   // $FF: renamed from: UE int
   private final int field_3588;
   private final String mName;

   Field(int var1, String var2, int var3) {
      this.field_3587 = var1;
      this.mName = (String)class_335.method_2311(var2);
      this.field_3588 = var3;
   }

   public Field(String var1, int var2) {
      this(1, var1, var2);
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Field) boolean
   private boolean method_4760(Field var1) {
      return this.mName.equals(var1.mName) && this.field_3588 == var1.field_3588;
   }

   // $FF: renamed from: bu (java.lang.String) com.google.android.gms.fitness.data.Field
   private static Field method_4761(String var0) {
      return new Field(var0, 1);
   }

   // $FF: renamed from: bv (java.lang.String) com.google.android.gms.fitness.data.Field
   private static Field method_4762(String var0) {
      return new Field(var0, 2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Field && this.method_4760((Field)var1);
   }

   public int getFormat() {
      return this.field_3588;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.field_3587;
   }

   public int hashCode() {
      return this.mName.hashCode();
   }

   public String toString() {
      Object[] var1 = new Object[]{this.mName, null};
      String var2;
      if(this.field_3588 == 1) {
         var2 = "i";
      } else {
         var2 = "f";
      }

      var1[1] = var2;
      return String.format("%s(%s)", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1039.method_5726(this, var1, var2);
   }
}
