package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.PriceListAdapter;

public class PriceListAdapter$FooterViewHolder$$ViewBinder<T extends PriceListAdapter.FooterViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.viewMore = (View)var1.findRequiredView(var3, 2131886497, "field \'viewMore\'");
      var2.viewCant = (View)var1.findRequiredView(var3, 2131886498, "field \'viewCant\'");
      var2.viewAbout = (View)var1.findRequiredView(var3, 2131886502, "field \'viewAbout\'");
      var2.txtPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886501, "field \'txtPrice\'"), 2131886501, "field \'txtPrice\'");
   }

   public void unbind(T var1) {
      var1.viewMore = null;
      var1.viewCant = null;
      var1.viewAbout = null;
      var1.txtPrice = null;
   }
}
