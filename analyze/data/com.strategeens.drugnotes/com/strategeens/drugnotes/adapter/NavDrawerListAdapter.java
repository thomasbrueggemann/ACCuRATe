package com.strategeens.drugnotes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.strategeens.drugnotes.model.NavDrawerItem;
import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter {
   private Context context;
   private ArrayList<NavDrawerItem> navDrawerItems;

   public NavDrawerListAdapter(Context var1, ArrayList<NavDrawerItem> var2) {
      this.context = var1;
      this.navDrawerItems = var2;
   }

   public int getCount() {
      return this.navDrawerItems.size();
   }

   public Object getItem(int var1) {
      return this.navDrawerItems.get(var1);
   }

   public long getItemId(int var1) {
      return (long)var1;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      if(var2 == null) {
         var2 = ((LayoutInflater)this.context.getSystemService("layout_inflater")).inflate(2130903043, (ViewGroup)null);
      }

      ImageView var4 = (ImageView)var2.findViewById(2131558433);
      TextView var5 = (TextView)var2.findViewById(2131558434);
      TextView var6 = (TextView)var2.findViewById(2131558435);
      var4.setImageResource(((NavDrawerItem)this.navDrawerItems.get(var1)).getIcon());
      var5.setText(((NavDrawerItem)this.navDrawerItems.get(var1)).getTitle());
      if(((NavDrawerItem)this.navDrawerItems.get(var1)).getCounterVisibility()) {
         var6.setText(((NavDrawerItem)this.navDrawerItems.get(var1)).getCount());
         return var2;
      } else {
         var6.setVisibility(8);
         return var2;
      }
   }
}
