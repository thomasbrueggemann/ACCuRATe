package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_251;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public final class AppContentTupleRef extends class_251 implements AppContentTuple {
   AppContentTupleRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentTupleEntity.method_2351(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_1694();
   }

   public String getName() {
      return this.getString("tuple_name");
   }

   public String getValue() {
      return this.getString("tuple_value");
   }

   public int hashCode() {
      return AppContentTupleEntity.method_2350(this);
   }

   // $FF: renamed from: ld () com.google.android.gms.games.appcontent.AppContentTuple
   public AppContentTuple method_1694() {
      return new AppContentTupleEntity(this);
   }

   public String toString() {
      return AppContentTupleEntity.method_2352(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentTupleEntity)this.method_1694()).writeToParcel(var1, var2);
   }
}
