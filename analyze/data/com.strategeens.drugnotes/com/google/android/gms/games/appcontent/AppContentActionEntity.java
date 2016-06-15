package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntityCreator;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
   public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3738;
   // $FF: renamed from: XJ java.util.ArrayList
   private final ArrayList<AppContentConditionEntity> field_3739;
   // $FF: renamed from: XK java.lang.String
   private final String field_3740;
   // $FF: renamed from: XL java.lang.String
   private final String field_3741;
   // $FF: renamed from: XM java.lang.String
   private final String field_3742;
   private final Bundle mExtras;
   // $FF: renamed from: vc java.lang.String
   private final String field_3743;

   AppContentActionEntity(int var1, ArrayList<AppContentConditionEntity> var2, String var3, Bundle var4, String var5, String var6, String var7) {
      this.field_3738 = var1;
      this.field_3739 = var2;
      this.field_3740 = var3;
      this.mExtras = var4;
      this.field_3741 = var5;
      this.field_3742 = var6;
      this.field_3743 = var7;
   }

   public AppContentActionEntity(AppContentAction var1) {
      this.field_3738 = 1;
      this.field_3740 = var1.method_227();
      this.mExtras = var1.getExtras();
      this.field_3741 = var1.getLabel();
      this.field_3742 = var1.method_228();
      this.field_3743 = var1.getType();
      List var2 = var1.method_226();
      int var3 = var2.size();
      this.field_3739 = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field_3739.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var2.get(var4)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentAction) int
   static int method_4900(AppContentAction var0) {
      Object[] var1 = new Object[]{var0.method_226(), var0.method_227(), var0.getExtras(), var0.getLabel(), var0.method_228(), var0.getType()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentAction, java.lang.Object) boolean
   static boolean method_4901(AppContentAction var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentAction)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentAction var3 = (AppContentAction)var1;
         if(!class_336.equal(var3.method_226(), var0.method_226()) || !class_336.equal(var3.method_227(), var0.method_227()) || !class_336.equal(var3.getExtras(), var0.getExtras()) || !class_336.equal(var3.getLabel(), var0.getLabel()) || !class_336.equal(var3.method_228(), var0.method_228()) || !class_336.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentAction) java.lang.String
   static String method_4902(AppContentAction var0) {
      return class_336.method_2312(var0).method_3424("Conditions", var0.method_226()).method_3424("ContentDescription", var0.method_227()).method_3424("Extras", var0.getExtras()).method_3424("Label", var0.getLabel()).method_3424("LabelStyle", var0.method_228()).method_3424("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4901(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_4903();
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public String getLabel() {
      return this.field_3741;
   }

   public String getType() {
      return this.field_3743;
   }

   public int getVersionCode() {
      return this.field_3738;
   }

   public int hashCode() {
      return method_4900(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kH () java.util.List
   public List<AppContentCondition> method_226() {
      return new ArrayList(this.field_3739);
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_227() {
      return this.field_3740;
   }

   // $FF: renamed from: kJ () java.lang.String
   public String method_228() {
      return this.field_3742;
   }

   // $FF: renamed from: kK () com.google.android.gms.games.appcontent.AppContentAction
   public AppContentAction method_4903() {
      return this;
   }

   public String toString() {
      return method_4902(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentActionEntityCreator.method_3774(this, var1, var2);
   }
}
