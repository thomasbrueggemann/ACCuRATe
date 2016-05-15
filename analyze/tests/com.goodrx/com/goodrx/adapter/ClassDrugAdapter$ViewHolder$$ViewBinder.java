package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.ClassDrugAdapter;
import com.goodrx.widget.VolBar;

public class ClassDrugAdapter$ViewHolder$$ViewBinder<T extends ClassDrugAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.volBar = (VolBar)var1.castView((View)var1.findRequiredView(var3, 2131886554, "field \'volBar\'"), 2131886554, "field \'volBar\'");
      var2.txtDrugName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886555, "field \'txtDrugName\'"), 2131886555, "field \'txtDrugName\'");
      var2.txtDrugPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886556, "field \'txtDrugPrice\'"), 2131886556, "field \'txtDrugPrice\'");
   }

   public void unbind(T var1) {
      var1.volBar = null;
      var1.txtDrugName = null;
      var1.txtDrugPrice = null;
   }
}
