package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Application;
import com.google.android.gms.fitness.data.zzq;

public class Session implements SafeParcelable {
   public static final Creator<Session> CREATOR = new zzq();
   private final String mName;
   private final int mVersionCode;
   private final long zzRD;
   private final long zzavV;
   private final int zzawf;
   private final Application zzaws;
   private final String zzaxk;
   private final String zzaxl;
   private final Long zzaxm;

   Session(int var1, long var2, long var4, String var6, String var7, String var8, int var9, Application var10, Long var11) {
      this.mVersionCode = var1;
      this.zzRD = var2;
      this.zzavV = var4;
      this.mName = var6;
      this.zzaxk = var7;
      this.zzaxl = var8;
      this.zzawf = var9;
      this.zzaws = var10;
      this.zzaxm = var11;
   }

   private boolean zza(Session var1) {
      return this.zzRD == var1.zzRD && this.zzavV == var1.zzavV && zzw.equal(this.mName, var1.mName) && zzw.equal(this.zzaxk, var1.zzaxk) && zzw.equal(this.zzaxl, var1.zzaxl) && zzw.equal(this.zzaws, var1.zzaws) && this.zzawf == var1.zzawf;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof Session && this.zza((Session)var1);
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getIdentifier() {
      return this.zzaxk;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxk};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("name", this.mName).zzg("identifier", this.zzaxk).zzg("description", this.zzaxl).zzg("activity", Integer.valueOf(this.zzawf)).zzg("application", this.zzaws).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzq.zza(this, var1, var2);
   }

   public long zzlO() {
      return this.zzRD;
   }

   public int zzub() {
      return this.zzawf;
   }

   public long zzud() {
      return this.zzavV;
   }

   public Application zzum() {
      return this.zzaws;
   }

   public Long zzuw() {
      return this.zzaxm;
   }
}
