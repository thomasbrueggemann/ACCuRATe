package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;

public final class LoadMatchesResponse {
    private final TurnBasedMatchBuffer acA;
    private final TurnBasedMatchBuffer acB;
    private final TurnBasedMatchBuffer acC;
    private final InvitationBuffer acz;

    public LoadMatchesResponse(Bundle var1) {
        DataHolder var2 = method_5851(var1, 0);
        if(var2 != null) {
            this.acz = new InvitationBuffer(var2);
        } else {
            this.acz = null;
        }

        DataHolder var3 = method_5851(var1, 1);
        if(var3 != null) {
            this.acA = new TurnBasedMatchBuffer(var3);
        } else {
            this.acA = null;
        }

        DataHolder var4 = method_5851(var1, 2);
        if(var4 != null) {
            this.acB = new TurnBasedMatchBuffer(var4);
        } else {
            this.acB = null;
        }

        DataHolder var5 = method_5851(var1, 3);
        if(var5 != null) {
            this.acC = new TurnBasedMatchBuffer(var5);
        } else {
            this.acC = null;
        }
    }

    // $FF: renamed from: a (android.os.Bundle, int) com.google.android.gms.common.data.DataHolder
    private static DataHolder method_5851(Bundle var0, int var1) {
        String var2 = TurnBasedMatchTurnStatus.method_5418(var1);
        return !var0.containsKey(var2)?null:(DataHolder)var0.getParcelable(var2);
    }

    public void close() {
        if(this.acz != null) {
            this.acz.close();
        }

        if(this.acA != null) {
            this.acA.close();
        }

        if(this.acB != null) {
            this.acB.close();
        }

        if(this.acC != null) {
            this.acC.close();
        }

    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.acC;
    }

    public InvitationBuffer getInvitations() {
        return this.acz;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.acA;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.acB;
    }

    public boolean hasData() {
        return this.acz != null && this.acz.getCount() > 0 || this.acA != null && this.acA.getCount() > 0 || this.acB != null && this.acB.getCount() > 0 || this.acC != null && this.acC.getCount() > 0;
    }
}
