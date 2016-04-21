package com.google.android.gms.games.internal.game;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.internal.game.GameBadge;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import java.util.ArrayList;

public interface ExtendedGame extends Parcelable, Freezable<ExtendedGame> {
    Game getGame();

    // $FF: renamed from: kR () java.util.ArrayList
    ArrayList<GameBadge> method_210();

    // $FF: renamed from: kS () int
    int method_211();

    // $FF: renamed from: kT () boolean
    boolean method_212();

    // $FF: renamed from: kU () int
    int method_213();

    // $FF: renamed from: kV () long
    long method_214();

    // $FF: renamed from: kW () long
    long method_215();

    // $FF: renamed from: kX () java.lang.String
    String method_216();

    // $FF: renamed from: kY () long
    long method_217();

    // $FF: renamed from: kZ () java.lang.String
    String method_218();

    // $FF: renamed from: la () com.google.android.gms.games.snapshot.SnapshotMetadata
    SnapshotMetadata method_219();
}
