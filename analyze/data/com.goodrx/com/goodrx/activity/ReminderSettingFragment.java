package com.goodrx.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.goodrx.activity.BaseFragmentWitGA;
import com.goodrx.model.MyRx;
import com.goodrx.utils.DialogHelper;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;
import com.goodrx.utils.api.GoodRxAPI;
import com.goodrx.utils.api.OnRequestFinishListener;
import com.goodrx.utils.tracker.GAHelper;
import com.goodrx.widget.DateTimePicker;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;
import org.droidparts.widget.ClearableEditText;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class ReminderSettingFragment extends BaseFragmentWitGA {
   private static final String RX_JSON = "rx_json";
   View mLayoutRefill;
   View mRefillDaysLayout;
   View mRefillHeaderLayout;
   View mReminderSettingContent;
   private MyRx mRx;
   View mScrollview;
   SwitchCompat mSwtReminder;
   TextView mTxtAlertTime;
   TextView mTxtRefillDays;
   TextView mTxtRefillUnit;
   TextView mTxtRepeatDays;
   TextView mTxtTitle;

   public static ReminderSettingFragment newInstance(String var0) {
      ReminderSettingFragment var1 = new ReminderSettingFragment();
      Bundle var2 = new Bundle();
      var2.putString("rx_json", var0);
      var1.setArguments(var2);
      return var1;
   }

   private void showReminderContent(final boolean var1) {
      ObjectAnimator var2 = ObjectAnimator.ofFloat(this.mScrollview, View.ALPHA, new float[]{1.0F, 0.0F});
      var2.setInterpolator(new AccelerateDecelerateInterpolator());
      var2.setDuration(500L);
      var2.addListener(new AnimatorListenerAdapter() {
         public void onAnimationEnd(Animator var1x) {
            super.onAnimationEnd(var1x);
            if(var1) {
               ReminderSettingFragment.this.mReminderSettingContent.setVisibility(0);
            } else {
               ReminderSettingFragment.this.mReminderSettingContent.setVisibility(8);
            }

            ObjectAnimator var2 = ObjectAnimator.ofFloat(ReminderSettingFragment.this.mScrollview, View.ALPHA, new float[]{0.0F, 1.0F});
            var2.setInterpolator(new AccelerateDecelerateInterpolator());
            var2.setDuration(500L);
            var2.start();
         }
      });
      var2.start();
   }

   public void animateBackgroundColor(int var1) {
      int var2 = Utils.getBackgroundColor(this.mRefillHeaderLayout);
      int var3 = Utils.getBackgroundColor(this.mRefillDaysLayout);
      int[] var4 = this.getBackgroundColorForReminder(var1);
      int var5 = var4[0];
      int var6 = var4[1];
      ObjectAnimator var7 = ObjectAnimator.ofInt(this.mRefillHeaderLayout, "backgroundColor", new int[]{var2, var5});
      var7.setEvaluator(new ArgbEvaluator());
      ObjectAnimator var8 = ObjectAnimator.ofInt(this.mRefillDaysLayout, "backgroundColor", new int[]{var3, var6});
      var8.setEvaluator(new ArgbEvaluator());
      AnimatorSet var9 = new AnimatorSet();
      var9.playTogether(new Animator[]{var7, var8});
      var9.setDuration(3000L);
      var9.start();
   }

   public int[] getBackgroundColorForReminder(int var1) {
      int[] var2 = new int[2];
      if(var1 > 1) {
         var2[0] = ContextCompat.getColor(this.getActivity(), 2131755023);
         var2[1] = ContextCompat.getColor(this.getActivity(), 2131755021);
         return var2;
      } else if(var1 >= 0) {
         var2[0] = ContextCompat.getColor(this.getActivity(), 2131755110);
         var2[1] = ContextCompat.getColor(this.getActivity(), 2131755109);
         return var2;
      } else {
         var2[0] = ContextCompat.getColor(this.getActivity(), 2131755130);
         var2[1] = ContextCompat.getColor(this.getActivity(), 2131755129);
         return var2;
      }
   }

   void onCheckedChanged(boolean var1) {
      if(this.mRx.getReminder().isActive() != var1) {
         this.mRx.getReminder().setActive(var1);
         this.saveReminder(this.mRx);
         this.showReminderContent(var1);
      }
   }

   void onClick(View var1) {
      int var2 = var1.getId();
      if(var2 == 2131886485) {
         this.showIntervalPickerDialog();
      } else if(var2 != 2131886482 && var2 != 2131886478) {
         if(var2 == 2131886481) {
            this.mRx.getReminder().rescheduleNextDate(this.mRx.getReminder().getInterval());
            this.saveReminder(this.mRx);
            this.updateUI(true);
            return;
         }
      } else if(this.isAdded()) {
         (new DateTimePicker(this.getActivity(), this.mRx.getReminder().getCombinedNextDate()) {
            public void onDateTimeChanged(DateTime var1) {
               DateTime var2 = var1.toDateTime(DateTimeZone.UTC);
               ReminderSettingFragment.this.mRx.getReminder().setNext_date(var2.getYear(), var2.getMonthOfYear(), var2.getDayOfMonth(), var2.getHourOfDay(), var2.getMinuteOfHour());
               ReminderSettingFragment.this.mRx.getReminder().setTime_of_day(var1.getHourOfDay(), var1.getMinuteOfHour());
               ReminderSettingFragment.this.saveReminder(ReminderSettingFragment.this.mRx);
               ReminderSettingFragment.this.updateUI(true);
            }
         }).show();
         return;
      }

   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if(this.getArguments() != null) {
         String var2 = this.getArguments().getString("rx_json");
         Gson var3 = new Gson();
         Object var4;
         if(!(var3 instanceof Gson)) {
            var4 = var3.fromJson(var2, MyRx.class);
         } else {
            var4 = GsonInstrumentation.fromJson((Gson)var3, var2, MyRx.class);
         }

         this.mRx = (MyRx)var4;
      }

   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      View var4 = var1.inflate(2130968689, var2, false);
      ButterKnife.bind(this, var4);
      this.updateUI(false);
      return var4;
   }

   public void onDestroyView() {
      super.onDestroyView();
      ButterKnife.unbind(this);
   }

   public void onResume() {
      super.onResume();
      GAHelper.sendGoogleAnalyticsScreenView(this.getActivity(), 2131427858);
   }

   public void saveReminder(final MyRx var1) {
      GoodRxAPI.getInstance().saveReminder(this.getActivity(), var1, new OnRequestFinishListener() {
         public void onSuccess(String var1x) {
            if(ReminderSettingFragment.this.isAdded()) {
               MyRxUtils.updateReminder(ReminderSettingFragment.this.getActivity(), var1);
               Intent var2 = new Intent();
               Gson var3 = new Gson();
               MyRx var4 = var1;
               String var5;
               if(!(var3 instanceof Gson)) {
                  var5 = var3.toJson((Object)var4);
               } else {
                  var5 = GsonInstrumentation.toJson((Gson)var3, (Object)var4);
               }

               var2.putExtra("my_rx", var5);
               if(ReminderSettingFragment.this.mSwtReminder.isChecked() && !MyRxUtils.isNotificationEnabled(ReminderSettingFragment.this.getActivity())) {
                  MyRxUtils.setNotificationEnabled(ReminderSettingFragment.this.getActivity(), true);
                  return;
               }
            }

         }
      });
   }

   public void setInterval(int var1) {
      this.mRx.getReminder().setInterval(var1);
      this.mRx.getReminder().rescheduleNextDate(var1);
      this.saveReminder(this.mRx);
      this.updateUI(true);
   }

   public void showCustomNumberEnterDialog() {
      if(this.isAdded()) {
         View var1 = View.inflate(this.getActivity(), 2130968670, (ViewGroup)null);
         final ClearableEditText var2 = (ClearableEditText)var1.findViewById(2131886422);
         var2.setHint(this.getResources().getString(2131427566));
         var2.setInputType(2);
         var2.addTextChangedListener(new TextWatcher() {
            // $FF: synthetic field
            final Toast val$toast;

            {
               this.val$toast = var2;
            }

            public void afterTextChanged(Editable var1) {
               if(var1.length() > 0) {
                  int var2 = Integer.valueOf(var1.toString()).intValue();
                  if(var2 > 500 || var2 == 0) {
                     var1.delete(-1 + var1.length(), var1.length());
                     if(!this.val$toast.getView().isShown()) {
                        this.val$toast.show();
                     }
                  }
               }

            }

            public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }

            public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }
         });
         AlertDialog.Builder var3 = DialogHelper.dialogWithCustomViewBuilder(this.getActivity(), 2131427707, var1);
         var3.setNegativeButton(2131427459, (OnClickListener)null);
         var3.setPositiveButton(2131427537, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2x) {
               if(var2.getText().toString().length() != 0) {
                  int var3 = Integer.valueOf(var2.getText().toString()).intValue();
                  ReminderSettingFragment.this.setInterval(var3);
               }
            }
         });
         var3.show();
      }
   }

   public void showIntervalPickerDialog() {
      if(this.isAdded()) {
         final NumberPicker var1 = new NumberPicker(this.getActivity());
         final int[] var2 = new int[]{3, 5, 7, 10, 14, 21, 28, 30, 60, 84, 90, 180};
         int var3 = this.mRx.getReminder().getInterval();
         if(ArrayUtils.indexOf(var2, var3) == -1) {
            var2 = ArrayUtils.add(var2, var3);
            Arrays.sort(var2);
         }

         String[] var4 = new String[var2.length];

         for(int var5 = 0; var5 < var2.length; ++var5) {
            var4[var5] = String.valueOf(var2[var5]);
         }

         var1.setDisplayedValues(var4);
         var1.setMinValue(0);
         var1.setMaxValue(-1 + var4.length);
         var1.setValue(ArrayUtils.indexOf(var2, var3));
         var1.setDescendantFocusability(393216);
         AlertDialog.Builder var6 = DialogHelper.dialogWithCustomViewBuilder(this.getActivity(), 2131427892, var1);
         var6.setPositiveButton(2131427709, new OnClickListener() {
            public void onClick(DialogInterface var1x, int var2x) {
               int var3 = var2[var1.getValue()];
               ReminderSettingFragment.this.setInterval(var3);
            }
         });
         var6.setNeutralButton(2131427517, new OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
               ReminderSettingFragment.this.showCustomNumberEnterDialog();
            }
         });
         var6.setNegativeButton(2131427459, (OnClickListener)null);
         Dialog var10 = DialogHelper.showDialog(var6);
         if(var10 != null) {
            var10.getWindow().clearFlags(131080);
            var10.getWindow().setSoftInputMode(4);
            return;
         }
      }

   }

   public void updateUI(boolean var1) {
      if(this.isAdded()) {
         this.mSwtReminder.setChecked(this.mRx.getReminder().isActive());
         if(this.mRx.getReminder().isActive()) {
            this.mReminderSettingContent.setVisibility(0);
         } else {
            this.mReminderSettingContent.setVisibility(8);
         }

         int var2 = this.mRx.getReminder().getDayLeft();
         if(var2 > 1) {
            this.mTxtTitle.setText(2131427778);
            this.mTxtRefillDays.setVisibility(0);
            this.mTxtRefillDays.setText(String.valueOf(var2));
            this.mTxtRefillUnit.setText(2131427521);
         } else if(var2 == 1) {
            this.mTxtTitle.setText(2131427786);
            this.mTxtRefillDays.setVisibility(8);
            this.mTxtRefillUnit.setText(2131427989);
         } else if(var2 == 0) {
            this.mTxtTitle.setText(2131427786);
            this.mTxtRefillDays.setVisibility(8);
            this.mTxtRefillUnit.setText(2131427987);
         } else if(var2 == -1) {
            this.mTxtTitle.setText(2131427788);
            this.mTxtRefillDays.setVisibility(8);
            this.mTxtRefillUnit.setText(2131428037);
         } else {
            this.mTxtTitle.setText(2131427788);
            this.mTxtRefillDays.setVisibility(0);
            this.mTxtRefillDays.setText(String.valueOf(-var2));
            this.mTxtRefillUnit.setText(2131427521);
         }

         if(var2 < 2) {
            this.mLayoutRefill.setVisibility(0);
         } else {
            this.mLayoutRefill.setVisibility(8);
         }

         int var3 = this.mRx.getReminder().getInterval();
         TextView var4 = this.mTxtRepeatDays;
         String var5 = this.getString(2131427588);
         Object[] var6 = new Object[1];
         Resources var7 = this.getResources();
         Object[] var8 = new Object[]{Integer.valueOf(var3)};
         var6[0] = var7.getQuantityString(2131361811, var3, var8);
         var4.setText(String.format(var5, var6));
         String var9 = this.mRx.getReminder().getFormatedNextDate("MMMM dd   hh:mm a");
         this.mTxtAlertTime.setText(var9);
         if(!var1) {
            int[] var10 = this.getBackgroundColorForReminder(var2);
            this.mRefillHeaderLayout.setBackgroundColor(var10[0]);
            this.mRefillDaysLayout.setBackgroundColor(var10[1]);
         } else {
            this.animateBackgroundColor(var2);
         }
      }
   }
}
