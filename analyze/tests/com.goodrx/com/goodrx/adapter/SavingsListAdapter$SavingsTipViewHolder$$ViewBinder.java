package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.SavingsListAdapter;

public class SavingsListAdapter$SavingsTipViewHolder$$ViewBinder<T extends SavingsListAdapter.SavingsTipViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886623, "field \'txtTitle\'"), 2131886623, "field \'txtTitle\'");
      var2.txtDescription = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886624, "field \'txtDescription\'"), 2131886624, "field \'txtDescription\'");
      var2.imgLogo = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886622, "field \'imgLogo\'"), 2131886622, "field \'imgLogo\'");
   }

   public void unbind(T var1) {
      var1.txtTitle = null;
      var1.txtDescription = null;
      var1.imgLogo = null;
   }
}
