package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.zzc;

public final class HandleClientLifecycleEventRequest implements SafeParcelable {
   public static final Creator<HandleClientLifecycleEventRequest> CREATOR = new zzc();
   public final int versionCode;
   public final ClientAppContext zzbcs;
   public final int zzbct;

   HandleClientLifecycleEventRequest(int var1, ClientAppContext var2, int var3) {
      this.versionCode = var1;
      this.zzbcs = var2;
      this.zzbct = var3;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }
}
