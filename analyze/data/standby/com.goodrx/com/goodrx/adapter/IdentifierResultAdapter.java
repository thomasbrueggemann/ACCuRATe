package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.IdentifierResult;
import com.nostra13.universalimageloader.core.ImageLoader;

public class IdentifierResultAdapter extends MyBaseAdapter<IdentifierResult> {
   public IdentifierResultAdapter(Context var1) {
      super(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      IdentifierResultAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968724, var3, false);
         var4 = new IdentifierResultAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (IdentifierResultAdapter.ViewHolder)var2.getTag();
      }

      IdentifierResult var5 = ((IdentifierResult[])this.dataArray)[var1];
      ImageLoader.getInstance().displayImage(var5.getPills()[0].getImage(), var4.img);
      var4.txtTitle.setText(var5.getDrug_object().getDisplay());
      var4.txtSubTitle.setText(var5.getDrug_object().getDosage_form_display_short());
      var4.txtCount.setText(String.valueOf(var5.getPills().length));
      return var2;
   }

   static class ViewHolder {
      ImageView img;
      TextView txtCount;
      TextView txtSubTitle;
      TextView txtTitle;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
