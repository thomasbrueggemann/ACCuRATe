package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.games.appcontent.AppContentUtils;
import com.google.android.gms.games.appcontent.MultiDataBufferRef;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
   AppContentConditionRef(ArrayList<DataHolder> var1, int var2) {
      super(var1, 4, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentConditionEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwj();
   }

   public int hashCode() {
      return AppContentConditionEntity.zza(this);
   }

   public String toString() {
      return AppContentConditionEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentConditionEntity)this.zzwj()).writeToParcel(var1, var2);
   }

   public String zzwf() {
      return this.getString("condition_default_value");
   }

   public String zzwg() {
      return this.getString("condition_expected_value");
   }

   public String zzwh() {
      return this.getString("condition_predicate");
   }

   public Bundle zzwi() {
      return AppContentUtils.zzd(this.zzahi, this.zzaDN, "condition_predicate_parameters", this.zzaje);
   }

   public AppContentCondition zzwj() {
      return new AppContentConditionEntity(this);
   }
}
