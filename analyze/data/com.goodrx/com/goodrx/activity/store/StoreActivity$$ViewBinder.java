package com.goodrx.activity.store;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.store.StoreActivity;
import com.goodrx.widget.MyProgressBar;

public class StoreActivity$$ViewBinder<T extends StoreActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtDrugInfo = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886359, "field \'txtDrugInfo\'"), 2131886359, "field \'txtDrugInfo\'");
      var2.bestPriceFrame = (FrameLayout)var1.castView((View)var1.findRequiredView(var3, 2131886360, "field \'bestPriceFrame\'"), 2131886360, "field \'bestPriceFrame\'");
      var2.txtShowAdditionalPrice = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886364, "field \'txtShowAdditionalPrice\'"), 2131886364, "field \'txtShowAdditionalPrice\'");
      var2.additionalPriceContainer = (LinearLayout)var1.castView((View)var1.findRequiredView(var3, 2131886361, "field \'additionalPriceContainer\'"), 2131886361, "field \'additionalPriceContainer\'");
      var2.additionalPriceLayout = (LinearLayout)var1.castView((View)var1.findRequiredView(var3, 2131886362, "field \'additionalPriceLayout\'"), 2131886362, "field \'additionalPriceLayout\'");
      var2.locationLayout = (LinearLayout)var1.castView((View)var1.findRequiredView(var3, 2131886366, "field \'locationLayout\'"), 2131886366, "field \'locationLayout\'");
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
      var2.scrollView = (NestedScrollView)var1.castView((View)var1.findRequiredView(var3, 2131886356, "field \'scrollView\'"), 2131886356, "field \'scrollView\'");
      var2.priceCard = (CardView)var1.castView((View)var1.findRequiredView(var3, 2131886358, "field \'priceCard\'"), 2131886358, "field \'priceCard\'");
      var2.locationCard = (CardView)var1.castView((View)var1.findRequiredView(var3, 2131886365, "field \'locationCard\'"), 2131886365, "field \'locationCard\'");
      var2.imgTransparent = (ImageView)var1.castView((View)var1.findRequiredView(var3, 2131886368, "field \'imgTransparent\'"), 2131886368, "field \'imgTransparent\'");
   }

   public void unbind(T var1) {
      var1.txtDrugInfo = null;
      var1.bestPriceFrame = null;
      var1.txtShowAdditionalPrice = null;
      var1.additionalPriceContainer = null;
      var1.additionalPriceLayout = null;
      var1.locationLayout = null;
      var1.myProgressBar = null;
      var1.scrollView = null;
      var1.priceCard = null;
      var1.locationCard = null;
      var1.imgTransparent = null;
   }
}
