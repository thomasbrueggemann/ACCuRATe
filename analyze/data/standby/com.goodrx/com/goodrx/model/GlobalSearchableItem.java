package com.goodrx.model;

import android.app.Activity;

public interface GlobalSearchableItem {
   String getSearchDisplay();

   String getSearchType();

   void onClick(Activity var1);
}
