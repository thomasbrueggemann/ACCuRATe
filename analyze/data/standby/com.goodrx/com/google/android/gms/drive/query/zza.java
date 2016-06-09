package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.SortOrder;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

public class zza implements Creator<Query> {
   static void zza(Query var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1000, var0.mVersionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 1, (Parcelable)var0.zzatV, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.zzatW, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (Parcelable)var0.zzatX, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzb(var1, 5, var0.zzatY, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, var0.zzatZ);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 7, var0.zzapB, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, var0.zzarL);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzcj(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzee(var1);
   }

   public Query zzcj(Parcel var1) {
      boolean var2 = false;
      ArrayList var3 = null;
      int var4 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      boolean var5 = false;
      ArrayList var6 = null;
      SortOrder var7 = null;
      String var8 = null;
      LogicalFilter var9 = null;
      int var10 = 0;

      while(var1.dataPosition() < var4) {
         int var11 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var11)) {
         case 1:
            var9 = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, LogicalFilter.CREATOR);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var11);
            break;
         case 4:
            var7 = (SortOrder)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var11, SortOrder.CREATOR);
            break;
         case 5:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzD(var1, var11);
            break;
         case 6:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 7:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11, DriveSpace.CREATOR);
            break;
         case 8:
            var2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(var1, var11);
            break;
         case 1000:
            var10 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var11);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var11);
         }
      }

      if(var1.dataPosition() != var4) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var4, var1);
      } else {
         return new Query(var10, var9, var8, var7, var6, var5, var3, var2);
      }
   }

   public Query[] zzee(int var1) {
      return new Query[var1];
   }
}
