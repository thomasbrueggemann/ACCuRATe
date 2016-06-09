package com.goodrx.activity;

import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.activity.BestPharmacySettingActivity;
import com.goodrx.widget.MyProgressBar;

public class BestPharmacySettingActivity$$ViewBinder<T extends BestPharmacySettingActivity> implements ButterKnife.ViewBinder<T> {
   public void bind(ButterKnife.Finder var1, T var2, Object var3) {
      var2.txtLocation = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886252, "field \'txtLocation\'"), 2131886252, "field \'txtLocation\'");
      var2.sbRadius = (AppCompatSeekBar)var1.castView((View)var1.findRequiredView(var3, 2131886254, "field \'sbRadius\'"), 2131886254, "field \'sbRadius\'");
      var2.txtRadius = (TextView)var1.castView((View)var1.findRequiredView(var3, 2131886253, "field \'txtRadius\'"), 2131886253, "field \'txtRadius\'");
      var2.drugsLayout = (LinearLayout)var1.castView((View)var1.findRequiredView(var3, 2131886255, "field \'drugsLayout\'"), 2131886255, "field \'drugsLayout\'");
      var2.myProgressBar = (MyProgressBar)var1.castView((View)var1.findRequiredView(var3, 2131886399, "field \'myProgressBar\'"), 2131886399, "field \'myProgressBar\'");
   }

   public void unbind(T var1) {
      var1.txtLocation = null;
      var1.sbRadius = null;
      var1.txtRadius = null;
      var1.drugsLayout = null;
      var1.myProgressBar = null;
   }
}
