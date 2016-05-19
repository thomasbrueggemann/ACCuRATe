package com.google.android.gms.games.appcontent;

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
      return AppContentCardEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwe();
   }

   public List<AppContentAction> getActions() {
      return AppContentUtils.zza(this.zzahi, this.zzaDN, "card_actions", this.zzaje);
   }

   public String getDescription() {
      return this.getString("card_description");
   }

   public Bundle getExtras() {
      return AppContentUtils.zzd(this.zzahi, this.zzaDN, "card_data", this.zzaje);
   }

   public String getId() {
      return this.getString("card_id");
   }

   public String getTitle() {
      return this.getString("card_title");
   }

   public String getType() {
      return this.getString("card_type");
   }

   public int hashCode() {
      return AppContentCardEntity.zza(this);
   }

   public String toString() {
      return AppContentCardEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentCardEntity)this.zzwe()).writeToParcel(var1, var2);
   }

   public List<AppContentCondition> zzvP() {
      return AppContentUtils.zzc(this.zzahi, this.zzaDN, "card_conditions", this.zzaje);
   }

   public String zzvQ() {
      return this.getString("card_content_description");
   }

   public List<AppContentAnnotation> zzwa() {
      return AppContentUtils.zzb(this.zzahi, this.zzaDN, "card_annotations", this.zzaje);
   }

   public int zzwb() {
      return this.getInteger("card_current_steps");
   }

   public String zzwc() {
      return this.getString("card_subtitle");
   }

   public int zzwd() {
      return this.getInteger("card_total_steps");
   }

   public AppContentCard zzwe() {
      return new AppContentCardEntity(this);
   }
}
