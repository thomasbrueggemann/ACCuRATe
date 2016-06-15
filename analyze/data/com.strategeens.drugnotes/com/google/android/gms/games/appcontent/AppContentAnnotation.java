package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface AppContentAnnotation extends Parcelable, Freezable<AppContentAnnotation> {
   String getDescription();

   String getTitle();

   String getType();

   // $FF: renamed from: kL () android.net.Uri
   Uri method_263();
}
