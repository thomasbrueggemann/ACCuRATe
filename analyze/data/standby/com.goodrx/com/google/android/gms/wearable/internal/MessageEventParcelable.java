package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzba;

public class MessageEventParcelable implements SafeParcelable {
   public static final Creator<MessageEventParcelable> CREATOR = new zzba();
   private final String mPath;
   final int mVersionCode;
   private final byte[] zzaKm;
   private final String zzaPI;
   private final int zzaox;

   MessageEventParcelable(int var1, int var2, String var3, byte[] var4, String var5) {
      this.mVersionCode = var1;
      this.zzaox = var2;
      this.mPath = var3;
      this.zzaKm = var4;
      this.zzaPI = var5;
   }

   public int describeContents() {
      return 0;
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public String getPath() {
      return this.mPath;
   }

   public int getRequestId() {
      return this.zzaox;
   }

   public String getSourceNodeId() {
      return this.zzaPI;
   }

   public String toString() {
      StringBuilder var1 = (new StringBuilder()).append("MessageEventParcelable[").append(this.zzaox).append(",").append(this.mPath).append(", size=");
      Object var2;
      if(this.zzaKm == null) {
         var2 = "null";
      } else {
         var2 = Integer.valueOf(this.zzaKm.length);
      }

      return var1.append(var2).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzba.zza(this, var1, var2);
   }
}
