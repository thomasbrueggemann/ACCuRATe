package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.internal.DeleteRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DeleteRequest> {
   static void zza(DeleteRequest var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zza(var1, 1, (Parcelable)var0.getCredential(), var2, false);
      zzb.zzc(var1, 1000, var0.mVersionCode);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzK(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaF(var1);
   }

   public DeleteRequest zzK(Parcel var1) {
      int var2 = zza.zzau(var1);
      int var3 = 0;
      Credential var4 = null;

      while(var1.dataPosition() < var2) {
         int var5 = zza.zzat(var1);
         switch(zza.zzca(var5)) {
         case 1:
            var4 = (Credential)zza.zza(var1, var5, Credential.CREATOR);
            break;
         case 1000:
            var3 = zza.zzg(var1, var5);
            break;
         default:
            zza.zzb(var1, var5);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new DeleteRequest(var3, var4);
      }
   }

   public DeleteRequest[] zzaF(int var1) {
      return new DeleteRequest[var1];
   }
}
