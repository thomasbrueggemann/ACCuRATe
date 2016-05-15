package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.zzah;
import com.google.android.gms.internal.zzow;

public class UnsubscribeRequest implements SafeParcelable {
   public static final Creator<UnsubscribeRequest> CREATOR = new zzah();
   private final int mVersionCode;
   private final zzow zzaAD;
   private final DataType zzavT;
   private final DataSource zzavU;

   UnsubscribeRequest(int var1, DataType var2, DataSource var3, IBinder var4) {
      this.mVersionCode = var1;
      this.zzavT = var2;
      this.zzavU = var3;
      this.zzaAD = zzow.zza.zzbR(var4);
   }

   private boolean zzb(UnsubscribeRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.zzavU, var1.zzavU) && com.google.android.gms.common.internal.zzw.equal(this.zzavT, var1.zzavT);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return this == var1 || var1 instanceof UnsubscribeRequest && this.zzb((UnsubscribeRequest)var1);
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

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavU, this.zzavT};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzah.zza(this, var1, var2);
   }
}
