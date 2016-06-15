package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Parcel;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.class_1040;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_780;

public final class Device implements SafeParcelable {
   public static final Creator<Device> CREATOR = new class_1040();
   public static final int TYPE_CHEST_STRAP = 4;
   public static final int TYPE_PHONE = 1;
   public static final int TYPE_SCALE = 5;
   public static final int TYPE_TABLET = 2;
   public static final int TYPE_UNKNOWN = 0;
   public static final int TYPE_WATCH = 3;
   // $FF: renamed from: CK int
   private final int field_1194;
   // $FF: renamed from: Gt int
   private final int field_1195;
   // $FF: renamed from: TU java.lang.String
   private final String field_1196;
   // $FF: renamed from: Uw java.lang.String
   private final String field_1197;
   // $FF: renamed from: Ux java.lang.String
   private final String field_1198;
   // $FF: renamed from: Uy java.lang.String
   private final String field_1199;
   // $FF: renamed from: Uz int
   private final int field_1200;

   Device(int var1, String var2, String var3, String var4, String var5, int var6, int var7) {
      this.field_1194 = var1;
      this.field_1197 = (String)class_335.method_2311(var2);
      this.field_1198 = (String)class_335.method_2311(var3);
      this.field_1196 = "";
      this.field_1199 = (String)class_335.method_2311(var5);
      this.field_1195 = var6;
      this.field_1200 = var7;
   }

   public Device(String var1, String var2, String var3, int var4) {
      this(var1, var2, "", var3, var4, 0);
   }

   public Device(String var1, String var2, String var3, String var4, int var5) {
      this(var1, var2, var4, var5);
   }

   public Device(String var1, String var2, String var3, String var4, int var5, int var6) {
      this(1, var1, var2, "", var4, var5, var6);
   }

   // $FF: renamed from: M (android.content.Context) java.lang.String
   private static String method_2641(Context var0) {
      return Secure.getString(var0.getContentResolver(), "android_id");
   }

   // $FF: renamed from: N (android.content.Context) int
   private static int method_2642(Context var0) {
      int var1 = method_2644(var0);
      byte var2 = 0;
      switch(var1) {
      case 8:
      case 9:
         break;
      case 10:
         boolean var3 = method_2643(var0);
         var2 = 0;
         if(var3) {
            return 3;
         }
         break;
      default:
         if(!method_2646(var0)) {
            return 2;
         }

         var2 = 1;
      }

      return var2;
   }

   // $FF: renamed from: O (android.content.Context) boolean
   public static boolean method_2643(Context var0) {
      return (15 & var0.getResources().getConfiguration().uiMode) == 6;
   }

   // $FF: renamed from: P (android.content.Context) int
   private static int method_2644(Context var0) {
      return 5 + method_2645(var0) % 1000 / 100;
   }

   // $FF: renamed from: Q (android.content.Context) int
   private static int method_2645(Context var0) {
      try {
         int var3 = var0.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
         return var3;
      } catch (NameNotFoundException var4) {
         Log.w("Fitness", "Could not find package info for Google Play Services");
         return -1;
      }
   }

   // $FF: renamed from: R (android.content.Context) boolean
   private static boolean method_2646(Context var0) {
      return ((TelephonyManager)var0.getSystemService("phone")).getPhoneType() != 0;
   }

   // $FF: renamed from: a (com.google.android.gms.fitness.data.Device) boolean
   private boolean method_2647(Device var1) {
      return class_336.equal(this.field_1197, var1.field_1197) && class_336.equal(this.field_1198, var1.field_1198) && class_336.equal(this.field_1196, var1.field_1196) && class_336.equal(this.field_1199, var1.field_1199) && this.field_1195 == var1.field_1195 && this.field_1200 == var1.field_1200;
   }

   public static Device getLocalDevice(Context var0) {
      int var1 = method_2642(var0);
      String var2 = method_2641(var0);
      return new Device(Build.MANUFACTURER, Build.MODEL, VERSION.RELEASE, var2, var1, 2);
   }

   // $FF: renamed from: jD () boolean
   private boolean method_2648() {
      return this.method_2649() == 1;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof Device && this.method_2647((Device)var1);
   }

   public String getManufacturer() {
      return this.field_1197;
   }

   public String getModel() {
      return this.field_1198;
   }

   String getStreamIdentifier() {
      Object[] var1 = new Object[]{this.field_1197, this.field_1198, this.field_1199};
      return String.format("%s:%s:%s", var1);
   }

   public int getType() {
      return this.field_1195;
   }

   public String getUid() {
      return this.field_1199;
   }

   public String getVersion() {
      return this.field_1196;
   }

   int getVersionCode() {
      return this.field_1194;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.field_1197, this.field_1198, this.field_1196, this.field_1199, Integer.valueOf(this.field_1195)};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: jC () int
   public int method_2649() {
      return this.field_1200;
   }

   // $FF: renamed from: jE () com.google.android.gms.fitness.data.Device
   Device method_2650() {
      return new Device(class_780.method_4401(this.field_1197), class_780.method_4401(this.field_1198), class_780.method_4401(this.field_1196), this.field_1199, this.field_1195);
   }

   // $FF: renamed from: jF () java.lang.String
   public String method_2651() {
      return !class_780.method_4403() && !this.method_2648()?class_780.method_4401(this.field_1199):this.field_1199;
   }

   public String toString() {
      Object[] var1 = new Object[]{this.getStreamIdentifier(), this.field_1196, Integer.valueOf(this.field_1195), Integer.valueOf(this.field_1200)};
      return String.format("Device{%s:%s:%s:%s}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1040.method_5729(this, var1, var2);
   }
}
