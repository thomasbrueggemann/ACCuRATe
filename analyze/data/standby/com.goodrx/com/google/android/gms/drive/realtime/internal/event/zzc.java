package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.realtime.internal.event.FieldChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ObjectChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import com.google.android.gms.drive.realtime.internal.event.ReferenceShiftedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextDeletedDetails;
import com.google.android.gms.drive.realtime.internal.event.TextInsertedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValueChangedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesAddedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesRemovedDetails;
import com.google.android.gms.drive.realtime.internal.event.ValuesSetDetails;
import java.util.ArrayList;

public class zzc implements Creator<ParcelableEvent> {
   static void zza(ParcelableEvent var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 2, (String)var0.zzLq, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzrG, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 4, var0.zzauR, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 5, var0.zzauS);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (String)var0.zzauL, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (String)var0.zzauV, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.zzauW, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.zzauX, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.zzauY, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (Parcelable)var0.zzauZ, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (Parcelable)var0.zzava, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (Parcelable)var0.zzavb, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (Parcelable)var0.zzavc, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (Parcelable)var0.zzavd, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 17, var0.zzauU);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 16, var0.zzauT);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 18, (Parcelable)var0.zzave, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcE(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzeA(var1);
   }

   public ParcelableEvent zzcE(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      String var4 = null;
      String var5 = null;
      ArrayList var6 = null;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      String var10 = null;
      String var11 = null;
      TextInsertedDetails var12 = null;
      TextDeletedDetails var13 = null;
      ValuesAddedDetails var14 = null;
      ValuesRemovedDetails var15 = null;
      ValuesSetDetails var16 = null;
      ValueChangedDetails var17 = null;
      ReferenceShiftedDetails var18 = null;
      ObjectChangedDetails var19 = null;
      FieldChangedDetails var20 = null;

      while(var1.dataPosition() < var2) {
         int var21 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var21)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var21);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var21);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var21);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var21);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var21);
            break;
         case 6:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var21);
            break;
         case 7:
            var11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var21);
            break;
         case 8:
            var12 = (TextInsertedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, TextInsertedDetails.CREATOR);
            break;
         case 9:
            var13 = (TextDeletedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, TextDeletedDetails.CREATOR);
            break;
         case 10:
            var14 = (ValuesAddedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ValuesAddedDetails.CREATOR);
            break;
         case 11:
            var15 = (ValuesRemovedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ValuesRemovedDetails.CREATOR);
            break;
         case 12:
            var16 = (ValuesSetDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ValuesSetDetails.CREATOR);
            break;
         case 13:
            var17 = (ValueChangedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ValueChangedDetails.CREATOR);
            break;
         case 14:
            var18 = (ReferenceShiftedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ReferenceShiftedDetails.CREATOR);
            break;
         case 15:
            var19 = (ObjectChangedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, ObjectChangedDetails.CREATOR);
            break;
         case 16:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var21);
            break;
         case 17:
            var9 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var21);
            break;
         case 18:
            var20 = (FieldChangedDetails)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var21, FieldChangedDetails.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var21);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new ParcelableEvent(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);
      }
   }

   public ParcelableEvent[] zzeA(int var1) {
      return new ParcelableEvent[var1];
   }
}
