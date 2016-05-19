package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.devices.zzb;
import com.google.android.gms.nearby.messages.devices.zzd;
import com.google.android.gms.nearby.messages.devices.zzh;

public class NearbyDeviceId implements SafeParcelable {
   public static final Creator<NearbyDeviceId> CREATOR = new zzh();
   public static final NearbyDeviceId zzbcl = new NearbyDeviceId();
   final int mVersionCode;
   private final int zzabB;
   final byte[] zzbbY;
   private final zzb zzbcm;
   private final zzd zzbcn;

   private NearbyDeviceId() {
      this(1, 1, (byte[])null);
   }

   NearbyDeviceId(int var1, int var2, byte[] var3) {
      this.mVersionCode = var1;
      this.zzabB = var2;
      this.zzbbY = var3;
      zzb var4;
      if(var2 == 2) {
         var4 = new zzb(var3);
      } else {
         var4 = null;
      }

      this.zzbcm = var4;
      zzd var5 = null;
      if(var2 == 3) {
         var5 = new zzd(var3);
      }

      this.zzbcn = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof NearbyDeviceId)) {
            return false;
         }

         NearbyDeviceId var2 = (NearbyDeviceId)var1;
         if(!zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(var2.zzabB)) || !zzw.equal(this.zzbbY, var2.zzbbY)) {
            return false;
         }
      }

      return true;
   }

   public int getType() {
      return this.zzabB;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.zzabB), this.zzbbY};
      return zzw.hashCode(var1);
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("NearbyDeviceId{");
      switch(this.zzabB) {
      case 1:
         var1.append("UNKNOWN");
         break;
      case 2:
         var1.append("eddystoneUid=").append(this.zzbcm);
         break;
      case 3:
         var1.append("iBeaconId=").append(this.zzbcn);
      }

      var1.append("}");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
