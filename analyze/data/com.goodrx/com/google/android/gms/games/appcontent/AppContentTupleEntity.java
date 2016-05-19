package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntityCreator;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
   public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
   private final String mName;
   private final String mValue;
   private final int mVersionCode;

   AppContentTupleEntity(int var1, String var2, String var3) {
      this.mVersionCode = var1;
      this.mName = var2;
      this.mValue = var3;
   }

   public AppContentTupleEntity(AppContentTuple var1) {
      this.mVersionCode = 1;
      this.mName = var1.getName();
      this.mValue = var1.getValue();
   }

   static int zza(AppContentTuple var0) {
      Object[] var1 = new Object[]{var0.getName(), var0.getValue()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentTuple var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentTuple)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentTuple var3 = (AppContentTuple)var1;
         if(!zzw.equal(var3.getName(), var0.getName()) || !zzw.equal(var3.getValue(), var0.getValue())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentTuple var0) {
      return zzw.zzy(var0).zzg("Name", var0.getName()).zzg("Value", var0.getValue()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwq();
   }

   public String getName() {
      return this.mName;
   }

   public String getValue() {
      return this.mValue;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentTupleEntityCreator.zza(this, var1, var2);
   }

   public AppContentTuple zzwq() {
      return this;
   }
}
