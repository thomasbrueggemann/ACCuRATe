package com.goodrx.widget.MyRx;

import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.goodrx.widget.DatePickerFragment;
import com.goodrx.widget.MyRx.RxEditOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RxEditDate extends RxEditOption implements OnDateSetListener, OnClickListener {
   private Calendar date;

   public RxEditDate(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setOnClickListener(this);
   }

   public void onClick(View var1) {
      DatePickerFragment var2;
      if(this.date == null) {
         var2 = DatePickerFragment.newInstance(Calendar.getInstance());
      } else {
         var2 = DatePickerFragment.newInstance(this.date);
      }

      var2.setOnDateSetListener(this);

      try {
         var2.show(((AppCompatActivity)var1.getContext()).getSupportFragmentManager(), "date_picker");
      } catch (Exception var4) {
         ;
      }
   }

   public void onDateSet(DatePicker var1, int var2, int var3, int var4) {
      if(this.date == null) {
         this.date = Calendar.getInstance();
      }

      this.date.set(var2, var3, var4);
      this.setText2(SimpleDateFormat.getDateInstance().format(this.date.getTime()));
   }
}
