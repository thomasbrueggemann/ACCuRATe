package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzh;
import com.google.android.gms.internal.zzoi;
import java.util.List;

public class DataSourcesRequest implements SafeParcelable {
   public static final Creator<DataSourcesRequest> CREATOR = new zzh();
   private final int mVersionCode;
   private final List<Integer> zzaAV;
   private final boolean zzaAW;
   private final zzoi zzaAX;
   private final List<DataType> zzawe;

   DataSourcesRequest(int var1, List<DataType> var2, List<Integer> var3, boolean var4, IBinder var5) {
      this.mVersionCode = var1;
      this.zzawe = var2;
      this.zzaAV = var3;
      this.zzaAW = var4;
      this.zzaAX = zzoi.zza.zzbD(var5);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAX == null?null:this.zzaAX.asBinder();
   }

   public List<DataType> getDataTypes() {
      return this.zzawe;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      com.google.android.gms.common.internal.zzw.zza var1 = com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("sourceTypes", this.zzaAV);
      if(this.zzaAW) {
         var1.zzg("includeDbOnlySources", "true");
      }

      return var1.toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzh.zza(this, var1, var2);
   }

   public List<Integer> zzuT() {
      return this.zzaAV;
   }

   public boolean zzuU() {
      return this.zzaAW;
   }
}
