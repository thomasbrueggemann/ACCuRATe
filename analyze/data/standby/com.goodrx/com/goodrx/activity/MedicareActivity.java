package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.goodrx.activity.CoPayActivity;
import com.goodrx.activity.PlanActivity;
import com.goodrx.activity.ZipActivity;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.ClickableItemWithSubtext;

public class MedicareActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, MedicareActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void onBackPressed() {
      super.onBackPressed();
      this.overridePendingTransition(2131034131, 2131034139);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968623);
      ClickableItemWithSubtext var2 = (ClickableItemWithSubtext)this.findViewById(2131886299);
      ClickableItemWithSubtext var3 = (ClickableItemWithSubtext)this.findViewById(2131886300);
      ClickableItemWithSubtext var4 = (ClickableItemWithSubtext)this.findViewById(2131886301);
      MedicareActivity.OnButtonClickListener var5 = new MedicareActivity.OnButtonClickListener();
      var2.setOnClickListener(var5);
      var3.setOnClickListener(var5);
      var4.setOnClickListener(var5);
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      if(var1.getItemId() == 16908332) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   private class OnButtonClickListener implements OnClickListener {
      private OnButtonClickListener() {
      }

      // $FF: synthetic method
      OnButtonClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         int var2 = var1.getId();
         if(var2 == 2131886299) {
            ZipActivity.launch(MedicareActivity.this);
         } else {
            if(var2 == 2131886300) {
               PlanActivity.launch(MedicareActivity.this);
               return;
            }

            if(var2 == 2131886301) {
               CoPayActivity.launch(MedicareActivity.this);
               return;
            }
         }

      }
   }
}
