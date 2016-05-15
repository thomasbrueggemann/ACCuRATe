package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentActionEntityCreator;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentAnnotationEntity;
import com.google.android.gms.games.appcontent.AppContentCondition;
import com.google.android.gms.games.appcontent.AppContentConditionEntity;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
   public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
   private final Bundle mExtras;
   private final int mVersionCode;
   private final String zzJN;
   private final ArrayList<AppContentConditionEntity> zzaDv;
   private final String zzaDw;
   private final AppContentAnnotationEntity zzaDx;
   private final String zzaDy;
   private final String zzyv;

   AppContentActionEntity(int var1, ArrayList<AppContentConditionEntity> var2, String var3, Bundle var4, String var5, String var6, AppContentAnnotationEntity var7, String var8) {
      this.mVersionCode = var1;
      this.zzaDx = var7;
      this.zzaDv = var2;
      this.zzaDw = var3;
      this.mExtras = var4;
      this.zzyv = var6;
      this.zzaDy = var8;
      this.zzJN = var5;
   }

   public AppContentActionEntity(AppContentAction var1) {
      this.mVersionCode = 5;
      this.zzaDx = (AppContentAnnotationEntity)var1.zzvO().freeze();
      this.zzaDw = var1.zzvQ();
      this.mExtras = var1.getExtras();
      this.zzyv = var1.getId();
      this.zzaDy = var1.zzvR();
      this.zzJN = var1.getType();
      List var2 = var1.zzvP();
      int var3 = var2.size();
      this.zzaDv = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.zzaDv.add((AppContentConditionEntity)((AppContentConditionEntity)((AppContentCondition)var2.get(var4)).freeze()));
      }

   }

   static int zza(AppContentAction var0) {
      Object[] var1 = new Object[]{var0.zzvO(), var0.zzvP(), var0.zzvQ(), var0.getExtras(), var0.getId(), var0.zzvR(), var0.getType()};
      return zzw.hashCode(var1);
   }

   static boolean zza(AppContentAction var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof AppContentAction)) {
         var2 = false;
      } else if(var0 != var1) {
         AppContentAction var3 = (AppContentAction)var1;
         if(!zzw.equal(var3.zzvO(), var0.zzvO()) || !zzw.equal(var3.zzvP(), var0.zzvP()) || !zzw.equal(var3.zzvQ(), var0.zzvQ()) || !zzw.equal(var3.getExtras(), var0.getExtras()) || !zzw.equal(var3.getId(), var0.getId()) || !zzw.equal(var3.zzvR(), var0.zzvR()) || !zzw.equal(var3.getType(), var0.getType())) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(AppContentAction var0) {
      return zzw.zzy(var0).zzg("Annotation", var0.zzvO()).zzg("Conditions", var0.zzvP()).zzg("ContentDescription", var0.zzvQ()).zzg("Extras", var0.getExtras()).zzg("Id", var0.getId()).zzg("OverflowText", var0.zzvR()).zzg("Type", var0.getType()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   // $FF: synthetic method
   public Object freeze() {
      return this.zzvS();
   }

   public Bundle getExtras() {
      return this.mExtras;
   }

   public String getId() {
      return this.zzyv;
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
      AppContentActionEntityCreator.zza(this, var1, var2);
   }

   public AppContentAnnotation zzvO() {
      return this.zzaDx;
   }

   public List<AppContentCondition> zzvP() {
      return new ArrayList(this.zzaDv);
   }

   public String zzvQ() {
      return this.zzaDw;
   }

   public String zzvR() {
      return this.zzaDy;
   }

   public AppContentAction zzvS() {
      return this;
   }
}
