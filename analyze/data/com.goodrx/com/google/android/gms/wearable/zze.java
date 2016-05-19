package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.Asset;

public class zze implements Creator<Asset> {
   static void zza(Asset var0, Parcel var1, int var2) {
      int var3 = zzb.zzav(var1);
      zzb.zzc(var1, 1, var0.mVersionCode);
      zzb.zza(var1, 2, (byte[])var0.getData(), false);
      zzb.zza(var1, 3, (String)var0.getDigest(), false);
      zzb.zza(var1, 4, (Parcelable)var0.zzbqV, var2, false);
      zzb.zza(var1, 5, (Parcelable)var0.uri, var2, false);
      zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzhX(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzly(var1);
   }

   public Asset zzhX(Parcel var1) {
      Uri var2 = null;
      int var3 = zza.zzau(var1);
      int var4 = 0;
      ParcelFileDescriptor var5 = null;
      String var6 = null;
      byte[] var7 = null;

      while(var1.dataPosition() < var3) {
         int var8 = zza.zzat(var1);
         switch(zza.zzca(var8)) {
         case 1:
            var4 = zza.zzg(var1, var8);
            break;
         case 2:
            var7 = zza.zzs(var1, var8);
            break;
         case 3:
            var6 = zza.zzp(var1, var8);
            break;
         case 4:
            var5 = (ParcelFileDescriptor)zza.zza(var1, var8, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var2 = (Uri)zza.zza(var1, var8, Uri.CREATOR);
            break;
         default:
            zza.zzb(var1, var8);
         }
      }

      if(var1.dataPosition() != var3) {
         throw new zza.zza("Overread allowed size end=" + var3, var1);
      } else {
         return new Asset(var4, var7, var6, var5, var2);
      }
   }

   public Asset[] zzly(int var1) {
      return new Asset[var1];
   }
}
