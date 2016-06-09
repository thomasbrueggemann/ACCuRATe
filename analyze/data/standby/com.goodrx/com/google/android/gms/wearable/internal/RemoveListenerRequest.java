package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzbg;

public class RemoveListenerRequest implements SafeParcelable {
   public static final Creator<RemoveListenerRequest> CREATOR = new zzbg();
   final int mVersionCode;
   public final zzaw zzbrB;

   RemoveListenerRequest(int var1, IBinder var2) {
      this.mVersionCode = var1;
      if(var2 != null) {
         this.zzbrB = zzaw.zza.zzet(var2);
      } else {
         this.zzbrB = null;
      }
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzbg.zza(this, var1, var2);
   }

   IBinder zzIy() {
      return this.zzbrB == null?null:this.zzbrB.asBinder();
   }
}
