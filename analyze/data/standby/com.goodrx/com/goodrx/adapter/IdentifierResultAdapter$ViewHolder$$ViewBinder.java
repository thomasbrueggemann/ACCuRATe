package com.goodrx.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.IdentifierResultAdapter;

public class IdentifierResultAdapter$ViewHolder$$ViewBinder<T extends IdentifierResultAdapter.ViewHolder> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.img = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886568, "field \'img\'"), 2131886568, "field \'img\'");
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886570, "field \'txtTitle\'"), 2131886570, "field \'txtTitle\'");
      var2.txtSubTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886571, "field \'txtSubTitle\'"), 2131886571, "field \'txtSubTitle\'");
      var2.txtCount = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886569, "field \'txtCount\'"), 2131886569, "field \'txtCount\'");
   }

   public void unbind(T var1) {
      var1.img = null;
      var1.txtTitle = null;
      var1.txtSubTitle = null;
      var1.txtCount = null;
   }
}
