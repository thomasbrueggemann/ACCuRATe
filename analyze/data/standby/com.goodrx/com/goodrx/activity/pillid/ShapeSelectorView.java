package com.goodrx.activity.pillid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import com.goodrx.adapter.ShapeSelectorAdapter;

public abstract class ShapeSelectorView extends FrameLayout {
   private int mSelectedIndex;

   public ShapeSelectorView(Context var1, int var2) {
      super(var1);
      this.mSelectedIndex = var2;
      this.init(var1);
   }

   private void init(Context var1) {
      ListView var2 = (ListView)LayoutInflater.from(var1).inflate(2130968642, this, true).findViewById(2131886350);
      var2.setAdapter(new ShapeSelectorAdapter(var1, this.mSelectedIndex));
      var2.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView<?> var1, View var2, int var3, long var4) {
            ShapeSelectorView.this.onShapeSelected(var3);
         }
      });
   }

   public abstract void onShapeSelected(int var1);
}
