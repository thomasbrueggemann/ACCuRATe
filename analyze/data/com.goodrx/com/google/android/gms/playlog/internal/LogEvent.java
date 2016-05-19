package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.playlog.internal.zzc;
import java.util.Iterator;

public class LogEvent implements SafeParcelable {
   public static final zzc CREATOR = new zzc();
   public final String tag;
   public final int versionCode;
   public final long zzbdA;
   public final long zzbdB;
   public final byte[] zzbdC;
   public final Bundle zzbdD;

   LogEvent(int var1, long var2, long var4, String var6, byte[] var7, Bundle var8) {
      this.versionCode = var1;
      this.zzbdA = var2;
      this.zzbdB = var4;
      this.tag = var6;
      this.zzbdC = var7;
      this.zzbdD = var8;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("tag=").append(this.tag).append(",");
      var1.append("eventTime=").append(this.zzbdA).append(",");
      var1.append("eventUptime=").append(this.zzbdB).append(",");
      if(this.zzbdD != null && !this.zzbdD.isEmpty()) {
         var1.append("keyValues=");
         Iterator var6 = this.zzbdD.keySet().iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var1.append("(").append(var7).append(",");
            var1.append(this.zzbdD.getString(var7)).append(")");
            var1.append(" ");
         }
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
