package com.google.android.gms.games.internal.data;

import android.net.Uri;

public final class GamesDataChangeUris {
    private static final Uri aan = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
    public static final Uri aao;
    public static final Uri aap;

    static {
        aao = aan.buildUpon().appendPath("invitations").build();
        aap = aan.buildUpon().appendEncodedPath("players").build();
    }
}
