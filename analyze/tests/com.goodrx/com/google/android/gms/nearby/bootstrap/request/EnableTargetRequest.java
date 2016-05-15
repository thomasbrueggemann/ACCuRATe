package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.request.zze;

public class EnableTargetRequest implements SafeParcelable {
   public static final zze CREATOR = new zze();
   private final String description;
   private final String name;
   final int versionCode;
   private final byte zzbaR;
   private final zzqe zzbaT;
   private final zzqf zzbaU;
   private final zzqg zzbaV;

   EnableTargetRequest(int var1, String var2, String var3, byte var4, IBinder var5, IBinder var6, IBinder var7) {
      this.versionCode = var1;
      this.name = zzx.zzcM(var2);
      this.description = (String)zzx.zzz(var3);
      this.zzbaR = var4;
      zzx.zzz(var5);
      this.zzbaT = zzqe.zza.zzdq(var5);
      zzx.zzz(var6);
      this.zzbaU = zzqf.zza.zzdr(var6);
      zzx.zzz(var7);
      this.zzbaV = zzqg.zza.zzds(var7);
   }

   public int describeContents() {
      zze var10000 = CREATOR;
      return 0;
   }

   public IBinder getCallbackBinder() {
      return this.zzbaV == null?null:this.zzbaV.asBinder();
   }

   public String getDescription() {
      return this.description;
   }

   public String getName() {
      return this.name;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zze var10000 = CREATOR;
      zze.zza(this, var1, var2);
   }

   public byte zzEb() {
      return this.zzbaR;
   }

   public IBinder zzEg() {
      return this.zzbaT == null?null:this.zzbaT.asBinder();
   }

   public IBinder zzEh() {
      return this.zzbaU == null?null:this.zzbaU.asBinder();
   }
}
