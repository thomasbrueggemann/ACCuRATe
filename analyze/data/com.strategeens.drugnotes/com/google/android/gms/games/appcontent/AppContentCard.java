package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCondition;
import java.util.List;

public interface AppContentCard extends Parcelable, Freezable<AppContentCard> {
   List<AppContentAction> getActions();

   String getDescription();

   Uri getIconImageUri();

   String getTitle();

   String getType();

   // $FF: renamed from: kH () java.util.List
   List<AppContentCondition> method_234();

   // $FF: renamed from: kI () java.lang.String
   String method_235();

   // $FF: renamed from: kL () android.net.Uri
   Uri method_236();

   // $FF: renamed from: kN () java.util.List
   List<AppContentAnnotation> method_237();

   // $FF: renamed from: kO () int
   int method_238();

   // $FF: renamed from: kP () android.os.Bundle
   Bundle method_239();

   // $FF: renamed from: kQ () java.lang.String
   String method_240();

   // $FF: renamed from: kR () int
   int method_241();
}
