package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardRef;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
   private final int zzaDQ;

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentSectionEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwm();
   }

   // $FF: synthetic method
   public List getActions() {
      return this.zzwn();
   }

   public Bundle getExtras() {
      return AppContentUtils.zzd(this.zzahi, this.zzaDN, "section_data", this.zzaje);
   }

   public String getId() {
      return this.getString("section_id");
   }

   public String getTitle() {
      return this.getString("section_title");
   }

   public String getType() {
      return this.getString("section_type");
   }

   public int hashCode() {
      return AppContentSectionEntity.zza(this);
   }

   public String toString() {
      return AppContentSectionEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentSectionEntity)this.zzwm()).writeToParcel(var1, var2);
   }

   public String zzvQ() {
      return this.getString("section_content_description");
   }

   // $FF: synthetic method
   public List zzwa() {
      return this.zzwo();
   }

   public String zzwc() {
      return this.getString("section_subtitle");
   }

   // $FF: synthetic method
   public List zzwk() {
      return this.zzwp();
   }

   public String zzwl() {
      return this.getString("section_card_type");
   }

   public AppContentSection zzwm() {
      return new AppContentSectionEntity(this);
   }

   public ArrayList<AppContentAction> zzwn() {
      return AppContentUtils.zza(this.zzahi, this.zzaDN, "section_actions", this.zzaje);
   }

   public ArrayList<AppContentAnnotation> zzwo() {
      return AppContentUtils.zzb(this.zzahi, this.zzaDN, "section_annotations", this.zzaje);
   }

   public ArrayList<AppContentCard> zzwp() {
      ArrayList var1 = new ArrayList(this.zzaDQ);

      for(int var2 = 0; var2 < this.zzaDQ; ++var2) {
         var1.add(new AppContentCardRef(this.zzaDN, var2 + this.zzaje));
      }

      return var1;
   }
}
