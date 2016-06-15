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
import com.google.android.gms.internal.class_336;
import com.google.android.gms.internal.class_719;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
   public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
   // $FF: renamed from: CK int
   private final int field_3147;
   // $FF: renamed from: Ef int
   private final int field_3148;
   // $FF: renamed from: UO java.lang.String
   private final String field_3149;
   // $FF: renamed from: XH long
   private final long field_3150;
   // $FF: renamed from: Zb java.lang.String
   private final String field_3151;
   private final GameEntity acs;
   private final long adS;
   private final ArrayList<ParticipantEntity> adV;
   private final int adW;
   private final byte[] aeA;
   private final String aeB;
   private final byte[] aeC;
   private final int aeD;
   private final int aeE;
   private final boolean aeF;
   private final String aeG;
   private final Bundle aem;
   private final String aep;
   private final String aex;
   private final String aey;
   private final int aez;

   TurnBasedMatchEntity(int var1, GameEntity var2, String var3, String var4, long var5, String var7, long var8, String var10, int var11, int var12, int var13, byte[] var14, ArrayList<ParticipantEntity> var15, String var16, byte[] var17, int var18, Bundle var19, int var20, boolean var21, String var22, String var23) {
      this.field_3147 = var1;
      this.acs = var2;
      this.field_3151 = var3;
      this.aep = var4;
      this.adS = var5;
      this.aex = var7;
      this.field_3150 = var8;
      this.aey = var10;
      this.aez = var11;
      this.aeE = var20;
      this.adW = var12;
      this.field_3148 = var13;
      this.aeA = var14;
      this.adV = var15;
      this.aeB = var16;
      this.aeC = var17;
      this.aeD = var18;
      this.aem = var19;
      this.aeF = var21;
      this.field_3149 = var22;
      this.aeG = var23;
   }

   public TurnBasedMatchEntity(TurnBasedMatch var1) {
      this.field_3147 = 2;
      this.acs = new GameEntity(var1.getGame());
      this.field_3151 = var1.getMatchId();
      this.aep = var1.getCreatorId();
      this.adS = var1.getCreationTimestamp();
      this.aex = var1.getLastUpdaterId();
      this.field_3150 = var1.getLastUpdatedTimestamp();
      this.aey = var1.getPendingParticipantId();
      this.aez = var1.getStatus();
      this.aeE = var1.getTurnStatus();
      this.adW = var1.getVariant();
      this.field_3148 = var1.getVersion();
      this.aeB = var1.getRematchId();
      this.aeD = var1.getMatchNumber();
      this.aem = var1.getAutoMatchCriteria();
      this.aeF = var1.isLocallyModified();
      this.field_3149 = var1.getDescription();
      this.aeG = var1.getDescriptionParticipantId();
      byte[] var2 = var1.getData();
      if(var2 == null) {
         this.aeA = null;
      } else {
         this.aeA = new byte[var2.length];
         System.arraycopy(var2, 0, this.aeA, 0, var2.length);
      }

      byte[] var3 = var1.getPreviousMatchData();
      if(var3 == null) {
         this.aeC = null;
      } else {
         this.aeC = new byte[var3.length];
         System.arraycopy(var3, 0, this.aeC, 0, var3.length);
      }

      ArrayList var4 = var1.getParticipants();
      int var5 = var4.size();
      this.adV = new ArrayList(var5);

      for(int var6 = 0; var6 < var5; ++var6) {
         this.adV.add((ParticipantEntity)((ParticipantEntity)((Participant)var4.get(var6)).freeze()));
      }

   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) int
   static int method_4103(TurnBasedMatch var0) {
      Object[] var1 = new Object[]{var0.getGame(), var0.getMatchId(), var0.getCreatorId(), Long.valueOf(var0.getCreationTimestamp()), var0.getLastUpdaterId(), Long.valueOf(var0.getLastUpdatedTimestamp()), var0.getPendingParticipantId(), Integer.valueOf(var0.getStatus()), Integer.valueOf(var0.getTurnStatus()), var0.getDescription(), Integer.valueOf(var0.getVariant()), Integer.valueOf(var0.getVersion()), var0.getParticipants(), var0.getRematchId(), Integer.valueOf(var0.getMatchNumber()), var0.getAutoMatchCriteria(), Integer.valueOf(var0.getAvailableAutoMatchSlots()), Boolean.valueOf(var0.isLocallyModified())};
      return class_336.hashCode(var1);
   }

   // $FF: renamed from: a (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) int
   static int method_4104(TurnBasedMatch var0, String var1) {
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
   static boolean method_4105(TurnBasedMatch var0, Object var1) {
      boolean var2 = true;
      if(!(var1 instanceof TurnBasedMatch)) {
         var2 = false;
      } else if(var0 != var1) {
         TurnBasedMatch var3 = (TurnBasedMatch)var1;
         if(!class_336.equal(var3.getGame(), var0.getGame()) || !class_336.equal(var3.getMatchId(), var0.getMatchId()) || !class_336.equal(var3.getCreatorId(), var0.getCreatorId()) || !class_336.equal(Long.valueOf(var3.getCreationTimestamp()), Long.valueOf(var0.getCreationTimestamp())) || !class_336.equal(var3.getLastUpdaterId(), var0.getLastUpdaterId()) || !class_336.equal(Long.valueOf(var3.getLastUpdatedTimestamp()), Long.valueOf(var0.getLastUpdatedTimestamp())) || !class_336.equal(var3.getPendingParticipantId(), var0.getPendingParticipantId()) || !class_336.equal(Integer.valueOf(var3.getStatus()), Integer.valueOf(var0.getStatus())) || !class_336.equal(Integer.valueOf(var3.getTurnStatus()), Integer.valueOf(var0.getTurnStatus())) || !class_336.equal(var3.getDescription(), var0.getDescription()) || !class_336.equal(Integer.valueOf(var3.getVariant()), Integer.valueOf(var0.getVariant())) || !class_336.equal(Integer.valueOf(var3.getVersion()), Integer.valueOf(var0.getVersion())) || !class_336.equal(var3.getParticipants(), var0.getParticipants()) || !class_336.equal(var3.getRematchId(), var0.getRematchId()) || !class_336.equal(Integer.valueOf(var3.getMatchNumber()), Integer.valueOf(var0.getMatchNumber())) || !class_336.equal(var3.getAutoMatchCriteria(), var0.getAutoMatchCriteria()) || !class_336.equal(Integer.valueOf(var3.getAvailableAutoMatchSlots()), Integer.valueOf(var0.getAvailableAutoMatchSlots())) || !class_336.equal(Boolean.valueOf(var3.isLocallyModified()), Boolean.valueOf(var0.isLocallyModified()))) {
            return false;
         }
      }

      return var2;
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch) java.lang.String
   static String method_4106(TurnBasedMatch var0) {
      return class_336.method_2312(var0).method_3424("Game", var0.getGame()).method_3424("MatchId", var0.getMatchId()).method_3424("CreatorId", var0.getCreatorId()).method_3424("CreationTimestamp", Long.valueOf(var0.getCreationTimestamp())).method_3424("LastUpdaterId", var0.getLastUpdaterId()).method_3424("LastUpdatedTimestamp", Long.valueOf(var0.getLastUpdatedTimestamp())).method_3424("PendingParticipantId", var0.getPendingParticipantId()).method_3424("MatchStatus", Integer.valueOf(var0.getStatus())).method_3424("TurnStatus", Integer.valueOf(var0.getTurnStatus())).method_3424("Description", var0.getDescription()).method_3424("Variant", Integer.valueOf(var0.getVariant())).method_3424("Data", var0.getData()).method_3424("Version", Integer.valueOf(var0.getVersion())).method_3424("Participants", var0.getParticipants()).method_3424("RematchId", var0.getRematchId()).method_3424("PreviousData", var0.getPreviousMatchData()).method_3424("MatchNumber", Integer.valueOf(var0.getMatchNumber())).method_3424("AutoMatchCriteria", var0.getAutoMatchCriteria()).method_3424("AvailableAutoMatchSlots", Integer.valueOf(var0.getAvailableAutoMatchSlots())).method_3424("LocallyModified", Boolean.valueOf(var0.isLocallyModified())).method_3424("DescriptionParticipantId", var0.getDescriptionParticipantId()).toString();
   }

   // $FF: renamed from: b (com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch, java.lang.String) java.lang.String
   static String method_4107(TurnBasedMatch var0, String var1) {
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
   static Participant method_4108(TurnBasedMatch var0, String var1) {
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
   static ArrayList<String> method_4109(TurnBasedMatch var0) {
      ArrayList var1 = var0.getParticipants();
      int var2 = var1.size();
      ArrayList var3 = new ArrayList(var2);

      for(int var4 = 0; var4 < var2; ++var4) {
         var3.add(((Participant)var1.get(var4)).getParticipantId());
      }

      return var3;
   }

   public boolean canRematch() {
      return this.aez == 2 && this.aeB == null;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return method_4105(this, var1);
   }

   public TurnBasedMatch freeze() {
      return this;
   }

   public Bundle getAutoMatchCriteria() {
      return this.aem;
   }

   public int getAvailableAutoMatchSlots() {
      return this.aem == null?0:this.aem.getInt("max_automatch_players");
   }

   public long getCreationTimestamp() {
      return this.adS;
   }

   public String getCreatorId() {
      return this.aep;
   }

   public byte[] getData() {
      return this.aeA;
   }

   public String getDescription() {
      return this.field_3149;
   }

   public void getDescription(CharArrayBuffer var1) {
      class_719.method_4197(this.field_3149, var1);
   }

   public Participant getDescriptionParticipant() {
      String var1 = this.getDescriptionParticipantId();
      return var1 == null?null:this.getParticipant(var1);
   }

   public String getDescriptionParticipantId() {
      return this.aeG;
   }

   public Game getGame() {
      return this.acs;
   }

   public long getLastUpdatedTimestamp() {
      return this.field_3150;
   }

   public String getLastUpdaterId() {
      return this.aex;
   }

   public String getMatchId() {
      return this.field_3151;
   }

   public int getMatchNumber() {
      return this.aeD;
   }

   public Participant getParticipant(String var1) {
      return method_4108(this, var1);
   }

   public String getParticipantId(String var1) {
      return method_4107(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return method_4109(this);
   }

   public int getParticipantStatus(String var1) {
      return method_4104(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      return new ArrayList(this.adV);
   }

   public String getPendingParticipantId() {
      return this.aey;
   }

   public byte[] getPreviousMatchData() {
      return this.aeC;
   }

   public String getRematchId() {
      return this.aeB;
   }

   public int getStatus() {
      return this.aez;
   }

   public int getTurnStatus() {
      return this.aeE;
   }

   public int getVariant() {
      return this.adW;
   }

   public int getVersion() {
      return this.field_3148;
   }

   public int getVersionCode() {
      return this.field_3147;
   }

   public int hashCode() {
      return method_4103(this);
   }

   public boolean isDataValid() {
      return true;
   }

   public boolean isLocallyModified() {
      return this.aeF;
   }

   public String toString() {
      return method_4106(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      TurnBasedMatchEntityCreator.method_4093(this, var1, var2);
   }
}
