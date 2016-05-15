package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
   AppContentActionRef(ArrayList<DataHolder> var1, int var2) {
      super(var1, 1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentActionEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzvS();
   }

   public Bundle getExtras() {
      return AppContentUtils.zzd(this.zzahi, this.zzaDN, "action_data", this.zzaje);
   }

   public String getId() {
      return this.getString("action_id");
   }

   public String getType() {
      return this.getString("action_type");
   }

   public int hashCode() {
      return AppContentActionEntity.zza(this);
   }

   public String toString() {
      return AppContentActionEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentActionEntity)this.zzvS()).writeToParcel(var1, var2);
   }

   public AppContentAnnotation zzvO() {
      ArrayList var1 = AppContentUtils.zzb(this.zzahi, this.zzaDN, "action_annotation", this.zzaje);
      return var1.size() == 1?(AppContentAnnotation)var1.get(0):null;
   }

   public List<AppContentCondition> zzvP() {
      return AppContentUtils.zzc(this.zzahi, this.zzaDN, "action_conditions", this.zzaje);
   }

   public String zzvQ() {
      return this.getString("action_content_description");
   }

   public String zzvR() {
      return this.getString("overflow_text");
   }

   public AppContentAction zzvS() {
      return new AppContentActionEntity(this);
   }
}
