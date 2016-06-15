package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.fitness.data.class_1052;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;

public final class Value implements SafeParcelable {
   public static final Creator<Value> CREATOR = new class_1052();
   // $FF: renamed from: CK int
   private final int field_2505;
   // $FF: renamed from: UE int
   private final int field_2506;
   // $FF: renamed from: US boolean
   private boolean field_2507;
   // $FF: renamed from: UT float
   private float field_2508;

   Value(int var1) {
      this(1, var1, false, 0.0F);
   }

   Value(int var1, int var2, boolean var3, float var4) {
      this.field_2505 = var1;
      this.field_2506 = var2;
      this.field_2507 = var3;
      this.field_2508 = var4;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Value) boolean
   private boolean method_3266(Value var1) {
      if(this.field_2506 == var1.field_2506 && this.field_2507 == var1.field_2507) {
         switch(this.field_2506) {
         case 1:
            if(this.asInt() != var1.asInt()) {
               return false;
            }
            break;
         case 2:
            if(this.asFloat() != var1.asFloat()) {
               return false;
            }
            break;
         default:
            if(this.field_2508 != var1.field_2508) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public String asActivity() {
      try {
         String var2 = FitnessActivities.getName(this.asInt());
         return var2;
      } catch (IllegalArgumentException var3) {
         return "unknown";
      }
   }

   public float asFloat() {
      boolean var1;
      if(this.field_2506 == 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      class_335.method_2302(var1, "Value is not in float format");
      return this.field_2508;
   }

   public int asInt() {
      byte var1 = 1;
      if(this.field_2506 != var1) {
         var1 = 0;
      }

      class_335.method_2302((boolean)var1, "Value is not in int format");
      return Float.floatToRawIntBits(this.field_2508);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Value && this.method_3266((Value)var1);
   }

   public int getFormat() {
      return this.field_2506;
   }

   int getVersionCode() {
      return this.field_2505;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Float.valueOf(this.field_2508), Integer.valueOf(this.field_2506), Boolean.valueOf(this.field_2507)};
      return class_336.hashCode(var1);
   }

   public boolean isSet() {
      return this.field_2507;
   }

   // $FF: renamed from: jL () float
   float method_3267() {
      return this.field_2508;
   }

   public void setActivity(String var1) {
      this.setInt(FitnessActivities.method_3193(var1));
   }

   public void setFloat(float var1) {
      boolean var2;
      if(this.field_2506 == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2302(var2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.field_2507 = true;
      this.field_2508 = var1;
   }

   public void setInt(int var1) {
      boolean var2;
      if(this.field_2506 == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2302(var2, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.field_2507 = true;
      this.field_2508 = Float.intBitsToFloat(var1);
   }

   public String toString() {
      if(!this.field_2507) {
         return "unset";
      } else {
         switch(this.field_2506) {
         case 1:
            return Integer.toString(this.asInt());
         case 2:
            return Float.toString(this.asFloat());
         default:
            return "unknown";
         }
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1052.method_5776(this, var1, var2);
   }
}
