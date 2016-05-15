package com.goodrx.model;

import android.app.Activity;
import com.goodrx.activity.pillid.PillIdActivity;
import com.goodrx.model.GlobalSearchableItem;

public class ImprintResult implements GlobalSearchableItem {
   private String display;

   public ImprintResult(String var1) {
      this.display = var1;
   }

   public String getDisplay() {
      return this.display;
   }

   public String getSearchDisplay() {
      return this.display;
   }

   public String getSearchType() {
      return ImprintResult.class.getName();
   }

   public void onClick(Activity var1) {
      PillIdActivity.launch(var1, this.display);
   }
}
