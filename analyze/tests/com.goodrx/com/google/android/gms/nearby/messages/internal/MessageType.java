package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzk;

public class MessageType implements SafeParcelable {
   public static final Creator<MessageType> CREATOR = new zzk();
   final int mVersionCode;
   public final String type;
   public final String zzamD;

   MessageType(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.zzamD = var2;
      this.type = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof MessageType)) {
            return false;
         }

         MessageType var2 = (MessageType)var1;
         if(!zzw.equal(this.zzamD, var2.zzamD) || !zzw.equal(this.type, var2.type)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzamD, this.type};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return "namespace=" + this.zzamD + ", type=" + this.type;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
