package com.comscore.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;

public class API9 {
   @SuppressLint({"NewApi"})
   public static String getSerial() {
      return VERSION.SDK_INT >= 9?Build.SERIAL:"";
   }
}
