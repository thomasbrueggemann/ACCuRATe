package com.goodrx.activity.configure;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.configure.ConfigureFragment;
import com.goodrx.widget.MyProgressBar;
import com.goodrx.widget.ConfigureItem.ConfigureItem;
import com.goodrx.widget.ConfigureItem.DrugNameItem;

public class ConfigureFragment$$ViewBinder<T extends ConfigureFragment> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      View var4 = (View)var1.findRequiredView(var3, 2131886445, "field \'itemDrugName\' and method \'onClick\'");
      var2.itemDrugName = (DrugNameItem)var1.castView(var4, 2131886445, "field \'itemDrugName\'");
      var4.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var5 = (View)var1.findRequiredView(var3, 2131886446, "field \'itemForm\' and method \'onClick\'");
      var2.itemForm = (ConfigureItem)var1.castView(var5, 2131886446, "field \'itemForm\'");
      var5.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      var2.formDivider = (View)var1.findRequiredView(var3, 2131886447, "field \'formDivider\'");
      View var6 = (View)var1.findRequiredView(var3, 2131886448, "field \'itemDosage\' and method \'onClick\'");
      var2.itemDosage = (ConfigureItem)var1.castView(var6, 2131886448, "field \'itemDosage\'");
      var6.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var7 = (View)var1.findRequiredView(var3, 2131886449, "field \'itemQuantity\' and method \'onClick\'");
      var2.itemQuantity = (ConfigureItem)var1.castView(var7, 2131886449, "field \'itemQuantity\'");
      var7.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var8 = (View)var1.findRequiredView(var3, 2131886450, "field \'itemLocation\' and method \'onClick\'");
      var2.itemLocation = (ConfigureItem)var1.castView(var8, 2131886450, "field \'itemLocation\'");
      var8.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
         }
      });
      View var9 = (View)var1.findRequiredView(var3, 2131886451, "field \'btnPrice\', method \'onClick\', and method \'onPriceButtonClicked\'");
      var2.btnPrice = (Button)var1.castView(var9, 2131886451, "field \'btnPrice\'");
      var9.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onClick(var1);
            var2.onPriceButtonClicked();
         }
      });
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
   }

   public void unbind(T var1) {
      var1.itemDrugName = null;
      var1.itemForm = null;
      var1.formDivider = null;
      var1.itemDosage = null;
      var1.itemQuantity = null;
      var1.itemLocation = null;
      var1.btnPrice = null;
      var1.myProgressBar = null;
   }
}
