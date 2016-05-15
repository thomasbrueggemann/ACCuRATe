package com.goodrx.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import com.goodrx.utils.DialogHelper;

public abstract class LocationProviderSelector {
   private Context context;
   private Dialog dialog;

   public LocationProviderSelector(Context var1) {
      this.context = var1;
   }

   public abstract void onProviderSelected(View var1);

   public void show(boolean var1) {
      View var2 = View.inflate(this.context, 2130968671, (ViewGroup)null);
      View var3 = var2.findViewById(2131886423);
      View var4 = var2.findViewById(2131886426);
      View var5 = var2.findViewById(2131886430);
      LocationProviderSelector.OnProviderClickListener var6 = new LocationProviderSelector.OnProviderClickListener();
      var3.setOnClickListener(var6);
      var4.setOnClickListener(var6);
      var5.setOnClickListener(var6);
      if(var1) {
         var5.setVisibility(8);
      }

      this.dialog = DialogHelper.showDialog(DialogHelper.dialogWithCustomViewBuilder(this.context, 2131427890, var2));
   }

   private class OnProviderClickListener implements OnClickListener {
      private OnProviderClickListener() {
      }

      // $FF: synthetic method
      OnProviderClickListener(Object var2) {
         this();
      }

      public void onClick(View var1) {
         if(LocationProviderSelector.this.dialog.isShowing()) {
            LocationProviderSelector.this.dialog.dismiss();
         }

         LocationProviderSelector.this.onProviderSelected(var1);
      }
   }
}
