package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.class_580;
import com.google.android.gms.drive.internal.class_248;
import com.google.android.gms.internal.class_246;
import com.google.android.gms.internal.class_347;
import com.google.android.gms.internal.class_637;

public class DriveId implements SafeParcelable {
   public static final Creator<DriveId> CREATOR = new class_580();
   // $FF: renamed from: HK java.lang.String
   final String field_2179;
   // $FF: renamed from: HL long
   final long field_2180;
   // $FF: renamed from: HM long
   final long field_2181;
   // $FF: renamed from: HN java.lang.String
   private volatile String field_2182;
   // $FF: renamed from: xJ int
   final int field_2183;

   DriveId(int var1, String var2, long var3, long var5) {
      this.field_2182 = null;
      this.field_2183 = var1;
      this.field_2179 = var2;
      boolean var7;
      if(!"".equals(var2)) {
         var7 = true;
      } else {
         var7 = false;
      }

      boolean var8;
      label15: {
         class_347.method_2160(var7);
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

      class_347.method_2160(var8);
      this.field_2180 = var3;
      this.field_2181 = var5;
   }

   public DriveId(String var1, long var2, long var4) {
      this(1, var1, var2, var4);
   }

   // $FF: renamed from: aL (java.lang.String) com.google.android.gms.drive.DriveId
   public static DriveId method_2740(String var0) {
      class_347.method_2170(var0);
      return new DriveId(var0, -1L, -1L);
   }

   public static DriveId decodeFromString(String var0) {
      class_347.method_2168(var0.startsWith("DriveId:"), "Invalid DriveId: " + var0);
      return method_2741(Base64.decode(var0.substring("DriveId:".length()), 10));
   }

   // $FF: renamed from: f (byte[]) com.google.android.gms.drive.DriveId
   static DriveId method_2741(byte[] var0) {
      class_248 var2;
      try {
         var2 = class_248.method_1728(var0);
      } catch (class_637 var4) {
         throw new IllegalArgumentException();
      }

      String var3;
      if("".equals(var2.field_816)) {
         var3 = null;
      } else {
         var3 = var2.field_816;
      }

      return new DriveId(var2.versionCode, var3, var2.field_817, var2.field_818);
   }

   public int describeContents() {
      return 0;
   }

   public final String encodeToString() {
      if(this.field_2182 == null) {
         String var1 = Base64.encodeToString(this.method_2742(), 10);
         this.field_2182 = "DriveId:" + var1;
      }

      return this.field_2182;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof DriveId) {
         DriveId var2 = (DriveId)var1;
         if(var2.field_2181 != this.field_2181) {
            Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
         }

         if(var2.field_2180 == -1L && this.field_2180 == -1L) {
            return var2.field_2179.equals(this.field_2179);
         }

         if(var2.field_2180 == this.field_2180) {
            return true;
         }
      }

      return false;
   }

   public String getResourceId() {
      return this.field_2179;
   }

   // $FF: renamed from: gf () byte[]
   final byte[] method_2742() {
      class_248 var1 = new class_248();
      var1.versionCode = this.field_2183;
      String var2;
      if(this.field_2179 == null) {
         var2 = "";
      } else {
         var2 = this.field_2179;
      }

      var1.field_816 = var2;
      var1.field_817 = this.field_2180;
      var1.field_818 = this.field_2181;
      return class_246.method_1720(var1);
   }

   public int hashCode() {
      return this.field_2180 == -1L?this.field_2179.hashCode():(this.field_2181 + String.valueOf(this.field_2180)).hashCode();
   }

   public String toString() {
      return this.encodeToString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_580.method_3255(this, var1, var2);
   }
}
