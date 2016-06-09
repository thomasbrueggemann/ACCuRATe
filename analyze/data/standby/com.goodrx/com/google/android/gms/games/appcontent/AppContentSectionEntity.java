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
import com.google.android.gms.games.appcontent.AppContentCardEntity;
import com.google.android.gms.games.appcontent.AppContentSection;
import com.google.android.gms.games.appcontent.AppContentSectionEntityCreator;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
   public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
   private final ArrayList<AppContentActionEntity> mActions;
   private final Bundle mExtras;
   private final int mVersionCode;
   private final String zzJN;
   private final ArrayList<AppContentAnnotationEntity> zzaDF;
   private final String zzaDH;
   private final ArrayList<AppContentCardEntity> zzaDO;
   private final String zzaDP;
   private final String zzaDw;
   private final String zzapg;
   private final String zzyv;

   AppContentSectionEntity(int var1, ArrayList<AppContentActionEntity> var2, ArrayList<AppContentCardEntity> var3, String var4, Bundle var5, String var6, String var7, String var8, String var9, String var10, ArrayList<AppContentAnnotationEntity> var11) {
      this.mVersionCode = var1;
      this.mActions = var2;
      this.zzaDF = var11;
      this.zzaDO = var3;
      this.zzaDP = var10;
      this.zzaDw = var4;
      this.mExtras = var5;
      this.zzyv = var9;
      this.zzaDH = var6;
      this.zzapg = var7;
      this.zzJN = var8;
   }

   public AppContentSectionEntity(AppContentSection var1) {
      int var2 = 0;
      super();
      this.mVersionCode = 5;
      this.zzaDP = var1.zzwl();
      this.zzaDw = var1.zzvQ();
      this.mExtras = var1.getExtras();
      this.zzyv = var1.getId();
      this.zzaDH = var1.zzwc();
      this.zzapg = var1.getTitle();
      this.zzJN = var1.getType();
      List var3 = var1.getActions();
      int var4 = var3.size();
      this.mActions = new ArrayList(var4);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.mActions.add((AppContentActionEntity)((AppContentActionEntity)((AppContentAction)var3.get(var5)).freeze()));
      }

      List var6 = var1.zzwk();
      int var7 = var6.size();
      this.zzaDO = new ArrayList(var7);

      for(int var8 = 0; var8 < var7; ++var8) {
         this.zzaDO.add((AppContentCardEntity)((AppContentCardEntity)((AppContentCard)var6.get(var8)).freeze()));
      }

      List var9 = var1.zzwa();
      int var10 = var9.size();

      for(this.zzaDF = new ArrayList(var10); var2 < var10; ++var2) {
         this.zzaDF.add((AppContentAnnotationEntity)((AppContentAnnotationEntity)((AppContentAnnotation)var9.get(var2)).freeze()));
      }

   }

   static int zza(AppContentSection var0) {
      Object[] var1 = new Object[]{var0.getActions(), var0.zzwa(), var0.zzwk(), var0.zzwl(), var0.zzvQ(), var0.getExtras(), var0.getId(), var0.zzwc(), var0.getTitle(), var0.getType()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentSection var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentSection)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentSection var3 = (AppContentSection)var1;
         if(!zzw.equal(var3.getActions(), var0.getActions()) || !zzw.equal(var3.zzwa(), var0.zzwa()) || !zzw.equal(var3.zzwk(), var0.zzwk()) || !zzw.equal(var3.zzwl(), var0.zzwl()) || !zzw.equal(var3.zzvQ(), var0.zzvQ()) || !zzw.equal(var3.getExtras(), var0.getExtras()) || !zzw.equal(var3.getId(), var0.getId()) || !zzw.equal(var3.zzwc(), var0.zzwc()) || !zzw.equal(var3.getTitle(), var0.getTitle()) || !zzw.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentSection var0) {
      return zzw.zzy(var0).zzg("Actions", var0.getActions()).zzg("Annotations", var0.zzwa()).zzg("Cards", var0.zzwk()).zzg("CardType", var0.zzwl()).zzg("ContentDescription", var0.zzvQ()).zzg("Extras", var0.getExtras()).zzg("Id", var0.getId()).zzg("Subtitle", var0.zzwc()).zzg("Title", var0.getTitle()).zzg("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzwm();
   }

   public List<AppContentAction> getActions() {
      return new ArrayList(this.mActions);
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
      AppContentSectionEntityCreator.zza(this, var1, var2);
   }

   public String zzvQ() {
      return this.zzaDw;
   }

   public List<AppContentAnnotation> zzwa() {
      return new ArrayList(this.zzaDF);
   }

   public String zzwc() {
      return this.zzaDH;
   }

   public List<AppContentCard> zzwk() {
      return new ArrayList(this.zzaDO);
   }

   public String zzwl() {
      return this.zzaDP;
   }

   public AppContentSection zzwm() {
      return this;
   }
}
