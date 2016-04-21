package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.class_1090;
import java.util.ArrayList;

public final class TurnBasedMatchConfig {
    private final int acD;
    private final int acd;
    private final String[] acr;
    private final Bundle acs;

    private TurnBasedMatchConfig(TurnBasedMatchConfig.Builder var1) {
        this.acd = var1.acd;
        this.acD = var1.acD;
        this.acs = var1.acs;
        int var2 = var1.acv.size();
        this.acr = (String[])var1.acv.toArray(new String[var2]);
    }

    // $FF: synthetic method
    TurnBasedMatchConfig(TurnBasedMatchConfig.Builder var1, Object var2) {
        this(var1);
    }

    public static TurnBasedMatchConfig.Builder builder() {
        return new TurnBasedMatchConfig.Builder();
    }

    public static Bundle createAutoMatchCriteria(int var0, int var1, long var2) {
        Bundle var4 = new Bundle();
        var4.putInt("min_automatch_players", var0);
        var4.putInt("max_automatch_players", var1);
        var4.putLong("exclusive_bit_mask", var2);
        return var4;
    }

    public Bundle getAutoMatchCriteria() {
        return this.acs;
    }

    public String[] getInvitedPlayerIds() {
        return this.acr;
    }

    public int getVariant() {
        return this.acd;
    }

    // $FF: renamed from: lH () int
    public int method_5253() {
        return this.acD;
    }

    public static final class Builder {
        int acD;
        int acd;
        Bundle acs;
        ArrayList<String> acv;

        private Builder() {
            this.acd = -1;
            this.acv = new ArrayList();
            this.acs = null;
            this.acD = 2;
        }

        // $FF: synthetic method
        Builder(Object var1) {
            this();
        }

        public TurnBasedMatchConfig.Builder addInvitedPlayer(String var1) {
            class_1090.method_5685(var1);
            this.acv.add(var1);
            return this;
        }

        public TurnBasedMatchConfig.Builder addInvitedPlayers(ArrayList<String> var1) {
            class_1090.method_5685(var1);
            this.acv.addAll(var1);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfig(this);
        }

        public TurnBasedMatchConfig.Builder setAutoMatchCriteria(Bundle var1) {
            this.acs = var1;
            return this;
        }

        public TurnBasedMatchConfig.Builder setVariant(int var1) {
            boolean var2;
            if(var1 != -1 && var1 <= 0) {
                var2 = false;
            } else {
                var2 = true;
            }

            class_1090.method_5683(var2, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.acd = var1;
            return this;
        }
    }
}
