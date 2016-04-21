package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchEntity;
import java.util.ArrayList;

public final class TurnBasedMatchRef extends class_255 implements TurnBasedMatch {
    private final int aaK;
    private final Game abx;

    TurnBasedMatchRef(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.abx = new GameRef(var1, var2);
        this.aaK = var3;
    }

    public boolean canRematch() {
        return this.getTurnStatus() == 3 && this.getRematchId() == null && this.getParticipants().size() > 1;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return TurnBasedMatchEntity.method_4380(this, var1);
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
        String var1 = this.getDescriptionParticipantId();
        return var1 == null?null:this.getParticipant(var1);
    }

    public String getDescriptionParticipantId() {
        return this.getString("description_participant_id");
    }

    public Game getGame() {
        return this.abx;
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
        return TurnBasedMatchEntity.method_4383(this, var1);
    }

    public String getParticipantId(String var1) {
        return TurnBasedMatchEntity.method_4382(this, var1);
    }

    public ArrayList<String> getParticipantIds() {
        return TurnBasedMatchEntity.method_4384(this);
    }

    public int getParticipantStatus(String var1) {
        return TurnBasedMatchEntity.method_4379(this, var1);
    }

    public ArrayList<Participant> getParticipants() {
        ArrayList var1 = new ArrayList(this.aaK);

        for(int var2 = 0; var2 < this.aaK; ++var2) {
            var1.add(new ParticipantRef(this.II, var2 + this.JX));
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
        return TurnBasedMatchEntity.method_4378(this);
    }

    public boolean isLocallyModified() {
        return this.getBoolean("upsync_required");
    }

    public String toString() {
        return TurnBasedMatchEntity.method_4381(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((TurnBasedMatchEntity)this.freeze()).writeToParcel(var1, var2);
    }
}
