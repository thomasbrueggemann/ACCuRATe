package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.SingleChoiceItemWithSubtext;

public class CoPayActivity extends BaseActivityWithPasscode {
   private SingleChoiceItemWithSubtext[] singleChoiceItems;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, CoPayActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968609);
      this.singleChoiceItems = new SingleChoiceItemWithSubtext[4];
      this.singleChoiceItems[0] = (SingleChoiceItemWithSubtext)this.findViewById(2131886258);
      this.singleChoiceItems[1] = (SingleChoiceItemWithSubtext)this.findViewById(2131886259);
      this.singleChoiceItems[2] = (SingleChoiceItemWithSubtext)this.findViewById(2131886260);
      this.singleChoiceItems[3] = (SingleChoiceItemWithSubtext)this.findViewById(2131886261);
      this.singleChoiceItems[0].setChecked(true);
      CoPayActivity.MyOnClickListener var2 = new CoPayActivity.MyOnClickListener();

      for(int var3 = 0; var3 < 4; ++var3) {
         this.singleChoiceItems[var3].setOnClickListener(var2);
         this.singleChoiceItems[var3].setTag(Integer.valueOf(var3));
      }

   }

   private class MyOnClickListener implements OnClickListener {
      private MyOnClickListener() {
      }

      // $FF: synthetic method
      MyOnClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         int var2 = ((Integer)var1.getTag()).intValue();
         SingleChoiceItemWithSubtext[] var3 = CoPayActivity.this.singleChoiceItems;
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            var3[var5].setChecked(false);
         }

         CoPayActivity.this.singleChoiceItems[var2].setChecked(true);
      }
   }
}
