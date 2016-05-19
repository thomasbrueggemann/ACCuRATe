package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.PlayerLevel;
import com.google.android.gms.games.PlayerLevelInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
   private final PlayerLevelInfo zzaCS;
   private final PlayerColumnNames zzaDh;
   private final MostRecentGameInfoRef zzaDi;

   public PlayerRef(DataHolder var1, int var2) {
      this(var1, var2, (String)null);
   }

   public PlayerRef(DataHolder var1, int var2, String var3) {
      super(var1, var2);
      this.zzaDh = new PlayerColumnNames(var3);
      this.zzaDi = new MostRecentGameInfoRef(var1, var2, this.zzaDh);
      if(this.zzvJ()) {
         int var4 = this.getInteger(this.zzaDh.zzaIC);
         int var5 = this.getInteger(this.zzaDh.zzaIF);
         PlayerLevel var6 = new PlayerLevel(var4, this.getLong(this.zzaDh.zzaID), this.getLong(this.zzaDh.zzaIE));
         PlayerLevel var7;
         if(var4 != var5) {
            var7 = new PlayerLevel(var5, this.getLong(this.zzaDh.zzaIE), this.getLong(this.zzaDh.zzaIG));
         } else {
            var7 = var6;
         }

         this.zzaCS = new PlayerLevelInfo(this.getLong(this.zzaDh.zzaIB), this.getLong(this.zzaDh.zzaIH), var6, var7);
      } else {
         this.zzaCS = null;
      }
   }

   private boolean zzvJ() {
      return !this.zzcB(this.zzaDh.zzaIB) && this.getLong(this.zzaDh.zzaIB) != -1L;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return PlayerEntity.zza(this, var1);
   }

   public Player freeze() {
      return new PlayerEntity(this);
   }

   public Uri getBannerImageLandscapeUri() {
      return this.zzcA(this.zzaDh.zzaIS);
   }

   public String getBannerImageLandscapeUrl() {
      return this.getString(this.zzaDh.zzaIT);
   }

   public Uri getBannerImagePortraitUri() {
      return this.zzcA(this.zzaDh.zzaIU);
   }

   public String getBannerImagePortraitUrl() {
      return this.getString(this.zzaDh.zzaIV);
   }

   public String getDisplayName() {
      return this.getString(this.zzaDh.zzaIt);
   }

   public Uri getHiResImageUri() {
      return this.zzcA(this.zzaDh.zzaIw);
   }

   public String getHiResImageUrl() {
      return this.getString(this.zzaDh.zzaIx);
   }

   public Uri getIconImageUri() {
      return this.zzcA(this.zzaDh.zzaIu);
   }

   public String getIconImageUrl() {
      return this.getString(this.zzaDh.zzaIv);
   }

   public long getLastPlayedWithTimestamp() {
      return this.zzcz(this.zzaDh.zzaIA) && !this.zzcB(this.zzaDh.zzaIA)?this.getLong(this.zzaDh.zzaIA):-1L;
   }

   public PlayerLevelInfo getLevelInfo() {
      return this.zzaCS;
   }

   public String getName() {
      return this.getString(this.zzaDh.name);
   }

   public String getPlayerId() {
      return this.getString(this.zzaDh.zzaIs);
   }

   public long getRetrievedTimestamp() {
      return this.getLong(this.zzaDh.zzaIy);
   }

   public String getTitle() {
      return this.getString(this.zzaDh.title);
   }

   public int hashCode() {
      return PlayerEntity.zzb(this);
   }

   public String toString() {
      return PlayerEntity.zzc((Player)this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((PlayerEntity)this.freeze()).writeToParcel(var1, var2);
   }

   public String zzvE() {
      return this.getString(this.zzaDh.zzaIR);
   }

   public boolean zzvF() {
      return this.getBoolean(this.zzaDh.zzaIQ);
   }

   public int zzvG() {
      return this.getInteger(this.zzaDh.zzaIz);
   }

   public boolean zzvH() {
      return this.getBoolean(this.zzaDh.zzaIJ);
   }

   public MostRecentGameInfo zzvI() {
      return this.zzcB(this.zzaDh.zzaIK)?null:this.zzaDi;
   }
}
