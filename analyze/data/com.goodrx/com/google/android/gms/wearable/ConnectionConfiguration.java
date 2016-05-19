package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzg;

public class ConnectionConfiguration implements SafeParcelable {
   public static final Creator<ConnectionConfiguration> CREATOR = new zzg();
   private final String mName;
   final int mVersionCode;
   private boolean zzTb;
   private final int zzabB;
   private final int zzapo;
   private final String zzawc;
   private final boolean zzbqY;
   private String zzbqZ;
   private boolean zzbra;
   private String zzbrb;

   ConnectionConfiguration(int var1, String var2, String var3, int var4, int var5, boolean var6, boolean var7, String var8, boolean var9, String var10) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzawc = var3;
      this.zzabB = var4;
      this.zzapo = var5;
      this.zzbqY = var6;
      this.zzTb = var7;
      this.zzbqZ = var8;
      this.zzbra = var9;
      this.zzbrb = var10;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof ConnectionConfiguration) {
         ConnectionConfiguration var2 = (ConnectionConfiguration)var1;
         if(zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(var2.mVersionCode)) && zzw.equal(this.mName, var2.mName) && zzw.equal(this.zzawc, var2.zzawc) && zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(var2.zzabB)) && zzw.equal(Integer.valueOf(this.zzapo), Integer.valueOf(var2.zzapo)) && zzw.equal(Boolean.valueOf(this.zzbqY), Boolean.valueOf(var2.zzbqY)) && zzw.equal(Boolean.valueOf(this.zzbra), Boolean.valueOf(var2.zzbra))) {
            return true;
         }
      }

      return false;
   }

   public String getAddress() {
      return this.zzawc;
   }

   public String getName() {
      return this.mName;
   }

   public String getNodeId() {
      return this.zzbrb;
   }

   public int getRole() {
      return this.zzapo;
   }

   public int getType() {
      return this.zzabB;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Integer.valueOf(this.mVersionCode), this.mName, this.zzawc, Integer.valueOf(this.zzabB), Integer.valueOf(this.zzapo), Boolean.valueOf(this.zzbqY), Boolean.valueOf(this.zzbra)};
      return zzw.hashCode(var1);
   }

   public boolean isConnected() {
      return this.zzTb;
   }

   public boolean isEnabled() {
      return this.zzbqY;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConnectionConfiguration[ ");
      var1.append("mName=" + this.mName);
      var1.append(", mAddress=" + this.zzawc);
      var1.append(", mType=" + this.zzabB);
      var1.append(", mRole=" + this.zzapo);
      var1.append(", mEnabled=" + this.zzbqY);
      var1.append(", mIsConnected=" + this.zzTb);
      var1.append(", mPeerNodeId=" + this.zzbqZ);
      var1.append(", mBtlePriority=" + this.zzbra);
      var1.append(", mNodeId=" + this.zzbrb);
      var1.append("]");
      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzg.zza(this, var1, var2);
   }

   public String zzIt() {
      return this.zzbqZ;
   }

   public boolean zzIu() {
      return this.zzbra;
   }
}
