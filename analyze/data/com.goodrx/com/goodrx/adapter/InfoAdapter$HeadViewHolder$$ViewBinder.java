package com.goodrx.adapter;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.InfoAdapter;

public class InfoAdapter$HeadViewHolder$$ViewBinder<T extends InfoAdapter.HeadViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.viewNews = (View)var1.findRequiredView(var3, 2131886525, "field \'viewNews\'");
      var2.viewImage = (View)var1.findRequiredView(var3, 2131886529, "field \'viewImage\'");
      var2.txtNewsCount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886527, "field \'txtNewsCount\'"), 2131886527, "field \'txtNewsCount\'");
      var2.txtImageCount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886531, "field \'txtImageCount\'"), 2131886531, "field \'txtImageCount\'");
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886533, "field \'txtTitle\'"), 2131886533, "field \'txtTitle\'");
   }

   public void unbind(T var1) {
      var1.viewNews = null;
      var1.viewImage = null;
      var1.txtNewsCount = null;
      var1.txtImageCount = null;
      var1.txtTitle = null;
   }
}
