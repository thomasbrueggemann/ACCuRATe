package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class zze implements Creator<CompletionEvent> {
   static void zza(CompletionEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (Parcelable)var0.zzaoz, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzVa, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzapD, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzapE, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzapF, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 7, var0.zzapG, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 8, var0.zzBc);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (IBinder)var0.zzapH, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzaS(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzcH(var1);
   }

   public CompletionEvent zzaS(Parcel var1) {
      int var2 = 0;
      IBinder var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      ArrayList var5 = null;
      MetadataBundle var6 = null;
      ParcelFileDescriptor var7 = null;
      ParcelFileDescriptor var8 = null;
      String var9 = null;
      DriveId var10 = null;
      int var11 = 0;

      while(var1.dataPosition() < var4) {
         int var12 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var12)) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 2:
            var10 = (DriveId)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, DriveId.CREATOR);
            break;
         case 3:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var12);
            break;
         case 4:
            var8 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, ParcelFileDescriptor.CREATOR);
            break;
         case 5:
            var7 = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, ParcelFileDescriptor.CREATOR);
            break;
         case 6:
            var6 = (MetadataBundle)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var12, MetadataBundle.CREATOR);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var12);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var12);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(var1, var12);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var12);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new CompletionEvent(var11, var10, var9, var8, var7, var6, var5, var2, var3);
      }
   }

   public CompletionEvent[] zzcH(int var1) {
      return new CompletionEvent[var1];
   }
}
