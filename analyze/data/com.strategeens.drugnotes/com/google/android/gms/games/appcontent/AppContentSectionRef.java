package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardRef;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
   // $FF: renamed from: Ya int
   private final int field_541;

   AppContentSectionRef(ArrayList<DataHolder> var1, int var2, int var3) {
      super(var1, 0, var2);
      this.field_541 = var3;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentSectionEntity.method_5104(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1685();
   }

   // $FF: synthetic method
   public List getActions() {
      return this.method_1686();
   }

   public String getTitle() {
      return this.getString("section_title");
   }

   public String getType() {
      return this.getString("section_type");
   }

   public int hashCode() {
      return AppContentSectionEntity.method_5103(this);
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_258() {
      return this.getString("section_content_description");
   }

   // $FF: renamed from: kP () android.os.Bundle
   public Bundle method_259() {
      return AppContentUtils.method_1647(this.JG, this.XX, "section_data", this.KZ);
   }

   // $FF: renamed from: kQ () java.lang.String
   public String method_260() {
      return this.getString("section_subtitle");
   }

   // $FF: renamed from: kY () android.net.Uri
   public Uri method_261() {
      return this.aR("section_background_image_uri");
   }

   // $FF: renamed from: kZ () java.util.List
   // $FF: synthetic method
   public List method_262() {
      return this.method_1687();
   }

   // $FF: renamed from: la () com.google.android.gms.games.appcontent.AppContentSection
   public AppContentSection method_1685() {
      return new AppContentSectionEntity(this);
   }

   // $FF: renamed from: lb () java.util.ArrayList
   public ArrayList<AppContentAction> method_1686() {
      return AppContentUtils.method_1643(this.JG, this.XX, "section_actions", this.KZ);
   }

   // $FF: renamed from: lc () java.util.ArrayList
   public ArrayList<AppContentCard> method_1687() {
      ArrayList var1 = new ArrayList(this.field_541);

      for(int var2 = 0; var2 < this.field_541; ++var2) {
         var1.add(new AppContentCardRef(this.XX, var2 + this.KZ));
      }

      return var1;
   }

   public String toString() {
      return AppContentSectionEntity.method_5105(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentSectionEntity)this.method_1685()).writeToParcel(var1, var2);
   }
}
