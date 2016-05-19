package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.InfoAdapter;

public class InfoAdapter$InfoViewHolder$$ViewBinder<T extends InfoAdapter.InfoViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886582, "field \'txtTitle\'"), 2131886582, "field \'txtTitle\'");
   }

   public void unbind(T var1) {
      var1.txtTitle = null;
   }
}
