package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.DetectedActivityCreator;

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
   // $FF: renamed from: UV int
   int field_3947;
   // $FF: renamed from: UW int
   int field_3948;
   // $FF: renamed from: xJ int
   private final int field_3949;

   public DetectedActivity(int var1, int var2) {
      this.field_3949 = 1;
      this.field_3947 = var1;
      this.field_3948 = var2;
   }

   public DetectedActivity(int var1, int var2, int var3) {
      this.field_3949 = var1;
      this.field_3947 = var2;
      this.field_3948 = var3;
   }

   // $FF: renamed from: cF (int) int
   private int method_4229(int var1) {
      if(var1 > 8) {
         var1 = 4;
      }

      return var1;
   }

   public int describeContents() {
      return 0;
   }

   public int getConfidence() {
      return this.field_3948;
   }

   public int getType() {
      return this.method_4229(this.field_3947);
   }

   public int getVersionCode() {
      return this.field_3949;
   }

   public String toString() {
      return "DetectedActivity [type=" + this.getType() + ", confidence=" + this.field_3948 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      DetectedActivityCreator.method_2923(this, var1, var2);
   }
}
