package com.goodrx.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.adapter.MyBaseAdapter;
import com.goodrx.model.ImageResult;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.apache.commons.lang3.ArrayUtils;

public class ImagesListAdapter extends MyBaseAdapter<ImageResult> {
   public ImagesListAdapter(Context var1) {
      super(var1);
   }

   public void append(ImageResult[] var1) {
      this.dataArray = ArrayUtils.addAll((Object[])this.dataArray, (Object[])var1);
      this.notifyDataSetChanged();
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ImagesListAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = this.inflater.inflate(2130968726, var3, false);
         var4 = new ImagesListAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (ImagesListAdapter.ViewHolder)var2.getTag();
      }

      ImageResult var5 = ((ImageResult[])this.dataArray)[var1];
      var4.txtTitle.setText(var5.getProduct_name_long());
      var4.txtSubtitle.setText(var5.getDescription());
      ImageLoader.getInstance().displayImage(var5.getImage(), var4.imgDrug);
      return var2;
   }

   static class ViewHolder {
      ImageView imgDrug;
      TextView txtSubtitle;
      TextView txtTitle;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
