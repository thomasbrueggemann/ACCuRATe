package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ChannelImpl;
import com.google.android.gms.wearable.internal.zzn;

public final class ChannelEventParcelable implements SafeParcelable {
   public static final Creator<ChannelEventParcelable> CREATOR = new zzn();
   final int mVersionCode;
   final int type;
   final int zzbsa;
   final int zzbsb;
   final ChannelImpl zzbsc;

   ChannelEventParcelable(int var1, ChannelImpl var2, int var3, int var4, int var5) {
      this.mVersionCode = var1;
      this.zzbsc = var2;
      this.type = var3;
      this.zzbsa = var4;
      this.zzbsb = var5;
   }

   private static String zzlG(int var0) {
      switch(var0) {
      case 1:
         return "CHANNEL_OPENED";
      case 2:
         return "CHANNEL_CLOSED";
      case 3:
         return "INPUT_CLOSED";
      case 4:
         return "OUTPUT_CLOSED";
      default:
         return Integer.toString(var0);
      }
   }

   private static String zzlH(int var0) {
      switch(var0) {
      case 0:
         return "CLOSE_REASON_NORMAL";
      case 1:
         return "CLOSE_REASON_DISCONNECTED";
      case 2:
         return "CLOSE_REASON_REMOTE_CLOSE";
      case 3:
         return "CLOSE_REASON_LOCAL_CLOSE";
      default:
         return Integer.toString(var0);
      }
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzbsc + ", type=" + zzlG(this.type) + ", closeReason=" + zzlH(this.zzbsa) + ", appErrorCode=" + this.zzbsb + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzn.zza(this, var1, var2);
   }
}
