package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
   AppContentCardRef(ArrayList<DataHolder> var1, int var2) {
      super(var1, 0, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentCardEntity.method_3705(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1689();
   }

   public List<AppContentAction> getActions() {
      return AppContentUtils.method_1643(this.JG, this.XX, "card_actions", this.KZ);
   }

   public String getDescription() {
      return this.getString("card_description");
   }

   public Uri getIconImageUri() {
      return this.aR("card_icon_image_uri");
   }

   public String getTitle() {
      return this.getString("card_title");
   }

   public String getType() {
      return this.getString("card_type");
   }

   public int hashCode() {
      return AppContentCardEntity.method_3704(this);
   }

   // $FF: renamed from: kH () java.util.List
   public List<AppContentCondition> method_234() {
      return AppContentUtils.method_1646(this.JG, this.XX, "card_conditions", this.KZ);
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_235() {
      return this.getString("card_content_description");
   }

   // $FF: renamed from: kL () android.net.Uri
   public Uri method_236() {
      return this.aR("card_image_uri");
   }

   // $FF: renamed from: kN () java.util.List
   public List<AppContentAnnotation> method_237() {
      return AppContentUtils.method_1645(this.JG, this.XX, "card_annotations", this.KZ);
   }

   // $FF: renamed from: kO () int
   public int method_238() {
      return this.getInteger("card_current_steps");
   }

   // $FF: renamed from: kP () android.os.Bundle
   public Bundle method_239() {
      return AppContentUtils.method_1647(this.JG, this.XX, "card_data", this.KZ);
   }

   // $FF: renamed from: kQ () java.lang.String
   public String method_240() {
      return this.getString("card_subtitle");
   }

   // $FF: renamed from: kR () int
   public int method_241() {
      return this.getInteger("card_total_steps");
   }

   // $FF: renamed from: kS () com.google.android.gms.games.appcontent.AppContentCard
   public AppContentCard method_1689() {
      return new AppContentCardEntity(this);
   }

   public String toString() {
      return AppContentCardEntity.method_3706(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentCardEntity)this.method_1689()).writeToParcel(var1, var2);
   }
}
