package com.goodrx.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.utils.CircularMarkerIcon;
import com.goodrx.utils.MarkerIcon;

public class MarkerIconFactory {
   public static MarkerIcon create(Context var0, MarkerIconFactory.MarkerIconType var1) {
      switch(null.$SwitchMap$com$goodrx$utils$MarkerIconFactory$MarkerIconType[var1.ordinal()]) {
      case 1:
         return new CircularMarkerIcon(View.inflate(var0, 2130968782, (ViewGroup)null), var0.getResources().getDimensionPixelSize(2131558579));
      case 2:
         return new MarkerIcon(View.inflate(var0, 2130968781, (ViewGroup)null));
      default:
         return new CircularMarkerIcon(View.inflate(var0, 2130968780, (ViewGroup)null), var0.getResources().getDimensionPixelSize(2131558526));
      }
   }

   public static enum MarkerIconType {
      CURRENT_LOCATION,
      PHARMACY,
      PHARMACY_DETAIL;

      static {
         MarkerIconFactory.MarkerIconType[] var0 = new MarkerIconFactory.MarkerIconType[]{CURRENT_LOCATION, PHARMACY_DETAIL, PHARMACY};
      }
   }
}
