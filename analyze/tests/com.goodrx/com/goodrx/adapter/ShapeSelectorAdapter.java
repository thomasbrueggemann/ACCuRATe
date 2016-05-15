package com.goodrx.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.goodrx.model.Shape;
import java.util.ArrayList;

public class ShapeSelectorAdapter extends BaseAdapter {
   private static ArrayList<Shape> shapes;
   private Context context;
   private int selectedIndex;

   public ShapeSelectorAdapter(Context var1, int var2) {
      this.context = var1;
      this.selectedIndex = var2;
   }

   public static ArrayList<Shape> getShapes() {
      if(shapes == null) {
         shapes = new ArrayList(24);
         shapes.add(new Shape("", 2130837795));
         shapes.add(new Shape("Apple", 2130837796));
         shapes.add(new Shape("Bow-Tie", 2130837797));
         shapes.add(new Shape("Bullet", 2130837798));
         shapes.add(new Shape("Capsule", 2130837799));
         shapes.add(new Shape("Diamond", 2130837800));
         shapes.add(new Shape("Double Circle", 2130837801));
         shapes.add(new Shape("D-Shaped", 2130837800));
         shapes.add(new Shape("Heart", 2130837803));
         shapes.add(new Shape("Hexagon", 2130837804));
         shapes.add(new Shape("Kidney", 2130837805));
         shapes.add(new Shape("Modified Rectangle", 2130837806));
         shapes.add(new Shape("Oblong", 2130837807));
         shapes.add(new Shape("Octagon", 2130837808));
         shapes.add(new Shape("Oval", 2130837810));
         shapes.add(new Shape("Pentagon", 2130837811));
         shapes.add(new Shape("Rectangular", 2130837812));
         shapes.add(new Shape("Round", 2130837813));
         shapes.add(new Shape("Shield", 2130837814));
         shapes.add(new Shape("Square", 2130837815));
         shapes.add(new Shape("Trapezoid", 2130837817));
         shapes.add(new Shape("Triangle", 2130837818));
         shapes.add(new Shape("Tear", 2130837816));
         shapes.add(new Shape("Other", 2130837809));
      }

      return shapes;
   }

   public int getCount() {
      return getShapes().size();
   }

   public Object getItem(int var1) {
      return getShapes().get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ShapeSelectorAdapter.ViewHolder var4;
      if(var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2130968725, var3, false);
         var4 = new ShapeSelectorAdapter.ViewHolder();
         var4.textView = (TextView)var2.findViewById(2131886573);
         var4.imageView = (ImageView)var2.findViewById(2131886572);
         var4.imgChecked = (ImageView)var2.findViewById(2131886574);
         var2.setTag(var4);
      } else {
         var4 = (ShapeSelectorAdapter.ViewHolder)var2.getTag();
      }

      Shape var5 = (Shape)getShapes().get(var1);
      if(var1 == 0) {
         var4.textView.setText(2131427429);
      } else {
         var4.textView.setText(var5.getName());
      }

      var4.imageView.setImageResource(var5.getImageSrc());
      if(this.selectedIndex == var1) {
         var4.imgChecked.setVisibility(0);
         return var2;
      } else {
         var4.imgChecked.setVisibility(8);
         return var2;
      }
   }

   private static class ViewHolder {
      ImageView imageView;
      ImageView imgChecked;
      TextView textView;

      private ViewHolder() {
      }

      // $FF: synthetic method
      ViewHolder(Object var1) {
         this();
      }
   }
}
