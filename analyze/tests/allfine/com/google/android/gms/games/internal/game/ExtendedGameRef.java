package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.class_255;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.internal.game.ExtendedGame;
import com.google.android.gms.games.internal.game.ExtendedGameEntity;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.internal.game.GameBadgeRef;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataRef;
import java.util.ArrayList;

public class ExtendedGameRef extends class_255 implements ExtendedGame {
    private final SnapshotMetadataRef aaJ;
    private final int aaK;
    private final GameRef aax;

    ExtendedGameRef(DataHolder var1, int var2, int var3) {
        super(var1, var2);
        this.aax = new GameRef(var1, var2);
        this.aaK = var3;
        if(this.aQ("external_snapshot_id") && !this.aS("external_snapshot_id")) {
            this.aaJ = new SnapshotMetadataRef(var1, var2);
        } else {
            this.aaJ = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object var1) {
        return ExtendedGameEntity.method_3204(this, var1);
    }

    // $FF: synthetic method
    public Object freeze() {
        return this.method_1674();
    }

    public Game getGame() {
        return this.aax;
    }

    public int hashCode() {
        return ExtendedGameEntity.method_3203(this);
    }

    // $FF: renamed from: kR () java.util.ArrayList
    public ArrayList<GameBadge> method_210() {
        int var1 = 0;
        if(this.II.method_5989("badge_title", this.JX, this.II.method_5987(this.JX)) == null) {
            return new ArrayList(0);
        } else {
            ArrayList var2;
            for(var2 = new ArrayList(this.aaK); var1 < this.aaK; ++var1) {
                var2.add(new GameBadgeRef(this.II, var1 + this.JX));
            }

            return var2;
        }
    }

    // $FF: renamed from: kS () int
    public int method_211() {
        return this.getInteger("availability");
    }

    // $FF: renamed from: kT () boolean
    public boolean method_212() {
        return this.getBoolean("owned");
    }

    // $FF: renamed from: kU () int
    public int method_213() {
        return this.getInteger("achievement_unlocked_count");
    }

    // $FF: renamed from: kV () long
    public long method_214() {
        return this.getLong("last_played_server_time");
    }

    // $FF: renamed from: kW () long
    public long method_215() {
        return this.getLong("price_micros");
    }

    // $FF: renamed from: kX () java.lang.String
    public String method_216() {
        return this.getString("formatted_price");
    }

    // $FF: renamed from: kY () long
    public long method_217() {
        return this.getLong("full_price_micros");
    }

    // $FF: renamed from: kZ () java.lang.String
    public String method_218() {
        return this.getString("formatted_full_price");
    }

    // $FF: renamed from: la () com.google.android.gms.games.snapshot.SnapshotMetadata
    public SnapshotMetadata method_219() {
        return this.aaJ;
    }

    // $FF: renamed from: lc () com.google.android.gms.games.internal.game.ExtendedGame
    public ExtendedGame method_1674() {
        return new ExtendedGameEntity(this);
    }

    public String toString() {
        return ExtendedGameEntity.method_3205(this);
    }

    public void writeToParcel(Parcel var1, int var2) {
        ((ExtendedGameEntity)this.method_1674()).writeToParcel(var1, var2);
    }
}
