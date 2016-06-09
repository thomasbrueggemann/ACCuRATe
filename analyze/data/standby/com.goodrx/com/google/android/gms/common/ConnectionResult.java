package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionResult implements SafeParcelable {
   public static final Creator<ConnectionResult> CREATOR = new zzb();
   public static final ConnectionResult zzafB = new ConnectionResult(0);
   private final PendingIntent mPendingIntent;
   final int mVersionCode;
   private final int zzade;
   private final String zzafC;

   public ConnectionResult(int var1) {
      this(var1, (PendingIntent)null, (String)null);
   }

   ConnectionResult(int var1, int var2, PendingIntent var3, String var4) {
      this.mVersionCode = var1;
      this.zzade = var2;
      this.mPendingIntent = var3;
      this.zzafC = var4;
   }

   public ConnectionResult(int var1, PendingIntent var2) {
      this(var1, var2, (String)null);
   }

   public ConnectionResult(int var1, PendingIntent var2, String var3) {
      this(1, var1, var2, var3);
   }

   static String getStatusString(int var0) {
      switch(var0) {
      case 0:
         return "SUCCESS";
      case 1:
         return "SERVICE_MISSING";
      case 2:
         return "SERVICE_VERSION_UPDATE_REQUIRED";
      case 3:
         return "SERVICE_DISABLED";
      case 4:
         return "SIGN_IN_REQUIRED";
      case 5:
         return "INVALID_ACCOUNT";
      case 6:
         return "RESOLUTION_REQUIRED";
      case 7:
         return "NETWORK_ERROR";
      case 8:
         return "INTERNAL_ERROR";
      case 9:
         return "SERVICE_INVALID";
      case 10:
         return "DEVELOPER_ERROR";
      case 11:
         return "LICENSE_CHECK_FAILED";
      case 12:
      default:
         return "UNKNOWN_ERROR_CODE(" + var0 + ")";
      case 13:
         return "CANCELED";
      case 14:
         return "TIMEOUT";
      case 15:
         return "INTERRUPTED";
      case 16:
         return "API_UNAVAILABLE";
      case 17:
         return "SIGN_IN_FAILED";
      case 18:
         return "SERVICE_UPDATING";
      case 19:
         return "SERVICE_MISSING_PERMISSION";
      case 20:
         return "RESTRICTED_PROFILE";
      }
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ConnectionResult)) {
            return false;
         }

         ConnectionResult var2 = (ConnectionResult)var1;
         if(this.zzade != var2.zzade || !zzw.equal(this.mPendingIntent, var2.mPendingIntent) || !zzw.equal(this.zzafC, var2.zzafC)) {
            return false;
         }
      }

      return true;
   }

   public int getErrorCode() {
      return this.zzade;
   }

   @Nullable
   public String getErrorMessage() {
      return this.zzafC;
   }

   @Nullable
   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public boolean hasResolution() {
      return this.zzade != 0 && this.mPendingIntent != null;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzade), this.mPendingIntent, this.zzafC};
      return zzw.hashCode(var1);
   }

   public boolean isSuccess() {
      return this.zzade == 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return zzw.zzy(this).zzg("statusCode", getStatusString(this.zzade)).zzg("resolution", this.mPendingIntent).zzg("message", this.zzafC).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
