package com.goodrx.activity.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.main.WelcomeSearchFragment;

public class WelcomeSearchFragment$$ViewBinder<T extends WelcomeSearchFragment> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.imgTitle = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886493, "field \'imgTitle\'"), 2131886493, "field \'imgTitle\'");
      var2.txtSubtitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886397, "field \'txtSubtitle\'"), 2131886397, "field \'txtSubtitle\'");
      View var4 = (View)var1.findRequiredView(var3, 2131886494, "field \'viewSearchbox\' and method \'onSearchViewClicked\'");
      var2.viewSearchbox = var4;
      var4.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onSearchViewClicked();
         }
      });
   }

   public void unbind(T var1) {
      var1.imgTitle = null;
      var1.txtSubtitle = null;
      var1.viewSearchbox = null;
   }
}
