package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzh;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PutDataRequest implements SafeParcelable {
   public static final Creator<PutDataRequest> CREATOR = new zzh();
   private static final long zzbrf;
   private static final Random zzbrg;
   private final Uri mUri;
   final int mVersionCode;
   private byte[] zzaKm;
   private final Bundle zzbrh;
   private long zzbri;

   static {
      zzbrf = TimeUnit.MINUTES.toMillis(30L);
      zzbrg = new SecureRandom();
   }

   PutDataRequest(int var1, Uri var2, Bundle var3, byte[] var4, long var5) {
      this.mVersionCode = var1;
      this.mUri = var2;
      this.zzbrh = var3;
      this.zzbrh.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
      this.zzaKm = var4;
      this.zzbri = var5;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public Uri getUri() {
      return this.mUri;
   }

   public String toString() {
      return this.toString(Log.isLoggable("DataMap", 3));
   }

   public String toString(boolean var1) {
      StringBuilder var2 = new StringBuilder("PutDataRequest[");
      StringBuilder var3 = (new StringBuilder()).append("dataSz=");
      Object var4;
      if(this.zzaKm == null) {
         var4 = "null";
      } else {
         var4 = Integer.valueOf(this.zzaKm.length);
      }

      var2.append(var3.append(var4).toString());
      var2.append(", numAssets=" + this.zzbrh.size());
      var2.append(", uri=" + this.mUri);
      var2.append(", syncDeadline=" + this.zzbri);
      if(!var1) {
         var2.append("]");
         return var2.toString();
      } else {
         var2.append("]\n  assets: ");
         Iterator var10 = this.zzbrh.keySet().iterator();

         while(var10.hasNext()) {
            String var12 = (String)var10.next();
            var2.append("\n    " + var12 + ": " + this.zzbrh.getParcelable(var12));
         }

         var2.append("\n  ]");
         return var2.toString();
      }
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public Bundle zzIv() {
      return this.zzbrh;
   }

   public long zzIw() {
      return this.zzbri;
   }
}
