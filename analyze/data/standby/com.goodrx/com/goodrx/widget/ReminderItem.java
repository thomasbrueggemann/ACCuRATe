package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ReminderItem extends FrameLayout {
   private Button btnRefill;
   private ImageView imageView;
   private View innerDivider;
   private View layoutTime;
   private View outterDivider;
   private TextView txtAmount;
   private TextView txtDate;
   private TextView txtMonth;
   private TextView txtName;

   public ReminderItem(Context var1) {
      super(var1);
      this.init(var1);
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968743, this, true);
      this.layoutTime = var2.findViewById(2131886610);
      this.txtMonth = (TextView)var2.findViewById(2131886611);
      this.txtDate = (TextView)var2.findViewById(2131886612);
      this.imageView = (ImageView)var2.findViewById(2131886613);
      this.txtName = (TextView)var2.findViewById(2131886616);
      this.txtAmount = (TextView)var2.findViewById(2131886617);
      this.btnRefill = (Button)var2.findViewById(2131886618);
      this.btnRefill.setVisibility(8);
      this.outterDivider = var2.findViewById(2131886620);
      this.innerDivider = var2.findViewById(2131886619);
   }

   public void setInnerDividerEnabled(boolean var1) {
      if(var1) {
         this.innerDivider.setVisibility(0);
      } else {
         this.innerDivider.setVisibility(8);
      }
   }

   public void setOnRefillButtonClickListener(OnClickListener var1) {
      if(var1 == null) {
         this.btnRefill.setVisibility(8);
      } else {
         this.btnRefill.setVisibility(0);
         this.btnRefill.setOnClickListener(var1);
      }
   }

   public void setOutterDividerEnabled(boolean var1) {
      if(var1) {
         this.outterDivider.setVisibility(0);
      } else {
         this.outterDivider.setVisibility(8);
      }
   }

   public void setTime(String var1, String var2) {
      this.txtMonth.setText(var1);
      this.txtDate.setText(var2);
   }

   public void setTimeEnabled(boolean var1) {
      if(var1) {
         this.layoutTime.setVisibility(0);
      } else {
         this.layoutTime.setVisibility(4);
      }
   }

   public void updateUI(String var1, String var2, String var3) {
      ImageLoader.getInstance().displayImage(var1, this.imageView);
      this.txtName.setText(var2);
      this.txtAmount.setText(var3);
   }
}
