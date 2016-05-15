package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;

public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
   AppContentAnnotationRef(ArrayList<DataHolder> var1, int var2) {
      super(var1, 2, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentAnnotationEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzvZ();
   }

   public String getDescription() {
      return this.getString("annotation_description");
   }

   public String getId() {
      return this.getString("annotation_id");
   }

   public String getTitle() {
      return this.getString("annotation_title");
   }

   public int hashCode() {
      return AppContentAnnotationEntity.zza(this);
   }

   public String toString() {
      return AppContentAnnotationEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentAnnotationEntity)this.zzvZ()).writeToParcel(var1, var2);
   }

   public String zzvT() {
      return this.getString("annotation_image_default_id");
   }

   public int zzvU() {
      return this.getInteger("annotation_image_height");
   }

   public Uri zzvV() {
      return this.zzcA("annotation_image_uri");
   }

   public Bundle zzvW() {
      return AppContentUtils.zzd(this.zzahi, this.zzaDN, "annotation_modifiers", this.zzaje);
   }

   public int zzvX() {
      return this.getInteger("annotation_image_width");
   }

   public String zzvY() {
      return this.getString("annotation_layout_slot");
   }

   public AppContentAnnotation zzvZ() {
      return new AppContentAnnotationEntity(this);
   }
}
