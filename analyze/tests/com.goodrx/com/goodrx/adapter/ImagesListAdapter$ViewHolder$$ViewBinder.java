package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.ImagesListAdapter;

public class ImagesListAdapter$ViewHolder$$ViewBinder<T extends ImagesListAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886576, "field \'txtTitle\'"), 2131886576, "field \'txtTitle\'");
      var2.txtSubtitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886577, "field \'txtSubtitle\'"), 2131886577, "field \'txtSubtitle\'");
      var2.imgDrug = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886575, "field \'imgDrug\'"), 2131886575, "field \'imgDrug\'");
   }

   public void unbind(T var1) {
      var1.txtTitle = null;
      var1.txtSubtitle = null;
      var1.imgDrug = null;
   }
}
