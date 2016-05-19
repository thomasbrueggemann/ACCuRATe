package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;
import com.google.android.gms.nearby.bootstrap.request.zza;

public class ConnectRequest implements SafeParcelable {
   public static final zza CREATOR = new zza();
   private final String description;
   private final String name;
   private final long timeoutMillis;
   final int versionCode;
   private final byte zzbaR;
   private final Device zzbaS;
   private final zzqe zzbaT;
   private final zzqf zzbaU;
   private final zzqg zzbaV;
   private final String zzbaW;
   private final byte zzbaX;

   ConnectRequest(int var1, Device var2, String var3, String var4, byte var5, long var6, String var8, byte var9, IBinder var10, IBinder var11, IBinder var12) {
      this.versionCode = var1;
      this.zzbaS = (Device)zzx.zzz(var2);
      this.name = zzx.zzcM(var3);
      this.description = (String)zzx.zzz(var4);
      this.zzbaR = var5;
      this.timeoutMillis = var6;
      this.zzbaX = var9;
      this.zzbaW = var8;
      zzx.zzz(var10);
      this.zzbaT = zzqe.zza.zzdq(var10);
      zzx.zzz(var11);
      this.zzbaU = zzqf.zza.zzdr(var11);
      zzx.zzz(var12);
      this.zzbaV = zzqg.zza.zzds(var12);
   }

   public int describeContents() {
      zza var10000 = CREATOR;
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

   public String getToken() {
      return this.zzbaW;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza var10000 = CREATOR;
      zza.zza(this, var1, var2);
   }

   public byte zzEb() {
      return this.zzbaR;
   }

   public Device zzEd() {
      return this.zzbaS;
   }

   public long zzEe() {
      return this.timeoutMillis;
   }

   public byte zzEf() {
      return this.zzbaX;
   }

   public IBinder zzEg() {
      return this.zzbaT == null?null:this.zzbaT.asBinder();
   }

   public IBinder zzEh() {
      return this.zzbaU == null?null:this.zzbaU.asBinder();
   }
}
