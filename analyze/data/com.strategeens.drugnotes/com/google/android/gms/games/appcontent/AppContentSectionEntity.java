package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntityCreator;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
   public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3863;
   // $FF: renamed from: OH java.lang.String
   private final String field_3864;
   // $FF: renamed from: XK java.lang.String
   private final String field_3865;
   // $FF: renamed from: XQ android.os.Bundle
   private final Bundle field_3866;
   // $FF: renamed from: XR java.lang.String
   private final String field_3867;
   // $FF: renamed from: XY android.net.Uri
   private final Uri field_3868;
   // $FF: renamed from: XZ java.util.ArrayList
   private final ArrayList<AppContentCardEntity> field_3869;
   private final ArrayList<AppContentActionEntity> mActions;
   // $FF: renamed from: vc java.lang.String
   private final String field_3870;

   AppContentSectionEntity(int var1, ArrayList<AppContentActionEntity> var2, Uri var3, ArrayList<AppContentCardEntity> var4, String var5, Bundle var6, String var7, String var8, String var9) {
      this.field_3863 = var1;
      this.mActions = var2;
      this.field_3868 = var3;
      this.field_3869 = var4;
      this.field_3865 = var5;
      this.field_3866 = var6;
      this.field_3867 = var7;
      this.field_3864 = var8;
      this.field_3870 = var9;
   }

   public AppContentSectionEntity(AppContentSection var1) {
      int var2 = 0;
      super();
      this.field_3863 = 1;
      this.field_3868 = var1.method_261();
      this.field_3865 = var1.method_258();
      this.field_3866 = var1.method_259();
      this.field_3867 = var1.method_260();
      this.field_3864 = var1.getTitle();
      this.field_3870 = var1.getType();
      List var3 = var1.getActions();
      int var4 = var3.size();
      this.mActions = new ArrayList(var4);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var3.get(var5)).freeze()));
      }

      List var6 = var1.method_262();
      int var7 = var6.size();

      for(this.field_3869 = new ArrayList(var7); var2 < var7; ++var2) {
         this.field_3869.add((AppContentCardEntity)((AppContentCardEntity)((AppContentCard)var6.get(var2)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentSection) int
   static int method_5103(AppContentSection var0) {
      Object[] var1 = new Object[]{var0.getActions(), var0.method_261(), var0.method_262(), var0.method_258(), var0.method_259(), var0.method_260(), var0.getTitle(), var0.getType()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentSection, java.lang.Object) boolean
   static boolean method_5104(AppContentSection var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentSection)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentSection var3 = (AppContentSection)var1;
         if(!class_336.equal(var3.getActions(), var0.getActions()) || !class_336.equal(var3.method_261(), var0.method_261()) || !class_336.equal(var3.method_262(), var0.method_262()) || !class_336.equal(var3.method_258(), var0.method_258()) || !class_336.equal(var3.method_259(), var0.method_259()) || !class_336.equal(var3.method_260(), var0.method_260()) || !class_336.equal(var3.getTitle(), var0.getTitle()) || !class_336.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentSection) java.lang.String
   static String method_5105(AppContentSection var0) {
      return class_336.method_2312(var0).method_3424("Actions", var0.getActions()).method_3424("BackgroundImageUri", var0.method_261()).method_3424("Cards", var0.method_262()).method_3424("ContentDescription", var0.method_258()).method_3424("ExtraData", var0.method_259()).method_3424("Subtitle", var0.method_260()).method_3424("Title", var0.getTitle()).method_3424("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_5104(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_5106();
   }

   public List<AppContentAction> getActions() {
      return new ArrayList(this.mActions);
   }

   public String getTitle() {
      return this.field_3864;
   }

   public String getType() {
      return this.field_3870;
   }

   public int getVersionCode() {
      return this.field_3863;
   }

   public int hashCode() {
      return method_5103(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_258() {
      return this.field_3865;
   }

   // $FF: renamed from: kP () android.os.Bundle
   public Bundle method_259() {
      return this.field_3866;
   }

   // $FF: renamed from: kQ () java.lang.String
   public String method_260() {
      return this.field_3867;
   }

   // $FF: renamed from: kY () android.net.Uri
   public Uri method_261() {
      return this.field_3868;
   }

   // $FF: renamed from: kZ () java.util.List
   public List<AppContentCard> method_262() {
      return new ArrayList(this.field_3869);
   }

   // $FF: renamed from: la () com.google.android.gms.games.appcontent.AppContentSection
   public AppContentSection method_5106() {
      return this;
   }

   public String toString() {
      return method_5105(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentSectionEntityCreator.method_3439(this, var1, var2);
   }
}
