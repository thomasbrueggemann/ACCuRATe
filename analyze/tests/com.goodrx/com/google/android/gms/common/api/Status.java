package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class Status implements Result, SafeParcelable {
   public static final Creator<Status> CREATOR = new zzc();
   public static final Status zzagC = new Status(0);
   public static final Status zzagD = new Status(14);
   public static final Status zzagE = new Status(8);
   public static final Status zzagF = new Status(15);
   public static final Status zzagG = new Status(16);
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final int zzade;
   private final String zzafC;

   public Status(int var1) {
      this(var1, (String)null);
   }

   Status(int var1, int var2, String var3, PendingIntent var4) {
      this.mVersionCode = var1;
      this.zzade = var2;
      this.zzafC = var3;
      this.mPendingIntent = var4;
   }

   public Status(int var1, String var2) {
      this(1, var1, var2, (PendingIntent)null);
   }

   public Status(int var1, String var2, PendingIntent var3) {
      this(1, var1, var2, var3);
   }

   private String zzpd() {
      return this.zzafC != null?this.zzafC:CommonStatusCodes.getStatusCodeString(this.zzade);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Status) {
         Status var2 = (Status)var1;
         if(this.mVersionCode == var2.mVersionCode && this.zzade == var2.zzade && zzw.equal(this.zzafC, var2.zzafC) && zzw.equal(this.mPendingIntent, var2.mPendingIntent)) {
            return true;
         }
      }

      return false;
   }

   public Status getStatus() {
      return this;
   }

   public int getStatusCode() {
      return this.zzade;
   }

   public String getStatusMessage() {
      return this.zzafC;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzade), this.zzafC, this.mPendingIntent};
      return zzw.hashCode(var1);
   }

   public boolean isSuccess() {
      return this.zzade <= 0;
   }

   public String toString() {
      return zzw.zzy(this).zzg("statusCode", this.zzpd()).zzg("resolution", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   PendingIntent zzpc() {
      return this.mPendingIntent;
   }
}
