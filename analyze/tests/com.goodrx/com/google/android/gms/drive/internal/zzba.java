package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;
import com.google.android.gms.drive.internal.OnEventResponse;

public class zzba implements Creator<OnEventResponse> {
   static void zza(OnEventResponse var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.zzanf);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (Parcelable)var0.zzasl, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, (Parcelable)var0.zzasm, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable)var0.zzasn, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.zzaso, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzasp, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.zzasq, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzbD(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzdy(var1);
   }

   public OnEventResponse zzbD(Parcel var1) {
      int var2 = 0;
      TransferProgressEvent var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      TransferStateEvent var5 = null;
      ChangesAvailableEvent var6 = null;
      QueryResultEventParcelable var7 = null;
      CompletionEvent var8 = null;
      ChangeEvent var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         case 3:
            var9 = (ChangeEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, ChangeEvent.CREATOR);
            break;
         case 4:
         case 8:
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
            break;
         case 5:
            var8 = (CompletionEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, CompletionEvent.CREATOR);
            break;
         case 6:
            var7 = (QueryResultEventParcelable)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, QueryResultEventParcelable.CREATOR);
            break;
         case 7:
            var6 = (ChangesAvailableEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, ChangesAvailableEvent.CREATOR);
            break;
         case 9:
            var5 = (TransferStateEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, TransferStateEvent.CREATOR);
            break;
         case 10:
            var3 = (TransferProgressEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, TransferProgressEvent.CREATOR);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new OnEventResponse(var10, var2, var9, var8, var7, var6, var5, var3);
      }
   }

   public OnEventResponse[] zzdy(int var1) {
      return new OnEventResponse[var1];
   }
}
