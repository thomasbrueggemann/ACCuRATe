package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface MostRecentGameInfo extends Parcelable, Freezable<MostRecentGameInfo> {
   // $FF: renamed from: ik () java.lang.String
   String method_220();

   // $FF: renamed from: il () java.lang.String
   String method_221();

   // $FF: renamed from: im () long
   long method_222();

   // $FF: renamed from: in () android.net.Uri
   Uri method_223();

   // $FF: renamed from: io () android.net.Uri
   Uri method_224();

   // $FF: renamed from: ip () android.net.Uri
   Uri method_225();
}
