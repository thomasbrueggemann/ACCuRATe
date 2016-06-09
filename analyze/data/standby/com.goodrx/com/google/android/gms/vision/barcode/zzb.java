package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.vision.barcode.Barcode;

public class zzb implements Creator<Barcode> {
   static void zza(Barcode var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.zzb.zzav(var1);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 1, var0.versionCode);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 2, var0.format);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 3, (String)var0.rawValue, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 4, (String)var0.displayValue, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzc(var1, 5, var0.valueFormat);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 6, (Parcelable[])var0.cornerPoints, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 7, (Parcelable)var0.email, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 8, (Parcelable)var0.phone, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 9, (Parcelable)var0.sms, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 10, (Parcelable)var0.wifi, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 11, (Parcelable)var0.url, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 12, (Parcelable)var0.geoPoint, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 13, (Parcelable)var0.calendarEvent, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 14, (Parcelable)var0.contactInfo, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zza(var1, 15, (Parcelable)var0.driverLicense, var2, false);
      com.google.android.gms.common.internal.safeparcel.zzb.zzI(var1, var3);
   }

   // $FF: synthetic method
   public Object createFromParcel(Parcel var1) {
      return this.zzgX(var1);
   }

   // $FF: synthetic method
   public Object[] newArray(int var1) {
      return this.zzku(var1);
   }

   public Barcode zzgX(Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.zza.zzau(var1);
      int var3 = 0;
      int var4 = 0;
      String var5 = null;
      String var6 = null;
      int var7 = 0;
      Point[] var8 = null;
      Barcode.Email var9 = null;
      Barcode.Phone var10 = null;
      Barcode.Sms var11 = null;
      Barcode.WiFi var12 = null;
      Barcode.UrlBookmark var13 = null;
      Barcode.GeoPoint var14 = null;
      Barcode.CalendarEvent var15 = null;
      Barcode.ContactInfo var16 = null;
      Barcode.DriverLicense var17 = null;

      while(var1.dataPosition() < var2) {
         int var18 = com.google.android.gms.common.internal.safeparcel.zza.zzat(var1);
         switch(com.google.android.gms.common.internal.safeparcel.zza.zzca(var18)) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 4:
            var6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(var1, var18);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(var1, var18);
            break;
         case 6:
            var8 = (Point[])com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var18, Point.CREATOR);
            break;
         case 7:
            var9 = (Barcode.Email)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.Email.CREATOR);
            break;
         case 8:
            var10 = (Barcode.Phone)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.Phone.CREATOR);
            break;
         case 9:
            var11 = (Barcode.Sms)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.Sms.CREATOR);
            break;
         case 10:
            var12 = (Barcode.WiFi)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.WiFi.CREATOR);
            break;
         case 11:
            var13 = (Barcode.UrlBookmark)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.UrlBookmark.CREATOR);
            break;
         case 12:
            var14 = (Barcode.GeoPoint)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.GeoPoint.CREATOR);
            break;
         case 13:
            var15 = (Barcode.CalendarEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.CalendarEvent.CREATOR);
            break;
         case 14:
            var16 = (Barcode.ContactInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.ContactInfo.CREATOR);
            break;
         case 15:
            var17 = (Barcode.DriverLicense)com.google.android.gms.common.internal.safeparcel.zza.zza(var1, var18, Barcode.DriverLicense.CREATOR);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.zza.zzb(var1, var18);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + var2, var1);
      } else {
         return new Barcode(var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17);
      }
   }

   public Barcode[] zzku(int var1) {
      return new Barcode[var1];
   }
}
