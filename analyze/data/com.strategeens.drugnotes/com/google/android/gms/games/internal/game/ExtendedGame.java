package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
   Game getGame();

   // $FF: renamed from: lY () java.util.ArrayList
   ArrayList<GameBadge> method_266();

   // $FF: renamed from: lZ () int
   int method_267();

   // $FF: renamed from: ma () boolean
   boolean method_268();

   // $FF: renamed from: mb () int
   int method_269();

   // $FF: renamed from: mc () long
   long method_270();

   // $FF: renamed from: md () long
   long method_271();

   // $FF: renamed from: me () java.lang.String
   String method_272();

   // $FF: renamed from: mf () long
   long method_273();

   // $FF: renamed from: mg () java.lang.String
   String method_274();

   // $FF: renamed from: mh () com.google.android.gms.games.snapshot.SnapshotMetadata
   SnapshotMetadata method_275();
}
