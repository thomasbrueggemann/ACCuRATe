package com.goodrx.widget.MyRx;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.goodrx.model.MyRx;

public class BestPharmacyDrugNameView extends FrameLayout implements OnClickListener {
   private AppCompatCheckBox checkBox;
   // $FF: renamed from: rx com.goodrx.model.MyRx
   private MyRx field_535;

   public BestPharmacyDrugNameView(Context var1, MyRx var2) {
      super(var1);
      this.field_535 = var2;
      this.init(var1);
   }

   public AppCompatCheckBox getCheckBox() {
      return this.checkBox;
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968773, this, true);
      ((TextView)var2.findViewById(2131886673)).setText(this.field_535.getDrug().getSelected_drug());
      ((SimpleDraweeView)var2.findViewById(2131886672)).setImageURI(Uri.parse(this.field_535.getDrug().getImage()));
      this.checkBox = (AppCompatCheckBox)var2.findViewById(2131886211);
      this.setOnClickListener(this);
   }

   public boolean isChecked() {
      return this.checkBox.isChecked();
   }

   public void onClick(View var1) {
      AppCompatCheckBox var2 = this.checkBox;
      boolean var3;
      if(!this.checkBox.isChecked()) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2.setChecked(var3);
   }

   public void setChecked(boolean var1) {
      this.checkBox.setChecked(var1);
   }

   public void setTag(Object var1) {
      super.setTag(var1);
      this.checkBox.setTag(var1);
   }
}
