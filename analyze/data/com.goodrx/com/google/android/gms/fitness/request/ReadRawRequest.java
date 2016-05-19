package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.DataSourceQueryParams;
import com.google.android.gms.fitness.request.zzt;
import com.google.android.gms.internal.zzos;
import java.util.List;

public class ReadRawRequest implements SafeParcelable {
   public static final Creator<ReadRawRequest> CREATOR = new zzt();
   private final int mVersionCode;
   private final boolean zzaAP;
   private final boolean zzaAQ;
   private final zzos zzaBe;
   private final List<DataSourceQueryParams> zzaBf;

   ReadRawRequest(int var1, IBinder var2, List<DataSourceQueryParams> var3, boolean var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzaBe = zzos.zza.zzbN(var2);
      this.zzaBf = var3;
      this.zzaAP = var4;
      this.zzaAQ = var5;
   }

   public int describeContents() {
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzaBe != null?this.zzaBe.asBinder():null;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzt.zza(this, var1, var2);
   }

   public boolean zzuP() {
      return this.zzaAQ;
   }

   public boolean zzuQ() {
      return this.zzaAP;
   }

   public List<DataSourceQueryParams> zzuW() {
      return this.zzaBf;
   }
}
