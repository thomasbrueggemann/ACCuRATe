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
      return AppContentConditionEntity.method_5506(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1691();
   }

   public int hashCode() {
      return AppContentConditionEntity.method_5505(this);
   }

   // $FF: renamed from: kT () java.lang.String
   public String method_242() {
      return this.getString("condition_default_value");
   }

   // $FF: renamed from: kU () java.lang.String
   public String method_243() {
      return this.getString("condition_expected_value");
   }

   // $FF: renamed from: kV () java.lang.String
   public String method_244() {
      return this.getString("condition_predicate");
   }

   // $FF: renamed from: kW () android.os.Bundle
   public Bundle method_245() {
      return AppContentUtils.method_1647(this.JG, this.XX, "condition_predicate_parameters", this.KZ);
   }

   // $FF: renamed from: kX () com.google.android.gms.games.appcontent.AppContentCondition
   public AppContentCondition method_1691() {
      return new AppContentConditionEntity(this);
   }

   public String toString() {
      return AppContentConditionEntity.method_5507(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentConditionEntity)this.method_1691()).writeToParcel(var1, var2);
   }
}
