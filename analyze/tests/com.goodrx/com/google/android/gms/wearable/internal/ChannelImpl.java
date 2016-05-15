package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.internal.zzo;

public class ChannelImpl implements SafeParcelable, Channel {
   public static final Creator<ChannelImpl> CREATOR = new zzo();
   private final String mPath;
   final int mVersionCode;
   private final String zzVo;
   private final String zzbrb;

   ChannelImpl(int var1, String var2, String var3, String var4) {
      this.mVersionCode = var1;
      this.zzVo = (String)zzx.zzz(var2);
      this.zzbrb = (String)zzx.zzz(var3);
      this.mPath = (String)zzx.zzz(var4);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ChannelImpl)) {
            return false;
         }

         ChannelImpl var2 = (ChannelImpl)var1;
         if(!this.zzVo.equals(var2.zzVo) || !zzw.equal(var2.zzbrb, this.zzbrb) || !zzw.equal(var2.mPath, this.mPath) || var2.mVersionCode != this.mVersionCode) {
            return false;
         }
      }

      return true;
   }

   public String getNodeId() {
      return this.zzbrb;
   }

   public String getPath() {
      return this.mPath;
   }

   public String getToken() {
      return this.zzVo;
   }

   public int hashCode() {
      return this.zzVo.hashCode();
   }

   public String toString() {
      return "ChannelImpl{versionCode=" + this.mVersionCode + ", token=\'" + this.zzVo + '\'' + ", nodeId=\'" + this.zzbrb + '\'' + ", path=\'" + this.mPath + '\'' + "}";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }
}
