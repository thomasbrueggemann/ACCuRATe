package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.result.zzi;
import java.util.Collections;
import java.util.List;

public class ReadRawResult implements Result, SafeParcelable {
   public static final Creator<ReadRawResult> CREATOR = new zzi();
   private final int mVersionCode;
   private final List<DataHolder> zzaBN;
   private final DataHolder zzahi;

   ReadRawResult(int var1, DataHolder var2, List<DataHolder> var3) {
      this.mVersionCode = var1;
      this.zzahi = var2;
      if(var3 == null) {
         var3 = Collections.singletonList(var2);
      }

      this.zzaBN = var3;
   }

   public int describeContents() {
      return 0;
   }

   public Status getStatus() {
      return new Status(this.zzahi.getStatusCode());
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   DataHolder zzsX() {
      return this.zzahi;
   }

   public List<DataHolder> zzvo() {
      return this.zzaBN;
   }
}
