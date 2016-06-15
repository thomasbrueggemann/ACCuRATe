package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.appcontent.AppContentCondition;
import java.util.List;

public interface AppContentAction extends Parcelable, Freezable<AppContentAction> {
   Bundle getExtras();

   String getLabel();

   String getType();

   // $FF: renamed from: kH () java.util.List
   List<AppContentCondition> method_226();

   // $FF: renamed from: kI () java.lang.String
   String method_227();

   // $FF: renamed from: kJ () java.lang.String
   String method_228();
}
