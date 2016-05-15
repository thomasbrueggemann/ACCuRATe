package com.goodrx.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import com.goodrx.model.BestPharmacy;
import com.goodrx.model.PharmacyLocationObject;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.utils.Utils;

public class BestPharmacyAddressFormater {
   public static void format(TextView var0, BestPharmacy var1) {
      Context var2 = var0.getContext();
      if(var1.getType().equals("nabp")) {
         var0.setText(2131427671);
         var0.setTypeface((Typeface)null, 2);
         var0.setTextColor(ContextCompat.getColor(var2, 2131755021));
      } else {
         var0.setText(getAddressText(var0.getContext(), var1));
         var0.setTextColor(ContextCompat.getColor(var2, 2131755084));
      }
   }

   public static String getAddressText(Context var0, BestPharmacy var1) {
      int var2 = var1.getPharmacy_info().length;
      if(var2 == 0) {
         return "";
      } else if(var2 > 1) {
         int var6 = MyRxUtils.getBestPharmacyDistance(var0);
         String var7 = var0.getString(2131428034);
         Object[] var8 = new Object[]{Integer.valueOf(var2), null};
         Resources var9 = var0.getResources();
         Object[] var10 = new Object[]{Integer.valueOf(var6)};
         var8[1] = var9.getQuantityString(2131361816, var6, var10);
         return String.format(var7, var8);
      } else {
         PharmacyLocationObject var3 = var1.getPharmacy_info()[0];
         StringBuilder var4 = new StringBuilder(var3.getAddress());
         var4.append(" (").append(Utils.formatDistance(var3.getDistance())).append(")");
         return var4.toString();
      }
   }
}
