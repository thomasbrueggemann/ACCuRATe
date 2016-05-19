package com.goodrx.widget;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import com.google.gson.Gson;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Calendar;

@Instrumented
public class DatePickerFragment extends DialogFragment implements OnDateSetListener, TraceFieldInterface {
   private OnDateSetListener listener;

   public static DatePickerFragment newInstance(Calendar var0) {
      DatePickerFragment var1 = new DatePickerFragment();
      Bundle var2 = new Bundle();
      Gson var3 = new Gson();
      String var4;
      if(!(var3 instanceof Gson)) {
         var4 = var3.toJson((Object)var0);
      } else {
         var4 = GsonInstrumentation.toJson((Gson)var3, (Object)var0);
      }

      var2.putString("init_date", var4);
      var1.setArguments(var2);
      return var1;
   }

   @NonNull
   public Dialog onCreateDialog(Bundle var1) {
      Gson var2 = new Gson();
      String var3 = this.getArguments().getString("init_date");
      Object var4;
      if(!(var2 instanceof Gson)) {
         var4 = var2.fromJson(var3, Calendar.class);
      } else {
         var4 = GsonInstrumentation.fromJson((Gson)var2, var3, Calendar.class);
      }

      Calendar var5 = (Calendar)var4;
      int var6 = var5.get(1);
      int var7 = var5.get(2);
      int var8 = var5.get(5);
      return new DatePickerDialog(this.getActivity(), this, var6, var7, var8);
   }

   public void onDateSet(DatePicker var1, int var2, int var3, int var4) {
      if(this.listener != null) {
         this.listener.onDateSet(var1, var2, var3, var4);
      }

   }

   protected void onStart() {
      super.onStart();
      ApplicationStateMonitor.getInstance().activityStarted();
   }

   protected void onStop() {
      super.onStop();
      ApplicationStateMonitor.getInstance().activityStopped();
   }

   public void setOnDateSetListener(OnDateSetListener var1) {
      this.listener = var1;
   }
}
