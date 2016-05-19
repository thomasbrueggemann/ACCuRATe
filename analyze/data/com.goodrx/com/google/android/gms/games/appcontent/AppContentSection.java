package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.appcontent.AppContentAction;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCard;
import java.util.List;

public interface AppContentSection extends Parcelable, Freezable<AppContentSection> {
   List<AppContentAction> getActions();

   Bundle getExtras();

   String getId();

   String getTitle();

   String getType();

   String zzvQ();

   List<AppContentAnnotation> zzwa();

   String zzwc();

   List<AppContentCard> zzwk();

   String zzwl();
}
