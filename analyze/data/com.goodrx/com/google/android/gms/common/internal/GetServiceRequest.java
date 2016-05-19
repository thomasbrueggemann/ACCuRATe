package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zza;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
   public static final Creator<GetServiceRequest> CREATOR = new zzi();
   final int version;
   final int zzall;
   int zzalm;
   String zzaln;
   IBinder zzalo;
   Scope[] zzalp;
   Bundle zzalq;
   Account zzalr;

   public GetServiceRequest(int var1) {
      this.version = 2;
      this.zzalm = com.google.android.gms.common.zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
      this.zzall = var1;
   }

   GetServiceRequest(int var1, int var2, int var3, String var4, IBinder var5, Scope[] var6, Bundle var7, Account var8) {
      this.version = var1;
      this.zzall = var2;
      this.zzalm = var3;
      this.zzaln = var4;
      if(var1 < 2) {
         this.zzalr = this.zzaO(var5);
      } else {
         this.zzalo = var5;
         this.zzalr = var8;
      }

      this.zzalp = var6;
      this.zzalq = var7;
   }

   private Account zzaO(IBinder var1) {
      Account var2 = null;
      if(var1 != null) {
         var2 = zza.zza(zzp.zza.zzaP(var1));
      }

      return var2;
   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzi.zza(this, var1, var2);
   }

   public GetServiceRequest zzb(zzp var1) {
      if(var1 != null) {
         this.zzalo = var1.asBinder();
      }

      return this;
   }

   public GetServiceRequest zzc(Account var1) {
      this.zzalr = var1;
      return this;
   }

   public GetServiceRequest zzcG(String var1) {
      this.zzaln = var1;
      return this;
   }

   public GetServiceRequest zzd(Collection<Scope> var1) {
      this.zzalp = (Scope[])var1.toArray(new Scope[var1.size()]);
      return this;
   }

   public GetServiceRequest zzj(Bundle var1) {
      this.zzalq = var1;
      return this;
   }
}
