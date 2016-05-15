package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.result.zzh;
import java.util.List;

public class ListSubscriptionsResult implements Result, SafeParcelable {
   public static final Creator<ListSubscriptionsResult> CREATOR = new zzh();
   private final int mVersionCode;
   private final Status zzUX;
   private final List<Subscription> zzaBM;

   ListSubscriptionsResult(int var1, List<Subscription> var2, Status var3) {
      this.mVersionCode = var1;
      this.zzaBM = var2;
      this.zzUX = var3;
   }

   private boolean zzb(ListSubscriptionsResult var1) {
      return this.zzUX.equals(var1.zzUX) && zzw.equal(this.zzaBM, var1.zzaBM);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof ListSubscriptionsResult && this.zzb((ListSubscriptionsResult)var1);
   }

   public Status getStatus() {
      return this.zzUX;
   }

   public List<Subscription> getSubscriptions() {
      return this.zzaBM;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzUX, this.zzaBM};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("status", this.zzUX).zzg("subscriptions", this.zzaBM).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }
}
