package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_313;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

// $FF: renamed from: com.google.android.gms.internal.ji
public class class_314 implements SafeParcelable, Geofence {
   public static final class_313 CREATOR = new class_313();
   // $FF: renamed from: Oy java.lang.String
   private final String field_1269;
   // $FF: renamed from: UX int
   private final int field_1270;
   // $FF: renamed from: UZ short
   private final short field_1271;
   // $FF: renamed from: VW long
   private final long field_1272;
   // $FF: renamed from: Va double
   private final double field_1273;
   // $FF: renamed from: Vb double
   private final double field_1274;
   // $FF: renamed from: Vc float
   private final float field_1275;
   // $FF: renamed from: Vd int
   private final int field_1276;
   // $FF: renamed from: Ve int
   private final int field_1277;
   // $FF: renamed from: xJ int
   private final int field_1278;

   public class_314(int var1, String var2, int var3, short var4, double var5, double var7, float var9, long var10, int var12, int var13) {
      method_2034(var2);
      method_2033(var9);
      method_2032(var5, var7);
      int var14 = method_2035(var3);
      this.field_1278 = var1;
      this.field_1271 = var4;
      this.field_1269 = var2;
      this.field_1273 = var5;
      this.field_1274 = var7;
      this.field_1275 = var9;
      this.field_1272 = var10;
      this.field_1270 = var14;
      this.field_1276 = var12;
      this.field_1277 = var13;
   }

   public class_314(String var1, int var2, short var3, double var4, double var6, float var8, long var9, int var11, int var12) {
      this(1, var1, var2, var3, var4, var6, var8, var9, var11, var12);
   }

   // $FF: renamed from: a (double, double) void
   private static void method_2032(double var0, double var2) {
      if(var0 <= 90.0D && var0 >= -90.0D) {
         if(var2 > 180.0D || var2 < -180.0D) {
            throw new IllegalArgumentException("invalid longitude: " + var2);
         }
      } else {
         throw new IllegalArgumentException("invalid latitude: " + var0);
      }
   }

   // $FF: renamed from: b (float) void
   private static void method_2033(float var0) {
      if(var0 <= 0.0F) {
         throw new IllegalArgumentException("invalid radius: " + var0);
      }
   }

   // $FF: renamed from: bq (java.lang.String) void
   private static void method_2034(String var0) {
      if(var0 == null || var0.length() > 100) {
         throw new IllegalArgumentException("requestId is null or too long: " + var0);
      }
   }

   // $FF: renamed from: cM (int) int
   private static int method_2035(int var0) {
      int var1 = var0 & 7;
      if(var1 == 0) {
         throw new IllegalArgumentException("No supported transition specified: " + var0);
      } else {
         return var1;
      }
   }

   // $FF: renamed from: cN (int) java.lang.String
   private static String method_2036(int var0) {
      switch(var0) {
      case 1:
         return "CIRCLE";
      default:
         return null;
      }
   }

   // $FF: renamed from: h (byte[]) com.google.android.gms.internal.ji
   public static class_314 method_2037(byte[] var0) {
      Parcel var1 = Parcel.obtain();
      var1.unmarshall(var0, 0, var0.length);
      var1.setDataPosition(0);
      class_314 var2 = CREATOR.method_2030(var1);
      var1.recycle();
      return var2;
   }

   public int describeContents() {
      class_313 var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(!(var1 instanceof class_314)) {
            return false;
         }

         class_314 var2 = (class_314)var1;
         if(this.field_1275 != var2.field_1275) {
            return false;
         }

         if(this.field_1273 != var2.field_1273) {
            return false;
         }

         if(this.field_1274 != var2.field_1274) {
            return false;
         }

         if(this.field_1271 != var2.field_1271) {
            return false;
         }
      }

      return true;
   }

   public long getExpirationTime() {
      return this.field_1272;
   }

   public double getLatitude() {
      return this.field_1273;
   }

   public double getLongitude() {
      return this.field_1274;
   }

   public int getNotificationResponsiveness() {
      return this.field_1276;
   }

   public String getRequestId() {
      return this.field_1269;
   }

   public int getVersionCode() {
      return this.field_1278;
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.field_1273);
      int var3 = 31 + (int)(var1 ^ var1 >>> 32);
      long var4 = Double.doubleToLongBits(this.field_1274);
      return 31 * (31 * (31 * (var3 * 31 + (int)(var4 ^ var4 >>> 32)) + Float.floatToIntBits(this.field_1275)) + this.field_1271) + this.field_1270;
   }

   // $FF: renamed from: iV () short
   public short method_2038() {
      return this.field_1271;
   }

   // $FF: renamed from: iW () float
   public float method_2039() {
      return this.field_1275;
   }

   // $FF: renamed from: iX () int
   public int method_2040() {
      return this.field_1270;
   }

   // $FF: renamed from: iY () int
   public int method_2041() {
      return this.field_1277;
   }

   public String toString() {
      Locale var1 = Locale.US;
      Object[] var2 = new Object[]{method_2036(this.field_1271), this.field_1269, Integer.valueOf(this.field_1270), Double.valueOf(this.field_1273), Double.valueOf(this.field_1274), Float.valueOf(this.field_1275), Integer.valueOf(this.field_1276 / 1000), Integer.valueOf(this.field_1277), Long.valueOf(this.field_1272)};
      return String.format(var1, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", var2);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_313 var10000 = CREATOR;
      class_313.method_2029(this, var1, var2);
   }
}
