package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.NoticeListAdapter;

public class NoticeListAdapter$NoticeViewHolder$$ViewBinder<T extends NoticeListAdapter.NoticeViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886593, "field \'txtTitle\'"), 2131886593, "field \'txtTitle\'");
      var2.txtSubtitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886595, "field \'txtSubtitle\'"), 2131886595, "field \'txtSubtitle\'");
   }

   public void unbind(T var1) {
      var1.txtTitle = null;
      var1.txtSubtitle = null;
   }
}
