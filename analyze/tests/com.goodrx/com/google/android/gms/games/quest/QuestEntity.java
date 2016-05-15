package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.MilestoneEntity;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestEntityCreator;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity implements SafeParcelable, Quest {
   public static final Creator<QuestEntity> CREATOR = new QuestEntityCreator();
   private final String mName;
   private final int mState;
   private final int mVersionCode;
   private final long zzaDt;
   private final GameEntity zzaJE;
   private final long zzaKA;
   private final Uri zzaKB;
   private final String zzaKC;
   private final long zzaKD;
   private final long zzaKE;
   private final ArrayList<MilestoneEntity> zzaKF;
   private final String zzaKw;
   private final long zzaKx;
   private final Uri zzaKy;
   private final String zzaKz;
   private final int zzabB;
   private final String zzaxl;

   QuestEntity(int var1, GameEntity var2, String var3, long var4, Uri var6, String var7, String var8, long var9, long var11, Uri var13, String var14, String var15, long var16, long var18, int var20, int var21, ArrayList<MilestoneEntity> var22) {
      this.mVersionCode = var1;
      this.zzaJE = var2;
      this.zzaKw = var3;
      this.zzaKx = var4;
      this.zzaKy = var6;
      this.zzaKz = var7;
      this.zzaxl = var8;
      this.zzaKA = var9;
      this.zzaDt = var11;
      this.zzaKB = var13;
      this.zzaKC = var14;
      this.mName = var15;
      this.zzaKD = var16;
      this.zzaKE = var18;
      this.mState = var20;
      this.zzabB = var21;
      this.zzaKF = var22;
   }

   public QuestEntity(Quest var1) {
      this.mVersionCode = 2;
      this.zzaJE = new GameEntity(var1.getGame());
      this.zzaKw = var1.getQuestId();
      this.zzaKx = var1.getAcceptedTimestamp();
      this.zzaxl = var1.getDescription();
      this.zzaKy = var1.getBannerImageUri();
      this.zzaKz = var1.getBannerImageUrl();
      this.zzaKA = var1.getEndTimestamp();
      this.zzaKB = var1.getIconImageUri();
      this.zzaKC = var1.getIconImageUrl();
      this.zzaDt = var1.getLastUpdatedTimestamp();
      this.mName = var1.getName();
      this.zzaKD = var1.zzxS();
      this.zzaKE = var1.getStartTimestamp();
      this.mState = var1.getState();
      this.zzabB = var1.getType();
      List var2 = var1.zzxR();
      int var3 = var2.size();
      this.zzaKF = new ArrayList(var3);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.zzaKF.add((MilestoneEntity)((MilestoneEntity)((Milestone)var2.get(var4)).freeze()));
      }

   }

   static int zza(Quest var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getQuestId(), Long.valueOf(var0.getAcceptedTimestamp()), var0.getBannerImageUri(), var0.getDescription(), Long.valueOf(var0.getEndTimestamp()), var0.getIconImageUri(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.zzxR(), var0.getName(), Long.valueOf(var0.zzxS()), Long.valueOf(var0.getStartTimestamp()), Integer.valueOf(var0.getState())};
      return zzw.hashCode(var1);
   }

   static boolean zza(Quest var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof Quest)) {
         var2 = false;
      } else if(var0 != var1) {
         Quest var3 = (Quest)var1;
         if(!zzw.equal(var3.getGame(), var0.getGame()) || !zzw.equal(var3.getQuestId(), var0.getQuestId()) || !zzw.equal(Long.valueOf(var3.getAcceptedTimestamp()), Long.valueOf(var0.getAcceptedTimestamp())) || !zzw.equal(var3.getBannerImageUri(), var0.getBannerImageUri()) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(Long.valueOf(var3.getEndTimestamp()), Long.valueOf(var0.getEndTimestamp())) || !zzw.equal(var3.getIconImageUri(), var0.getIconImageUri()) || !zzw.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !zzw.equal(var3.zzxR(), var0.zzxR()) || !zzw.equal(var3.getName(), var0.getName()) || !zzw.equal(Long.valueOf(var3.zzxS()), Long.valueOf(var0.zzxS())) || !zzw.equal(Long.valueOf(var3.getStartTimestamp()), Long.valueOf(var0.getStartTimestamp())) || !zzw.equal(Integer.valueOf(var3.getState()), Integer.valueOf(var0.getState()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(Quest var0) {
      return zzw.zzy(var0).zzg("Game", var0.getGame()).zzg("QuestId", var0.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(var0.getAcceptedTimestamp())).zzg("BannerImageUri", var0.getBannerImageUri()).zzg("BannerImageUrl", var0.getBannerImageUrl()).zzg("Description", var0.getDescription()).zzg("EndTimestamp", Long.valueOf(var0.getEndTimestamp())).zzg("IconImageUri", var0.getIconImageUri()).zzg("IconImageUrl", var0.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).zzg("Milestones", var0.zzxR()).zzg("Name", var0.getName()).zzg("NotifyTimestamp", Long.valueOf(var0.zzxS())).zzg("StartTimestamp", Long.valueOf(var0.getStartTimestamp())).zzg("State", Integer.valueOf(var0.getState())).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public Quest freeze() {
      return this;
   }

   public long getAcceptedTimestamp() {
      return this.zzaKx;
   }

   public Uri getBannerImageUri() {
      return this.zzaKy;
   }

   public String getBannerImageUrl() {
      return this.zzaKz;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public long getEndTimestamp() {
      return this.zzaKA;
   }

   public Game getGame() {
      return this.zzaJE;
   }

   public Uri getIconImageUri() {
      return this.zzaKB;
   }

   public String getIconImageUrl() {
      return this.zzaKC;
   }

   public long getLastUpdatedTimestamp() {
      return this.zzaDt;
   }

   public String getName() {
      return this.mName;
   }

   public String getQuestId() {
      return this.zzaKw;
   }

   public long getStartTimestamp() {
      return this.zzaKE;
   }

   public int getState() {
      return this.mState;
   }

   public int getType() {
      return this.zzabB;
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
      QuestEntityCreator.zza(this, var1, var2);
   }

   public List<Milestone> zzxR() {
      return new ArrayList(this.zzaKF);
   }

   public long zzxS() {
      return this.zzaKD;
   }
}
