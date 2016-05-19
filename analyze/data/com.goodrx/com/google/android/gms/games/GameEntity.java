package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntityCreator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
   public static final Creator<GameEntity> CREATOR = new GameEntity.GameEntityCreatorCompat();
   private final int mVersionCode;
   private final boolean zzDZ;
   private final String zzWQ;
   private final String zzZC;
   private final String zzaCa;
   private final String zzaCb;
   private final String zzaCc;
   private final Uri zzaCd;
   private final Uri zzaCe;
   private final Uri zzaCf;
   private final boolean zzaCg;
   private final boolean zzaCh;
   private final String zzaCi;
   private final int zzaCj;
   private final int zzaCk;
   private final int zzaCl;
   private final boolean zzaCm;
   private final boolean zzaCn;
   private final String zzaCo;
   private final String zzaCp;
   private final String zzaCq;
   private final boolean zzaCr;
   private final boolean zzaCs;
   private final String zzaCt;
   private final boolean zzaCu;
   private final String zzaxl;

   GameEntity(int var1, String var2, String var3, String var4, String var5, String var6, String var7, Uri var8, Uri var9, Uri var10, boolean var11, boolean var12, String var13, int var14, int var15, int var16, boolean var17, boolean var18, String var19, String var20, String var21, boolean var22, boolean var23, boolean var24, String var25, boolean var26) {
      this.mVersionCode = var1;
      this.zzZC = var2;
      this.zzWQ = var3;
      this.zzaCa = var4;
      this.zzaCb = var5;
      this.zzaxl = var6;
      this.zzaCc = var7;
      this.zzaCd = var8;
      this.zzaCo = var19;
      this.zzaCe = var9;
      this.zzaCp = var20;
      this.zzaCf = var10;
      this.zzaCq = var21;
      this.zzaCg = var11;
      this.zzaCh = var12;
      this.zzaCi = var13;
      this.zzaCj = var14;
      this.zzaCk = var15;
      this.zzaCl = var16;
      this.zzaCm = var17;
      this.zzaCn = var18;
      this.zzDZ = var22;
      this.zzaCr = var23;
      this.zzaCs = var24;
      this.zzaCt = var25;
      this.zzaCu = var26;
   }

   public GameEntity(Game var1) {
      this.mVersionCode = 7;
      this.zzZC = var1.getApplicationId();
      this.zzaCa = var1.getPrimaryCategory();
      this.zzaCb = var1.getSecondaryCategory();
      this.zzaxl = var1.getDescription();
      this.zzaCc = var1.getDeveloperName();
      this.zzWQ = var1.getDisplayName();
      this.zzaCd = var1.getIconImageUri();
      this.zzaCo = var1.getIconImageUrl();
      this.zzaCe = var1.getHiResImageUri();
      this.zzaCp = var1.getHiResImageUrl();
      this.zzaCf = var1.getFeaturedImageUri();
      this.zzaCq = var1.getFeaturedImageUrl();
      this.zzaCg = var1.zzvx();
      this.zzaCh = var1.zzvz();
      this.zzaCi = var1.zzvA();
      this.zzaCj = var1.zzvB();
      this.zzaCk = var1.getAchievementTotalCount();
      this.zzaCl = var1.getLeaderboardCount();
      this.zzaCm = var1.isRealTimeMultiplayerEnabled();
      this.zzaCn = var1.isTurnBasedMultiplayerEnabled();
      this.zzDZ = var1.isMuted();
      this.zzaCr = var1.zzvy();
      this.zzaCs = var1.areSnapshotsEnabled();
      this.zzaCt = var1.getThemeColor();
      this.zzaCu = var1.hasGamepadSupport();
   }

   static int zza(Game var0) {
      Object[] var1 = new Object[]{var0.getApplicationId(), var0.getDisplayName(), var0.getPrimaryCategory(), var0.getSecondaryCategory(), var0.getDescription(), var0.getDeveloperName(), var0.getIconImageUri(), var0.getHiResImageUri(), var0.getFeaturedImageUri(), Boolean.valueOf(var0.zzvx()), Boolean.valueOf(var0.zzvz()), var0.zzvA(), Integer.valueOf(var0.zzvB()), Integer.valueOf(var0.getAchievementTotalCount()), Integer.valueOf(var0.getLeaderboardCount()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(var0.isMuted()), Boolean.valueOf(var0.zzvy()), Boolean.valueOf(var0.areSnapshotsEnabled()), var0.getThemeColor(), Boolean.valueOf(var0.hasGamepadSupport())};
      return zzw.hashCode(var1);
   }

   static boolean zza(Game var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Game)) {
         var2 = false;
      } else if(var0 != var1) {
         Game var3 = (Game)var1;
         if(zzw.equal(var3.getApplicationId(), var0.getApplicationId()) && zzw.equal(var3.getDisplayName(), var0.getDisplayName()) && zzw.equal(var3.getPrimaryCategory(), var0.getPrimaryCategory()) && zzw.equal(var3.getSecondaryCategory(), var0.getSecondaryCategory()) && zzw.equal(var3.getDescription(), var0.getDescription()) && zzw.equal(var3.getDeveloperName(), var0.getDeveloperName()) && zzw.equal(var3.getIconImageUri(), var0.getIconImageUri()) && zzw.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) && zzw.equal(var3.getFeaturedImageUri(), var0.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(var3.zzvx()), Boolean.valueOf(var0.zzvx())) && zzw.equal(Boolean.valueOf(var3.zzvz()), Boolean.valueOf(var0.zzvz())) && zzw.equal(var3.zzvA(), var0.zzvA()) && zzw.equal(Integer.valueOf(var3.zzvB()), Integer.valueOf(var0.zzvB())) && zzw.equal(Integer.valueOf(var3.getAchievementTotalCount()), Integer.valueOf(var0.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(var3.getLeaderboardCount()), Integer.valueOf(var0.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(var3.isRealTimeMultiplayerEnabled()), Boolean.valueOf(var0.isRealTimeMultiplayerEnabled()))) {
            Boolean var4 = Boolean.valueOf(var3.isTurnBasedMultiplayerEnabled());
            boolean var5;
            if(var0.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(var3.isMuted()), Boolean.valueOf(var0.isMuted())) && zzw.equal(Boolean.valueOf(var3.zzvy()), Boolean.valueOf(var0.zzvy()))) {
               var5 = var2;
            } else {
               var5 = false;
            }

            if(zzw.equal(var4, Boolean.valueOf(var5)) && zzw.equal(Boolean.valueOf(var3.areSnapshotsEnabled()), Boolean.valueOf(var0.areSnapshotsEnabled())) && zzw.equal(var3.getThemeColor(), var0.getThemeColor()) && zzw.equal(Boolean.valueOf(var3.hasGamepadSupport()), Boolean.valueOf(var0.hasGamepadSupport()))) {
               return var2;
            }
         }

         return false;
      }

      return var2;
   }

   static String zzb(Game var0) {
      return zzw.zzy(var0).zzg("ApplicationId", var0.getApplicationId()).zzg("DisplayName", var0.getDisplayName()).zzg("PrimaryCategory", var0.getPrimaryCategory()).zzg("SecondaryCategory", var0.getSecondaryCategory()).zzg("Description", var0.getDescription()).zzg("DeveloperName", var0.getDeveloperName()).zzg("IconImageUri", var0.getIconImageUri()).zzg("IconImageUrl", var0.getIconImageUrl()).zzg("HiResImageUri", var0.getHiResImageUri()).zzg("HiResImageUrl", var0.getHiResImageUrl()).zzg("FeaturedImageUri", var0.getFeaturedImageUri()).zzg("FeaturedImageUrl", var0.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(var0.zzvx())).zzg("InstanceInstalled", Boolean.valueOf(var0.zzvz())).zzg("InstancePackageName", var0.zzvA()).zzg("AchievementTotalCount", Integer.valueOf(var0.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(var0.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(var0.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(var0.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(var0.areSnapshotsEnabled())).zzg("ThemeColor", var0.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(var0.hasGamepadSupport())).toString();
   }

   public boolean areSnapshotsEnabled() {
      return this.zzaCs;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Game freeze() {
      return this;
   }

   public int getAchievementTotalCount() {
      return this.zzaCk;
   }

   public String getApplicationId() {
      return this.zzZC;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getDeveloperName() {
      return this.zzaCc;
   }

   public String getDisplayName() {
      return this.zzWQ;
   }

   public Uri getFeaturedImageUri() {
      return this.zzaCf;
   }

   public String getFeaturedImageUrl() {
      return this.zzaCq;
   }

   public Uri getHiResImageUri() {
      return this.zzaCe;
   }

   public String getHiResImageUrl() {
      return this.zzaCp;
   }

   public Uri getIconImageUri() {
      return this.zzaCd;
   }

   public String getIconImageUrl() {
      return this.zzaCo;
   }

   public int getLeaderboardCount() {
      return this.zzaCl;
   }

   public String getPrimaryCategory() {
      return this.zzaCa;
   }

   public String getSecondaryCategory() {
      return this.zzaCb;
   }

   public String getThemeColor() {
      return this.zzaCt;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public boolean hasGamepadSupport() {
      return this.zzaCu;
   }

   public int hashCode() {
      return zza(this);
   }

   public boolean isMuted() {
      return this.zzDZ;
   }

   public boolean isRealTimeMultiplayerEnabled() {
      return this.zzaCm;
   }

   public boolean isTurnBasedMultiplayerEnabled() {
      return this.zzaCn;
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      byte var3 = 1;
      if(!this.zzqC()) {
         GameEntityCreator.zza(this, var1, var2);
      } else {
         var1.writeString(this.zzZC);
         var1.writeString(this.zzWQ);
         var1.writeString(this.zzaCa);
         var1.writeString(this.zzaCb);
         var1.writeString(this.zzaxl);
         var1.writeString(this.zzaCc);
         String var4;
         if(this.zzaCd == null) {
            var4 = null;
         } else {
            var4 = this.zzaCd.toString();
         }

         var1.writeString(var4);
         String var5;
         if(this.zzaCe == null) {
            var5 = null;
         } else {
            var5 = this.zzaCe.toString();
         }

         var1.writeString(var5);
         Uri var6 = this.zzaCf;
         String var7 = null;
         if(var6 != null) {
            var7 = this.zzaCf.toString();
         }

         var1.writeString(var7);
         byte var8;
         if(this.zzaCg) {
            var8 = var3;
         } else {
            var8 = 0;
         }

         var1.writeInt(var8);
         if(!this.zzaCh) {
            var3 = 0;
         }

         var1.writeInt(var3);
         var1.writeString(this.zzaCi);
         var1.writeInt(this.zzaCj);
         var1.writeInt(this.zzaCk);
         var1.writeInt(this.zzaCl);
      }
   }

   public String zzvA() {
      return this.zzaCi;
   }

   public int zzvB() {
      return this.zzaCj;
   }

   public boolean zzvx() {
      return this.zzaCg;
   }

   public boolean zzvy() {
      return this.zzaCr;
   }

   public boolean zzvz() {
      return this.zzaCh;
   }

   static final class GameEntityCreatorCompat extends GameEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzea(var1);
      }

      public GameEntity zzea(Parcel var1) {
         if(!GameEntity.zzd(GameEntity.zzqB()) && !GameEntity.zzcF(GameEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            String var6 = var1.readString();
            String var7 = var1.readString();
            String var8 = var1.readString();
            Uri var9;
            if(var8 == null) {
               var9 = null;
            } else {
               var9 = Uri.parse(var8);
            }

            String var10 = var1.readString();
            Uri var11;
            if(var10 == null) {
               var11 = null;
            } else {
               var11 = Uri.parse(var10);
            }

            String var12 = var1.readString();
            Uri var13;
            if(var12 == null) {
               var13 = null;
            } else {
               var13 = Uri.parse(var12);
            }

            boolean var14;
            if(var1.readInt() > 0) {
               var14 = true;
            } else {
               var14 = false;
            }

            boolean var15;
            if(var1.readInt() > 0) {
               var15 = true;
            } else {
               var15 = false;
            }

            return new GameEntity(7, var2, var3, var4, var5, var6, var7, var9, var11, var13, var14, var15, var1.readString(), var1.readInt(), var1.readInt(), var1.readInt(), false, false, (String)null, (String)null, (String)null, false, false, false, (String)null, false);
         } else {
            return super.zzea(var1);
         }
      }
   }
}
