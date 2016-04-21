package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.common.internal.class_1090;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import java.util.ArrayList;

public final class InvitationRef extends class_255 implements Invitation {
    private final Game abx;
    private final ArrayList<Participant> acc;
    private final ParticipantRef acf;

    InvitationRef(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.abx = new GameRef(var1, var2);
        this.acc = new ArrayList(var3);
        String var4 = this.getString("external_inviter_id");
        int var5 = 0;

        ParticipantRef var6;
        for(var6 = null; var5 < var3; ++var5) {
            ParticipantRef var7 = new ParticipantRef(this.II, var5 + this.JX);
            if(var7.getParticipantId().equals(var4)) {
                var6 = var7;
            }

            this.acc.add(var7);
        }

        this.acf = (ParticipantRef)class_1090.method_5681(var6, "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return InvitationEntity.method_3212(this, var1);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        return !this.getBoolean("has_automatch_criteria")?0:this.getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(this.getLong("creation_timestamp"), this.getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.abx;
    }

    public String getInvitationId() {
        return this.getString("external_invitation_id");
    }

    public int getInvitationType() {
        return this.getInteger("type");
    }

    public Participant getInviter() {
        return this.acf;
    }

    public ArrayList<Participant> getParticipants() {
        return this.acc;
    }

    public int getVariant() {
        return this.getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.method_3211(this);
    }

    public String toString() {
        return InvitationEntity.method_3213(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((InvitationEntity)this.freeze()).writeToParcel(var1, var2);
    }
}
