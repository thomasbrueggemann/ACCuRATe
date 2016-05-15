package com.goodrx.activity;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.ReminderSettingFragment;

public class ReminderSettingFragment$$ViewBinder<T extends ReminderSettingFragment> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.mTxtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886477, "field \'mTxtTitle\'"), 2131886477, "field \'mTxtTitle\'");
      var2.mTxtRefillDays = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886479, "field \'mTxtRefillDays\'"), 2131886479, "field \'mTxtRefillDays\'");
      var2.mTxtRefillUnit = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886480, "field \'mTxtRefillUnit\'"), 2131886480, "field \'mTxtRefillUnit\'");
      var2.mRefillHeaderLayout = (View)var1.findRequiredView(var3, 2131886476, "field \'mRefillHeaderLayout\'");
      View var4 = (View)var1.findRequiredView(var3, 2131886478, "field \'mRefillDaysLayout\' and method \'onClick\'");
      var2.mRefillDaysLayout = var4;
      var4.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      var2.mTxtRepeatDays = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886488, "field \'mTxtRepeatDays\'"), 2131886488, "field \'mTxtRepeatDays\'");
      var2.mTxtAlertTime = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886484, "field \'mTxtAlertTime\'"), 2131886484, "field \'mTxtAlertTime\'");
      View var5 = (View)var1.findRequiredView(var3, 2131886490, "field \'mSwtReminder\' and method \'onCheckedChanged\'");
      var2.mSwtReminder = (SwitchCompat)var1.castView(var5, 2131886490, "field \'mSwtReminder\'");
      ((CompoundButton)var5).setOnCheckedChangeListener(new OnCheckedChangeListener() {
         public void onCheckedChanged(CompoundButton var1, boolean var2x) {
            var2.onCheckedChanged(var2x);
         }
      });
      var2.mReminderSettingContent = (View)var1.findRequiredView(var3, 2131886475, "field \'mReminderSettingContent\'");
      var2.mScrollview = (View)var1.findRequiredView(var3, 2131886474, "field \'mScrollview\'");
      View var6 = (View)var1.findRequiredView(var3, 2131886481, "field \'mLayoutRefill\' and method \'onClick\'");
      var2.mLayoutRefill = var6;
      var6.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886485, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      ((View)var1.findRequiredView(var3, 2131886482, "method \'onClick\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
   }

   public void unbind(T var1) {
      var1.mTxtTitle = null;
      var1.mTxtRefillDays = null;
      var1.mTxtRefillUnit = null;
      var1.mRefillHeaderLayout = null;
      var1.mRefillDaysLayout = null;
      var1.mTxtRepeatDays = null;
      var1.mTxtAlertTime = null;
      var1.mSwtReminder = null;
      var1.mReminderSettingContent = null;
      var1.mScrollview = null;
      var1.mLayoutRefill = null;
   }
}
