package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.goodrx.model.MyRx;
import com.goodrx.widget.ReminderItem;
import java.util.ArrayList;

public class ReminderGroup extends FrameLayout {
   private Context context;
   private LinearLayout layoutReminders;
   private ReminderGroup.OnRefillButtonClickListener onRefillButtonClickListener;
   private OnClickListener onReminderItemClickListener;

   public ReminderGroup(Context var1) {
      super(var1);
      this.init(var1);
   }

   public void init(Context var1) {
      this.context = var1;
      this.layoutReminders = (LinearLayout)LayoutInflater.from(var1).inflate(2130968744, this, true).findViewById(2131886621);
   }

   public void setOnRefillButtonClickListener(ReminderGroup.OnRefillButtonClickListener var1) {
      this.onRefillButtonClickListener = var1;
   }

   public void setOnReminderItemClickListener(OnClickListener var1) {
      this.onReminderItemClickListener = var1;
   }

   public void setReminders(ArrayList<MyRx> var1) {
      if(var1.size() != 0) {
         int var2 = ((MyRx)var1.get(0)).getReminder().getDayLeft();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            final MyRx var4 = (MyRx)var1.get(var3);
            ReminderItem var5 = new ReminderItem(this.context);
            var5.updateUI(var4.getDrug().getImage(), var4.getDrug().getSelected_drug(), var4.getDrug().getAmount());
            var5.setInnerDividerEnabled(true);
            var5.setOutterDividerEnabled(false);
            var5.setTimeEnabled(false);
            var5.setOnClickListener(new OnClickListener() {
               public void onClick(View var1) {
                  if(ReminderGroup.this.onReminderItemClickListener != null) {
                     ReminderGroup.this.onReminderItemClickListener.onClick(var1);
                  }

               }
            });
            if(var2 < 1) {
               var5.setOnRefillButtonClickListener(new OnClickListener() {
                  public void onClick(View var1) {
                     ReminderGroup.this.onRefillButtonClickListener.onClick(var4);
                  }
               });
            }

            if(var3 == 0) {
               String[] var6 = var4.getReminder().getFormatedNextDate("MMM dd").split(" ");
               var5.setTime(var6[0], var6[1]);
               var5.setTimeEnabled(true);
            }

            if(var3 == -1 + var1.size()) {
               var5.setInnerDividerEnabled(false);
               var5.setOutterDividerEnabled(true);
            }

            var5.setTag(var4);
            this.layoutReminders.addView(var5);
         }
      }

   }

   public interface OnRefillButtonClickListener {
      void onClick(MyRx var1);
   }
}
