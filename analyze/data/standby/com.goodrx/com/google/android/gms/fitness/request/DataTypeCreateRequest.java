package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.zzi;
import com.google.android.gms.internal.zzoj;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest implements SafeParcelable {
   public static final Creator<DataTypeCreateRequest> CREATOR = new zzi();
   private final String mName;
   private final int mVersionCode;
   private final zzoj zzaBa;
   private final List<Field> zzawE;

   DataTypeCreateRequest(int var1, String var2, List<Field> var3, IBinder var4) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.zzawE = Collections.unmodifiableList(var3);
      this.zzaBa = zzoj.zza.zzbE(var4);
   }

   private boolean zzb(DataTypeCreateRequest var1) {
      return com.google.android.gms.common.internal.zzw.equal(this.mName, var1.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzawE, var1.zzawE);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return var1 == this || var1 instanceof DataTypeCreateRequest && this.zzb((DataTypeCreateRequest)var1);
   }

   public IBinder getCallbackBinder() {
      return this.zzaBa == null?null:this.zzaBa.asBinder();
   }

   public List<Field> getFields() {
      return this.zzawE;
   }

   public String getName() {
      return this.mName;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.mName, this.zzawE};
      return com.google.android.gms.common.internal.zzw.hashCode(var1);
   }

   public String toString() {
      return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg("fields", this.zzawE).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }
}
