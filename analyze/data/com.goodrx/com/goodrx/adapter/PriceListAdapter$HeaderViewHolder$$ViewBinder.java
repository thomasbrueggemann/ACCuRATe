package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.PriceListAdapter;

public class PriceListAdapter$HeaderViewHolder$$ViewBinder<T extends PriceListAdapter.HeaderViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtDrugInfo = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886537, "field \'txtDrugInfo\'"), 2131886537, "field \'txtDrugInfo\'");
      var2.txtLocation = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886538, "field \'txtLocation\'"), 2131886538, "field \'txtLocation\'");
      var2.imgMap = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886536, "field \'imgMap\'"), 2131886536, "field \'imgMap\'");
      var2.headerLayout = (View)var1.findRequiredView(var3, 2131886324, "field \'headerLayout\'");
   }

   public void unbind(T var1) {
      var1.txtDrugInfo = null;
      var1.txtLocation = null;
      var1.imgMap = null;
      var1.headerLayout = null;
   }
}
