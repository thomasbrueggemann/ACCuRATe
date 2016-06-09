package com.goodrx.widget.MyRx;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;

public class RxEditImage extends FrameLayout {
   private String imageUrl;
   private SimpleDraweeView imageView;
   private TextView textView;

   public RxEditImage(Context var1) {
      super(var1);
      this.init(var1);
   }

   public RxEditImage(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init(var1);
   }

   public RxEditImage(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init(var1);
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public ImageView getImageView() {
      return this.imageView;
   }

   public void init(Context var1) {
      View var2 = LayoutInflater.from(var1).inflate(2130968789, this, true);
      this.textView = (TextView)var2.findViewById(2131886714);
      this.imageView = (SimpleDraweeView)var2.findViewById(2131886715);
      this.setEnabled(true);
   }

   public void setEnabled(boolean var1) {
      if(var1) {
         this.textView.setTextColor(ContextCompat.getColor(this.getContext(), 17170444));
         this.setClickable(true);
      } else {
         this.textView.setTextColor(ContextCompat.getColor(this.getContext(), 2131755079));
         this.setClickable(false);
      }
   }

   public void setImageUrl(String var1) {
      this.imageUrl = var1;
      this.imageView.setImageURI(Uri.parse(var1));
   }
}
