package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntity;

public final class AppContentTupleRef extends zzc implements AppContentTuple {
   AppContentTupleRef(DataHolder var1, int var2) {
      super(var1, var2);
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return AppContentTupleEntity.zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwq();
   }

   public String getName() {
      return this.getString("tuple_name");
   }

   public String getValue() {
      return this.getString("tuple_value");
   }

   public int hashCode() {
      return AppContentTupleEntity.zza(this);
   }

   public String toString() {
      return AppContentTupleEntity.zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((AppContentTupleEntity)this.zzwq()).writeToParcel(var1, var2);
   }

   public AppContentTuple zzwq() {
      return new AppContentTupleEntity(this);
   }
}
