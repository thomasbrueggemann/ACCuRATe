package com.goodrx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.goodrx.class_3;

public class SettingItemWithSwitch extends FrameLayout {
   // $FF: renamed from: sc android.support.v7.widget.SwitchCompat
   private SwitchCompat field_533;
   // $FF: renamed from: tv android.widget.TextView
   private TextView field_534;

   public SettingItemWithSwitch(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
      this.setAttrs(var1, var2);
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968805, this, true);
      this.field_533 = (SwitchCompat)var2.findViewById(2131886778);
      this.field_534 = (TextView)var2.findViewById(2131886777);
   }

   public void setAttrs(Context var1, AttributeSet var2) {
      TypedArray var3 = var1.obtainStyledAttributes(var2, class_3.styleable.SettingItemWithSwitch);
      String var4 = var3.getString(0);
      if(var4 != null) {
         this.field_534.setText(var4);
      }

      var3.recycle();
   }

   public void setChecked(boolean var1) {
      this.field_533.setChecked(var1);
   }

   public void setOnCheckedChangeListener(OnCheckedChangeListener var1) {
      this.field_533.setOnCheckedChangeListener(var1);
   }
}
