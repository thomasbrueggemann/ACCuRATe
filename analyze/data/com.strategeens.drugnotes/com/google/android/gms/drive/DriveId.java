package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_681;
import com.google.android.gms.drive.internal.class_265;
import com.google.android.gms.drive.internal.class_302;
import com.google.android.gms.internal.class_300;
import com.google.android.gms.internal.class_335;
import com.google.android.gms.internal.class_833;

public class DriveId implements SafeParcelable {
   public static final Creator<DriveId> CREATOR = new class_681();
   // $FF: renamed from: CK int
   final int field_1923;
   // $FF: renamed from: Ot java.lang.String
   final String field_1924;
   // $FF: renamed from: Ou long
   final long field_1925;
   // $FF: renamed from: Ov long
   final long field_1926;
   // $FF: renamed from: Ow java.lang.String
   private volatile String field_1927;

   DriveId(int var1, String var2, long var3, long var5) {
      this.field_1927 = null;
      this.field_1923 = var1;
      this.field_1924 = var2;
      boolean var7;
      if(!"".equals(var2)) {
         var7 = true;
      } else {
         var7 = false;
      }

      boolean var8;
      label15: {
         class_335.method_2301(var7);
         if(var2 == null) {
            long var10;
            int var9 = (var10 = var3 - -1L) == 0L?0:(var10 < 0L?-1:1);
            var8 = false;
            if(var9 == 0) {
               break label15;
            }
         }

         var8 = true;
      }

      class_335.method_2301(var8);
      this.field_1925 = var3;
      this.field_1926 = var5;
   }

   public DriveId(String var1, long var2, long var4) {
      this(1, var1, var2, var4);
   }

   // $FF: renamed from: bi (java.lang.String) com.google.android.gms.drive.DriveId
   public static DriveId method_3218(String var0) {
      class_335.method_2311(var0);
      return new DriveId(var0, -1L, -1L);
   }

   public static DriveId decodeFromString(String var0) {
      class_335.method_2308(var0.startsWith("DriveId:"), "Invalid DriveId: " + var0);
      return method_3219(Base64.decode(var0.substring("DriveId:".length()), 10));
   }

   // $FF: renamed from: f (byte[]) com.google.android.gms.drive.DriveId
   static DriveId method_3219(byte[] var0) {
      class_302 var2;
      try {
         var2 = class_302.method_2100(var0);
      } catch (class_833 var4) {
         throw new IllegalArgumentException();
      }

      String var3;
      if("".equals(var2.field_661)) {
         var3 = null;
      } else {
         var3 = var2.field_661;
      }

      return new DriveId(var2.versionCode, var3, var2.field_662, var2.field_663);
   }

   public int describeContents() {
      return 0;
   }

   public final String encodeToString() {
      if(this.field_1927 == null) {
         String var1 = Base64.encodeToString(this.method_3220(), 10);
         this.field_1927 = "DriveId:" + var1;
      }

      return this.field_1927;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof DriveId) {
         DriveId var2 = (DriveId)var1;
         if(var2.field_1926 != this.field_1926) {
            class_265.method_1703("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
         }

         if(var2.field_1925 == -1L && this.field_1925 == -1L) {
            return var2.field_1924.equals(this.field_1924);
         }

         if(var2.field_1925 == this.field_1925) {
            return true;
         }
      }

      return false;
   }

   public String getResourceId() {
      return this.field_1924;
   }

   public int hashCode() {
      return this.field_1925 == -1L?this.field_1924.hashCode():(this.field_1926 + String.valueOf(this.field_1925)).hashCode();
   }

   // $FF: renamed from: iu () byte[]
   final byte[] method_3220() {
      class_302 var1 = new class_302();
      var1.versionCode = this.field_1923;
      String var2;
      if(this.field_1924 == null) {
         var2 = "";
      } else {
         var2 = this.field_1924;
      }

      var1.field_661 = var2;
      var1.field_662 = this.field_1925;
      var1.field_663 = this.field_1926;
      return class_300.method_2088(var1);
   }

   public String toString() {
      return this.encodeToString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_681.method_3859(this, var1, var2);
   }
}
