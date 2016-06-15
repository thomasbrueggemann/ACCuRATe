package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_758;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.nn
public class class_757 implements SafeParcelable, Geofence {
   public static final class_758 CREATOR = new class_758();
   // $FF: renamed from: CK int
   private final int field_3417;
   // $FF: renamed from: Zt java.lang.String
   private final String field_3418;
   private final int agd;
   private final short agf;
   private final double agg;
   private final double agh;
   private final float agi;
   private final int agj;
   private final int agk;
   private final long ahl;

   public class_757(int var1, String var2, int var3, short var4, double var5, double var7, float var9, long var10, int var12, int var13) {
      method_4342(var2);
      method_4341(var9);
      method_4340(var5, var7);
      int var14 = method_4343(var3);
      this.field_3417 = var1;
      this.agf = var4;
      this.field_3418 = var2;
      this.agg = var5;
      this.agh = var7;
      this.agi = var9;
      this.ahl = var10;
      this.agd = var14;
      this.agj = var12;
      this.agk = var13;
   }

   public class_757(String var1, int var2, short var3, double var4, double var6, float var8, long var9, int var11, int var12) {
      this(1, var1, var2, var3, var4, var6, var8, var9, var11, var12);
   }

   // $FF: renamed from: a (double, double) void
   private static void method_4340(double var0, double var2) {
      if(var0 <= 90.0D && var0 >= -90.0D) {
         if(var2 > 180.0D || var2 < -180.0D) {
            throw new IllegalArgumentException("invalid longitude: " + var2);
         }
      } else {
         throw new IllegalArgumentException("invalid latitude: " + var0);
      }
   }

   // $FF: renamed from: b (float) void
   private static void method_4341(float var0) {
      if(var0 <= 0.0F) {
         throw new IllegalArgumentException("invalid radius: " + var0);
      }
   }

   // $FF: renamed from: cb (java.lang.String) void
   private static void method_4342(String var0) {
      if(var0 == null || var0.length() > 100) {
         throw new IllegalArgumentException("requestId is null or too long: " + var0);
      }
   }

   // $FF: renamed from: eH (int) int
   private static int method_4343(int var0) {
      int var1 = var0 & 7;
      if(var1 == 0) {
         throw new IllegalArgumentException("No supported transition specified: " + var0);
      } else {
         return var1;
      }
   }

   // $FF: renamed from: eI (int) java.lang.String
   private static String method_4344(int var0) {
      switch(var0) {
      case 1:
         return "CIRCLE";
      default:
         return null;
      }
   }

   // $FF: renamed from: h (byte[]) com.google.android.gms.internal.nn
   public static class_757 method_4345(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      class_757 var2 = CREATOR.method_4351(var1);
      var1.recycle();
      return var2;
   }

   public int describeContents() {
      class_758 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(!(var1 instanceof class_757)) {
            return false;
         }

         class_757 var2 = (class_757)var1;
         if(this.agi != var2.agi) {
            return false;
         }

         if(this.agg != var2.agg) {
            return false;
         }

         if(this.agh != var2.agh) {
            return false;
         }

         if(this.agf != var2.agf) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.ahl;
   }

   public double getLatitude() {
      return this.agg;
   }

   public double getLongitude() {
      return this.agh;
   }

   public int getNotificationResponsiveness() {
      return this.agj;
   }

   public String getRequestId() {
      return this.field_3418;
   }

   public int getVersionCode() {
      return this.field_3417;
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.agg);
      int var3 = 31 + (int)(var1 ^ var1 >>> 32);
      long var4 = Double.doubleToLongBits(this.agh);
      return 31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.agi)) + this.agf) + this.agd;
   }

   // $FF: renamed from: nn () short
   public short method_4346() {
      return this.agf;
   }

   // $FF: renamed from: no () float
   public float method_4347() {
      return this.agi;
   }

   // $FF: renamed from: np () int
   public int method_4348() {
      return this.agd;
   }

   // $FF: renamed from: nq () int
   public int method_4349() {
      return this.agk;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{method_4344(this.agf), this.field_3418, Integer.valueOf(this.agd), Double.valueOf(this.agg), Double.valueOf(this.agh), Float.valueOf(this.agi), Integer.valueOf(this.agj / 1000), Integer.valueOf(this.agk), Long.valueOf(this.ahl)};
      return String.format(var1, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_758 var10000 = CREATOR;
      class_758.method_4350(this, var1, var2);
   }
}
