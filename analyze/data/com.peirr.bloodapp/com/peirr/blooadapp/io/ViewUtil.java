package com.peirr.blooadapp.io;

import android.content.Context;
import android.view.View;
import android.widget.Switch;
import com.peirr.blooadapp.io.Cache;

public class ViewUtil {
   public static void changeBackGround(Context var0, View var1, Switch var2, String var3) {
      if(var3 != null) {
         Cache var4 = Cache.getInstance();
         boolean var5;
         if(!var3.equalsIgnoreCase("0")) {
            var5 = true;
         } else {
            var5 = false;
         }

         var4.setFemale(var5);
         if(Cache.getInstance().isFemale()) {
            var1.setBackgroundColor(var0.getResources().getColor(2131099648));
         } else {
            var1.setBackgroundColor(var0.getResources().getColor(2131099649));
         }

         if(var2 != null) {
            var2.setChecked(var3.equalsIgnoreCase("0"));
         }

      } else if(Cache.getInstance().isFemale()) {
         var1.setBackgroundColor(var0.getResources().getColor(2131099648));
      } else {
         var1.setBackgroundColor(var0.getResources().getColor(2131099649));
      }
   }
}
