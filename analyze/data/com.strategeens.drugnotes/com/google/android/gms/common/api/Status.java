package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.class_336;

public final class Status implements Result, SafeParcelable {
   public static final StatusCreator CREATOR = new StatusCreator();
   // $FF: renamed from: KA com.google.android.gms.common.api.Status
   public static final Status field_3959 = new Status(16);
   // $FF: renamed from: Kw com.google.android.gms.common.api.Status
   public static final Status field_3960 = new Status(0);
   // $FF: renamed from: Kx com.google.android.gms.common.api.Status
   public static final Status field_3961 = new Status(14);
   // $FF: renamed from: Ky com.google.android.gms.common.api.Status
   public static final Status field_3962 = new Status(8);
   // $FF: renamed from: Kz com.google.android.gms.common.api.Status
   public static final Status field_3963 = new Status(15);
   // $FF: renamed from: CK int
   private final int field_3964;
   // $FF: renamed from: Iv int
   private final int field_3965;
   // $FF: renamed from: KB java.lang.String
   private final String field_3966;
   private final PendingIntent mPendingIntent;

   public Status(int var1) {
      this(var1, (String)null);
   }

   Status(int var1, int var2, String var3, PendingIntent var4) {
      this.field_3964 = var1;
      this.field_3965 = var2;
      this.field_3966 = var3;
      this.mPendingIntent = var4;
   }

   public Status(int var1, String var2) {
      this(1, var1, var2, (PendingIntent)null);
   }

   public Status(int var1, String var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   // $FF: renamed from: gt () java.lang.String
   private String method_5231() {
      return this.field_3966 != null?this.field_3966:CommonStatusCodes.getStatusCodeString(this.field_3965);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Status) {
         Status var2 = (Status)var1;
         if(this.field_3964 == var2.field_3964 && this.field_3965 == var2.field_3965 && class_336.equal(this.field_3966, var2.field_3966) && class_336.equal(this.mPendingIntent, var2.mPendingIntent)) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: gP () android.app.PendingIntent
   PendingIntent method_5232() {
      return this.mPendingIntent;
   }

   // $FF: renamed from: gQ () com.google.android.gms.common.ConnectionResult
   @Deprecated
   public ConnectionResult method_5233() {
      return new ConnectionResult(this.field_3965, this.mPendingIntent);
   }

   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public Status getStatus() {
      return this;
   }

   public int getStatusCode() {
      return this.field_3965;
   }

   public String getStatusMessage() {
      return this.field_3966;
   }

   int getVersionCode() {
      return this.field_3964;
   }

   public boolean hasResolution() {
      return this.mPendingIntent != null;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3964), Integer.valueOf(this.field_3965), this.field_3966, this.mPendingIntent};
      return class_336.hashCode(var1);
   }

   public boolean isCanceled() {
      return this.field_3965 == 16;
   }

   public boolean isInterrupted() {
      return this.field_3965 == 14;
   }

   public boolean isSuccess() {
      return this.field_3965 <= 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return class_336.method_2312(this).method_3424("statusCode", this.method_5231()).method_3424("resolution", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StatusCreator.method_4095(this, var1, var2);
   }
}
