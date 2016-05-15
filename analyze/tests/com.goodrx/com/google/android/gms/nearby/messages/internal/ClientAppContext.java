package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zza;

public final class ClientAppContext implements SafeParcelable {
   public static final Creator<ClientAppContext> CREATOR = new zza();
   final int versionCode;
   public final boolean zzbbH;
   public final String zzbco;
   public final String zzbcp;
   public final int zzbcq;

   ClientAppContext(int var1, String var2, String var3, boolean var4, int var5) {
      this.versionCode = var1;
      this.zzbco = var2;
      this.zzbcp = var3;
      this.zzbbH = var4;
      this.zzbcq = var5;
   }

   public ClientAppContext(String var1, String var2) {
      this(var1, var2, false);
   }

   public ClientAppContext(String var1, String var2, boolean var3) {
      this(var1, var2, var3, 0);
   }

   public ClientAppContext(String var1, String var2, boolean var3, int var4) {
      this(1, var1, var2, var3, var4);
   }

   private static boolean zzT(String var0, String var1) {
      return TextUtils.isEmpty(var0)?TextUtils.isEmpty(var1):var0.equals(var1);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof ClientAppContext)) {
            return false;
         }

         ClientAppContext var2 = (ClientAppContext)var1;
         if(!zzT(this.zzbco, var2.zzbco) || !zzT(this.zzbcp, var2.zzbcp) || this.zzbbH != var2.zzbbH || this.zzbcq != var2.zzbcq) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq)};
      return zzw.hashCode(var1);
   }

   public String toString() {
      Object[] var1 = new Object[]{this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq)};
      return String.format("{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, callingContext: %d}", var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      zza.zza(this, var1, var2);
   }
}
