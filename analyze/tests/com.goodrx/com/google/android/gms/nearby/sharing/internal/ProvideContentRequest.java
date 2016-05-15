package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb;
import com.google.android.gms.nearby.sharing.internal.zzc;
import com.google.android.gms.nearby.sharing.internal.zzf;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
   public static final Creator<ProvideContentRequest> CREATOR = new zzf();
   final int versionCode;
   public IBinder zzbdk;
   public zzb zzbdl;
   @Deprecated
   public List<SharedContent> zzbdm;
   public long zzbdn;
   public zzc zzbdo;

   ProvideContentRequest() {
      this.versionCode = 1;
   }

   ProvideContentRequest(int var1, IBinder var2, IBinder var3, List<SharedContent> var4, long var5, IBinder var7) {
      this.versionCode = var1;
      this.zzbdk = var2;
      this.zzbdl = zzb.zza.zzdG(var3);
      this.zzbdm = var4;
      this.zzbdn = var5;
      this.zzbdo = zzc.zza.zzdH(var7);
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzf.zza(this, var1, var2);
   }

   IBinder zzED() {
      return this.zzbdo.asBinder();
   }

   IBinder zzEP() {
      return this.zzbdl == null?null:this.zzbdl.asBinder();
   }
}
