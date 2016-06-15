package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
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
      return AppContentActionEntity.method_4901(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1688();
   }

   public Bundle getExtras() {
      return AppContentUtils.method_1647(this.JG, this.XX, "action_data", this.KZ);
   }

   public String getLabel() {
      return this.getString("action_label");
   }

   public String getType() {
      return this.getString("action_type");
   }

   public int hashCode() {
      return AppContentActionEntity.method_4900(this);
   }

   // $FF: renamed from: kH () java.util.List
   public List<AppContentCondition> method_226() {
      return AppContentUtils.method_1646(this.JG, this.XX, "action_conditions", this.KZ);
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_227() {
      return this.getString("action_content_description");
   }

   // $FF: renamed from: kJ () java.lang.String
   public String method_228() {
      return this.getString("action_label_style");
   }

   // $FF: renamed from: kK () com.google.android.gms.games.appcontent.AppContentAction
   public AppContentAction method_1688() {
      return new AppContentActionEntity(this);
   }

   public String toString() {
      return AppContentActionEntity.method_4902(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentActionEntity)this.method_1688()).writeToParcel(var1, var2);
   }
}
