package com.goodrx.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.goodrx.model.Color;
import java.util.ArrayList;

public class ColorSelectorAdapter extends BaseAdapter {
   private static ArrayList<Color> colors;
   private Context context;
   private int selectedIndex;

   public ColorSelectorAdapter(Context var1, int var2) {
      this.context = var1;
      this.selectedIndex = var2;
   }

   public static ArrayList<Color> getColors() {
      if(colors == null) {
         colors = new ArrayList(13);
         colors.add(new Color("", 0));
         colors.add(new Color("Red", -769226));
         colors.add(new Color("Pink", -1499549));
         colors.add(new Color("Orange", -26624));
         colors.add(new Color("Yellow", -16121));
         colors.add(new Color("Green", -11751600));
         colors.add(new Color("Blue", -14575885));
         colors.add(new Color("Purple", -6543440));
         colors.add(new Color("Brown", -8825528));
         colors.add(new Color("Black", -16777216));
         colors.add(new Color("Gray", -5526613));
         colors.add(new Color("White", -1));
         colors.add(new Color("Colorless", 16777215));
      }

      return colors;
   }

   public int getCount() {
      return getColors().size();
   }

   public Object getItem(int var1) {
      return getColors().get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ColorSelectorAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2130968725, var3, false);
         var4 = new ColorSelectorAdapter.ViewHolder(var2);
         var2.setTag(var4);
      } else {
         var4 = (ColorSelectorAdapter.ViewHolder)var2.getTag();
      }

      if(var1 == 0) {
         var4.textview.setText(2131427428);
         var4.imageView.setBackgroundResource(2130837748);
      } else {
         if(var1 >= -2 + this.getCount() && var1 < this.getCount()) {
            var4.imageView.setBackgroundResource(2130837596);
         } else {
            var4.imageView.setBackgroundResource(2130837595);
         }

         var4.textview.setText(((Color)getColors().get(var1)).getName());
         ((GradientDrawable)var4.imageView.getBackground()).setColor(((Color)getColors().get(var1)).getRgb());
      }

      if(var1 == this.selectedIndex) {
         var4.imgChecked.setVisibility(0);
         return var2;
      } else {
         var4.imgChecked.setVisibility(8);
         return var2;
      }
   }

   static class ViewHolder {
      ImageView imageView;
      ImageView imgChecked;
      TextView textview;

      public ViewHolder(View var1) {
         ButterKnife.bind(this, var1);
      }
   }
}
