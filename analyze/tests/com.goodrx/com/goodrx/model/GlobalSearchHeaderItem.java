package com.goodrx.model;

import android.app.Activity;
import com.goodrx.model.GlobalSearchableItem;

public class GlobalSearchHeaderItem implements GlobalSearchableItem {
   private String name;

   public GlobalSearchHeaderItem(String var1) {
      this.name = var1;
   }

   public String getName() {
      return this.name;
   }

   public String getSearchDisplay() {
      return this.name;
   }

   public String getSearchType() {
      return GlobalSearchHeaderItem.class.getName();
   }

   public void onClick(Activity var1) {
   }
}
