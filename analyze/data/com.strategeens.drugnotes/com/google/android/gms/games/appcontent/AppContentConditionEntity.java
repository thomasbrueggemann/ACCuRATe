package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntityCreator;
import com.google.android.gms.internal.class_336;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
   public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
   // $FF: renamed from: CK int
   private final int field_4264;
   // $FF: renamed from: XT java.lang.String
   private final String field_4265;
   // $FF: renamed from: XU java.lang.String
   private final String field_4266;
   // $FF: renamed from: XV java.lang.String
   private final String field_4267;
   // $FF: renamed from: XW android.os.Bundle
   private final Bundle field_4268;

   AppContentConditionEntity(int var1, String var2, String var3, String var4, Bundle var5) {
      this.field_4264 = var1;
      this.field_4265 = var2;
      this.field_4266 = var3;
      this.field_4267 = var4;
      this.field_4268 = var5;
   }

   public AppContentConditionEntity(AppContentCondition var1) {
      this.field_4264 = 1;
      this.field_4265 = var1.method_242();
      this.field_4266 = var1.method_242();
      this.field_4267 = var1.method_244();
      this.field_4268 = var1.method_245();
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentCondition) int
   static int method_5505(AppContentCondition var0) {
      Object[] var1 = new Object[]{var0.method_242(), var0.method_243(), var0.method_244(), var0.method_245()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentCondition, java.lang.Object) boolean
   static boolean method_5506(AppContentCondition var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentCondition)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentCondition var3 = (AppContentCondition)var1;
         if(!class_336.equal(var3.method_242(), var0.method_242()) || !class_336.equal(var3.method_243(), var0.method_243()) || !class_336.equal(var3.method_244(), var0.method_244()) || !class_336.equal(var3.method_245(), var0.method_245())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentCondition) java.lang.String
   static String method_5507(AppContentCondition var0) {
      return class_336.method_2312(var0).method_3424("DefaultValue", var0.method_242()).method_3424("ExpectedValue", var0.method_243()).method_3424("Predicate", var0.method_244()).method_3424("PredicateParameters", var0.method_245()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_5506(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5508();
   }

   public int getVersionCode() {
      return this.field_4264;
   }

   public int hashCode() {
      return method_5505(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kT () java.lang.String
   public String method_242() {
      return this.field_4265;
   }

   // $FF: renamed from: kU () java.lang.String
   public String method_243() {
      return this.field_4266;
   }

   // $FF: renamed from: kV () java.lang.String
   public String method_244() {
      return this.field_4267;
   }

   // $FF: renamed from: kW () android.os.Bundle
   public Bundle method_245() {
      return this.field_4268;
   }

   // $FF: renamed from: kX () com.google.android.gms.games.appcontent.AppContentCondition
   public AppContentCondition method_5508() {
      return this;
   }

   public String toString() {
      return method_5507(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentConditionEntityCreator.method_3421(this, var1, var2);
   }
}
