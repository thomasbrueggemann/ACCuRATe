package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.FACLData;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import java.util.ArrayList;

public class zzc implements Creator<ScopeDetail> {
   static void zza(ScopeDetail var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.version);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.description, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzYw, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.zzYx, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (String)var0.zzYy, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzYz, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 7, var0.zzYA, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.zzYB, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzY(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzaV(var1);
   }

   public ScopeDetail zzY(Parcel var1) {
      FACLData var2 = null;
      int var3 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var4 = 0;
      ArrayList var5 = new ArrayList();
      String var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      String var10 = null;

      while(var1.dataPosition() < var3) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 4:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var11);
            break;
         case 8:
            var2 = (FACLData)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, FACLData.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new ScopeDetail(var4, var10, var9, var8, var7, var6, var5, var2);
      }
   }

   public ScopeDetail[] zzaV(int var1) {
      return new ScopeDetail[var1];
   }
}
