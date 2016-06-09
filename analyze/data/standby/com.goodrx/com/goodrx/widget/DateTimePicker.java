package com.goodrx.widget;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.widget.DatePicker;
import android.widget.TimePicker;
import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

public abstract class DateTimePicker implements OnDateSetListener, OnTimeSetListener {
   private Context mContext;
   private MutableDateTime mDateTime;

   public DateTimePicker(Context var1, DateTime var2) {
      this.mDateTime = new MutableDateTime(var2);
      this.mContext = var1;
   }

   private int getDialogTheme() {
      return VERSION.SDK_INT >= 21?2131624139:0;
   }

   private void showTimePickerDialog() {
      TimePickerDialog var1 = new TimePickerDialog(this.mContext, this.getDialogTheme(), this, this.mDateTime.getHourOfDay(), this.mDateTime.getMinuteOfHour(), false);
      var1.setButton(-3, this.mContext.getString(2131427760), new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            DateTimePicker.this.showDatePickerDialog();
         }
      });
      var1.show();
   }

   public void onDateSet(DatePicker var1, int var2, int var3, int var4) {
      this.mDateTime.setDate(var2, var3 + 1, var4);
   }

   public abstract void onDateTimeChanged(DateTime var1);

   public void onTimeSet(TimePicker var1, int var2, int var3) {
      this.mDateTime.setTime(var2, var3, 0, 0);
      this.onDateTimeChanged(this.mDateTime.toDateTime());
   }

   public void show() {
      this.showDatePickerDialog();
   }

   public void showDatePickerDialog() {
      final DatePickerDialog var1 = new DatePickerDialog(this.mContext, this.getDialogTheme(), this, this.mDateTime.getYear(), -1 + this.mDateTime.getMonthOfYear(), this.mDateTime.getDayOfMonth());
      var1.setButton(-1, this.mContext.getString(2131427677), new OnClickListener() {
         public void onClick(DialogInterface var1x, int var2) {
            DatePicker var3 = var1.getDatePicker();
            DateTimePicker.this.onDateSet(var3, var3.getYear(), var3.getMonth(), var3.getDayOfMonth());
            DateTimePicker.this.showTimePickerDialog();
         }
      });
      var1.show();
   }
}
