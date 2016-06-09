package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntity;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCard;
import com.google.android.gms.games.appcontent.AppContentCardEntityCreator;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
   public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
   private final ArrayList<AppContentActionEntity> mActions;
   private final Bundle mExtras;
   private final int mVersionCode;
   private final String zzJN;
   private final ArrayList<AppContentAnnotationEntity> zzaDF;
   private final int zzaDG;
   private final String zzaDH;
   private final int zzaDI;
   private final ArrayList<AppContentConditionEntity> zzaDv;
   private final String zzaDw;
   private final String zzapg;
   private final String zzaxl;
   private final String zzyv;

   AppContentCardEntity(int var1, ArrayList<AppContentActionEntity> var2, ArrayList<AppContentAnnotationEntity> var3, ArrayList<AppContentConditionEntity> var4, String var5, int var6, String var7, Bundle var8, String var9, String var10, int var11, String var12, String var13) {
      this.mVersionCode = var1;
      this.mActions = var2;
      this.zzaDF = var3;
      this.zzaDv = var4;
      this.zzaDw = var5;
      this.zzaDG = var6;
      this.zzaxl = var7;
      this.mExtras = var8;
      this.zzyv = var13;
      this.zzaDH = var9;
      this.zzapg = var10;
      this.zzaDI = var11;
      this.zzJN = var12;
   }

   public AppContentCardEntity(AppContentCard var1) {
      int var2 = 0;
      super();
      this.mVersionCode = 4;
      this.zzaDw = var1.zzvQ();
      this.zzaDG = var1.zzwb();
      this.zzaxl = var1.getDescription();
      this.mExtras = var1.getExtras();
      this.zzyv = var1.getId();
      this.zzapg = var1.getTitle();
      this.zzaDH = var1.zzwc();
      this.zzaDI = var1.zzwd();
      this.zzJN = var1.getType();
      List var3 = var1.getActions();
      int var4 = var3.size();
      this.mActions = new ArrayList(var4);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var3.get(var5)).freeze()));
      }

      List var6 = var1.zzwa();
      int var7 = var6.size();
      this.zzaDF = new ArrayList(var7);

      for(int var8 = 0; var8 < var7; ++var8) {
         this.zzaDF.add((AppContentAnnotationEntity)((AppContentAnnotationEntity)((AppContentAnnotation)var6.get(var8)).freeze()));
      }

      List var9 = var1.zzvP();
      int var10 = var9.size();

      for(this.zzaDv = new ArrayList(var10); var2 < var10; ++var2) {
         this.zzaDv.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var9.get(var2)).freeze()));
      }

   }

   static int zza(AppContentCard var0) {
      Object[] var1 = new Object[]{var0.getActions(), var0.zzwa(), var0.zzvP(), var0.zzvQ(), Integer.valueOf(var0.zzwb()), var0.getDescription(), var0.getExtras(), var0.getId(), var0.zzwc(), var0.getTitle(), Integer.valueOf(var0.zzwd()), var0.getType()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentCard var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentCard)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentCard var3 = (AppContentCard)var1;
         if(!zzw.equal(var3.getActions(), var0.getActions()) || !zzw.equal(var3.zzwa(), var0.zzwa()) || !zzw.equal(var3.zzvP(), var0.zzvP()) || !zzw.equal(var3.zzvQ(), var0.zzvQ()) || !zzw.equal(Integer.valueOf(var3.zzwb()), Integer.valueOf(var0.zzwb())) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(var3.getExtras(), var0.getExtras()) || !zzw.equal(var3.getId(), var0.getId()) || !zzw.equal(var3.zzwc(), var0.zzwc()) || !zzw.equal(var3.getTitle(), var0.getTitle()) || !zzw.equal(Integer.valueOf(var3.zzwd()), Integer.valueOf(var0.zzwd())) || !zzw.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentCard var0) {
      return zzw.zzy(var0).zzg("Actions", var0.getActions()).zzg("Annotations", var0.zzwa()).zzg("Conditions", var0.zzvP()).zzg("ContentDescription", var0.zzvQ()).zzg("CurrentSteps", Integer.valueOf(var0.zzwb())).zzg("Description", var0.getDescription()).zzg("Extras", var0.getExtras()).zzg("Id", var0.getId()).zzg("Subtitle", var0.zzwc()).zzg("Title", var0.getTitle()).zzg("TotalSteps", Integer.valueOf(var0.zzwd())).zzg("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwe();
   }

   public List<AppContentAction> getActions() {
      return new ArrayList(this.mActions);
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public String getId() {
      return this.zzyv;
   }

   public String getTitle() {
      return this.zzapg;
   }

   public String getType() {
      return this.zzJN;
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
      AppContentCardEntityCreator.zza(this, var1, var2);
   }

   public List<AppContentCondition> zzvP() {
      return new ArrayList(this.zzaDv);
   }

   public String zzvQ() {
      return this.zzaDw;
   }

   public List<AppContentAnnotation> zzwa() {
      return new ArrayList(this.zzaDF);
   }

   public int zzwb() {
      return this.zzaDG;
   }

   public String zzwc() {
      return this.zzaDH;
   }

   public int zzwd() {
      return this.zzaDI;
   }

   public AppContentCard zzwe() {
      return this;
   }
}
