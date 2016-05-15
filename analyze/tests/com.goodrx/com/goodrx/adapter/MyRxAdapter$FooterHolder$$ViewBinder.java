package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyRxAdapter;

public class MyRxAdapter$FooterHolder$$ViewBinder<T extends MyRxAdapter.FooterHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.viewButton = (View)var1.findRequiredView(var3, 2131886508, "field \'viewButton\'");
      var2.viewBestPharmacy = (View)var1.findRequiredView(var3, 2131886509, "field \'viewBestPharmacy\'");
      var2.txtPharmacyName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886513, "field \'txtPharmacyName\'"), 2131886513, "field \'txtPharmacyName\'");
      var2.txtSubTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886515, "field \'txtSubTitle\'"), 2131886515, "field \'txtSubTitle\'");
      var2.txtPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886514, "field \'txtPrice\'"), 2131886514, "field \'txtPrice\'");
   }

   public void unbind(T var1) {
      var1.viewButton = null;
      var1.viewBestPharmacy = null;
      var1.txtPharmacyName = null;
      var1.txtSubTitle = null;
      var1.txtPrice = null;
   }
}
