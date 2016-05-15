package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.ColorSelectorAdapter;

public class ColorSelectorAdapter$ViewHolder$$ViewBinder<T extends ColorSelectorAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.textview = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886573, "field \'textview\'"), 2131886573, "field \'textview\'");
      var2.imageView = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886572, "field \'imageView\'"), 2131886572, "field \'imageView\'");
      var2.imgChecked = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886574, "field \'imgChecked\'"), 2131886574, "field \'imgChecked\'");
   }

   public void unbind(T var1) {
      var1.textview = null;
      var1.imageView = null;
      var1.imgChecked = null;
   }
}
