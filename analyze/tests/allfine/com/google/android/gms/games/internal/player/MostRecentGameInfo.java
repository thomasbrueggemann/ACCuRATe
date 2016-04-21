package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable<MostRecentGameInfo> {
    // $FF: renamed from: lp () java.lang.String
    String method_196();

    // $FF: renamed from: lq () java.lang.String
    String method_197();

    // $FF: renamed from: lr () long
    long method_198();

    // $FF: renamed from: ls () android.net.Uri
    Uri method_199();

    // $FF: renamed from: lt () android.net.Uri
    Uri method_200();

    // $FF: renamed from: lu () android.net.Uri
    Uri method_201();
}
