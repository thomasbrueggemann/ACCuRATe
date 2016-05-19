package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.zzaf;
import com.google.android.gms.internal.zzow;

public class SubscribeRequest implements SafeParcelable {
   public static final Creator<SubscribeRequest> CREATOR = new zzaf();
   private final int mVersionCode;
   private final zzow zzaAD;
   private Subscription zzaBC;
   private final boolean zzaBD;

   SubscribeRequest(int var1, Subscription var2, boolean var3, IBinder var4) {
      this.mVersionCode = var1;
      this.zzaBC = var2;
      this.zzaBD = var3;
      this.zzaAD = zzow.zza.zzbR(var4);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("subscription", this.zzaBC).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzaf.zza(this, var1, var2);
   }

   public Subscription zzvh() {
      return this.zzaBC;
   }

   public boolean zzvi() {
      return this.zzaBD;
   }
}
