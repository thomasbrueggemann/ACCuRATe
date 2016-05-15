package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse implements SafeParcelable {
   public static final Creator<ProxyResponse> CREATOR = new zzc();
   public final byte[] body;
   public final int googlePlayServicesStatusCode;
   public final PendingIntent recoveryAction;
   public final int statusCode;
   final int versionCode;
   final Bundle zzWB;

   ProxyResponse(int var1, int var2, PendingIntent var3, int var4, Bundle var5, byte[] var6) {
      this.versionCode = var1;
      this.googlePlayServicesStatusCode = var2;
      this.statusCode = var4;
      this.zzWB = var5;
      this.body = var6;
      this.recoveryAction = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
