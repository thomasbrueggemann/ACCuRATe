package com.google.android.gms.auth.api.proxy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.proxy.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyGrpcRequest implements SafeParcelable {
   public static final Creator<ProxyGrpcRequest> CREATOR = new zza();
   public final byte[] body;
   public final String hostname;
   public final String method;
   public final int port;
   public final long timeoutMillis;
   final int versionCode;

   ProxyGrpcRequest(int var1, String var2, int var3, long var4, byte[] var6, String var7) {
      this.versionCode = var1;
      this.hostname = var2;
      this.port = var3;
      this.timeoutMillis = var4;
      this.body = var6;
      this.method = var7;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
