package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends class_255 implements GameRequest {
    private final int aaK;

    public GameRequestRef(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.aaK = var3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return GameRequestEntity.method_4026(this, var1);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return this.getLong("creation_timestamp");
    }

    public byte[] getData() {
        return this.getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return this.getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.II, this.JX);
    }

    public int getRecipientStatus(String var1) {
        for(int var2 = this.JX; var2 < this.JX + this.aaK; ++var2) {
            int var3 = this.II.method_5987(var2);
            if(this.II.method_5989("recipient_external_player_id", var2, var3).equals(var1)) {
                return this.II.method_5988("recipient_status", var2, var3);
            }
        }

        return -1;
    }

    public List<Player> getRecipients() {
        ArrayList var1 = new ArrayList(this.aaK);

        for(int var2 = 0; var2 < this.aaK; ++var2) {
            var1.add(new PlayerRef(this.II, var2 + this.JX, "recipient_"));
        }

        return var1;
    }

    public String getRequestId() {
        return this.getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.II, this.gz(), "sender_");
    }

    public int getStatus() {
        return this.getInteger("status");
    }

    public int getType() {
        return this.getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.method_4025(this);
    }

    public boolean isConsumed(String var1) {
        return this.getRecipientStatus(var1) == 1;
    }

    public String toString() {
        return GameRequestEntity.method_4028(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((GameRequestEntity)this.freeze()).writeToParcel(var1, var2);
    }
}
