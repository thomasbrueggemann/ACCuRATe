package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzk;
import com.google.android.gms.internal.zzow;

public class DataUpdateListenerRegistrationRequest implements SafeParcelable {
   public static final Creator<DataUpdateListenerRegistrationRequest> CREATOR = new zzk();
   private final PendingIntent mPendingIntent;
   private final int mVersionCode;
   private final zzow zzaAD;
   private DataType zzavT;
   private DataSource zzavU;

   DataUpdateListenerRegistrationRequest(int var1, DataSource var2, DataType var3, PendingIntent var4, IBinder var5) {
      this.mVersionCode = var1;
      this.zzavU = var2;
      this.zzavT = var3;
      this.mPendingIntent = var4;
      this.zzaAD = zzow.zza.zzbR(var5);
   }

   private boolean zzb(DataUpdateListenerRegistrationRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzavU, var1.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, var1.zzavT) && com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, var1.mPendingIntent);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof DataUpdateListenerRegistrationRequest && this.zzb((DataUpdateListenerRegistrationRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaAD == null?null:this.zzaAD.asBinder();
   }

   public DataSource getDataSource() {
      return this.zzavU;
   }

   public DataType getDataType() {
      return this.zzavT;
   }

   public PendingIntent getIntent() {
      return this.mPendingIntent;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, this.zzavT, this.mPendingIntent};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("dataSource", this.zzavU).zzg("dataType", this.zzavT).zzg("pendingIntent", this.mPendingIntent).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzk.zza(this, var1, var2);
   }
}
