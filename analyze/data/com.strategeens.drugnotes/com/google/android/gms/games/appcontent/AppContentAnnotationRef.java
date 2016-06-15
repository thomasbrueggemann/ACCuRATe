package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
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
      return AppContentAnnotationEntity.method_4827(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1690();
   }

   public String getDescription() {
      return this.getString("annotation_description");
   }

   public String getTitle() {
      return this.getString("annotation_title");
   }

   public String getType() {
      return this.getString("annotation_type");
   }

   public int hashCode() {
      return AppContentAnnotationEntity.method_4826(this);
   }

   // $FF: renamed from: kL () android.net.Uri
   public Uri method_263() {
      return this.aR("annotation_image_uri");
   }

   // $FF: renamed from: kM () com.google.android.gms.games.appcontent.AppContentAnnotation
   public AppContentAnnotation method_1690() {
      return new AppContentAnnotationEntity(this);
   }

   public String toString() {
      return AppContentAnnotationEntity.method_4828(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentAnnotationEntity)this.method_1690()).writeToParcel(var1, var2);
   }
}
