package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceId;
import com.google.android.gms.nearby.messages.devices.zzf;
import java.util.Arrays;

public class NearbyDevice implements SafeParcelable {
   public static final Creator<NearbyDevice> CREATOR = new zzf();
   private static final NearbyDeviceId[] zzbcb = new NearbyDeviceId[0];
   private static final String[] zzbcc = new String[0];
   public static final NearbyDevice zzbcd;
   final int mVersionCode;
   @Deprecated
   @Nullable
   private final String zzF;
   @Deprecated
   private final NearbyDeviceId zzbce;
   private final String zzbcf;
   private final NearbyDeviceId[] zzbcg;
   private final String[] zzbch;

   static {
      zzbcd = new NearbyDevice("", zzbcb, zzbcc);
   }

   NearbyDevice(int var1, @Nullable NearbyDeviceId var2, @Nullable String var3, @Nullable String var4, @Nullable NearbyDeviceId[] var5, @Nullable String[] var6) {
      this.mVersionCode = ((Integer)zzx.zzz(Integer.valueOf(var1))).intValue();
      if(var4 == null) {
         var4 = "";
      }

      this.zzbcf = var4;
      if(var5 == null) {
         var5 = zzbcb;
      }

      this.zzbcg = var5;
      if(var6 == null) {
         var6 = zzbcc;
      }

      this.zzbch = var6;
      NearbyDeviceId var7;
      if(this.zzbcg.length == 0) {
         var7 = NearbyDeviceId.zzbcl;
      } else {
         var7 = this.zzbcg[0];
      }

      this.zzbce = var7;
      String var8;
      if(this.zzbch.length == 0) {
         var8 = null;
      } else {
         var8 = this.zzbch[0];
      }

      this.zzF = var8;
   }

   public NearbyDevice(String var1, NearbyDeviceId[] var2, String[] var3) {
      this(1, (NearbyDeviceId)null, (String)null, var1, var2, var3);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof NearbyDevice)) {
         return false;
      } else {
         NearbyDevice var2 = (NearbyDevice)var1;
         return zzw.equal(this.zzbcf, var2.zzbcf);
      }
   }

   @Deprecated
   @Nullable
   public String getUrl() {
      return this.zzbch.length == 0?null:this.zzbch[0];
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbcf};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "NearbyDevice{deviceHandle=" + this.zzbcf + ", ids=" + Arrays.toString(this.zzbcg) + ", urls=" + Arrays.toString(this.zzbch) + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   public NearbyDeviceId[] zzEA() {
      return this.zzbcg;
   }

   public String[] zzEB() {
      return this.zzbch;
   }

   public String zzEC() {
      return this.zzbcf;
   }

   @Deprecated
   public NearbyDeviceId zzEz() {
      return this.zzbcg.length == 0?NearbyDeviceId.zzbcl:this.zzbcg[0];
   }
}
