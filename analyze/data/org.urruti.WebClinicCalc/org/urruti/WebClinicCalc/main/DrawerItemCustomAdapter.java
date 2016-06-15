package org.urruti.WebClinicCalc.main;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.urruti.WebClinicCalc.main.ObjectDrawerItem;

public class DrawerItemCustomAdapter extends ArrayAdapter<ObjectDrawerItem> {
   ObjectDrawerItem[] data = null;
   int layoutResourceId;
   Context mContext;

   public DrawerItemCustomAdapter(Context var1, int var2, ObjectDrawerItem[] var3) {
      super(var1, var2, var3);
      this.layoutResourceId = var2;
      this.mContext = var1;
      this.data = var3;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      View var4 = ((Activity)this.mContext).getLayoutInflater().inflate(this.layoutResourceId, var3, false);
      ImageView var5 = (ImageView)var4.findViewById(2131296683);
      TextView var6 = (TextView)var4.findViewById(2131296684);
      ObjectDrawerItem var7 = this.data[var1];
      var5.setImageResource(var7.icon);
      var6.setText(var7.name);
      return var4;
   }
}
