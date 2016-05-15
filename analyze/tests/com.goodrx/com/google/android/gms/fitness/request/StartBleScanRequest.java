package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzad;
import com.google.android.gms.fitness.request.zzq;
import com.google.android.gms.internal.zzow;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest implements SafeParcelable {
   public static final Creator<StartBleScanRequest> CREATOR = new zzad();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final zzq zzaBA;
   private final int zzaBB;
   private final List<DataType> zzawe;

   StartBleScanRequest(int var1, List<DataType> var2, IBinder var3, int var4, IBinder var5) {
      this.mVersionCode = var1;
      this.zzawe = var2;
      this.zzaBA = zzq.zza.zzbU(var3);
      this.zzaBB = var4;
      this.zzaAD = zzow.zza.zzbR(var5);
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public List<DataType> getDataTypes() {
      return Collections.unmodifiableList(this.zzawe);
   }

   public int getTimeoutSecs() {
      return this.zzaBB;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataTypes", this.zzawe).zzg("timeoutSecs", Integer.valueOf(this.zzaBB)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzad.zza(this, var1, var2);
   }

   public IBinder zzvg() {
      return this.zzaBA.asBinder();
   }
}
