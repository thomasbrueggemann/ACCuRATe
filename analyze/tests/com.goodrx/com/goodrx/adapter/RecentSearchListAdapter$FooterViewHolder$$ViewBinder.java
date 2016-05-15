package com.goodrx.adapter;

import android.view.View;
import butterknife.ButterKnife;
import com.goodrx.adapter.RecentSearchListAdapter;

public class RecentSearchListAdapter$FooterViewHolder$$ViewBinder<T extends RecentSearchListAdapter.FooterViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.btnPopularDrug = (View)var1.findRequiredView(var3, 2131886504, "field \'btnPopularDrug\'");
      var2.btnCondition = (View)var1.findRequiredView(var3, 2131886505, "field \'btnCondition\'");
      var2.btnPillId = (View)var1.findRequiredView(var3, 2131886506, "field \'btnPillId\'");
   }

   public void unbind(T var1) {
      var1.btnPopularDrug = null;
      var1.btnCondition = null;
      var1.btnPillId = null;
   }
}
