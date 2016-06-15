package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntityCreator;
import com.google.android.gms.internal.class_284;
import com.google.android.gms.internal.class_349;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
   public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
   // $FF: renamed from: Mm java.lang.String
   private final String field_3178;
   // $FF: renamed from: Of java.lang.String
   private final String field_3179;
   // $FF: renamed from: Rq com.google.android.gms.games.GameEntity
   private final GameEntity field_3180;
   // $FF: renamed from: SR long
   private final long field_3181;
   // $FF: renamed from: SU java.util.ArrayList
   private final ArrayList<ParticipantEntity> field_3182;
   // $FF: renamed from: SV int
   private final int field_3183;
   // $FF: renamed from: TA int
   private final int field_3184;
   // $FF: renamed from: TB int
   private final int field_3185;
   // $FF: renamed from: TC byte[]
   private final byte[] field_3186;
   // $FF: renamed from: TD java.lang.String
   private final String field_3187;
   // $FF: renamed from: TE byte[]
   private final byte[] field_3188;
   // $FF: renamed from: TF int
   private final int field_3189;
   // $FF: renamed from: TG int
   private final int field_3190;
   // $FF: renamed from: TH boolean
   private final boolean field_3191;
   // $FF: renamed from: TI java.lang.String
   private final String field_3192;
   // $FF: renamed from: Tl android.os.Bundle
   private final Bundle field_3193;
   // $FF: renamed from: Tp java.lang.String
   private final String field_3194;
   // $FF: renamed from: Tx java.lang.String
   private final String field_3195;
   // $FF: renamed from: Ty long
   private final long field_3196;
   // $FF: renamed from: Tz java.lang.String
   private final String field_3197;
   // $FF: renamed from: xJ int
   private final int field_3198;

   TurnBasedMatchEntity(int var1, GameEntity var2, String var3, String var4, long var5, String var7, long var8, String var10, int var11, int var12, int var13, byte[] var14, ArrayList<ParticipantEntity> var15, String var16, byte[] var17, int var18, Bundle var19, int var20, boolean var21, String var22, String var23) {
      this.field_3198 = var1;
      this.field_3180 = var2;
      this.field_3179 = var3;
      this.field_3194 = var4;
      this.field_3181 = var5;
      this.field_3195 = var7;
      this.field_3196 = var8;
      this.field_3197 = var10;
      this.field_3184 = var11;
      this.field_3190 = var20;
      this.field_3183 = var12;
      this.field_3185 = var13;
      this.field_3186 = var14;
      this.field_3182 = var15;
      this.field_3187 = var16;
      this.field_3188 = var17;
      this.field_3189 = var18;
      this.field_3193 = var19;
      this.field_3191 = var21;
      this.field_3178 = var22;
      this.field_3192 = var23;
   }

   public TurnBasedMatchEntity(TurnBasedMatch var1) {
      this.field_3198 = 2;
      this.field_3180 = new GameEntity(var1.getGame());
      this.field_3179 = var1.getMatchId();
      this.field_3194 = var1.getCreatorId();
      this.field_3181 = var1.getCreationTimestamp();
      this.field_3195 = var1.getLastUpdaterId();
      this.field_3196 = var1.getLastUpdatedTimestamp();
      this.field_3197 = var1.getPendingParticipantId();
      this.field_3184 = var1.getStatus();
      this.field_3190 = var1.getTurnStatus();
      this.field_3183 = var1.getVariant();
      this.field_3185 = var1.getVersion();
      this.field_3187 = var1.getRematchId();
      this.field_3189 = var1.getMatchNumber();
      this.field_3193 = var1.getAutoMatchCriteria();
      this.field_3191 = var1.isLocallyModified();
      this.field_3178 = var1.getDescription();
      this.field_3192 = var1.getDescriptionParticipantId();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.field_3186 = null;
      } else {
         this.field_3186 = new byte[var2.length];
         System.arraycopy(var2, 0, this.field_3186, 0, var2.length);
      }

      byte[] var3 = var1.getPreviousMatchData();
      if(var3 == null) {
         this.field_3188 = null;
      } else {
         this.field_3188 = new byte[var3.length];
         System.arraycopy(var3, 0, this.field_3188, 0, var3.length);
      }

      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.field_3182 = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         this.field_3182.add((ParticipantEntity)((ParticipantEntity)((Participant)var4.get(var6)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) int
   static int method_3434(TurnBasedMatch var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getMatchId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), var0.getLastUpdaterId(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPendingParticipantId(), Integer.valueOf(var0.getStatus()), Integer.valueOf(var0.getTurnStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getVersion()), var0.getParticipants(), var0.getRematchId(), Integer.valueOf(var0.getMatchNumber()), var0.getAutoMatchCriteria(), Integer.valueOf(var0.getAvailableAutoMatchSlots()), Boolean.valueOf(var0.isLocallyModified())};
      return class_349.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) int
   static int method_3435(TurnBasedMatch var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         if(var5.getParticipantId().equals(var1)) {
            return var5.getStatus();
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.Object) boolean
   static boolean method_3436(TurnBasedMatch var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof TurnBasedMatch)) {
         var2 = false;
      } else if(var0 != var1) {
         TurnBasedMatch var3 = (TurnBasedMatch)var1;
         if(!class_349.equal(var3.getGame(), var0.getGame()) || !class_349.equal(var3.getMatchId(), var0.getMatchId()) || !class_349.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_349.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_349.equal(var3.getLastUpdaterId(), var0.getLastUpdaterId()) || !class_349.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_349.equal(var3.getPendingParticipantId(), var0.getPendingParticipantId()) || !class_349.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_349.equal(Integer.valueOf(var3.getTurnStatus()), Integer.valueOf(var0.getTurnStatus())) || !class_349.equal(var3.getDescription(), var0.getDescription()) || !class_349.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_349.equal(Integer.valueOf(var3.getVersion()), Integer.valueOf(var0.getVersion())) || !class_349.equal(var3.getParticipants(), var0.getParticipants()) || !class_349.equal(var3.getRematchId(), var0.getRematchId()) || !class_349.equal(Integer.valueOf(var3.getMatchNumber()), Integer.valueOf(var0.getMatchNumber())) || !class_349.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_349.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots())) || !class_349.equal(Boolean.valueOf(var3.isLocallyModified()), Boolean.valueOf(var0.isLocallyModified()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) java.lang.String
   static String method_3437(TurnBasedMatch var0) {
      return class_349.method_2174(var0).method_4301("Game", var0.getGame()).method_4301("MatchId", var0.getMatchId()).method_4301("CreatorId", var0.getCreatorId()).method_4301("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_4301("LastUpdaterId", var0.getLastUpdaterId()).method_4301("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_4301("PendingParticipantId", var0.getPendingParticipantId()).method_4301("MatchStatus", Integer.valueOf(var0.getStatus())).method_4301("TurnStatus", Integer.valueOf(var0.getTurnStatus())).method_4301("Description", var0.getDescription()).method_4301("Variant", Integer.valueOf(var0.getVariant())).method_4301("Data", var0.getData()).method_4301("Version", Integer.valueOf(var0.getVersion())).method_4301("Participants", var0.getParticipants()).method_4301("RematchId", var0.getRematchId()).method_4301("PreviousData", var0.getPreviousMatchData()).method_4301("MatchNumber", Integer.valueOf(var0.getMatchNumber())).method_4301("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_4301("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).method_4301("LocallyModified", Boolean.valueOf(var0.isLocallyModified())).method_4301("DescriptionParticipantId", var0.getDescriptionParticipantId()).toString();
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) java.lang.String
   static String method_3438(TurnBasedMatch var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         Player var6 = var5.getPlayer();
         if(var6 != null && var6.getPlayerId().equals(var1)) {
            return var5.getParticipantId();
         }
      }

      return null;
   }

   // $FF: renamed from: c (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) com.google.android.gms.games.multiplayer.Participant
   static Participant method_3439(TurnBasedMatch var0, String var1) {
      ArrayList var2 = var0.getParticipants();
      int var3 = var2.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         Participant var5 = (Participant)var2.get(var4);
         if(var5.getParticipantId().equals(var1)) {
            return var5;
         }
      }

      throw new IllegalStateException("Participant " + var1 + " is not in match " + var0.getMatchId());
   }

   // $FF: renamed from: c (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) java.util.ArrayList
   static ArrayList<String> method_3440(TurnBasedMatch var0) {
      ArrayList var1 = var0.getParticipants();
      int var2 = var1.size();
      ArrayList var3 = new ArrayList(var2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.add(((Participant)var1.get(var4)).getParticipantId());
      }

      return var3;
   }

   public boolean canRematch() {
      return this.field_3184 == 2 && this.field_3187 == null;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_3436(this, var1);
   }

   public TurnBasedMatch freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.field_3193;
   }

   public int getAvailableAutoMatchSlots() {
      return this.field_3193 == null?0:this.field_3193.getInt("max_automatch_players");
   }

   public long getCreationTimestamp() {
      return this.field_3181;
   }

   public String getCreatorId() {
      return this.field_3194;
   }

   public byte[] getData() {
      return this.field_3186;
   }

   public String getDescription() {
      return this.field_3178;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_284.method_1876(this.field_3178, var1);
   }

   public Participant getDescriptionParticipant() {
      return this.getParticipant(this.getDescriptionParticipantId());
   }

   public String getDescriptionParticipantId() {
      return this.field_3192;
   }

   public Game getGame() {
      return this.field_3180;
   }

   public long getLastUpdatedTimestamp() {
      return this.field_3196;
   }

   public String getLastUpdaterId() {
      return this.field_3195;
   }

   public String getMatchId() {
      return this.field_3179;
   }

   public int getMatchNumber() {
      return this.field_3189;
   }

   public Participant getParticipant(String var1) {
      return method_3439(this, var1);
   }

   public String getParticipantId(String var1) {
      return method_3438(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return method_3440(this);
   }

   public int getParticipantStatus(String var1) {
      return method_3435(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.field_3182);
   }

   public String getPendingParticipantId() {
      return this.field_3197;
   }

   public byte[] getPreviousMatchData() {
      return this.field_3188;
   }

   public String getRematchId() {
      return this.field_3187;
   }

   public int getStatus() {
      return this.field_3184;
   }

   public int getTurnStatus() {
      return this.field_3190;
   }

   public int getVariant() {
      return this.field_3183;
   }

   public int getVersion() {
      return this.field_3185;
   }

   public int getVersionCode() {
      return this.field_3198;
   }

   public int hashCode() {
      return method_3434(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isLocallyModified() {
      return this.field_3191;
   }

   public String toString() {
      return method_3437(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      TurnBasedMatchEntityCreator.method_3422(this, var1, var2);
   }
}
