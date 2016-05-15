package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.goodrx.adapter.MyRxAdapter;

public class MyRxAdapter$ContentViewHolder$$ViewBinder<T extends MyRxAdapter.ContentViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.imageView = (SimpleDraweeView)var1.castView((View)var1.findRequiredView(var3, 2131886585, "field \'imageView\'"), 2131886585, "field \'imageView\'");
      var2.txtDrugName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886587, "field \'txtDrugName\'"), 2131886587, "field \'txtDrugName\'");
      var2.txtAmount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886588, "field \'txtAmount\'"), 2131886588, "field \'txtAmount\'");
      var2.txtPharmacy = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886589, "field \'txtPharmacy\'"), 2131886589, "field \'txtPharmacy\'");
      var2.txtSaving = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886590, "field \'txtSaving\'"), 2131886590, "field \'txtSaving\'");
      var2.txtAsLowAs = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886591, "field \'txtAsLowAs\'"), 2131886591, "field \'txtAsLowAs\'");
      var2.txtPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886592, "field \'txtPrice\'"), 2131886592, "field \'txtPrice\'");
      var2.container = (View)var1.findRequiredView(var3, 2131886584, "field \'container\'");
   }

   public void unbind(T var1) {
      var1.imageView = null;
      var1.txtDrugName = null;
      var1.txtAmount = null;
      var1.txtPharmacy = null;
      var1.txtSaving = null;
      var1.txtAsLowAs = null;
      var1.txtPrice = null;
      var1.container = null;
   }
}
