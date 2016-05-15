package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzc;

public class AddListenerRequest implements SafeParcelable {
   public static final Creator<AddListenerRequest> CREATOR = new zzc();
   final int mVersionCode;
   public final zzaw zzbrB;
   public final IntentFilter[] zzbrC;
   public final String zzbrD;
   public final String zzbrE;

   AddListenerRequest(int var1, IBinder var2, IntentFilter[] var3, String var4, String var5) {
      this.mVersionCode = var1;
      if(var2 != null) {
         this.zzbrB = zzaw.zza.zzet(var2);
      } else {
         this.zzbrB = null;
      }

      this.zzbrC = var3;
      this.zzbrD = var4;
      this.zzbrE = var5;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzc.zza(this, var1, var2);
   }

   IBinder zzIy() {
      return this.zzbrB == null?null:this.zzbrB.asBinder();
   }
}
