package com.goodrx.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.ImageSelectorActivity;
import com.goodrx.widget.MyProgressBar;

public class ImageSelectorActivity$$ViewBinder<T extends ImageSelectorActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      var2.imagePager = (ViewPager)var1.castView((View)var1.findRequiredView(var3, 2131886288, "field \'imagePager\'"), 2131886288, "field \'imagePager\'");
      var2.txtTitle = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886287, "field \'txtTitle\'"), 2131886287, "field \'txtTitle\'");
      var2.txtName = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886289, "field \'txtName\'"), 2131886289, "field \'txtName\'");
      var2.txtDescription = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886290, "field \'txtDescription\'"), 2131886290, "field \'txtDescription\'");
      var2.txtCompany = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886291, "field \'txtCompany\'"), 2131886291, "field \'txtCompany\'");
      var2.txtEmpty = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886293, "field \'txtEmpty\'"), 2131886293, "field \'txtEmpty\'");
      var2.txtSave = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886281, "field \'txtSave\'"), 2131886281, "field \'txtSave\'");
      View var4 = (View)var1.findRequiredView(var3, 2131886292, "field \'layoutPhoto\' and method \'onButtonClicked\'");
      var2.layoutPhoto = var4;
      var4.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onButtonClicked(var1);
         }
      });
      View var5 = (View)var1.findRequiredView(var3, 2131886286, "field \'layoutSave\' and method \'onButtonClicked\'");
      var2.layoutSave = var5;
      var5.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onButtonClicked(var1);
         }
      });
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
      ((View)var1.findRequiredView(var3, 2131886285, "method \'onButtonClicked\'")).setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onButtonClicked(var1);
         }
      });
   }

   public void unbind(T var1) {
      var1.imagePager = null;
      var1.txtTitle = null;
      var1.txtName = null;
      var1.txtDescription = null;
      var1.txtCompany = null;
      var1.txtEmpty = null;
      var1.txtSave = null;
      var1.layoutPhoto = null;
      var1.layoutSave = null;
      var1.myProgressBar = null;
   }
}
