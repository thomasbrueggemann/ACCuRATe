package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.Achievement;
import com.google.android.gms.games.achievement.AchievementEntityCreator;

public final class AchievementEntity implements SafeParcelable, Achievement {
   public static final Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
   private final String mName;
   private final int mState;
   private final int mVersionCode;
   private final String zzaDj;
   private final Uri zzaDk;
   private final String zzaDl;
   private final Uri zzaDm;
   private final String zzaDn;
   private final int zzaDo;
   private final String zzaDp;
   private final PlayerEntity zzaDq;
   private final int zzaDr;
   private final String zzaDs;
   private final long zzaDt;
   private final long zzaDu;
   private final int zzabB;
   private final String zzaxl;

   AchievementEntity(int var1, String var2, int var3, String var4, String var5, Uri var6, String var7, Uri var8, String var9, int var10, String var11, PlayerEntity var12, int var13, int var14, String var15, long var16, long var18) {
      this.mVersionCode = var1;
      this.zzaDj = var2;
      this.zzabB = var3;
      this.mName = var4;
      this.zzaxl = var5;
      this.zzaDk = var6;
      this.zzaDl = var7;
      this.zzaDm = var8;
      this.zzaDn = var9;
      this.zzaDo = var10;
      this.zzaDp = var11;
      this.zzaDq = var12;
      this.mState = var13;
      this.zzaDr = var14;
      this.zzaDs = var15;
      this.zzaDt = var16;
      this.zzaDu = var18;
   }

   public AchievementEntity(Achievement var1) {
      this.mVersionCode = 1;
      this.zzaDj = var1.getAchievementId();
      this.zzabB = var1.getType();
      this.mName = var1.getName();
      this.zzaxl = var1.getDescription();
      this.zzaDk = var1.getUnlockedImageUri();
      this.zzaDl = var1.getUnlockedImageUrl();
      this.zzaDm = var1.getRevealedImageUri();
      this.zzaDn = var1.getRevealedImageUrl();
      this.zzaDq = (PlayerEntity)var1.getPlayer().freeze();
      this.mState = var1.getState();
      this.zzaDt = var1.getLastUpdatedTimestamp();
      this.zzaDu = var1.getXpValue();
      if(var1.getType() == 1) {
         this.zzaDo = var1.getTotalSteps();
         this.zzaDp = var1.getFormattedTotalSteps();
         this.zzaDr = var1.getCurrentSteps();
         this.zzaDs = var1.getFormattedCurrentSteps();
      } else {
         this.zzaDo = 0;
         this.zzaDp = null;
         this.zzaDr = 0;
         this.zzaDs = null;
      }

      zzb.zzv(this.zzaDj);
      zzb.zzv(this.zzaxl);
   }

   static int zza(Achievement var0) {
      int var1;
      int var2;
      if(var0.getType() == 1) {
         var2 = var0.getCurrentSteps();
         var1 = var0.getTotalSteps();
      } else {
         var1 = 0;
         var2 = 0;
      }

      Object[] var3 = new Object[]{var0.getAchievementId(), var0.getName(), Integer.valueOf(var0.getType()), var0.getDescription(), Long.valueOf(var0.getXpValue()), Integer.valueOf(var0.getState()), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPlayer(), Integer.valueOf(var2), Integer.valueOf(var1)};
      return zzw.hashCode(var3);
   }

   static boolean zza(Achievement var0, Object var1) {
      byte var2 = 1;
      if(!(var1 instanceof Achievement)) {
         var2 = 0;
      } else if(var0 != var1) {
         Achievement var3 = (Achievement)var1;
         byte var4;
         byte var5;
         if(var0.getType() == var2) {
            var5 = zzw.equal(Integer.valueOf(var3.getCurrentSteps()), Integer.valueOf(var0.getCurrentSteps()));
            var4 = zzw.equal(Integer.valueOf(var3.getTotalSteps()), Integer.valueOf(var0.getTotalSteps()));
         } else {
            var4 = var2;
            var5 = var2;
         }

         if(!zzw.equal(var3.getAchievementId(), var0.getAchievementId()) || !zzw.equal(var3.getName(), var0.getName()) || !zzw.equal(Integer.valueOf(var3.getType()), Integer.valueOf(var0.getType())) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(Long.valueOf(var3.getXpValue()), Long.valueOf(var0.getXpValue())) || !zzw.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState())) || !zzw.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !zzw.equal(var3.getPlayer(), var0.getPlayer()) || var5 == 0 || var4 == 0) {
            return false;
         }
      }

      return (boolean)var2;
   }

   static String zzb(Achievement var0) {
      zzw.zza var1 = zzw.zzy(var0).zzg("Id", var0.getAchievementId()).zzg("Type", Integer.valueOf(var0.getType())).zzg("Name", var0.getName()).zzg("Description", var0.getDescription()).zzg("Player", var0.getPlayer()).zzg("State", Integer.valueOf(var0.getState()));
      if(var0.getType() == 1) {
         var1.zzg("CurrentSteps", Integer.valueOf(var0.getCurrentSteps()));
         var1.zzg("TotalSteps", Integer.valueOf(var0.getTotalSteps()));
      }

      return var1.toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Achievement freeze() {
      return this;
   }

   public String getAchievementId() {
      return this.zzaDj;
   }

   public int getCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.zzvM();
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getFormattedCurrentSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.zzvN();
   }

   public String getFormattedTotalSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.zzvL();
   }

   public long getLastUpdatedTimestamp() {
      return this.zzaDt;
   }

   public String getName() {
      return this.mName;
   }

   public Player getPlayer() {
      return this.zzaDq;
   }

   public Uri getRevealedImageUri() {
      return this.zzaDm;
   }

   public String getRevealedImageUrl() {
      return this.zzaDn;
   }

   public int getState() {
      return this.mState;
   }

   public int getTotalSteps() {
      byte var1 = 1;
      if(this.getType() != var1) {
         var1 = 0;
      }

      zzb.zzab((boolean)var1);
      return this.zzvK();
   }

   public int getType() {
      return this.zzabB;
   }

   public Uri getUnlockedImageUri() {
      return this.zzaDk;
   }

   public String getUnlockedImageUrl() {
      return this.zzaDl;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public long getXpValue() {
      return this.zzaDu;
   }

   public int hashCode() {
      return zza(this);
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      AchievementEntityCreator.zza(this, var1, var2);
   }

   public int zzvK() {
      return this.zzaDo;
   }

   public String zzvL() {
      return this.zzaDp;
   }

   public int zzvM() {
      return this.zzaDr;
   }

   public String zzvN() {
      return this.zzaDs;
   }
}
