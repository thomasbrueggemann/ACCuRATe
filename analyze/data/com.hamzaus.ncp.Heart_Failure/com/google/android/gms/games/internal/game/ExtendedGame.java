package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
   Game getGame();

   // $FF: renamed from: hL () java.util.ArrayList
   ArrayList<GameBadge> method_236();

   // $FF: renamed from: hM () int
   int method_237();

   // $FF: renamed from: hN () boolean
   boolean method_238();

   // $FF: renamed from: hO () int
   int method_239();

   // $FF: renamed from: hP () long
   long method_240();

   // $FF: renamed from: hQ () long
   long method_241();

   // $FF: renamed from: hR () java.lang.String
   String method_242();

   // $FF: renamed from: hS () long
   long method_243();

   // $FF: renamed from: hT () java.lang.String
   String method_244();

   // $FF: renamed from: hU () com.google.android.gms.games.snapshot.SnapshotMetadata
   SnapshotMetadata method_245();
}
