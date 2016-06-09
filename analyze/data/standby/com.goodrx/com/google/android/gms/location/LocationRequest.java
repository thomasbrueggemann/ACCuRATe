package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.LocationRequestCreator;

public final class LocationRequest implements SafeParcelable {
   public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
   int mPriority;
   private final int mVersionCode;
   boolean zzaBr;
   long zzaND;
   long zzaNY;
   long zzaNZ;
   int zzaOa;
   float zzaOb;
   long zzaOc;

   public LocationRequest() {
      this.mVersionCode = 1;
      this.mPriority = 102;
      this.zzaNY = 3600000L;
      this.zzaNZ = 600000L;
      this.zzaBr = false;
      this.zzaND = Long.MAX_VALUE;
      this.zzaOa = Integer.MAX_VALUE;
      this.zzaOb = 0.0F;
      this.zzaOc = 0L;
   }

   LocationRequest(int var1, int var2, long var3, long var5, boolean var7, long var8, int var10, float var11, long var12) {
      this.mVersionCode = var1;
      this.mPriority = var2;
      this.zzaNY = var3;
      this.zzaNZ = var5;
      this.zzaBr = var7;
      this.zzaND = var8;
      this.zzaOa = var10;
      this.zzaOb = var11;
      this.zzaOc = var12;
   }

   private static void zzL(long var0) {
      if(var0 < 0L) {
         throw new IllegalArgumentException("invalid interval: " + var0);
      }
   }

   private static void zzhs(int var0) {
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

   public static String zzht(int var0) {
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

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LocationRequest)) {
            return false;
         }

         LocationRequest var2 = (LocationRequest)var1;
         if(this.mPriority != var2.mPriority || this.zzaNY != var2.zzaNY || this.zzaNZ != var2.zzaNZ || this.zzaBr != var2.zzaBr || this.zzaND != var2.zzaND || this.zzaOa != var2.zzaOa || this.zzaOb != var2.zzaOb) {
            return false;
         }
      }

      return true;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.zzaNY), Long.valueOf(this.zzaNZ), Boolean.valueOf(this.zzaBr), Long.valueOf(this.zzaND), Integer.valueOf(this.zzaOa), Float.valueOf(this.zzaOb)};
      return zzw.hashCode(var1);
   }

   public LocationRequest setFastestInterval(long var1) {
      zzL(var1);
      this.zzaBr = true;
      this.zzaNZ = var1;
      return this;
   }

   public LocationRequest setInterval(long var1) {
      zzL(var1);
      this.zzaNY = var1;
      if(!this.zzaBr) {
         this.zzaNZ = (long)((double)this.zzaNY / 6.0D);
      }

      return this;
   }

   public LocationRequest setNumUpdates(int var1) {
      if(var1 <= 0) {
         throw new IllegalArgumentException("invalid numUpdates: " + var1);
      } else {
         this.zzaOa = var1;
         return this;
      }
   }

   public LocationRequest setPriority(int var1) {
      zzhs(var1);
      this.mPriority = var1;
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Request[").append(zzht(this.mPriority));
      if(this.mPriority != 105) {
         var1.append(" requested=");
         var1.append(this.zzaNY).append("ms");
      }

      var1.append(" fastest=");
      var1.append(this.zzaNZ).append("ms");
      if(this.zzaOc > this.zzaNY) {
         var1.append(" maxWait=");
         var1.append(this.zzaOc).append("ms");
      }

      if(this.zzaND != Long.MAX_VALUE) {
         long var7 = this.zzaND - SystemClock.elapsedRealtime();
         var1.append(" expireIn=");
         var1.append(var7).append("ms");
      }

      if(this.zzaOa != Integer.MAX_VALUE) {
         var1.append(" num=").append(this.zzaOa);
      }

      var1.append(']');
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      LocationRequestCreator.zza(this, var1, var2);
   }
}
