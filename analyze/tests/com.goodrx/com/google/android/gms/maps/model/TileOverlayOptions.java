package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.zzo;

public final class TileOverlayOptions implements SafeParcelable {
   public static final zzo CREATOR = new zzo();
   private final int mVersionCode;
   private com.google.android.gms.maps.model.internal.zzi zzaTP;
   private TileProvider zzaTQ;
   private boolean zzaTR = true;
   private float zzaTh;
   private boolean zzaTi = true;

   public TileOverlayOptions() {
      this.mVersionCode = 1;
   }

   TileOverlayOptions(int var1, IBinder var2, boolean var3, float var4, boolean var5) {
      this.mVersionCode = var1;
      this.zzaTP = com.google.android.gms.maps.model.internal.zzi.zza.zzdm(var2);
      TileProvider var6;
      if(this.zzaTP == null) {
         var6 = null;
      } else {
         var6 = new TileProvider() {
            private final com.google.android.gms.maps.model.internal.zzi zzaTS;

            {
               this.zzaTS = TileOverlayOptions.this.zzaTP;
            }
         };
      }

      this.zzaTQ = var6;
      this.zzaTi = var3;
      this.zzaTh = var4;
      this.zzaTR = var5;
   }

   public int describeContents() {
      return 0;
   }

   public boolean getFadeIn() {
      return this.zzaTR;
   }

   int getVersionCode() {
      return this.mVersionCode;
   }

   public float getZIndex() {
      return this.zzaTh;
   }

   public boolean isVisible() {
      return this.zzaTi;
   }

   public void writeToParcel(Parcel var1, int var2) {
      zzo.zza(this, var1, var2);
   }

   IBinder zzAm() {
      return this.zzaTP.asBinder();
   }
}
