package com.comscore.utils;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;

public class API13 {
   public static Point getDisplaySize(Display var0) {
      Point var1 = new Point();
      if(VERSION.SDK_INT >= 13) {
         var0.getSize(var1);
      }

      return var1;
   }
}
