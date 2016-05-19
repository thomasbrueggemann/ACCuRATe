package com.goodrx.activity;

import android.view.View;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.internal.DebouncingOnClickListener;
import com.goodrx.activity.RxEditActivity;
import com.goodrx.widget.MyRx.RxEditImage;
import com.goodrx.widget.MyRx.RxEditOption;

public class RxEditActivity$$ViewBinder<T extends RxEditActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, final T var2, Object var3) {
      View var4 = (View)var1.findRequiredView(var3, 2131886336, "field \'drugOption\' and method \'onRxEditClicked\'");
      var2.drugOption = (RxEditOption)var1.castView(var4, 2131886336, "field \'drugOption\'");
      var4.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      View var5 = (View)var1.findRequiredView(var3, 2131886337, "field \'formOption\' and method \'onRxEditClicked\'");
      var2.formOption = (RxEditOption)var1.castView(var5, 2131886337, "field \'formOption\'");
      var5.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      View var6 = (View)var1.findRequiredView(var3, 2131886338, "field \'dosageOption\' and method \'onRxEditClicked\'");
      var2.dosageOption = (RxEditOption)var1.castView(var6, 2131886338, "field \'dosageOption\'");
      var6.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      View var7 = (View)var1.findRequiredView(var3, 2131886339, "field \'quantityOption\' and method \'onRxEditClicked\'");
      var2.quantityOption = (RxEditOption)var1.castView(var7, 2131886339, "field \'quantityOption\'");
      var7.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      View var8 = (View)var1.findRequiredView(var3, 2131886340, "field \'imageOption\' and method \'onRxEditClicked\'");
      var2.imageOption = (RxEditImage)var1.castView(var8, 2131886340, "field \'imageOption\'");
      var8.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      View var9 = (View)var1.findRequiredView(var3, 2131886341, "field \'pharmacyOption\' and method \'onRxEditClicked\'");
      var2.pharmacyOption = (RxEditOption)var1.castView(var9, 2131886341, "field \'pharmacyOption\'");
      var9.setOnClickListener(new DebouncingOnClickListener() {
         public void doClick(View var1) {
            var2.onRxEditClicked(var1);
         }
      });
      var2.btnAdd = (Button)var1.castView((View)var1.findRequiredView(var3, 2131886343, "field \'btnAdd\'"), 2131886343, "field \'btnAdd\'");
      var2.layoutDelete = (View)var1.findRequiredView(var3, 2131886342, "field \'layoutDelete\'");
   }

   public void unbind(T var1) {
      var1.drugOption = null;
      var1.formOption = null;
      var1.dosageOption = null;
      var1.quantityOption = null;
      var1.imageOption = null;
      var1.pharmacyOption = null;
      var1.btnAdd = null;
      var1.layoutDelete = null;
   }
}
