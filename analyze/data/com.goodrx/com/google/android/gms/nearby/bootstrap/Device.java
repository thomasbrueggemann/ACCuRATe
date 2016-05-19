package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.bootstrap.zzb;

public class Device implements SafeParcelable {
   public static final Creator<Device> CREATOR = new zzb();
   private final String description;
   private final String name;
   final int versionCode;
   private final String zzbaQ;
   private final byte zzbaR;

   Device(int var1, String var2, String var3, String var4, byte var5) {
      this.versionCode = var1;
      this.name = zzx.zzcM(var2);
      this.description = (String)zzx.zzz(var3);
      this.zzbaQ = (String)zzx.zzz(var4);
      boolean var6;
      if(var5 <= 4) {
         var6 = true;
      } else {
         var6 = false;
      }

      zzx.zzb(var6, "Unknown device type");
      this.zzbaR = var5;
   }

   public int describeContents() {
      return 0;
   }

   public String getDescription() {
      return this.description;
   }

   public String getDeviceId() {
      return this.zzbaQ;
   }

   public String getName() {
      return this.name;
   }

   public String toString() {
      return this.name + ": " + this.description + "[" + this.zzbaR + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }

   public byte zzEb() {
      return this.zzbaR;
   }
}
