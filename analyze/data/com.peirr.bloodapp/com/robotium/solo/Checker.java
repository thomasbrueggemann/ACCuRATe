package com.robotium.solo;

import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.Waiter;
import java.util.ArrayList;

class Checker {
   private final ViewFetcher viewFetcher;
   private final Waiter waiter;

   public Checker(ViewFetcher var1, Waiter var2) {
      this.viewFetcher = var1;
      this.waiter = var2;
   }

   public <T extends CompoundButton> boolean isButtonChecked(Class<T> var1, int var2) {
      return ((CompoundButton)this.waiter.waitForAndGetView(var2, var1)).isChecked();
   }

   public <T extends CompoundButton> boolean isButtonChecked(Class<T> var1, String var2) {
      CompoundButton var3 = (CompoundButton)this.waiter.waitForText(var1, var2, 0, (long)Timeout.getSmallTimeout(), true);
      return var3 != null && var3.isChecked();
   }

   public boolean isCheckedTextChecked(String var1) {
      CheckedTextView var2 = (CheckedTextView)this.waiter.waitForText(CheckedTextView.class, var1, 0, (long)Timeout.getSmallTimeout(), true);
      return var2 != null && var2.isChecked();
   }

   public boolean isSpinnerTextSelected(int var1, String var2) {
      boolean var3 = ((TextView)((Spinner)this.waiter.waitForAndGetView(var1, Spinner.class)).getChildAt(0)).getText().equals(var2);
      boolean var4 = false;
      if(var3) {
         var4 = true;
      }

      return var4;
   }

   public boolean isSpinnerTextSelected(String var1) {
      this.waiter.waitForAndGetView(0, Spinner.class);
      ArrayList var3 = this.viewFetcher.getCurrentViews(Spinner.class, true);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         if(this.isSpinnerTextSelected(var4, var1)) {
            return true;
         }
      }

      return false;
   }
}
