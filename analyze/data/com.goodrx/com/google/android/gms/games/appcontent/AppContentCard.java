package com.google.android.gms.games.appcontent;

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

   Bundle getExtras();

   String getId();

   String getTitle();

   String getType();

   List<AppContentCondition> zzvP();

   String zzvQ();

   List<AppContentAnnotation> zzwa();

   int zzwb();

   String zzwc();

   int zzwd();
}
