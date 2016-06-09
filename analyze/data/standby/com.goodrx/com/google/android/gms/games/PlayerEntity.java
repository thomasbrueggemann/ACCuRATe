package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntityCreator;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
   public static final Creator<PlayerEntity> CREATOR = new PlayerEntity.PlayerEntityCreatorCompat();
   private final String mName;
   private final int mVersionCode;
   private String zzWQ;
   private final long zzaCO;
   private final int zzaCP;
   private final long zzaCQ;
   private final MostRecentGameInfoEntity zzaCR;
   private final PlayerLevelInfo zzaCS;
   private final boolean zzaCT;
   private final boolean zzaCU;
   private final String zzaCV;
   private final Uri zzaCW;
   private final String zzaCX;
   private final Uri zzaCY;
   private final String zzaCZ;
   private final Uri zzaCd;
   private final Uri zzaCe;
   private final String zzaCo;
   private final String zzaCp;
   private String zzacX;
   private final String zzapg;

   PlayerEntity(int var1, String var2, String var3, Uri var4, Uri var5, long var6, int var8, long var9, String var11, String var12, String var13, MostRecentGameInfoEntity var14, PlayerLevelInfo var15, boolean var16, boolean var17, String var18, String var19, Uri var20, String var21, Uri var22, String var23) {
      this.mVersionCode = var1;
      this.zzacX = var2;
      this.zzWQ = var3;
      this.zzaCd = var4;
      this.zzaCo = var11;
      this.zzaCe = var5;
      this.zzaCp = var12;
      this.zzaCO = var6;
      this.zzaCP = var8;
      this.zzaCQ = var9;
      this.zzapg = var13;
      this.zzaCT = var16;
      this.zzaCR = var14;
      this.zzaCS = var15;
      this.zzaCU = var17;
      this.zzaCV = var18;
      this.mName = var19;
      this.zzaCW = var20;
      this.zzaCX = var21;
      this.zzaCY = var22;
      this.zzaCZ = var23;
   }

   public PlayerEntity(Player var1) {
      this(var1, true);
   }

   public PlayerEntity(Player var1, boolean var2) {
      this.mVersionCode = 13;
      String var3;
      if(var2) {
         var3 = var1.getPlayerId();
      } else {
         var3 = null;
      }

      this.zzacX = var3;
      this.zzWQ = var1.getDisplayName();
      this.zzaCd = var1.getIconImageUri();
      this.zzaCo = var1.getIconImageUrl();
      this.zzaCe = var1.getHiResImageUri();
      this.zzaCp = var1.getHiResImageUrl();
      this.zzaCO = var1.getRetrievedTimestamp();
      this.zzaCP = var1.zzvG();
      this.zzaCQ = var1.getLastPlayedWithTimestamp();
      this.zzapg = var1.getTitle();
      this.zzaCT = var1.zzvH();
      MostRecentGameInfo var4 = var1.zzvI();
      MostRecentGameInfoEntity var5 = null;
      if(var4 != null) {
         var5 = new MostRecentGameInfoEntity(var4);
      }

      this.zzaCR = var5;
      this.zzaCS = var1.getLevelInfo();
      this.zzaCU = var1.zzvF();
      this.zzaCV = var1.zzvE();
      this.mName = var1.getName();
      this.zzaCW = var1.getBannerImageLandscapeUri();
      this.zzaCX = var1.getBannerImageLandscapeUrl();
      this.zzaCY = var1.getBannerImagePortraitUri();
      this.zzaCZ = var1.getBannerImagePortraitUrl();
      if(var2) {
         zzb.zzv(this.zzacX);
      }

      zzb.zzv(this.zzWQ);
      boolean var6;
      if(this.zzaCO > 0L) {
         var6 = true;
      } else {
         var6 = false;
      }

      zzb.zzab(var6);
   }

   static boolean zza(Player var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Player)) {
         var2 = false;
      } else if(var0 != var1) {
         Player var3 = (Player)var1;
         if(!zzw.equal(var3.getPlayerId(), var0.getPlayerId()) || !zzw.equal(var3.getDisplayName(), var0.getDisplayName()) || !zzw.equal(Boolean.valueOf(var3.zzvF()), Boolean.valueOf(var0.zzvF())) || !zzw.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !zzw.equal(var3.getHiResImageUri(), var0.getHiResImageUri()) || !zzw.equal(Long.valueOf(var3.getRetrievedTimestamp()), Long.valueOf(var0.getRetrievedTimestamp())) || !zzw.equal(var3.getTitle(), var0.getTitle()) || !zzw.equal(var3.getLevelInfo(), var0.getLevelInfo()) || !zzw.equal(var3.zzvE(), var0.zzvE()) || !zzw.equal(var3.getName(), var0.getName()) || !zzw.equal(var3.getBannerImageLandscapeUri(), var0.getBannerImageLandscapeUri()) || !zzw.equal(var3.getBannerImagePortraitUri(), var0.getBannerImagePortraitUri())) {
            return false;
         }
      }

      return var2;
   }

   static int zzb(Player var0) {
      Object[] var1 = new Object[]{var0.getPlayerId(), var0.getDisplayName(), Boolean.valueOf(var0.zzvF()), var0.getIconImageUri(), var0.getHiResImageUri(), Long.valueOf(var0.getRetrievedTimestamp()), var0.getTitle(), var0.getLevelInfo(), var0.zzvE(), var0.getName(), var0.getBannerImageLandscapeUri(), var0.getBannerImagePortraitUri()};
      return zzw.hashCode(var1);
   }

   static String zzc(Player var0) {
      return zzw.zzy(var0).zzg("PlayerId", var0.getPlayerId()).zzg("DisplayName", var0.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(var0.zzvF())).zzg("IconImageUri", var0.getIconImageUri()).zzg("IconImageUrl", var0.getIconImageUrl()).zzg("HiResImageUri", var0.getHiResImageUri()).zzg("HiResImageUrl", var0.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(var0.getRetrievedTimestamp())).zzg("Title", var0.getTitle()).zzg("LevelInfo", var0.getLevelInfo()).zzg("GamerTag", var0.zzvE()).zzg("Name", var0.getName()).zzg("BannerImageLandscapeUri", var0.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", var0.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", var0.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", var0.getBannerImagePortraitUrl()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Player freeze() {
      return this;
   }

   public Uri getBannerImageLandscapeUri() {
      return this.zzaCW;
   }

   public String getBannerImageLandscapeUrl() {
      return this.zzaCX;
   }

   public Uri getBannerImagePortraitUri() {
      return this.zzaCY;
   }

   public String getBannerImagePortraitUrl() {
      return this.zzaCZ;
   }

   public String getDisplayName() {
      return this.zzWQ;
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

   public long getLastPlayedWithTimestamp() {
      return this.zzaCQ;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.zzaCS;
   }

   public String getName() {
      return this.mName;
   }

   public String getPlayerId() {
      return this.zzacX;
   }

   public long getRetrievedTimestamp() {
      return this.zzaCO;
   }

   public String getTitle() {
      return this.zzapg;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zzb(this);
   }

   public String toString() {
      return zzc((Player)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      if(!this.zzqC()) {
         PlayerEntityCreator.zza(this, var1, var2);
      } else {
         var1.writeString(this.zzacX);
         var1.writeString(this.zzWQ);
         String var3;
         if(this.zzaCd == null) {
            var3 = null;
         } else {
            var3 = this.zzaCd.toString();
         }

         var1.writeString(var3);
         Uri var4 = this.zzaCe;
         String var5 = null;
         if(var4 != null) {
            var5 = this.zzaCe.toString();
         }

         var1.writeString(var5);
         var1.writeLong(this.zzaCO);
      }
   }

   public String zzvE() {
      return this.zzaCV;
   }

   public boolean zzvF() {
      return this.zzaCU;
   }

   public int zzvG() {
      return this.zzaCP;
   }

   public boolean zzvH() {
      return this.zzaCT;
   }

   public MostRecentGameInfo zzvI() {
      return this.zzaCR;
   }

   static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
      // $FF: synthetic method
      public Object createFromParcel(Parcel var1) {
         return this.zzeb(var1);
      }

      public PlayerEntity zzeb(Parcel var1) {
         if(!PlayerEntity.zzd(PlayerEntity.zzqB()) && !PlayerEntity.zzcF(PlayerEntity.class.getCanonicalName())) {
            String var2 = var1.readString();
            String var3 = var1.readString();
            String var4 = var1.readString();
            String var5 = var1.readString();
            Uri var6;
            if(var4 == null) {
               var6 = null;
            } else {
               var6 = Uri.parse(var4);
            }

            Uri var7;
            if(var5 == null) {
               var7 = null;
            } else {
               var7 = Uri.parse(var5);
            }

            return new PlayerEntity(13, var2, var3, var6, var7, var1.readLong(), -1, -1L, (String)null, (String)null, (String)null, (MostRecentGameInfoEntity)null, (PlayerLevelInfo)null, true, false, var1.readString(), var1.readString(), (Uri)null, (String)null, (Uri)null, (String)null);
         } else {
            return super.zzeb(var1);
         }
      }
   }
}
