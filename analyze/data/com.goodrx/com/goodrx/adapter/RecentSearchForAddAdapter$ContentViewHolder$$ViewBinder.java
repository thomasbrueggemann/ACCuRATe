package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.RecentSearchForAddAdapter;

public class RecentSearchForAddAdapter$ContentViewHolder$$ViewBinder<T extends RecentSearchForAddAdapter.ContentViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886567, "field \'txtName\'"), 2131886567, "field \'txtName\'");
   }

   public void unbind(T var1) {
      var1.txtName = null;
   }
}
