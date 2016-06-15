package com.google.android.gms.games.internal.data;

import android.net.Uri;

public final class GamesDataChangeUris {
   // $FF: renamed from: Rg android.net.Uri
   private static final Uri field_2715 = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
   // $FF: renamed from: Rh android.net.Uri
   public static final Uri field_2716;
   // $FF: renamed from: Ri android.net.Uri
   public static final Uri field_2717;

   static {
      field_2716 = field_2715.buildUpon().appendPath("invitations").build();
      field_2717 = field_2715.buildUpon().appendEncodedPath("players").build();
   }
}
