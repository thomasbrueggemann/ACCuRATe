package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable<MostRecentGameInfo> {
   // $FF: renamed from: mA () android.net.Uri
   Uri method_246();

   // $FF: renamed from: mB () android.net.Uri
   Uri method_247();

   // $FF: renamed from: mw () java.lang.String
   String method_248();

   // $FF: renamed from: mx () java.lang.String
   String method_249();

   // $FF: renamed from: my () long
   long method_250();

   // $FF: renamed from: mz () android.net.Uri
   Uri method_251();
}
