package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.PriceListAdapter;

public class PriceListAdapter$PriceViewHolder$$ViewBinder<T extends PriceListAdapter.PriceViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtPharmacyName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886600, "field \'txtPharmacyName\'"), 2131886600, "field \'txtPharmacyName\'");
      var2.txtDistance = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886603, "field \'txtDistance\'"), 2131886603, "field \'txtDistance\'");
      var2.txtPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886605, "field \'txtPrice\'"), 2131886605, "field \'txtPrice\'");
      var2.txtType = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886606, "field \'txtType\'"), 2131886606, "field \'txtType\'");
      var2.txtNameHidden = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886604, "field \'txtNameHidden\'"), 2131886604, "field \'txtNameHidden\'");
      var2.imgLocation = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886602, "field \'imgLocation\'"), 2131886602, "field \'imgLocation\'");
      var2.layoutPrice = (View)var1.findRequiredView(var3, 2131886601, "field \'layoutPrice\'");
   }

   public void unbind(T var1) {
      var1.txtPharmacyName = null;
      var1.txtDistance = null;
      var1.txtPrice = null;
      var1.txtType = null;
      var1.txtNameHidden = null;
      var1.imgLocation = null;
      var1.layoutPrice = null;
   }
}
