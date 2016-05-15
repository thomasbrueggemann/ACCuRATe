package com.goodrx.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.goodrx.model.EventBusMessage;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.io.File;
import org.greenrobot.eventbus.EventBus;

public class PhotoReviewAdapter extends RecyclerView.Adapter<PhotoReviewAdapter.MyViewHolder> {
   private File[] files;
   private boolean[] selected;

   public PhotoReviewAdapter(File[] var1) {
      this.files = var1;
      this.selected = new boolean[var1.length];

      for(int var2 = 0; var2 < this.selected.length; ++var2) {
         this.selected[var2] = true;
      }

   }

   public int getItemCount() {
      return this.files.length;
   }

   public void onBindViewHolder(PhotoReviewAdapter.MyViewHolder var1, int var2) {
      String var3 = "file://" + this.files[var2].getAbsolutePath();
      ImageLoader.getInstance().displayImage(var3, var1.imageView);
      if(this.selected[var2]) {
         var1.borderView.setVisibility(0);
      } else {
         var1.borderView.setVisibility(8);
      }
   }

   public PhotoReviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      return new PhotoReviewAdapter.MyViewHolder(LayoutInflater.from(var1.getContext()).inflate(2130968734, var1, false));
   }

   public boolean selected(int var1) {
      return this.selected[var1];
   }

   public class MyViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
      private FrameLayout borderView;
      private ImageView imageView;

      public MyViewHolder(View var2) {
         super(var2);
         this.imageView = (ImageView)var2.findViewById(2131886596);
         this.borderView = (FrameLayout)var2.findViewById(2131886597);
         var2.setOnClickListener(this);
      }

      public void onClick(View var1) {
         int var2 = 0;
         int var3 = this.getAdapterPosition();
         boolean[] var4 = PhotoReviewAdapter.this.selected;
         boolean var5;
         if(!PhotoReviewAdapter.this.selected[var3]) {
            var5 = true;
         } else {
            var5 = false;
         }

         var4[var3] = var5;
         PhotoReviewAdapter.this.notifyItemChanged(var3);
         int var6 = 0;
         boolean[] var7 = PhotoReviewAdapter.this.selected;

         for(int var8 = var7.length; var2 < var8; ++var2) {
            if(var7[var2]) {
               ++var6;
            }
         }

         EventBus.getDefault().post(new EventBusMessage(PhotoReviewAdapter.class.getName() + "/selected_counter", Integer.valueOf(var6)));
      }
   }
}
