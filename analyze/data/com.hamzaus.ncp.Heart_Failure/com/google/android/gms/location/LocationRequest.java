package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_349;
import com.google.android.gms.location.LocationRequestCreator;

public final class LocationRequest implements SafeParcelable {
   public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
   public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
   public static final int PRIORITY_HIGH_ACCURACY = 100;
   public static final int PRIORITY_LOW_POWER = 104;
   public static final int PRIORITY_NO_POWER = 105;
   // $FF: renamed from: UY long
   long field_3676;
   // $FF: renamed from: Vi long
   long field_3677;
   // $FF: renamed from: Vj long
   long field_3678;
   // $FF: renamed from: Vk boolean
   boolean field_3679;
   // $FF: renamed from: Vl int
   int field_3680;
   // $FF: renamed from: Vm float
   float field_3681;
   int mPriority;
   // $FF: renamed from: xJ int
   private final int field_3682;

   public LocationRequest() {
      this.field_3682 = 1;
      this.mPriority = 102;
      this.field_3677 = 3600000L;
      this.field_3678 = 600000L;
      this.field_3679 = false;
      this.field_3676 = Long.MAX_VALUE;
      this.field_3680 = Integer.MAX_VALUE;
      this.field_3681 = 0.0F;
   }

   LocationRequest(int var1, int var2, long var3, long var5, boolean var7, long var8, int var10, float var11) {
      this.field_3682 = var1;
      this.mPriority = var2;
      this.field_3677 = var3;
      this.field_3678 = var5;
      this.field_3679 = var7;
      this.field_3676 = var8;
      this.field_3680 = var10;
      this.field_3681 = var11;
   }

   // $FF: renamed from: a (float) void
   private static void method_4010(float var0) {
      if(var0 < 0.0F) {
         throw new IllegalArgumentException("invalid displacement: " + var0);
      }
   }

   // $FF: renamed from: cG (int) void
   private static void method_4011(int var0) {
      switch(var0) {
      case 100:
      case 102:
      case 104:
      case 105:
         return;
      case 101:
      case 103:
      default:
         throw new IllegalArgumentException("invalid quality: " + var0);
      }
   }

   // $FF: renamed from: cH (int) java.lang.String
   public static String method_4012(int var0) {
      switch(var0) {
      case 100:
         return "PRIORITY_HIGH_ACCURACY";
      case 101:
      case 103:
      default:
         return "???";
      case 102:
         return "PRIORITY_BALANCED_POWER_ACCURACY";
      case 104:
         return "PRIORITY_LOW_POWER";
      case 105:
         return "PRIORITY_NO_POWER";
      }
   }

   public static LocationRequest create() {
      return new LocationRequest();
   }

   // $FF: renamed from: v (long) void
   private static void method_4013(long var0) {
      if(var0 < 0L) {
         throw new IllegalArgumentException("invalid interval: " + var0);
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LocationRequest)) {
            return false;
         }

         LocationRequest var2 = (LocationRequest)var1;
         if(this.mPriority != var2.mPriority || this.field_3677 != var2.field_3677 || this.field_3678 != var2.field_3678 || this.field_3679 != var2.field_3679 || this.field_3676 != var2.field_3676 || this.field_3680 != var2.field_3680 || this.field_3681 != var2.field_3681) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.field_3676;
   }

   public long getFastestInterval() {
      return this.field_3678;
   }

   public long getInterval() {
      return this.field_3677;
   }

   public int getNumUpdates() {
      return this.field_3680;
   }

   public int getPriority() {
      return this.mPriority;
   }

   public float getSmallestDisplacement() {
      return this.field_3681;
   }

   int getVersionCode() {
      return this.field_3682;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.field_3677), Long.valueOf(this.field_3678), Boolean.valueOf(this.field_3679), Long.valueOf(this.field_3676), Integer.valueOf(this.field_3680), Float.valueOf(this.field_3681)};
      return class_349.hashCode(var1);
   }

   public LocationRequest setExpirationDuration(long var1) {
      long var3 = SystemClock.elapsedRealtime();
      if(var1 > Long.MAX_VALUE - var3) {
         this.field_3676 = Long.MAX_VALUE;
      } else {
         this.field_3676 = var3 + var1;
      }

      if(this.field_3676 < 0L) {
         this.field_3676 = 0L;
      }

      return this;
   }

   public LocationRequest setExpirationTime(long var1) {
      this.field_3676 = var1;
      if(this.field_3676 < 0L) {
         this.field_3676 = 0L;
      }

      return this;
   }

   public LocationRequest setFastestInterval(long var1) {
      method_4013(var1);
      this.field_3679 = true;
      this.field_3678 = var1;
      return this;
   }

   public LocationRequest setInterval(long var1) {
      method_4013(var1);
      this.field_3677 = var1;
      if(!this.field_3679) {
         this.field_3678 = (long)((double)this.field_3677 / 6.0D);
      }

      return this;
   }

   public LocationRequest setNumUpdates(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("invalid numUpdates: " + var1);
      } else {
         this.field_3680 = var1;
         return this;
      }
   }

   public LocationRequest setPriority(int var1) {
      method_4011(var1);
      this.mPriority = var1;
      return this;
   }

   public LocationRequest setSmallestDisplacement(float var1) {
      method_4010(var1);
      this.field_3681 = var1;
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Request[").append(method_4012(this.mPriority));
      if(this.mPriority != 105) {
         var1.append(" requested=");
         var1.append(this.field_3677 + "ms");
      }

      var1.append(" fastest=");
      var1.append(this.field_3678 + "ms");
      if(this.field_3676 != Long.MAX_VALUE) {
         long var7 = this.field_3676 - SystemClock.elapsedRealtime();
         var1.append(" expireIn=");
         var1.append(var7 + "ms");
      }

      if(this.field_3680 != Integer.MAX_VALUE) {
         var1.append(" num=").append(this.field_3680);
      }

      var1.append(']');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      LocationRequestCreator.method_3335(this, var1, var2);
   }
}
