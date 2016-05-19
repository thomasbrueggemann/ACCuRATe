package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.zzr;

public class SessionDataSet implements SafeParcelable {
   public static final Creator<SessionDataSet> CREATOR = new zzr();
   final int mVersionCode;
   private final Session zzavX;
   private final DataSet zzaxn;

   SessionDataSet(int var1, Session var2, DataSet var3) {
      this.mVersionCode = var1;
      this.zzavX = var2;
      this.zzaxn = var3;
   }

   private boolean zza(SessionDataSet var1) {
      return zzw.equal(this.zzavX, var1.zzavX) && zzw.equal(this.zzaxn, var1.zzaxn);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof SessionDataSet && this.zza((SessionDataSet)var1);
   }

   public DataSet getDataSet() {
      return this.zzaxn;
   }

   public Session getSession() {
      return this.zzavX;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzavX, this.zzaxn};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("session", this.zzavX).zzg("dataSet", this.zzaxn).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzr.zza(this, var1, var2);
   }
}
