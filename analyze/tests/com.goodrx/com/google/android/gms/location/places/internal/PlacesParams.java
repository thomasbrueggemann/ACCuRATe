package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.places.internal.zzs;
import java.util.Locale;

public class PlacesParams implements SafeParcelable {
   public static final zzs CREATOR = new zzs();
   public static final PlacesParams zzaQW = new PlacesParams("com.google.android.gms", Locale.getDefault(), (String)null);
   public final int versionCode;
   public final String zzaPU;
   public final String zzaQX;
   public final String zzaQY;
   public final String zzaQZ;
   public final int zzaRa;
   public final int zzaRb;

   public PlacesParams(int var1, String var2, String var3, String var4, String var5, int var6, int var7) {
      this.versionCode = var1;
      this.zzaQX = var2;
      this.zzaQY = var3;
      this.zzaQZ = var4;
      this.zzaPU = var5;
      this.zzaRa = var6;
      this.zzaRb = var7;
   }

   public PlacesParams(String var1, Locale var2, String var3) {
      this(3, var1, var2.toString(), var3, (String)null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
   }

   public int describeContents() {
      zzs var10000 = CREATOR;
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 != null && var1 instanceof PlacesParams) {
            PlacesParams var2 = (PlacesParams)var1;
            if(this.zzaRa == var2.zzaRa && this.zzaRb == var2.zzaRb && this.zzaQY.equals(var2.zzaQY) && this.zzaQX.equals(var2.zzaQX) && zzw.equal(this.zzaQZ, var2.zzaQZ) && zzw.equal(this.zzaPU, var2.zzaPU)) {
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public int hashCode() {
      Object[] var1 = new Object[]{this.zzaQX, this.zzaQY, this.zzaQZ, this.zzaPU, Integer.valueOf(this.zzaRa), Integer.valueOf(this.zzaRb)};
      return zzw.hashCode(var1);
   }

   @SuppressLint({"DefaultLocale"})
   public String toString() {
      return zzw.zzy(this).zzg("clientPackageName", this.zzaQX).zzg("locale", this.zzaQY).zzg("accountName", this.zzaQZ).zzg("gCoreClientName", this.zzaPU).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzs var10000 = CREATOR;
      zzs.zza(this, var1, var2);
   }
}
