package com.google.android.gms.games.internal.data;

import android.net.Uri;

public final class GamesDataChangeUris {
   private static final Uri ach = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
   public static final Uri aci;
   public static final Uri acj;

   static {
      aci = ach.buildUpon().appendPath("invitations").build();
      acj = ach.buildUpon().appendEncodedPath("players").build();
   }
}
