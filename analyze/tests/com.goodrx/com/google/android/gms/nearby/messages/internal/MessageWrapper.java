package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.internal.zzl;

public class MessageWrapper implements SafeParcelable {
   public static final zzl CREATOR = new zzl();
   final int mVersionCode;
   public final Message zzbcu;

   MessageWrapper(int var1, Message var2) {
      this.mVersionCode = var1;
      this.zzbcu = (Message)zzx.zzz(var2);
   }

   public int describeContents() {
      zzl var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof MessageWrapper)) {
         return false;
      } else {
         MessageWrapper var2 = (MessageWrapper)var1;
         return zzw.equal(this.zzbcu, var2.zzbcu);
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbcu};
      return zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzl var10000 = CREATOR;
      zzl.zza(this, var1, var2);
   }
}
