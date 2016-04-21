package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;

public interface OnTurnBasedMatchUpdateReceivedListener {
    void onTurnBasedMatchReceived(TurnBasedMatch var1);

    void onTurnBasedMatchRemoved(String var1);
}
