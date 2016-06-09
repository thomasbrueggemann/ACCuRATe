package com.goodrx.receiver;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.activity.price.RxPriceActivity;
import com.goodrx.activity.store.StoreActivity;
import com.goodrx.model.MyRx;
import com.goodrx.utils.DBManager;
import com.goodrx.utils.MyRxUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.parse.ParsePushBroadcastReceiver;

public class ParseReceiver extends ParsePushBroadcastReceiver {
   protected Class<? extends Activity> getActivity(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("com.parse.Data");
      if(var3 != null && var3.length() != 0) {
         JsonObject var4 = (new JsonParser()).parse(var3).getAsJsonObject();
         if(!var4.has("type")) {
            return super.getActivity(var1, var2);
         } else {
            (new DBManager(var1)).clearAllCache();
            String var5 = var4.getAsJsonPrimitive("type").getAsString();
            if(var5.equals("price_alert")) {
               JsonArray var9 = var4.getAsJsonArray("drug_ids");
               if(var9.size() == 1) {
                  var2.putExtra("create_back_stack", true);
                  if(var4.has("coupon_changed") && var4.getAsJsonPrimitive("coupon_changed").getAsBoolean() && var4.has("pharmacy_id") && var4.getAsJsonPrimitive("pharmacy_id").getAsString().length() > 0) {
                     return StoreActivity.class;
                  } else {
                     var2.putExtra("drug_id", var9.get(0).getAsString());
                     return RxPriceActivity.class;
                  }
               } else {
                  return MainActivity.class;
               }
            } else if(!var5.equals("savings_alert") && !var5.equals("news_alert")) {
               return MainActivity.class;
            } else {
               JsonArray var6 = var4.getAsJsonArray("drug_ids");
               if(var6.size() == 1) {
                  var2.putExtra("create_back_stack", true);
                  var2.putExtra("drug_id", var6.get(0).getAsString());
                  return RxPriceActivity.class;
               } else {
                  return MainActivity.class;
               }
            }
         }
      } else {
         return super.getActivity(var1, var2);
      }
   }

   protected Bitmap getLargeIcon(Context var1, Intent var2) {
      String var3 = var2.getStringExtra("com.parse.Data");
      if(var3 == null) {
         return super.getLargeIcon(var1, var2);
      } else {
         JsonObject var4 = (new JsonParser()).parse(var3).getAsJsonObject();
         if(!var4.has("drug_ids")) {
            return super.getLargeIcon(var1, var2);
         } else {
            JsonArray var5 = var4.getAsJsonArray("drug_ids");
            if(var5.size() > 1) {
               return super.getLargeIcon(var1, var2);
            } else {
               MyRx var6 = MyRxUtils.findRxByDrugId(var1, var5.get(0).getAsString());
               return var6 != null && var6.getDrug().getImage() != null?ImageLoader.getInstance().loadImageSync(var6.getDrug().getImage()):super.getLargeIcon(var1, var2);
            }
         }
      }
   }

   protected Notification getNotification(Context var1, Intent var2) {
      Notification var3 = super.getNotification(var1, var2);
      if(VERSION.SDK_INT >= 21) {
         var3.color = ContextCompat.getColor(var1, 2131755163);
      }

      return var3;
   }

   protected int getSmallIconId(Context var1, Intent var2) {
      return VERSION.SDK_INT >= 21?2130903040:super.getSmallIconId(var1, var2);
   }
}
