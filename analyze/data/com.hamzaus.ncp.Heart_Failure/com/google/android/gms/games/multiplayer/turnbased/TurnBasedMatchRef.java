package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_206;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public final class TurnBasedMatchRef extends class_206 implements TurnBasedMatch {
   // $FF: renamed from: RD int
   private final int field_695;
   // $FF: renamed from: Sp com.google.android.gms.games.Game
   private final Game field_696;

   TurnBasedMatchRef(DataHolder var1, int var2, int var3) {
      super(var1, var2);
      this.field_696 = new GameRef(var1, var2);
      this.field_695 = var3;
   }

   public boolean canRematch() {
      return this.getTurnStatus() == 3 && this.getRematchId() == null && this.getParticipants().size() > 1;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      return TurnBasedMatchEntity.method_3436(this, var1);
   }

   public TurnBasedMatch freeze() {
      return new TurnBasedMatchEntity(this);
   }

   public Bundle getAutoMatchCriteria() {
      return !this.getBoolean("has_automatch_criteria")?null:TurnBasedMatchConfig.createAutoMatchCriteria(this.getInteger("automatch_min_players"), this.getInteger("automatch_max_players"), this.getLong("automatch_bit_mask"));
   }

   public int getAvailableAutoMatchSlots() {
      return !this.getBoolean("has_automatch_criteria")?0:this.getInteger("automatch_max_players");
   }

   public long getCreationTimestamp() {
      return this.getLong("creation_timestamp");
   }

   public String getCreatorId() {
      return this.getString("creator_external");
   }

   public byte[] getData() {
      return this.getByteArray("data");
   }

   public String getDescription() {
      return this.getString("description");
   }

   public void getDescription(CharArrayBuffer var1) {
      this.a("description", var1);
   }

   public Participant getDescriptionParticipant() {
      return this.getParticipant(this.getDescriptionParticipantId());
   }

   public String getDescriptionParticipantId() {
      return this.getString("description_participant_id");
   }

   public Game getGame() {
      return this.field_696;
   }

   public long getLastUpdatedTimestamp() {
      return this.getLong("last_updated_timestamp");
   }

   public String getLastUpdaterId() {
      return this.getString("last_updater_external");
   }

   public String getMatchId() {
      return this.getString("external_match_id");
   }

   public int getMatchNumber() {
      return this.getInteger("match_number");
   }

   public Participant getParticipant(String var1) {
      return TurnBasedMatchEntity.method_3439(this, var1);
   }

   public String getParticipantId(String var1) {
      return TurnBasedMatchEntity.method_3438(this, var1);
   }

   public ArrayList<String> getParticipantIds() {
      return TurnBasedMatchEntity.method_3440(this);
   }

   public int getParticipantStatus(String var1) {
      return TurnBasedMatchEntity.method_3435(this, var1);
   }

   public ArrayList<Participant> getParticipants() {
      ArrayList var1 = new ArrayList(this.field_695);

      for(int var2 = 0; var2 < this.field_695; ++var2) {
         var1.add(new ParticipantRef(this.DD, var2 + this.Ez));
      }

      return var1;
   }

   public String getPendingParticipantId() {
      return this.getString("pending_participant_external");
   }

   public byte[] getPreviousMatchData() {
      return this.getByteArray("previous_match_data");
   }

   public String getRematchId() {
      return this.getString("rematch_id");
   }

   public int getStatus() {
      return this.getInteger("status");
   }

   public int getTurnStatus() {
      return this.getInteger("user_match_status");
   }

   public int getVariant() {
      return this.getInteger("variant");
   }

   public int getVersion() {
      return this.getInteger("version");
   }

   public int hashCode() {
      return TurnBasedMatchEntity.method_3434(this);
   }

   public boolean isLocallyModified() {
      return this.getBoolean("upsync_required");
   }

   public String toString() {
      return TurnBasedMatchEntity.method_3437(this);
   }

   public void writeToParcel(Parcel var1, int var2) {
      ((TurnBasedMatchEntity)this.freeze()).writeToParcel(var1, var2);
   }
}
