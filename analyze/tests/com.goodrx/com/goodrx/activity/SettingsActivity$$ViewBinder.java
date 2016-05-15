package com.goodrx.activity;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.SettingsActivity;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.SettingItemWithSwitch;

public class SettingsActivity$$ViewBinder<T extends SettingsActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.viewNotLogin = (View)var1.findRequiredView(var3, 2131886733, "field \'viewNotLogin\'");
      var2.viewAccountInfo = (View)var1.findRequiredView(var3, 2131886735, "field \'viewAccountInfo\'");
      var2.viewPasscodeDetail = (View)var1.findRequiredView(var3, 2131886728, "field \'viewPasscodeDetail\'");
      var2.txtEmail = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886737, "field \'txtEmail\'"), 2131886737, "field \'txtEmail\'");
      var2.txtpasscodeValidDuration = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886730, "field \'txtpasscodeValidDuration\'"), 2131886730, "field \'txtpasscodeValidDuration\'");
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
      var2.scPasscode = (SettingItemWithSwitch)var1.castView((View)var1.findRequiredView(var3, 2131886727, "field \'scPasscode\'"), 2131886727, "field \'scPasscode\'");
      ((View)var1.findRequiredView(var3, 2131886734, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886354, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886738, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886732, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886729, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886731, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886720, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886721, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886722, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886723, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
   }

   public void unbind(T var1) {
      var1.viewNotLogin = null;
      var1.viewAccountInfo = null;
      var1.viewPasscodeDetail = null;
      var1.txtEmail = null;
      var1.txtpasscodeValidDuration = null;
      var1.myProgressBar = null;
      var1.scPasscode = null;
   }
}
