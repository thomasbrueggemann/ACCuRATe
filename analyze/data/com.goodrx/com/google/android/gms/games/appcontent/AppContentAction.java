package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.appcontent.AppContentAnnotation;
import com.google.android.gms.games.appcontent.AppContentCondition;
import java.util.List;

public interface AppContentAction extends Parcelable, Freezable<AppContentAction> {
   Bundle getExtras();

   String getId();

   String getType();

   AppContentAnnotation zzvO();

   List<AppContentCondition> zzvP();

   String zzvQ();

   String zzvR();
}
