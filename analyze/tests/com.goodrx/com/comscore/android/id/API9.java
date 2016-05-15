package com.comscore.android.id;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
public class API9 {
   public static String getAndroidSerial() {
      return Integer.valueOf(VERSION.SDK_INT).intValue() >= 9?Build.SERIAL:null;
   }
}
