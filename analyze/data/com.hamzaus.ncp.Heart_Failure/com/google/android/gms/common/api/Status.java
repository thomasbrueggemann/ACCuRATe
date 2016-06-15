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
import com.google.android.gms.internal.class_349;

public final class Status implements Result, SafeParcelable {
   public static final StatusCreator CREATOR = new StatusCreator();
   // $FF: renamed from: Ek com.google.android.gms.common.api.Status
   public static final Status field_3880 = new Status(0);
   // $FF: renamed from: El com.google.android.gms.common.api.Status
   public static final Status field_3881 = new Status(14);
   // $FF: renamed from: Em com.google.android.gms.common.api.Status
   public static final Status field_3882 = new Status(8);
   // $FF: renamed from: En com.google.android.gms.common.api.Status
   public static final Status field_3883 = new Status(15);
   // $FF: renamed from: Eo com.google.android.gms.common.api.Status
   public static final Status field_3884 = new Status(16);
   // $FF: renamed from: CQ int
   private final int field_3885;
   // $FF: renamed from: Ep java.lang.String
   private final String field_3886;
   private final PendingIntent mPendingIntent;
   // $FF: renamed from: xJ int
   private final int field_3887;

   public Status(int var1) {
      this(1, var1, (String)null, (PendingIntent)null);
   }

   Status(int var1, int var2, String var3, PendingIntent var4) {
      this.field_3887 = var1;
      this.field_3885 = var2;
      this.field_3886 = var3;
      this.mPendingIntent = var4;
   }

   public Status(int var1, String var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   // $FF: renamed from: es () java.lang.String
   private String method_4119() {
      return this.field_3886 != null?this.field_3886:CommonStatusCodes.getStatusCodeString(this.field_3885);
   }

   public int describeContents() {
      return 0;
   }

   // $FF: renamed from: eL () android.app.PendingIntent
   PendingIntent method_4120() {
      return this.mPendingIntent;
   }

   // $FF: renamed from: eM () com.google.android.gms.common.ConnectionResult
   @Deprecated
   public ConnectionResult method_4121() {
      return new ConnectionResult(this.field_3885, this.mPendingIntent);
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Status) {
         Status var2 = (Status)var1;
         if(this.field_3887 == var2.field_3887 && this.field_3885 == var2.field_3885 && class_349.equal(this.field_3886, var2.field_3886) && class_349.equal(this.mPendingIntent, var2.mPendingIntent)) {
            return true;
         }
      }

      return false;
   }

   public PendingIntent getResolution() {
      return this.mPendingIntent;
   }

   public Status getStatus() {
      return this;
   }

   public int getStatusCode() {
      return this.field_3885;
   }

   public String getStatusMessage() {
      return this.field_3886;
   }

   int getVersionCode() {
      return this.field_3887;
   }

   public boolean hasResolution() {
      return this.mPendingIntent != null;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.field_3887), Integer.valueOf(this.field_3885), this.field_3886, this.mPendingIntent};
      return class_349.hashCode(var1);
   }

   public boolean isCanceled() {
      return this.field_3885 == 16;
   }

   public boolean isInterrupted() {
      return this.field_3885 == 14;
   }

   public boolean isSuccess() {
      return this.field_3885 <= 0;
   }

   public void startResolutionForResult(Activity var1, int var2) throws SendIntentException {
      if(this.hasResolution()) {
         var1.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), var2, (Intent)null, 0, 0, 0);
      }
   }

   public String toString() {
      return class_349.method_2174(this).method_4301("statusCode", this.method_4119()).method_4301("resolution", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      StatusCreator.method_3424(this, var1, var2);
   }
}
