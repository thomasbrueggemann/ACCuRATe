package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzs;
import com.google.android.gms.internal.zzor;

public class ListSubscriptionsRequest implements SafeParcelable {
   public static final Creator<ListSubscriptionsRequest> CREATOR = new zzs();
   private final int mVersionCode;
   private final zzor zzaBd;
   private final DataType zzavT;

   ListSubscriptionsRequest(int var1, DataType var2, IBinder var3) {
      this.mVersionCode = var1;
      this.zzavT = var2;
      this.zzaBd = zzor.zza.zzbM(var3);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaBd == null?null:this.zzaBd.asBinder();
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzs.zza(this, var1, var2);
   }
}
