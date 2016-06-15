package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentCard;
import java.util.List;

public interface AppContentSection extends Parcelable, Freezable<AppContentSection> {
   List<AppContentAction> getActions();

   String getTitle();

   String getType();

   // $FF: renamed from: kI () java.lang.String
   String method_258();

   // $FF: renamed from: kP () android.os.Bundle
   Bundle method_259();

   // $FF: renamed from: kQ () java.lang.String
   String method_260();

   // $FF: renamed from: kY () android.net.Uri
   Uri method_261();

   // $FF: renamed from: kZ () java.util.List
   List<AppContentCard> method_262();
}
