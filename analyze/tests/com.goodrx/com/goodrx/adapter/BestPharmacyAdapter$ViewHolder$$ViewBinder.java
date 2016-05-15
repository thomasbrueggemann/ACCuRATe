package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.BestPharmacyAdapter;

public class BestPharmacyAdapter$ViewHolder$$ViewBinder<T extends BestPharmacyAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtNumber = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886541, "field \'txtNumber\'"), 2131886541, "field \'txtNumber\'");
      var2.txtName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886542, "field \'txtName\'"), 2131886542, "field \'txtName\'");
      var2.txtAddress = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886544, "field \'txtAddress\'"), 2131886544, "field \'txtAddress\'");
      var2.txtPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886543, "field \'txtPrice\'"), 2131886543, "field \'txtPrice\'");
   }

   public void unbind(T var1) {
      var1.txtNumber = null;
      var1.txtName = null;
      var1.txtAddress = null;
      var1.txtPrice = null;
   }
}
