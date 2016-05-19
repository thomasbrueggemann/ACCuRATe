package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzb;
import com.google.android.gms.internal.zznr;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
   public static final Creator<BleDevice> CREATOR = new zzb();
   private final String mName;
   private final int mVersionCode;
   private final String zzawc;
   private final List<String> zzawd;
   private final List<DataType> zzawe;

   BleDevice(int var1, String var2, String var3, List<String> var4, List<DataType> var5) {
      this.mVersionCode = var1;
      this.zzawc = var2;
      this.mName = var3;
      this.zzawd = Collections.unmodifiableList(var4);
      this.zzawe = Collections.unmodifiableList(var5);
   }

   private boolean zza(BleDevice var1) {
      return this.mName.equals(var1.mName) && this.zzawc.equals(var1.zzawc) && zznr.zza(var1.zzawd, this.zzawd) && zznr.zza(this.zzawe, var1.zzawe);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof BleDevice && this.zza((BleDevice)var1);
   }

   public String getAddress() {
      return this.zzawc;
   }

   public List<DataType> getDataTypes() {
      return this.zzawe;
   }

   public String getName() {
      return this.mName;
   }

   public List<String> getSupportedProfiles() {
      return this.zzawd;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.zzawc, this.zzawd, this.zzawe};
      return zzw.hashCode(var1);
   }

   public String toString() {
      return zzw.zzy(this).zzg("name", this.mName).zzg("address", this.zzawc).zzg("dataTypes", this.zzawe).zzg("supportedProfiles", this.zzawd).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzb.zza(this, var1, var2);
   }
}
