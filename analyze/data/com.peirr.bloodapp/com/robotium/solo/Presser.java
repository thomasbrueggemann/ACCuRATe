package com.robotium.solo;

import android.app.Instrumentation;
import android.widget.EditText;
import android.widget.Spinner;
import com.robotium.solo.Clicker;
import com.robotium.solo.DialogUtils;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.Waiter;
import junit.framework.Assert;

class Presser {
   private final Clicker clicker;
   private final DialogUtils dialogUtils;
   private final Instrumentation inst;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;
   private final Waiter waiter;

   public Presser(ViewFetcher var1, Clicker var2, Instrumentation var3, Sleeper var4, Waiter var5, DialogUtils var6) {
      this.viewFetcher = var1;
      this.clicker = var2;
      this.inst = var3;
      this.sleeper = var4;
      this.waiter = var5;
      this.dialogUtils = var6;
   }

   public void pressMenuItem(int var1) {
      this.pressMenuItem(var1, 3);
   }

   public void pressMenuItem(int var1, int var2) {
      int[] var3 = new int[4];

      for(int var4 = 1; var4 <= 3; ++var4) {
         var3[var4] = var2 * var4;
      }

      this.sleeper.sleep();

      try {
         this.inst.sendKeyDownUpSync(82);
         this.dialogUtils.waitForDialogToOpen((long)Timeout.getSmallTimeout(), true);
         this.inst.sendKeyDownUpSync(19);
         this.inst.sendKeyDownUpSync(19);
      } catch (SecurityException var11) {
         Assert.fail("Can not press the menu!");
      }

      if(var1 < var3[1]) {
         for(int var9 = 0; var9 < var1; ++var9) {
            this.sleeper.sleepMini();
            this.inst.sendKeyDownUpSync(22);
         }
      } else if(var1 >= var3[1] && var1 < var3[2]) {
         this.inst.sendKeyDownUpSync(20);

         for(int var8 = var3[1]; var8 < var1; ++var8) {
            this.sleeper.sleepMini();
            this.inst.sendKeyDownUpSync(22);
         }
      } else if(var1 >= var3[2]) {
         this.inst.sendKeyDownUpSync(20);
         this.inst.sendKeyDownUpSync(20);

         for(int var7 = var3[2]; var7 < var1; ++var7) {
            this.sleeper.sleepMini();
            this.inst.sendKeyDownUpSync(22);
         }
      }

      try {
         this.inst.sendKeyDownUpSync(66);
      } catch (SecurityException var10) {
         ;
      }
   }

   public void pressSoftKeyboardSearchOrNextButton(final boolean var1) {
      final EditText var2 = (EditText)this.viewFetcher.getFreshestView(this.viewFetcher.getCurrentViews(EditText.class, true));
      if(var2 != null) {
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               if(var1) {
                  var2.onEditorAction(3);
               } else {
                  var2.onEditorAction(5);
               }
            }
         });
      }

   }

   public void pressSpinnerItem(int var1, int var2) {
      this.clicker.clickOnScreen(this.waiter.waitForAndGetView(var1, Spinner.class));
      this.dialogUtils.waitForDialogToOpen((long)Timeout.getSmallTimeout(), true);

      try {
         this.inst.sendKeyDownUpSync(20);
      } catch (SecurityException var13) {
         ;
      }

      boolean var5 = true;
      if(var2 < 0) {
         var5 = false;
         var2 *= -1;
      }

      for(int var6 = 0; var6 < var2; ++var6) {
         this.sleeper.sleepMini();
         if(var5) {
            try {
               this.inst.sendKeyDownUpSync(20);
            } catch (SecurityException var11) {
               ;
            }
         } else {
            try {
               this.inst.sendKeyDownUpSync(19);
            } catch (SecurityException var12) {
               ;
            }
         }
      }

      try {
         this.inst.sendKeyDownUpSync(66);
      } catch (SecurityException var10) {
         ;
      }
   }
}
