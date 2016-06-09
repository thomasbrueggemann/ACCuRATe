package com.robotium.solo;

import android.app.Instrumentation;
import android.widget.EditText;
import com.robotium.solo.Clicker;
import com.robotium.solo.DialogUtils;
import junit.framework.Assert;

class TextEnterer {
   private final Clicker clicker;
   private final DialogUtils dialogUtils;
   private final Instrumentation inst;

   public TextEnterer(Instrumentation var1, Clicker var2, DialogUtils var3) {
      this.inst = var1;
      this.clicker = var2;
      this.dialogUtils = var3;
   }

   public void setEditText(final EditText var1, final String var2) {
      if(var1 != null) {
         final String var3 = var1.getText().toString();
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               var1.setInputType(0);
               var1.performClick();
               TextEnterer.this.dialogUtils.hideSoftKeyboard(var1, false, false);
               if(var2.equals("")) {
                  var1.setText(var2);
               } else {
                  var1.setText(var3 + var2);
                  var1.setCursorVisible(false);
               }
            }
         });
      }

   }

   public void typeText(final EditText var1, String var2) {
      if(var1 != null) {
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               var1.setInputType(0);
            }
         });
         this.clicker.clickOnScreen(var1, false, 0);
         this.dialogUtils.hideSoftKeyboard(var1, true, true);
         boolean var3 = false;
         int var4 = 0;

         while(!var3 && var4 < 10) {
            try {
               this.inst.sendStringSync(var2);
            } catch (SecurityException var6) {
               this.dialogUtils.hideSoftKeyboard(var1, true, true);
               ++var4;
               continue;
            }

            var3 = true;
         }

         if(!var3) {
            Assert.fail("Text can not be typed!");
         }
      }

   }
}
