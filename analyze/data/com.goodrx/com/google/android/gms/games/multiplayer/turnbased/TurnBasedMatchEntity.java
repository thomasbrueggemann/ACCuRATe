package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntityCreator;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
   public static final Creator<TurnBasedMatchEntity> CREATOR = new TurnBasedMatchEntityCreator();
   private final int mVersion;
   private final int mVersionCode;
   private final long zzaDt;
   private final String zzaER;
   private final GameEntity zzaJE;
   private final long zzaJF;
   private final ArrayList<ParticipantEntity> zzaJI;
   private final int zzaJJ;
   private final Bundle zzaJZ;
   private final String zzaKb;
   private final String zzaKj;
   private final String zzaKk;
   private final int zzaKl;
   private final byte[] zzaKm;
   private final String zzaKn;
   private final byte[] zzaKo;
   private final int zzaKp;
   private final int zzaKq;
   private final boolean zzaKr;
   private final String zzaKs;
   private final String zzaxl;

   TurnBasedMatchEntity(int var1, GameEntity var2, String var3, String var4, long var5, String var7, long var8, String var10, int var11, int var12, int var13, byte[] var14, ArrayList<ParticipantEntity> var15, String var16, byte[] var17, int var18, Bundle var19, int var20, boolean var21, String var22, String var23) {
      this.mVersionCode = var1;
      this.zzaJE = var2;
      this.zzaER = var3;
      this.zzaKb = var4;
      this.zzaJF = var5;
      this.zzaKj = var7;
      this.zzaDt = var8;
      this.zzaKk = var10;
      this.zzaKl = var11;
      this.zzaKq = var20;
      this.zzaJJ = var12;
      this.mVersion = var13;
      this.zzaKm = var14;
      this.zzaJI = var15;
      this.zzaKn = var16;
      this.zzaKo = var17;
      this.zzaKp = var18;
      this.zzaJZ = var19;
      this.zzaKr = var21;
      this.zzaxl = var22;
      this.zzaKs = var23;
   }

   public TurnBasedMatchEntity(TurnBasedMatch var1) {
      this.mVersionCode = 2;
      this.zzaJE = new GameEntity(var1.getGame());
      this.zzaER = var1.getMatchId();
      this.zzaKb = var1.getCreatorId();
      this.zzaJF = var1.getCreationTimestamp();
      this.zzaKj = var1.getLastUpdaterId();
      this.zzaDt = var1.getLastUpdatedTimestamp();
      this.zzaKk = var1.getPendingParticipantId();
      this.zzaKl = var1.getStatus();
      this.zzaKq = var1.getTurnStatus();
      this.zzaJJ = var1.getVariant();
      this.mVersion = var1.getVersion();
      this.zzaKn = var1.getRematchId();
      this.zzaKp = var1.getMatchNumber();
      this.zzaJZ = var1.getAutoMatchCriteria();
      this.zzaKr = var1.isLocallyModified();
      this.zzaxl = var1.getDescription();
      this.zzaKs = var1.getDescriptionParticipantId();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.zzaKm = null;
      } else {
         this.zzaKm = new byte[var2.length];
         System.arraycopy(var2, 0, this.zzaKm, 0, var2.length);
      }

      byte[] var3 = var1.getPreviousMatchData();
      if(var3 == null) {
         this.zzaKo = null;
      } else {
         this.zzaKo = new byte[var3.length];
         System.arraycopy(var3, 0, this.zzaKo, 0, var3.length);
      }

      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.zzaJI = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         this.zzaJI.add((ParticipantEntity)((ParticipantEntity)((Participant)var4.get(var6)).freeze()));
      }

   }

   static int zza(TurnBasedMatch var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getMatchId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), var0.getLastUpdaterId(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPendingParticipantId(), Integer.valueOf(var0.getStatus()), Integer.valueOf(var0.getTurnStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getVersion()), var0.getParticipants(), var0.getRematchId(), Integer.valueOf(var0.getMatchNumber()), var0.getAutoMatchCriteria(), Integer.valueOf(var0.getAvailableAutoMatchSlots()), Boolean.valueOf(var0.isLocallyModified())};
      return zzw.hashCode(var1);
   }

   static boolean zza(TurnBasedMatch var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof TurnBasedMatch)) {
         var2 = false;
      } else if(var0 != var1) {
         TurnBasedMatch var3 = (TurnBasedMatch)var1;
         if(!zzw.equal(var3.getGame(), var0.getGame()) || !zzw.equal(var3.getMatchId(), var0.getMatchId()) || !zzw.equal(var3.getCreatorId(), var0.getCreatorId()) || !zzw.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !zzw.equal(var3.getLastUpdaterId(), var0.getLastUpdaterId()) || !zzw.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !zzw.equal(var3.getPendingParticipantId(), var0.getPendingParticipantId()) || !zzw.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !zzw.equal(Integer.valueOf(var3.getTurnStatus()), Integer.valueOf(var0.getTurnStatus())) || !zzw.equal(var3.getDescription(), var0.getDescription()) || !zzw.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !zzw.equal(Integer.valueOf(var3.getVersion()), Integer.valueOf(var0.getVersion())) || !zzw.equal(var3.getParticipants(), var0.getParticipants()) || !zzw.equal(var3.getRematchId(), var0.getRematchId()) || !zzw.equal(Integer.valueOf(var3.getMatchNumber()), Integer.valueOf(var0.getMatchNumber())) || !zzw.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !zzw.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots())) || !zzw.equal(Boolean.valueOf(var3.isLocallyModified()), Boolean.valueOf(var0.isLocallyModified()))) {
            return false;
         }
      }

      return var2;
   }

   static String zzb(TurnBasedMatch var0) {
      return zzw.zzy(var0).zzg("Game", var0.getGame()).zzg("MatchId", var0.getMatchId()).zzg("CreatorId", var0.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).zzg("LastUpdaterId", var0.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).zzg("PendingParticipantId", var0.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(var0.getStatus())).zzg("TurnStatus", Integer.valueOf(var0.getTurnStatus())).zzg("Description", var0.getDescription()).zzg("Variant", Integer.valueOf(var0.getVariant())).zzg("Data", var0.getData()).zzg("Version", Integer.valueOf(var0.getVersion())).zzg("Participants", var0.getParticipants()).zzg("RematchId", var0.getRematchId()).zzg("PreviousData", var0.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(var0.getMatchNumber())).zzg("AutoMatchCriteria", var0.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(var0.isLocallyModified())).zzg("DescriptionParticipantId", var0.getDescriptionParticipantId()).toString();
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return zza(this, var1);
   }

   public TurnBasedMatch freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.zzaJZ;
   }

   public int getAvailableAutoMatchSlots() {
      return this.zzaJZ == null?0:this.zzaJZ.getInt("max_automatch_players");
   }

   public long getCreationTimestamp() {
      return this.zzaJF;
   }

   public String getCreatorId() {
      return this.zzaKb;
   }

   public byte[] getData() {
      return this.zzaKm;
   }

   public String getDescription() {
      return this.zzaxl;
   }

   public String getDescriptionParticipantId() {
      return this.zzaKs;
   }

   public Game getGame() {
      return this.zzaJE;
   }

   public long getLastUpdatedTimestamp() {
      return this.zzaDt;
   }

   public String getLastUpdaterId() {
      return this.zzaKj;
   }

   public String getMatchId() {
      return this.zzaER;
   }

   public int getMatchNumber() {
      return this.zzaKp;
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.zzaJI);
   }

   public String getPendingParticipantId() {
      return this.zzaKk;
   }

   public byte[] getPreviousMatchData() {
      return this.zzaKo;
   }

   public String getRematchId() {
      return this.zzaKn;
   }

   public int getStatus() {
      return this.zzaKl;
   }

   public int getTurnStatus() {
      return this.zzaKq;
   }

   public int getVariant() {
      return this.zzaJJ;
   }

   public int getVersion() {
      return this.mVersion;
   }

   public int getVersionCode() {
      return this.mVersionCode;
   }

   public int hashCode() {
      return zza(this);
   }

   public boolean isLocallyModified() {
      return this.zzaKr;
   }

   public String toString() {
      return zzb(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      TurnBasedMatchEntityCreator.zza(this, var1, var2);
   }
}
