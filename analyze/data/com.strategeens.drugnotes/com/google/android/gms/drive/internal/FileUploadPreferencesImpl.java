package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.internal.class_1023;

public final class FileUploadPreferencesImpl implements SafeParcelable, FileUploadPreferences {
   public static final Creator<FileUploadPreferencesImpl> CREATOR = new class_1023();
   // $FF: renamed from: CK int
   final int field_4244;
   // $FF: renamed from: QA int
   int field_4245;
   // $FF: renamed from: QB boolean
   boolean field_4246;
   // $FF: renamed from: Qz int
   int field_4247;

   FileUploadPreferencesImpl(int var1, int var2, int var3, boolean var4) {
      this.field_4244 = var1;
      this.field_4247 = var2;
      this.field_4245 = var3;
      this.field_4246 = var4;
   }

   // $FF: renamed from: by (int) boolean
   public static boolean method_5468(int var0) {
      switch(var0) {
      case 1:
      case 2:
         return true;
      default:
         return false;
      }
   }

   // $FF: renamed from: bz (int) boolean
   public static boolean method_5469(int var0) {
      switch(var0) {
      case 256:
      case 257:
         return true;
      default:
         return false;
      }
   }

   public int describeContents() {
      return 0;
   }

   public int getBatteryUsagePreference() {
      return !method_5469(this.field_4245)?0:this.field_4245;
   }

   public int getNetworkTypePreference() {
      return !method_5468(this.field_4247)?0:this.field_4247;
   }

   public boolean isRoamingAllowed() {
      return this.field_4246;
   }

   public void setBatteryUsagePreference(int var1) {
      if(!method_5469(var1)) {
         throw new IllegalArgumentException("Invalid battery usage preference value.");
      } else {
         this.field_4245 = var1;
      }
   }

   public void setNetworkTypePreference(int var1) {
      if(!method_5468(var1)) {
         throw new IllegalArgumentException("Invalid data connection preference value.");
      } else {
         this.field_4247 = var1;
      }
   }

   public void setRoamingAllowed(boolean var1) {
      this.field_4246 = var1;
   }

   public void writeToParcel(Parcel var1, int var2) {
      class_1023.method_5619(this, var1, var2);
   }
}
