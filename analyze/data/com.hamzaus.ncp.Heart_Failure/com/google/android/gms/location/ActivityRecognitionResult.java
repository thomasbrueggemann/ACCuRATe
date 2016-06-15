package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.location.ActivityRecognitionResultCreator;
import com.google.android.gms.location.DetectedActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
   public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
   public static final String EXTRA_ACTIVITY_RESULT = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT";
   // $FF: renamed from: US java.util.List
   List<DetectedActivity> field_3343;
   // $FF: renamed from: UT long
   long field_3344;
   // $FF: renamed from: UU long
   long field_3345;
   // $FF: renamed from: xJ int
   private final int field_3346;

   public ActivityRecognitionResult(int var1, List<DetectedActivity> var2, long var3, long var5) {
      this.field_3346 = 1;
      this.field_3343 = var2;
      this.field_3344 = var3;
      this.field_3345 = var5;
   }

   public ActivityRecognitionResult(DetectedActivity var1, long var2, long var4) {
      this(Collections.singletonList(var1), var2, var4);
   }

   public ActivityRecognitionResult(List<DetectedActivity> var1, long var2, long var4) {
      boolean var6;
      if(var1 != null && var1.size() > 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      class_347.method_2168(var6, "Must have at least 1 detected activity");
      long var10;
      int var7 = (var10 = var2 - 0L) == 0L?0:(var10 < 0L?-1:1);
      boolean var8 = false;
      if(var7 > 0) {
         long var11;
         int var9 = (var11 = var4 - 0L) == 0L?0:(var11 < 0L?-1:1);
         var8 = false;
         if(var9 > 0) {
            var8 = true;
         }
      }

      class_347.method_2168(var8, "Must set times");
      this.field_3346 = 1;
      this.field_3343 = var1;
      this.field_3344 = var2;
      this.field_3345 = var4;
   }

   public static ActivityRecognitionResult extractResult(Intent var0) {
      return !hasResult(var0)?null:(ActivityRecognitionResult)var0.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
   }

   public static boolean hasResult(Intent var0) {
      return var0 == null?false:var0.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
   }

   public int describeContents() {
      return 0;
   }

   public int getActivityConfidence(int var1) {
      Iterator var2 = this.field_3343.iterator();

      DetectedActivity var3;
      do {
         if(!var2.hasNext()) {
            return 0;
         }

         var3 = (DetectedActivity)var2.next();
      } while(var3.getType() != var1);

      return var3.getConfidence();
   }

   public long getElapsedRealtimeMillis() {
      return this.field_3345;
   }

   public DetectedActivity getMostProbableActivity() {
      return (DetectedActivity)this.field_3343.get(0);
   }

   public List<DetectedActivity> getProbableActivities() {
      return this.field_3343;
   }

   public long getTime() {
      return this.field_3344;
   }

   public int getVersionCode() {
      return this.field_3346;
   }

   public String toString() {
      return "ActivityRecognitionResult [probableActivities=" + this.field_3343 + ", timeMillis=" + this.field_3344 + ", elapsedRealtimeMillis=" + this.field_3345 + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      ActivityRecognitionResultCreator.method_2854(this, var1, var2);
   }
}
