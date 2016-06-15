package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentTuple;
import com.google.android.gms.games.appcontent.AppContentTupleEntityCreator;
import com.google.android.gms.internal.class_336;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
   public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
   // $FF: renamed from: CK int
   private final int field_966;
   private final String mName;
   private final String mValue;

   AppContentTupleEntity(int var1, String var2, String var3) {
      this.field_966 = var1;
      this.mName = var2;
      this.mValue = var3;
   }

   public AppContentTupleEntity(AppContentTuple var1) {
      this.field_966 = 1;
      this.mName = var1.getName();
      this.mValue = var1.getValue();
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentTuple) int
   static int method_2350(AppContentTuple var0) {
      Object[] var1 = new Object[]{var0.getName(), var0.getValue()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentTuple, java.lang.Object) boolean
   static boolean method_2351(AppContentTuple var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentTuple)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentTuple var3 = (AppContentTuple)var1;
         if(!class_336.equal(var3.getName(), var0.getName()) || !class_336.equal(var3.getValue(), var0.getValue())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentTuple) java.lang.String
   static String method_2352(AppContentTuple var0) {
      return class_336.method_2312(var0).method_3424("Name", var0.getName()).method_3424("Value", var0.getValue()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_2351(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_2353();
   }

   public String getName() {
      return this.mName;
   }

   public String getValue() {
      return this.mValue;
   }

   public int getVersionCode() {
      return this.field_966;
   }

   public int hashCode() {
      return method_2350(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: ld () com.google.android.gms.games.appcontent.AppContentTuple
   public AppContentTuple method_2353() {
      return this;
   }

   public String toString() {
      return method_2352(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentTupleEntityCreator.method_2876(this, var1, var2);
   }
}
