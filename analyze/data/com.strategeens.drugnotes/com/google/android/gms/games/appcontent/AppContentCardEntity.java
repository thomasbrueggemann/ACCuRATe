package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntityCreator;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import com.google.android.gms.internal.class_336;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
   public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
   // $FF: renamed from: CK int
   private final int field_2802;
   // $FF: renamed from: OH java.lang.String
   private final String field_2803;
   // $FF: renamed from: UO java.lang.String
   private final String field_2804;
   // $FF: renamed from: WD android.net.Uri
   private final Uri field_2805;
   // $FF: renamed from: XJ java.util.ArrayList
   private final ArrayList<AppContentConditionEntity> field_2806;
   // $FF: renamed from: XK java.lang.String
   private final String field_2807;
   // $FF: renamed from: XN android.net.Uri
   private final Uri field_2808;
   // $FF: renamed from: XO java.util.ArrayList
   private final ArrayList<AppContentAnnotationEntity> field_2809;
   // $FF: renamed from: XP int
   private final int field_2810;
   // $FF: renamed from: XQ android.os.Bundle
   private final Bundle field_2811;
   // $FF: renamed from: XR java.lang.String
   private final String field_2812;
   // $FF: renamed from: XS int
   private final int field_2813;
   private final ArrayList<AppContentActionEntity> mActions;
   // $FF: renamed from: vc java.lang.String
   private final String field_2814;

   AppContentCardEntity(int var1, ArrayList<AppContentActionEntity> var2, ArrayList<AppContentAnnotationEntity> var3, ArrayList<AppContentConditionEntity> var4, String var5, int var6, String var7, Bundle var8, Uri var9, Uri var10, String var11, String var12, int var13, String var14) {
      this.field_2802 = var1;
      this.mActions = var2;
      this.field_2809 = var3;
      this.field_2806 = var4;
      this.field_2807 = var5;
      this.field_2810 = var6;
      this.field_2804 = var7;
      this.field_2811 = var8;
      this.field_2805 = var9;
      this.field_2808 = var10;
      this.field_2812 = var11;
      this.field_2803 = var12;
      this.field_2813 = var13;
      this.field_2814 = var14;
   }

   public AppContentCardEntity(AppContentCard var1) {
      int var2 = 0;
      super();
      this.field_2802 = 1;
      this.field_2807 = var1.method_235();
      this.field_2810 = var1.method_238();
      this.field_2804 = var1.getDescription();
      this.field_2811 = var1.method_239();
      this.field_2805 = var1.getIconImageUri();
      this.field_2808 = var1.method_236();
      this.field_2803 = var1.getTitle();
      this.field_2812 = var1.method_240();
      this.field_2813 = var1.method_241();
      this.field_2814 = var1.getType();
      List var3 = var1.getActions();
      int var4 = var3.size();
      this.mActions = new ArrayList(var4);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var3.get(var5)).freeze()));
      }

      List var6 = var1.method_237();
      int var7 = var6.size();
      this.field_2809 = new ArrayList(var7);

      for(int var8 = 0; var8 < var7; ++var8) {
         this.field_2809.add((AppContentAnnotationEntity)((AppContentAnnotationEntity)((AppContentAnnotation)var6.get(var8)).freeze()));
      }

      List var9 = var1.method_234();
      int var10 = var9.size();

      for(this.field_2806 = new ArrayList(var10); var2 < var10; ++var2) {
         this.field_2806.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var9.get(var2)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentCard) int
   static int method_3704(AppContentCard var0) {
      Object[] var1 = new Object[]{var0.getActions(), var0.method_237(), var0.method_234(), var0.method_235(), Integer.valueOf(var0.method_238()), var0.getDescription(), var0.method_239(), var0.getIconImageUri(), var0.method_236(), var0.method_240(), var0.getTitle(), Integer.valueOf(var0.method_241()), var0.getType()};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.appcontent.AppContentCard, java.lang.Object) boolean
   static boolean method_3705(AppContentCard var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentCard)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentCard var3 = (AppContentCard)var1;
         if(!class_336.equal(var3.getActions(), var0.getActions()) || !class_336.equal(var3.method_237(), var0.method_237()) || !class_336.equal(var3.method_234(), var0.method_234()) || !class_336.equal(var3.method_235(), var0.method_235()) || !class_336.equal(Integer.valueOf(var3.method_238()), Integer.valueOf(var0.method_238())) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(var3.method_239(), var0.method_239()) || !class_336.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !class_336.equal(var3.method_236(), var0.method_236()) || !class_336.equal(var3.method_240(), var0.method_240()) || !class_336.equal(var3.getTitle(), var0.getTitle()) || !class_336.equal(Integer.valueOf(var3.method_241()), Integer.valueOf(var0.method_241())) || !class_336.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.appcontent.AppContentCard) java.lang.String
   static String method_3706(AppContentCard var0) {
      return class_336.method_2312(var0).method_3424("Actions", var0.getActions()).method_3424("Annotations", var0.method_237()).method_3424("Conditions", var0.method_234()).method_3424("ContentDescription", var0.method_235()).method_3424("CurrentSteps", Integer.valueOf(var0.method_238())).method_3424("Description", var0.getDescription()).method_3424("ExtraData", var0.method_239()).method_3424("IconImageUri", var0.getIconImageUri()).method_3424("ImageUri", var0.method_236()).method_3424("Subtitle", var0.method_240()).method_3424("Title", var0.getTitle()).method_3424("TotalSteps", Integer.valueOf(var0.method_241())).method_3424("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3705(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.method_3707();
   }

   public List<AppContentAction> getActions() {
      return new ArrayList(this.mActions);
   }

   public String getDescription() {
      return this.field_2804;
   }

   public Uri getIconImageUri() {
      return this.field_2805;
   }

   public String getTitle() {
      return this.field_2803;
   }

   public String getType() {
      return this.field_2814;
   }

   public int getVersionCode() {
      return this.field_2802;
   }

   public int hashCode() {
      return method_3704(this);
   }

   public boolean isDataValid() {
      return true;
   }

   // $FF: renamed from: kH () java.util.List
   public List<AppContentCondition> method_234() {
      return new ArrayList(this.field_2806);
   }

   // $FF: renamed from: kI () java.lang.String
   public String method_235() {
      return this.field_2807;
   }

   // $FF: renamed from: kL () android.net.Uri
   public Uri method_236() {
      return this.field_2808;
   }

   // $FF: renamed from: kN () java.util.List
   public List<AppContentAnnotation> method_237() {
      return new ArrayList(this.field_2809);
   }

   // $FF: renamed from: kO () int
   public int method_238() {
      return this.field_2810;
   }

   // $FF: renamed from: kP () android.os.Bundle
   public Bundle method_239() {
      return this.field_2811;
   }

   // $FF: renamed from: kQ () java.lang.String
   public String method_240() {
      return this.field_2812;
   }

   // $FF: renamed from: kR () int
   public int method_241() {
      return this.field_2813;
   }

   // $FF: renamed from: kS () com.google.android.gms.games.appcontent.AppContentCard
   public AppContentCard method_3707() {
      return this;
   }

   public String toString() {
      return method_3706(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AppContentCardEntityCreator.method_5112(this, var1, var2);
   }
}
