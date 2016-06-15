package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DetectedActivityCreator;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
   public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
   public static final int IN_VEHICLE = 0;
   public static final int ON_BICYCLE = 1;
   public static final int ON_FOOT = 2;
   public static final int RUNNING = 8;
   public static final int STILL = 3;
   public static final int TILTING = 5;
   public static final int UNKNOWN = 4;
   public static final int WALKING = 7;
   public static final Comparator<DetectedActivity> aga = new Comparator() {
      // $FF: renamed from: a (com.google.android.gms.location.DetectedActivity, com.google.android.gms.location.DetectedActivity) int
      public int method_3072(DetectedActivity var1, DetectedActivity var2) {
         int var3 = Integer.valueOf(var2.getConfidence()).compareTo(Integer.valueOf(var1.getConfidence()));
         if(var3 == 0) {
            var3 = Integer.valueOf(var1.getType()).compareTo(Integer.valueOf(var2.getType()));
         }

         return var3;
      }

      // $FF: synthetic method
      public int compare(Object var1, Object var2) {
         return this.method_3072((DetectedActivity)var1, (DetectedActivity)var2);
      }
   };
   // $FF: renamed from: CK int
   private final int field_4034;
   int agb;
   int agc;

   public DetectedActivity(int var1, int var2) {
      this.field_4034 = 1;
      this.agb = var1;
      this.agc = var2;
   }

   public DetectedActivity(int var1, int var2, int var3) {
      this.field_4034 = var1;
      this.agb = var2;
      this.agc = var3;
   }

   // $FF: renamed from: ev (int) int
   private int method_5331(int var1) {
      if(var1 > 9) {
         var1 = 4;
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   public int getConfidence() {
      return this.agc;
   }

   public int getType() {
      return this.method_5331(this.agb);
   }

   public int getVersionCode() {
      return this.field_4034;
   }

   public String toString() {
      return "DetectedActivity [type=" + this.getType() + ", confidence=" + this.agc + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      DetectedActivityCreator.method_3497(this, var1, var2);
   }
}
