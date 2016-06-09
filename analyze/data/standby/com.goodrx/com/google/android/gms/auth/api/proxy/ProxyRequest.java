package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.zzb;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
   public static final Creator<ProxyRequest> CREATOR = new zzb();
   public static final int HTTP_METHOD_DELETE = 3;
   public static final int HTTP_METHOD_GET = 0;
   public static final int HTTP_METHOD_HEAD = 4;
   public static final int HTTP_METHOD_OPTIONS = 5;
   public static final int HTTP_METHOD_PATCH = 7;
   public static final int HTTP_METHOD_POST = 1;
   public static final int HTTP_METHOD_PUT = 2;
   public static final int HTTP_METHOD_TRACE = 6;
   public static final int LAST_CODE = 7;
   public final byte[] body;
   public final int httpMethod;
   public final long timeoutMillis;
   public final String url;
   final int versionCode;
   Bundle zzWB;

   ProxyRequest(int var1, String var2, int var3, long var4, byte[] var6, Bundle var7) {
      this.versionCode = var1;
      this.url = var2;
      this.httpMethod = var3;
      this.timeoutMillis = var4;
      this.body = var6;
      this.zzWB = var7;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return "ProxyRequest[ url: " + this.url + ", method: " + this.httpMethod + " ]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
