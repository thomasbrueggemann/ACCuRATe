package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class TurnBasedMatchTurnStatus {
    // $FF: renamed from: dH (int) java.lang.String
    public static String method_5418(int var0) {
        switch(var0) {
            case 0:
                return "TURN_STATUS_INVITED";
            case 1:
                return "TURN_STATUS_MY_TURN";
            case 2:
                return "TURN_STATUS_THEIR_TURN";
            case 3:
                return "TURN_STATUS_COMPLETE";
            default:
                GamesLog.method_6006("MatchTurnStatus", "Unknown match turn status: " + var0);
                return "TURN_STATUS_UNKNOWN";
        }
    }
}
