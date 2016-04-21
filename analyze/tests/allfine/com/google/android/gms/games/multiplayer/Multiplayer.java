package com.google.android.gms.games.multiplayer;

public interface Multiplayer {
    String EXTRA_EXCLUSIVE_BIT_MASK = "exclusive_bit_mask";
    String EXTRA_INVITATION = "invitation";
    String EXTRA_MAX_AUTOMATCH_PLAYERS = "max_automatch_players";
    String EXTRA_MIN_AUTOMATCH_PLAYERS = "min_automatch_players";
    String EXTRA_ROOM = "room";
    String EXTRA_TURN_BASED_MATCH = "turn_based_match";
    int MAX_RELIABLE_MESSAGE_LEN = 1400;
    int MAX_UNRELIABLE_MESSAGE_LEN = 1168;
    int SORT_ORDER_MOST_RECENT_FIRST = 0;
    int SORT_ORDER_SOCIAL_AGGREGATION = 1;
}
