package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.internal.zzo;
import java.util.Locale;

public class ParcelableGeofence implements SafeParcelable {
   public static final zzo CREATOR = new zzo();
   private final int mVersionCode;
   private final String zzEY;
   private final int zzaNC;
   private final short zzaNE;
   private final double zzaNF;
   private final double zzaNG;
   private final float zzaNH;
   private final int zzaNI;
   private final int zzaNJ;
   private final long zzaOZ;

   public ParcelableGeofence(int var1, String var2, int var3, short var4, double var5, double var7, float var9, long var10, int var12, int var13) {
      zzek(var2);
      zze(var9);
      zza(var5, var7);
      int var14 = zzhF(var3);
      this.mVersionCode = var1;
      this.zzaNE = var4;
      this.zzEY = var2;
      this.zzaNF = var5;
      this.zzaNG = var7;
      this.zzaNH = var9;
      this.zzaOZ = var10;
      this.zzaNC = var14;
      this.zzaNI = var12;
      this.zzaNJ = var13;
   }

   private static void zza(double var0, double var2) {
      if(var0 <= 90.0D && var0 >= -90.0D) {
         if(var2 > 180.0D || var2 < -180.0D) {
            throw new IllegalArgumentException("invalid longitude: " + var2);
         }
      } else {
         throw new IllegalArgumentException("invalid latitude: " + var0);
      }
   }

   private static void zze(float var0) {
      if(var0 <= 0.0F) {
         throw new IllegalArgumentException("invalid radius: " + var0);
      }
   }

   private static void zzek(String var0) {
      if(var0 == null || var0.length() > 100) {
         throw new IllegalArgumentException("requestId is null or too long: " + var0);
      }
   }

   private static int zzhF(int var0) {
      int var1 = var0 & 7;
      if(var1 == 0) {
         throw new IllegalArgumentException("No supported transition specified: " + var0);
      } else {
         return var1;
      }
   }

   @SuppressLint({"DefaultLocale"})
   private static String zzhG(int var0) {
      switch(var0) {
      case 1:
         return "CIRCLE";
      default:
         return null;
      }
   }

   public int describeContents() {
      zzo var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(!(var1 instanceof ParcelableGeofence)) {
            return false;
         }

         ParcelableGeofence var2 = (ParcelableGeofence)var1;
         if(this.zzaNH != var2.zzaNH) {
            return false;
         }

         if(this.zzaNF != var2.zzaNF) {
            return false;
         }

         if(this.zzaNG != var2.zzaNG) {
            return false;
         }

         if(this.zzaNE != var2.zzaNE) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.zzaOZ;
   }

   public double getLatitude() {
      return this.zzaNF;
   }

   public double getLongitude() {
      return this.zzaNG;
   }

   public int getNotificationResponsiveness() {
      return this.zzaNI;
   }

   public String getRequestId() {
      return this.zzEY;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.zzaNF);
      int var3 = 31 + (int)(var1 ^ var1 >>> 32);
      long var4 = Double.doubleToLongBits(this.zzaNG);
      return 31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.zzaNH)) + this.zzaNE) + this.zzaNC;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{zzhG(this.zzaNE), this.zzEY, Integer.valueOf(this.zzaNC), Double.valueOf(this.zzaNF), Double.valueOf(this.zzaNG), Float.valueOf(this.zzaNH), Integer.valueOf(this.zzaNI / 1000), Integer.valueOf(this.zzaNJ), Long.valueOf(this.zzaOZ)};
      return String.format(var1, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo var10000 = CREATOR;
      zzo.zza(this, var1, var2);
   }

   public short zzyT() {
      return this.zzaNE;
   }

   public float zzyU() {
      return this.zzaNH;
   }

   public int zzyV() {
      return this.zzaNC;
   }

   public int zzyW() {
      return this.zzaNJ;
   }
}
