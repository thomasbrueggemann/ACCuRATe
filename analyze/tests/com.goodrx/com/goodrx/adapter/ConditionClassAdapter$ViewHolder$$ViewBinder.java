package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.ConditionClassAdapter;

public class ConditionClassAdapter$ViewHolder$$ViewBinder<T extends ConditionClassAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886562, "field \'txtName\'"), 2131886562, "field \'txtName\'");
      var2.txtCount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886563, "field \'txtCount\'"), 2131886563, "field \'txtCount\'");
   }

   public void unbind(T var1) {
      var1.txtName = null;
      var1.txtCount = null;
   }
}
