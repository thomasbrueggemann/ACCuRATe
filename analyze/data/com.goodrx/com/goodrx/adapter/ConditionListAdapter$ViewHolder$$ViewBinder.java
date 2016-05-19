package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.ConditionListAdapter;

public class ConditionListAdapter$ViewHolder$$ViewBinder<T extends ConditionListAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886557, "field \'txtName\'"), 2131886557, "field \'txtName\'");
      var2.txtCount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886558, "field \'txtCount\'"), 2131886558, "field \'txtCount\'");
      var2.txtSectorTitle = (TextView)var1.castView((View)var1.findOptionalView(var3, 2131886561, (String)null), 2131886561, "field \'txtSectorTitle\'");
   }

   public void unbind(T var1) {
      var1.txtName = null;
      var1.txtCount = null;
      var1.txtSectorTitle = null;
   }
}
