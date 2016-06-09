package com.goodrx.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.adapter.DialogOptionAdapter;

public class MultipleButtonDialogView extends FrameLayout {
   ListView lvOptions;

   public MultipleButtonDialogView(Context var1, String var2, String var3, String[] var4) {
      super(var1);
      FrameLayout var5 = (FrameLayout)LayoutInflater.from(var1).inflate(2130968799, this, true);
      ((TextView)var5.findViewById(2131886412)).setText(var2);
      ((TextView)var5.findViewById(2131886752)).setText(var3);
      DialogOptionAdapter var6 = new DialogOptionAdapter(var1, var4);
      this.lvOptions = (ListView)var5.findViewById(2131886753);
      this.lvOptions.setAdapter(var6);
   }

   public void setOnItemClickListener(OnItemClickListener var1) {
      this.lvOptions.setOnItemClickListener(var1);
   }
}
