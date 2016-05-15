package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.model.ImageResult;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.parceler.Parcels;

public class ImageDetailActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0, ImageResult var1) {
      Intent var2 = new Intent(var0, ImageDetailActivity.class);
      var2.putExtra("image_result", Parcels.wrap(var1));
      var0.startActivity(var2);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427838);
      this.setContentView(2130968617);
      ImageResult var2 = (ImageResult)Parcels.unwrap(this.getIntent().getParcelableExtra("image_result"));
      TextView var3 = (TextView)this.findViewById(2131886283);
      TextView var4 = (TextView)this.findViewById(2131886284);
      ImageView var5 = (ImageView)this.findViewById(2131886282);
      var3.setText(var2.getProduct_name_long());
      String var6 = this.getResources().getString(2131427619);
      Object[] var7 = new Object[]{var2.getDescription(), var2.getCompany_name()};
      var4.setText(String.format(var6, var7));
      ImageLoader.getInstance().displayImage(var2.getImage(), var5);
   }
}
