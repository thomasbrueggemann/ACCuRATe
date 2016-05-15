package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.internal.zzp;
import com.google.android.gms.location.places.internal.zzt;

public class zzq extends zzt implements PlacePhotoMetadata {
   private final String zzaQR = this.getString("photo_fife_url");

   public zzq(DataHolder var1, int var2) {
      super(var1, var2);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzzz();
   }

   public CharSequence getAttributions() {
      return this.zzG("photo_attributions", (String)null);
   }

   public int getMaxHeight() {
      return this.zzz("photo_max_height", 0);
   }

   public int getMaxWidth() {
      return this.zzz("photo_max_width", 0);
   }

   public PlacePhotoMetadata zzzz() {
      return new zzp(this.zzaQR, this.getMaxWidth(), this.getMaxHeight(), this.getAttributions(), this.zzaje);
   }
}
